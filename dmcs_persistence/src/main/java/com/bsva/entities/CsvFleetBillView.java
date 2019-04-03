package com.bsva.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author AugustineA
 */
@Entity
@Table(name = "CSV_FLEET_BILL_VIEW")
@NamedQueries({
    @NamedQuery(name = "CsvFleetBillView.findAll", query = "SELECT c FROM CsvFleetBillView c")})
@DynamicUpdate
public class CsvFleetBillView implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected CsvFleetBillViewPK csvFleetBillViewPK;    
   
    @Column(name = "VALUE")
    private Double value;
    @Column(name = "VOLUME")
    private Double volume;
    @Column(name = "PERC_COST")
    private Double percCost;
    @Column(name = "COST")
    private String cost;
    @Column(name = "VAT")
    private Double vat;
    @Column(name = "TOTAL_CHARGE")
    private Double totalCharge;
    @Column(name = "NETT_AMOUNT")
    private Double nettAmount;
    
    public CsvFleetBillView() {
    }

    public CsvFleetBillView(CsvFleetBillViewPK csvFleetBillViewPK) {
		this.csvFleetBillViewPK = csvFleetBillViewPK;
	}

	public CsvFleetBillView(CsvFleetBillViewPK csvFleetBillViewPK,Double value,
			Double volume, Double percCost, String cost, Double vat, Double totalCharge, Double nettAmount) {
		super();
		this.csvFleetBillViewPK = csvFleetBillViewPK;
		this.value = value;
		this.volume = volume;
		this.percCost = percCost;
		this.cost = cost;
		this.vat = vat;
		this.totalCharge = totalCharge;
		this.nettAmount = nettAmount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public CsvFleetBillViewPK getCsvFleetBillViewPK() {
		return csvFleetBillViewPK;
	}

	

	public Double getValue() {
		return value;
	}

	public Double getVolume() {
		return volume;
	}

	public Double getPercCost() {
		return percCost;
	}

	public String getCost() {
		return cost;
	}

	public Double getVat() {
		return vat;
	}

	public Double getTotalCharge() {
		return totalCharge;
	}

	public Double getNettAmount() {
		return nettAmount;
	}

	public void setCsvFleetBillViewPK(CsvFleetBillViewPK csvFleetBillViewPK) {
		this.csvFleetBillViewPK = csvFleetBillViewPK;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}

	public void setPercCost(Double percCost) {
		this.percCost = percCost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public void setVat(Double vat) {
		this.vat = vat;
	}

	public void setTotalCharge(Double totalCharge) {
		this.totalCharge = totalCharge;
	}

	public void setNettAmount(Double nettAmount) {
		this.nettAmount = nettAmount;
	}

	

    
}
