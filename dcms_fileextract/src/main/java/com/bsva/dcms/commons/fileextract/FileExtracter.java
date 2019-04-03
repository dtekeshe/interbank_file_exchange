package com.bsva.dcms.commons.fileextract;

import org.apache.log4j.Logger;

import com.bsva.dcms.commons.dao.CSFMembersDAO;
import com.bsva.dcms.commons.dao.CsoInputFileControlsDAO;
import com.bsva.dcms.commons.dao.SiteControlsDAO;
import com.bsva.dcms.commons.dto.CSFMembersDTO;
import com.bsva.dcms.commons.dto.CsoInputFileControlsDTO;
import com.bsva.dcms.commons.dto.CsoOutputControlsDTO;
import com.bsva.dcms.commons.dto.SiteControlsDTO;
import com.bsva.dcms.commons.dto.file.DataElementDTO;
import com.bsva.dcms.commons.dto.file.FileAXSHeaderRecordDTO;
import com.bsva.dcms.commons.dto.file.FileAXSTrailorRecordDTO;
import com.bsva.dcms.commons.dto.file.FileDTO;
import com.bsva.dcms.commons.dto.file.FileEOS98RecordDTO;
import com.bsva.dcms.commons.dto.file.FileTrailer91_92RecordDTO;
import com.bsva.dcms.commons.dto.file.IPMFileHeaderDTO;
import com.bsva.dcms.commons.dto.file.IPMFileTrailorDTO;
import com.bsva.dcms.commons.dto.file.MastercardFileDTO;
import com.bsva.dcms.commons.dto.file.VisaTCRTransactionsDTO;
import com.bsva.dcms.commons.enums.Status;
import com.bsva.dcms.commons.util.BsvTableLookup;
import com.bsva.dcms.commons.util.Constants;
import com.bsva.dcms.commons.util.StringUtil;
import com.bsva.dcms.commons.util.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author SimphiweT
 */
public class FileExtracter {

    private static String logPGM = "EXTRACT";
    private FileDTO fileDto;
    private MastercardFileDTO mastercardFileDTO;
    private List<FileTrailer91_92RecordDTO> fileTrailer91_92RecordList;
    private static Logger log = Logger.getLogger(FileExtracter.class);
    private int fileNumberCountVisa = 0;
    private int fileNumberCountMCI = 0;
    private static final String PROCESSNAME = "FileExtract";

    public FileExtracter() {
        this.fileDto = new FileDTO();
        this.fileTrailer91_92RecordList = new ArrayList<>();
        this.mastercardFileDTO = new MastercardFileDTO();
    }

