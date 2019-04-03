package com.bsva.front.dmcs.controllers;

import com.bsva.dcms.commons.dao.CsoProgramControlsDAO;
import com.bsva.dcms.commons.dto.CsoProgramControlsDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SimphiweT
 */
public class CsoProgramControlsController {
    
    private String fileName ;
    
    private CsoProgramControlsDAO csoProgramControlsDAO = new CsoProgramControlsDAO();
    
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    public List<CsoProgramControlsDTO> getProgramControlsDTOList() throws DAOException {
        
        CsoProgramControlsDTO controlsDTO = new CsoProgramControlsDTO();
        controlsDTO.setArbData(getFileName());
        controlsDTO.setServiceCode("CARD");
        List<CsoProgramControlsDTO> controlsDTOList = csoProgramControlsDAO.retrieveRelated(controlsDTO);
        
        return controlsDTOList;
    }

	@Override
	public String toString() {
		return "CsoProgramControlsController [fileName=" + fileName + ", csoProgramControlsDAO=" + csoProgramControlsDAO
				+ "]";
	} 
   
    
}
