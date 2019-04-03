package com.bsva.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

/**
 * @author AugustineA
 *
 */
@Entity
@Table(name = "CSS_CCR009_VIEW")
@DynamicUpdate
public class CssCcr009View implements Serializable {
	
	
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	  private CssCcr009View_PK cssCcr009View_Pk;	  
	  @Column(name = "VOLUME")
	  private String volume;
	  @Column(name = "VALUE")
	  private String value;
	  @Column(name = "PRODUCT_CODE")
	  private String productCode;
	  @Column(name = "SUB_PRODUCT")
	  private String subProduct;
	  
	  public CssCcr009View(){
		  
	  }

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public CssCcr009View_PK getCssCcr009View_Pk() {
		return cssCcr009View_Pk;
	}

	public String getVolume() {
		return volume;
	}

	public String getValue() {
		return value;
	}

	public String getProductCode() {
		return productCode;
	}

	public String getSubProduct() {
		return subProduct;
	}

	public void setCssCcr009View_Pk(CssCcr009View_PK cssCcr009View_Pk) {
		this.cssCcr009View_Pk = cssCcr009View_Pk;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public void setSubProduct(String subProduct) {
		this.subProduct = subProduct;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cssCcr009View_Pk == null) ? 0 : cssCcr009View_Pk.hashCode());
		result = prime * result + ((productCode == null) ? 0 : productCode.hashCode());
		result = prime * result + ((subProduct == null) ? 0 : subProduct.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		result = prime * result + ((volume == null) ? 0 : volume.hashCode());
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
		CssCcr009View other = (CssCcr009View) obj;
		if (cssCcr009View_Pk == null) {
			if (other.cssCcr009View_Pk != null)
				return false;
		} else if (!cssCcr009View_Pk.equals(other.cssCcr009View_Pk))
			return false;
		if (productCode == null) {
			if (other.productCode != null)
				return false;
		} else if (!productCode.equals(other.productCode))
			return false;
		if (subProduct == null) {
			if (other.subProduct != null)
				return false;
		} else if (!subProduct.equals(other.subProduct))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		if (volume == null) {
			if (other.volume != null)
				return false;
		} else if (!volume.equals(other.volume))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CssCcr009View [cssCcr009View_Pk=");
		builder.append(cssCcr009View_Pk);
		builder.append(", volume=");
		builder.append(volume);
		builder.append(", value=");
		builder.append(value);
		builder.append(", productCode=");
		builder.append(productCode);
		builder.append(", subProduct=");
		builder.append(subProduct);
		builder.append("]");
		return builder.toString();
	}
	    
	

}
