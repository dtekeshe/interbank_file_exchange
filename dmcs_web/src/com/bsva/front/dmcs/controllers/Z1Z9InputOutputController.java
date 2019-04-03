package com.bsva.front.dmcs.controllers;

import com.bsva.dcms.commons.dao.CSFSubServicesDAO;
import com.bsva.dcms.commons.dao.CsoInputFileControlsDAO;
import com.bsva.dcms.commons.dao.CsoOutputControlsDAO;
import com.bsva.dcms.commons.dto.CSFSubServicesDTO;
import com.bsva.dcms.commons.dto.CsoInputFileControlsDTO;
import com.bsva.dcms.commons.dto.CsoOutputControlsDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.event.ValueChangeEvent;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;

/**
 *
 * @author SimphiweT
 */

public class Z1Z9InputOutputController {

    private CsoInputFileControlsDAO inputFileControlsDAO = new CsoInputFileControlsDAO();
    private CsoOutputControlsDAO outputControlsDAO = new CsoOutputControlsDAO();
    private List<CsoInputFileControlsDTO> controlsViewList = null;
    private List<CsoOutputControlsDTO> outputControlsViewList = null;

    private String selectedItem;
    private String selectedControl;
    
    private Map<String, String> controlSelectedItems;
    private Map<String, String> subServiceSelectItems;
    private Boolean inputControlSelected = false;
    private Boolean outputControlSelected = false;

    private CSFSubServicesDAO subServicesDAO = new CSFSubServicesDAO();

    public Z1Z9InputOutputController() throws DAOException {

        controlSelectedItems = new HashMap<>();
        subServiceSelectItems = new HashMap<>();
        
        controlsViewList = new ArrayList<>();
        outputControlsViewList = new ArrayList<>();

        controlSelectedItems.put("INPUT","INPUT");
        controlSelectedItems.put("OUTPUT","OUTPUT");
        
        List<CSFSubServicesDTO> subServicesDTOList = getSubServices();

        for (CSFSubServicesDTO servicesDTO : subServicesDTOList) {
            subServiceSelectItems.put(servicesDTO.getSubservice(), servicesDTO.getSubservice());
        }
    }

    /**
     * @param subService
     * @return
     * @throws DAOException
     */
    public List<CsoInputFileControlsDTO> getCsoInputFileControls(String subService) throws DAOException {
        CsoInputFileControlsDTO controlsDTO = new CsoInputFileControlsDTO();
        controlsDTO.setSubService(subService);
        List<CsoInputFileControlsDTO> controlsDTOList = inputFileControlsDAO.retrieveRelated(controlsDTO);
        
        return controlsDTOList;
    }

    public List<CsoOutputControlsDTO> getCsoOutputControls(String subService) throws DAOException {
        CsoOutputControlsDTO outputControlsDTO = new CsoOutputControlsDTO();
        outputControlsDTO.setSubService(subService);
        List<CsoOutputControlsDTO> outputControlsDTOList = outputControlsDAO.retrieveRelated(outputControlsDTO);
        
        return outputControlsDTOList;
    }

    public List<CSFSubServicesDTO> getSubServices() throws DAOException {

        CSFSubServicesDTO subServicesDTO = new CSFSubServicesDTO();
        subServicesDTO.setActiveIndicator("Y");
        List<CSFSubServicesDTO> subServicesDTOList = subServicesDAO.retrieveRelated(subServicesDTO);

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

    public List<CsoInputFileControlsDTO> getControlsViewList() {
    	try {
			controlsViewList = getCsoInputFileControls(subServiceSelectItems.get(selectedItem));
		} catch (DAOException e) {
			e.printStackTrace();
		}
    	
        return controlsViewList;
    }

    public void setControlsViewList(List<CsoInputFileControlsDTO> controlsViewList) {
        this.controlsViewList = controlsViewList;
    }

    public List<CsoOutputControlsDTO> getOutputControlsViewList() {
    	try {
			outputControlsViewList = getCsoOutputControls(subServiceSelectItems.get(selectedItem));
		} catch (DAOException e) {
			e.printStackTrace();
		}
        return outputControlsViewList;
    }

    public void setOutputControlsViewList(List<CsoOutputControlsDTO> outputControlsViewList) {
    	this.outputControlsViewList = outputControlsViewList;
    }

    public String getSelectedControl() {
        return selectedControl;
    }

    public void setSelectedControl(String selectedControl) {
        this.selectedControl = selectedControl;
    }


    public Map<String, String> getControlSelectedItems() {
        return controlSelectedItems;
    }

    public void setControlSelectedItems(Map<String, String> controlSelectedItems) {
        this.controlSelectedItems = controlSelectedItems;
    }

    public void subServiceChanged(ValueChangeEvent e) throws DAOException, ParserConfigurationException, TransformerConfigurationException {
           
        selectedItem = e.getNewValue().toString();
        controlsViewList = getCsoInputFileControls(selectedItem);
        outputControlsViewList = getCsoOutputControls(selectedItem);
    }  
    
    public void controlChanged(ValueChangeEvent e) throws DAOException, ParserConfigurationException, TransformerConfigurationException {
        
        selectedControl = e.getNewValue().toString();     
         if ("INPUT".equals(selectedControl)) {
            inputControlSelected = true;
            outputControlSelected = false;
        } 
        
        if ("OUTPUT".equals(selectedControl)) {
            outputControlSelected = true;
            inputControlSelected = false;
        }     
    }  

    public Boolean getInputControlSelected() {
        return inputControlSelected;
    }

    public void setInputControlSelected(Boolean inputControlSelected) {
        this.inputControlSelected = inputControlSelected;
    }

    public Boolean getOutputControlSelected() {
        return outputControlSelected;
    }

    public void setOutputControlSelected(Boolean outputControlSelected) {
        this.outputControlSelected = outputControlSelected;
    }
    
    
    
}
