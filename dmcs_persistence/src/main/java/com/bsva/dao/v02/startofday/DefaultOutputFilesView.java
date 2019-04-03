package com.bsva.dao.v02.startofday;

import com.bsva.dao.AbstractDao;
import com.bsva.dao.v02.util.DatabaseException;
import com.bsva.dto.Justification;
import com.bsva.entities.v02.startofday.DefaultOutputFileEntity;
import com.bsva.entities.v02.startofday.DefaultOutputFileKey;
import com.bsva.entities.v02.startofday.SeqNumberEntity;
import com.bsva.entities.v02.startofday.SeqNumberKey;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static com.bsva.dao.v02.util.StringUtils.format;

/**
 * TODO Document
 */
public class DefaultOutputFilesView extends AbstractDao<DefaultOutputFileEntity, Void> {

    // Metadata
    private final static String PROCESS_NAME = "SODAY";
    private final static String VERSION = "20";

    private final static String DEFAULT_OUTPUT_FILENAMES_SQL =

            " SELECT SERVICE AS SERVICE_ID, SUB_SERVICE AS SUB_SERVICE_ID,                                      " +
            "           DEST_BANK_CODE, DEST_BANK_ID,                                                           " +
            "           ORIGINATING_BANK AS ORIGIN_BANK_CODE, ORIGINATING_ID AS ORIGIN_BANK_ID,                 " +
            "           FILENAME_PREFIX                                                                         " +
            "   FROM CSV_DEFAULT_FILES_VIEW                                                                     " +
            "  ORDER BY SERVICE, SUB_SERVICE,DEST_BANK_CODE,ORIGINATING_BANK                                    ";

    /**
     * TODO Document
     * @return
     */
    @SuppressWarnings("unchecked")
	public List<DefaultOutputFileEntity> defaultOutputFiles()
                throws DatabaseException {

        // execute
        spolog("READING FROM CSV_DEFAULT_FILES_VIEW");
        List<DefaultOutputFileEntity> defaultOutputFiles
                = list(DEFAULT_OUTPUT_FILENAMES_SQL, DefaultOutputFileEntity.class);
        spolog("READ " + safeSize(defaultOutputFiles) + " DEFAULT FILES.");

        // set sequences number and filename description
        spolog("SETTING SEQ NUMBERS TO DEFAULT FILES");
        List<DefaultOutputFileEntity> defaultListData = setSeqNumbers(defaultOutputFiles);
        spolog("DEFAULT FILES READ SUCCESSFULLY.");
       //List<DefaultOutputFileEntity> listData = defaultOutputFiles.stream().distinct().collect(Collectors.toList());
        return  defaultListData;
    }

    /**
     * Set sequence numbers to a list of files
     *
     * @param files
     */
    protected List<DefaultOutputFileEntity> setSeqNumbers(List<DefaultOutputFileEntity> files) {

        // group files by destination bank
    	List<DefaultOutputFileEntity> defaultList = new ArrayList<>();
        Map<SeqNumberKey, SeqNumberEntity> destBanks = new HashMap<>();
        for ( DefaultOutputFileEntity file: files ) {

            // create key
            SeqNumberKey key
                    = new SeqNumberKey(file.getId().getFilenamePrefix(), file.getDestBankID());

            SeqNumberEntity seqNumberForThisBank = destBanks.get(key);
            if (seqNumberForThisBank == null) {
                seqNumberForThisBank = new SeqNumberEntity(key, 0);
            }

            // increment seq number
            seqNumberForThisBank.incrementSeqNumber();
            file.getId().setSeqNumber(seqNumberForThisBank.getSeqNumber());
            destBanks.put(key, seqNumberForThisBank);

            // construct filename
            String filename
                    = file.getId().getFilenamePrefix() +
                    file.getDestBankID() +
                    format("" + seqNumberForThisBank.getSeqNumber(), 3, '0', Justification.RIGHT) +
                    "D";
            file.getId().setFilenameDescription(filename);
            
            DefaultOutputFileEntity defaultEntity = new DefaultOutputFileEntity();
            
            defaultEntity.setDestBankID(file.getDestBankID());
            defaultEntity.setOriginBankID(file.getOriginBankID());
            
            DefaultOutputFileKey defaultFileKey = new DefaultOutputFileKey();
            defaultFileKey.setDestBankCode(file.getId().getDestBankCode());
            defaultFileKey.setFilenameDescription(file.getId().getFilenameDescription());
            defaultFileKey.setOriginBankCode(file.getId().getOriginBankCode());
            defaultFileKey.setSeqNumber(file.getId().getSeqNumber());
            defaultFileKey.setServiceID(file.getId().getServiceID());
            defaultFileKey.setSubServiceID(file.getId().getSubServiceID());
            defaultFileKey.setFilenamePrefix(file.getId().getFilenamePrefix());
            defaultEntity.setId(defaultFileKey);
            
            defaultList.add(defaultEntity);
            
        }

        // save last seq numbers
        Collection<SeqNumberEntity> seqNumbers
                        = destBanks.values();
        
        new SeqNumbersDAO().insert(seqNumbers);
        
        return defaultList;
        
    }

    /**
     * TODO Move to Util
     * @return
     */
    public static Integer safeSize(List<DefaultOutputFileEntity> defaultOutputFiles)
                throws DatabaseException {
        try {
            return defaultOutputFiles.size();
        } catch (Exception e) {
            throw new DatabaseException("FAILED TO COUNT DEFAULT FILES.", null);
        }
    }

    public void spolog(String message) {

        // spoLog.log(PROCESS_NAME, VERSION, message);
        System.out.println(PROCESS_NAME + " " + VERSION + " " + message);
    }
    
   
}
