/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsva.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author AugustineA
 */
@Entity
@Table(name = "CSF_MEMBER_SERVICE")
@NamedQueries({
    @NamedQuery(name = "CsfMemberService.findAll", query = "SELECT c FROM CsfMemberService c"),
    @NamedQuery(name = "CsfMemberService.findByMemberNo", query = "SELECT c FROM CsfMemberService c WHERE c.memberNo = :memberNo"),
    @NamedQuery(name = "CsfMemberService.findByBankCode", query = "SELECT c FROM CsfMemberService c WHERE c.csfMemberServicePK.bankCode = :bankCode"),
    @NamedQuery(name = "CsfMemberService.findByService", query = "SELECT c FROM CsfMemberService c WHERE c.csfMemberServicePK.service = :service"),
    @NamedQuery(name = "CsfMemberService.findBySubService", query = "SELECT c FROM CsfMemberService c WHERE c.csfMemberServicePK.subService = :subService"),
    @NamedQuery(name = "CsfMemberService.findByOutputInd", query = "SELECT c FROM CsfMemberService c WHERE c.outputInd = :outputInd"),
    @NamedQuery(name = "CsfMemberService.findByMaxSizeTransFile", query = "SELECT c FROM CsfMemberService c WHERE c.maxSizeTransFile = :maxSizeTransFile"),
    @NamedQuery(name = "CsfMemberService.findByMemberTapeId", query = "SELECT c FROM CsfMemberService c WHERE c.memberTapeId = :memberTapeId"),
    @NamedQuery(name = "CsfMemberService.findByAcquirerInd", query = "SELECT c FROM CsfMemberService c WHERE c.acquirerInd = :acquirerInd"),
    @NamedQuery(name = "CsfMemberService.findByIssuerInd", query = "SELECT c FROM CsfMemberService c WHERE c.issuerInd = :issuerInd"),
    @NamedQuery(name = "CsfMemberService.findByContactName", query = "SELECT c FROM CsfMemberService c WHERE c.contactName = :contactName"),
    @NamedQuery(name = "CsfMemberService.findByTitle", query = "SELECT c FROM CsfMemberService c WHERE c.title = :title"),
    @NamedQuery(name = "CsfMemberService.findByBranchCode", query = "SELECT c FROM CsfMemberService c WHERE c.branchCode = :branchCode"),
    @NamedQuery(name = "CsfMemberService.findByAccountNumber", query = "SELECT c FROM CsfMemberService c WHERE c.accountNumber = :accountNumber"),
    @NamedQuery(name = "CsfMemberService.findByMemberAddress1", query = "SELECT c FROM CsfMemberService c WHERE c.memberAddress1 = :memberAddress1"),
    @NamedQuery(name = "CsfMemberService.findByMemberAddress2", query = "SELECT c FROM CsfMemberService c WHERE c.memberAddress2 = :memberAddress2"),
    @NamedQuery(name = "CsfMemberService.findByMemberAddress3", query = "SELECT c FROM CsfMemberService c WHERE c.memberAddress3 = :memberAddress3"),
    @NamedQuery(name = "CsfMemberService.findByMemberAddress4", query = "SELECT c FROM CsfMemberService c WHERE c.memberAddress4 = :memberAddress4"),
    @NamedQuery(name = "CsfMemberService.findByCountry", query = "SELECT c FROM CsfMemberService c WHERE c.country = :country"),
    @NamedQuery(name = "CsfMemberService.findByVatRegNumber", query = "SELECT c FROM CsfMemberService c WHERE c.vatRegNumber = :vatRegNumber"),
    @NamedQuery(name = "CsfMemberService.findByExceptionReportInd", query = "SELECT c FROM CsfMemberService c WHERE c.exceptionReportInd = :exceptionReportInd"),
    @NamedQuery(name = "CsfMemberService.findByCurrencyCodeValidationReq", query = "SELECT c FROM CsfMemberService c WHERE c.currencyCodeValidationReq = :currencyCodeValidationReq"),
    @NamedQuery(name = "CsfMemberService.findByInputCharset", query = "SELECT c FROM CsfMemberService c WHERE c.inputCharset = :inputCharset"),
    @NamedQuery(name = "CsfMemberService.findByOutputCharset", query = "SELECT c FROM CsfMemberService c WHERE c.outputCharset = :outputCharset"),
    @NamedQuery(name = "CsfMemberService.findByHeader01RecordLength", query = "SELECT c FROM CsfMemberService c WHERE c.header01RecordLength = :header01RecordLength"),
    @NamedQuery(name = "CsfMemberService.findByTrailer98RecordLength", query = "SELECT c FROM CsfMemberService c WHERE c.trailer98RecordLength = :trailer98RecordLength"),
    @NamedQuery(name = "CsfMemberService.findByTrailer99RecordLength", query = "SELECT c FROM CsfMemberService c WHERE c.trailer99RecordLength = :trailer99RecordLength"),
    @NamedQuery(name = "CsfMemberService.findByInvoiceNoCcr001", query = "SELECT c FROM CsfMemberService c WHERE c.invoiceNoCcr001 = :invoiceNoCcr001")})
