package com.bsva.dmcs.operations.interfaces;

import java.util.Date;
import java.util.List;

import com.bsva.dcms.commons.dto.CsoServiceParametersDTO;
import com.bsva.dmcs.operations.exceptions.SODServiceException;

public interface SODService {

	public boolean sodProcess(Date processDate) throws SODServiceException;
	public void executeInputDelivery() throws SODServiceException;
	public void executeOutdel() throws SODServiceException;
	public String[] updateServiceParameters(String subService,String serviceStatus) throws SODServiceException;
	public void moveToPrevReceive() throws SODServiceException;
	public void moveToPrevSend() throws SODServiceException;
	public void moveToArchive() throws SODServiceException;
	public void moveToPrevReport() throws SODServiceException;
	public void deleteExportFile() throws SODServiceException;
	public void generateDefaultOutputFiles() throws SODServiceException;
	public List<CsoServiceParametersDTO> getServices() throws SODServiceException;
	public void deleteNegFiles() throws SODServiceException;
}
