package com.bsva.dcms.commons.util;

import com.bsva.dcms.commons.dao.CSFTransactionTypesDAO;
import com.bsva.dcms.commons.dao.CSOPaymentInstructionsVisaDAO;
import com.bsva.dcms.commons.dao.CsfCardFeeSarbBillingDAO;
import com.bsva.dcms.commons.dao.CsfCardRateLookupDAO;
import com.bsva.dcms.commons.dao.CsoFleetBillingDAO;
import com.bsva.dcms.commons.dao.CsoFleetBindResolvedDAO;
import com.bsva.dcms.commons.dao.CsoInputFileControlsDAO;
import com.bsva.dcms.commons.dao.CsoPaymentInstructionsMcardDAO;
import com.bsva.dcms.commons.dao.CsoTransactionsDAO;
import com.bsva.dcms.commons.dao.CsvSarbBillingViewDAO;
import com.bsva.dcms.commons.dto.CSOTransactionDTO;
import com.bsva.dcms.commons.dto.CsoFleetBillingDTO;
import com.bsva.dcms.commons.dto.CsoFleetBindResolvedDTO;
import com.bsva.dcms.commons.dto.CsoInputFileControlsDTO;
import com.bsva.dcms.commons.dto.views.CsvTransactionsViewDto;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.dcms.commons.views.CsvTransactionsView;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

/**
 *
 * @author SimphiweT
 */
public class FleetBilling {

    private String subService = "FLEET";
    private final Logger log = Logger.getLogger(FleetBilling.class);

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
    private SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
    private CsoFleetBillingDTO previousBillingDTO;

    public FleetBilling(String subService) throws ParseException {
        this.subService = subService;
    }

    public Date getDate() throws ParseException {
        String processDate = BsvTableLookup.getInstance().getProcessDate();
        Date date = formatter.parse(processDate);
        return date;
    }

