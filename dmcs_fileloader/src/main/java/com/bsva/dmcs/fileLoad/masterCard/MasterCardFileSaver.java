//package com.bsva.dmcs.fileLoad.masterCard;
//
//import java.math.BigDecimal;
//import java.util.Map;
//
//import javax.sql.DataSource;
//
//import org.apache.log4j.Logger;
//
//import com.bsva.dcms.commons.dao.CsoPaymentInstructionsMcardDAO;
//import com.bsva.dcms.commons.dao.CsoPaymentMcardPdsDAO;
//import com.bsva.dcms.commons.dao.CsoTransactionsDAO;
//import com.bsva.dcms.commons.dto.CSOTransactionDTO;
//import com.bsva.dcms.commons.dto.CsoPaymentInstructionsMcardDTO;
//import com.bsva.dcms.commons.dto.CsoPaymentMcardPdsDTO;
//import com.bsva.dcms.commons.dto.file.FileDTO;
//import com.bsva.dcms.commons.dto.file.FileTransactionRecordDTO;
//import com.bsva.dcms.commons.dto.file.MastercardFileDTO;
//import com.bsva.dcms.commons.dto.file.MastercardFileTransactionRecordDTO;
//import com.bsva.dcms.commons.exceptions.DAOException;
//import com.bsva.dcms.commons.util.Utils;
//import com.bsva.dmcs.fileLoad.AbstractFileSaver;
//import com.bsva.dmcs.fileLoad.exceptions.FileLoadException;
//import com.bsva.dmcs.fileLoad.masterCard.mappings.PDSObject;
//import com.bsva.dmcs.reports.CSR024;
//import java.util.HashMap;
//import java.util.logging.Level;
//import javax.xml.parsers.ParserConfigurationException;
//import javax.xml.transform.TransformerConfigurationException;
//import javax.xml.transform.TransformerFactoryConfigurationError;
//
//public class MasterCardFileSaver extends AbstractFileSaver {
//
//    private MastercardFileDTO fileDto;
//    private Logger log = Logger.getLogger(MasterCardFileSaver.class);
//    private DataSource conn;
//    private PDSObject pDSObject = new PDSObject();
//    private String pdsString = null;
//    private CsoPaymentMcardPdsDAO csoPaymentMcardPdsdao = new CsoPaymentMcardPdsDAO();
//
//    public DataSource getConn() {
//        return conn;
//    }
//
//    public void setConn(DataSource conn) {
//        this.conn = conn;
//    }
//
//    public MasterCardFileSaver() {
//
//    }
//
//    @Override
//    public void save(FileDTO fileDto) throws FileLoadException {
//        // TODO Auto-generated method stub
//
//        log.info("Saving file " + fileDto.getFileName() + " to the database");
//        this.fileDto = (MastercardFileDTO) fileDto;
//
//        //if file was rejected, then dont continue
////		if (this.fileDto.getFileStatus().equals(Status.R.getSymbol())){
////			log.debug("File " + fileDto.getFileName() + "was rejected, so we wont be saving to the database");
////			return;
////		}
//        //save file cso_input_file_controls
//        long fileSequence = loadInputFileControls(fileDto);
//
//        //save each transaction of the file into CSO_TRANSACTION
//        for (FileTransactionRecordDTO fileTransactionDto : this.fileDto.getFileTransactionRecordDtoList()) {
//
//            MastercardFileTransactionRecordDTO mcFileTransactionDto = (MastercardFileTransactionRecordDTO) fileTransactionDto;
//            loadFileTransaction(mcFileTransactionDto, fileSequence);
//        }
//
//        Utils.logSpolog("File " + fileDto.getFileName() + " Saved to the database");
//
//        //save file cso_input_file_controls
//        log.info("Finished Saving file " + fileDto.getFileName() + " to the database");
//    }
//
//    public void loadFileTransaction(MastercardFileTransactionRecordDTO fileTransactionDto, long fileSequence) throws FileLoadException {
//
//        try {
//            CSOTransactionDTO transactionDto = new CSOTransactionDTO();
//            CsoTransactionsDAO transactionDao = new CsoTransactionsDAO();
//
//            transactionDto.setFileSystemSeqNumber(fileSequence);
//            transactionDto.setRecordNumber(fileTransactionDto.getRecordOffset());
//            transactionDto.setTransactionCode(fileTransactionDto.getTransactionCode());
//            transactionDto.setCardType(fileTransactionDto.getCardType());
//            transactionDto.setIssuerMember(fileTransactionDto.getIssuer());
//            transactionDto.setAcquirerMember(fileTransactionDto.getAcquirer());
//            transactionDto.setIssuerBin(fileTransactionDto.getIssuerBin());
//            transactionDto.setAcquirerBin(fileTransactionDto.getAcquirerBin());
//
//            transactionDto.setCashbackAmount(new BigDecimal(fileTransactionDto.getCashbackAmount()));
//            transactionDto.setRecordStartByte(fileTransactionDto.getRecordStartByte());
//            transactionDto.setRecordEndByte(fileTransactionDto.getRecordEndByte());
//            transactionDto.setFileRecordCnt(fileTransactionDto.getNonFinRecCount() + 1);
//            transactionDto.setMessageTypeInd(fileTransactionDto.getMessageTypeInd()); //MTI
//            transactionDto.setMerchantCatCode(fileTransactionDto.getMerchantCatCode());
//            transactionDto.setIntchgRateDsgn(0);
//            transactionDto.setMessageReasonCode(fileTransactionDto.getMessageReasonCode());
//            transactionDto.setOutputFilename(fileTransactionDto.getOutputFileName());
//            transactionDto.setAccountNumber(fileTransactionDto.getCardNumber());
//            transactionDto.setSystemSeqNumber(fileSequence);
//            transactionDto.setProcessStatus(fileTransactionDto.isCurrentRecordValid() ? "A" : "R");
//            transactionDto.setTransactionAmount(fileTransactionDto.getTransactionAmount());
//            transactionDto.setCashbackPresent(fileTransactionDto.isTransactionACashBack() ? "Y" : "N");
//            transactionDto.setFleetCountTran("N"); //default
//            transactionDto.setExtractInd("N");
//            // create a transaction entry
//            transactionDao.create(transactionDto);
//            log.debug("MCI TRANSACTION SAVED!!!");
//
//            //retrieve the system sequence number
//            CSOTransactionDTO transactionDtot = new CSOTransactionDTO();
//            transactionDtot.setSystemSeqNumber(transactionDto.getSystemSeqNumber());
//            transactionDtot = transactionDao.retrieve(transactionDtot);
//
//            // create payment instructions for master card
//            saveTransactionPaymentInstructions(transactionDtot, fileTransactionDto);
//
//            //save pds for the transaction
//            generatePdsObject();
//            savePaymentMCardPDS(transactionDtot, fileTransactionDto);
//
//        } catch (Exception ex) {
//            ex.getMessage();
//            ex.printStackTrace();
//            throw new FileLoadException(ex.getMessage());
//        }
//    }
//
//    public void saveTransactionPaymentInstructions(CSOTransactionDTO transactionDto, MastercardFileTransactionRecordDTO fileTransactionDto) throws FileLoadException {
//
//        try {
//            CsoPaymentInstructionsMcardDAO csoPaymentInstructionsMcardDAO_ = new CsoPaymentInstructionsMcardDAO();
//            CsoPaymentInstructionsMcardDTO csoPaymentInstructionMcardDTO_ = new CsoPaymentInstructionsMcardDTO();
//
//            csoPaymentInstructionMcardDTO_.setFileRefNumber1(String.valueOf(transactionDto.getFileSystemSeqNumber()));
//            csoPaymentInstructionMcardDTO_.setSystemSeqNumber2(transactionDto.getSystemSeqNumber());
//            csoPaymentInstructionMcardDTO_.setRecordId(Integer.valueOf(fileTransactionDto.getRecordId()));
//            csoPaymentInstructionMcardDTO_.setServiceCode(fileDto.getFileService()); // TO DO
//            csoPaymentInstructionMcardDTO_.setSubServiceName("MASTERCARD");
//            csoPaymentInstructionMcardDTO_.setPrimaryBitmap(fileTransactionDto.getPrimaryBitMap());
//            csoPaymentInstructionMcardDTO_.setSecondaryBitmap(fileTransactionDto.getSecondaryBitMap());
//            csoPaymentInstructionMcardDTO_.setMessageTypeIndicator(fileTransactionDto.getMessageTypeInd());
//            csoPaymentInstructionMcardDTO_.setP4TransactionAmount(fileTransactionDto.getTransactionAmount());
//            csoPaymentInstructionMcardDTO_.setP5ReconclliationAmount(fileTransactionDto.getReconciliationAmout());
//            csoPaymentInstructionMcardDTO_.setAcquirerMember(fileTransactionDto.getAcquirer());
//            csoPaymentInstructionMcardDTO_.setIssuerMember(fileTransactionDto.getIssuer());
//            csoPaymentInstructionMcardDTO_.setP25MessageReasonCode(fileTransactionDto.getMessageReasonCode());
//            csoPaymentInstructionMcardDTO_.setP26CardAcceptorBusCode(Integer.valueOf(fileTransactionDto.getCardAcceptorBusCode()));
//            csoPaymentInstructionMcardDTO_.setP37RetrievalRefNumber(fileTransactionDto.getRetrievalRefNumber());
//            csoPaymentInstructionMcardDTO_.setP38ApprovalCode(fileTransactionDto.getApprovalCode());
//            csoPaymentInstructionMcardDTO_.setRecordId(Integer.parseInt(fileTransactionDto.getRecordId()));
//            csoPaymentInstructionMcardDTO_.setTransactionCode(fileTransactionDto.getTransactionCode());
//            csoPaymentInstructionMcardDTO_.setCardType(String.valueOf(fileTransactionDto.getCardType()));
//            csoPaymentInstructionMcardDTO_.setP55IccLength(Integer.valueOf(fileTransactionDto.getIccLength()));
//            csoPaymentInstructionMcardDTO_.setP55IccSystemRelatedData(fileTransactionDto.getIccSystemRelatedData());
//            csoPaymentInstructionMcardDTO_.setP2PanLength(fileTransactionDto.getPanlength());
//            csoPaymentInstructionMcardDTO_.setP2Pan(fileTransactionDto.getCardNumber());
//            csoPaymentInstructionMcardDTO_.setP12LocalDate(Long.valueOf(fileTransactionDto.getLocalDate()));
//            csoPaymentInstructionMcardDTO_.setP13LocalTime(Long.valueOf(fileTransactionDto.getLocalTime()));
//            csoPaymentInstructionMcardDTO_.setP22PointOfSaleData(fileTransactionDto.getPointOfSaleData());
//            csoPaymentInstructionMcardDTO_.setP41CardAcceptorTerminalId(fileTransactionDto.getCardAcceptorBusCode());
//            csoPaymentInstructionMcardDTO_.setP42CardAcceptorId(fileTransactionDto.getCardAcceptorId());
//            csoPaymentInstructionMcardDTO_.setP33ForwardingInstLength(fileTransactionDto.getP33ForwardingInstLength());
//            csoPaymentInstructionMcardDTO_.setP33ForwardingInstCode(Long.valueOf(fileTransactionDto.getFowardingInstCode()));
//            csoPaymentInstructionMcardDTO_.setP24FunctionCode(fileTransactionDto.getFunctionCode());
//            csoPaymentInstructionMcardDTO_.setP31AcquirerRefLength(fileTransactionDto.getAcquirerRefLength());
//            csoPaymentInstructionMcardDTO_.setP31AcquirerRefData(fileTransactionDto.getAcquirerRefData());
//            csoPaymentInstructionMcardDTO_.setP40ServiceCode(fileTransactionDto.getCode());
//            csoPaymentInstructionMcardDTO_.setP43CardAcceptorLength(fileTransactionDto.getCardAcceptorLength());
//            csoPaymentInstructionMcardDTO_.setP43CardAcceptorName(fileTransactionDto.getCardAcceptorName());
//            csoPaymentInstructionMcardDTO_.setP48AdditionalDataLength(String.valueOf(fileTransactionDto.getAdditionalDataLength()));
//            csoPaymentInstructionMcardDTO_.setP48AdditionalData(fileTransactionDto.getAdditionalData());
//            // PDS Assignment
//            setPdsString(fileTransactionDto.getAdditionalData());
//            csoPaymentInstructionMcardDTO_.setP49CurrencyCode(Integer.valueOf(fileTransactionDto.getCurrencyCode()));
//            csoPaymentInstructionMcardDTO_.setP50ReconcilliationCode(Integer.valueOf(fileTransactionDto.getReconciliationCode()));
//            csoPaymentInstructionMcardDTO_.setS71MessageNumber(fileTransactionDto.getMessageNumber());
//            csoPaymentInstructionMcardDTO_.setMastercardAmount(fileTransactionDto.getTransactionAmount());
//            csoPaymentInstructionMcardDTO_.setInputFileIdentifier(fileDto.getFileName());
//            csoPaymentInstructionMcardDTO_.setSeqNo(Long.valueOf(fileTransactionDto.getRecordId()));
//            csoPaymentInstructionMcardDTO_.setProcessStatus(fileTransactionDto.getProcessStatus());
//            csoPaymentInstructionMcardDTO_.setFilenameDescription(fileDto.getFileName());
//            csoPaymentInstructionMcardDTO_.setIrd(fileTransactionDto.getIRD());
//            csoPaymentInstructionMcardDTO_.setCashbackPurchaseAmnt(fileTransactionDto.getCashbackAmount());
//            csoPaymentInstructionMcardDTO_.setP2Pan(fileTransactionDto.getCardNumber());
//            csoPaymentInstructionMcardDTO_.setCashbackPurchase(fileTransactionDto.isTransactionACashBack() ? "Y" : "N");
//            csoPaymentInstructionMcardDTO_.setFinancialIndicator(fileTransactionDto.isFinancialStatus() ? "N" : "Y");
//            csoPaymentInstructionMcardDTO_.setS127NetworkData(fileTransactionDto.getS127networkdata());
//            csoPaymentInstructionMcardDTO_.setS125AdditionalData(fileTransactionDto.getS125additionaldata());
//            csoPaymentInstructionMcardDTO_.setS124AddLen(fileTransactionDto.getS124addlen());
//            csoPaymentInstructionMcardDTO_.setS124AdditionalData(fileTransactionDto.getS124additionaldata());
//            csoPaymentInstructionMcardDTO_.setS123AddLen(fileTransactionDto.getS123addlen());
//            csoPaymentInstructionMcardDTO_.setS123AdditionalData(fileTransactionDto.getS123additionaldata());
//            csoPaymentInstructionMcardDTO_.setS111Length(fileTransactionDto.getS111len());
//            csoPaymentInstructionMcardDTO_.setS111AmtCurrencyConversion(fileTransactionDto.getS111amtcurrencyconversion());
//            csoPaymentInstructionMcardDTO_.setS104TransactionDescription(fileTransactionDto.getS104transactiondescription());
//            csoPaymentInstructionMcardDTO_.setS103AccountIdentification2(fileTransactionDto.getS103accountidentification2());
//            csoPaymentInstructionMcardDTO_.setS102AccountIdentification1(fileTransactionDto.getS102accountidentification1());
//            csoPaymentInstructionMcardDTO_.setS101FileName(fileTransactionDto.getS101filename());
//            csoPaymentInstructionMcardDTO_.setS100RiiLen(fileTransactionDto.getS100riilen());
//            csoPaymentInstructionMcardDTO_.setS100RcvingInstIdCode(fileTransactionDto.getS100rcvinginstidcode());
//            csoPaymentInstructionMcardDTO_.setS99SettlementInstIdCode(fileTransactionDto.getS99settlementinstidcode());
//            csoPaymentInstructionMcardDTO_.setS98Payee(fileTransactionDto.getS98payee());
//            csoPaymentInstructionMcardDTO_.setS97NetSettlementAmount(fileTransactionDto.getS97netsettlementamount());
//            csoPaymentInstructionMcardDTO_.setS96MessageSecurityCode(fileTransactionDto.getS96messagesecuritycode());
//            /*csoPaymentInstructionMcardDTO_.setS95CardIssRefDataLength(Integer.valueOf(fileTransactionDto.getS95_CARD_ISS_REF_DATA_LENGTH()));
//             csoPaymentInstructionMcardDTO_.setS95CardIssuerRefData(String.valueOf(fileTransactionDto.getS95_CARD_ISSUER_REF_DATA()));
//             csoPaymentInstructionMcardDTO_.setS94Length(fileTransactionDto.getS94_LENGTH());
//             csoPaymentInstructionMcardDTO_.setS94TransactionOrigInstId(fileTransactionDto.getS94_TRANSACTION_ORIG_INST_ID());
//             csoPaymentInstructionMcardDTO_.setS93Length(fileTransactionDto.getS93_LENGTH());
//             csoPaymentInstructionMcardDTO_.setS93TransactionDestInstId(fileTransactionDto.getS93_TRANSACTION_DEST_INST_ID());*/
//            csoPaymentInstructionMcardDTO_.setS92FilesSecurityCode(fileTransactionDto.getS92filessecuritycode());
//            csoPaymentInstructionMcardDTO_.setS91FileUpdateCode(fileTransactionDto.getS91fileupdatecode());
//            csoPaymentInstructionMcardDTO_.setS90OriginatingDataElements(fileTransactionDto.getS90originatingdataelements());
//            csoPaymentInstructionMcardDTO_.setS89ReversalAmountDebits(fileTransactionDto.getS89reversalamountdebits());
//            csoPaymentInstructionMcardDTO_.setS88AmountDebits(fileTransactionDto.getS88amountdebits());
//            csoPaymentInstructionMcardDTO_.setS87ReversalAmountCredits(fileTransactionDto.getS87reversalamountcredits());
//            csoPaymentInstructionMcardDTO_.setS86AmountCredits(Long.valueOf(fileTransactionDto.getS86amountcredits()));
//            csoPaymentInstructionMcardDTO_.setS85TransctionFeeAmounts(Long.valueOf(fileTransactionDto.getS85transctionfeeamounts()));
//            csoPaymentInstructionMcardDTO_.setS84ProcessingFeeDebits(Long.valueOf(fileTransactionDto.getS84processingfeedebits()));
//            csoPaymentInstructionMcardDTO_.setS83TransactionFeeCredits(Long.valueOf(fileTransactionDto.getS83transactionfeecredits()));
//            csoPaymentInstructionMcardDTO_.setS82ProcessingFeeCredits(Long.valueOf(fileTransactionDto.getS82processingfeecredits()));
//            csoPaymentInstructionMcardDTO_.setS81NumberAuthorisations(Long.valueOf(fileTransactionDto.getS81numberauthorisations()));
//            csoPaymentInstructionMcardDTO_.setS80NumberEnquiries(Long.valueOf(fileTransactionDto.getS80numberenquiries()));
//            csoPaymentInstructionMcardDTO_.setS79ReversalNumberTransfers(Long.valueOf(fileTransactionDto.getS79reversalnumbertransfers()));
//            csoPaymentInstructionMcardDTO_.setS78NumberTransfers(Long.valueOf(fileTransactionDto.getS78numbertransfers()));
//            csoPaymentInstructionMcardDTO_.setS77ReversalNoOfDebits(Long.valueOf(fileTransactionDto.getS77reversalnoofdebits()));
//            csoPaymentInstructionMcardDTO_.setS76NoOfDebits(Long.valueOf(fileTransactionDto.getS76noofdebits()));
//            csoPaymentInstructionMcardDTO_.setS75ReversalNoOfCredits(Long.valueOf(fileTransactionDto.getS75reversalnoofcredits()));
//            csoPaymentInstructionMcardDTO_.setS74NoOfCredits(Long.valueOf(fileTransactionDto.getS74noofcredits()));
//            csoPaymentInstructionMcardDTO_.setS73ActionDate(Integer.valueOf(fileTransactionDto.getS73actiondate()));
//            csoPaymentInstructionMcardDTO_.setS72DataLen(fileTransactionDto.getS72datalen());
//            csoPaymentInstructionMcardDTO_.setS72DataRecord(fileTransactionDto.getS72datarecord());
//            csoPaymentInstructionMcardDTO_.setS70NetworkManCountryCode(fileTransactionDto.getS70networkmancountrycode());
//            csoPaymentInstructionsMcardDAO_.create(csoPaymentInstructionMcardDTO_);
//
//        } catch (NumberFormatException | DAOException e) {
//            throw new FileLoadException(e.getMessage());
//        }
//    }
//
//    public void savePaymentMCardPDS(CSOTransactionDTO transactionDto, MastercardFileTransactionRecordDTO fileTransactionDto) throws FileLoadException {
//
//        try {
//
//            for (Map pdsMap : getpDSObject().getPdsMapList()) {
//
//                CsoPaymentMcardPdsDTO paymentPdsDto = new CsoPaymentMcardPdsDTO();
//                paymentPdsDto.setSystemSeqNumber(transactionDto.getSystemSeqNumber());
//                paymentPdsDto.setPdsNumber(Integer.valueOf(pdsMap.get("tag").toString()));
//                paymentPdsDto.setPdsLength(Integer.valueOf(pdsMap.get("dataLength").toString()));
//                paymentPdsDto.setPdsData(pdsMap.get("pdsData").toString());
//
//                csoPaymentMcardPdsdao.create(paymentPdsDto);
//            }
//        } catch (NumberFormatException | DAOException e) {
//            throw new FileLoadException(e.getMessage());
//        }
//    }
//
//    @Override
//    public void setConnection(DataSource conn) {
//        // TODO Auto-generated method stub
//
//    }
//
//    public void generatePdsObject() {
//
//         String pdsField = getPdsString();
//
//        do {
//            String returnValue = getPdsData(pdsField);
//            String stringResult = pdsField.substring(returnValue.length(), pdsField.length());
//            pdsField = stringResult;
//        } while (pdsField.length() != 0);
//    }
//
//    public String getPdsData(String string) {
//
//        String tag = string.substring(0, 4);
//        String dataLength = string.substring(tag.length(), 7);
//        String pdsData = string.substring(7, (dataLength.length() * 2) + Integer.valueOf(dataLength) + 1);
//
//        String stringToReturn = tag + dataLength + pdsData;
//        Map<String, String> pdsMap = new HashMap<>();
//
//        pdsMap.put("tag", tag);
//        pdsMap.put("dataLength", dataLength);
//        pdsMap.put("pdsData", pdsData);
//
//        pDSObject.getPdsMapList().add(pdsMap);
//
//        return stringToReturn;
//    }
//
//    public PDSObject getpDSObject() {
//        return pDSObject;
//    }
//
//    public void setpDSObject(PDSObject pDSObject) {
//        this.pDSObject = pDSObject;
//    }
//
//    public String getPdsString() {
//        return pdsString;
//    }
//
//    public void setPdsString(String pdsString) {
//        this.pdsString = pdsString;
//    }
//
//
//
//}
