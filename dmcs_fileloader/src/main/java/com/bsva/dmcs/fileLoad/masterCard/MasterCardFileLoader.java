//package com.bsva.dmcs.fileLoad.masterCard;
//
//import com.bsva.dcms.commons.dto.CSFBinsDTO;
//import com.bsva.dcms.commons.dto.CsoPaymentInstructionsMasterCardRecord;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.log4j.Logger;
//
//import com.bsva.dcms.commons.dto.MasterCardTransactionTypesDTO;
//import com.bsva.dcms.commons.dto.file.DataElementDTO;
//import com.bsva.dcms.commons.dto.file.FileDTO;
//import com.bsva.dcms.commons.dto.file.IPMFileRecordDTO;
//import com.bsva.dcms.commons.dto.file.MastercardFileDTO;
//import com.bsva.dcms.commons.dto.file.MastercardFileTransactionRecordDTO;
//import com.bsva.dcms.commons.enums.Status;
//import com.bsva.dcms.commons.util.BsvTableLookup;
//import com.bsva.dmcs.fileLoad.AbstractFileLoader;
//import com.bsva.dmcs.fileLoad.exceptions.FileLoadException;
//import com.bsva.dmcs.fileLoad.masterCard.mappings.MasterCardUtil;
//
//import java.sql.Connection;
//
//import org.beanio.BeanIOException;
//import org.beanio.BeanReader;
//import org.beanio.BeanReaderIOException;
//import org.beanio.InvalidRecordException;
//import org.beanio.StreamFactory;
//
//public class MasterCardFileLoader extends AbstractFileLoader {
//
//    private Logger log = Logger.getLogger(MasterCardFileLoader.class);
//    private MastercardFileDTO fileDto = new MastercardFileDTO();
//    private String line = new String();
//    private MasterCardUtil masterCardUtil = new MasterCardUtil();
//    private List<CsoPaymentInstructionsMasterCardRecord> transactionRecordList;
//
//    @Override
//    public FileDTO getFileByType() {
//        return fileDto;
//    }
//
//    @Override
//    public void loadFileByType(String fileName) throws FileLoadException {
//        // TODO Auto-generated method stub
//
//        log.info("Loading file " + fileName);
//
//        try {
//
//            //load input file
//            File file = new File(BsvTableLookup.getInstance().getReceiveDir() + File.separator + fileName);
//            masterCardUtil.setDataFile(file);
//
//            InputStream is = new FileInputStream(BsvTableLookup.getInstance().getAppsDir() + File.separator + "dcms-pattern-mapping.xml");
//            StreamFactory factory = StreamFactory.newInstance();
//            factory.load(is);
//
//            Boolean controlCheck = masterCardUtil.doControlRecordChecks(factory);
//
//            lineCount = 1;
//            createAXSHeaderRecord(masterCardUtil.getEOSHeader(factory).getRecordEntry());
//
//            try {
//                if (controlCheck) {
//                    masterCardUtil.getEOS1644Header(factory);
//                    fileDto.setIpmFileHeaderDto(masterCardUtil.geteOS1644Header());
//                    recordCount = getTransactions(transactionRecordList, factory, file);
//                    masterCardUtil.getEOS1644Trailer(factory);
//                    fileDto.setIpmFileTrailorDto(masterCardUtil.geteOS1644Trailer());
//
//                    try {
//                        createEOS98Record(masterCardUtil.getRealEOS98Trailer(factory).getRecordEntry());
//                    } catch (RuntimeException ex) {
//                        log.info("<<<< Trailer 98 DOES NOT EXIST" + ex.getMessage());
//                    }
//                    fileDto.setFileEOS98RecordDto(fileDto.getFileEOS98RecordDto());
//                } else {
//                    recordCount = createLines(transactionRecordList, factory, file);
//                }
//            } catch (InvalidRecordException ex) {
//                log.error(ex.getMessage());
//            }
//
//            String linex = masterCardUtil.getEOS99Trailer(factory).getRecordEntry();
//
//            try {
//                createAXSTrailorRecord(linex);
//            } catch (IndexOutOfBoundsException ex) {
//                log.info("<<<< IndexOutOfBoundsException Caught whilst creating Triler 99 " + ex.getMessage());
//            }
//
//            //fileDto.getFileAXSHeaderRecordDto().setRecordLength("700");
//            fileDto.getFileAXSHeaderRecordDto().setServiceType("CARD");
//            fileDto.getFileAXSHeaderRecordDto().setSubServiceType("MASTERCARD");
//            fileDto.getFileAxsTrailorRecordDto().setServiceType("CARD");
//            fileDto.setFileSubService("MASTERCARD");
//            fileDto.setRecordCount(recordCount);
//
//        } catch (FileNotFoundException e) {
//
//            fileDto.setFileStatus(Status.R.getSymbol());
//            log.error("Error loading master card configuration. Cannot load " + fileName, e);
//
//        } catch (BeanIOException | IOException e) {
//
//            fileDto.getErrorDto().addError(4, lineCount, lineCount, 1, line, null);
//            fileDto.setFileStatus(Status.R.getSymbol());
//            log.error("Error loading file" + fileName + " into memory. cause : " + e.getMessage(), e);
//        }
//
//        log.info("Finished Loading " + fileName);
//    }
//
//    // Load Mastercard File without 1644 Control Record
//    public Integer createLines(List<CsoPaymentInstructionsMasterCardRecord> transactionRecordList, StreamFactory factory, File file) {
//
//        BeanReader reader = factory.createReader("dmcsTransactionStream", new File(file.getAbsolutePath()));
//        transactionRecordList = new ArrayList<>();
//
//        masterCardUtil.ignoreRecord(reader);
//        CsoPaymentInstructionsMasterCardRecord transactionRecord = new CsoPaymentInstructionsMasterCardRecord();
//
//        try {
//            for (; transactionRecord != null; transactionRecord = (CsoPaymentInstructionsMasterCardRecord) reader.read()) {
//                if ((reader.getLineNumber() > 1)) {
//                    recordCount++;
//                    MastercardFileTransactionRecordDTO mastercardFileTransactionRecordDTO = new MastercardFileTransactionRecordDTO();
//                    getMastercardFileTransactionRecordDTO(mastercardFileTransactionRecordDTO, transactionRecord);
//                }
//            }
//        } catch (InvalidRecordException ex) {
//            log.debug(ex.getMessage());
//            reader.close();
//        }
//        log.debug("DONE READING TRANSACTIONS!!!");
//
//        return recordCount;
//    }
//
//    // Load Mastercard File with 1644 Control Record
//    public Integer getTransactions(List<CsoPaymentInstructionsMasterCardRecord> transactionRecordList, StreamFactory factory, File file) {
//
//        BeanReader reader = factory.createReader("dmcsTransactionStream", file);
//
//        masterCardUtil.ignoreRecords(reader);
//        Integer counter = 0;
//
//        String ipmTrailorValue = "1644";//TODO subject to question STQ.
//        CsoPaymentInstructionsMasterCardRecord transactionRecord = new CsoPaymentInstructionsMasterCardRecord();
//
//        try {
//            for (; transactionRecord != null; transactionRecord = (CsoPaymentInstructionsMasterCardRecord) reader.read()) {
//                if ((reader.getLineNumber() > 1) && (!(Integer.valueOf(ipmTrailorValue).equals(transactionRecord.getMessagetypeindicator())))) {
//                    counter++;
//                    MastercardFileTransactionRecordDTO mastercardFileTransactionRecordDTO = new MastercardFileTransactionRecordDTO();
//                    getMastercardFileTransactionRecordDTO(mastercardFileTransactionRecordDTO, transactionRecord);
//                }
//            }
//        } catch (BeanReaderIOException | InvalidRecordException ex) {
//            System.out.println("DONE WITH TRANSACTIONS !!!");
//        }
//        return counter;
//    }
//
//    private IPMFileRecordDTO createIPMRecord(String mti, Map<Integer, DataElementDTO> dataElementsForRecord) {
//
//        IPMFileRecordDTO record = new IPMFileRecordDTO();
//        record.setDataElementsMap(dataElementsForRecord);
//        record.setMessageTypeIndicator(mti);
//        record.setPrimaryBitMap("");
//        record.setSecondaryBitMap("");
//
//        return record;
//    }
//
//    private int getTransactionCode(MastercardFileTransactionRecordDTO mcFileTxnRec, String functionCode) {
//
//        List<MasterCardTransactionTypesDTO> mcTransactionTypes = BsvTableLookup.getInstance().getMasterCardTransactionTypes();
//        MasterCardTransactionTypesDTO txType = null;
//
//        for (MasterCardTransactionTypesDTO mcTxTypes : mcTransactionTypes) {
//            if (mcTxTypes.getMessageTypeIdentifier() == mcFileTxnRec.getMessageTypeInd()
//                    && mcTxTypes.getFunctionCode().equals(functionCode)) {
//                txType = mcTxTypes;
//                break;
//            }
//        }
//
//        if (txType != null) {
//            return txType.getTransactionCode();
//        } else {
//            return getTransactionCode2(mcFileTxnRec);
//        }
//    }
//
//    private int getTransactionCode2(MastercardFileTransactionRecordDTO mcFileTxnRec) {
//
//        String mti = String.valueOf(mcFileTxnRec.getMessageTypeInd());
//        Map<Integer, DataElementDTO> dataElements = mcFileTxnRec.getDataElementsMap();
//
//        int transactionCode = 0;
//
//        DataElementDTO functionCodeDE = dataElements.get(24);
//        if (functionCodeDE.getValue().equals("696")) {
//            transactionCode = 51;
//        }
//
//        DataElementDTO processingCodeDE = dataElements.get(3);
//
//        if (processingCodeDE != null) {
//            String processingCode = dataElements.get(3).getValue();
//            String processingCodePrefix = processingCode.substring(0, 2);
//
//            switch (processingCodePrefix) {
//
//                case "00":
//                    transactionCode = 5;
//                    break;
//                case "01":
//                    break;
//                case "09":
//                case "18":
//                    transactionCode = 5;
//                    break;
//                case "12":
//                    transactionCode = 7;
//                    break;
//                case "20":
//                case "28":
//                    transactionCode = 6;
//                    break;
//                default:
//                    transactionCode = 0;
//                    break;
//            }
//        }
//        //TODO : should we not get the pds first e.g pds25 or 26
//        DataElementDTO additionalData48DE = dataElements.get(48);
//        String reversalInd = "";
//        if (additionalData48DE != null) {
//            String additionalData_ = additionalData48DE.getValue();
//
//            if (additionalData_.length() >= 30) {
//                reversalInd = additionalData_.substring(30, 31);
//            }
//        }
//
//        if (mti.equals("1442")) {
//            transactionCode += 10;
//        }
//        if (reversalInd.equals("R") && mti.equals("1240")) {
//            transactionCode += 20;
//        }
//
//        return transactionCode;
//    }
//
//    private String getBitMapInBinary(MastercardFileTransactionRecordDTO mcFileTxnRec) {
//
//        Map<Integer, DataElementDTO> dataElements = mcFileTxnRec.getDataElementsMap();
//
//        String binaryBitMap = "";
//        if (mcFileTxnRec.isSecondaryBitMapPresent()) {
//            binaryBitMap += "1";
//        } else {
//            binaryBitMap += "0";
//        }
//
//        for (int i = 2; i <= 128; i++) {
//            if (dataElements.get(i) != null) {
//                binaryBitMap += "1";
//            } else {
//                binaryBitMap += "0";
//            }
//        }
//
//        return binaryBitMap;
//    }
//
//    public void createEOS98Record(String line) {
//
//        if (line.trim().equals("")) { //absence of this record does not mean error
//            return;
//        }
//        super.createEOSRecord(line);
//        this.fileDto.setFileEOS98RecordDto(fileEOSTrailorRecordDto);
//
//    }
//
//    public MastercardFileTransactionRecordDTO getMastercardFileTransactionRecordDTO(MastercardFileTransactionRecordDTO mastercardFileTransactionRecordDTO, CsoPaymentInstructionsMasterCardRecord transactionRecord) {
//
//        mastercardFileTransactionRecordDTO.setOutputFilename(transactionRecord.getFilerefnumber1());
//        mastercardFileTransactionRecordDTO.setPrimaryBitMap(transactionRecord.getPrimarybitmap());
//        mastercardFileTransactionRecordDTO.setSecondaryBitMap(transactionRecord.getSecondarybitmap());
//        mastercardFileTransactionRecordDTO.setMessageTypeInd(transactionRecord.getMessagetypeindicator()); //MTI
//        mastercardFileTransactionRecordDTO.setTransactionAmount(transactionRecord.getTransactionamount());
//        mastercardFileTransactionRecordDTO.setMessageReasonCode(transactionRecord.getMessagereasoncode());
//        mastercardFileTransactionRecordDTO.setCardAcceptorBusCode(String.valueOf(transactionRecord.getCardacceptorbuscode()));
//        mastercardFileTransactionRecordDTO.setApprovalCode(transactionRecord.getApprovalcode());
//        mastercardFileTransactionRecordDTO.setRecordId(String.valueOf(transactionRecord.getSeqno()));
//        mastercardFileTransactionRecordDTO.setTransactionCode(transactionRecord.getTransactioncode());
//        mastercardFileTransactionRecordDTO.setCardType(transactionRecord.getCardtype());
//        mastercardFileTransactionRecordDTO.setIccLength(String.valueOf(transactionRecord.getIcclength()));
//        mastercardFileTransactionRecordDTO.setIccSystemRelatedData(String.valueOf(transactionRecord.getIccsystemrelateddata()));
//        mastercardFileTransactionRecordDTO.setPanlength(transactionRecord.getPanlength());
//        mastercardFileTransactionRecordDTO.setAccountNumber(transactionRecord.getPan());
//        mastercardFileTransactionRecordDTO.setLocalDate(transactionRecord.getLocaldate());
//        mastercardFileTransactionRecordDTO.setLocalTime(transactionRecord.getLocaltime());
//        mastercardFileTransactionRecordDTO.setPointOfSaleData(transactionRecord.getPointofsaledata());
//        mastercardFileTransactionRecordDTO.setCardAcceptorTerminalId(transactionRecord.getCardacceptorterminalid());
//        mastercardFileTransactionRecordDTO.setCardAcceptorId(transactionRecord.getCardacceptorid());
//        mastercardFileTransactionRecordDTO.setFowardingInstCode(transactionRecord.getForwardinginstcode());
//        mastercardFileTransactionRecordDTO.setFunctionCode(Integer.valueOf(transactionRecord.getFunctioncode()));
//        mastercardFileTransactionRecordDTO.setAcquirerRefLength(Integer.valueOf(transactionRecord.getAcquirerreflength()));
//        mastercardFileTransactionRecordDTO.setAcquirerRefData(transactionRecord.getAcquirerrefdata());
//        mastercardFileTransactionRecordDTO.setCode(Integer.valueOf(transactionRecord.getCode()));
//        mastercardFileTransactionRecordDTO.setCardAcceptorLength(Integer.valueOf(transactionRecord.getCardacceptorlength()));
//        mastercardFileTransactionRecordDTO.setCardAcceptorName(transactionRecord.getCardacceptorname());
//        mastercardFileTransactionRecordDTO.setAdditionalDataLength(Integer.valueOf(transactionRecord.getAdditionaldatalength()));
//        mastercardFileTransactionRecordDTO.setAdditionalData(transactionRecord.getAdditionaldata());
//        mastercardFileTransactionRecordDTO.setCurrencyCode(transactionRecord.getCurrencycode());
//        mastercardFileTransactionRecordDTO.setReconciliationCode(transactionRecord.getReconcilliationcode());
//        mastercardFileTransactionRecordDTO.setMessageNumber(Integer.valueOf(transactionRecord.getMessagenumber()));
//        mastercardFileTransactionRecordDTO.setFleetCountTran("N"); //default
//        mastercardFileTransactionRecordDTO.setExtractInd("N");
//        mastercardFileTransactionRecordDTO.setCardNumber(transactionRecord.getPan());
//        mastercardFileTransactionRecordDTO.setProcessStatus(transactionRecord.isCurrentRecordValid() ? "A" : "R");
//        mastercardFileTransactionRecordDTO.setFileNameDescription("C3");
//        mastercardFileTransactionRecordDTO.setCashbackAmount(transactionRecord.getCashbackpurchaseamnt());
//        mastercardFileTransactionRecordDTO.isTransactionACashBack();
//        mastercardFileTransactionRecordDTO.setFileName(transactionRecord.getFileid());
//        mastercardFileTransactionRecordDTO.setS127networkdata(transactionRecord.getS127networkdata());
//        mastercardFileTransactionRecordDTO.setS127addlen(transactionRecord.getS127addlen());
//        mastercardFileTransactionRecordDTO.setS125addlen(transactionRecord.getS125addlen());
//        mastercardFileTransactionRecordDTO.setS125additionaldata(transactionRecord.getS125additionaldata());
//        mastercardFileTransactionRecordDTO.setS124addlen(transactionRecord.getS124addlen());
//        mastercardFileTransactionRecordDTO.setS124additionaldata(transactionRecord.getS124additionaldata());
//        mastercardFileTransactionRecordDTO.setS123addlen(transactionRecord.getS123addlen());
//        mastercardFileTransactionRecordDTO.setS123additionaldata(transactionRecord.getS123additionaldata());
//        mastercardFileTransactionRecordDTO.setS111amtcurrencyconversion(transactionRecord.getS111amtcurrencyconversion());
//        mastercardFileTransactionRecordDTO.setS111len(transactionRecord.getS111len());
//        mastercardFileTransactionRecordDTO.setS99settlementinstidcode(transactionRecord.getS99settlementinstidcode());
//        mastercardFileTransactionRecordDTO.setS98payee(transactionRecord.getS98payee());
//        mastercardFileTransactionRecordDTO.setS97netsettlementamount(transactionRecord.getS97netsettlementamount());
//        mastercardFileTransactionRecordDTO.setS96messagesecuritycode(transactionRecord.getS96messagesecuritycode());
//        mastercardFileTransactionRecordDTO.setS95cardissuerrefdata(transactionRecord.getS95cardissuerrefdata());
//        mastercardFileTransactionRecordDTO.setS95cardissrefdatalength(String.valueOf(transactionRecord.getS95cardissrefdatalength()));
//        mastercardFileTransactionRecordDTO.setS94length(transactionRecord.getS94length());
//        mastercardFileTransactionRecordDTO.setS94transactionoriginstid(String.valueOf(transactionRecord.getS94transactionoriginstid()));
//        mastercardFileTransactionRecordDTO.setS93length(transactionRecord.getS93length());
//        mastercardFileTransactionRecordDTO.setS93transactiondestinstid(transactionRecord.getS93transactiondestinstid());
//        mastercardFileTransactionRecordDTO.setS92filessecuritycode(transactionRecord.getS92filessecuritycode());
//        mastercardFileTransactionRecordDTO.setS91fileupdatecode(transactionRecord.getS91fileupdatecode());
//        mastercardFileTransactionRecordDTO.setS90originatingdataelements(transactionRecord.getS90originatingdataelements());
//        mastercardFileTransactionRecordDTO.setS89reversalamountdebits(transactionRecord.getS89reversalamountdebits());
//        mastercardFileTransactionRecordDTO.setS88amountdebits(transactionRecord.getS88amountdebits());
//        mastercardFileTransactionRecordDTO.setS87reversalamountcredits(transactionRecord.getS87reversalamountcredits());
//        mastercardFileTransactionRecordDTO.setS86amountcredits(transactionRecord.getS86amountcredits());
//        mastercardFileTransactionRecordDTO.setS85transctionfeeamounts(transactionRecord.getS85transctionfeeamounts());
//        mastercardFileTransactionRecordDTO.setS84processingfeedebits(transactionRecord.getS84processingfeedebits());
//        mastercardFileTransactionRecordDTO.setS83transactionfeecredits(transactionRecord.getS83transactionfeecredits());
//        mastercardFileTransactionRecordDTO.setS82processingfeecredits(transactionRecord.getS82processingfeecredits());
//        mastercardFileTransactionRecordDTO.setS81numberauthorisations(transactionRecord.getS81numberauthorisations());
//        mastercardFileTransactionRecordDTO.setS80numberenquiries(transactionRecord.getS80numberenquiries());
//        mastercardFileTransactionRecordDTO.setS79reversalnumbertransfers(transactionRecord.getS79reversalnumbertransfers());
//        mastercardFileTransactionRecordDTO.setS78numbertransfers(transactionRecord.getS78numbertransfers());
//        mastercardFileTransactionRecordDTO.setS77reversalnoofdebits(transactionRecord.getS77reversalnoofdebits());
//        mastercardFileTransactionRecordDTO.setS76noofdebits(transactionRecord.getS76noofdebits());
//        mastercardFileTransactionRecordDTO.setS75reversalnoofcredits(transactionRecord.getS75reversalnoofcredits());
//        mastercardFileTransactionRecordDTO.setS74noofcredits(transactionRecord.getS74noofcredits());
//        mastercardFileTransactionRecordDTO.setS73actiondate(transactionRecord.getS73actiondate());
//        mastercardFileTransactionRecordDTO.setS72datalen(transactionRecord.getS72datalen());
//        mastercardFileTransactionRecordDTO.setS72datarecord(transactionRecord.getS72datarecord());
//        mastercardFileTransactionRecordDTO.setS70networkmancountrycode(transactionRecord.getS70networkmancountrycode());
//        mastercardFileTransactionRecordDTO.setAcquirerBin(transactionRecord.getAcquirermember());
//        mastercardFileTransactionRecordDTO.setIssuerBin(transactionRecord.getIssuermember());
//        mastercardFileTransactionRecordDTO.setReconciliationAmout(transactionRecord.getReconciliationAmount());
//
//        try {
//
//            CSFBinsDTO csfBinissuerBankCode = BsvTableLookup.getInstance().getCsfBins().get(String.valueOf(mastercardFileTransactionRecordDTO.getIssuerBin()));
//            CSFBinsDTO csfBinAcquirerBankCode = BsvTableLookup.getInstance().getCsfBins().get(String.valueOf(mastercardFileTransactionRecordDTO.getAcquirerBin()));
//
//            mastercardFileTransactionRecordDTO.setAcquirer(csfBinAcquirerBankCode.getBankCode());
//            mastercardFileTransactionRecordDTO.setIssuer(csfBinissuerBankCode.getBankCode());
//            mastercardFileTransactionRecordDTO.setRetrievalRefNumber(transactionRecord.getRetrievalrefnumber());//.getRETRIEVAL_REF_NUMBER());
//        } catch (Exception ex) {//TODO list
//            if (this.fileDto.getFileAXSHeaderRecordDto() == null) {
//                fileDto.getErrorDto().addError(3, Long.valueOf(mastercardFileTransactionRecordDTO.getRecordId()), 90, 1, fileDto.getFileName(), ex.getMessage());
//                fileDto.setFileStatus(Status.R.getSymbol());
//            }
//        }
//
//        if (mastercardFileTransactionRecordDTO.isFinancialStatus()) {
//            fileDto.getFileTransactionRecordDtoList().add(mastercardFileTransactionRecordDTO);
//        }
//
//        //mastercardFileTransactionRecordDTO.setMerchantCatCode(transactionRecord.getMerchantCatCode());
//        //mastercardFileTransactionRecordDTO.setIntchgRateDsgn(0);
//        //mastercardFileTransactionRecordDTO.setRecordStartByte(transactionRecord.getRecordStartByte());
//        //mastercardFileTransactionRecordDTO.setRecordEndByte(transactionRecord.getRecordEndByte());
//        //mastercardFileTransactionRecordDTO.setFileRecordCnt(transactionRecord.getNonFinRecCount() + 2);
//        // LOOKED UP VALUE
//        //mastercardFileTransactionRecordDTO.setProcessStatus(transactionRecord.isCurrentRecordValid() ? "A" : "R");
//        //System.out.println(transactionRecord + "\n");
//        return mastercardFileTransactionRecordDTO;
//
//    }
//
//    @Override
//    public void createAXSHeaderRecord(String line) {
//
//        super.createAXSHeaderRecord(line);
//        fileDto.setFileAXSHeaderRecordDto(fileAXSHeaderRecordDto);
//    }
//
//    @Override
//    public void createAXSTrailorRecord(String line) {
//
//        super.createAXSTrailorRecord(line);
//        this.fileDto.setFileAxsTrailorRecordDto(fileAXSTrailorRecordDto);
//    }
//
//    public void setConnection(Connection connection) {
//        // TODO Auto-generated method stub
//
//    }
//}
