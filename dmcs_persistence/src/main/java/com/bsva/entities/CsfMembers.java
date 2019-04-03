package com.bsva.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author AugustineA
 */
@Entity
@Table(name = "CSF_MEMBERS")
@NamedQueries({
    @NamedQuery(name = "CsfMembers.findAll", query = "SELECT c FROM CsfMembers c"),
    @NamedQuery(name = "CsfMembers.findByMemberNo", query = "SELECT c FROM CsfMembers c WHERE c.memberNo = :memberNo"),
    @NamedQuery(name = "CsfMembers.findByBankCode", query = "SELECT c FROM CsfMembers c WHERE c.bankCode = :bankCode"),
    @NamedQuery(name = "CsfMembers.findByMemberName", query = "SELECT c FROM CsfMembers c WHERE c.memberName = :memberName"),
    @NamedQuery(name = "CsfMembers.findByAbbrevMemberName", query = "SELECT c FROM CsfMembers c WHERE c.abbrevMemberName = :abbrevMemberName"),
    @NamedQuery(name = "CsfMembers.findByMnemonicMemberName", query = "SELECT c FROM CsfMembers c WHERE c.mnemonicMemberName = :mnemonicMemberName"),
    @NamedQuery(name = "CsfMembers.findByMemberAddress1", query = "SELECT c FROM CsfMembers c WHERE c.memberAddress1 = :memberAddress1"),
    @NamedQuery(name = "CsfMembers.findByMemberAddress2", query = "SELECT c FROM CsfMembers c WHERE c.memberAddress2 = :memberAddress2"),
    @NamedQuery(name = "CsfMembers.findByMemberAddress3", query = "SELECT c FROM CsfMembers c WHERE c.memberAddress3 = :memberAddress3"),
    @NamedQuery(name = "CsfMembers.findByMemberAddress4", query = "SELECT c FROM CsfMembers c WHERE c.memberAddress4 = :memberAddress4"),
    @NamedQuery(name = "CsfMembers.findByMemberStatus", query = "SELECT c FROM CsfMembers c WHERE c.memberStatus = :memberStatus"),
    @NamedQuery(name = "CsfMembers.findByMemberTapeId", query = "SELECT c FROM CsfMembers c WHERE c.memberTapeId = :memberTapeId"),
    @NamedQuery(name = "CsfMembers.findByContactName", query = "SELECT c FROM CsfMembers c WHERE c.contactName = :contactName"),
    @NamedQuery(name = "CsfMembers.findByVatRegNo", query = "SELECT c FROM CsfMembers c WHERE c.vatRegNo = :vatRegNo"),
    @NamedQuery(name = "CsfMembers.findByOriginatingBankId", query = "SELECT c FROM CsfMembers c WHERE c.originatingBankId = :originatingBankId"),
    @NamedQuery(name = "CsfMembers.findByProcessorId", query = "SELECT c FROM CsfMembers c WHERE c.processorId = :processorId"),
    @NamedQuery(name = "CsfMembers.findByTieredItemCharge", query = "SELECT c FROM CsfMembers c WHERE c.tieredItemCharge = :tieredItemCharge"),
    @NamedQuery(name = "CsfMembers.findByIncfOutputRequired", query = "SELECT c FROM CsfMembers c WHERE c.incfOutputRequired = :incfOutputRequired"),
    @NamedQuery(name = "CsfMembers.findByMonthsUntilCisBinDeletion", query = "SELECT c FROM CsfMembers c WHERE c.monthsUntilCisBinDeletion = :monthsUntilCisBinDeletion"),
    @NamedQuery(name = "CsfMembers.findByTieredItemChargeBelow", query = "SELECT c FROM CsfMembers c WHERE c.tieredItemChargeBelow = :tieredItemChargeBelow"),
    @NamedQuery(name = "CsfMembers.findByTieredItemChargeAbove", query = "SELECT c FROM CsfMembers c WHERE c.tieredItemChargeAbove = :tieredItemChargeAbove"),
    @NamedQuery(name = "CsfMembers.findByNegCardDataRequired", query = "SELECT c FROM CsfMembers c WHERE c.negCardDataRequired = :negCardDataRequired")})