    void doFleetBilling(String fileRefNumber) throws DAOException, ParseException {

        CsoInputFileControlsDTO csoInputFileControlsDTO = new CsoInputFileControlsDTO();
        csoInputFileControlsDTO.setFileRefNumber(fileRefNumber);
        CsoInputFileControlsDAO csoInputFileControlsDao = new CsoInputFileControlsDAO();
        CsoInputFileControlsDTO csoInputFileControlsDto = csoInputFileControlsDao.retrieve(csoInputFileControlsDTO);
        if (csoInputFileControlsDto == null) {
            log.debug("File " + fileRefNumber + " not found. Billing stopped");
            //return Boolean.FALSE;
        }

        CsoFleetBillingDTO csoFleetBillingDTO = new CsoFleetBillingDTO();
        csoFleetBillingDTO.setService("CARD");
        csoFleetBillingDTO.setSubService("FLEET");
        long fileRefNum = csoInputFileControlsDto.getSystemSeqNumber();
        csoFleetBillingDTO.setFileRefNumber(fileRefNum);

        // FLEET OBJECTS
        List<CsoFleetBillingDTO> fleetBillingDTOList = csoFleetBillingDAO.retrieveRelated(csoFleetBillingDTO);

        for (CsoFleetBillingDTO billingDTO : fleetBillingDTOList) {
            Map<String, CsoFleetBillingDTO> dtoMap = new HashMap<>();
            dtoMap.put(billingDTO.getAccNo(), billingDTO);
            myList.add(dtoMap);
        }

        for (Map fleetMap : myList) {
            for (Object mapEntry : fleetMap.entrySet()) {
                Map.Entry entry = (Map.Entry) mapEntry;
                String accountNumber = entry.getKey().toString();
                CsoFleetBillingDTO billingDTO = (CsoFleetBillingDTO) entry.getValue();
                billingMap.put(accountNumber, billingDTO);
            }
        }

        // GRAB ACCOUNT NUMBER AND CORRESPONDING FLEET TRANSACTIONS
        for (Map.Entry lookupMap : billingMap.entrySet()) {
            CsoFleetBillingDTO lookupDTO = new CsoFleetBillingDTO();
            CSOTransactionDTO transactionDTO = new CSOTransactionDTO();
            transactionDTO.setAccountNumber(lookupMap.getKey().toString());
            lookupDTO.setAccNo(lookupMap.getKey().toString());

            CSOTransactionDTO transaction = transactionsDAO.retrieve(transactionDTO);
            List<CsoFleetBillingDTO> billingFleetDTOList = csoFleetBillingDAO.retrieveRelated(lookupDTO);

            // SORT THE RESULT BY TRANSACTION TIME                    
            Collections.sort(billingFleetDTOList, new SortByFleetBilling_TxtDateTime());

            if (billingFleetDTOList.size() == 1) {
                // PERFORM FLEET BILLING for single transactions
                CsoFleetBillingDTO billingDTO = billingFleetDTOList.get(0);
                createBillingResolvedSingleEntry(billingDTO, transaction);
            }

            long divisor = 1000L;
            int counter = 0;
            CsoFleetBillingDTO billingDTO = null;

            if (billingFleetDTOList.size() > 2) {
                for (Iterator<CsoFleetBillingDTO> it = billingFleetDTOList.iterator(); it.hasNext();) {
                    counter++;
                    billingDTO = it.next();

                    if (counter > 1) {
                        long time_diff = Math.abs((getPreviousBillingDTO().getTxDateTime() - billingDTO.getTxDateTime()) / divisor);
                        if (time_diff < 300000) {
                            // merge and commit 1 transaction
                            createBillingResolvedEntry(billingDTO, getPreviousBillingDTO(), billingDTO.getTxDateTime(), getPreviousBillingDTO().getTxDateTime(), transaction);
                        } else {
                            // commit both transactions
                            createBillingResolvedSingleEntry(billingDTO, transaction);
                            createBillingResolvedSingleEntry(getPreviousBillingDTO(), transaction);
                        }

                        if (billingDTO.getTxDateTime() == getPreviousBillingDTO().getTxDateTime()) {
                            createBillingResolvedEntry(billingDTO, getPreviousBillingDTO(), billingDTO.getTxDateTime(), getPreviousBillingDTO().getTxDateTime(), transaction);
                        }
                    }
                    setPreviousBillingDTO(billingDTO);
                }
            }

            if (billingFleetDTOList.size() == 2) {
                CsoFleetBillingDTO billingDTO_1 = billingFleetDTOList.get(0);
                CsoFleetBillingDTO billingDTO_2 = billingFleetDTOList.get(1);

                long time_diff_1 = billingDTO_1.getTxDateTime() / divisor;
                long time_diff_2 = billingDTO_2.getTxDateTime() / divisor;

                if (Math.abs(time_diff_1 - time_diff_2) < 300000) {
                    // do a merge and commit 1 transaction
                    createBillingResolvedEntry(billingDTO_1, billingDTO_2, time_diff_1, time_diff_2, transaction);
                } else {
                    // commit both transactions
                    createBillingResolvedEntry(billingDTO_1, null, time_diff_1, time_diff_2, transaction);
                    createBillingResolvedEntry(null, billingDTO_2, time_diff_1, time_diff_2, transaction);
                }
            }
        }
    }

    // WORKS 
    public void createBillingResolvedSingleEntry(CsoFleetBillingDTO billingFleetDTO, CSOTransactionDTO transaction) throws ParseException, DAOException {

        CsoFleetBillingDTO cfbdto = billingFleetDTO;
        CsoFleetBindResolvedDTO bindResolvedDTO = new CsoFleetBindResolvedDTO();
        bindResolvedDTO.setAccNo(cfbdto.getAccNo());
        bindResolvedDTO.setIss(cfbdto.getIss());
        bindResolvedDTO.setAcq(cfbdto.getAcq());
        bindResolvedDTO.setAmount(cfbdto.getAmount());
        bindResolvedDTO.setCardType((short) cfbdto.getCardType());
        bindResolvedDTO.setFileSystemSeqNumber(cfbdto.getFileRefNumber());
        bindResolvedDTO.setIssuerBin((long) transaction.getIssuerBin());
        bindResolvedDTO.setAcquirerBin(transaction.getAcquirerBin());
        bindResolvedDTO.setProcessDate(getDate());
        bindResolvedDTO.setProduct(cfbdto.getProduct());
        bindResolvedDTO.setService(cfbdto.getService());
        bindResolvedDTO.setSubProduct(cfbdto.getSubProduct());
        bindResolvedDTO.setSubService(cfbdto.getSubService());
        bindResolvedDTO.setTranSystemSeqNumber(cfbdto.getTranSystemSeqNumber());
        bindResolvedDTO.setTxCde(cfbdto.getTxCde());
        bindResolvedDTO.setTxCnt(cfbdto.getTxCnt());
        bindResolvedDTO.setTxDateTime(cfbdto.getTxDateTime());
        bindResolvedDAO.create(bindResolvedDTO);

    }

