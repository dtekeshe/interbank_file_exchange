/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsva.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author AugustineA
 */
@Entity
@Table(name = "CSF_COMPANY_PARAMETERS")
@NamedQueries({
    @NamedQuery(name = "CsfCompanyParameters.findAll", query = "SELECT c FROM CsfCompanyParameters c"),
    @NamedQuery(name = "CsfCompanyParameters.findByCompanyName", query = "SELECT c FROM CsfCompanyParameters c WHERE c.companyName = :companyName"),
    @NamedQuery(name = "CsfCompanyParameters.findByCompanyNameAbrev", query = "SELECT c FROM CsfCompanyParameters c WHERE c.companyNameAbrev = :companyNameAbrev"),
    @NamedQuery(name = "CsfCompanyParameters.findByFullReportName", query = "SELECT c FROM CsfCompanyParameters c WHERE c.fullReportName = :fullReportName"),
    @NamedQuery(name = "CsfCompanyParameters.findByAddress1", query = "SELECT c FROM CsfCompanyParameters c WHERE c.address1 = :address1"),
    @NamedQuery(name = "CsfCompanyParameters.findByAddress2", query = "SELECT c FROM CsfCompanyParameters c WHERE c.address2 = :address2"),
    @NamedQuery(name = "CsfCompanyParameters.findByAddress3", query = "SELECT c FROM CsfCompanyParameters c WHERE c.address3 = :address3"),
    @NamedQuery(name = "CsfCompanyParameters.findByDiallingCode", query = "SELECT c FROM CsfCompanyParameters c WHERE c.diallingCode = :diallingCode"),
    @NamedQuery(name = "CsfCompanyParameters.findByTelephoneNumber1", query = "SELECT c FROM CsfCompanyParameters c WHERE c.telephoneNumber1 = :telephoneNumber1"),
    @NamedQuery(name = "CsfCompanyParameters.findByFaxCode", query = "SELECT c FROM CsfCompanyParameters c WHERE c.faxCode = :faxCode"),
    @NamedQuery(name = "CsfCompanyParameters.findByFaxNumber", query = "SELECT c FROM CsfCompanyParameters c WHERE c.faxNumber = :faxNumber"),
    @NamedQuery(name = "CsfCompanyParameters.findByEmailAddress", query = "SELECT c FROM CsfCompanyParameters c WHERE c.emailAddress = :emailAddress"),
    @NamedQuery(name = "CsfCompanyParameters.findByRegistrationNumber", query = "SELECT c FROM CsfCompanyParameters c WHERE c.registrationNumber = :registrationNumber"),
    @NamedQuery(name = "CsfCompanyParameters.findByVatNumber", query = "SELECT c FROM CsfCompanyParameters c WHERE c.vatNumber = :vatNumber"),
    @NamedQuery(name = "CsfCompanyParameters.findByContactName", query = "SELECT c FROM CsfCompanyParameters c WHERE c.contactName = :contactName"),
    @NamedQuery(name = "CsfCompanyParameters.findByInvoiceNumber", query = "SELECT c FROM CsfCompanyParameters c WHERE c.invoiceNumber = :invoiceNumber"),
    @NamedQuery(name = "CsfCompanyParameters.findByInvoiceDate", query = "SELECT c FROM CsfCompanyParameters c WHERE c.invoiceDate = :invoiceDate"),
    @NamedQuery(name = "CsfCompanyParameters.findByPreviousInvoiceNumber", query = "SELECT c FROM CsfCompanyParameters c WHERE c.previousInvoiceNumber = :previousInvoiceNumber"),
    @NamedQuery(name = "CsfCompanyParameters.findByVatPercent", query = "SELECT c FROM CsfCompanyParameters c WHERE c.vatPercent = :vatPercent"),
    @NamedQuery(name = "CsfCompanyParameters.findByTestLiveIndicator", query = "SELECT c FROM CsfCompanyParameters c WHERE c.testLiveIndicator = :testLiveIndicator"),
    @NamedQuery(name = "CsfCompanyParameters.findByCreatedBy", query = "SELECT c FROM CsfCompanyParameters c WHERE c.createdBy = :createdBy"),
    @NamedQuery(name = "CsfCompanyParameters.findByCreatedDate", query = "SELECT c FROM CsfCompanyParameters c WHERE c.createdDate = :createdDate"),
    @NamedQuery(name = "CsfCompanyParameters.findByModifiedBy", query = "SELECT c FROM CsfCompanyParameters c WHERE c.modifiedBy = :modifiedBy"),
    @NamedQuery(name = "CsfCompanyParameters.findByModifiedDate", query = "SELECT c FROM CsfCompanyParameters c WHERE c.modifiedDate = :modifiedDate"),
    @NamedQuery(name = "CsfCompanyParameters.findByValidationCode", query = "SELECT c FROM CsfCompanyParameters c WHERE c.validationCode = :validationCode"),
    @NamedQuery(name = "CsfCompanyParameters.findByInstitutionCode", query = "SELECT c FROM CsfCompanyParameters c WHERE c.institutionCode = :institutionCode"),
    @NamedQuery(name = "CsfCompanyParameters.findByCurrencyCode", query = "SELECT c FROM CsfCompanyParameters c WHERE c.currencyCode = :currencyCode"),
    @NamedQuery(name = "CsfCompanyParameters.findByInputRecordLength", query = "SELECT c FROM CsfCompanyParameters c WHERE c.inputRecordLength = :inputRecordLength"),
    @NamedQuery(name = "CsfCompanyParameters.findByInputId", query = "SELECT c FROM CsfCompanyParameters c WHERE c.inputId = :inputId"),
    @NamedQuery(name = "CsfCompanyParameters.findByPrepCode", query = "SELECT c FROM CsfCompanyParameters c WHERE c.prepCode = :prepCode"),
    @NamedQuery(name = "CsfCompanyParameters.findBySeqNo", query = "SELECT c FROM CsfCompanyParameters c WHERE c.seqNo = :seqNo"),
    @NamedQuery(name = "CsfCompanyParameters.findByCurrencyCodeNumber", query = "SELECT c FROM CsfCompanyParameters c WHERE c.currencyCodeNumber = :currencyCodeNumber"),
    @NamedQuery(name = "CsfCompanyParameters.findByFleetTxBindTime", query = "SELECT c FROM CsfCompanyParameters c WHERE c.fleetTxBindTime = :fleetTxBindTime"),
    @NamedQuery(name = "CsfCompanyParameters.findByTieredCutOff", query = "SELECT c FROM CsfCompanyParameters c WHERE c.tieredCutOff = :tieredCutOff")})
