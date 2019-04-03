package com.bsva.dmcs.fileloadv02.parsers;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.util.HashMap;
import java.util.Map;

import com.bsva.commonsv02.util.SPOLogger;
import com.bsva.dao.v02.DirectoryDAO;
import com.bsva.dao.v02.LastSeqNumbersDAO;
import com.bsva.dcms.commons.dao.CSFMembersServiceDAO;
import com.bsva.dcms.commons.dto.CSFMemberServiceDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.dmcs.fileloadv02.GenerateDelDelReports;
import com.bsva.entities.v02.loader.LastSeqNumberKey;
import com.bsva.entities.v02.startofday.DefaultOutputFileEntity;
import com.bsva.entities.v02.startofday.DefaultOutputFileKey;

public class EndOfDayFileCopy {

	private static final String SEND_FOLDER;

	private static final String REPORT_FOLDER;

	private static final String RECEIVE = "C:\\tana54\\ccc\\receive\\";

	private static CSFMemberServiceDTO memberNo;

	private static CSFMemberServiceDTO fromContact;

	private static CSFMemberServiceDTO toContact;

	private static Map<LastSeqNumberKey, Long> lastSeqNumberUsed;

	private static int counter = 0;
	protected final static Map<String, String> SUB_SERVICE_MNEMONICS;
	static {
		SUB_SERVICE_MNEMONICS = new HashMap<>();
		SUB_SERVICE_MNEMONICS.put("VISA CARD", "V");
		SUB_SERVICE_MNEMONICS.put("MASTERCARD", "M");
		SUB_SERVICE_MNEMONICS.put("DINERS", "D");
		SUB_SERVICE_MNEMONICS.put("AMEX", "A");
		SUB_SERVICE_MNEMONICS.put("FLEET CARD", "F");
	}
	
	//Used to get the Folders Directories
	static {

		Map<String, String> paths = new DirectoryDAO().directories();
		REPORT_FOLDER = paths.get("REPORTS");
		SEND_FOLDER = paths.get("SEND");
	}
	//Used to do a local testing
	public static void main(String[] args) throws IOException {
		/*
		 * BufferedReader in = new BufferedReader(new FileReader("C:\\tana54\\ccc\\receive\\CVD0001D")); String line =
		 * null; while ((line = in.readLine()) != null) { String fileLine = line;
		 * 
		 * }
		 */
		// copyReceiveFileToSendFolder();
	}

