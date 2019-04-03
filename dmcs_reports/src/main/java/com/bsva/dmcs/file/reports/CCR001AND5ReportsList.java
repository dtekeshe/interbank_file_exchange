package com.bsva.dmcs.file.reports;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author AugustineA
 *
 */
@XmlRootElement(name = "ccr001AND5Reports")
@XmlAccessorType (XmlAccessType.FIELD)
public class CCR001AND5ReportsList {
	
	@XmlElement(name = "ccr001AND5Reports")
	private List<CCR001AND5Reports> ccr001AND5ReportList = null;

	public List<CCR001AND5Reports> getCcr001AND5ReportList() {
		return ccr001AND5ReportList;
	}

	public void setCcr001AND5ReportList(List<CCR001AND5Reports> ccr001AND5Reports) {
		this.ccr001AND5ReportList = ccr001AND5Reports;
	}

}
