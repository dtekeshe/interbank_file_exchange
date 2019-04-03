package com.bsva.dcms.commons.util;

import java.sql.Connection;

import com.bsva.dcms.commons.dao.CsfFilenameLookupDAO;
import com.bsva.dcms.commons.dao.CsoSeqNumbersDAO;
import com.bsva.dcms.commons.dto.CsfFilenameLookupDTO;
import com.bsva.dcms.commons.dto.CsoSeqNumbersDTO;
import com.bsva.dcms.commons.exceptions.DAOException;

public class FileNameGenerator{ //extends DatabaseAccessor{
	
	
	public FileNameGenerator(){
	}

	public String generateFile(String fileNamePrefix, String destinationId) throws DAOException{
		
		CsoSeqNumbersDAO csoNumbersDAO = new CsoSeqNumbersDAO();
		
		CsoSeqNumbersDTO csoSeqNumbersDTO = new CsoSeqNumbersDTO();
		csoSeqNumbersDTO.setExternalFilenamePrefix(fileNamePrefix);
		csoSeqNumbersDTO.setDistributionCode(destinationId);
		Long count = csoNumbersDAO.retrieveRowCount(csoSeqNumbersDTO);
		
		if (count == 0){
			csoSeqNumbersDTO = new CsoSeqNumbersDTO();
			csoSeqNumbersDTO.setExternalFilenamePrefix(fileNamePrefix);
			csoSeqNumbersDTO.setDistributionCode(destinationId);
			csoSeqNumbersDTO.setLastSeqNumberUsed(1);
			csoNumbersDAO.create(csoSeqNumbersDTO);
		}else{
			csoSeqNumbersDTO = csoNumbersDAO.retrieve(csoSeqNumbersDTO);
			int lastSequenceUsed = csoSeqNumbersDTO.getLastSeqNumberUsed() + 1;
			csoSeqNumbersDTO.setLastSeqNumberUsed(lastSequenceUsed);
			csoNumbersDAO.update(csoSeqNumbersDTO);
		}
		
		CsfFilenameLookupDAO filenameDAO = new CsfFilenameLookupDAO();
		CsfFilenameLookupDTO filenameLookupDTO = new CsfFilenameLookupDTO();
		filenameLookupDTO.setNumIndex(csoSeqNumbersDTO.getLastSeqNumberUsed());
		filenameLookupDTO = filenameDAO.retrieve(filenameLookupDTO);
		
		if (filenameLookupDTO ==  null)
			return null;
		
		String filename = csoSeqNumbersDTO.getExternalFilenamePrefix() + csoSeqNumbersDTO.getDistributionCode() +
				filenameLookupDTO.getAlphaSeq() + "D";
			
		return filename;
	}
	
}
