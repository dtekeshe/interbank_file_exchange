package com.bsva.front.dmcs.controllers;

import com.bsva.dcms.commons.dao.CSFSubServicesDAO;
import com.bsva.dcms.commons.dto.CSFSubServicesDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.dmcs.reports.CSR024;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.event.ValueChangeEvent;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;


/**
 * @author AugustineA
 *
 */
public class CSR024ReportController {

	private CSR024 csr024 = null;

	private String selectedItem;
	private Map<String, String> subServiceSelectItems;

	private CSFSubServicesDAO subServicesDAO = new CSFSubServicesDAO();

	public CSR024ReportController() throws DAOException {

		subServiceSelectItems = new HashMap<>();
		List<CSFSubServicesDTO> subServicesDTOList = getSubServices();

		for (CSFSubServicesDTO servicesDTO : subServicesDTOList) {
			subServiceSelectItems.put(servicesDTO.getSubservice(), servicesDTO.getDescription());
		}
	}

	public void buildCSR024Report(String subservice)
			throws DAOException, ParserConfigurationException, TransformerConfigurationException {

		csr024 = new CSR024();
		csr024.build(subservice);
		csr024.printTextFile();

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

	public void subServiceChanged(ValueChangeEvent e)
			throws DAOException, ParserConfigurationException, TransformerConfigurationException {
		selectedItem = e.getNewValue().toString();
		buildCSR024Report(selectedItem);
	}
}
