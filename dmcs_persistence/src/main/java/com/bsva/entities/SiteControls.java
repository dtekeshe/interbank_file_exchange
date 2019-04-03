/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsva.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author AugustineA
 */
@Entity
@Table(name = "SITE_CONTROLS")
@NamedQueries({
    @NamedQuery(name = "SiteControls.findAll", query = "SELECT s FROM SiteControls s"),
    @NamedQuery(name = "SiteControls.findBySiteCode", query = "SELECT s FROM SiteControls s WHERE s.siteCode = :siteCode"),
    @NamedQuery(name = "SiteControls.findBySiteName", query = "SELECT s FROM SiteControls s WHERE s.siteName = :siteName"),
    @NamedQuery(name = "SiteControls.findByDbName", query = "SELECT s FROM SiteControls s WHERE s.dbName = :dbName"),
    @NamedQuery(name = "SiteControls.findByMenuEod", query = "SELECT s FROM SiteControls s WHERE s.menuEod = :menuEod"),
    @NamedQuery(name = "SiteControls.findBySpolog", query = "SELECT s FROM SiteControls s WHERE s.spolog = :spolog"),
    @NamedQuery(name = "SiteControls.findByReports", query = "SELECT s FROM SiteControls s WHERE s.reports = :reports"),
    @NamedQuery(name = "SiteControls.findByApps", query = "SELECT s FROM SiteControls s WHERE s.apps = :apps"),
    @NamedQuery(name = "SiteControls.findByReceive", query = "SELECT s FROM SiteControls s WHERE s.receive = :receive"),
    @NamedQuery(name = "SiteControls.findBySend", query = "SELECT s FROM SiteControls s WHERE s.send = :send"),
    @NamedQuery(name = "SiteControls.findByPrev", query = "SELECT s FROM SiteControls s WHERE s.prev = :prev"),
    @NamedQuery(name = "SiteControls.findByRestore", query = "SELECT s FROM SiteControls s WHERE s.restore = :restore"),
    @NamedQuery(name = "SiteControls.findBySystemStatus", query = "SELECT s FROM SiteControls s WHERE s.systemStatus = :systemStatus"),
    @NamedQuery(name = "SiteControls.findByDefaultCentre", query = "SELECT s FROM SiteControls s WHERE s.defaultCentre = :defaultCentre")})
@DynamicUpdate
public class SiteControls implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "SITE_CODE")
    private String siteCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "SITE_NAME")
    private String siteName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "DB_NAME")
    private String dbName;
    @Size(max = 1)
    @Column(name = "MENU_EOD")
    private String menuEod;
    @Size(max = 100)
    @Column(name = "SPOLOG")
    private String spolog;
    @Size(max = 100)
    @Column(name = "REPORTS")
    private String reports;
    @Size(max = 100)
    @Column(name = "APPS")
    private String apps;
    @Size(max = 100)
    @Column(name = "RECEIVE")
    private String receive;
    @Size(max = 100)
    @Column(name = "SEND")
    private String send;
    @Size(max = 100)
    @Column(name = "PREV")
    private String prev;
    @Size(max = 100)
    @Column(name = "RESTORE")
    private String restore;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "SYSTEM_STATUS")
    private String systemStatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "DEFAULT_CENTRE")
    private String defaultCentre;

    public SiteControls() {
    }

    public SiteControls(String siteCode) {
        this.siteCode = siteCode;
    }

    public SiteControls(String siteCode, String siteName, String dbName, String systemStatus, String defaultCentre) {
        this.siteCode = siteCode;
        this.siteName = siteName;
        this.dbName = dbName;
        this.systemStatus = systemStatus;
        this.defaultCentre = defaultCentre;
    }

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getMenuEod() {
        return menuEod;
    }

    public void setMenuEod(String menuEod) {
        this.menuEod = menuEod;
    }

    public String getSpolog() {
        return spolog;
    }

    public void setSpolog(String spolog) {
        this.spolog = spolog;
    }

    public String getReports() {
        return reports;
    }

    public void setReports(String reports) {
        this.reports = reports;
    }

    public String getApps() {
        return apps;
    }

    public void setApps(String apps) {
        this.apps = apps;
    }

    public String getReceive() {
        return receive;
    }

    public void setReceive(String receive) {
        this.receive = receive;
    }

    public String getSend() {
        return send;
    }

    public void setSend(String send) {
        this.send = send;
    }

    public String getPrev() {
        return prev;
    }

    public void setPrev(String prev) {
        this.prev = prev;
    }

    public String getRestore() {
        return restore;
    }

    public void setRestore(String restore) {
        this.restore = restore;
    }

    public String getSystemStatus() {
        return systemStatus;
    }

    public void setSystemStatus(String systemStatus) {
        this.systemStatus = systemStatus;
    }

    public String getDefaultCentre() {
        return defaultCentre;
    }

    public void setDefaultCentre(String defaultCentre) {
        this.defaultCentre = defaultCentre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (siteCode != null ? siteCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SiteControls)) {
            return false;
        }
        SiteControls other = (SiteControls) object;
        if ((this.siteCode == null && other.siteCode != null) || (this.siteCode != null && !this.siteCode.equals(other.siteCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsva.dmcs.entities.SiteControls[ siteCode=" + siteCode + " ]";
    }
    
}