@DynamicUpdate
public class CsfMembers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 6)
    @Column(name = "MEMBER_NO")
    private String memberNo;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "BANK_CODE")
    private String bankCode;
    @Size(max = 30)
    @Column(name = "MEMBER_NAME")
    private String memberName;
    @Size(max = 12)
    @Column(name = "ABBREV_MEMBER_NAME")
    private String abbrevMemberName;
    @Size(max = 3)
    @Column(name = "MNEMONIC_MEMBER_NAME")
    private String mnemonicMemberName;
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
    @Size(max = 1)
    @Column(name = "MEMBER_STATUS")
    private String memberStatus;
    @Size(max = 2)
    @Column(name = "MEMBER_TAPE_ID")
    private String memberTapeId;
    @Size(max = 30)
    @Column(name = "CONTACT_NAME")
    private String contactName;
    @Size(max = 10)
    @Column(name = "VAT_REG_NO")
    private String vatRegNo;
    @Size(max = 1)
    @Column(name = "ORIGINATING_BANK_ID")
    private String originatingBankId;
    @Column(name = "PROCESSOR_ID")
    private Long processorId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TIERED_ITEM_CHARGE")
    private BigDecimal tieredItemCharge;
    @Size(max = 1)
    @Column(name = "INCF_OUTPUT_REQUIRED")
    private String incfOutputRequired;
    @Column(name = "MONTHS_UNTIL_CIS_BIN_DELETION")
    private Short monthsUntilCisBinDeletion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIERED_ITEM_CHARGE_BELOW")
    private BigDecimal tieredItemChargeBelow;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIERED_ITEM_CHARGE_ABOVE")
    private BigDecimal tieredItemChargeAbove;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "NEG_CARD_DATA_REQUIRED")
    private String negCardDataRequired;
   // @Lob
  //  @Column(name = "CSFBINSLIST")
   // private byte[] csfbinslist;
    @OneToMany(cascade= CascadeType.ALL, mappedBy = "bankCode")
    private List<CsfBins> csfBinsList = new ArrayList<CsfBins>();

    public CsfMembers() {
    }

    public CsfMembers(String bankCode) {
        this.bankCode = bankCode;
    }

    public CsfMembers(String bankCode, BigDecimal tieredItemChargeBelow, BigDecimal tieredItemChargeAbove, String negCardDataRequired) {
        this.bankCode = bankCode;
        this.tieredItemChargeBelow = tieredItemChargeBelow;
        this.tieredItemChargeAbove = tieredItemChargeAbove;
        this.negCardDataRequired = negCardDataRequired;
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getAbbrevMemberName() {
        return abbrevMemberName;
    }

    public void setAbbrevMemberName(String abbrevMemberName) {
        this.abbrevMemberName = abbrevMemberName;
    }

    public String getMnemonicMemberName() {
        return mnemonicMemberName;
    }

    public void setMnemonicMemberName(String mnemonicMemberName) {
        this.mnemonicMemberName = mnemonicMemberName;
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

    public String getMemberStatus() {
        return memberStatus;
    }

    public void setMemberStatus(String memberStatus) {
        this.memberStatus = memberStatus;
    }

    public String getMemberTapeId() {
        return memberTapeId;
    }

    public void setMemberTapeId(String memberTapeId) {
        this.memberTapeId = memberTapeId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getVatRegNo() {
        return vatRegNo;
    }

    public void setVatRegNo(String vatRegNo) {
        this.vatRegNo = vatRegNo;
    }

    public String getOriginatingBankId() {
        return originatingBankId;
    }

    public void setOriginatingBankId(String originatingBankId) {
        this.originatingBankId = originatingBankId;
    }

    public Long getProcessorId() {
        return processorId;
    }

    public void setProcessorId(Long processorId) {
        this.processorId = processorId;
    }

    public BigDecimal getTieredItemCharge() {
        return tieredItemCharge;
    }

    public void setTieredItemCharge(BigDecimal tieredItemCharge) {
        this.tieredItemCharge = tieredItemCharge;
    }

    public String getIncfOutputRequired() {
        return incfOutputRequired;
    }

    public void setIncfOutputRequired(String incfOutputRequired) {
        this.incfOutputRequired = incfOutputRequired;
    }

    public Short getMonthsUntilCisBinDeletion() {
        return monthsUntilCisBinDeletion;
    }

    public void setMonthsUntilCisBinDeletion(Short monthsUntilCisBinDeletion) {
        this.monthsUntilCisBinDeletion = monthsUntilCisBinDeletion;
    }

    public BigDecimal getTieredItemChargeBelow() {
        return tieredItemChargeBelow;
    }

    public void setTieredItemChargeBelow(BigDecimal tieredItemChargeBelow) {
        this.tieredItemChargeBelow = tieredItemChargeBelow;
    }

    public BigDecimal getTieredItemChargeAbove() {
        return tieredItemChargeAbove;
    }

    public void setTieredItemChargeAbove(BigDecimal tieredItemChargeAbove) {
        this.tieredItemChargeAbove = tieredItemChargeAbove;
    }

    public String getNegCardDataRequired() {
        return negCardDataRequired;
    }

    public void setNegCardDataRequired(String negCardDataRequired) {
        this.negCardDataRequired = negCardDataRequired;
    }

/*    public byte[] getCsfbinslist() {
        return csfbinslist;
    }

    public void setCsfbinslist(byte[] csfbinslist) {
        this.csfbinslist = csfbinslist;
    }*/

    public List<CsfBins> getCsfBinsList() {
        return csfBinsList;
    }

    public void setCsfBinsList(List<CsfBins> csfBinsList) {
        this.csfBinsList = csfBinsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bankCode != null ? bankCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CsfMembers)) {
            return false;
        }
        CsfMembers other = (CsfMembers) object;
        if ((this.bankCode == null && other.bankCode != null) || (this.bankCode != null && !this.bankCode.equals(other.bankCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.dmcs.entities.CsfMembers[ bankCode=" + bankCode + " ]";
    }
    
}
