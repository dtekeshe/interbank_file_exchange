package com.bsva.dmcs.fileloadv02.model;

import com.bsva.dmcs.fileloadv02.dto.SubService;
import com.bsva.dmcs.fileloadv02.indexer.FileIndexer;

/**
 * TODO Document
 */
public class ServiceType {

    private final SubService subService;
    private final FileIndexer fileIndexer;
    private final String fileLoaderScript;

    public ServiceType( SubService subService,
                        FileIndexer fileIndexer,
                        String fileLoaderScript) {

        this.subService = subService;
        this.fileIndexer = fileIndexer;
        this.fileLoaderScript = fileLoaderScript;
    }

    public SubService getSubService() {
        return subService;
    }

    public FileIndexer getFileIndexer() {
        return fileIndexer;
    }

    public String getFileLoaderScript() {
        return fileLoaderScript;
    }

    @Override
    public String toString() {
        return subService.getDescription();
    }
}
