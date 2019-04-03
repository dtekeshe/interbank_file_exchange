//package com.bsva.dmcs.fileloadv02.validators;
//
//import com.bsva.dmcs.fileloadv02.dto.*;
//import com.bsva.dmcs.fileloadv02.model.VISAFileHeader;
//import com.bsva.dmcs.fileloadv02.util.FileRejectedException;
//import com.bsva.dto.ErrorCode;
//import com.bsva.dto.ErrorDTO;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.*;
//
///**
// * TODO Document
// */
//public class VISAFileHeaderValidator {
//
//    // process date
//    private Date processDate;
//    private final String serviceID;
//    private final String subServiceID;
//    private final Map<Integer, Integer> memberCodes;
//    private final String validationCode;
//
//    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");
//
//    public VISAFileHeaderValidator( String serviceID,
//                                    String subServiceID,
//                                    Date processDate,
//                                    String validationCode,
//                                    Map<Integer, Integer> memberCodes ) {
//
//        this.serviceID = serviceID;
//        this.subServiceID = subServiceID;
//        this.memberCodes = memberCodes;
//        this.processDate = processDate;
//        this.validationCode = validationCode;
//    }
//
//    public boolean validate(String filename, VISAFileHeader header, List<ErrorDTO> errors)
//            throws FileRejectedException {
//
//        int originalErrorCount = errors.size();
//
//
//        Long lineID = 1L;
//
//        // validate service
//        if (! serviceID.equalsIgnoreCase(header.getServiceId()) ) {
//            errors.add(
//                    new ErrorDTO("01", 1L, 3, ErrorCode.SERVICE_ON_HEADER_INVALID.getName(), header.getServiceId()));
//        }
//
//        // validate process date
//        Long fileProcessDate = null;
//        try {
//            fileProcessDate = DATE_FORMAT.parse(header.getFileDate()).getTime();
//        } catch (ParseException e) {
//        }
//
//        if ( processDate.getTime() != fileProcessDate) {
//            errors.add(
//                    new ErrorDTO(
//                            "01", lineID, 2, ErrorCode.OUTPUT_DATE_NOT_EQ_PROCESS_DATE.getName(),
//                            header.getFileDate()));
//        }
//
//        // validate filename prefix against sub service
//        String filenamePrefix = filename.substring(0, 2);
//        if (! subServiceID.equalsIgnoreCase(header.getSubServiceId())) {
//            errors.add(
//                    new ErrorDTO("01", lineID, 7, ErrorCode.FILE_PREFIX_SUBSERV_INVALID.getName(),
//                            header.getSubServiceId()));
//        }
//
//        // validate validation code
//        if (! validationCode.equalsIgnoreCase(header.getValidationCode())) {
//            errors.add(
//                    new ErrorDTO("01", lineID, 6, ErrorCode.FILE_ORIGINATOR_INVALID.getName(),
//                            header.getValidationCode()));
//        }
//
//        // validate filename sequence
//        String actualFilenameSequence = filename.substring(3, 7);
//        String headerFilenameSequence = header.getFilename().substring(3, 7);
//       // System.out.println("Filename Sequence # validation. " +
//       //         "expected: " + actualFilenameSequence +
//       //         "header: " + headerFilenameSequence );
//        if (!actualFilenameSequence.equals(headerFilenameSequence)) {
//            errors.add( new ErrorDTO("01", lineID, 7,ErrorCode.HDR_FILE_NUMBER_NOT_EQUAL_FILENAME.getName(), null));
//        }
//
//        // validate filename
//       // System.out.println("Filename validation. " +
//       //         "expected: " + filename +
//       //         "header: " + header.getFilename() );
//        if (!filename.equals(header.getFilename())) {
//            errors.add( new ErrorDTO("01", lineID, 7, ErrorCode.HDR_FILENAME_NOT_EQUAL_FILENAME.getName(), null));
//        }
//
//        // validate file content type
//        FileContentType expectedContentType = FileContentType.DATA;
//        FileContentType headerContentType = FileContentType.fromType(header.getFileContentType());
//       // System.out.println("File content type validation. " +
//       //         " expected : " + expectedContentType +
//       //         " header : " + headerContentType );
//        if (expectedContentType != headerContentType ) {
//            errors.add( new ErrorDTO("01", lineID, 9, ErrorCode.DATA_TYPE_NOT_EQUAL_DATA.getName(), null));
//        }
//
//        FileDirection expectedDirection = FileDirection.IN;
//        FileDirection headerFileDirection = FileDirection.fromDirection(header.getFileDirection());
//       // System.out.println("File direction validation: " +
//       //         " expected : " + expectedDirection +
//       //         " header : " + headerFileDirection);
//        if ( expectedDirection != headerFileDirection ) {
//            errors.add(
//                    new ErrorDTO("01", lineID, 10, ErrorCode.DATA_DIRECTION_NOT_EQUAL_IN.getName(), null));
//        }
//
//        // validate environment
//        Environment expectedEnvironment = Environment.TEST;
//        Environment headerEnvironment = Environment.environment(header.getEnvironment());
//       // System.out.println("Environment validation." +
//       //         " expected: " + expectedEnvironment +
//       //         " header: " + headerEnvironment);
//        if ( expectedEnvironment != headerEnvironment ) {
//            errors.add(
//                    new ErrorDTO("01", lineID, 6, ErrorCode.ENVIRONMENT_INDICATOR_INCORRECT.getName(), null));
//        }
//
//       // System.out.println("Record length information validation: " +
//        //                    " expected: " + expectedRecordLength +
//        //                    " header: " + recordLength);
//
//        // validate originating member
//       // System.out.println("Originating member validation: " +
//       //                     "header: " + header.getOriginatingMemberId());
//        Integer memberBankCode = null;
//        try {
//            memberBankCode = Integer.parseInt(header.getOriginatingMemberId());
//            if (isValidMember(memberBankCode)) {
//                header.setOriginatorFullCode(memberCodes.get(memberBankCode));
//            } else {
//                errors.add( new ErrorDTO("01", lineID, 10, ErrorCode.FILE_ORIGINATOR_INVALID.getName(), null));
//            }
//        } catch (Exception e) {
//            errors.add( new ErrorDTO("01", lineID, 10, ErrorCode.FILE_ORIGINATOR_INVALID.getName(), null));
//        }
//
//
//
//        return ! hasMoreErrors(errors.size(), originalErrorCount);
//    }
//
//    private boolean isValidMember(Integer memberBankCode) {
//        return memberCodes.containsKey(memberBankCode);
//    }
//
//    private boolean hasMoreErrors(Integer errorCount, Integer originalErrorCount) {
//        return errorCount - originalErrorCount > 0;
//    }
//
//    private boolean isValidService(List<ServiceDTO> serviceList, String serviceId) {
//        for (ServiceDTO service : serviceList) {
//            if (service.getService().name().equalsIgnoreCase(serviceId)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private boolean isValidSubService(List<ServiceDTO> serviceList, String subServiceId) {
//        for (ServiceDTO service : serviceList) {
//            if (service.getSubService().name().equalsIgnoreCase(subServiceId)) {
//                return true;
//            }
//        }
//        return false;
//    }
//}
