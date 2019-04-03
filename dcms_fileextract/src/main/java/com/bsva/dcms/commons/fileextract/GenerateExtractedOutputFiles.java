package com.bsva.dcms.commons.fileextract;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.bsva.dao.v02.LastSeqNumbersDAO;
import com.bsva.dao.v02.OutputControlDAO;
import com.bsva.dao.v02.OutputControlUpdateDAO;
import com.bsva.dao.v02.OutputFileReaderDAO;
import com.bsva.dao.v02.extract.MembersExtractDAO;
import com.bsva.dao.v02.members.MemberAddressDAO;
import com.bsva.dao.v02.members.MemberNegCardDAO;
import com.bsva.dao.v02.members.MembersDAO;
import com.bsva.dao.v02.members.MembersNegativecardsDAO;
import com.bsva.dao.v02.startofday.SeqNumbersDAO;
import com.bsva.dcms.commons.dto.file.FileAXSHeaderRecordDTO;
import com.bsva.dcms.commons.dto.file.FileAXSTrailorRecordDTO;
import com.bsva.dcms.commons.dto.file.FileEOS98RecordDTO;
import com.bsva.dcms.commons.util.BsvTableLookup;
import com.bsva.dcms.commons.util.Constants;
import com.bsva.dcms.commons.util.StringUtil;
import com.bsva.dcms.commons.util.Utils;
import com.bsva.dto.CsoNegativeCardsDTO;
import com.bsva.dto.Filename;
import com.bsva.dto.OriginDestinationPair;
import com.bsva.dto.OutputFileEntityDTO;
import com.bsva.entities.MemberNegCardEntity;
import com.bsva.entities.v02.loader.LastSeqNumberKey;
import com.bsva.entities.v02.members.MemberAddressEntity;
import com.bsva.entities.v02.startofday.SeqNumberEntity;
import com.bsva.entities.v02.startofday.SeqNumberKey;

/**
 * @author AugustineA
 *
 */
public class GenerateExtractedOutputFiles {

	private static BufferedWriter bw;
	private static FileWriter fwr;
	private String fileRef = null;
	private static Logger log = Logger.getLogger(GenerateExtractedOutputFiles.class);
	private static FileAXSHeaderRecordDTO header;
	private static FileEOS98RecordDTO footer98Record;
	private static FileAXSTrailorRecordDTO footer99Record;
	private static String logPGM = "EXTRACT";
	private static final String PROCESSNAME = "EXTRACT";
	private static long numberOfFiles = 0l;
	private static Map<Integer, String> listMapFilter = new HashMap<Integer, String>();
	private final Map<LastSeqNumberKey, Long> lastSeqNumbers;
	private LastSeqNumbersDAO lastSeqNumbersDAO ;
	private OutputControlUpdateDAO outputControlUpdateDAO;
	private SeqNumbersDAO seqNumbersDAO;
	private Map<OriginDestinationPair, List<Filename>> filenames;
	private Filename fileName ; 
	
	public GenerateExtractedOutputFiles(){
		
		lastSeqNumbersDAO = new LastSeqNumbersDAO();
        lastSeqNumbers = lastSeqNumbersDAO.lastSeqNumbers();
	}

