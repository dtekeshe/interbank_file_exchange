//package com.bsva.dmcs.fileLoad;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.log4j.Logger;
//
//import com.bsva.dcms.commons.dao.CsoInputFileControlsDAO;
//import com.bsva.dcms.commons.dao.CsoScheduledProcessesDAO;
//import com.bsva.dcms.commons.dto.CsfDeliveryServicesDTO;
//import com.bsva.dcms.commons.dto.CsoInputFileControlsDTO;
//import com.bsva.dcms.commons.dto.CsoScheduledProcessesDTO;
//import com.bsva.dcms.commons.dto.DelDeliveryFilesCCCDTO;
//import com.bsva.dcms.commons.exceptions.DAOException;
//import com.bsva.dcms.commons.exceptions.DuplicateProcessException;
//import com.bsva.dcms.commons.util.BsvTableLookup;
//import com.bsva.dmcs.controller.AbstractProcess;
//import com.bsva.dmcs.fileLoad.subfunctions.Billing;
//
//public class FileBillingProcess extends AbstractProcess {
//
//    private static final String EOD_PROCESS_NAME = "EOD";
//    private Logger log = Logger.getLogger(FileLoadProcess.class);
//
//    @Override
//    public void init() {
//        // TODO Auto-generated method stub
//    }
//    @Override
//    public void process() {
//        try {
//           // log.debug("0000000000 In file Billing Process Started 0000000000");
//            try {
//                CsoInputFileControlsDTO inputFilesDto = new CsoInputFileControlsDTO();
//                CsoInputFileControlsDAO daoInput = new CsoInputFileControlsDAO() ;
//                inputFilesDto.setBilled("N");
//                inputFilesDto.setProcessStatus("A");
//                List<CsoInputFileControlsDTO> inputFiles = daoInput.retrieveRelated(inputFilesDto);
//                for (CsoInputFileControlsDTO billedFile : inputFiles) {
//                    String filename = billedFile.getFileRefNumber().substring(0, 8);
//                    String fileReferenceNumber = billedFile.getFileRefNumber();
//                        if (billedFile.getSubService().equals("FLEET") && isEndOfDay()) {
//                            String service = billedFile.getService();
//                            String subService = billedFile.getSubService();
//                            Billing billing = new Billing(filename, service, subService, fileReferenceNumber);
//                            log.debug("In file Fleet Billing process0000000000000000000000000000000000000000000000000000");
//                            long now = System.currentTimeMillis();
//                            billing.execute();
//                            log.debug("After file Fleet Billing  process took : " + ((System.currentTimeMillis() - now) / 1000) + "seconds 0000000000000000000000000000000000000000000000000000");
//                        } else {
//                            String service = billedFile.getService();
//                            String subService = billedFile.getSubService();
//                            Billing billing = new Billing(filename, service, subService, fileReferenceNumber);
//                            log.debug("In file Billing process0000000000000000000000000000000000000000000000000000");
//                            long now = System.currentTimeMillis();
//                            billing.execute();
//                            log.debug("After file Billing  process took : " + ((System.currentTimeMillis() - now) / 1000) + "seconds 0000000000000000000000000000000000000000000000000000");
//                        }
//
//                }
//              //  log.debug("0000000000 In file Billing process Finished , There is no file to bill 0000000000");
//            } catch (DAOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        } catch (DuplicateProcessException e) {
//            log.error(e.getMessage());
//        }
//    }
//
//    private boolean isEndOfDay() throws DAOException {
//        CsoScheduledProcessesDAO csoScheduledProcessesDAO = new CsoScheduledProcessesDAO();
//        CsoScheduledProcessesDTO csoScheduledProcessesDto = new CsoScheduledProcessesDTO();
//        csoScheduledProcessesDto.setProcessName(EOD_PROCESS_NAME);
//        List<CsoScheduledProcessesDTO> csoScheduledProcessesDTOList = csoScheduledProcessesDAO.retrieveRelated(csoScheduledProcessesDto);
//        for (CsoScheduledProcessesDTO csoScheduledProcessesDTO : csoScheduledProcessesDTOList) {
//            String processName = csoScheduledProcessesDTO.getProcessName();
//            String activeIndicator = csoScheduledProcessesDTO.getActiveIndicator();
//
//            if (processName.equals(EOD_PROCESS_NAME) && activeIndicator.equals("Y")) {
//                return true;
//            } else {
//                return false;
//            }
//
//        }
//
//        return false;
//    }
//}
