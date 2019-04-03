package com.bsva.dmcs.fileloadv02.dto;

/**
 *
 */
public class MemberServiceDTO {

    private final Integer bankCode;
    private final ServiceDTO service;

    public MemberServiceDTO(Integer bankCode, ServiceDTO service) {
        this.bankCode = bankCode;
        this.service = service;
    }

    public Integer getBankCode() {
        return bankCode;
    }

    public ServiceDTO getService() {
        return service;
    }

    @Override
    public String toString() {
        return "MemberServiceDTO{" +
                "bankCode=" + bankCode +
                ", service=" + service +
                '}';
    }
}