@DynamicUpdate
public class CsfCompanyParameters implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "COMPANY_NAME")
    private String companyName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "COMPANY_NAME_ABREV")
    private String companyNameAbrev;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "FULL_REPORT_NAME")
    private String fullReportName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ADDRESS_1")
    private String address1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ADDRESS_2")
    private String address2;
    @Size(max = 30)
    @Column(name = "ADDRESS_3")
    private String address3;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "DIALLING_CODE")
    private String diallingCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "TELEPHONE_NUMBER_1")
    private String telephoneNumber1;
    @Size(max = 8)
    @Column(name = "FAX_CODE")
    private String faxCode;
    @Size(max = 7)
    @Column(name = "FAX_NUMBER")
    private String faxNumber;
    @Size(max = 30)
    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "REGISTRATION_NUMBER")
    private String registrationNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "VAT_NUMBER")
    private String vatNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CONTACT_NAME")
    private String contactName;
    @Column(name = "INVOICE_NUMBER")
    private Integer invoiceNumber;
    @Column(name = "INVOICE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date invoiceDate;
    @Column(name = "PREVIOUS_INVOICE_NUMBER")
    private Integer previousInvoiceNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VAT_PERCENT")
    private short vatPercent;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "TEST_LIVE_INDICATOR")
    private String testLiveIndicator;
    @Size(max = 30)
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Size(max = 30)
    @Column(name = "MODIFIED_BY")
    private String modifiedBy;
    @Column(name = "MODIFIED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "VALIDATION_CODE")
    private String validationCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "INSTITUTION_CODE")
    private String institutionCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "CURRENCY_CODE")
    private String currencyCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "INPUT_RECORD_LENGTH")
    private short inputRecordLength;
    @Size(max = 2)
    @Column(name = "INPUT_ID")
    private String inputId;
    @Column(name = "PREP_CODE")
    private Short prepCode;
    @Column(name = "SEQ_NO")
    private Long seqNo;
    @Column(name = "CURRENCY_CODE_NUMBER")
    private Short currencyCodeNumber;
    @Column(name = "FLEET_TX_BIND_TIME")
    private Short fleetTxBindTime;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIERED_CUT_OFF")
    private BigDecimal tieredCutOff;

    public CsfCompanyParameters() {
    }

    public CsfCompanyParameters(String companyName) {
        this.companyName = companyName;
    }

    public CsfCompanyParameters(String companyName, String companyNameAbrev, String fullReportName, String address1, String address2, String diallingCode, String telephoneNumber1, String registrationNumber, String vatNumber, String contactName, short vatPercent, String testLiveIndicator, String validationCode, String institutionCode, String currencyCode, short inputRecordLength, BigDecimal tieredCutOff) {
        this.companyName = companyName;
        this.companyNameAbrev = companyNameAbrev;
        this.fullReportName = fullReportName;
        this.address1 = address1;
        this.address2 = address2;
        this.diallingCode = diallingCode;
        this.telephoneNumber1 = telephoneNumber1;
        this.registrationNumber = registrationNumber;
        this.vatNumber = vatNumber;
        this.contactName = contactName;
        this.vatPercent = vatPercent;
        this.testLiveIndicator = testLiveIndicator;
        this.validationCode = validationCode;
        this.institutionCode = institutionCode;
        this.currencyCode = currencyCode;
        this.inputRecordLength = inputRecordLength;
        this.tieredCutOff = tieredCutOff;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyNameAbrev() {
        return companyNameAbrev;
    }

    public void setCompanyNameAbrev(String companyNameAbrev) {
        this.companyNameAbrev = companyNameAbrev;
    }

    public String getFullReportName() {
        return fullReportName;
    }

    public void setFullReportName(String fullReportName) {
        this.fullReportName = fullReportName;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getDiallingCode() {
        return diallingCode;
    }

    public void setDiallingCode(String diallingCode) {
        this.diallingCode = diallingCode;
    }

    public String getTelephoneNumber1() {
        return telephoneNumber1;
    }

    public void setTelephoneNumber1(String telephoneNumber1) {
        this.telephoneNumber1 = telephoneNumber1;
    }

    public String getFaxCode() {
        return faxCode;
    }

    public void setFaxCode(String faxCode) {
        this.faxCode = faxCode;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public Integer getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(Integer invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Integer getPreviousInvoiceNumber() {
        return previousInvoiceNumber;
    }

    public void setPreviousInvoiceNumber(Integer previousInvoiceNumber) {
        this.previousInvoiceNumber = previousInvoiceNumber;
    }

    public short getVatPercent() {
        return vatPercent;
    }

    public void setVatPercent(short vatPercent) {
        this.vatPercent = vatPercent;
    }

    public String getTestLiveIndicator() {
        return testLiveIndicator;
    }

    public void setTestLiveIndicator(String testLiveIndicator) {
        this.testLiveIndicator = testLiveIndicator;
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

    public String getValidationCode() {
        return validationCode;
    }

    public void setValidationCode(String validationCode) {
        this.validationCode = validationCode;
    }

    public String getInstitutionCode() {
        return institutionCode;
    }

    public void setInstitutionCode(String institutionCode) {
        this.institutionCode = institutionCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public short getInputRecordLength() {
        return inputRecordLength;
    }

    public void setInputRecordLength(short inputRecordLength) {
        this.inputRecordLength = inputRecordLength;
    }

    public String getInputId() {
        return inputId;
    }

    public void setInputId(String inputId) {
        this.inputId = inputId;
    }

    public Short getPrepCode() {
        return prepCode;
    }

    public void setPrepCode(Short prepCode) {
        this.prepCode = prepCode;
    }

    public Long getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(Long seqNo) {
        this.seqNo = seqNo;
    }

    public Short getCurrencyCodeNumber() {
        return currencyCodeNumber;
    }

    public void setCurrencyCodeNumber(Short currencyCodeNumber) {
        this.currencyCodeNumber = currencyCodeNumber;
    }

    public Short getFleetTxBindTime() {
        return fleetTxBindTime;
    }

    public void setFleetTxBindTime(Short fleetTxBindTime) {
        this.fleetTxBindTime = fleetTxBindTime;
    }

    public BigDecimal getTieredCutOff() {
        return tieredCutOff;
    }

    public void setTieredCutOff(BigDecimal tieredCutOff) {
        this.tieredCutOff = tieredCutOff;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (companyName != null ? companyName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsfCompanyParameters)) {
            return false;
        }
        CsfCompanyParameters other = (CsfCompanyParameters) object;
        if ((this.companyName == null && other.companyName != null) || (this.companyName != null && !this.companyName.equals(other.companyName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.dmcs.entities.CsfCompanyParameters[ companyName=" + companyName + " ]";
    }
    
}
