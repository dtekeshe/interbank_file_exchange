//package com.bsva.dmcs.fileloadv02.validators;
//
//import com.bsva.dmcs.fileloadv02.dto.ErrorDTO;
//
//import java.io.IOException;
//import java.util.List;
//
//public class VISAFileValidator implements Validator {
//
//    private final String path;
//    private final static int VISA_RECORD_LENGTH = 170;
//    public final static String[] VISA_EXPECTED_HEADER_IDS;
//    public final static String[] VISA_EXPECTED_TRAILER_IDS;
//
//    static {
//        VISA_EXPECTED_HEADER_IDS = new String[]{"01"};
//        VISA_EXPECTED_TRAILER_IDS = new String[]{"92", "98", "99"};
//    }
//    // TODO Inject
//    private FileStructureVerification fileStructureVerification;
//
//    public VISAFileValidator(String path) {
//        this.path = path;
//
//        fileStructureVerification = new FileStructureVerification();
//    }
//
//    @Override
//    public void validateFileStructure(String filename, List<ErrorDTO> errors) throws IOException {
//
//        fileStructureVerification.verify(
//                    path, VISA_RECORD_LENGTH, VISA_EXPECTED_HEADER_IDS, VISA_EXPECTED_TRAILER_IDS, filename,  errors);
//    }
//
//    @Override
//    public String toString() {
//        return "VISAFileValidator{}";
//    }
//}
