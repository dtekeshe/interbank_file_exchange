package com.bsva.dao.v02.extract;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.loader.FileDetailEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO Document
 */
public class PaymentDetailsDAO extends AbstractDao<FileDetailEntity, Void> {

	private final String mciFilePrefix;

	/**
	 * TODO Document
	 *
	 * @param mciFilePrefix
	 */
	public PaymentDetailsDAO( String mciFilePrefix) {

		this.mciFilePrefix = mciFilePrefix;
	}

	private final static String PAYMENT_DETAIL_MCI_SQL =

			" 		SELECT CARD_TRANSACTION 												 	 				" +
			"    	  FROM CSO_PAYMENT_INSTRUCT_MCARD_V2														" +
			"   	 WHERE FILENAME_DESCRIPTION = :filename 													" +
			" 	  ORDER BY SYSTEM_GEN_SEQ_NUMBER																";

	private final static String PAYMENT_DETAIL_VISA_SQL =

            " 		SELECT CARD_TRANSACTION 												 	 				" +
            "    	  FROM CSO_PAYMENT_INSTRUCT_VISA_V2														 	" +
            "   	 WHERE FILENAME_DESCRIPTION = :filename 													" +
            " 	  ORDER BY SYSTEM_GEN_SEQ_NUMBER																";


	/**
	 * TODO Document
	 *
	 * @param filename
	 * @return
	 */
    public List<FileDetailEntity> getFileDetailsFor( String filename ) {

    	// preparing params
    	Map<String, Object> params = new HashMap<>();
    	params.put("filename", filename);

		// select sql
		String sql = filename.startsWith(mciFilePrefix)
							? PAYMENT_DETAIL_MCI_SQL
								: PAYMENT_DETAIL_VISA_SQL;
        // execute
    	List<FileDetailEntity> fileDetails
                = list( sql, params, FileDetailEntity.class );

        return fileDetails;
    }
}