    // WORKS
    public void createBillingResolvedEntry(CsoFleetBillingDTO billingDTO_1, CsoFleetBillingDTO billingDTO_2, long time_diff_1, long time_diff_2, CSOTransactionDTO transaction) throws DAOException, ParseException {

        long amount = 0L;
        long amount1 = 0L;
        long amount2 = 0L;
        CsoFleetBillingDTO billing_DTO = new CsoFleetBillingDTO();

        if ((billingDTO_1 != null) && (billingDTO_1.getAmount() != null)) {
            amount = billingDTO_1.getAmount().longValue();
            amount1 = amount;
            billing_DTO = billingDTO_1;
        }

        if ((billingDTO_2 != null) && (billingDTO_2.getAmount() != null)) {
            amount = billingDTO_2.getAmount().longValue();
            amount2 = amount;
            billing_DTO = billingDTO_2;
        }

        if ((billingDTO_1 != null && billingDTO_1.getAmount() != null) && (billingDTO_2 != null && billingDTO_2.getAmount() != null)) {
            billing_DTO = billingDTO_1;
            amount = amount1 + amount2;
        }

        CsoFleetBindResolvedDTO bindResolvedDTO = new CsoFleetBindResolvedDTO();
        bindResolvedDTO.setAccNo(billing_DTO.getAccNo());
        bindResolvedDTO.setIss(billing_DTO.getIss());
        bindResolvedDTO.setAcq(billing_DTO.getAcq());
        bindResolvedDTO.setAmount(new BigDecimal(amount));
        bindResolvedDTO.setCardType((short) billing_DTO.getCardType());
        bindResolvedDTO.setFileSystemSeqNumber(billing_DTO.getFileRefNumber());
        bindResolvedDTO.setIssuerBin((long) transaction.getIssuerBin());
        bindResolvedDTO.setAcquirerBin(transaction.getAcquirerBin());
        bindResolvedDTO.setProcessDate(getDate());
        bindResolvedDTO.setProduct(billing_DTO.getProduct());
        bindResolvedDTO.setService(billing_DTO.getService());
        bindResolvedDTO.setSubProduct(billing_DTO.getSubProduct());
        bindResolvedDTO.setSubService(billing_DTO.getSubService());
        bindResolvedDTO.setTranSystemSeqNumber(billing_DTO.getTranSystemSeqNumber());
        bindResolvedDTO.setTxCde(billing_DTO.getTxCde());
        bindResolvedDTO.setTxCnt(billing_DTO.getTxCnt());
        bindResolvedDTO.setTxDateTime(billing_DTO.getTxDateTime());
        bindResolvedDAO.create(bindResolvedDTO);

    }

    public CsoFleetBillingDTO getPreviousBillingDTO() {
        return previousBillingDTO;
    }

    public void setPreviousBillingDTO(CsoFleetBillingDTO previousBillingDTO) {
        this.previousBillingDTO = previousBillingDTO;
    }

