package com.bsva.dcms.commons.dto;
import java.util.Date;
import java.io.Serializable;
import java.sql.Timestamp;

/**
* Data access object interface that defines the methods that must be supported
* by all data access objects.
*
* Created By BSVATools
*/

public class CsoCptConfirmationsDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String checkPoint;
	private String service;
	private String subService;
	private Date cptProcessDate;
	private String cptConfirmed;
	private String cptConfirmedUser;
	private Timestamp cptConfirmationRaised;
	private Timestamp cptConfirmedTime;

	public String getCheckPoint() {
		return this.checkPoint;
	}

	public void setCheckPoint(String checkPoint) {
		this.checkPoint=checkPoint;
	}

	public String getService() {
		return this.service;
	}

	public void setService(String service) {
		this.service=service;
	}

	public String getSubService() {
		return this.subService;
	}

	public void setSubService(String subService) {
		this.subService=subService;
	}

	public Date getCptProcessDate() {
		return this.cptProcessDate;
	}

	public void setCptProcessDate(Date cptProcessDate) {
		this.cptProcessDate=cptProcessDate;
	}

	public String getCptConfirmed() {
		return this.cptConfirmed;
	}

	public void setCptConfirmed(String cptConfirmed) {
		this.cptConfirmed=cptConfirmed;
	}

	public String getCptConfirmedUser() {
		return this.cptConfirmedUser;
	}

	public void setCptConfirmedUser(String cptConfirmedUser) {
		this.cptConfirmedUser=cptConfirmedUser;
	}

	public Timestamp getCptConfirmationRaised() {
		return this.cptConfirmationRaised;
	}

	public void setCptConfirmationRaised(Timestamp cptConfirmationRaised) {
		this.cptConfirmationRaised=cptConfirmationRaised;
	}

	public Timestamp getCptConfirmedTime() {
		return this.cptConfirmedTime;
	}

	public void setCptConfirmedTime(Timestamp cptConfirmedTime) {
		this.cptConfirmedTime=cptConfirmedTime;
	}
}
