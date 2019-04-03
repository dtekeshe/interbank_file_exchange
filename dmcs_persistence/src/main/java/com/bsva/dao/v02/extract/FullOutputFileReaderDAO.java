package com.bsva.dao.v02.extract;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.extract.FullOutputFileEntity;

import java.util.List;

/**
 * TODO Document
 */
public class FullOutputFileReaderDAO extends AbstractDao<FullOutputFileEntity, Void> {

	private String FULL_OUTPUT_FILES_SQL =

			" SELECT SUB_SERVICE AS SUB_SERVICE ID, " +
            "        FILENAME_DESCRIPTION, FILENAME_PREFIX                                                          " +
			"   FROM CSO_OUTPUT_CONTROLS_V2                                                                         " +
			"  WHERE FULLFILEIND = 'F'                                                                              ";

    /**
     * TODO Document
     * @return
     */
    public List<FullOutputFileEntity> getOutputFiles() {

        // execute
        List<FullOutputFileEntity> outputFiles
                = list(FULL_OUTPUT_FILES_SQL, FullOutputFileEntity.class);

        return outputFiles;
    }
}
