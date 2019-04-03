package com.bsva.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CssCcr009View_PK implements Serializable {

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	  @Column(name = "ACQUIRER")
	  private String acqquirer;
	  @Column(name = "ISSUER")
	  private String issuer;
	  @Column(name = "TX_DESC")
	  private String txDesc;
	  @Column(name = "PRODUCT_DESC")
	  private String productDesc;
	  @Column(name = "TRANSACTION_CODE")
	  private String transactionCode;
	 
	  
	  public CssCcr009View_PK(){
		  
	  }


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getAcqquirer() {
		return acqquirer;
	}


	public String getIssuer() {
		return issuer;
	}


	public String getTxDesc() {
		return txDesc;
	}


	public String getProductDesc() {
		return productDesc;
	}


	public String getTransactionCode() {
		return transactionCode;
	}


	public void setAcqquirer(String acqquirer) {
		this.acqquirer = acqquirer;
	}


	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}


	public void setTxDesc(String txDesc) {
		this.txDesc = txDesc;
	}


	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}


	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acqquirer == null) ? 0 : acqquirer.hashCode());
		result = prime * result + ((issuer == null) ? 0 : issuer.hashCode());
		result = prime * result + ((productDesc == null) ? 0 : productDesc.hashCode());
		result = prime * result + ((transactionCode == null) ? 0 : transactionCode.hashCode());
		result = prime * result + ((txDesc == null) ? 0 : txDesc.hashCode());
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
		CssCcr009View_PK other = (CssCcr009View_PK) obj;
		if (acqquirer == null) {
			if (other.acqquirer != null)
				return false;
		} else if (!acqquirer.equals(other.acqquirer))
			return false;
		if (issuer == null) {
			if (other.issuer != null)
				return false;
		} else if (!issuer.equals(other.issuer))
			return false;
		if (productDesc == null) {
			if (other.productDesc != null)
				return false;
		} else if (!productDesc.equals(other.productDesc))
			return false;
		if (transactionCode == null) {
			if (other.transactionCode != null)
				return false;
		} else if (!transactionCode.equals(other.transactionCode))
			return false;
		if (txDesc == null) {
			if (other.txDesc != null)
				return false;
		} else if (!txDesc.equals(other.txDesc))
			return false;
		return true;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CssCcr009View_PK [acqquirer=");
		builder.append(acqquirer);
		builder.append(", issuer=");
		builder.append(issuer);
		builder.append(", txDesc=");
		builder.append(txDesc);
		builder.append(", productDesc=");
		builder.append(productDesc);
		builder.append(", transactionCode=");
		builder.append(transactionCode);
		builder.append("]");
		return builder.toString();
	}
	  
	
}
