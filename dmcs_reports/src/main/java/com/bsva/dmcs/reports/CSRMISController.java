//
//package com.bsva.dmcs.reports;
//
//import com.bsva.dcms.commons.dao.CSFMembersDAO;
//import com.bsva.dcms.commons.dao.CSFSubServicesDAO;
//import com.bsva.dcms.commons.dao.CsoInputFileControlsDAO;
//import com.bsva.dcms.commons.dto.CSFMembersDTO;
//import com.bsva.dcms.commons.dto.CSFSubServicesDTO;
//import com.bsva.dcms.commons.dto.CsoInputFileControlsDTO;
//import com.bsva.dcms.commons.dto.file.FileDTO;
//import com.bsva.dcms.commons.exceptions.DAOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.Executors;
//import java.util.concurrent.ScheduledExecutorService;
//import java.util.concurrent.ScheduledFuture;
//import java.util.concurrent.TimeUnit;
//
///**
// *
// * @author SimphiweT
// */
//public class CSRMISController implements DMCSReportInterface {
//
//    private FileDTO fileDTO;
//    private List<String> reportNames = new ArrayList<>();
//
//    public CSRMISController(FileDTO fileDTO) {
//        this.fileDTO = fileDTO;
//    }
//
//
//    public void getInputControlFile(FileDTO fdto) throws DAOException {
//
//        // retrieve input control
//        CsoInputFileControlsDAO csoInputFileControlsDAO = new CsoInputFileControlsDAO();
//        CsoInputFileControlsDTO csoInputFileControlsDTO = new CsoInputFileControlsDTO();
//        csoInputFileControlsDTO.setService("CARD");
//        csoInputFileControlsDTO.setSubService(fdto.getFileSubService());
//        CsoInputFileControlsDTO controlsDTO = csoInputFileControlsDAO.retrieve(csoInputFileControlsDTO);
//
//        // get the bank that issued the file
//        CSFMembersDAO membersDAO = new CSFMembersDAO();
//        CSFMembersDTO membersDTO = new CSFMembersDTO();
//        membersDTO.setBankCode(fileDTO.getFileOriginator());
//        CSFMembersDTO fMembersDTO = membersDAO.retrieve(membersDTO);
//
//        // populate billing summary table -- TODO Remove this block
//
//
//
//
//
//    }
//
//
//    @Override
//    public List<String> getListOfReportNames() {
//        return reportNames;
//    }
//
//    @Override
//    public void printTextFile() throws Exception {
//
//         DMCSReportXML2TXTthread xml2txtLst = new DMCSReportXML2TXTthread(this);
//
//        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
//        ScheduledFuture scheduledFuture = scheduledExecutorService.schedule(xml2txtLst, 1, TimeUnit.SECONDS);
//
//    }
//
//}
