package com.bsva.front.dmcs.controllers;

import com.bsva.dcms.commons.dao.CsfDeliveryServicesDAO;
import com.bsva.dcms.commons.dto.CsfDeliveryServicesDTO;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import com.bsva.dcms.commons.enums.Status;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.front.dmcs.service.interfaces.DmcsFacadeRemote;
import com.bsva.front.dmcs.utils.JsfUtil;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.faces.event.ValueChangeEvent;



@ManagedBean
@ViewScoped
public class EndOfDayController implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    Logger logger = Logger.getLogger(EndOfDayController.class);

    @EJB
    DmcsFacadeRemote remoteServiceFacade;



    private static final String PROCESS_NAME = "EOD";
    private static final String SERVICE_NAME = "CARD";
    private static final String SUB_SERVICE_NAME = "ALL";

    private Map<String, String> subServiceSelectItems;
    private String selectedItem;
    private CsfDeliveryServicesDAO subServicesDAO = new CsfDeliveryServicesDAO();
    private List<CsfDeliveryServicesDTO> csfSubServicesRetrievedList = new ArrayList<>();    

    public EndOfDayController() throws DAOException {

        csfSubServicesRetrievedList = getSubServiceList();        
        subServiceSelectItems = new LinkedHashMap<>();
        
        for (Object subServicesDTO : getSubServiceList()) {
            CsfDeliveryServicesDTO fSubServicesDTO = (CsfDeliveryServicesDTO) subServicesDTO;
            subServiceSelectItems.put(fSubServicesDTO.getSubService(), fSubServicesDTO.getSubService());
        }        
    }

    @PostConstruct
    public void getServices() {

    }
    
    public void subServiceChanged(ValueChangeEvent e) throws DAOException {        
        selectedItem = e.getNewValue().toString();
    }

    public String executeEOD() {

        remoteServiceFacade.updateProcessActiveInd(PROCESS_NAME, SERVICE_NAME, getSelectedItem(), Status.Y.getSymbol(), null);
        remoteServiceFacade.actvateSchduleProcess("SETTLE", Status.Y.getSymbol());
        remoteServiceFacade.actvateSchduleProcess("EOD", Status.Y.getSymbol());
        JsfUtil.addSuccessMessage("EOD Indicator Set to : " + Status.Y.getSymbol());

        return "landing.xhtml?faces-redirect=true";
    }

    public List<CsfDeliveryServicesDTO> getSubServiceList() throws DAOException {
        
        CsfDeliveryServicesDTO servicesDTO = new CsfDeliveryServicesDTO();
        servicesDTO.setActiveIndicator("Y");
        servicesDTO.setInwardOutwardInd("O");
        List<CsfDeliveryServicesDTO> subServicesDTOList = subServicesDAO.retrieveRelated(servicesDTO);
        return subServicesDTOList;
    }

    public Map<String, String> getSubServiceSelectItems() {
        return subServiceSelectItems;
    }

    public void setSubServiceSelectItems(Map<String, String> subServiceSelectItems) {
        this.subServiceSelectItems = subServiceSelectItems;
    }

    public String getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(String selectedItem) {
        this.selectedItem = selectedItem;
    }
    
    

}
