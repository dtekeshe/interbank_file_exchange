package com.bsva.entities.v02.commons;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EndOfDayFlagEntity implements Serializable {

	@Id
	@Column(name = "END_OF_DAY_FLAG")
	private Integer endOfDayFlag;

	public Integer getEndOfDayFlag() {
		return endOfDayFlag;
	}

	public void setEndOfDayFlag(Integer endOfDayFlag) {
		this.endOfDayFlag = endOfDayFlag;
	}
	
	
}
