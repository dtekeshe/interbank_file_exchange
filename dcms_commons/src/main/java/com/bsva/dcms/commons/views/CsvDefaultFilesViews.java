package com.bsva.dcms.commons.views;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.bsva.dcms.commons.dao.CSFMembersDAO;
import com.bsva.dcms.commons.dao.CSFMembersServiceDAO;
import com.bsva.dcms.commons.dao.CsfDeliveryServicesDAO;
import com.bsva.dcms.commons.dto.CSFMemberServiceDTO;
import com.bsva.dcms.commons.dto.CSFMembersDTO;
import com.bsva.dcms.commons.dto.CSFSubServicesDTO;
import com.bsva.dcms.commons.dto.CsfDeliveryServicesDTO;
import com.bsva.dcms.commons.dto.views.CsvDefaultFilesViewDto;
import com.bsva.dcms.commons.exceptions.DAOException;

public class CsvDefaultFilesViews {
	
	

	public CsvDefaultFilesViews() {
		
	}
	
public 	List<CsvDefaultFilesViewDto> execute(CSFSubServicesDTO subServices){
	
	
	 List<CsvDefaultFilesViewDto> newListView = new ArrayList<CsvDefaultFilesViewDto>();
	
	List<CsvDefaultFilesViewDto> defaultFiles = build();

	
	for(CsvDefaultFilesViewDto dataA : defaultFiles){
		
		int seq = 1;
		String originatingId = "";
		String subService  = "";
		
		 List<CsvDefaultFilesViewDto> views = new ArrayList<CsvDefaultFilesViewDto>();
		
         for(CsvDefaultFilesViewDto dataB :  defaultFiles){
        	 
        	 CsvDefaultFilesViewDto view = new CsvDefaultFilesViewDto();

        	 if(dataA.getSubService().equals(dataB.getSubService()) && dataA.getService().equals(dataB.getService()) ){
        		 
        		 view.setBankCode(dataA.getBankCode()); 
        		 view.setDestBankId(dataA.getDestBankId());
        		 view.setOriginatingBank(dataB.getOriginatingBank()); 
        		 view.setOriginatingId(dataB.getDestBankId());
        		 view.setFilePrefix(dataA.getFilePrefix());
        		 view.setService(dataB.getService()); 
        		 view.setSubService(dataB.getSubService());
        		 view.setSeq(seq); 
        		 view.setLastFileInd("N"); 
       
        		 originatingId = view.getOriginatingId();
        		 subService = view.getSubService();
        		 
        		 views.add(view);
        		
        		 newListView.add(view);
                 
        		 seq = seq + 1;
        	 }
         }
         
     	if(newListView.size() > 0){
    		
    		for(CsvDefaultFilesViewDto updateView : newListView){
    			
    			if(updateView.getOriginatingId().equals(originatingId) 
    					&& updateView.getSubService().equals(subService) 
    					&& updateView.getSeq() == views.size()){
    				
    				updateView.setLastFileInd("N"); 
    			}  
    		}
    	}
		
	}
	
	return newListView;
}
		
public List<CsvDefaultFilesViewDto> build(){
	
	List<CSFMemberServiceDTO> memberServices = getMemberService();
	
	List<CsvDefaultFilesViewDto> listView = new ArrayList<CsvDefaultFilesViewDto>();
	
	try {
		CsfDeliveryServicesDAO csfDeliveryServicesdao = new CsfDeliveryServicesDAO();
		List<CsfDeliveryServicesDTO> delDelList = csfDeliveryServicesdao.retrieveRelated(null);
		
		for(CSFMemberServiceDTO memberService : memberServices){
			
			for(CsfDeliveryServicesDTO delService : delDelList){
				
				if(memberService.getService().equals(delService.getService())
						&& "Y".equals(delService.getActiveIndicator())
						&& "O".equals(delService.getInwardOutwardInd())
					    && !(delService.getSubService().contains("VAL")) 
						&& !(delService.getSubService().contains("REP"))
						&& memberService.getSubService().substring(0, 3).equals(delService.getSubService().substring(0, 3))){
					
						CsvDefaultFilesViewDto view = new CsvDefaultFilesViewDto();
						
						view.setBankCode(memberService.getBankCode()); 
						view.setDestBankId(memberService.getMemberTapeid());
						view.setOriginatingBank(memberService.getBankCode()); 
						view.setFilePrefix(delService.getFilenamePrefix()); 
						view.setService(memberService.getService()); 
						view.setSubService(memberService.getSubService());
						
						listView.add(view);	
					}  
				}   
		}
			
	} catch (DAOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return listView; 
}

public List<CSFMemberServiceDTO> getMemberService(){
	
	List<CSFMemberServiceDTO> newMemberServices = new ArrayList<CSFMemberServiceDTO>();
	
	try {
		CSFMembersServiceDAO csFMembersServicedao = new CSFMembersServiceDAO() ;
		List<CSFMemberServiceDTO> memberServices = csFMembersServicedao.retrieveRelated(null);
		CSFMembersDAO csFMembersdao =  new  CSFMembersDAO();
		List<CSFMembersDTO> members = csFMembersdao.retrieveRelated(null);
		
		for(CSFMemberServiceDTO memberService : memberServices){
			
				for(CSFMembersDTO member : members){
					
					if(memberService.getBankCode() == member.getBankCode() 
							&& member.getMnemonicMemberName() != null 
							&& !memberService.getSubService().contains("VAL")){
						
						newMemberServices.add(memberService);
					}
				}
		}
		
	} catch (DAOException e) {
		e.printStackTrace();
	}
	return newMemberServices;  
	
}


}