    public void doCsoTransactionUpdateForFleet(CsoInputFileControlsDTO csoInputFileControlsDTO) throws DAOException {

        CsvTransactionsView csvTransactionView = new CsvTransactionsView();
        List<CsvTransactionsViewDto> csvTransactionsViewDtoList = csvTransactionView.execute(csoInputFileControlsDTO);

        CsoFleetBindResolvedDTO bindResolvedDTO = new CsoFleetBindResolvedDTO();
        bindResolvedDTO.setFileSystemSeqNumber(csoInputFileControlsDTO.getSystemSeqNumber());
        List<CsoFleetBindResolvedDTO> fleetBindResolvedList = bindResolvedDAO.retrieveRelated(bindResolvedDTO);

        for (CsoFleetBindResolvedDTO resolvedDTO : fleetBindResolvedList) {
            for (CsvTransactionsViewDto csvTransactionViewDto : csvTransactionsViewDtoList) {
                if (resolvedDTO.getTranSystemSeqNumber() == csvTransactionViewDto.getTransactionSystemSeqNumber()) {
                    double transactionBill = new BigDecimal(resolvedDTO.getAmount().longValue() * (csvTransactionViewDto.getInterchangeFee() / 100)).setScale(5, RoundingMode.FLOOR).doubleValue();
                    double transactionBillAmount = new BigDecimal(csvTransactionViewDto.getInterchangeFeeAmount()).setScale(5, RoundingMode.FLOOR).doubleValue();
                    double transactionVat = new BigDecimal(((resolvedDTO.getAmount().longValue() * (csvTransactionViewDto.getInterchangeFee() / 100))
                            + csvTransactionViewDto.getInterchangeFeeAmount()) * csvTransactionViewDto.getInputVat() / 100).abs().setScale(5, RoundingMode.FLOOR).doubleValue();

                    CSOTransactionDTO csoTransaction = new CSOTransactionDTO();
                    CSOTransactionDTO csoTransactiodto = new CSOTransactionDTO();
                    csoTransactiodto.setSystemSeqNumber(resolvedDTO.getTranSystemSeqNumber()); // update this transaction

                    CsoTransactionsDAO csoTransactionsDao = new CsoTransactionsDAO();
                    CSOTransactionDTO cSOTransactionDTO = csoTransactionsDao.retrieve(csoTransactiodto);

                    double cashBackBill = 0;
                    double cashBackBillAmount = 0;
                    double cashbackVat = 0;
                    if (csvTransactionViewDto.getCashbackPresent().equals("Y")) {
                        cashBackBill = new BigDecimal(csvTransactionViewDto.getCashbackAmount() * (csvTransactionViewDto.getCashbackInterchangeFee() / 100)).setScale(5).doubleValue();
                        cashBackBillAmount = csvTransactionViewDto.getCashbackInterchangeFeeAmount();
                        cashbackVat = new BigDecimal(((csvTransactionViewDto.getCashbackAmount() * (csvTransactionViewDto.getCashbackInterchangeFee() / 100)) + csvTransactionViewDto.getCashbackInterchangeFeeAmount()) * csvTransactionViewDto.getCashbackInputVat() / 100).abs().setScale(5, RoundingMode.FLOOR).doubleValue();
                    } else {
                        csoTransaction.setFleetCountTran(cSOTransactionDTO.getFleetCountTran());
                        csoTransaction.setProcessStatus(cSOTransactionDTO.getProcessStatus());
                        csoTransaction.setTransactionAmount(resolvedDTO.getAmount().longValue());
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
                        csoTransaction.setFleetCountTran("Y");
                        csoTransaction.setAcquirerBin(cSOTransactionDTO.getAcquirerBin());
                        csoTransaction.setAcquirerMember(cSOTransactionDTO.getAcquirerMember());
                        csoTransaction.setIssuerBin(cSOTransactionDTO.getIssuerBin());
                        csoTransaction.setIssuerMember(cSOTransactionDTO.getIssuerMember());
                        csoTransaction.setAccountNumber(cSOTransactionDTO.getAccountNumber());
                        csoTransaction.setExtractInd(cSOTransactionDTO.getExtractInd());
                        csoTransaction.setSystemSeqNumber(resolvedDTO.getTranSystemSeqNumber()); // update this transaction
                        csoTransactionsDao.updateBilling(csoTransaction);
                    }
                    break;
                }                
            }
        }
    }
}
