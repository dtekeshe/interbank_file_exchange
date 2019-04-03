package com.bsva.dao.v02.startofday;

import com.bsva.dao.AbstractDao;
import com.bsva.dao.v02.util.DatabaseException;
import com.bsva.entities.v02.startofday.DefaultOutputFileEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO Document
 */
public class DefaultOutputFilesDAO extends AbstractDao<DefaultOutputFileEntity, Void> {

	private final static String DEFAULT_OUTPUT_FILE_INSERT_SQL =

			"   INSERT INTO CSO_OUTPUT_CONTROLS (                                                                   "
					+ "           SERVICE, SUB_SERVICE, BANK_CODE, DISTRIBUTION_CODE,                                         "
					+ "           ORIGINATING_MEMBER, ORIGINATING_BANK_ID,                                                    "
					+ "           FILENAME_PREFIX, FILENAME_DESCRIPTION, SEQ_NUMBER,                                          "
					+ "           RECORD_COUNT, LAST_FILE_INDICATOR, NEG_CARD_COUNT, FULLFILEIND )                            "
					+ "   VALUES (                                                                                            "
					+ "           :serviceID, :subServiceID, :destBankCode, :destBankID,                                      "
					+ "           :originBankCode, :originBankID,                                                             "
					+ "           :filenamePrefix, :filenameDescription, :seqNumber,                                          "
					+ "           :recordCount, :lastFileIndicator, :negativeCardCount,  :fullFileInd )                       ";

	/**
	 * TODO Document
	 */
	public void createDefaultOutputFiles() throws DatabaseException {

		// read default output files from database view wrapper
		List<DefaultOutputFileEntity> defaultOutputFiles = new DefaultOutputFilesView().defaultOutputFiles();

		// prepare params
		List<Map<String, Object>> paramsList = new ArrayList<>();
		for (DefaultOutputFileEntity file : defaultOutputFiles) {

			Map<String, Object> params = new HashMap<>();
			params.put("serviceID", file.getId().getServiceID());
			params.put("subServiceID", file.getId().getSubServiceID());
			params.put("destBankCode", file.getId().getDestBankCode());
			params.put("originBankCode", file.getId().getOriginBankCode());
			params.put("destBankID", file.getDestBankID());
			params.put("originBankID", file.getOriginBankID());
			params.put("filenamePrefix", file.getId().getFilenamePrefix());
			params.put("filenameDescription", file.getId().getFilenameDescription());
			params.put("seqNumber", padLeft(String.valueOf(file.getId().getSeqNumber()), 3));
			params.put("recordCount", 0);
			params.put("lastFileIndicator", "N");
			params.put("negativeCardCount", 0);
			params.put("fullFileInd", "D");

			paramsList.add(params);
		
		}
			// execute
			executeUpdate(DEFAULT_OUTPUT_FILE_INSERT_SQL, paramsList);
			
	}
	
	public void createSingleDefaultOutputFiles(DefaultOutputFileEntity outPutFile) throws DatabaseException {

		// read default output files from database view wrapper
		// preparing params
			Map<String, Object> params = new HashMap<>();

			params.put("serviceID", outPutFile.getId().getServiceID());
			params.put("subServiceID", outPutFile.getId().getSubServiceID());
			params.put("destBankCode", outPutFile.getId().getDestBankCode());
			params.put("originBankCode", outPutFile.getId().getOriginBankCode());
			params.put("destBankID", outPutFile.getDestBankID());
			params.put("originBankID", outPutFile.getOriginBankID());
			params.put("filenamePrefix", (outPutFile.getId().getFilenamePrefix() == null ? "CR":outPutFile.getId().getFilenamePrefix()));
			params.put("filenameDescription", outPutFile.getId().getFilenameDescription());
			params.put("seqNumber", padLeft(String.valueOf(outPutFile.getId().getSeqNumber()), 3));
			params.put("recordCount", 0);
			params.put("lastFileIndicator", "N");
			params.put("negativeCardCount", 0);
			params.put("fullFileInd", "D");
		
			// execute
			executeUpdate(DEFAULT_OUTPUT_FILE_INSERT_SQL, params);
			
	}
	public void createSingleDefaultOutputFilesCCR009(DefaultOutputFileEntity outPutFile) throws DatabaseException {

		// read default output files from database view wrapper
		// preparing params
			Map<String, Object> params = new HashMap<>();

			params.put("serviceID", outPutFile.getId().getServiceID());
			params.put("subServiceID", outPutFile.getId().getSubServiceID());
			params.put("destBankCode", outPutFile.getId().getDestBankCode());
			params.put("originBankCode", outPutFile.getId().getOriginBankCode());
			params.put("destBankID", outPutFile.getDestBankID());
			params.put("originBankID", outPutFile.getOriginBankID());
			params.put("filenamePrefix", (outPutFile.getId().getFilenamePrefix() == null ? "CR":outPutFile.getId().getFilenamePrefix()));
			params.put("filenameDescription", outPutFile.getId().getFilenameDescription());
			params.put("seqNumber", padLeft(String.valueOf(outPutFile.getId().getSeqNumber()), 3));
			params.put("recordCount", 0);
			params.put("lastFileIndicator", "N");
			params.put("negativeCardCount", 0);
			params.put("fullFileInd", "D");
		
			// execute
			executeUpdate(DEFAULT_OUTPUT_FILE_INSERT_SQL, params);
			
	}

	public static void main(String[] args) {
		DefaultOutputFilesDAO defaultOutputFilesView = new DefaultOutputFilesDAO();
		try {
			defaultOutputFilesView.createDefaultOutputFiles();

		}
		catch (DatabaseException e) {
			e.printStackTrace();
		}
	}

	public static String padLeft(String s, int n) {
		return String.format("%1$" + n + "s", s).replace(' ', '0');
	}
}
