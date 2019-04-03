package com.bsva.dmcs.file.reports;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author AugustineA
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ccr001Data")
public class CCR001DataList {
	
	@XmlElement(name = "ccr001Data", type = CCR001DataList.class)
	private List<CCR001Data1> list = new ArrayList<>();

	public List<CCR001Data1> getList() {
		return list;
	}

	public void setList(List<CCR001Data1> list) {
		this.list = list;
	}

	public CCR001DataList() {
		super();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(list);
		return builder.toString();
	}

}
