package com.bsva.dmcs.fileloadv02.dto;

/**
 *
 */
public class DeliveryServiceDTO {

    private final String filenamePrefix;
    private final Service service;
    private final SubService subService;
    private final FileFormat fileFormat;

    public DeliveryServiceDTO(
            String filenamePrefix,
            Service service,
            SubService subService,
            FileFormat fileFormat) {
        this.filenamePrefix = filenamePrefix;
        this.service = service;
        this.subService = subService;
        this.fileFormat = fileFormat;
    }

    public String getFilenamePrefix() {
        return filenamePrefix;
    }

    public Service getService() {
        return service;
    }

    public SubService getSubService() {
        return subService;
    }

    public FileFormat getFileFormat() {
        return fileFormat;
    }
}