    // createAXSHeaderRecord
    public FileAXSHeaderRecordDTO createAXSHeaderRecord(CsoInputFileControlsDTO csoInputFC,FileDTO filedto) {

        FileAXSHeaderRecordDTO visaAXSHeaderRecordDto = new FileAXSHeaderRecordDTO();

        try {

            String recordID = Constants.AXS_HEADER_RECID;
            visaAXSHeaderRecordDto.setRecordId(StringUtil.leftJustify(recordID, StringUtil.SPACE_STRING, 2));
            String outputDate = BsvTableLookup.getInstance().getProcessDate();
            visaAXSHeaderRecordDto.setOutputDate(StringUtil.leftJustify(outputDate, StringUtil.SPACE_STRING, 8));

            String serviceType = BsvTableLookup.getInstance().getSystemService();
            visaAXSHeaderRecordDto.setServiceType(StringUtil.leftJustify(serviceType, StringUtil.SPACE_STRING, 4));

            String memberSubService = csoInputFC.getSubService();
            visaAXSHeaderRecordDto.setSubServiceType(StringUtil.leftJustify(memberSubService, StringUtil.SPACE_STRING, 10));

           // CSFMembersDTO members = new CSFMembersDTO();
            //members.setBankCode(csoInputFC.getOriginatingMember());
            //CSFMembersDAO membersdao = new CSFMembersDAO();
            //CSFMembersDTO membersData = membersdao.retrieve(members);
            //if(membersData != null){
            	visaAXSHeaderRecordDto.setBankMemberNumber(padLeftString(String.valueOf(fileDto.getBankCode()), 4));//(membersData.getMemberNo(), StringUtil.ZERO_STRING, 4));
           // }
            //int originBankMember = csoInputFC.getOriginatingMember();
           // StringBuffer sTest = new StringBuffer("000");
           // sTest.append(originBankMember);
            String originator = Constants.ORIGINATOR;
            visaAXSHeaderRecordDto.setOriginator(StringUtil.leftJustify(originator, StringUtil.SPACE_STRING, 4));

            if (csoInputFC.getSubService().equals("MASTERCARD")) {
            	fileNumberCountMCI ++;
                String fileName = mastercardFileDTO.getFileName();
                visaAXSHeaderRecordDto.setFileName(StringUtil.leftJustify(fileName, StringUtil.SPACE_STRING, 8));
            }
            //"VISA CARD".equals(csoInputFC.getSubService()) || "DINERS".equals(csoInputFC.getSubService())|| "AMEX".equals(csoInputFC.getSubService()) || "FLEET".equals(csoInputFC.getSubService())
            if ("VISA CARD".equals(csoInputFC.getSubService()) || "DINERS".equals(csoInputFC.getSubService())|| "AMEX".equals(csoInputFC.getSubService()) || "FLEET".equals(csoInputFC.getSubService())) {
            	fileDto = filedto;
            	fileNumberCountVisa ++;
            	String fileName = fileDto.getFileName();
                visaAXSHeaderRecordDto.setFileName(StringUtil.leftJustify(fileName, StringUtil.SPACE_STRING, 8));
            }

            
             String fileNumber = fileDto.getFileName();//String.valueOf(fileNumberCount);//fileDto.getFileNumber();
             visaAXSHeaderRecordDto.setFileNumber(StringUtil.leftJustify(fileNumber.substring(3, 7),StringUtil.SPACE_STRING, 4));
             
            String dataType = Constants.FILE_DATA_TYPE;
            visaAXSHeaderRecordDto.setDataType(StringUtil.leftJustify(dataType, StringUtil.SPACE_STRING, 4));

            String dataDirection = Constants.OUT_DATA_DIRECTION;
            visaAXSHeaderRecordDto.setDataDirection(StringUtil.leftJustify(dataDirection, StringUtil.SPACE_STRING, 3));

            String settlementDate = BsvTableLookup.getInstance().getProcessDate();
            visaAXSHeaderRecordDto.setSettlementDate(StringUtil.leftJustify(settlementDate, StringUtil.SPACE_STRING, 8));
          
            String liveIndicator = BsvTableLookup.getInstance().getSystemStatus();
            visaAXSHeaderRecordDto.setTestLiveIndicator(StringUtil.leftJustify(liveIndicator, StringUtil.SPACE_STRING, 4));

            String recordSize = Constants.RECORD_SIZE;//fileDto.getRecordCount(); //Constants.RECORD_SIZE;
            visaAXSHeaderRecordDto.setRecordLength(StringUtil.leftJustify(recordSize, StringUtil.SPACE_STRING, 4));

            String filler = "";
            visaAXSHeaderRecordDto.setFiller(StringUtil.leftJustify(filler, StringUtil.SPACE_STRING, 101));

            this.fileDto.setFileAXSHeaderRecordDto(visaAXSHeaderRecordDto);
            
            csoInputFC.setProcessStatus(Status.C.getSymbol());
            new CsoInputFileControlsDAO().update(csoInputFC);

        } catch (Exception e) {
            log.error("Error in createAXSHeaderRecord() " + e);
        }
       
        return visaAXSHeaderRecordDto;
    }

