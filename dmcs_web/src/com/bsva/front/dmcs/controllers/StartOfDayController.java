package com.bsva.front.dmcs.controllers;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import com.bsva.dcms.commons.enums.Status;
import com.bsva.front.dmcs.service.interfaces.DmcsFacadeRemote;
import com.bsva.front.dmcs.utils.JsfUtil;

@ManagedBean
@ViewScoped
public class StartOfDayController implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    DmcsFacadeRemote remoteServiceFacade;

    private Date sodDate;
    private static final String PROCESS_NAME = "SOD";
    private static final String SERVICE_NAME = "CARD";
    private static final String SUB_SERVICE_NAME = "ALL";

    public StartOfDayController() {

    }

    public String executeSOD() {

        remoteServiceFacade.updateProcessActiveInd(PROCESS_NAME, SERVICE_NAME, SUB_SERVICE_NAME, Status.Y.getSymbol(), getSodDate());
        
        //HELPER FUNCTION IN THE EVENT THE REMOTE FACADE IS DEAD!!!!!
        
        
        
        JsfUtil.addSuccessMessage("SOD Indicator Set to : " + Status.Y.getSymbol());

         return "landing.xhtml?faces-redirect=true";
       // return " ";
    }
    
    public void forceStartOfDay() {
        
    }

    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }

    public Date getSodDate() {
        return sodDate;
    }

    public void setSodDate(Date sodDate) {
        this.sodDate = sodDate;
    }

}
