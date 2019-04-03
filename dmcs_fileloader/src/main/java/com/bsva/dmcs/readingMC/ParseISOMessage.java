//package com.bsva.dmcs.readingMC;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.nio.charset.Charset;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.JAXBException;
//import javax.xml.bind.Unmarshaller;
//
//import org.jpos.iso.ISOException;
//import org.jpos.iso.ISOMsg;
//import org.jpos.iso.packager.GenericPackager;
//
//import com.bsva.dcms.commons.dto.CSFMemberServiceDTO;
//import com.bsva.dcms.commons.util.BsvTableLookup;
//
//public class ParseISOMessage {
//
//
//	  String data = "";
//	  Map<Integer, isofield> xmlFileMap = new HashMap<>();
//	  int bankCode= 0;
//	  String[] ebcdic = {
//	               	  "NUL", // Null
//	               	  "SOH", // Start of Heading
//	               	  "STX", // Start of Text
//	               	  "ETX", // End of Text
//	               	  "PF",  // Punch Off
//	               	  "\t",  // Horizontal Tab
//	               	  "LC",  // Lower Case
//	               	  "DEL", // Delete
//	               	  " ", " ",
//	               	  "SMM", // Start of Manual Message
//	               	  "",  // Vertical Tab
//	               	  "\f",  // Form Feed
//	               	  "CR",  // Carriage Return
//	               	  "SO",  // Shift Out
//	               	  "SI",  // Shift In
//	               	  "DLE", // Data Link Escape
//	               	  "DC1", // Device Control 1
//	               	  "DC2", // Device Control 2
//	               	  "TM",  // Tape Mark
//	               	  "RES", // Restore
//	               	  "\n",  // New Line
//	               	  "",  // Backspace
//	               	  "IL",  // Idle
//	               	  "CAN", // Cancel
//	               	  "EM",  // End of Medium
//	               	  "CC",  // Cursor Control
//	               	  "CU1", // Customer Use 1
//	               	  "IFS", // Interchange File Separator
//	               	  "IGS", // Interchange Group Separator
//	               	  "IRS", // Interchange Record Separator
//	               	  "IUS", // Interchange Unit Separator
//	               	  "DS",  // Digit Select
//	               	  "SOS", // Start of Significance
//	               	  "FS",  // Field Separator
//	               	  " ",
//	               	  "BYP", // Bypass
//	               	  "\n",  // Line Feed
//	               	  "ETB", // End of Transmission Block
//	               	  "ESC", // Escape
//	               	  " ", " ",
//	               	  "SM",  // Set Mode
//	               	  "CU2", // Customer Use 2
//	               	  " ",
//	               	  "ENQ", // Enquiry
//	               	  "ACK", // Acknowledge
//	               	  "BEL", // Bell
//	               	  " ", " ",
//	               	  "SYN", // Synchronous Idle
//	               	  " ",
//	               	  "PN",  // Punch On
//	               	  "RS",  // Reader Stop
//	               	  "UC",  // Upper Case
//	               	  "EOT", // End of Transmission
//	               	  " ", " ", " ",
//	               	  "CU3", // Customer Use 3
//	               	  "DC4", // Device Control 4
//	               	  "NAK", // Negative Acknowledge
//	               	  " ",
//	               	  "SUB", // Substitute
//	               	  " ", // Space
//	               	  " ", " ", " ", " ", " ", " ", " ", " ", " ",
//	               	  "¢", ".", "<", "(", "+", "|", "&",
//	               	      " ", " ", " ", " ", " ", " ", " ", " ", " ",
//	               	  "!", "$", "*", ")", ";", "¬", "-", "/",
//	               	  " ", " ", " ", " ", " ", " ", " ", " ", " ",
//	               	  ",", "%", "_", ">", "?",
//	               	  " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",
//	               	  ":", "#", "@", "\"","=", "\""," ",
//	               	  "a", "b", "c", "d", "e", "f", "g", "h", "i",
//	               	  " ", " ", " ", " ", " ", " ", " ",
//	               	  "j",  "k", "l", "m", "n", "o", "p", "q", "r",
//	               	  " ", " ", " ", " ", " ", " ", " ", " ",
//	               	  "s", "t", "u", "v", "w", "x", "y", "z",
//	               	  " ", " ", " ", " ", " ", " ", " ", " ",
//	               	  " ", " ", " ", " ", " ", " ", " ",
//	               	  "`", // Grave Accent
//	               	  " ", " ", " ", " ", " ", " ", " ",
//	               	  "A", "B", "C", "D", "E", "F", "G", "H", "I",
//	               	  " ", " ", " ", " ", " ", " ", " ",
//	               	  "J",  "K", "L", "M", "N", "O", "P", "Q", "R",
//	               	  " ", " ", " ", " ", " ", " ", " ", " ",
//	               	  "S", "T", "U", "V", "W", "X", "Y", "Z",
//	               	  " ", " ", " ", " ", " ", " ",
//	               	  "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
//	               	  " ", " ", " ", " ", " ", " "
//	  };
//
//	  public static void main(String[] args){
//
//		try{
//			ParseISOMessage pisom = new ParseISOMessage();
////			pisom.parseIsoMessage();
//			pisom.readXml();
//			pisom.parseIsoMessage3();
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//	}
//
////   String data="0200B2200001001000000000000000800000201234000000010000011072218012345610000506A5DFGR021ABCDEFGHIJ 1234567890";
////	 String data="0200B2200000001000000000000000800000201234000000010000011072218012345606A5DFGR021ABCDEFGHIJ 1234567890";
////	 String data="02003000000000000000201234000000010000011072218012345606A5DFGR021ABCDEFGHIJ 1234567890";
//
////	 String data="020030000000000000006970800122001T01100250021507160000000683201794019100120105025002150716000000068320179400000001";
//
//	public void readXml(){
//
//		try {
//			JAXBContext jaxbContext = JAXBContext.newInstance(isopackager.class);
//			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//
//			File xmlFile = new File("basic2.xml");
//			isopackager ip = (isopackager)jaxbUnmarshaller.unmarshal(xmlFile);
//			ArrayList<isofield> isoFieldList = ip.getIsoFieldList();
//
//			for(isofield field : isoFieldList){
//				xmlFileMap.put(new Integer(field.getId()), field);
//			}
//
//		} catch (JAXBException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
//
////    public void parseIsoMessage() throws IOException, ISOException , FileNotFoundException{
////
////
////    	BufferedReader  br = new BufferedReader(new FileReader("c://Users/MboniN//Desktop//data//MC"));
////    	String line = "";
////    	while ( (line = br.readLine()) != null){
////    		data = line;
////    	}
////
////        // Create Packager based on XML that contain DE type
////    	GenericPackager packager = new GenericPackager("basic2.xml");
////        System.out.println("Data to unpack : " + data);
////
////        // Create ISO Message
////        ISOMsg isoMsg = new ISOMsg();
////        isoMsg.setPackager(packager);
////
////        isoMsg.unpack(data.getBytes());
////
////        // print the DE list
////        logISOMsg(isoMsg);
////    }
//
//
//  public void parseIsoMessage3() throws IOException, ISOException , FileNotFoundException{
//
//
//	File file = new File("c://Users/MboniN//Desktop//data//CCN0004D");
//	FileInputStream fis = new FileInputStream(file);
//	byte[] fileInBytes = new byte[(int)file.length()];
//	fis.read(fileInBytes);
//
////	bankCode = 10;
//
//	//remove header and trailor
////	byte[] bytes = new byte[fileInBytes.length];
////	bytes = Arrays.copyOfRange(fileInBytes, getHeaderStartIndex(), getTrailorStartIndex(fileInBytes));
////
////	int len1 = fileInBytes.length;
////	int len2 = bytes.length;
////
////	String mboni = new String(bytes);
////
////    // Create Packager based on XML that contain DE type
//	GenericPackager packager = new GenericPackager("basic2.xml");
////    System.out.println("Data to unpack : " + mboni);
////
////    // Create ISO Message
//    ISOMsg isoMsg = null;
////
////    do{
//    	//read from the prescribed record_read_start_byte
////    	bytes = readFromStartByte(bytes, bankCode);  // remove those control characters if present
////    	mboni = new String(bytes);
//
//    	isoMsg = new ISOMsg();
//        isoMsg.setPackager(packager);
//        isoMsg.unpack(fileInBytes);
//
//        logISOMsg(isoMsg);
////
////        bytes = logISOMsg3(isoMsg , bytes);
////        mboni = new String(bytes);
////    	System.out.println("next Data to unpack : " + mboni);
////    }while(bytes.length > 1);
//
//}
//
//   public void parseIsoMessage2() throws IOException, ISOException , FileNotFoundException{
//
//
////    	BufferedReader  br = new BufferedReader(new FileReader("c://Users/MboniN//Desktop//data//MC"));
////	   BufferedReader  br = new BufferedReader(new FileReader("c://Users/MboniN//Desktop//data//CCN0002D"));
////	   BufferedReader  br = new BufferedReader(new FileReader("c://Users/MboniN//Desktop//data//CCN0004D"));
////	   BufferedReader  br = new BufferedReader(new FileReader("c://Users/MboniN//Desktop//data//space.txt"));
//	   BufferedReader  br = new BufferedReader(new FileReader("c://Users/MboniN//Desktop//data//CCN0003D"));//:TODO to change
//    	String line = "";
//    	while ( (line = br.readLine()) != null){
//    		data += line;
//    	}
//    	br.close();
////    	byte[] something = data.substring(4,17).getBytes("Cp037");
////    	System.out.println(new String(something));
//
////    	InputStreamReader rr = new InputStreamReader(new FileInputStream("c://Users/MboniN//Desktop//data//CCN0005D"));
//////    	InputStreamReader rr = new InputStreamReader(new FileInputStream("c://Users/MboniN//Desktop//data//mastercard//CCA0001D") , "Cp500"); // for EBCDIC input
////    	int ll = 0;
////    	int count =0;
////    	String mboni= "";
////    	while( (ll = rr.read()) != -1){
////    		try{
////    			System.out.println( ll + ":" + (char)ll);
////    			mboni += (char)ll;
////    		}catch(Exception e){
////    			System.out.println((char)ll);
////    		}
////    	}
//
//    	String filename = "CCN0002D";
//    	//bankCode = BsvTableLookup.getInstance().getCsfMembersByTapeId().get(filename.substring(2,4)).getBankCode();
//    	bankCode = 10;
//
//    	//remove header and trailor
////    	data = data.substring(getHeaderStartIndex() , getTrailorStartIndex(data));
//
//        // Create Packager based on XML that contain DE type
//    	GenericPackager packager = new GenericPackager("basic2.xml");
//        System.out.println("Data to unpack : " + data);
//
//        // Create ISO Message
//        ISOMsg isoMsg = null;
//
//        // print the DE list
//        do{
//        	//read from the prescribed record_read_start_byte
////        	data = readFromStartByte(data, bankCode);  // remove those control characters if present
//
//        	isoMsg = new ISOMsg();
//            isoMsg.setPackager(packager);
//            isoMsg.unpack(data.getBytes());
//
//        	data = logISOMsg2(isoMsg , data);
//        	System.out.println("next Data to unpack : " + data);
//        }while(data.length() > 1);
//    }
//
//
//    private String logISOMsg2(ISOMsg msg , String readData) {
//        System.out.println("----Unpacked ISO MESSAGE-----");
//
//        int processedCharsCount = 0;
//
//        try {
//            System.out.println("  MTI : " + msg.getMTI());
//            for (int i = -1; i <= msg.getMaxField(); i++) {
//                if (msg.hasField(i)) {
//
//                	System.out.println("    Field-" + i + " : " + msg.getString(i));
//
//                	//get the bitmap length
//                	if (i ==  -1)
//                		processedCharsCount += 16;
//
//                	isofield isoF = xmlFileMap.get(new Integer(i));
//                	if (isoF != null){
//
//                		String length = isoF.getLength();
//
//                		if (length.equals("99")){  // additional data length
//                			processedCharsCount += 2;
//                			processedCharsCount += msg.getString(i).length();
//                		}else if (length.equals("999")){ //additional data length
//                			processedCharsCount += 3;
//                			processedCharsCount += msg.getString(i).length();
//                		}else{   // preset length
//                			processedCharsCount += msg.getString(i).length();
//                		}
//
//                	}
//                }
//            }
//        } catch (ISOException e) {
//            e.printStackTrace();
//        } finally {
//            System.out.println("--------------------");
//        }
//
//        return readData.substring(processedCharsCount);
//    }
//
//    private byte[] logISOMsg3(ISOMsg msg , byte[] b) {
//        System.out.println("----Unpacked ISO MESSAGE-----");
//
//        byte[] newB = new byte[b.length];
//        String mboni = new String(b);
//        int processedCharsCount = 0;
//
//        try {
//            System.out.println("  MTI : " + msg.getMTI());
//            for (int i = -1; i <= msg.getMaxField(); i++) {
//                if (msg.hasField(i)) {
//
//                	System.out.println("    Field-" + i + " : " + msg.getString(i));
//
//                	//get the bitmap length
//                	if (i ==  -1)
//                		processedCharsCount += 16;
//
//                	isofield isoF = xmlFileMap.get(new Integer(i));
//                	if (isoF != null){
//
//                		String length = isoF.getLength();
//                		String class_ = isoF.getClass_();
//
//                		if (class_.equals("org.jpos.iso.IFA_LLCHAR") || class_.equals("org.jpos.iso.IFA_LLNUM")){  // additional data length
//                			processedCharsCount += 2;
//                			processedCharsCount += msg.getString(i).length();
//                		}else if (class_.equals("org.jpos.iso.IFA_LLLCHAR")){ //additional data length
//                			processedCharsCount += 3;
//                			processedCharsCount += msg.getString(i).length();
//                		}else{   // preset length
//                			processedCharsCount += msg.getString(i).length();
//                		}
//
////                		if (length.equals("99")){  // additional data length
////                			processedCharsCount += 2;
////                			processedCharsCount += msg.getString(i).length();
////                		}else if (length.equals("999")){ //additional data length
////                			processedCharsCount += 3;
////                			processedCharsCount += msg.getString(i).length();
////                		}else{   // preset length
////                			processedCharsCount += msg.getString(i).length();
////                		}
//
//                	}
//                }
//            }
//        } catch (ISOException e) {
//            e.printStackTrace();
//        } finally {
//            System.out.println("--------------------");
//        }
//
////        return readData.substring(processedCharsCount);
//        System.arraycopy(b, processedCharsCount, newB, 0, b.length - processedCharsCount);
//
//        return newB;
//
//    }
//
//
//    public int getHeaderStartIndex(){
//
////    	int recordReadStartByte = BsvTableLookup.getInstance().getCsfMasterCardOptions().get(String.valueOf(bankCode)).getRecordReadStartByte();
//    	int recordReadStartByte = 4;
//
//    	CSFMemberServiceDTO myMemberService =  null;
//    	List<CSFMemberServiceDTO> memberServiceList = BsvTableLookup.getInstance().getCsfMemberService();
//    	for(CSFMemberServiceDTO memberService : memberServiceList){
//
//    		if (memberService.getSubService().equals("MASTERCARD") && memberService.getBankCode() == bankCode){
//    			myMemberService = memberService;
//    			break;
//    		}
//    	}
//
//    	int headerLength = myMemberService.getHeader01RecordLength();
//    	return recordReadStartByte + headerLength;
//    }
//
//    public int getTrailorStartIndex(byte[] b){
//
//    	String data = new String(b);
////    	int recordReadStartByte = BsvTableLookup.getInstance().getCsfMasterCardOptions().get(String.valueOf(bankCode)).getRecordReadStartByte();
//    	int recordReadStartByte = 4;
////    	String processDate = BsvTableLookup.getInstance().getProcessDate();
//    	String processDate = "20150716";
//    	int trailorStartIndex = data.indexOf("99" + processDate + "CARDMCI");
//
//    	return trailorStartIndex - recordReadStartByte;
//    }
//
//    public byte[] readFromStartByte(byte[] b , int bankCode){
//
//    	byte[] newB = new byte[b.length];
//
////    	int recordReadStartByte = BsvTableLookup.getInstance().getCsfMasterCardOptions().get(String.valueOf(bankCode)).getRecordReadStartByte();
//    	int recordReadStartByte = 4;
//
//    	System.arraycopy(b, recordReadStartByte, newB, 0, b.length - recordReadStartByte);
//
//    	return newB;
//
//    }
//    private static void logISOMsg(ISOMsg msg) {
//        System.out.println("----Unpacked ISO MESSAGE-----");
//
//        try {
//
//            System.out.println("  MTI : " + msg.getMTI());
//            for (int i = -1; i <= msg.getMaxField(); i++) {
//                if (msg.hasField(i)) {
//                    System.out.println("    Field-" + i + " : " + msg.getString(i));
//
//                    /*
//                     * TODO:
//                     * pass the entire string after removing the header - string x
//                     * add the lengths of msg.getString(i), remove those items from x
//                     * then process the remaing x after removing above...until you reach the trailor
//                     * find a way to chop off the trailor
//                     */
//                }
//            }
//        } catch (ISOException e) {
//            e.printStackTrace();
//        } finally {
//            System.out.println("--------------------");
//        }
//    }
//
//
//}
