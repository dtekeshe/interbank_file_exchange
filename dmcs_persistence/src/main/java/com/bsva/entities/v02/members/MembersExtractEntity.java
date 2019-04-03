package com.bsva.entities.v02.members;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
public class MembersExtractEntity implements Serializable {
    @Id
    @Column(name = "BANK_CODE")
    private Integer bankCode;
    @Column(name = "MEMBER_TAPE_ID")
    private String memberTapeId;
    @Column(name = "FULL_BANK_CODE")
    private Integer fullBankCode;
    @Column(name = "MAX_FILE_SIZE")
    private Integer maxFileSize;
    @Column(name = "MEMBER_NAME")
    private String memberName;
    @Column(name="MNEMONIC_MEMBER_NAME")
    private String mmemonicMemberName;
    
    public MembersExtractEntity(){
    	
    }

    public Integer getBankCode() {
        return bankCode;
    }

    public void setBankCode(Integer bankCode) {
        this.bankCode = bankCode;
    }

    public String getMemberTapeId() {
        return memberTapeId;
    }

    public void setMemberTapeId(String memberTapeId) {
        this.memberTapeId = memberTapeId;
    }

    public Integer getFullBankCode() {
        return fullBankCode;
    }

    public void setFullBankCode(Integer fullBankCode) {
        this.fullBankCode = fullBankCode;
    }

    public Integer getMaxFileSize() {
        return maxFileSize;
    }

    public void setMaxFileSize(Integer maxFileSize) {
        this.maxFileSize = maxFileSize;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

	public String getMmemonicMemberName() {
		return mmemonicMemberName;
	}

	public void setMmemonicMemberName(String mmemonicMemberName) {
		this.mmemonicMemberName = mmemonicMemberName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bankCode == null) ? 0 : bankCode.hashCode());
		result = prime * result + ((fullBankCode == null) ? 0 : fullBankCode.hashCode());
		result = prime * result + ((maxFileSize == null) ? 0 : maxFileSize.hashCode());
		result = prime * result + ((memberName == null) ? 0 : memberName.hashCode());
		result = prime * result + ((memberTapeId == null) ? 0 : memberTapeId.hashCode());
		result = prime * result + ((mmemonicMemberName == null) ? 0 : mmemonicMemberName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MembersExtractEntity other = (MembersExtractEntity) obj;
		if (bankCode == null) {
			if (other.bankCode != null)
				return false;
		} else if (!bankCode.equals(other.bankCode))
			return false;
		if (fullBankCode == null) {
			if (other.fullBankCode != null)
				return false;
		} else if (!fullBankCode.equals(other.fullBankCode))
			return false;
		if (maxFileSize == null) {
			if (other.maxFileSize != null)
				return false;
		} else if (!maxFileSize.equals(other.maxFileSize))
			return false;
		if (memberName == null) {
			if (other.memberName != null)
				return false;
		} else if (!memberName.equals(other.memberName))
			return false;
		if (memberTapeId == null) {
			if (other.memberTapeId != null)
				return false;
		} else if (!memberTapeId.equals(other.memberTapeId))
			return false;
		if (mmemonicMemberName == null) {
			if (other.mmemonicMemberName != null)
				return false;
		} else if (!mmemonicMemberName.equals(other.mmemonicMemberName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MembersExtractEntity [bankCode=");
		builder.append(bankCode);
		builder.append(", memberTapeId=");
		builder.append(memberTapeId);
		builder.append(", fullBankCode=");
		builder.append(fullBankCode);
		builder.append(", maxFileSize=");
		builder.append(maxFileSize);
		builder.append(", memberName=");
		builder.append(memberName);
		builder.append(", mmemonicMemberName=");
		builder.append(mmemonicMemberName);
		builder.append("]");
		return builder.toString();
	}
}

