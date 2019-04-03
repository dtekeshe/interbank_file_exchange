package com.bsva.entities.v02.billing;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "CSF_MEMBERS")
@DynamicUpdate
public class MemberServiceEntity {
	
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
	    private String mnemonicMemberName;
	    @Column(name="MEMBER_NO")
	    private String memberNo;
	    
	    public MemberServiceEntity(){
	    	
	    }

		public Integer getBankCode() {
			return bankCode;
		}

		public String getMemberTapeId() {
			return memberTapeId;
		}

		public Integer getFullBankCode() {
			return fullBankCode;
		}

		public Integer getMaxFileSize() {
			return maxFileSize;
		}

		public String getMemberName() {
			return memberName;
		}

		public String getMnemonicMemberName() {
			return mnemonicMemberName;
		}

		public String getMemberNo() {
			return memberNo;
		}

		public void setBankCode(Integer bankCode) {
			this.bankCode = bankCode;
		}

		public void setMemberTapeId(String memberTapeId) {
			this.memberTapeId = memberTapeId;
		}

		public void setFullBankCode(Integer fullBankCode) {
			this.fullBankCode = fullBankCode;
		}

		public void setMaxFileSize(Integer maxFileSize) {
			this.maxFileSize = maxFileSize;
		}

		public void setMemberName(String memberName) {
			this.memberName = memberName;
		}

		public void setMnemonicMemberName(String mnemonicMemberName) {
			this.mnemonicMemberName = mnemonicMemberName;
		}

		public void setMemberNo(String memberNo) {
			this.memberNo = memberNo;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((bankCode == null) ? 0 : bankCode.hashCode());
			result = prime * result + ((fullBankCode == null) ? 0 : fullBankCode.hashCode());
			result = prime * result + ((maxFileSize == null) ? 0 : maxFileSize.hashCode());
			result = prime * result + ((memberName == null) ? 0 : memberName.hashCode());
			result = prime * result + ((memberNo == null) ? 0 : memberNo.hashCode());
			result = prime * result + ((memberTapeId == null) ? 0 : memberTapeId.hashCode());
			result = prime * result + ((mnemonicMemberName == null) ? 0 : mnemonicMemberName.hashCode());
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
			MemberServiceEntity other = (MemberServiceEntity) obj;
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
			if (memberNo == null) {
				if (other.memberNo != null)
					return false;
			} else if (!memberNo.equals(other.memberNo))
				return false;
			if (memberTapeId == null) {
				if (other.memberTapeId != null)
					return false;
			} else if (!memberTapeId.equals(other.memberTapeId))
				return false;
			if (mnemonicMemberName == null) {
				if (other.mnemonicMemberName != null)
					return false;
			} else if (!mnemonicMemberName.equals(other.mnemonicMemberName))
				return false;
			return true;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("MemberServiceEntity [bankCode=");
			builder.append(bankCode);
			builder.append(", memberTapeId=");
			builder.append(memberTapeId);
			builder.append(", fullBankCode=");
			builder.append(fullBankCode);
			builder.append(", maxFileSize=");
			builder.append(maxFileSize);
			builder.append(", memberName=");
			builder.append(memberName);
			builder.append(", mnemonicMemberName=");
			builder.append(mnemonicMemberName);
			builder.append(", memberNo=");
			builder.append(memberNo);
			builder.append("]");
			return builder.toString();
		}

}