	@SuppressWarnings({ "unused" })
	private static void copyFiles(File source, File dest,String subServiceID) throws IOException {
		String fileLine = null;
		String strHold = null;
		String strHold1 = null;
		String holdremainder = null;
		String filenameprefix = null;
		File[] files = source.listFiles();
		File destination;
		File original;
		if (files != null && files.length > 0) {
			for (File file : files) {
				if (file.isFile()) {
					String filename = file.getName();
					String fileMnemonicName = filename.substring(6,7);
					String subServiceName = SUB_SERVICE_MNEMONICS.get(subServiceID);
					//check for CCR001 and CCR005 files , Rename and move them SEND folder
					if ((filename.startsWith("CCR001") || filename.startsWith("CCR005")) && (fileMnemonicName.equals(subServiceName))) {
						String destFile = file.getName().substring(1);
						String mnemonicName = destFile.substring(5, 6);
						String sourceFile = file.getName();

						destination = new File(dest + File.separator + destFile);
						original = new File(source + File.separator + sourceFile);

						BufferedReader in = new BufferedReader(new FileReader(original));

						String line = null;
						while ((line = in.readLine()) != null) {
							strHold = line;
							break;
						}
						BufferedReader br1 = new BufferedReader(new FileReader(original));
						String line1 = br1.readLine();

						for (int i = 1; i <= 10 && line1 != null; i++) {
							line1 = br1.readLine();
						}

						String toFile = line1.substring(6, 29);
						fromContact = getContactName(toFile);
						String fromFile = line1.substring(74);
						toContact = getContactName(fromFile);

						String destFilename = destination.getName();
						String nameFile = destFilename.substring(7);

						fileLine = strHold.substring(0, 32);
						holdremainder = strHold.substring(44);
						lastSeqNumberUsed = new LastSeqNumbersDAO().lastSeqNumbers();
						
						LastSeqNumberKey LastSeqKey = new LastSeqNumberKey();
						if (filename.startsWith("CCR001")) {
							LastSeqKey.setDistributionCode(fromContact.getMemberTapeid());
						}
						else {
							LastSeqKey.setDistributionCode(toContact.getMemberTapeid());
						}
						LastSeqKey.setExternalFilenamePrefix("CR");
						Long numberOfCount = 0l;
						
						for(Map.Entry<LastSeqNumberKey, Long> entry : lastSeqNumberUsed.entrySet()){
							if(entry.getKey().equals(LastSeqKey)){
								numberOfCount = entry.getValue();
							}
						}
						Long lookupKey = lastSeqNumberUsed.get(LastSeqKey);
						//int keyvalue = lastSeqNumberUsed.values().size();
						String fixName1;
						File newDestFielName ;
						int inrementCounter = increment(numberOfCount.intValue());
						if (lookupKey != null) {
							fixName1 = fileLine + "CR" + LastSeqKey.getDistributionCode()
									+ padLeftString("0" + inrementCounter + lookupKey.longValue(), 3) + "D"
									+ padLeftString("0" + inrementCounter + lookupKey.longValue(), 3) + holdremainder
									+ mnemonicName;
							newDestFielName = new File(dest + File.separator +"CR" + LastSeqKey.getDistributionCode()+ padLeftString("0" + inrementCounter, 3) + "D");
						}
						else {

							fixName1 = fileLine + "CR" + LastSeqKey.getDistributionCode()
									+ padLeftString("0" + inrementCounter, 3) + "D"
									+ padLeftString("0" + inrementCounter, 3) + holdremainder
									+ mnemonicName;
							newDestFielName = new File(dest + File.separator +"CR" + LastSeqKey.getDistributionCode()+ padLeftString("0" + inrementCounter, 3) + "D");
						}
					     
						System.out.println(fixName1);
						strHold = fixName1;
						try {
							File fileData = new File(source + "\\" + destFilename);
							RandomAccessFile raf = new RandomAccessFile(original, "rw");
							raf.seek(0L);
							raf.write(fixName1.getBytes());
							raf.close();

							if (filename.startsWith("CCR001")) {
								DefaultOutputFileEntity defaultOutputFile = new DefaultOutputFileEntity();
								DefaultOutputFileKey defaultOutputKey = new DefaultOutputFileKey();
								defaultOutputFile.setDestBankID(fromContact.getMemberTapeid());
								defaultOutputFile.setOriginBankID(String.valueOf(toContact.getMemberTapeid()));
								defaultOutputKey.setServiceID("CARD");
								defaultOutputKey.setSubServiceID("REPORTS");
								defaultOutputKey.setDestBankCode(Integer.valueOf(fromContact.getBankCode()).intValue());
								defaultOutputKey.setOriginBankCode(Integer.valueOf(toContact.getBankCode()).intValue());
								defaultOutputFile.setId(defaultOutputKey);
								GenerateDelDelReports generateDelDelReports = new GenerateDelDelReports();
								generateDelDelReports.setSeqNumbers(defaultOutputFile, inrementCounter);
							}
							else {
								DefaultOutputFileEntity defaultOutputFile = new DefaultOutputFileEntity();
								DefaultOutputFileKey defaultOutputKey = new DefaultOutputFileKey();
								defaultOutputFile.setDestBankID(toContact.getMemberTapeid());
								defaultOutputFile.setOriginBankID(String.valueOf(fromContact.getMemberTapeid()));
								defaultOutputKey.setServiceID("CARD");
								defaultOutputKey.setSubServiceID("REPORTS");
								defaultOutputKey.setDestBankCode(Integer.valueOf(toContact.getBankCode()).intValue());
								defaultOutputKey.setOriginBankCode(Integer.valueOf(fromContact.getBankCode()).intValue());
								defaultOutputFile.setId(defaultOutputKey);
								GenerateDelDelReports generateDelDelReports = new GenerateDelDelReports();
								generateDelDelReports.setSeqNumbers(defaultOutputFile, inrementCounter);
							}

						}
						catch (Exception ex) {
							System.out.println("Error occured : " + ex.getMessage());
							ex.printStackTrace();
						}

						try {
							destination.renameTo(newDestFielName);
							copyfromOriginalToDestination(newDestFielName, original);
						}
						catch (NoSuchFileException nex) {
							nex.printStackTrace();
						}
					}
				}
			}
		}
	}
	//Used to copy files from RECEIVED folder to SEND folder
	private static void copyfromOriginalToDestination(File destination, File original) throws IOException {
		Files.copy(FileSystems.getDefault().getPath(original.getAbsolutePath()),
				FileSystems.getDefault().getPath(destination.getAbsolutePath()), REPLACE_EXISTING);
	}
	//Used to copy Files from sorce to dest
	public void copyReceiveFileToSendFolder(String subServiceID) {

		String sendPath = SEND_FOLDER;
		String reportpath = REPORT_FOLDER;
		File reportspath = new File(reportpath);
		File send = new File(sendPath);
		try {
			try {
				copyFiles(reportspath, send,subServiceID);
			}
			catch (NumberFormatException nex) {
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}
	 // Used to format Seqnumbers.
	public static String padLeftString(String s, int n) {
		return String.format("%0$" + n + "s", s).replace(' ', '0');
	}
	//Used to get member Numbers from CSFMemberService
	private static CSFMemberServiceDTO getMemberNo(String memberNo) {

		CSFMemberServiceDTO parmObject = new CSFMemberServiceDTO();
		parmObject.setMemberNo(memberNo);
		try {

			CSFMemberServiceDTO returnedObject = new CSFMembersServiceDAO().retrieve(parmObject);

			if (returnedObject != null) {

				return returnedObject;

			}

		}
		catch (DAOException e) {
			e.printStackTrace();
		}
		return null;
	}
	//used to get Member Contects from Csf_Members_service Table
	private static CSFMemberServiceDTO getContactName(String contact) {

		CSFMemberServiceDTO parmObject = new CSFMemberServiceDTO();
		String strContact = contact.substring(0);
		String strContact1 = strContact.replaceAll("\\s{2,}", " ").trim();
		parmObject.setContactName(strContact1);
		try {

			CSFMemberServiceDTO returnedObject = new CSFMembersServiceDAO().retrieve(parmObject);

			if (returnedObject != null) {

				return returnedObject;

			}

		}
		catch (DAOException e) {
			e.printStackTrace();
		}
		return null;
	}
	//Used to do counter Increment
	public static int increment(int increment) {

		increment = increment + 1;
		counter = increment;
		return increment;
	}
}
