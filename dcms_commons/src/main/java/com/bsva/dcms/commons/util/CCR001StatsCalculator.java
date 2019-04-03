package com.bsva.dcms.commons.util;

import java.sql.Connection;
import java.util.Date;

import com.bsva.dcms.commons.dao.CsoSystemParametersDAO;
import com.bsva.dcms.commons.dao.CssCcr002StatsDAO;
import com.bsva.dcms.commons.dto.CsoSystemParametersDTO;
import com.bsva.dcms.commons.dto.CssCcr002StatsDTO;

public class CCR001StatsCalculator {

	
	public CCR001StatsCalculator(){
	}
	
	//TODO: this needs to move to end of day. Mphikeleli
	public void buildCCR002Stats(String subService){
			
		try{
			//get process date
			CsoSystemParametersDTO csoSystemParametersDTO = new CsoSystemParametersDTO();
			csoSystemParametersDTO.setProcessActiveInd("Y");
			csoSystemParametersDTO = new CsoSystemParametersDAO().retrieve(csoSystemParametersDTO);
			Date processDate = csoSystemParametersDTO.getProcessDate();
				
		    //delete stats
			CssCcr002StatsDTO ccr002StatsDTO = new CssCcr002StatsDTO();
			ccr002StatsDTO.setProcessDate(processDate);
			ccr002StatsDTO.setSubService(subService);
			//new CssCcr002StatsDAO(connection).delete(ccr002StatsDTO);
				
			//insert new stats
				
				
				
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
