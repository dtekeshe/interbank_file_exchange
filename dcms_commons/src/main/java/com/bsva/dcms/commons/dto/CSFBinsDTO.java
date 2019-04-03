package com.bsva.dcms.commons.dto;

import com.bsva.entities.CsfMembers;
import java.io.Serializable;
import java.util.Date;

public class CSFBinsDTO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String binNo;
    private String binDescription;
    private int bankCode;
    private String bankName;
    private String cardType;
    private String cardDescription;
    private double limit1;
    private double limit2;
    private double floorLimit;
    private int routing;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
    private String subService;
    private Date firstDeletionDate;
    private int daysBeforeFirstDeletionDate;
    private Date finalDeletionDate;
    private int daysBeforeFinalDeletionDate;
    private String activeInd;
    private String acqIssBoth;
    private int monthUntilDeletion;

    private CSFMembersDTO csfMembersDTO;

    public String getBinNo() {
        return binNo;
    }

    public void setBinNo(String binNo) {
        this.binNo = binNo;
    }

    public String getBinDescription() {
        return binDescription;
    }

    public void setBinDescription(String binDescription) {
        this.binDescription = binDescription;
    }

    public int getBankCode() {
        return bankCode;
    }

    public void setBankCode(int bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardDescription() {
        return cardDescription;
    }

    public void setCardDescription(String cardDescription) {
        this.cardDescription = cardDescription;
    }

    public double getLimit1() {
        return limit1;
    }

    public void setLimit1(double limit1) {
        this.limit1 = limit1;
    }

    public double getLimit2() {
        return limit2;
    }

    public void setLimit2(double limit2) {
        this.limit2 = limit2;
    }

    public double getFloorLimit() {
        return floorLimit;
    }

    public void setFloorLimit(double floorLimit) {
        this.floorLimit = floorLimit;
    }

    public int getRouting() {
        return routing;
    }

    public void setRouting(int routing) {
        this.routing = routing;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getSubService() {
        return subService;
    }

    public void setSubService(String subService) {
        this.subService = subService;
    }

    public Date getFirstDeletionDate() {
        return firstDeletionDate;
    }

    public void setFirstDeletionDate(Date firstDeletionDate) {
        this.firstDeletionDate = firstDeletionDate;
    }

    public int getDaysBeforeFirstDeletionDate() {
        return daysBeforeFirstDeletionDate;
    }

    public void setDaysBeforeFirstDeletionDate(int daysBeforeFirstDeletionDate) {
        this.daysBeforeFirstDeletionDate = daysBeforeFirstDeletionDate;
    }

    public Date getFinalDeletionDate() {
        return finalDeletionDate;
    }

    public void setFinalDeletionDate(Date finalDeletionDate) {
        this.finalDeletionDate = finalDeletionDate;
    }

    public int getDaysBeforeFinalDeletionDate() {
        return daysBeforeFinalDeletionDate;
    }

    public void setDaysBeforeFinalDeletionDate(int daysBeforeFinalDeletionDate) {
        this.daysBeforeFinalDeletionDate = daysBeforeFinalDeletionDate;
    }

    public String getActiveInd() {
        return activeInd;
    }

    public void setActiveInd(String activeInd) {
        this.activeInd = activeInd;
    }

    public String getAcqIssBoth() {
        return acqIssBoth;
    }

    public void setAcqIssBoth(String acqIssBoth) {
        this.acqIssBoth = acqIssBoth;
    }

    public int getMonthUntilDeletion() {
        return monthUntilDeletion;
    }

    public void setMonthUntilDeletion(int monthUntilDeletion) {
        this.monthUntilDeletion = monthUntilDeletion;
    }

    public CSFMembersDTO getCsfMembersDTO() {
        return csfMembersDTO;
    }

    public void setCsfMembersDTO(CSFMembersDTO csfMembersDTO) {
        this.csfMembersDTO = csfMembersDTO;
    }

}