    public IPMFileHeaderDTO createIPMFileHeader1644(CsoInputFileControlsDTO csoInputFC,FileDTO filedto) {

        IPMFileHeaderDTO ipmFileHeader1664 = new IPMFileHeaderDTO();
        Map<Integer, DataElementDTO> dataElementsMap = new HashMap<Integer, DataElementDTO>();
        DataElementDTO daElement24 = new DataElementDTO();
        String masterCardRecord = "";

        int bankCode = csoInputFC.getOriginatingMember();
        int recordWriteStartByte = BsvTableLookup.getInstance()
                .getCsfMasterCardOptions().get(String.valueOf(bankCode))
                .getRecordWriteStartByte();
        for (int x = 0; x < recordWriteStartByte; x++) {
            masterCardRecord += "#";
        }

        try {

            String messageTypeIndicator = "1644";
            ipmFileHeader1664.setMessageTypeIndicator(messageTypeIndicator);
            dataElementsMap.put(24, daElement24);

            // Construct the bitmap
            String primaryBM = "";
            for (int i = 1; i <= 64; i++) {
                if (dataElementsMap.get(i) != null) {
                    primaryBM += "1";
                } else {
                    primaryBM += "0";
                }
            }
            // convert binary to ASCII text
            char[] primaryBMResults = new char[primaryBM.length() / 8];
            for (int i = 0; i < primaryBM.length(); i += 8) {
                String sub = primaryBM.substring(i, i + 8);
                primaryBMResults[i / 8] = (char) Integer.parseInt(sub, 2);
            }
            System.out.println(new String(primaryBMResults));
            Utils.logSpolog(new String(primaryBMResults),PROCESSNAME);

            ipmFileHeader1664.setPrimaryBitMap(primaryBM);

            // Construct the bitmap
            String secondaryBM = "";

            for (int i = 65; i <= 128; i++) {
                if (dataElementsMap.get(i) != null) {
                    secondaryBM += "1";
                } else {
                    secondaryBM += "0";
                }
            }

            // convert binary to ASCII text
            char[] secondaryBMResults = new char[secondaryBM.length() / 8];
            for (int i = 0; i < secondaryBM.length(); i += 8) {
                String sub = secondaryBM.substring(i, i + 8);
                secondaryBMResults[i / 8] = (char) Integer.parseInt(sub, 2);
            }
            System.out.println(new String(secondaryBMResults));
            Utils.logSpolog(new String(secondaryBMResults),PROCESSNAME);

            ipmFileHeader1664.setSecondaryBitMap(secondaryBM);
            String p_24FunctionCode = "697";
            // ipmFileHeader1664.setP_24FunctionCode(p_24FunctionCode);

            this.mastercardFileDTO.setIpmFileHeaderDto(ipmFileHeader1664);

        } catch (Exception e) {
            log.error("Error in createIPMFileHeader1644() " + e);
        }

        return ipmFileHeader1664;

    }