@DynamicUpdate
public class CsfMemberService implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CsfMemberServicePK csfMemberServicePK;
    @Size(max = 6)
    @Column(name = "MEMBER_NO")
    private String memberNo;
    @Size(max = 2)
    @Column(name = "OUTPUT_IND")
    private String outputInd;
    @Size(max = 8)
    @Column(name = "MAX_SIZE_TRANS_FILE")
    private String maxSizeTransFile;
    @Size(max = 2)
    @Column(name = "MEMBER_TAPE_ID")
    private String memberTapeId;
    @Size(max = 1)
    @Column(name = "ACQUIRER_IND")
    private String acquirerInd;
    @Size(max = 1)
    @Column(name = "ISSUER_IND")
    private String issuerInd;
    @Size(max = 30)
    @Column(name = "CONTACT_NAME")
    private String contactName;
    @Size(max = 30)
    @Column(name = "TITLE")
    private String title;
    @Size(max = 6)
    @Column(name = "BRANCH_CODE")
    private String branchCode;
    @Size(max = 35)
    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;
    @Size(max = 30)
    @Column(name = "MEMBER_ADDRESS_1")
    private String memberAddress1;
    @Size(max = 30)
    @Column(name = "MEMBER_ADDRESS_2")
    private String memberAddress2;
    @Size(max = 30)
    @Column(name = "MEMBER_ADDRESS_3")
    private String memberAddress3;
    @Size(max = 30)
    @Column(name = "MEMBER_ADDRESS_4")
    private String memberAddress4;
    @Size(max = 35)
    @Column(name = "COUNTRY")
    private String country;
    @Size(max = 10)
    @Column(name = "VAT_REG_NUMBER")
    private String vatRegNumber;
    @Size(max = 1)
    @Column(name = "EXCEPTION_REPORT_IND")
    private String exceptionReportInd;
    @Size(max = 1)
    @Column(name = "CURRENCY_CODE_VALIDATION_REQ")
    private String currencyCodeValidationReq;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "INPUT_CHARSET")
    private String inputCharset;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "OUTPUT_CHARSET")
    private String outputCharset;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HEADER01_RECORD_LENGTH")
    private int header01RecordLength;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRAILER98_RECORD_LENGTH")
    private int trailer98RecordLength;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRAILER99_RECORD_LENGTH")
    private int trailer99RecordLength;
    @Column(name = "INVOICE_NO_CCR001")
    private Integer invoiceNoCcr001;
    @JoinColumn(name = "SERVICE2", referencedColumnName = "SERVICE_CODE")
    @ManyToOne
    private CsfSystemService service2;
    @JoinColumn(name = "SERVICE", referencedColumnName = "SERVICE_CODE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CsfSystemService csfSystemService;
    @JoinColumns({
        @JoinColumn(name = "SERVICE", referencedColumnName = "SERVICE_CODE", insertable = false, updatable = false),
        @JoinColumn(name = "SUB_SERVICE", referencedColumnName = "SERVICE_NAME", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private CsfServices csfServices;
    @JoinColumns({
        @JoinColumn(name = "SERVICE1", referencedColumnName = "SERVICE_CODE"),
        @JoinColumn(name = "SUB_SERVICE1", referencedColumnName = "SERVICE_NAME")})
    @ManyToOne
    private CsfServices csfServices1;
    @JoinColumn(name = "BANK_CODE", referencedColumnName = "BANK_CODE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CsfMembers csfMembers;
    @JoinColumn(name = "BANK_CODE1", referencedColumnName = "BANK_CODE")
    @ManyToOne
    private CsfMembers bankCode1;

    public CsfMemberService() {
    }

    public CsfMemberService(CsfMemberServicePK csfMemberServicePK) {
        this.csfMemberServicePK = csfMemberServicePK;
    }

    public CsfMemberService(CsfMemberServicePK csfMemberServicePK, String inputCharset, String outputCharset, int header01RecordLength, int trailer98RecordLength, int trailer99RecordLength) {
        this.csfMemberServicePK = csfMemberServicePK;
        this.inputCharset = inputCharset;
        this.outputCharset = outputCharset;
        this.header01RecordLength = header01RecordLength;
        this.trailer98RecordLength = trailer98RecordLength;
        this.trailer99RecordLength = trailer99RecordLength;
    }

    public CsfMemberService(String bankCode, String service, String subService) {
        this.csfMemberServicePK = new CsfMemberServicePK(bankCode, service, subService);
    }

    public CsfMemberServicePK getCsfMemberServicePK() {
        return csfMemberServicePK;
    }

    public void setCsfMemberServicePK(CsfMemberServicePK csfMemberServicePK) {
        this.csfMemberServicePK = csfMemberServicePK;
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }

    public String getOutputInd() {
        return outputInd;
    }

    public void setOutputInd(String outputInd) {
        this.outputInd = outputInd;
    }

    public String getMaxSizeTransFile() {
        return maxSizeTransFile;
    }

    public void setMaxSizeTransFile(String maxSizeTransFile) {
        this.maxSizeTransFile = maxSizeTransFile;
    }

    public String getMemberTapeId() {
        return memberTapeId;
    }

    public void setMemberTapeId(String memberTapeId) {
        this.memberTapeId = memberTapeId;
    }

    public String getAcquirerInd() {
        return acquirerInd;
    }

    public void setAcquirerInd(String acquirerInd) {
        this.acquirerInd = acquirerInd;
    }

    public String getIssuerInd() {
        return issuerInd;
    }

    public void setIssuerInd(String issuerInd) {
        this.issuerInd = issuerInd;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getMemberAddress1() {
        return memberAddress1;
    }

    public void setMemberAddress1(String memberAddress1) {
        this.memberAddress1 = memberAddress1;
    }

    public String getMemberAddress2() {
        return memberAddress2;
    }

    public void setMemberAddress2(String memberAddress2) {
        this.memberAddress2 = memberAddress2;
    }

    public String getMemberAddress3() {
        return memberAddress3;
    }

    public void setMemberAddress3(String memberAddress3) {
        this.memberAddress3 = memberAddress3;
    }

    public String getMemberAddress4() {
        return memberAddress4;
    }

    public void setMemberAddress4(String memberAddress4) {
        this.memberAddress4 = memberAddress4;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getVatRegNumber() {
        return vatRegNumber;
    }

    public void setVatRegNumber(String vatRegNumber) {
        this.vatRegNumber = vatRegNumber;
    }

    public String getExceptionReportInd() {
        return exceptionReportInd;
    }

    public void setExceptionReportInd(String exceptionReportInd) {
        this.exceptionReportInd = exceptionReportInd;
    }

    public String getCurrencyCodeValidationReq() {
        return currencyCodeValidationReq;
    }

    public void setCurrencyCodeValidationReq(String currencyCodeValidationReq) {
        this.currencyCodeValidationReq = currencyCodeValidationReq;
    }

    public String getInputCharset() {
        return inputCharset;
    }

    public void setInputCharset(String inputCharset) {
        this.inputCharset = inputCharset;
    }

    public String getOutputCharset() {
        return outputCharset;
    }

    public void setOutputCharset(String outputCharset) {
        this.outputCharset = outputCharset;
    }

    public int getHeader01RecordLength() {
        return header01RecordLength;
    }

    public void setHeader01RecordLength(int header01RecordLength) {
        this.header01RecordLength = header01RecordLength;
    }

    public int getTrailer98RecordLength() {
        return trailer98RecordLength;
    }

    public void setTrailer98RecordLength(int trailer98RecordLength) {
        this.trailer98RecordLength = trailer98RecordLength;
    }

    public int getTrailer99RecordLength() {
        return trailer99RecordLength;
    }

    public void setTrailer99RecordLength(int trailer99RecordLength) {
        this.trailer99RecordLength = trailer99RecordLength;
    }

    public Integer getInvoiceNoCcr001() {
        return invoiceNoCcr001;
    }

    public void setInvoiceNoCcr001(Integer invoiceNoCcr001) {
        this.invoiceNoCcr001 = invoiceNoCcr001;
    }

    public CsfSystemService getService2() {
        return service2;
    }

    public void setService2(CsfSystemService service2) {
        this.service2 = service2;
    }

    public CsfSystemService getCsfSystemService() {
        return csfSystemService;
    }

    public void setCsfSystemService(CsfSystemService csfSystemService) {
        this.csfSystemService = csfSystemService;
    }

    public CsfServices getCsfServices() {
        return csfServices;
    }

    public void setCsfServices(CsfServices csfServices) {
        this.csfServices = csfServices;
    }

    public CsfServices getCsfServices1() {
        return csfServices1;
    }

    public void setCsfServices1(CsfServices csfServices1) {
        this.csfServices1 = csfServices1;
    }

    public CsfMembers getCsfMembers() {
        return csfMembers;
    }

    public void setCsfMembers(CsfMembers csfMembers) {
        this.csfMembers = csfMembers;
    }

    public CsfMembers getBankCode1() {
        return bankCode1;
    }

    public void setBankCode1(CsfMembers bankCode1) {
        this.bankCode1 = bankCode1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (csfMemberServicePK != null ? csfMemberServicePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsfMemberService)) {
            return false;
        }
        CsfMemberService other = (CsfMemberService) object;
        if ((this.csfMemberServicePK == null && other.csfMemberServicePK != null) || (this.csfMemberServicePK != null && !this.csfMemberServicePK.equals(other.csfMemberServicePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.dmcs.entities.CsfMemberService[ csfMemberServicePK=" + csfMemberServicePK + " ]";
    }
    
}
