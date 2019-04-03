package com.bsva.dmcs.fileloadv02.indexer;

import com.bsva.dmcs.fileloadv02.dto.FileFooterDto;
import com.bsva.dmcs.fileloadv02.util.FileRejectedException;
import com.bsva.dmcs.fileloadv02.util.SystemConfigurationException;
import com.bsva.dto.ErrorDTO;
import com.bsva.dto.FileHeaderDTO;

import java.io.IOException;
import java.util.List;

/**
 * Create an index file for each input file before loading.
 * - Reads the next id from indexes_table and lock it
 * - VISA File Indexer
 *   - Stamp each financial transaction record with id and increment it
 *   - Stamp each payment instruction record with parent id
 * - Update next id on indexes_table and unlock it
 */
public interface FileIndexer {

    /**
     * Indexing
     *
     * TODO exception handling
     *
     * @param filename
     * @throws SystemConfigurationException
     */
    void index(String filename,
               FileHeaderDTO header,
               FileFooterDto footer,
               List<ErrorDTO> errors,
               boolean isReload)
            throws IOException, FileRejectedException, SystemConfigurationException;

//    /**
//     * Prints a vet report
//     *
//     * @param filename
//     * @param header
//     * @param errors
//     * @throws FileNotFoundException
//     */
//    void printVetReport(String filename, FileHeaderDTO header, List<ErrorDTO> errors)
//            throws FileNotFoundException;
     TxnRecordWriter getTxnRecordWriter();
}
