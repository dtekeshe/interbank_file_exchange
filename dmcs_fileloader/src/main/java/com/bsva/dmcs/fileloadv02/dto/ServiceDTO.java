package com.bsva.dmcs.fileloadv02.dto;

/**
 *
 */
public class ServiceDTO {
    private final Service service;
    private final SubService subService;

    public ServiceDTO(Service service, SubService subService) {
        this.service = service;
        this.subService = subService;
    }

    public Service getService() {
        return service;
    }

    public SubService getSubService() {
        return subService;
    }
}