    /*
     * // /createHeader90Record public FileHeader90RecordDTO
     * createHeader90Record() {
     * 
     * FileHeader90RecordDTO visaHeaderRecord90DTO = new
     * FileHeader90RecordDTO();
     * 
     * try {
     * 
     * String transactionCode = Constants.HEADER_90_RECID;
     * visaHeaderRecord90DTO.
     * setTransactionCode(StringUtil.leftJustify(transactionCode,
     * StringUtil.SPACE_STRING, 2));
     * 
     * String processingBin = " ";
     * visaHeaderRecord90DTO.setProcessingBin(StringUtil
     * .leftJustify(processingBin,StringUtil.ZERO_STRING, 6));
     * 
     * String processingDate = BsvTableLookup.getInstance().getProcessDate();
     * visaHeaderRecord90DTO
     * .setProcessingDate(StringUtil.leftJustify(processingDate
     * ,StringUtil.ZERO_STRING, 5));
     * 
     * String reserved = " ";
     * visaHeaderRecord90DTO.setReserved1(StringUtil.leftJustify
     * (reserved,StringUtil.SPACE_STRING, 16));
     * 
     * String testOption = BsvTableLookup.getInstance().getSystemStatus();
     * visaHeaderRecord90DTO
     * .setTestOption(StringUtil.leftJustify(testOption,StringUtil.SPACE_STRING,
     * 4));
     * 
     * String reserved2 = " ";
     * visaHeaderRecord90DTO.setReserved2(StringUtil.leftJustify
     * (reserved2,StringUtil.SPACE_STRING, 29));
     * 
     * String securityCode = " ";
     * visaHeaderRecord90DTO.setSecurityCode(StringUtil
     * .leftJustify(securityCode,StringUtil.SPACE_STRING, 8));
     * 
     * String reserved3 = " ";
     * visaHeaderRecord90DTO.setReserved3(StringUtil.leftJustify
     * (reserved3,StringUtil.SPACE_STRING, 6));
     * 
     * String outgoingFile = " ";
     * visaHeaderRecord90DTO.setOutgointFileId(StringUtil
     * .leftJustify(outgoingFile,StringUtil.SPACE_STRING, 3));
     * 
     * String reserved4 = " ";
     * visaHeaderRecord90DTO.setReserved4(StringUtil.leftJustify
     * (reserved4,StringUtil.SPACE_STRING, 89));
     * 
     * this.fileDto.setFileHeader90RecordDto(visaHeaderRecord90DTO);
     * 
     * } catch (Exception e) { log.error("Error in createHeader90Record() " +
     * e.getMessage()); } return visaHeaderRecord90DTO;
     * 
     * }
     */
    // createTrailor92Record
    public List<FileTrailer91_92RecordDTO> createTrailor92Record() {

        FileTrailer91_92RecordDTO fileTrailorDto = new FileTrailer91_92RecordDTO();

        try {

            VisaTCRTransactionsDTO dto = new VisaTCRTransactionsDTO();

            String transactionCode = dto.getTransactionCode();

            if (transactionCode == Constants.END_OF_BATCH_91 || transactionCode == Constants.END_OF_BATCH_92);
            fileTrailorDto.setTransactionCode(StringUtil.leftJustify(transactionCode, StringUtil.SPACE_STRING, 2));

            String tranCCodeQualifier = dto.getTranCodeQualifier();
            fileTrailorDto.setTranCodeQualifier(StringUtil.leftJustify(tranCCodeQualifier, StringUtil.ZERO_STRING, 1));

            String tranSeqNo = dto.getTcrNumber();
            fileTrailorDto.setTcrNumber(StringUtil.leftJustify(tranSeqNo, StringUtil.ZERO_STRING, 1));

            String bin = "";
            fileTrailorDto.setBin(StringUtil.leftJustify(bin, StringUtil.ZERO_STRING, 6));

            String processingDate = BsvTableLookup.getInstance().getProcessDate();
            fileTrailorDto.setProcessingDate(StringUtil.leftJustify(processingDate, StringUtil.ZERO_STRING, 5));

            String destAmount = "";
            fileTrailorDto.setDestinationAmount(StringUtil.leftJustify(destAmount, StringUtil.ZERO_STRING, 15));

            String moneyTransfer = "";
            fileTrailorDto.setNoOfMoneyTransfers(StringUtil.leftJustify(moneyTransfer, StringUtil.ZERO_STRING, 12));

            String batchNumber = "";
            fileTrailorDto.setBatchNumber(StringUtil.leftJustify(batchNumber, StringUtil.ZERO_STRING, 6));

            String numberOTCRs = "";
            fileTrailorDto.setNoOfTCRs(StringUtil.leftJustify(numberOTCRs, StringUtil.ZERO_STRING, 12));

            String reserved1 = "";
            fileTrailorDto.setReserved1(StringUtil.leftJustify(reserved1, StringUtil.SPACE_STRING, 6));

            String centreBatchInd = "";
            fileTrailorDto.setCentreBatchIndicator(StringUtil.leftJustify(centreBatchInd, StringUtil.SPACE_STRING, 8));

            String noOfTransactions = "";
            fileTrailorDto.setNoOfTransactions(StringUtil.leftJustify(noOfTransactions, StringUtil.SPACE_STRING, 9));

            String reserved2 = "";
            fileTrailorDto.setReserved2(StringUtil.leftJustify(reserved2, StringUtil.SPACE_STRING, 18));

            String sourceAmount = "";
            fileTrailorDto.setSourceAmount(StringUtil.leftJustify(sourceAmount, StringUtil.ZERO_STRING, 13));

            String filler = "";
            fileTrailorDto.setFiller(StringUtil.leftJustify(filler, StringUtil.SPACE_STRING, 52));

            // this.visaFileDto.setFileCtrlTrailorDtoList(fileTrailorDto);
            fileTrailer91_92RecordList.add(fileTrailorDto);

        } catch (Exception e) {
            log.error("Error in createTrailor92Record() " + e.getMessage());
        }
        return fileTrailer91_92RecordList;

    }

