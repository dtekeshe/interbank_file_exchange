/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsva.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author AugustineA
 */
@Entity
@Table(name = "CSF_SYSTEM_SERVICE")
@NamedQueries({
    @NamedQuery(name = "CsfSystemService.findAll", query = "SELECT c FROM CsfSystemService c"),
    @NamedQuery(name = "CsfSystemService.findByServiceCode", query = "SELECT c FROM CsfSystemService c WHERE c.serviceCode = :serviceCode")})
@DynamicUpdate
public class CsfSystemService implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "SERVICE_CODE")
    private String serviceCode;
    @OneToMany(mappedBy = "service")
    private List<CsfDistributionParameters> csfDistributionParametersList = new ArrayList<>(0);
    @OneToMany(mappedBy = "service2")
    private List<CsfMemberService> csfMemberServiceList = new ArrayList<>(0);
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "csfSystemService")
    private List<CsfMemberService> csfMemberServiceList1 = new ArrayList<>(0);
    @OneToMany(mappedBy = "service1")
    private List<CsfSubServices> csfSubServicesList = new ArrayList<>(0);
    @OneToMany(mappedBy = "serviceCode1")
    private List<CsfServices> csfServicesList = new ArrayList<>(0);
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "csfSystemService")
    private List<CsfServices> csfServicesList1 = new ArrayList<>(0);
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "service")
    private List<CsfDeliveryServices> csfDeliveryServicesList = new ArrayList<>(0);

    public List<CsfDeliveryServices> getCsfDeliveryServicesList() {
        return csfDeliveryServicesList;
    }

    public void setCsfDeliveryServicesList(
            List<CsfDeliveryServices> csfDeliveryServicesList) {
        this.csfDeliveryServicesList = csfDeliveryServicesList;
    }

    public CsfSystemService() {
    }

    public CsfSystemService(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public List<CsfDistributionParameters> getCsfDistributionParametersList() {
        return csfDistributionParametersList;
    }

    public void setCsfDistributionParametersList(List<CsfDistributionParameters> csfDistributionParametersList) {
        this.csfDistributionParametersList = csfDistributionParametersList;
    }

    public List<CsfMemberService> getCsfMemberServiceList() {
        return csfMemberServiceList;
    }

    public void setCsfMemberServiceList(List<CsfMemberService> csfMemberServiceList) {
        this.csfMemberServiceList = csfMemberServiceList;
    }

    public List<CsfMemberService> getCsfMemberServiceList1() {
        return csfMemberServiceList1;
    }

    public void setCsfMemberServiceList1(List<CsfMemberService> csfMemberServiceList1) {
        this.csfMemberServiceList1 = csfMemberServiceList1;
    }

    public List<CsfSubServices> getCsfSubServicesList() {
        return csfSubServicesList;
    }

    public void setCsfSubServicesList(List<CsfSubServices> csfSubServicesList) {
        this.csfSubServicesList = csfSubServicesList;
    }
    
    public List<CsfServices> getCsfServicesList() {
        return csfServicesList;
    }

    public void setCsfServicesList(List<CsfServices> csfServicesList) {
        this.csfServicesList = csfServicesList;
    }

    public List<CsfServices> getCsfServicesList1() {
        return csfServicesList1;
    }

    public void setCsfServicesList1(List<CsfServices> csfServicesList1) {
        this.csfServicesList1 = csfServicesList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serviceCode != null ? serviceCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof CsfSystemService)) {
            return false;
        }
        CsfSystemService other = (CsfSystemService) object;
        if ((this.serviceCode == null && other.serviceCode != null) || (this.serviceCode != null && !this.serviceCode.equals(other.serviceCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.dmcs.entities.CsfSystemService[ serviceCode=" + serviceCode + " ]";
    }

}