	public void writeVisaFile() {
		try {
			String pathName = BsvTableLookup.getInstance().getSendDir();
			// gets files from the outputcontrol table with status in N and F
			List<MemberNegCardEntity> mapList = new MemberNegCardDAO().memberNegCard();
			for (MemberNegCardEntity entry : mapList) {
				List<OutputFileEntityDTO> outputFileList = new OutputFileReaderDAO()
						.getOutputFilesNeg("" + entry.getBankCode());
				if (!outputFileList.isEmpty() && outputFileList.size() > 0) {
					// Checking if subservices if active or not
					if (Utils.isSubServiceActive(logPGM, outputFileList.get(0).getService(),
							outputFileList.get(0).getSubService(), "I")) {
						for (OutputFileEntityDTO outputFileEntity : outputFileList) {
							numberOfFiles++;
							try {
								Set<CsoNegativeCardsDTO> paymentList = new MembersNegativecardsDAO()
										.getFileDetailsFor(outputFileEntity.getBankCode());
								if (paymentList == null) {
									
									Utils.logSpolog("Null Value for Negative file extract for this Bankcode "
											+ outputFileEntity.getBankCode(), PROCESSNAME);

								} else if (!paymentList.isEmpty() && paymentList.size() > 0) {
									//First update the filename in the Database before updating the records in the Database
									//update on bothe CsoOutputControls and the SeqNumber tables.
									flashFilenamesSeqNumberToOutputControls(Integer.valueOf(outputFileEntity.getSeqNumber()), outputFileEntity.getFileNamePrefix(), outputFileEntity.getDistributionCode(), outputFileEntity.getSubService());
									
									// Creating a file name and save to $Send folder
									OriginDestinationPair originDestpair = new OriginDestinationPair(Integer.valueOf(outputFileEntity.getOriginatingBank()),Integer.valueOf(outputFileEntity.getBankCode()),
											outputFileEntity.getDistributionCode(),outputFileEntity.getService(),outputFileEntity.getSubService(),outputFileEntity.getFileNamePrefix());
									//Construct a new Filename
								   fileName = nextNegativecardFilename(Long.valueOf(outputFileEntity.getSeqNumber()),originDestpair,outputFileEntity.getRecordCountForDay());
								   Utils.logSpolog("##### EXTRACT STARTED FOR FILENAME : "
											+ fileName.getFilename() + " #####", PROCESSNAME);
								    System.out.println("============######====== EXTRACT STARTING ======= ######===============");
									System.out.println("##### EXTRACT STARTED FOR FILENAME : "
											+ fileName.getFilename() + " #####");
								    //use the New Constructed Filename
									fwr = new FileWriter(	
											pathName + File.separator + fileName.getFilename());
									//Add the new Constructed Filename to the Header
									header = createAXSHeaderRecord(outputFileEntity,fileName);
									//Add  the new Constructed FileName to the  98 Footer Record
									footer98Record = createEOS98Record(outputFileEntity,fileName, numberOfFiles);
									//Add the newly Constructed FileName to the 99 Footer Record
									footer99Record = createEOF99Record(outputFileEntity,fileName);

									Map<Integer, MemberAddressEntity> member = new MemberAddressDAO()
											.memberAddresses(outputFileEntity.getSubService());
									Collection<MemberAddressEntity> members = (Collection<MemberAddressEntity>) member
											.values();
									//needs to get the right MnemonicMemberNumber from the csF_Members table
									Map<Integer,String> bankCodeName = new MembersExtractDAO().mnemonicMemberNameCodes();

									bw = new BufferedWriter(fwr);
									// writing file header to the file
									bw.write(header.toString());
									bw.newLine();
									bw.flush();
									long count = 0;
									long acquirer = 0l;
									String bankName = null;
									String bankmemberTapId = null;
									for (CsoNegativeCardsDTO string : paymentList) {
										Integer aqc = Integer.valueOf(string.getAcquirer());
										for (MemberAddressEntity memberAddressEntity : members) {
											if (memberAddressEntity.getBankCode() == aqc) {
												acquirer = memberAddressEntity.getBankCode();
												bankName = bankCodeName.get(memberAddressEntity.getBankCode());
											
											}
										}
										// writing the file names to the files
										CsoNegativeCardsDTO csoNegativeCardsDTO = new CsoNegativeCardsDTO();
										csoNegativeCardsDTO.setAcquirer(string.getAcquirer());
										csoNegativeCardsDTO.setDestBinNumber(string.getDestBinNumber());
										csoNegativeCardsDTO.setSourceBinNumber(string.getSourceBinNumber());
										csoNegativeCardsDTO.setTransactionType(string.getTransactionType());
										csoNegativeCardsDTO.setAuthCenter(string.getAuthCenter());
										csoNegativeCardsDTO.setNegativeAccNumber(string.getNegativeAccNumber());
										csoNegativeCardsDTO.setCardHolderName(string.getCardHolderName());
										csoNegativeCardsDTO.setPurgeDate(string.getPurgeDate());
										csoNegativeCardsDTO.setRegionCode(bankName);
										csoNegativeCardsDTO.setResponseCode(string.getResponseCode());
										csoNegativeCardsDTO.setSystemSeqNumber(string.getSystemSeqNumber());
										csoNegativeCardsDTO.setTransactoionCode(string.getTransactoionCode());
										csoNegativeCardsDTO.setTransSeqNumber(string.getTransSeqNumber());

										bw.write(csoNegativeCardsDTO.toString());
										bw.newLine();
										bw.flush();
										++count;
										// After every ten thousand records
										// flush the buffer to prevent out of
										// memmory error
										if (count % 10000L == 0) {
											Utils.logSpolog(
													"##### EXTRACTED : " + count + " RECORDS FOR FILENAME : "
															+ fileName.getFilename() + "  #####",
													PROCESSNAME);
											System.out.println("##### EXTRACTED : " + count + " RECORDS FOR FILENAME : "
															+ fileName.getFilename() + "");
											bw.flush();
										}
									}
									bw.write(footer98Record.toString());
									bw.newLine();
									bw.flush();
									bw.write(footer99Record.toString());
									bw.flush();
								}

							} catch (Exception ex) {
								ex.getMessage();
							} finally {

								try {
									// Checkk if the BufferedWriter is not null
									// and close it
									if (bw != null){
										bw.close();
									}
									// Check if the FileWriter is not null and
									// close it.
									if (fwr != null){
										fwr.close();
									}
									System.out.println(".........########============== DONE EXTRACTING NEGATIVE FILES===============#########........");

								} catch (IOException ex) {
									ex.printStackTrace();
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			log.error("ERROR WRITING TO FILE : " + e);
			log.debug("VISA ERROR LOG ... " + e.getMessage());
		}

	}

	// Creating of the FileHeader
	public static FileAXSHeaderRecordDTO createAXSHeaderRecord(OutputFileEntityDTO outputFileEntity,Filename  filename) {

		FileAXSHeaderRecordDTO visaAXSHeaderRecordDto = new FileAXSHeaderRecordDTO();

		try {

			String recordID = Constants.AXS_HEADER_RECID;
			visaAXSHeaderRecordDto.setRecordId(StringUtil.leftJustify(recordID, StringUtil.SPACE_STRING, 2));
			String outputDate = BsvTableLookup.getInstance().getProcessDate();
			visaAXSHeaderRecordDto.setOutputDate(StringUtil.leftJustify(outputDate, StringUtil.SPACE_STRING, 8));

			String serviceType = BsvTableLookup.getInstance().getSystemService();
			visaAXSHeaderRecordDto.setServiceType(StringUtil.leftJustify(serviceType, StringUtil.SPACE_STRING, 4));

			String memberSubService = outputFileEntity.getSubService();
			visaAXSHeaderRecordDto
					.setSubServiceType(StringUtil.leftJustify(memberSubService, StringUtil.SPACE_STRING, 10));

			visaAXSHeaderRecordDto
					.setBankMemberNumber(padLeftString(String.valueOf(outputFileEntity.getBankCode()), 4));

			String originator = Constants.ORIGINATOR;
			visaAXSHeaderRecordDto.setOriginator(StringUtil.leftJustify(originator, StringUtil.SPACE_STRING, 4));

			if (outputFileEntity.getSubService().equals("MASTERCARD")) {
				String fileName = filename.getFilename();
				visaAXSHeaderRecordDto.setFileName(StringUtil.leftJustify(fileName, StringUtil.SPACE_STRING, 8));
			}
			if ("VISA CARD".equals(outputFileEntity.getSubService())
					|| "DINERS".equals(outputFileEntity.getSubService())
					|| "AMEX".equals(outputFileEntity.getSubService())
					|| "FLEET".equals(outputFileEntity.getSubService())) {
				String fileName = filename.getFilename();
				visaAXSHeaderRecordDto.setFileName(StringUtil.leftJustify(fileName, StringUtil.SPACE_STRING, 8));
			}

			// getting the number of files for the day
			String fileNumber = filename.getFilename();
			visaAXSHeaderRecordDto
					.setFileNumber(StringUtil.leftJustify(fileNumber.substring(3, 7), StringUtil.SPACE_STRING, 4));

			String dataType = Constants.FILE_DATA_TYPE;
			visaAXSHeaderRecordDto.setDataType(StringUtil.leftJustify(dataType, StringUtil.SPACE_STRING, 4));

			String dataDirection = Constants.OUT_DATA_DIRECTION;
			visaAXSHeaderRecordDto.setDataDirection(StringUtil.leftJustify(dataDirection, StringUtil.SPACE_STRING, 3));

			String settlementDate = BsvTableLookup.getInstance().getProcessDate();
			visaAXSHeaderRecordDto
					.setSettlementDate(StringUtil.leftJustify(settlementDate, StringUtil.SPACE_STRING, 8));

			String liveIndicator = BsvTableLookup.getInstance().getSystemStatus();
			visaAXSHeaderRecordDto
					.setTestLiveIndicator(StringUtil.leftJustify(liveIndicator, StringUtil.SPACE_STRING, 4));

			String recordSize = Constants.RECORD_SIZE;
			visaAXSHeaderRecordDto.setRecordLength(StringUtil.leftJustify(recordSize, StringUtil.SPACE_STRING, 4));
			String destinationBank = "";
			visaAXSHeaderRecordDto.setDestinationBank(destinationBank);
			String filler = "";
			visaAXSHeaderRecordDto.setDestinationBank(padLeftString(outputFileEntity.getOriginatingBank(), 4));
			visaAXSHeaderRecordDto.setFiller(StringUtil.leftJustify(filler, StringUtil.SPACE_STRING, 101));

		} catch (Exception e) {
			log.error("Error in createAXSHeaderRecord() " + e);
		}
		return visaAXSHeaderRecordDto;
	}

	// Not used for now but reserved for future purposes.
	/*
	 * public List<FileTrailer91_92RecordDTO> createTrailor92Record() {
	 * 
	 * FileTrailer91_92RecordDTO fileTrailorDto = new
	 * FileTrailer91_92RecordDTO();
	 * 
	 * try {
	 * 
	 * VisaTCRTransactionsDTO dto = new VisaTCRTransactionsDTO();
	 * 
	 * String transactionCode = dto.getTransactionCode();
	 * 
	 * if (transactionCode == Constants.END_OF_BATCH_91 || transactionCode ==
	 * Constants.END_OF_BATCH_92);
	 * fileTrailorDto.setTransactionCode(StringUtil.leftJustify(transactionCode,
	 * StringUtil.SPACE_STRING, 2));
	 * 
	 * String tranCCodeQualifier = dto.getTranCodeQualifier();
	 * fileTrailorDto.setTranCodeQualifier
	 * (StringUtil.leftJustify(tranCCodeQualifier, StringUtil.ZERO_STRING, 1));
	 * 
	 * String tranSeqNo = dto.getTcrNumber();
	 * fileTrailorDto.setTcrNumber(StringUtil.leftJustify(tranSeqNo,
	 * StringUtil.ZERO_STRING, 1));
	 * 
	 * String bin = ""; fileTrailorDto.setBin(StringUtil.leftJustify(bin,
	 * StringUtil.ZERO_STRING, 6));
	 * 
	 * String processingDate = BsvTableLookup.getInstance().getProcessDate();
	 * fileTrailorDto.setProcessingDate(StringUtil.leftJustify(processingDate,
	 * StringUtil.ZERO_STRING, 5));
	 * 
	 * String destAmount = "";
	 * fileTrailorDto.setDestinationAmount(StringUtil.leftJustify(destAmount,
	 * StringUtil.ZERO_STRING, 15));
	 * 
	 * String moneyTransfer = "";
	 * fileTrailorDto.setNoOfMoneyTransfers(StringUtil
	 * .leftJustify(moneyTransfer, StringUtil.ZERO_STRING, 12));
	 * 
	 * String batchNumber = "";
	 * fileTrailorDto.setBatchNumber(StringUtil.leftJustify(batchNumber,
	 * StringUtil.ZERO_STRING, 6));
	 * 
	 * String numberOTCRs = "";
	 * fileTrailorDto.setNoOfTCRs(StringUtil.leftJustify(numberOTCRs,
	 * StringUtil.ZERO_STRING, 12));
	 * 
	 * String reserved1 = "";
	 * fileTrailorDto.setReserved1(StringUtil.leftJustify(reserved1,
	 * StringUtil.SPACE_STRING, 6));
	 * 
	 * String centreBatchInd = "";
	 * fileTrailorDto.setCentreBatchIndicator(StringUtil
	 * .leftJustify(centreBatchInd, StringUtil.SPACE_STRING, 8));
	 * 
	 * String noOfTransactions = "";
	 * fileTrailorDto.setNoOfTransactions(StringUtil
	 * .leftJustify(noOfTransactions, StringUtil.SPACE_STRING, 9));
	 * 
	 * String reserved2 = "";
	 * fileTrailorDto.setReserved2(StringUtil.leftJustify(reserved2,
	 * StringUtil.SPACE_STRING, 18));
	 * 
	 * String sourceAmount = "";
	 * fileTrailorDto.setSourceAmount(StringUtil.leftJustify(sourceAmount,
	 * StringUtil.ZERO_STRING, 13));
	 * 
	 * String filler = "";
	 * fileTrailorDto.setFiller(StringUtil.leftJustify(filler,
	 * StringUtil.SPACE_STRING, 52));
	 * 
	 * // this.visaFileDto.setFileCtrlTrailorDtoList(fileTrailorDto); //
	 * fileTrailer91_92RecordList.add(fileTrailorDto);
	 * 
	 * } catch (Exception e) { log.error("Error in createTrailor92Record() " +
	 * e.getMessage()); } // return fileTrailer91_92RecordList;
	 * 
	 * }
	 */

	// Creating of the File Trailer 98 records (Last file of the day)
	public static FileEOS98RecordDTO createEOS98Record(OutputFileEntityDTO outputFileEntity,Filename fileName, long numberOfFiles) {
		FileEOS98RecordDTO fileEOS98RecordDto = new FileEOS98RecordDTO();

		try {

			String recordID = Constants.EOS_98_RECID;
			fileEOS98RecordDto.setRecordId(recordID);
			String outputDate = BsvTableLookup.getInstance().getProcessDate();
			fileEOS98RecordDto.setOutputDate(outputDate);

			fileEOS98RecordDto.setServiceType(outputFileEntity.getService());

			String memberSubService = outputFileEntity.getSubService();
			fileEOS98RecordDto.setSubServiceType(memberSubService);

			String sTest = "00";
			fileEOS98RecordDto.setBankMemberNumber(padLeftString(sTest, 4));

			String noOfTransFiles = String.valueOf(numberOfFiles);
			fileEOS98RecordDto.setTransamissionFileCount(padLeftString(noOfTransFiles, 4));

			String noOfCredits = "";
			fileEOS98RecordDto.setCreditRecordCount(noOfCredits);

			fileEOS98RecordDto.setDebitRecordCount(String.valueOf(outputFileEntity.getRecordCountForDay()));

			String valueCreditRecs = "";
			fileEOS98RecordDto.setValueOfCreditRecords(valueCreditRecs);

			long valueDebitRecs = Long.valueOf(outputFileEntity.getDrValue());
			valueDebitRecs += valueDebitRecs;
			fileEOS98RecordDto
					.setValueOfDebitRecords(padLeftString(String.valueOf(outputFileEntity.getDrValueForDay()), 16));

			fileEOS98RecordDto.setHashTotalOfAccountNumber("");

			String filler = "";
			fileEOS98RecordDto.setFiller(filler);

		} catch (Exception e) {
			log.error("Error in createEOS98Record() " + e.getMessage());
		}
		return fileEOS98RecordDto;

	}

	// Creating of the file Trailer 99 Records
	public static FileAXSTrailorRecordDTO createEOF99Record(OutputFileEntityDTO outputFileEntity,Filename fileName) {

		FileAXSTrailorRecordDTO fileEOS99RecordDto = new FileAXSTrailorRecordDTO();

		try {

			String recordID = Constants.AXS_TRAILOR_RECID;
			fileEOS99RecordDto.setRecordId(recordID);
			String outputDate = BsvTableLookup.getInstance().getProcessDate();
			fileEOS99RecordDto.setOutputDate(outputDate);

			String serviceType = BsvTableLookup.getInstance().getSystemService();
			fileEOS99RecordDto.setServiceType(serviceType);

			String memberSubService = outputFileEntity.getSubService();
			fileEOS99RecordDto.setSubServiceType(memberSubService);

			fileEOS99RecordDto.setBankMemberNumber(padLeftString(String.valueOf(outputFileEntity.getBankCode()), 4));

			String noOfRecords = String.valueOf(outputFileEntity.getRecordCount());
			String pad = padLeftString(noOfRecords, 6);
			fileEOS99RecordDto.setNumberOfRecords(pad);

			String sourceID = "";
			fileEOS99RecordDto.setSourceIdentifier(sourceID);

			String encryptedWorkingKey = "";
			fileEOS99RecordDto.setEncryptedWorkingKey(encryptedWorkingKey);

			String macHashTotal = " ";
			fileEOS99RecordDto.setMacOfHashTotal(macHashTotal);

			long hashTotalAccNo = Long.valueOf(outputFileEntity.getHashTotal());
			fileEOS99RecordDto.setHashtotalOfAccountNumbers(padLeftString(String.valueOf(hashTotalAccNo), 16));

			String filler = "";
			fileEOS99RecordDto.setFiller(filler);

		} catch (Exception e) {
			log.error("Error in createEOF99Record() " + e.getMessage());
		}
		return fileEOS99RecordDto;
	}
   //refactored to use and generate the filename from the Cso_Seq_Number table
	public Filename nextNegativecardFilename(Long seqNum, OriginDestinationPair originDestinationPair,
			Long maxTransactionCount) {

		LastSeqNumberKey lastSeqNumberKey = new LastSeqNumberKey();
		String distributionCode = originDestinationPair.getDistributionCode();
		lastSeqNumberKey.setExternalFilenamePrefix(originDestinationPair.getFilenamePrefix());
		lastSeqNumberKey.setDistributionCode(distributionCode);

		Long seqNumber = null;
		try {
			seqNumber =  seqNum + 1;
			
		} catch (Exception e) {
			System.exit(1);
		}

		Filename filename = new Filename(
				originDestinationPair.getFilenamePrefix() + distributionCode + format("" + seqNumber, 3, '0', com.bsva.dmcs.fileextractv02.Justification.RIGHT) + "D",
				maxTransactionCount, 2L, seqNumber, 0L, 0.0, 0L, 0.0);
		
		//return the new Filename
		return filename;
	}

	public void flashFilenamesSeqNumberToOutputControls(Integer LastSeqNuber,String externalFileNamePrefix , String distributionCode,String subService) {

		try {
			// update
			SeqNumberKey SeqNumberKey = new SeqNumberKey(externalFileNamePrefix,distributionCode);
			Integer SeqNumber = LastSeqNuber + 1;
			SeqNumberEntity seqNumber = new SeqNumberEntity(SeqNumberKey,SeqNumber);
			seqNumbersDAO = new SeqNumbersDAO();
			//Update the Database table with the new sequence Number
			seqNumbersDAO.updateLastSeqNumbers(seqNumber.getSeqNumber(),seqNumber.getId().getFilenamePrefix(),seqNumber.getId().getDestDistCode());
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	public void flashFileNamesOutputToOutputControls(Integer LastSeqNuber,String externalFileNamePrefix , String distributionCode,String subService) {

		try {

			outputControlUpdateDAO.updateOutputControls(filenames);
			// reload
			filenames = new OutputControlDAO().filenames("CARD", subService);
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}

	/**
	 * @param s
	 * @param n
	 * @return
	 */
	// used to format String for FileWriter
	public static String padLeftString(String s, int n) {
		return String.format("%0$" + n + "s", s).replace(' ', '0');
	}
	//used to runthis report manually
	//Remember to umcomment this portion of Hibernate.cfg file  <!-- <property name="connection.datasource">java:jboss/datasources/DMCSDb</property> -->
	// Then enable the manual connection to the database. and verse versa. or you will get an error on the server that connection could not be establised. 
	public static void main(String[] args) {
		//You can run it , to generate the reports or you can debug it manually
		GenerateExtractedOutputFiles generateFiles = new GenerateExtractedOutputFiles();
		generateFiles.writeVisaFile();
	}
	//Used to format the Data
    public String format(String data, int len, char padChar, com.bsva.dmcs.fileextractv02.Justification justification) {
        if (data == null) {
            data = "x";
        }

        if (data.length() > len) {
            return data.substring(0, len);
        }

        StringBuilder sb = new StringBuilder("" + data);
        while (sb.length() < len) {
            if (justification == com.bsva.dmcs.fileextractv02.Justification.RIGHT) {
                sb.insert(0, padChar);
            } else {
                sb.append(padChar);
            }
        }
        return sb.toString();
    }

}
