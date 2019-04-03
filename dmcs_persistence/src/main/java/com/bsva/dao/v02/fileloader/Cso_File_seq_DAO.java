package com.bsva.dao.v02.fileloader;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.loader.CsoFileSeqEntity;

public class Cso_File_seq_DAO extends AbstractDao<CsoFileSeqEntity, Void> {

	private final static String FILENAME_SEQ_SQL =

			" SELECT FILE_NAME, FILE_SEQUENCE  FROM CSO_FILE_SEQ  WHERE FILE_NAME =:fileName ";

	private final static String GET_FILENAME_SEQ_SQL =

			" SELECT FILE_SEQUENCE, FILE_NAME FROM CSO_FILE_SEQ ";

	private final static String FILE_SEQ_SQL = " INSERT INTO CSO_FILE_SEQ (FILE_NAME, FILE_SEQUENCE)  VALUES ( :fileName, :fileSequence )";

	private final static String LAST_SEQ_NUMBERS_UPDATE_SQL = " UPDATE CSO_FILE_SEQ  SET FILE_SEQUENCE = :fileSequence WHERE FILE_NAME = :filename ";

	public List<CsoFileSeqEntity> getFileNames() {

		// execute
		List<CsoFileSeqEntity> entities = list(GET_FILENAME_SEQ_SQL, CsoFileSeqEntity.class);

		// prepare result
		/*
		 * Map<String, String> prefixes = new HashMap<>(); for (CsoFileSeqEntity entity : entities) {
		 * prefixes.put(entity.getFileName(), String.valueOf(entity.getFileSequence())); }
		 */

		return entities;
	}

	public List<CsoFileSeqEntity> selectFileNames(String fileName) {

		// prepare params
		Map<String, Object> params = new HashMap<>();
		params.put("fileName", fileName);

		// execute
		List<CsoFileSeqEntity> entities = list(FILENAME_SEQ_SQL, params, CsoFileSeqEntity.class);

		// prepare result

		return entities;
	}

	// Used to insert a new record to the Cso_SeqNumber Table
	public void insertFileName(Collection<CsoFileSeqEntity> fileSeqNumbers) {

		// prepare params
		List<Map<String, Object>> payload = new ArrayList<>();
		for (CsoFileSeqEntity seqNumber : fileSeqNumbers) {
			Map<String, Object> params = new HashMap<>();
			params.put("fileName", seqNumber.getFileName());
			params.put("fileSequence", Integer.valueOf(seqNumber.getFileSequence()));
			payload.add(params);
		}

		// execute
		executeUpdate(FILE_SEQ_SQL, payload);
	}

	// Used to update lastSeqNumber Used in the Cso_seqNumber.
	public void updateLastFileSeqNumbersUsed(Integer fileSequence, String filename) {

		// update if exists
		Map<String, Object> params = new HashMap<>();
		params.put("fileSequence", fileSequence);
		params.put("filename", filename);

		int num = executeUpdate(LAST_SEQ_NUMBERS_UPDATE_SQL, params);

	}


}
