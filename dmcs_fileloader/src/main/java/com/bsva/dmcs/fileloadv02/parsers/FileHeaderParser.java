package com.bsva.dmcs.fileloadv02.parsers;

import com.bsva.dao.v02.ProgramControlsDAO;
import com.bsva.dao.v02.SystemParametersDAO;
import com.bsva.dmcs.fileloadv02.dto.FileFooterDto;
import com.bsva.dmcs.fileloadv02.dto.SubService;
import com.bsva.dmcs.fileloadv02.model.FileDetailDTO;
import com.bsva.dmcs.fileloadv02.model.MemberInfoBean;
import com.bsva.dmcs.fileloadv02.util.SystemConfigurationException;
import com.bsva.dto.*;
import com.bsva.entities.v02.params.SystemParametersEntity;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

import static com.bsva.dmcs.reportv02.util.StringUtils.parseInt;
import static com.bsva.dto.ErrorCode.*;
import static com.bsva.dmcs.reportv02.util.StringUtils.substring;

/**
 * TODO Document
 */
public class FileHeaderParser extends TxnRecordParser {

    private Date processDate;
    private final boolean isPublicHoliday;
    private String processDateString;
    private long recordCount;
    private final String serviceID;
    private final String subServiceID;
    private final Set<Integer> memberBankCodes;
    private final String validationCode;
    private final Environment environment;

    private final static Map<String, String> SUB_SERVICE_NAME_NORMALISER;
    static {
        SUB_SERVICE_NAME_NORMALISER = new HashMap<>();
        SUB_SERVICE_NAME_NORMALISER.put("MASTERCARD", "MASTERCARD");
    }

    public FileHeaderParser(Date processDate,
                            Boolean isPublicHoliday,
                            String serviceID,
                            String subServiceID,
                            Set<Integer> memberBankCodes,
                            String validationCode,
                            Environment environment
                            ) {

        this.processDate = processDate;
        this.isPublicHoliday = isPublicHoliday;
        this.processDateString = new SimpleDateFormat("yyyMMdd").format(processDate);
        this.serviceID = serviceID;
        this.subServiceID = subServiceID;
        this.memberBankCodes = memberBankCodes;
        this.validationCode = validationCode;
        this.environment = environment;
    }

    public void parse( FileHeaderDTO header,
                       String filename,
                       String line,
                       List<ErrorDTO> errors,
                       ProgramControlsDAO programControlsDAO,
                       boolean isReload)
            throws SystemConfigurationException {

        int initErrorCount = errors.size();

        // FileHeaderDTO header = new FileHeaderDTO();
        SystemParametersEntity systemParametersEntity = new SystemParametersDAO().systemParameters();
        this.processDate = systemParametersEntity.getProcessDate();
        this.processDateString = new SimpleDateFormat("yyyMMdd").format(this.processDate);

        if (line == null) {
            error(errors, null, 1L, HEADER_RECORD_NOT_FIRST_REC, 1, null);
            return;
        }
        header.setInput(line);
        header.setInputLength(line.length());

        // line record id
        String s = substring(line, 0, 2 );
        
        if ( "01".equals(s)) {
            header.setRecordID(1);
        } else {
            error(errors, null, 1L, HEADER_RECORD_NOT_FIRST_REC, 1, s);
        }

        // process date
        header.setFileDate(processDate);
        s = substring(line, 2, 10 );
        if (! processDateString.equals(s)) {
            error(errors, null, 1L, OUTPUT_DATE_NOT_EQ_PROCESS_DATE, 2, s );
        }

        // service
        s = substring(line, 10, 14);
        if (serviceID.equals(s)) {
            header.setServiceID(serviceID);
        } else {
            error(errors, null, 1L, SERVICE_ON_HEADER_INVALID, 3, s);
        }

        // sub service
        s = substring(line, 14, 24 ).trim();
        String normalizedName = SUB_SERVICE_NAME_NORMALISER.get(s);
        if (exists(normalizedName)) {
            s = normalizedName;
        }
        if (subServiceID.equals(s)) {
            header.setSubServiceID(subServiceID);
        } else {
            error(errors, null, 1L, SUB_SERVICE_INVALID, 4, s);
        }

        // originator id
        Integer i = parseInt(line, 24, 28);
        if (memberBankCodes.contains(i)) {
            header.setOriginatorID(i);
        } else {
            error(errors, null, 1L, FILE_ORIGINATOR_INVALID, 5, "" + i);
        }

        // validation code
        s = substring(line, 28, 32 );
        if (validationCode.equals(s)) {
            header.setValidationCode(s);
        } else {
            error(errors, null, 1L, FILE_ORIGINATOR_INVALID, 6, s);
        }

        // filename
        s = substring(line, 32, 40 );
        if (filename.equals(s)) {
            header.setFilename(filename);
        } else {
            error(errors, null, 1L, HDR_FILE_NUMBER_NOT_EQUAL_FILENAME, 6, s);
        }

        // destination id

        // content type
        s = substring(line, 44, 48 );
        if ("DATA".equals(s)) {
            header.setContentType(ContentType.DATA);
        } else {
            error(errors, null, 1L, DATA_TYPE_NOT_EQUAL_DATA, 6, s);
        }

        // direction
        s = substring(line, 48, 50 );
        if ("IN".equals(s)) {
            header.setDirection(Direction.IN);
        } else {
            error(errors, null, 1L, DATA_DIRECTION_NOT_EQUAL_IN, 6, s);
        }

        // environment
        s = substring(line, 59, 63 );
        if (environment.name().equals(s)) {
            header.setEnvironment(environment);
        } else {
            error(errors, null, 1L, ENVIRONMENT_INDICATOR_INCORRECT, 6, s);
        }

        // has loader already processed this file?
        if (! isReload) {
            boolean programAlreadyRun
                    = programControlsDAO.programAlreadyRun("LOADER", subServiceID, filename);
            if (programAlreadyRun) {
                throw new SystemConfigurationException("PROCESS LOADER ALREADY STARTED FOR FILENAME: " + filename);
            }
        }
        // status
        boolean isValid = ! hasErrors(initErrorCount, errors.size());
        header.setStatus(isValid ? (isPublicHoliday ? "H" : "C") : "R");

        //return header;
    }
    

