//package com.bsva.dmcs.fileloadv02.util;
//
//import com.bsva.dto.ErrorCode;
//import com.bsva.dmcs.fileloadv02.dto.ErrorDTO;
//import com.bsva.dmcs.fileloadv02.dto.ReportHeader;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.PrintWriter;
//import java.text.SimpleDateFormat;
//import java.util.Map;
//
///**
// * TODO Document
// */
//public class XMLMarshaller {
//
//    private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");
//
//    public static String marshallReportHeader(ReportHeader reportHeader) {
//
//        StringBuilder sb = new StringBuilder();
//
//        sb.append("<reportContent>\n");
//        sb.append("\t<companyName>");
//        sb.append(reportHeader.getCompanyName());
//        sb.append("</companyName>\n");
//        sb.append("\t<CompanyRegNumber>");
//        sb.append(reportHeader.getCompanyRegNumber());
//        sb.append("</CompanyRegNumber>\n");
//        sb.append("<\tprocessDate>");
//        sb.append(DATE_FORMAT.format(reportHeader.getProcessDate()));
//        sb.append("</processDate>\n");
//        sb.append("\t<service>");
//        sb.append(reportHeader.getServiceID());
//        sb.append("</service>\n");
//        sb.append("\t<subService>");
//        sb.append(reportHeader.getSubServiceID());
//        sb.append("</subService>\n");
//        sb.append("\t<bsvFileName>");
//        sb.append(reportHeader.getFilename());
//        sb.append("</bsvFileName>\n");
//        sb.append("\t<fileRejections>\n");
//        return sb.toString();
//    }
//
//    public static String marshall(ErrorDTO errorDTO) {
//
//        StringBuilder sb = new StringBuilder();
//
//        sb.append("\t\t<recordID>");
//        sb.append("" + errorDTO.getRecordID());
//        sb.append("</recordID>\n");
//        sb.append("\t\t<recordNumber>");
//        sb.append("" + errorDTO.getRecordNumber());
//        sb.append("</recordNumber>\n");
//        sb.append("\t\t<errorDescription>");
//        sb.append("" + errorDTO.getErrorDescription());
//        sb.append("</errorDescription>\n");
//        sb.append("\t\t<fieldNumber>");
//        sb.append("" + errorDTO.getFieldNumber());
//        sb.append("</fieldNumber>\n");
//        sb.append("\t\t<content>");
//        sb.append("" + errorDTO.getContent());
//        sb.append("</content>\n");
//
//        return sb.toString();
//    }
//
//    public static String marshallEndOfReportDetails(){
//
//        StringBuilder sb = new StringBuilder();
//
//        sb.append("\t</fileRejections>");
//
//        return sb.toString();
//    }
//
//    public static String marshallReportMessage(){
//
//        StringBuilder sb = new StringBuilder();
//
//        sb.append("\t<reportMessage>");
//        sb.append("ERRORS PRINTED EXCEEDS 100 - VALIDATION WILL CONTINUE");
//        sb.append("</reportMessage>\n");
//
//        return sb.toString();
//    }
//
//    public static String marshallFileStatsTotals(Map<String, Long> fileStatsTotals) {
//
//        StringBuilder sb = new StringBuilder();
//
//        sb.append("\t<totAccDrVol>");
//        sb.append("" + Counter.numberOfDebits);
//        sb.append("</totAccDrVol>\n");
//
//        sb.append("\t<totAccDrVal>");
//        sb.append("" + Counter.debitValue);
//        sb.append("</totAccDrVal>\n");
//
//        sb.append("\t<totRejDrVol>");
//        sb.append("" + Counter.numberOfRejectedDebits);
//        sb.append("</totRejDrVol>\n");
//
//        sb.append("\t<totRejDrVal>");
//        sb.append("" + Counter.debitRejectedValue);
//        sb.append("</totRejDrVal>\n");
//
//        sb.append("\t<totAccCrVol>");
//        sb.append("" + Counter.numberOfRecs);
//        sb.append("</totAccCrVol>\n");
//
//        sb.append("\t<totAccCrVal>");
//        sb.append("" + Counter.creditValue);
//        sb.append("</totAccCrVal>\n");
//
//        sb.append("\t<totRejCrVol>");
//        sb.append("" + Counter.numberOfRejectedCredits);
//        sb.append("</totRejCrVol>\n");
//
//        sb.append("\t<totRejCrVal>");
//        sb.append("" + Counter.creditRejectedValue);
//        sb.append("</totRejCrVal>\n");
//
//        sb.append("\t<totAccFinRecs>");
//        sb.append("" + fileStatsTotals.get("totAccFinRecs"));
//        sb.append("</totAccFinRecs>\n");
//
//        sb.append("\t<totRejFinRecs>");
//        sb.append("" + fileStatsTotals.get("totRejFinRecs"));
//        sb.append("</totRejFinRecs>\n");
//
//        sb.append("\t<totAccNonFinRecs>");
//        sb.append("" + fileStatsTotals.get("totAccNonFinRecs"));
//        sb.append("</totAccNonFinRecs>\n");
//
//        sb.append("\t<totRejNonFinRecs>");
//        sb.append("" + fileStatsTotals.get("totRejNonFinRecs"));
//        sb.append("</totRejNonFinRecs>\n");
//
//        sb.append("\t<totNegativeRecords>");
//        sb.append("" + fileStatsTotals.get("totNegativeRecords"));
//        sb.append("</totNegativeRecords>\n");
//
//        sb.append("\t<totControlRecords>");
//        sb.append("" + fileStatsTotals.get(""));
//        sb.append("</totControlRecords>\n");
//
//        sb.append("\t<totAcceptedRecs>");
//        sb.append("" + fileStatsTotals.get("totAcceptedRecs"));
//        sb.append("</totAcceptedRecs>\n");
//
//        sb.append("\t<totRejectedRecs>");
//        sb.append("" + fileStatsTotals.get("totRejectedRecs"));
//        sb.append("</totRejectedRecs>\n");
//
//
//        return sb.toString();
//    }
//
//    public static String marshallEndOfReport(){
//
//        StringBuilder sb = new StringBuilder();
//
//        sb.append("\t</reportContent>");
//
//        return sb.toString();
//    }
//
//
//    public static void main(String[] args) {
//
//        PrintWriter out = null;
//        try {
//
//            out = new PrintWriter(new File("c:\\\\tana54\\\\ccc\\\\csr23.xml"));
//            Long startedAt = System.currentTimeMillis();
//            XMLMarshaller writer = new XMLMarshaller();
//
//            ErrorDTO errorDTO = new ErrorDTO(5, 1222L, 4, ErrorCode.TRAN_CODE_DOES_NOT_EXIST.getName(), null);
//
//            for (int idx = 0; idx < 1000000;++idx) {
//                String xml = writer.marshall(errorDTO);
//                out.println(xml + "\n");
//
//                if (idx % 50000 == 0) {
//                    System.out.println("INSERTED " + idx + " RECS.");
//                }
//            }
//            System.out.println("took : " + ((System.currentTimeMillis() - startedAt) / 1000) + " seconds");
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            try{out.flush();}catch (Exception e){}
//            try{out.close();}catch (Exception e){}
//        }
//    }
//
//}
