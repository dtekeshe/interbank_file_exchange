package com.bsva.commonsv02.util;

import com.bsva.dao.v02.endofservice.*;
import com.bsva.dcms.commons.dao.CsoOutputControlsDAO;
import com.bsva.dcms.commons.dto.CsoOutputControlsDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.entities.v02.endofservice.AcquirerIssuerDayTotalEntity;
import com.bsva.entities.v02.endofservice.AcquirerIssuerLastFileEntity;
import com.bsva.entities.v02.endofservice.AcquirerIssuerPairKey;

import java.util.List;
import java.util.Map;

/**
 * TODO Document
 */
public class EndOfServiceUtils {

    public static boolean stopFileLoad(String subServiceID) {
        return false;
    }

    public static boolean stopFileExtract(String subServiceID) {
        return false;
    }

//    public static boolean runPartialFileExtract(String subServiceID) {
//
//        while(pendingOutboundFiles(subServiceID)) {
//            // extract files
//        }
//
//        return false;
//    }

    public static boolean pendingOutboundFiles(String subServiceID) {
        return false;
    }

    public static boolean build98RecordsData(String subServiceID) {

        
        // TODO
        // get totals for the day for each acquirer / issuer pair
        // KEY: AcquirerCode, IssuerCode, Service, SubService
        // VALUE: RecordCountForDay, DrValueForDay
        Map<AcquirerIssuerPairKey, AcquirerIssuerDayTotalEntity> dayTotals = new AcquirerIssuerDayTotalDAO().dayTotals();

        // get last file for each acquirer / issuer pair
        // KEY: AcquirerCode, IssuerCode, Service, SubService
        // VALUE: SEQ_NUMBER
        List<AcquirerIssuerLastFileEntity> lastFiles = new AcquirerIssuerLastFileDAO().lastFiles();

        // last file status getter
        AcquirerIssuerLastFileStatusDAO lastFileStatusDAO = new AcquirerIssuerLastFileStatusDAO();
        // last file updater
        AcquirerIssuerLastFileUpdateDAO lastFileUpdateDAO = new AcquirerIssuerLastFileUpdateDAO();
        // last file inserter
        AcquirerIssuerLastFileInsertDAO lastFileInsertDAO = new AcquirerIssuerLastFileInsertDAO();

        // for each last file
        for (AcquirerIssuerLastFileEntity lastFile : lastFiles) {

            // get status
            String fileStatus = lastFileStatusDAO.fileStatus(lastFile.getId(), lastFile.getLastSeqNumber());

            switch(fileStatus) {
            case "N":
            case "D":
                // if 'N' or 'D', update last file
            	  AcquirerIssuerDayTotalEntity  updateTotal = dayTotals.get(lastFile.getId());
                  Long recordCountUpdate = updateTotal.getRecordCountForDay();
                  double drValueUpdate = updateTotal.getDrValueForDay();
                  //lastFileUpdateDAO.update(recordCountUpdate,drValueUpdate,lastFile.getId(), lastFile.getLastSeqNumber());
                  CsoOutputControlsDTO dtoBean1 = new CsoOutputControlsDTO();
                  dtoBean1.setFilenameDescription(lastFile.getFileName());
                  CsoOutputControlsDTO output1;
                  try {
  					 output1 = new CsoOutputControlsDAO().retrieve(dtoBean1);
  					if(output1 != null){
  						output1.setRecordCount(2);
  						output1.setRecordCountForDay(recordCountUpdate);
  						output1.setDrValueForDay(drValueUpdate);
  						output1.setLastFileIndicator("Y");
  						new CsoOutputControlsDAO().update(output1);
  					}
  					
  				} catch (DAOException e) {
  					e.printStackTrace();
  				}
                  
                break;

            case "C":
            case "F":
                // if 'C' or 'F'
                // create a new file with totals for the day
                AcquirerIssuerDayTotalEntity dayTotal = dayTotals.get(lastFile.getId());
                Long recordCountForDay = dayTotal.getRecordCountForDay();
                double drValueForDay = dayTotal.getDrValueForDay();
                String nextSeqNumber = lastFile.getLastSeqNumber();
                String nextFilename = lastFile.getFileName();
                String nextFilenamePrefix = lastFile.getFileNamePrefix();
                String distributionCode = lastFile.getDistributionCode();
                CsoOutputControlsDTO dtoBean = new CsoOutputControlsDTO();
                dtoBean.setFilenameDescription(nextFilename);
                CsoOutputControlsDTO output;
                try {
					 output = new CsoOutputControlsDAO().retrieve(dtoBean);
					if(output != null){
						output.setRecordCountForDay(recordCountForDay);
						output.setDrValueForDay(drValueForDay);
						output.setSeqNumber(nextSeqNumber);
						output.setFilenamePrefix(nextFilenamePrefix);
						output.setDistributionCode(distributionCode);
						output.setLastFileIndicator("Y");
						new CsoOutputControlsDAO().update(output);
					}
					
				} catch (DAOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
                //String lastFileIndicator = "Y";
                //lastFileInsertDAO.insert( lastFile.getId(), nextSeqNumber, nextFilename, nextFilenamePrefix, recordCountForDay, drValueForDay,distributionCode,lastFileIndicator);
                break;
            }
        }
        
        return Boolean.TRUE;
    }

    public void billFleet(){

        // UPDATE CSO_TRANSACTION T
        //    SET BILLING_FEE = ?
        //        BILLING_FEE_AMOUNT = ?
        //        BILLING_VAT = ?
        //  WHERE T.SYSTEM_GEN_SEQ_NUMBER = CSO_BILLING_RESOLVED.SEQ_NUMBER
        //    AND T.SUB_SERVICE = CSO_BILLING_RESOLVED.SUB_SERVICE
        //    AND T.ACQUIRER_CODE = CSO_BILLING_RESOLVED.ACQUIRER_CODE
        //    AND T.ISSUER_CODE = CSO_BILLING_RESOLVED.ISSUER_CODE
    }

    public static void sleep(Integer seconds) {
        try{Thread.sleep(seconds * 1000);} catch (Exception e){}
    }
}
