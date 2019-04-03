package com.bsva.dmcs.operations.businesslogic;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.sql.DataSource;

import com.bsva.dao.v02.startofday.DefaultOutputFilesDAO;
import com.bsva.dao.v02.util.DatabaseException;
import com.bsva.dcms.commons.dao.CsoOutputControlsDAO;
import com.bsva.dcms.commons.dao.CsoSeqNumbersDAO;
import com.bsva.dcms.commons.dao.CsoServiceParametersDAO;
import com.bsva.dcms.commons.dao.CsoSystemParametersDAO;
import com.bsva.dcms.commons.dao.CsvDefaultFilesViewDAO;
import com.bsva.dcms.commons.dto.CSFSubServicesDTO;
import com.bsva.dcms.commons.dto.CsoOutputControlsDTO;
import com.bsva.dcms.commons.dto.CsoSeqNumbersDTO;
import com.bsva.dcms.commons.dto.CsoServiceParametersDTO;
import com.bsva.dcms.commons.dto.CsoSystemParametersDTO;
import com.bsva.dcms.commons.dto.CsvDefaultFilesViewDTO;
import com.bsva.dcms.commons.dto.views.CsvDefaultFilesViewDto;
import com.bsva.dcms.commons.enums.Status;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.dcms.commons.util.BsvTableLookup;
import com.bsva.dcms.commons.util.Utils;
import com.bsva.dcms.commons.views.CsvDefaultFilesViews;

/**
 * @author Mphikeleli
 *
 */
public class DmcsDefaultOutputFiles {

	private final Logger log = Logger.getLogger(DmcsDefaultOutputFiles.class.getName());

	@Resource(lookup = "java:jboss/datasources/DMCSDb")
    private DataSource datasource;
	private static final String PROCESSNAME = "DmcsDefaultOutputFiles";

	public DmcsDefaultOutputFiles() {
	}

	public void generateDefaultOutputFiles() throws DAOException{

		DefaultOutputFilesDAO defaultOutputFilesDAO = new DefaultOutputFilesDAO();
		try {
			defaultOutputFilesDAO.createDefaultOutputFiles();
			
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
		/*CSFSubServicesDTO subService = new CSFSubServicesDTO();
		List<CsvDefaultFilesViewDto> viewData = new CsvDefaultFilesViews().execute(subService);

		
		if(viewData != null && viewData.size() > 0){
             Utils.logSpolog("#####---------- about to generate output files-----------#####",PROCESSNAME);
			//1. Delete CSO_SEQ_NUMBERS
			deleteSeqNumbers();
			//2. Delete CSO_OUTPUT_CONTROLS
			deleteOutputControls();
			CsoOutputControlsDAO outputControlDao = new CsoOutputControlsDAO();
			CsoSeqNumbersDAO csoNumbersDAO = new CsoSeqNumbersDAO();
			
			for(CsvDefaultFilesViewDto defaultFile : viewData){

				CsoOutputControlsDTO outputControl = new CsoOutputControlsDTO();
				//updateServiceParameters(defaultFile.getSubService());
				try {
					outputControl.setBankCode(defaultFile.getBankCode()); 
					outputControl.setService(defaultFile.getService()); 
					outputControl.setSubService(defaultFile.getSubService());
					outputControl.setFilenamePrefix(defaultFile.getFilePrefix());
					outputControl.setDistributionCode(defaultFile.getDestBankId()); 

					String seqNumber = Utils.leftJustifyWithZeros(String.valueOf(defaultFile.getSeq()),3);

					String filename = outputControl.getFilenamePrefix() + outputControl.getDistributionCode() + seqNumber + "D";

					outputControl.setSeqNumber(seqNumber); 

					outputControl.setFilenameDescription(filename);

					outputControl.setTransmissionDate(new Date());

					outputControl.setOriginatingBankId(defaultFile.getOriginatingId());
					outputControl.setOriginatingMember(defaultFile.getOriginatingBank()); 
					outputControl.setLastFileIndicator(defaultFile.getLastFileInd());
					outputControl.setStatusCode(Status.O.getSymbol());
					outputControl.setRecordCountForDay(0L);
					outputControl.setFullFileInd(Status.D.getSymbol());

					//3. Insert New Default Values
					outputControlDao.create(outputControl);
					
					//4 Insert Last Sequence Value
					if("Y".equals(outputControl.getLastFileIndicator())){
						CsoSeqNumbersDTO csoSeqNumbersDTO = new CsoSeqNumbersDTO();
						csoSeqNumbersDTO.setExternalFilenamePrefix(outputControl.getFilenamePrefix());
						csoSeqNumbersDTO.setDistributionCode(outputControl.getDistributionCode());
						csoSeqNumbersDTO.setLastSeqNumberUsed(Integer.valueOf(outputControl.getSeqNumber()));
						
						
						csoNumbersDAO.create(csoSeqNumbersDTO);
					}

				} catch (DAOException e ) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
			}
			Utils.logSpolog("Successfully Populated CsoOutputCotrol Table",PROCESSNAME);
			 Utils.logSpolog("#####------Successfully Populated CsoOutputCotrol Table----------######",PROCESSNAME);
		}*/

	}

	private void deleteSeqNumbers(){

		CsoSeqNumbersDAO seqNum = new CsoSeqNumbersDAO();

		try {

			seqNum.delete();
			Utils.logSpolog("Succesfully Deleted CsoSeqNumber",PROCESSNAME);

		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void deleteOutputControls(){

		CsoOutputControlsDAO output = new CsoOutputControlsDAO();

		try {

			output.delete();
			Utils.logSpolog("Succesfully Deleted CsoOutputControls",PROCESSNAME);

		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	private void insertSequence(){

		CsoOutputControlsDAO output = new CsoOutputControlsDAO();

		try {

			output.delete();
			Utils.logSpolog("Deleted CsoOutputControls",PROCESSNAME);

		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
