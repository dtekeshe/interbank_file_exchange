package com.bsva.dcms.commons.util;

import com.bsva.dcms.commons.dao.CSFTransactionTypesDAO;
import com.bsva.dcms.commons.dao.CSOPaymentInstructionsVisaDAO;
import com.bsva.dcms.commons.dao.CsfCardFeeSarbBillingDAO;
import com.bsva.dcms.commons.dao.CsfCardRateLookupDAO;
import com.bsva.dcms.commons.dao.CsfCompanyParametersDAO;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.bsva.dcms.commons.dao.CsfDeliveryServicesDAO;
import com.bsva.dcms.commons.dao.CsoFleetBillingDAO;
import com.bsva.dcms.commons.dao.CsoFleetBindResolvedDAO;
import com.bsva.dcms.commons.dao.CsoInputFileControlsDAO;
import com.bsva.dcms.commons.dao.CsoPaymentInstructionsMcardDAO;
import com.bsva.dcms.commons.dao.CsoServiceParametersDAO;
import com.bsva.dcms.commons.dao.CsoTransactionsDAO;
import com.bsva.dcms.commons.dao.CsvSarbBillingViewDAO;
import com.bsva.dcms.commons.dto.CSFTransactionTypesDTO;
import com.bsva.dcms.commons.dto.CSOPaymentInstructionsVisaDTO;
import com.bsva.dcms.commons.dto.CSOTransactionDTO;
import com.bsva.dcms.commons.dto.CsfCardRateLookupDTO;
import com.bsva.dcms.commons.dto.CsfCompanyParametersDTO;
import com.bsva.dcms.commons.dto.CsfDeliveryServicesDTO;
import com.bsva.dcms.commons.dto.CsoFleetBillingDTO;
import com.bsva.dcms.commons.dto.CsoInputFileControlsDTO;
import com.bsva.dcms.commons.dto.CsoPaymentInstructionsMcardDTO;
import com.bsva.dcms.commons.dto.CsoServiceParametersDTO;
import com.bsva.dcms.commons.dto.CsoSystemParametersDTO;
import com.bsva.dcms.commons.dto.CssCcr002StatsDTO;
import com.bsva.dcms.commons.dto.CsvSarbBillingViewDTO;
import com.bsva.dcms.commons.dto.views.temp.CsvCcr002ViewDto;
import com.bsva.dcms.commons.dto.views.CsvTransactionsViewDto;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.dcms.commons.views.temp.CsvCcr002View;
import com.bsva.dcms.commons.views.CsvTransactionsView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DMCSCalcBilling {

    private DataSource connection;
    private Logger log = Logger.getLogger(DMCSCalcBilling.class);
    private static String logPGM = "BILLING";
    private static final String PROCESSNAME = "DMCSCalcBilling"
;
    private CsfCardFeeSarbBillingDAO cardFeeSarbBillingDAO = new CsfCardFeeSarbBillingDAO();
    private CsfCardRateLookupDAO cardRateLookupViewDAO = new CsfCardRateLookupDAO();
    private CSFTransactionTypesDAO transactionTypeDAO = new CSFTransactionTypesDAO();
    public CsoFleetBillingDAO csoFleetBillingDAO = new CsoFleetBillingDAO();
    private CsvSarbBillingViewDAO csvSarbBillingViewDAO = new CsvSarbBillingViewDAO();
    private CSOPaymentInstructionsVisaDAO cSOPaymentInstructionsVisaDAO = new CSOPaymentInstructionsVisaDAO();
    private CsoPaymentInstructionsMcardDAO csoPaymentInstructionsMcardDAO = new CsoPaymentInstructionsMcardDAO();
    private CsoFleetBindResolvedDAO bindResolvedDAO = new CsoFleetBindResolvedDAO();
    private CsoTransactionsDAO transactionsDAO = new CsoTransactionsDAO();

    //BILLING MAP
    private Map<String, CsoFleetBillingDTO> billingMap = new HashMap<>();
    private List<CsoFleetBillingDTO> cfbdtoList = new ArrayList<>();
    private List<Map<String, CsoFleetBillingDTO>> myList = new ArrayList<>();

    public boolean calculate(String fileRefNumber) throws DAOException {

        //lOOKUP VAT
        CsfCompanyParametersDAO companyParametersDAO = new CsfCompanyParametersDAO();
        CsfCompanyParametersDTO companyParametersDTO = new CsfCompanyParametersDTO();
        companyParametersDTO.setCurrencyCode("ZAR");
        companyParametersDTO.setValidationCode("ACBJ");
        CsfCompanyParametersDTO parametersDTO = companyParametersDAO.retrieve(companyParametersDTO);

        log.info("Calculate billing figures for " + fileRefNumber.substring(0, 8));

        try {

            CsoInputFileControlsDTO csoInputFileControlsDTO = new CsoInputFileControlsDTO();
            csoInputFileControlsDTO.setFileRefNumber(fileRefNumber);
            CsoInputFileControlsDAO csoInputFileControlsDao = new CsoInputFileControlsDAO();
            CsoInputFileControlsDTO csoInputFileControlsDto = csoInputFileControlsDao.retrieve(csoInputFileControlsDTO);
            if (csoInputFileControlsDto == null) {
                log.debug("File " + fileRefNumber + " not found. Billing stopped");
                return Boolean.FALSE;
            }

            if ("FLEET".equals(csoInputFileControlsDto.getSubService())) {
                FleetBilling fleetBiling = new FleetBilling(csoInputFileControlsDto.getSubService());
                fleetBiling.doFleetBilling(fileRefNumber);
                fleetBiling.doCsoTransactionUpdateForFleet(csoInputFileControlsDto);
            } else {

                //update billing values for each transaction
                CsvTransactionsView csvTransactionView = new CsvTransactionsView();
                List<CsvTransactionsViewDto> csvTransactionsViewDtoList = csvTransactionView.execute(csoInputFileControlsDto);

                for (CsvTransactionsViewDto csvTransactionViewDto : csvTransactionsViewDtoList) {

                    long transactionSystemSequenceNumber = csvTransactionViewDto.getTransactionSystemSeqNumber();

                    // locate SARB Billing rates for Transaction Code 5 & 6
                    if ((csvTransactionViewDto.getTransactionCode() == 5) || (csvTransactionViewDto.getTransactionCode() == 6)) {

                        if ("MASTERCARD".equals(csoInputFileControlsDto.getSubService())) {
                            CsoPaymentInstructionsMcardDTO csoPaymentInstructionsMcardDTO = new CsoPaymentInstructionsMcardDTO();
                            csoPaymentInstructionsMcardDTO.setSystemSeqNumber2(transactionSystemSequenceNumber);
                            CsoPaymentInstructionsMcardDTO instructionsMcardDTO = csoPaymentInstructionsMcardDAO.retrieve(csoPaymentInstructionsMcardDTO);
                            if(instructionsMcardDTO != null){
                            String p22DataElement = instructionsMcardDTO.getP22PointOfSaleData();
                            Integer p40DataElement = instructionsMcardDTO.getP40ServiceCode();
                            String p48DataElement = instructionsMcardDTO.getP48AdditionalData();

                            String subField1 = p22DataElement.substring(0, 1);
                            String subField6 = p22DataElement.substring(5, 6);
                            String subField7 = p22DataElement.substring(6, 7);
                            String eComm = p48DataElement.substring(2, 3);

                            // TODO Chip Card Value from input file has 3 Characters  - Lookup Field has 1 value
                            String chipCard = String.valueOf(p40DataElement);
                            String chopedChipCard = chipCard.substring(0, 1);

                            // Use Data Element 22/40/48 to build Rate Lookup Data
                            CsfCardRateLookupDTO cardRateLookupDTO = new CsfCardRateLookupDTO();

                            cardRateLookupDTO.setTerminalCapability(subField1);
                            cardRateLookupDTO.setCardPresent(subField6);
                            cardRateLookupDTO.setPosEntryMode(subField7);
                            cardRateLookupDTO.setChipCard(chopedChipCard);
                            cardRateLookupDTO.seteCommInd(eComm);
                            cardRateLookupDTO.setService("CARD");
                            cardRateLookupDTO.setSubService("MASTERCARD");

                            CsfCardRateLookupDTO lookupViewDTO = new CsfCardRateLookupDTO();

                            lookupViewDTO = cardRateLookupViewDAO.retrieve(cardRateLookupDTO);
                            String rateDesc = null;
                            if(lookupViewDTO != null){
	                            try {
	                                rateDesc = lookupViewDTO.getRateDescriptor();
	                            } catch (NullPointerException nlp) {
	                                // OBJECT NOT FOUND
	                            }
                            }

                            // Retrieve the view object we use for Billing
                            CsvSarbBillingViewDTO csvSarbBillingViewDTO = new CsvSarbBillingViewDTO();
                            if (rateDesc == null) {
                                csvSarbBillingViewDTO.setRateDescriptor("CNP BR");
                            } else {
                                csvSarbBillingViewDTO.setRateDescriptor(lookupViewDTO.getRateDescriptor());
                            }
                            csvSarbBillingViewDTO.setCardType(csvTransactionViewDto.getCardType());
                            CsvSarbBillingViewDTO billingViewDTO = csvSarbBillingViewDAO.retrieve(csvSarbBillingViewDTO);

                            // UPDATE PAYMENT INSTRUCTIONS TABLE WITH cardRateLookupViewDTO
                            updateMasterCardPaymentInstructions(instructionsMcardDTO, cardRateLookupDTO, billingViewDTO);
                            // LOOKUP THE TRANSACTION TYPE
                            CSFTransactionTypesDTO transactionTypeDTO = new CSFTransactionTypesDTO();
                            transactionTypeDTO.setTransactionCode((short) csvTransactionViewDto.getTransactionCode());
                            CSFTransactionTypesDTO transactionTypesDTO = transactionTypeDAO.retrieve(transactionTypeDTO);

                            double billper = 0.0;
                            double billfee = 0.0;
                            double transactionTax = 0.0;
                            float vatPerc = parametersDTO.getVatPercent() / 100f;

                            if (csvTransactionViewDto.getCashbackPresent().equals("Y")) {
                                billper = billingViewDTO.getBillingPercent() * transactionTypesDTO.getFeeDirection();
                                billfee = new BigDecimal(((csvTransactionViewDto.getCashbackAmount() + billingViewDTO.getBillingRate()) / 100)).setScale(5, RoundingMode.FLOOR).longValue();
                                transactionTax = new BigDecimal(((billingViewDTO.getBillingPercent() + billingViewDTO.getBillingRate()) * vatPerc) * transactionTypesDTO.getVatDirection()).abs().setScale(5, RoundingMode.FLOOR).doubleValue();
                                // UPDATE BILLING DATA ON PAYMENT INSTRUCTIONS
                                instructionsMcardDTO.setCashbackIcFee(billfee);
                                instructionsMcardDTO.setCashbackIcPerc(billper);
                                instructionsMcardDTO.setCashbackIcVat(transactionTax);
                                csoPaymentInstructionsMcardDAO.update(instructionsMcardDTO);
                            } else {
                                // UPDATE BILLING DATA ON PAYMENT INSTRUCTIONS
                                billper = billingViewDTO.getBillingPercent() * transactionTypesDTO.getFeeDirection();
                                billfee = new BigDecimal(((csvTransactionViewDto.getTransactionAmount() * billper) / 100)).setScale(5, RoundingMode.FLOOR).longValue();
                                transactionTax = new BigDecimal(((billingViewDTO.getBillingPercent() + billingViewDTO.getBillingRate()) * vatPerc) * transactionTypesDTO.getVatDirection()).abs().setScale(5, RoundingMode.FLOOR).doubleValue();
                                // UPDATE BILLING DATA ON PAYMENT INSTRUCTIONS
                                instructionsMcardDTO.setInterchangeFee(billfee);
                                instructionsMcardDTO.setInterchangePerc(billper);
                                instructionsMcardDTO.setInterchangeVat(transactionTax);
                                csoPaymentInstructionsMcardDAO.update(instructionsMcardDTO);
                            }

                            // Perform Billing for CSO_transactions
                            CSOTransactionDTO csoTransaction = new CSOTransactionDTO();
                            CSOTransactionDTO csoTransactiodto = new CSOTransactionDTO();
                            csoTransactiodto.setSystemSeqNumber(transactionSystemSequenceNumber); // update this transaction

                            CsoTransactionsDAO csoTransactionsDao = new CsoTransactionsDAO();
                            CSOTransactionDTO cSOTransactionDTO = csoTransactionsDao.retrieve(csoTransactiodto);

                            if (cSOTransactionDTO != null) {
                                updateBillingForCSOTransactions(cSOTransactionDTO, csvTransactionViewDto, csoTransactionsDao, billper, billfee, transactionTax, transactionSystemSequenceNumber);
                            }
                         }
                        }else if ("VISA CARD".equals(csoInputFileControlsDto.getSubService())) {

                            // Retrieve visa payment_instruction 
                            CSOPaymentInstructionsVisaDTO cSOPaymentInstructionsVisaDTO = new CSOPaymentInstructionsVisaDTO();
                            cSOPaymentInstructionsVisaDTO.setSystemGenSeqNumber((int) transactionSystemSequenceNumber);
                            CSOPaymentInstructionsVisaDTO instructionsVisaDTO = cSOPaymentInstructionsVisaDAO.retrieve(cSOPaymentInstructionsVisaDTO);
                            if(instructionsVisaDTO != null){
                            String chipCard = instructionsVisaDTO.getChipCard();
                            String eCommInd = instructionsVisaDTO.getEcommInd();
                            String posTermCapability = instructionsVisaDTO.getTerminalCapability();
                            String posEntryMode = instructionsVisaDTO.getPosEntryMode();
                            String cardPresent = instructionsVisaDTO.getCardPresent();

                            // Use Data Element 22/40/48 to build Rate Lookup Data
                            CsfCardRateLookupDTO cardRateLookupDTO = new CsfCardRateLookupDTO();

                            cardRateLookupDTO.setTerminalCapability(posTermCapability);
                            cardRateLookupDTO.setCardPresent(cardPresent);
                            cardRateLookupDTO.setPosEntryMode(posEntryMode);
                            cardRateLookupDTO.setChipCard(chipCard);
                            cardRateLookupDTO.seteCommInd(eCommInd);
                            cardRateLookupDTO.setService("CARD");
                            cardRateLookupDTO.setSubService("VISA CARD");

                            CsfCardRateLookupDTO lookupViewDTO = cardRateLookupViewDAO.retrieve(cardRateLookupDTO);
                            String rateDesc = null;
                            if(lookupViewDTO != null){
	                            try {
	                                if (lookupViewDTO != null) {
	                                    rateDesc = lookupViewDTO.getRateDescriptor();
	                                }
	                            } catch (NullPointerException nlp) {
	                                // OBJECT NOT FOUND
	                                nlp.getMessage();
	                            }
                            }

                            // Retrieve the view object we use for Billing
                            CsvSarbBillingViewDTO csvSarbBillingViewDTO = new CsvSarbBillingViewDTO();
                            if (rateDesc == null) {
                                csvSarbBillingViewDTO.setRateDescriptor("CNP BR");
                            } else {
                                csvSarbBillingViewDTO.setRateDescriptor(lookupViewDTO.getRateDescriptor());
                            }
                            csvSarbBillingViewDTO.setCardType(csvTransactionViewDto.getCardType());
                            CsvSarbBillingViewDTO billingViewDTO = csvSarbBillingViewDAO.retrieve(csvSarbBillingViewDTO);
                            
                            if(billingViewDTO != null){
                            // UPDATE PAYMENT INSTRUCTIONS TABLE WITH cardRateLookupViewDTO
                            updateVisaPaymentInstructions(instructionsVisaDTO, cardRateLookupDTO, lookupViewDTO);

                            // LOOKUP THE TRANSACTION TYPE
                            CSFTransactionTypesDTO transactionTypeDTO = new CSFTransactionTypesDTO();
                            transactionTypeDTO.setTransactionCode((short) csvTransactionViewDto.getTransactionCode());
                            CSFTransactionTypesDTO transactionTypesDTO = transactionTypeDAO.retrieve(transactionTypeDTO);
                            if(transactionTypesDTO != null){
                            double billper = 0.0;
                            double billfee = 0.0;
                            double transactionTax = 0.0;
                            float vatPerc = parametersDTO.getVatPercent() / 100f;

                            if (billingViewDTO != null) {
                                if (csvTransactionViewDto.getCashbackPresent().equals("Y")) {
                                    billper = billingViewDTO.getBillingPercent() * transactionTypesDTO.getFeeDirection();
                                    billfee = new BigDecimal(((csvTransactionViewDto.getCashbackAmount() + billingViewDTO.getBillingRate()) / 100)).setScale(5, RoundingMode.FLOOR).longValue();
                                    transactionTax = new BigDecimal(((billingViewDTO.getBillingPercent() + billingViewDTO.getBillingRate()) * vatPerc) * transactionTypesDTO.getVatDirection()).abs().setScale(5, RoundingMode.FLOOR).doubleValue();
                                    // UPDATE BILLING DATA ON PAYMENT INSTRUCTIONS
                                    instructionsVisaDTO.setCashbackIcFee(billfee);
                                    instructionsVisaDTO.setCashbackIcPerc(billper);
                                    instructionsVisaDTO.setCashbackIcVat(transactionTax);
                                    cSOPaymentInstructionsVisaDAO.update(instructionsVisaDTO);
                                } else {
                                    // UPDATE BILLING DATA ON PAYMENT INSTRUCTIONS
                                    billper = billingViewDTO.getBillingPercent() * transactionTypesDTO.getFeeDirection();
                                    billfee = new BigDecimal(((csvTransactionViewDto.getTransactionAmount() * billper) / 100)).setScale(5, RoundingMode.FLOOR).longValue();
                                    transactionTax = new BigDecimal(((billingViewDTO.getBillingPercent() + billingViewDTO.getBillingRate()) * vatPerc) * transactionTypesDTO.getVatDirection()).abs().setScale(5, RoundingMode.FLOOR).doubleValue();
                                    // UPDATE BILLING DATA ON PAYMENT INSTRUCTIONS
                                    instructionsVisaDTO.setInterchangeFee(billfee);
                                    instructionsVisaDTO.setInterchangePerc(billper);
                                    instructionsVisaDTO.setInterchasngeVat(transactionTax);
                                    cSOPaymentInstructionsVisaDAO.update(instructionsVisaDTO);
                                }
                              }
                            
                            // Perform Billing for CSO_transactions
                            CsoTransactionsDAO csoTransactionsDao = new CsoTransactionsDAO();
                            //CSOTransactionDTO csoTransaction = new CSOTransactionDTO();
                            CSOTransactionDTO csoTransactiodto = new CSOTransactionDTO();
                            csoTransactiodto.setSystemSeqNumber(transactionSystemSequenceNumber); // update this transaction                           
                            CSOTransactionDTO cSOTransactionDTO = csoTransactionsDao.retrieve(csoTransactiodto);

                            if (cSOTransactionDTO != null) {
                                updateBillingForCSOTransactions(cSOTransactionDTO, csvTransactionViewDto, csoTransactionsDao, billper, billfee, transactionTax, transactionSystemSequenceNumber);
                            }
                            }
                          }
                        } 
                        }else {

                            double transactionBill = new BigDecimal(csvTransactionViewDto.getTransactionAmount() * (csvTransactionViewDto.getInterchangeFee() / 100)).setScale(5, RoundingMode.FLOOR).doubleValue();
                            double transactionBillAmount = new BigDecimal(csvTransactionViewDto.getInterchangeFeeAmount()).setScale(5, RoundingMode.FLOOR).doubleValue();
                            double transactionVat = new BigDecimal(((csvTransactionViewDto.getTransactionAmount() * (csvTransactionViewDto.getInterchangeFee() / 100)) + csvTransactionViewDto.getInterchangeFeeAmount()) * csvTransactionViewDto.getInputVat() / 100).abs().setScale(5, RoundingMode.FLOOR).doubleValue();

                            CSOTransactionDTO csoTransaction = new CSOTransactionDTO();
                            CSOTransactionDTO csoTransactiodto = new CSOTransactionDTO();
                            csoTransactiodto.setSystemSeqNumber(transactionSystemSequenceNumber); // update this transaction

                           
                            double cashBackBill = 0;
                            double cashBackBillAmount = 0;
                            double cashbackVat = 0;
                            if (csvTransactionViewDto.getCashbackPresent().equals("Y")) {
                                cashBackBill = new BigDecimal(csvTransactionViewDto.getCashbackAmount() * (csvTransactionViewDto.getCashbackInterchangeFee() / 100)).setScale(5).doubleValue();
                                cashBackBillAmount = csvTransactionViewDto.getCashbackInterchangeFeeAmount();
                                cashbackVat = new BigDecimal(((csvTransactionViewDto.getCashbackAmount() * (csvTransactionViewDto.getCashbackInterchangeFee() / 100)) + csvTransactionViewDto.getCashbackInterchangeFeeAmount()) * csvTransactionViewDto.getCashbackInputVat() / 100).abs().setScale(5, RoundingMode.FLOOR).doubleValue();
                            }
                            
                            CsoTransactionsDAO csoTransactionsDao = new CsoTransactionsDAO();
                            CSOTransactionDTO cSOTransactionDTO = csoTransactionsDao.retrieve(csoTransactiodto);

                            if (cSOTransactionDTO != null) {

                                csoTransaction.setFleetCountTran(cSOTransactionDTO.getFleetCountTran());
                                csoTransaction.setProcessStatus(cSOTransactionDTO.getProcessStatus());
                                csoTransaction.setTransactionAmount(cSOTransactionDTO.getTransactionAmount());
                                csoTransaction.setCashbackPresent(cSOTransactionDTO.getCashbackPresent());
                                csoTransaction.setCashbackAmount(cSOTransactionDTO.getCashbackAmount());
                                csoTransaction.setCardType(cSOTransactionDTO.getCardType());
                                csoTransaction.setFileRecordCnt(cSOTransactionDTO.getFileRecordCnt());
                                csoTransaction.setFileSystemSeqNumber(cSOTransactionDTO.getFileSystemSeqNumber());
                                csoTransaction.setRecordNumber(cSOTransactionDTO.getRecordNumber());
                                csoTransaction.setTransactionCode(cSOTransactionDTO.getTransactionCode());
                                csoTransaction.setRecordStartByte(cSOTransactionDTO.getRecordStartByte());
                                csoTransaction.setRecordEndByte(cSOTransactionDTO.getRecordEndByte());
                                csoTransaction.setOpfileNumSeq(cSOTransactionDTO.getOpfileNumSeq());
                                csoTransaction.setBillingFee(transactionBill);
                                csoTransaction.setBillingFeeAmount(transactionBillAmount);
                                csoTransaction.setBillingVat(transactionVat);
                                csoTransaction.setCbBillFee(cashBackBill);
                                csoTransaction.setCbBillFeeAmnt(cashBackBillAmount);
                                csoTransaction.setCbBillVat(cashbackVat);
                                csoTransaction.setAcquirerBin(cSOTransactionDTO.getAcquirerBin());
                                csoTransaction.setAcquirerMember(cSOTransactionDTO.getAcquirerMember());
                                csoTransaction.setIssuerBin(cSOTransactionDTO.getIssuerBin());
                                csoTransaction.setIssuerMember(cSOTransactionDTO.getIssuerMember());
                                csoTransaction.setAccountNumber(cSOTransactionDTO.getAccountNumber());
                                csoTransaction.setExtractInd(cSOTransactionDTO.getExtractInd());
                                csoTransaction.setSystemSeqNumber(transactionSystemSequenceNumber); // update this transaction

                                csoTransactionsDao.updateBilling(csoTransaction);
                            }
                           }
                        }
                    }
                }
            

            Utils.logSpolog("Completed Billing for file " + fileRefNumber.substring(0, 8),PROCESSNAME);
            log.info("Finished Calculate billing figures for " + fileRefNumber.substring(0, 8));

            return Boolean.TRUE;
        } catch (Exception e) {
            log.error("Error creating calculating billing fees, cause : " + e.getMessage(), e);
            return Boolean.FALSE;
        }

    }

    public void updateMasterCardPaymentInstructions(CsoPaymentInstructionsMcardDTO instructionsMcardDTO, CsfCardRateLookupDTO cardRateLookupDTO, CsvSarbBillingViewDTO billingViewDTO) throws DAOException {

        instructionsMcardDTO.setPosEntryMode(cardRateLookupDTO.getPosEntryMode());
        instructionsMcardDTO.setChipCard(cardRateLookupDTO.getChipCard());
        instructionsMcardDTO.setEcommInd(cardRateLookupDTO.geteCommInd());
        instructionsMcardDTO.setCardPresent(cardRateLookupDTO.getCardPresent());
        instructionsMcardDTO.setRateDesc(billingViewDTO.getRateDescriptor());
        instructionsMcardDTO.setTerminalCapability(cardRateLookupDTO.getTerminalCapability());
        csoPaymentInstructionsMcardDAO.update(instructionsMcardDTO);

    }

    public void updateVisaPaymentInstructions(CSOPaymentInstructionsVisaDTO instructionsVisaDTO, CsfCardRateLookupDTO cardRateLookupDTO, CsfCardRateLookupDTO billingViewDTO) throws DAOException {

        instructionsVisaDTO.setPosEntryMode(cardRateLookupDTO.getPosEntryMode());
        instructionsVisaDTO.setChipCard(cardRateLookupDTO.getChipCard());
        instructionsVisaDTO.setEcommInd(cardRateLookupDTO.geteCommInd());
        instructionsVisaDTO.setCardPresent(cardRateLookupDTO.getCardPresent());
        instructionsVisaDTO.setRateDesc(billingViewDTO.getRateDescriptor());
        instructionsVisaDTO.setTerminalCapability(cardRateLookupDTO.getTerminalCapability());
        cSOPaymentInstructionsVisaDAO.update(instructionsVisaDTO);
    }

    public void updateBillingForCSOTransactions(CSOTransactionDTO cSOTransactionDTO, CsvTransactionsViewDto csvTransactionViewDto, CsoTransactionsDAO csoTransactionsDao, double billper, double billfee, double transactionTax, long transactionSystemSequenceNumber) throws DAOException {
    	CSOTransactionDTO csoTransaction = new CSOTransactionDTO();
        csoTransaction.setFleetCountTran(cSOTransactionDTO.getFleetCountTran());
        csoTransaction.setProcessStatus(cSOTransactionDTO.getProcessStatus());
        csoTransaction.setTransactionAmount(cSOTransactionDTO.getTransactionAmount());
        csoTransaction.setCashbackPresent(cSOTransactionDTO.getCashbackPresent());
        csoTransaction.setCashbackAmount(cSOTransactionDTO.getCashbackAmount());
        csoTransaction.setCardType(cSOTransactionDTO.getCardType());
        csoTransaction.setFileRecordCnt(cSOTransactionDTO.getFileRecordCnt());
        csoTransaction.setFileSystemSeqNumber(cSOTransactionDTO.getFileSystemSeqNumber());
        csoTransaction.setRecordNumber(cSOTransactionDTO.getRecordNumber());
        csoTransaction.setTransactionCode(cSOTransactionDTO.getTransactionCode());
        csoTransaction.setRecordStartByte(cSOTransactionDTO.getRecordStartByte());
        csoTransaction.setRecordEndByte(cSOTransactionDTO.getRecordEndByte());
        csoTransaction.setOpfileNumSeq(cSOTransactionDTO.getOpfileNumSeq());

        if (csvTransactionViewDto.getCashbackPresent().equals("Y")) {
            csoTransaction.setCbBillFee(billfee);
            csoTransaction.setCbBillVat(transactionTax);
            csoTransaction.setCbBillFeeAmnt(billfee);
        } else {
            csoTransaction.setBillingFee(billfee);
            csoTransaction.setBillingVat(transactionTax);
            csoTransaction.setBillingFeeAmount(billfee);
        }
        csoTransaction.setAcquirerBin(cSOTransactionDTO.getAcquirerBin());
        csoTransaction.setAcquirerMember(cSOTransactionDTO.getAcquirerMember());
        csoTransaction.setIssuerBin(cSOTransactionDTO.getIssuerBin());
        csoTransaction.setIssuerMember(cSOTransactionDTO.getIssuerMember());
        csoTransaction.setAccountNumber(cSOTransactionDTO.getAccountNumber());
        csoTransaction.setExtractInd(cSOTransactionDTO.getExtractInd());
        csoTransaction.setSystemSeqNumber(transactionSystemSequenceNumber); // update this transaction

        csoTransactionsDao.updateBilling(csoTransaction);

    }

    public void buildCssCcr002Stats(String subService) {

        try {
            // get processing date
            CsoSystemParametersDTO csoSystemParametersDTO = new CsoSystemParametersDTO();
            csoSystemParametersDTO.setProcessActiveInd("Y");
            String procDate = BsvTableLookup.getInstance().getProcessDate();
            Date processingDate = DateUtil.formatStringToDate(procDate, "yyyyMMdd");

            //get subservices
            CsoServiceParametersDTO csoServiceParametersDTO = new CsoServiceParametersDTO();
//                                            csoServiceParametersDTO.setInwardStatus("R");
//                                            csoServiceParametersDTO.setOutwardStatus("R");
            csoServiceParametersDTO.setInwardStatus("A");
            csoServiceParametersDTO.setOutwardStatus("A");

            if (subService != null) // if its null , this will run for all subservices
            {
                csoServiceParametersDTO.setSubService(subService);
            }

            List<CsoServiceParametersDTO> csoServiceParametersDtoList = new CsoServiceParametersDAO().retrieveRelated(csoServiceParametersDTO);

            for (CsoServiceParametersDTO cspDto : csoServiceParametersDtoList) {

                CsfDeliveryServicesDTO csfDeliveryServicesDTO = new CsfDeliveryServicesDTO();
                csfDeliveryServicesDTO.setSubService(cspDto.getSubService());
                csfDeliveryServicesDTO = new CsfDeliveryServicesDAO().retrieve(csfDeliveryServicesDTO);

                if (csfDeliveryServicesDTO == null) {
                    continue;
                } else {
                    // delete old stats
                    CssCcr002StatsDTO cssCcr002StatsDTO = new CssCcr002StatsDTO();
                    cssCcr002StatsDTO.setProcessDate(processingDate);
                    cssCcr002StatsDTO.setSubService(cspDto.getSubService());
//                                                                            new CssCcr002StatsDAO(connection).delete(cssCcr002StatsDTO);

                    //get csv_ccr002 view data
                    CsvCcr002View csvCcr002View = new CsvCcr002View();
                    List<CsvCcr002ViewDto> csvCcr002ViewDtos = csvCcr002View.execute();

                    //insert new stats
                    for (CsvCcr002ViewDto csvCcr002ViewDto : csvCcr002ViewDtos) {

                        if (csvCcr002ViewDto.getSubService().equals(cspDto.getSubService())) {
                            cssCcr002StatsDTO = new CssCcr002StatsDTO();
                            cssCcr002StatsDTO.setProcessDate(processingDate);
                            cssCcr002StatsDTO.setService(csvCcr002ViewDto.getService());
                            cssCcr002StatsDTO.setSubService(csvCcr002ViewDto.getSubService());
                            cssCcr002StatsDTO.setTargetBank(csvCcr002ViewDto.getIssuerBankCode());
                            cssCcr002StatsDTO.setOtherBank(csvCcr002ViewDto.getAcquirerBankCode());
                            cssCcr002StatsDTO.setFeesAsAcq(csvCcr002ViewDto.getAcquirerFees());
                            cssCcr002StatsDTO.setFeesAsIss(csvCcr002ViewDto.getIssuerFees());
                            cssCcr002StatsDTO.setNettFees(csvCcr002ViewDto.getNettFees());
                            //new CssCcr002StatsDAO(connection).create(cssCcr002StatsDTO);
                        }
                    }
                }
            }
        } catch (Exception e) {
            log.error("Error with buildCssCcr002Stats. cause : " + e.getMessage(), e);
        }
    }

    public DataSource getConnection() {
        return connection;
    }

    public void setConnection(DataSource connection) {
        this.connection = connection;
    }
}
