//package com.bsva.dmcs.fileLoad.subfunctions;
//
//import org.apache.log4j.Logger;
//
//import com.bsva.dao.CsoInputFileControlsDao;
//import com.bsva.dcms.commons.dao.CsoInputFileControlsDAO;
//import com.bsva.dcms.commons.dto.CsoInputFileControlsDTO;
//import com.bsva.dcms.commons.enums.Status;
//import com.bsva.dcms.commons.exceptions.DAOException;
//import com.bsva.dcms.commons.exceptions.DuplicateProcessException;
//import com.bsva.dcms.commons.util.DMCSCalcBilling;
//import com.bsva.dcms.commons.util.Utils;
//import com.bsva.dmcs.fileLoad.FileLoadDAO;
//import com.bsva.dto.FileStatusDTO;
//import com.bsva.entities.CsoInputFileControls;
//
//public class Billing {
//
//    private static String logPGM = "BILLING";
//    private static Logger log = Logger.getLogger(Billing.class);
//    private String filename;
//    private String service;
//    private String subService;
//    private String fileReferenceNumber;
//
//    private CsoInputFileControlsDao csoInputFileControlsDao;
//
//    public Billing(String filename, String service, String subService, String fileReferenceNumber) {
//        super();
//        this.filename = filename;
//        this.service = service;
//        this.subService = subService;
//        this.fileReferenceNumber = fileReferenceNumber;
//        csoInputFileControlsDao = new CsoInputFileControlsDao();
//    }
//
//    public void execute() throws DuplicateProcessException, DAOException {
//
//		// Is file ready for billing
//        //    i.e. is CSO_INPUT_FILE_CONTROLS.PROCESS_STATUS = 'A' AND IS_BILLED = 'N'
//        FileStatusDTO fileStatus = csoInputFileControlsDao.getFileStatus(fileReferenceNumber);
//        if ((fileStatus.getBilled().equals("N") && fileStatus.getPreExtracted().equals("N"))) {
//			// Flag CSO_INPUT_FILE_CONTROLS.PROCESS_STATUS = 'B', null value means do not update the field
//            //fileStatus = new FileStatusDTO(FileStatusDTO.FileProcessStatus.BUSY, null, null);
//            //int result = csoInputFileControlsDao.updateFileStatus(fileReferenceNumber, fileStatus);
//            CsoInputFileControlsDAO csoInputFileControlsDao = new CsoInputFileControlsDAO();
//
//            try {
//                CsoInputFileControlsDTO csoInputFileControlsDto = new CsoInputFileControlsDTO();
//                csoInputFileControlsDto.setFileRefNumber(fileReferenceNumber);
//                CsoInputFileControlsDTO csoInputFileControlsdto = csoInputFileControlsDao.retrieve(csoInputFileControlsDto);
//                csoInputFileControlsdto.setProcessStatus("B");
//                csoInputFileControlsDao.update(csoInputFileControlsdto);
//            } catch (DAOException ex) {
//                ex.getMessage();
//            }
//            DMCSCalcBilling dmcsCalcBilling = new DMCSCalcBilling();
//            boolean billingSuccessful = dmcsCalcBilling.calculate(fileReferenceNumber);
//            if (billingSuccessful) {
//                try {
//                    CsoInputFileControlsDTO csoInputFileControlsDtos = new CsoInputFileControlsDTO();
//                    csoInputFileControlsDtos.setFileRefNumber(fileReferenceNumber);
//                    CsoInputFileControlsDTO csoInputFileControlsdto = csoInputFileControlsDao.retrieve(csoInputFileControlsDtos);
//                    csoInputFileControlsdto.setBilled("Y");
//                    csoInputFileControlsdto.setProcessStatus("A");
//                    csoInputFileControlsDao.update(csoInputFileControlsdto);
//                } catch (DAOException ex) {
//                    ex.getMessage();
//                }
//            } else {
//                try {
//                    CsoInputFileControlsDTO csoInputFileControlsDtos = new CsoInputFileControlsDTO();
//                    csoInputFileControlsDtos.setFileRefNumber(fileReferenceNumber);
//                    CsoInputFileControlsDTO csoInputFileControlsdto = csoInputFileControlsDao.retrieve(csoInputFileControlsDtos);
//                    csoInputFileControlsdto.setBilled("N");
//                    csoInputFileControlsdto.setPreExtracted("N");
//                    csoInputFileControlsdto.setProcessStatus("A");
//                    csoInputFileControlsDao.update(csoInputFileControlsdto);
//                } catch (DAOException ex) {
//                    ex.getMessage();
//                }
//                log.debug("Database Updated Successful ");
//            }
//        }
//
//    }
//
//}