    public void parseFooter( 
    		           FileFooterDto footer,
                       String filename,
                       String line,
                       List<ErrorDTO> errors,
                       ProgramControlsDAO programControlsDAO,
                       boolean isReload,
                       Long counter,
                       Long count99Rec)
            throws SystemConfigurationException {
    	this.recordCount = counter;
        int initErrorCount = errors.size();

        // FileHeaderDTO header = new FileHeaderDTO();
        SystemParametersEntity systemParametersEntity = new SystemParametersDAO().systemParameters();
        this.processDate = systemParametersEntity.getProcessDate();
        this.processDateString = new SimpleDateFormat("yyyMMdd").format(this.processDate);

        if (line == null) {
            error(errors, null, 1L, TRAILER_RECORD_NOT_LAST_REC, 1, null);
            return;
        }

        // line record id
        String s = substring(line, 0, 2 );
        
        String fs = substring(line,0,2);
        
      if ( "99".equals(fs)) {
        if ( "99".equals(fs)) {
            footer.setRecordId(fs);
        } else {
            error(errors, null, 1L, TRAILER_RECORD_NOT_LAST_REC, 1, s);
        }

        //footer processdate
        footer.setOutputDate(processDate);
        s = substring(line, 2, 10 );
        if (! processDateString.equals(s)) {
            error(errors, null, 1L, TRAILER_DATE_NOT_PROCESS_DATE, 2, s );
        }

        // service
        s = substring(line, 10, 14);
        if (serviceID.equals(s)) {
            footer.setService(serviceID);
        } else {
            error(errors, null, 1L, SERVICE_ON_FOOTER_INVALID, 3, s);
        }

        // sub service
        s = substring(line, 14, 24 ).trim();
        String normalizedName = SUB_SERVICE_NAME_NORMALISER.get(s);
        if (exists(normalizedName)) {
            s = normalizedName;
        }
        if (subServiceID.equals(s)) {
            footer.setSubService(subServiceID);
        } else {
            error(errors, null, 1L, SUB_SERVICE_INVALID, 4, s);
        }
        s = substring(line,28,34);//changed to fix error on trailer record
        if(recordCount == Long.valueOf(s)){
        	footer.setCounterNumber(""+recordCount);
        }else{
        	error(errors,null,1L,FOOTER_COUNT_NOT_RECORD_COUNT,5,s);
        }
        if(count99Rec != 0){
        	
        }else{
        	error(errors,null,1L,RECORD_99_NOT_FOUND_IN_FILE,5,s);
        }
        
      }
      // status
      boolean isValid = ! hasErrors(initErrorCount, errors.size());
      footer.setStatus(isValid ? (isPublicHoliday ? "H" : "C") : "R");

    }
    

    @Override
    public FileDetailDTO parse( AtomicLong fileSeqNumber,
                                AtomicLong txnSeqNumber,
                                String line,
                                Long lineID,
                                MemberInfoBean memberInfoBean,
                                SubService subService,
                                List<ErrorDTO> errors) {
        return null;
    }

    private boolean exists(String input) {
        return input != null;
    }
}
