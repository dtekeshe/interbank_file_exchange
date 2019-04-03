//package com.bsva.dmcs.fileLoad.masterCard.mappings;
//
//import java.io.File;
//import org.apache.log4j.Logger;
//import org.beanio.BeanReader;
//import org.beanio.InvalidRecordException;
//import org.beanio.StreamFactory;
//
///**
// *
// * @author SimphiweT
// */
//public class MasterCardUtil {
//
//    private File dataFile;
//    private Boolean switch1644 = false;
//    private EOS1644Header eOS1644Header = null;
//    private EOS1644Trailer eOS1644Trailer = null;
//
//    private Logger log = Logger.getLogger(MasterCardUtil.class);
//
//    public EOSHeader getEOSHeader(StreamFactory factory) {
//
//        Object record = null;
//        EOSHeader eOSHeader = null;
//
//        BeanReader reader = factory.createReader("recordEOSHeaderStream", dataFile);
//        while ((record = reader.read()) != null) {
//            if (record.toString().startsWith("01")) {
//                eOSHeader = (EOSHeader) record;
//                break;
//            }
//        }
//        reader.close();
//        return eOSHeader;
//    }
//
//    public EOS1644Header getEOS1644Header(StreamFactory factory) {
//
//        Object record = new String();
//
//        BeanReader reader = factory.createReader("recordEOS1644HeaderStream", dataFile);
//        ignoreRecord(reader);
//
//        eOS1644Header = new EOS1644Header();
//
//        try {
//            while ((record = reader.read()) != null) {
//                if (("" + record).startsWith("00") && "697".equals(("" + record).substring(313, 316))) {
//                    eOS1644Header = (EOS1644Header) record;
//                    switch1644 = true;
//                    eOS1644Header.setP24_FunctionCode(("" + record).substring(313, 316));
//                    geteOS1644Header().setP24_FunctionCode(eOS1644Header.getP24_FunctionCode());
//                    break;
//                }
//            }
//        } catch (InvalidRecordException ex) {
//            log.debug("<<<<<<<< 1644 HEADER RECORD ENCOUNTERED >>>>>>>>>");
//        }
//
//        reader.close();
//        return eOS1644Header;
//    }
//
//    public EOS1644Trailer getEOS1644Trailer(StreamFactory factory) {
//
//        Object record = null;
//        eOS1644Trailer = new EOS1644Trailer();
//
//        BeanReader reader = factory.createReader("recordEOS1644TrailerStream", dataFile);
//
//        ignoreRecords(reader);
//        try {
//            while ((record = reader.read()) != null) {
//                if (("" + record).startsWith("00") && "695".equals(("" + record).substring(313, 316))) {
//                    eOS1644Trailer = (EOS1644Trailer) record;
//                    eOS1644Trailer.setP24_FunctionCode(("" + record).substring(313, 316));
//                    geteOS1644Trailer().setP24_FunctionCode(eOS1644Trailer.getP24_FunctionCode());
//                    break;
//                }
//            }
//        } catch (InvalidRecordException ex) {
//            log.debug("<<<<<<<< 1644 TRAILER RECORD ENCOUNTERED >>>>>>>>>");
//        }
//        reader.close();
//        return eOS1644Trailer;
//    }
//
//    public EOS98Trailer getEOS98Trailer(StreamFactory factory) {
//
//        Object record = null;
//        EOS98Trailer eOS98Trailer = new EOS98Trailer();
//
//        BeanReader reader = factory.createReader("recordEOS98TrailerStream", dataFile);
//
//        ignoreRecords(reader);
//
//        try {
//            //TODO use substring to pick 98
//            while ((record = reader.read()) != null) {
//                if (("" + record).startsWith("00") && "695".equals(("" + record).substring(313, 316))) {
//                    //eOS98Trailer = (EOS98Trailer) record;
//                    break;
//                }
//            }
//        } catch (InvalidRecordException ex) {
//            log.debug("<<<<<<<< 98 TRAILER RECORD ENCOUNTERED >>>>>>>>>");
//        }
//
//        reader.close();
//        return eOS98Trailer;
//    }
//
//    public EOS98Trailer getRealEOS98Trailer(StreamFactory factory) {
//
//        Object record = null;
//        EOS98Trailer eOS98Trailer = new EOS98Trailer();
//
//        BeanReader reader = factory.createReader("recordEOS98TrailerStream", dataFile);
//
//        ignoreRecords(reader);
//
//        try {
//            //TODO use substring to pick 98
//            while ((record = reader.read()) != null) {
//                if (("" + record).startsWith("98")) {
//                    eOS98Trailer = (EOS98Trailer) record;
//                    break;
//                }
//            }
//        } catch (InvalidRecordException ex) {
//            log.debug("<<<<<<<< 98 TRAILER RECORD ENCOUNTERED >>>>>>>>>");
//        }
//
//        reader.close();
//        return eOS98Trailer;
//    }
//
//    public EOS99Trailer getEOS99Trailer(StreamFactory factory) {
//
//        Object record = new Object();
//        EOS99Trailer eOS99Trailer = new EOS99Trailer();
//
//        BeanReader reader = factory.createReader("recordEOS99TrailerStream", dataFile);
//        ignoreRecords(reader);
//
//        try {
//            //TODO use substring to pick 99
//            while ((record = reader.read()) != null) {
//                if (record.toString().startsWith("99")) {
//                    eOS99Trailer.setRecordEntry(record.toString());
//                    break;
//                }
//            }
//        } catch (RuntimeException ex) {
//            log.debug("<<<<<<<< 99 TRAILER RECORD ENCOUNTERED >>>>>>>>>" + record.toString());
//        }
//
//        reader.close();
//        return eOS99Trailer;
//    }
//
//    public void ignoreRecord(BeanReader reader) {
//        try {
//            reader.read();
//        } catch (InvalidRecordException ex) {
//            log.debug("1 RECORD IGNORED - HEADER OR TRAILER ENCOUNTERED");
//        }
//    }
//
//    public void ignoreRecords(BeanReader reader) {
//        try {
//            reader.read();
//            reader.read();
//        } catch (InvalidRecordException ex) {
//            log.debug("2 RECORD IGNORED - HEADER OR TRAILER ENCOUNTERED");
//        }
//    }
//
//    public File getDataFile() {
//        return dataFile;
//    }
//
//    public void setDataFile(File dataFile) {
//        this.dataFile = dataFile;
//    }
//
//    public EOS1644Header geteOS1644Header() {
//        return eOS1644Header;
//    }
//
//    public void seteOS1644Header(EOS1644Header eOS1644Header) {
//        this.eOS1644Header = eOS1644Header;
//    }
//
//    public EOS1644Trailer geteOS1644Trailer() {
//        return eOS1644Trailer;
//    }
//
//    public void seteOS1644Trailer(EOS1644Trailer eOS1644Trailer) {
//        this.eOS1644Trailer = eOS1644Trailer;
//    }
//
//
//
//    public Boolean doControlRecordChecks(StreamFactory factory) {
//
//        try {
//            String trailer = getEOS1644Header(factory).getRecordEntry();
//
//            if (trailer != null) {
//                switch1644 = true;
//            } else {
//                switch1644 = false;
//            }
//        } catch (RuntimeException rx) {
//            log.debug(rx.getMessage());
//        }
//        return switch1644;
//    }
//}
