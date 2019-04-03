package com.bsva.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

	/**
	 *
	 * @author AugustineA
	 */
	@Entity
	@Table(name = "CSV_CCR002_VIEW")
	@DynamicUpdate
	public class CsvCcr002View implements Serializable {
		
	    private static final long serialVersionUID = 1L;
	    @EmbeddedId
	    private CsvCcr002View_PK csvCcr015ViewPK;
	    @Column(name = "ACQ_FEES")
	    private String acquiringFees;
	    @Column(name = "ISS_FEES")
	    private String issuerFees;
	    @Column(name = "NETT_FEES")
	    private Long nettFees;
	    @Column(name = "INVOICE_NO_CCR001")
	    private Long invoiceNumber;

		public CsvCcr002View() {
	    }

		public CsvCcr002View(CsvCcr002View_PK csvCcr015ViewPK, String acquiringFees, String issuerFees, Long nettFees,
				Long invoiceNumber) {
			super();
			this.csvCcr015ViewPK = csvCcr015ViewPK;
			this.acquiringFees = acquiringFees;
			this.issuerFees = issuerFees;
			this.nettFees = nettFees;
			this.invoiceNumber = invoiceNumber;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		public CsvCcr002View_PK getCsvCcr015ViewPK() {
			return csvCcr015ViewPK;
		}

		public String getAcquiringFees() {
			return acquiringFees;
		}

		public String getIssuerFees() {
			return issuerFees;
		}

		public Long getNettFees() {
			return nettFees;
		}

		public Long getInvoiceNumber() {
			return invoiceNumber;
		}

		public void setCsvCcr015ViewPK(CsvCcr002View_PK csvCcr015ViewPK) {
			this.csvCcr015ViewPK = csvCcr015ViewPK;
		}

		public void setAcquiringFees(String acquiringFees) {
			this.acquiringFees = acquiringFees;
		}

		public void setIssuerFees(String issuerFees) {
			this.issuerFees = issuerFees;
		}

		public void setNettFees(Long nettFees) {
			this.nettFees = nettFees;
		}

		public void setInvoiceNumber(Long invoiceNumber) {
			this.invoiceNumber = invoiceNumber;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("CsvCcr002View [csvCcr015ViewPK=");
			builder.append(csvCcr015ViewPK);
			builder.append(", acquiringFees=");
			builder.append(acquiringFees);
			builder.append(", issuerFees=");
			builder.append(issuerFees);
			builder.append(", nettFees=");
			builder.append(nettFees);
			builder.append(", invoiceNumber=");
			builder.append(invoiceNumber);
			builder.append("]");
			return builder.toString();
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((acquiringFees == null) ? 0 : acquiringFees.hashCode());
			result = prime * result + ((csvCcr015ViewPK == null) ? 0 : csvCcr015ViewPK.hashCode());
			result = prime * result + ((invoiceNumber == null) ? 0 : invoiceNumber.hashCode());
			result = prime * result + ((issuerFees == null) ? 0 : issuerFees.hashCode());
			result = prime * result + ((nettFees == null) ? 0 : nettFees.hashCode());
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
			CsvCcr002View other = (CsvCcr002View) obj;
			if (acquiringFees == null) {
				if (other.acquiringFees != null)
					return false;
			} else if (!acquiringFees.equals(other.acquiringFees))
				return false;
			if (csvCcr015ViewPK == null) {
				if (other.csvCcr015ViewPK != null)
					return false;
			} else if (!csvCcr015ViewPK.equals(other.csvCcr015ViewPK))
				return false;
			if (invoiceNumber == null) {
				if (other.invoiceNumber != null)
					return false;
			} else if (!invoiceNumber.equals(other.invoiceNumber))
				return false;
			if (issuerFees == null) {
				if (other.issuerFees != null)
					return false;
			} else if (!issuerFees.equals(other.issuerFees))
				return false;
			if (nettFees == null) {
				if (other.nettFees != null)
					return false;
			} else if (!nettFees.equals(other.nettFees))
				return false;
			return true;
		}
		
		
	}