    // createEOS98Record
    public FileEOS98RecordDTO createEOS98Record(
            CsoInputFileControlsDTO csoInputFC) {
        FileEOS98RecordDTO fileEOS98RecordDto = new FileEOS98RecordDTO();

        try {

            String recordID = Constants.EOS_98_RECID;
            fileEOS98RecordDto.setRecordId(recordID);
            String outputDate = BsvTableLookup.getInstance().getProcessDate();
            fileEOS98RecordDto.setOutputDate(outputDate);

            String serviceType = BsvTableLookup.getInstance().getSystemService();
            fileEOS98RecordDto.setServiceType(serviceType);

            String memberSubService = csoInputFC.getSubService();
            fileEOS98RecordDto.setSubServiceType(memberSubService);

            //int originBankMember = csoInputFC.getOriginatingMember();
            String sTest = "00";
            fileEOS98RecordDto.setBankMemberNumber(padLeftString(sTest, 4));
            String noOfTransFiles = null;
            if ("VISA CARD".equals(csoInputFC.getSubService()) || "DINERS".equals(csoInputFC.getSubService())|| "AMEX".equals(csoInputFC.getSubService()) || "FLEET".equals(csoInputFC.getSubService())) {
             noOfTransFiles =  String.valueOf(fileNumberCountVisa);
            }else{
            	noOfTransFiles =  String.valueOf(fileNumberCountMCI);
            }
            fileEOS98RecordDto.setTransamissionFileCount(padLeftString(noOfTransFiles,4));

            String noOfCredits = "";
            fileEOS98RecordDto.setCreditRecordCount(padLeftString(noOfCredits,8));

            String noOfDebitRecords = "";
            fileEOS98RecordDto.setDebitRecordCount(padLeftString(noOfDebitRecords,8));

            String valueCreditRecs = "";
            fileEOS98RecordDto.setValueOfCreditRecords(padLeftString(valueCreditRecs,12));

            String valueDebitRecs = "";
            fileEOS98RecordDto.setValueOfDebitRecords(padLeftString(valueDebitRecs,12));

            long hashTotalAccNo = fileDto.getHashTotal();
            fileEOS98RecordDto.setHashTotalOfAccountNumber(String.valueOf(hashTotalAccNo));

            String filler = "";
            fileEOS98RecordDto.setFiller(filler);

            this.fileDto.setFileEOS98RecordDto(fileEOS98RecordDto);

        } catch (Exception e) {
            log.error("Error in createEOS98Record() " + e.getMessage());
        }
        return fileEOS98RecordDto;

    }

    public IPMFileTrailorDTO createTrailer1644(
            CsoInputFileControlsDTO csoInputFC) {

        IPMFileTrailorDTO ipmFileTrailer1644 = new IPMFileTrailorDTO();
        Map<Integer, DataElementDTO> dataElementsMap = new HashMap<Integer, DataElementDTO>();
        DataElementDTO daElement24 = new DataElementDTO();
        String masterCardRecord = "";

        int bankCode = csoInputFC.getOriginatingMember();
        int recordWriteStartByte = BsvTableLookup.getInstance()
                .getCsfMasterCardOptions().get(String.valueOf(bankCode))
                .getRecordWriteStartByte();
        for (int x = 0; x < recordWriteStartByte; x++) {
            masterCardRecord += "#";
        }

        try {

            String mti = "1644";
            ipmFileTrailer1644.setMessageTypeIndicator(mti);
            dataElementsMap.put(24, daElement24);

            String primaryBM = "";
            for (int i = 1; i <= 64; i++) {
                if (dataElementsMap.get(i) != null) {
                    primaryBM += "1";
                } else {
                    primaryBM += "0";
                }
            }
            ipmFileTrailer1644.setPrimaryBitMap(primaryBM);

            // Construct the bitmap
            String secondaryBM = "";
            ipmFileTrailer1644.setSecondaryBitMap("");
            for (int i = 65; i <= 128; i++) {
                if (dataElementsMap.get(i) != null) {
                    secondaryBM += "1";
                } else {
                    secondaryBM += "0";
                }
            }
            ipmFileTrailer1644.setSecondaryBitMap(secondaryBM);

            String p_24FunctionCode = "695";
            // ipmFileTrailer1644.setP_24FunctionCode(p_24FunctionCode);

            this.mastercardFileDTO.setIpmFileTrailorDto(ipmFileTrailer1644);

        } catch (Exception e) {
            log.error("Error in createTrailer1644() " + e);
        }

        return ipmFileTrailer1644;

    }

