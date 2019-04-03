package com.bsva.dcms.commons.dto;

import java.io.Serializable;

public class CSFBINTotalsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int totalNumber;
	private int finallyDel;
	private int delCycle;
	private int toBeDeleted;
	private int actBins;
	
	
	public int getTotalNumber() {
		return totalNumber;
	}
	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}
	public int getFinallyDel() {
		return finallyDel;
	}
	public void setFinallyDel(int finallyDel) {
		this.finallyDel = finallyDel;
	}
	public int getDelCycle() {
		return delCycle;
	}
	public void setDelCycle(int delCycle) {
		this.delCycle = delCycle;
	}
	public int getToBeDeleted() {
		return toBeDeleted;
	}
	public void setToBeDeleted(int toBeDeleted) {
		this.toBeDeleted = toBeDeleted;
	}
	public int getActBins() {
		return actBins;
	}
	public void setActBins(int actBins) {
		this.actBins = actBins;
	}
	

}