    // createEOF99Record
    public FileAXSTrailorRecordDTO createEOF99Record(CsoInputFileControlsDTO csoInputFC) {

        FileAXSTrailorRecordDTO fileEOS99RecordDto = new FileAXSTrailorRecordDTO();

        try {

            String recordID = Constants.AXS_TRAILOR_RECID;
            fileEOS99RecordDto.setRecordId(recordID);
            String outputDate = BsvTableLookup.getInstance().getProcessDate();
            fileEOS99RecordDto.setOutputDate(outputDate);

            String serviceType = BsvTableLookup.getInstance().getSystemService();
            fileEOS99RecordDto.setServiceType(serviceType);

            String memberSubService = csoInputFC.getSubService();
            fileEOS99RecordDto.setSubServiceType(memberSubService);

           // int originBankMember = csoInputFC.getOriginatingMember();
           // StringBuffer sTest = new StringBuffer("000");
            ////sTest.append(originBankMember);
           // CSFMembersDTO members = new CSFMembersDTO();
           // members.setBankCode(csoInputFC.getOriginatingMember());
           // CSFMembersDAO membersdao = new CSFMembersDAO();
           // CSFMembersDTO membersData = membersdao.retrieve(members);
            //if(membersData != null){
            fileEOS99RecordDto.setBankMemberNumber(padLeftString(String.valueOf(fileDto.getBankCode()), 4));
            //}

            String noOfRecords = String.valueOf(fileDto.getRecordCount());
            String pad = padLeftString(noOfRecords,6);
            fileEOS99RecordDto.setNumberOfRecords(pad);

            String sourceID = "";
            fileEOS99RecordDto.setSourceIdentifier(sourceID);

            String encryptedWorkingKey = "";
            fileEOS99RecordDto.setEncryptedWorkingKey(encryptedWorkingKey);

            String macHashTotal = " ";
            fileEOS99RecordDto.setMacOfHashTotal(macHashTotal);

            long hashTotalAccNo = 0L;//fileDto.getHashTotal();
            fileEOS99RecordDto.setHashtotalOfAccountNumbers(padLeftString(String.valueOf(hashTotalAccNo),16));

            String filler = "";
            fileEOS99RecordDto.setFiller(filler);

            String masterCardRecord = "";

            /*if (memberSubService.equals("MASTERCARD")) {
             int bankCode = csoInputFC.getOriginatingMember();
             int recordWriteStartByte = BsvTableLookup.getInstance().getCsfMasterCardOptions().get(String.valueOf(bankCode)).getRecordWriteStartByte();
             for (int x = 0; x < recordWriteStartByte; x++) {
             masterCardRecord += '\0';
             }
             }*/
            this.fileDto.setFileAxsTrailorRecordDto(fileEOS99RecordDto);

        } catch (Exception e) {
            log.error("Error in createEOF99Record() " + e.getMessage());
        }
        return fileEOS99RecordDto;
    }
    /**
	 * @param s
	 * @param n
	 * @return
	 */
    public static String padLeftString(String s, int n) {
 	   return String.format("%0$"+ n +"s", s).replace(' ', '0');
     }

    public FileDTO getFileDto() {
        return fileDto;
    }

    public void setFileDto(FileDTO fileDto) {
        this.fileDto = fileDto;
    }
    
    

}
