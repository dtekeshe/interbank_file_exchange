package com.bsva.dcms.commons.util;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import com.bsva.dao.CsfBinsDao;

import org.apache.log4j.Logger;

import com.bsva.dao.CsfCardFeeBilateralDao;
import com.bsva.dcms.commons.dao.CSFBinDAO;
import com.bsva.dcms.commons.dao.CSFCardTypesDAO;
import com.bsva.dcms.commons.dao.CSFMembersDAO;
import com.bsva.dcms.commons.dao.CSFMembersServiceDAO;
import com.bsva.dcms.commons.dao.CSFServicesDAO;
import com.bsva.dcms.commons.dao.CSFSubServicesDAO;
import com.bsva.dcms.commons.dao.CSFTransactionTypesDAO;
import com.bsva.dcms.commons.dao.CsfCardFeeBilateralDAO;
import com.bsva.dcms.commons.dao.CsfCardRateLookupDAO;
import com.bsva.dcms.commons.dao.CsfCashbackMccDAO;
import com.bsva.dcms.commons.dao.CsfCompanyParametersDAO;
import com.bsva.dcms.commons.dao.CsfDeliveryServicesDAO;
import com.bsva.dcms.commons.dao.CsfDirectoriesDAO;
import com.bsva.dcms.commons.dao.CsfErrorCodesDAO;
import com.bsva.dcms.commons.dao.CsfFilenameLookupDAO;
import com.bsva.dcms.commons.dao.CsfMastercardOptionsDAO;
import com.bsva.dcms.commons.dao.CsfSystemServiceDAO;
import com.bsva.dcms.commons.dao.CsfSystemSettingsDAO;
import com.bsva.dcms.commons.dao.CsoScheduledProcessesDAO;
import com.bsva.dcms.commons.dao.CsoSystemParametersDAO;
import com.bsva.dcms.commons.dao.SiteControlsDAO;
import com.bsva.dcms.commons.dto.CSFBINTotalsDTO;
import com.bsva.dcms.commons.dto.CSFBinsDTO;
import com.bsva.dcms.commons.dto.CSFCardTypesDTO;
import com.bsva.dcms.commons.dto.CSFMemberServiceDTO;
import com.bsva.dcms.commons.dto.CSFMembersDTO;
import com.bsva.dcms.commons.dto.CSFServicesDTO;
import com.bsva.dcms.commons.dto.CSFSubServicesDTO;
import com.bsva.dcms.commons.dto.CSFTransactionTypesDTO;
import com.bsva.dcms.commons.dto.CsfCardFeeBilateralDTO;
import com.bsva.dcms.commons.dto.CsfCardRateLookupDTO;
import com.bsva.dcms.commons.dto.CsfCashbackMccDTO;
import com.bsva.dcms.commons.dto.CsfCompanyParametersDTO;
import com.bsva.dcms.commons.dto.CsfDeliveryServicesDTO;
import com.bsva.dcms.commons.dto.CsfDirectoriesDTO;
import com.bsva.dcms.commons.dto.CsfErrorCodesDTO;
import com.bsva.dcms.commons.dto.CsfFilenameLookupDTO;
import com.bsva.dcms.commons.dto.CsfMastercardOptionsDTO;
import com.bsva.dcms.commons.dto.CsfSystemServiceDTO;
import com.bsva.dcms.commons.dto.CsfSystemSettingsDTO;
import com.bsva.dcms.commons.dto.CsoScheduledProcessesDTO;
import com.bsva.dcms.commons.dto.CsoSystemParametersDTO;
import com.bsva.dcms.commons.dto.MasterCardTransactionTypesDTO;
import com.bsva.dcms.commons.dto.SiteControlsDTO;
import com.bsva.dcms.commons.enums.Status;
import com.bsva.dcms.commons.exceptions.DAOException;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.MySQLDialect;
import org.hibernate.dialect.Oracle10gDialect;

public class BsvTableLookup {
	
	public static BsvTableLookup instance;
	private Logger log = Logger.getLogger(BsvTableLookup.class);

	private HashMap<String , CsfDirectoriesDTO> csfDirectories = new HashMap<String , CsfDirectoriesDTO>();
	private HashMap<String , CSFBinsDTO> csfBins = new HashMap<String , CSFBinsDTO>();
	private HashMap<String , CSFTransactionTypesDTO> csfTransactionTypes = new HashMap<String , CSFTransactionTypesDTO>();
	private HashMap<String , CSFCardTypesDTO> csfCardTypes = new HashMap<String , CSFCardTypesDTO>();
	private HashMap<String , CSFServicesDTO> csfServices = new HashMap<String , CSFServicesDTO>();
	private HashMap<String , CSFSubServicesDTO> csfSubServices = new HashMap<String , CSFSubServicesDTO>();
	private HashMap<String , CSFMembersDTO> csfMembers = new HashMap<String , CSFMembersDTO>();
	private HashMap<String , CsfCompanyParametersDTO> csfCompanyParameters = new HashMap<String , CsfCompanyParametersDTO>();
	private HashMap<String , CsfSystemServiceDTO> csfSystemService = new HashMap<String , CsfSystemServiceDTO>();
	private HashMap<String , SiteControlsDTO> siteControls = new HashMap<String , SiteControlsDTO>();
	private HashMap<String , CsfMastercardOptionsDTO> csfMasterCardOptions = new HashMap<String , CsfMastercardOptionsDTO>();
	private HashMap<String , CsfFilenameLookupDTO> csfFilenameLookup = new HashMap<String , CsfFilenameLookupDTO>();
	private HashMap<String , CsfCashbackMccDTO> csfCashBackMcc = new HashMap<String , CsfCashbackMccDTO>();
	private HashMap<String , CsfSystemSettingsDTO> csfSystemSettings = new HashMap<String , CsfSystemSettingsDTO>();
	private HashMap<String , CsfErrorCodesDTO> csfErrorCodes = new HashMap<String , CsfErrorCodesDTO>();
	private List<CSFMemberServiceDTO> csfMemberService = new ArrayList<CSFMemberServiceDTO>();
	private List<MasterCardTransactionTypesDTO> masterCardTransactionTypes = new ArrayList<MasterCardTransactionTypesDTO>();
	private HashMap<String , CsfDeliveryServicesDTO> csfDeliveryServices = new HashMap<String , CsfDeliveryServicesDTO>();
	private CSFBINTotalsDTO csfBinTotals = new CSFBINTotalsDTO();
	private HashMap<String , CSFMembersDTO> csfMembersByTapeId = new HashMap<String , CSFMembersDTO>();
	private Map<Integer, List<Integer>> mtiFunctionCombinations = new HashMap<>();
	private HashMap<String , CsfCardFeeBilateralDTO> csfCardFeeBilateral = new HashMap<String , CsfCardFeeBilateralDTO>();
	private HashMap<String , CsfCardRateLookupDTO> cardRate = new HashMap<String , CsfCardRateLookupDTO>();

	

	private int currencyCodeNumber;
	private String currencyCode;
	private String companyName;
	private String fullReportName;
	private String registrationNumber;
	private String validationCode;
	
	private String systemService;
	private String systemStatus;
	
	private String processDate; //TODO: this needs to be loaded on a daily basis
	private String nextOutputProcessDate;	
	private String receiveDir;
	private String sendDir;
	private String reportsDir;
	private String appsDir;
	private String spologDir;
	private String prevDir;
	private String archiveDir;
	private String inputDir;
	private String exportDir;
	@Resource(lookup = "java:jboss/datasources/DMCSDb")
    private DataSource datasource;
	
	private BsvTableLookup(){
		super();
		loadTableData();
	}

	public static BsvTableLookup getInstance(){
		
		if (instance == null){
			instance = new BsvTableLookup();
			return instance;
		}else
			return instance;
	}
	
	//TODO : to be called during start of day to force BsvTableLookup to reload
	public static void inValidateInstance(){
		
		if (instance != null){
			instance.getCsfDirectories().clear();
			instance.getCsfBins().clear();
			instance.getCsfTransactionTypes().clear();
			instance.getCsfCardTypes().clear();
			instance.getCsfServices().clear();
			instance.getCsfSubServices().clear();
			instance.getCsfMembers().clear();
			instance.getCsfCompanyParameters().clear();
			instance.getCsfSystemService().clear();
			instance.getSiteControls().clear();
			instance.getCsfMasterCardOptions().clear();
			instance.getCsfFilenameLookup().clear();
			instance.getCsfCashBackMcc().clear();
			instance.getCsfSystemSettings().clear();
			instance.getCsfErrorCodes().clear();
			instance.getCsfMemberService().clear();
			instance.getMasterCardTransactionTypes().clear();
			instance.getCsfDeliveryServices().clear();
			instance.getCsfMembersByTapeId().clear();
			instance.getMtiFunctionCombinations().clear();
			instance.getCsfCardFeeBilateral().clear();
			instance.getCardRate().clear();
			
		}
		
		instance = null;
	}
	public void loadTableData(){
		
		try{

			//log.info("BsvTableLookup loadTableData() started");
			CsfBinsDao csfBinsDao = new CsfBinsDao();
			Dialect dialect = csfBinsDao.getDialect();

			//log.info("DIALECT : " + dialect);
			String dialectId = null;
			if (dialect instanceof Oracle10gDialect) {
				dialectId = "ORACLE";
			} else if (dialect instanceof MySQLDialect) {
				dialectId = "MYSQL";
			}

			//log.info("DIALECT ID : " + dialectId);

			loadCsfBin();
			loadCsfTransactionTypes();
			loadCsfCardTypes();
			loadCsfServices();
			loadCsfSubServices();
			loadCsfMembers();
			loadCsfCompanyParameters();
			loadCsfSystemService();
			loadSiteControls();
			loadMasterCardOptions();
			loadCsfFileNameLookup();
			//loadCsfCashBackMcc();
			loadCsfSystemSetting();
			loadCsoSystemParameters();
			loadCsfDirectories();
			loadCsfErrorCodes();
			loadCsfMemberService();
			loadCsfBinTotals(dialectId);
			loadDeliveryService();
			loadMasterCardTransactionTypes();
			loadMtiFunctionCombination();
			loadCsfCardRateLookup();
			//removedAllStatus();
			loadCsfCardFeeBilateral();
			//releaseConnection(connection);
		}catch(Exception e){
			log.error(e.getMessage(), e);
		}finally{
			//releaseConnection(connection);
		}
	
	}
	public void removedAllStatus(){
		try{
		CsoScheduledProcessesDAO csoScheduledProcessesDAO = new CsoScheduledProcessesDAO();
		
		List<CsoScheduledProcessesDTO> csoScheduledProcessesDTOs = new ArrayList<CsoScheduledProcessesDTO>();
	     csoScheduledProcessesDTOs = csoScheduledProcessesDAO.retrieveRelated(null);// Retrieve ALL
		
		if(csoScheduledProcessesDTOs != null && csoScheduledProcessesDTOs.size() > 0){
			for (CsoScheduledProcessesDTO csoScheduledProcessesDTO :csoScheduledProcessesDTOs){
				if("SOD".equals(csoScheduledProcessesDTO.getProcessName())){
					csoScheduledProcessesDTO.setActiveIndicator(Status.Y.getSymbol());
				}else{
					csoScheduledProcessesDTO.setActiveIndicator(Status.N.getSymbol());
				}
				CsoScheduledProcessesDAO csoScheduledProcessesDao = new CsoScheduledProcessesDAO();
				csoScheduledProcessesDao.update(csoScheduledProcessesDTO);
			}
		}
		}catch(Exception ex){
			log.debug("Error Occured"+ ex.getMessage());
		}
	}
	//loaded when referenced i.e like a static block
	public void loadCsfBin() throws DAOException{
		CSFBinDAO dao = new CSFBinDAO();
		List<CSFBinsDTO> dtoList = dao.retrieveRelated(null);
		for(CSFBinsDTO dto : dtoList){
			csfBins.put(dto.getBinNo(), dto);
		}
	}
	
	public void loadCsfTransactionTypes() throws DAOException{
		CSFTransactionTypesDAO dao = new CSFTransactionTypesDAO();
		List<CSFTransactionTypesDTO> dtoList = dao.retrieveRelated(null);
		for(CSFTransactionTypesDTO dto : dtoList){
			csfTransactionTypes.put(String.valueOf(dto.getTransactionCode()), dto);
		}
	}
	
	public void loadCsfCardTypes() throws DAOException{
		CSFCardTypesDAO dao = new CSFCardTypesDAO();
		List<CSFCardTypesDTO> dtoList = dao.retrieveRelated(null);
		for(CSFCardTypesDTO dto : dtoList){
			csfCardTypes.put(String.valueOf(dto.getCardType()), dto);
		}
	}
	
	public void loadCsfCardRateLookup() throws DAOException{
		CsfCardRateLookupDAO dao = new CsfCardRateLookupDAO();
		List<CsfCardRateLookupDTO> dtoList = dao.retrieveRelated(null);
		for(CsfCardRateLookupDTO dto : dtoList){
			cardRate.put(String.valueOf(dto.getRateDescriptor()), dto);
		}
	}
	
	public void loadCsfServices() throws DAOException{
		CSFServicesDAO dao = new CSFServicesDAO();
		List<CSFServicesDTO> dtoList = dao.retrieveRelated(null);
		for(CSFServicesDTO dto : dtoList){
			csfServices.put(dto.getServiceName(), dto);
		}
	}
	//loadCsfCardFeeBilateral()
	public void loadCsfCardFeeBilateral() throws DAOException{
		CsfCardFeeBilateralDAO  csfCardDao = new CsfCardFeeBilateralDAO();
		List<CsfCardFeeBilateralDTO> dtoList = csfCardDao.retrieveRelated(null);
		for(CsfCardFeeBilateralDTO dto : dtoList){
			csfCardFeeBilateral.put(dto.getDestReport(), dto);
		}
	}
	
	public void loadCsfSubServices() throws DAOException{
		CSFSubServicesDAO dao = new CSFSubServicesDAO();
		List<CSFSubServicesDTO> dtoList = dao.retrieveRelated(null);
		for(CSFSubServicesDTO dto : dtoList){
			csfSubServices.put(dto.getSubservice(), dto);
		}
	}
	
	public void loadCsfMembers() throws DAOException{
		CSFMembersDAO dao = new CSFMembersDAO();
		List<CSFMembersDTO> dtoList = dao.retrieveRelated(null);
		for(CSFMembersDTO dto : dtoList){
			csfMembers.put(String.valueOf(dto.getBankCode()), dto);
			csfMembersByTapeId.put(dto.getMemberTapeId(), dto);
		}
	}
	
	public void loadCsfCompanyParameters() throws DAOException{
		CsfCompanyParametersDAO dao = new CsfCompanyParametersDAO();
		CsfCompanyParametersDTO dto = dao.retrieve(null);
		csfCompanyParameters.put(dto.getCompanyName(), dto);
		
		setCurrencyCodeNumber(dto.getCurrencyCodeNumber());
		setCurrencyCode(dto.getCurrencyCode());
		setCompanyName(dto.getCompanyName());
		setFullReportName(dto.getFullReportName());
		setRegistrationNumber(dto.getRegistrationNumber());
		setValidationCode(dto.getValidationCode());
	}

	public void loadCsfSystemService()throws DAOException{
		CsfSystemServiceDAO dao = new CsfSystemServiceDAO();
		CsfSystemServiceDTO dto = dao.retrieve(null);
		csfSystemService.put(dto.getServiceCode(), dto);
		
		setSystemService(dto.getServiceCode());
	}
	
	public void loadSiteControls() throws DAOException{
		SiteControlsDAO dao = new SiteControlsDAO();
		SiteControlsDTO dto = dao.retrieve(null);
		siteControls.put(dto.getSiteCode(), dto);
		
		setSystemStatus(dto.getSystemStatus());
	}
	
	public void loadMasterCardOptions() throws DAOException{
		CsfMastercardOptionsDAO dao = new CsfMastercardOptionsDAO();
		List<CsfMastercardOptionsDTO> dtoList = dao.retrieveRelated(null);
		for(CsfMastercardOptionsDTO dto : dtoList){
			csfMasterCardOptions.put(String.valueOf(dto.getBankCode()), dto);
		}
	}
	
	public void loadCsfFileNameLookup() throws DAOException{
		CsfFilenameLookupDAO dao = new CsfFilenameLookupDAO();
		List<CsfFilenameLookupDTO> dtoList = dao.retrieveRelated(null);
		for(CsfFilenameLookupDTO dto : dtoList){
			csfFilenameLookup.put(String.valueOf(dto.getNumIndex()), dto);
		}
	}
	
	public void loadCsfCashBackMcc() throws DAOException{
		CsfCashbackMccDAO dao = new CsfCashbackMccDAO();
		List<CsfCashbackMccDTO> dtoList = dao.retrieveRelated(null);
		for(CsfCashbackMccDTO dto : dtoList){
			csfCashBackMcc.put(String.valueOf(dto.getCbMcc()), dto);
		}
	}
	
	public void  loadCsfSystemSetting() throws DAOException{
		CsfSystemSettingsDAO dao = new CsfSystemSettingsDAO();
		List<CsfSystemSettingsDTO> dtoList = dao.retrieveRelated(null);
		for(CsfSystemSettingsDTO dto : dtoList){
			csfSystemSettings.put(dto.getSettingCode(), dto);
		}
	}
	
	public void loadCsoSystemParameters() throws DAOException, ParseException{
		CsoSystemParametersDAO dao = new CsoSystemParametersDAO();
		
		CsoSystemParametersDTO dto = new CsoSystemParametersDTO();
		dto.setProcessActiveInd("Y");
		
		CsoSystemParametersDTO dto2 = dao.retrieve(dto);
		
		setProcessDate(DateUtil.formatDate(dto2.getProcessDate(), "yyyyMMdd"));
		setNextOutputProcessDate(DateUtil.formatDate(dto2.getNextOutputDate(), "yyyyMMdd"));
	}
	
	public void loadCsfDirectories() throws DAOException{
		CsfDirectoriesDAO dao = new CsfDirectoriesDAO();
		
		List<CsfDirectoriesDTO> dtoList = dao.retrieveRelated(null);
		for(CsfDirectoriesDTO dto : dtoList){
			csfDirectories.put(dto.getDirectoryName(), dto);
		}
		
		if (csfDirectories.get("RECEIVE") != null)
			setReceiveDir(csfDirectories.get("RECEIVE").getDirectoryPath());
		if (csfDirectories.get("SEND") != null)
			setSendDir(csfDirectories.get("SEND").getDirectoryPath());
		if (csfDirectories.get("REPORTS") != null)
			setReportsDir(csfDirectories.get("REPORTS").getDirectoryPath());
		if (csfDirectories.get("APPS") != null)
			setAppsDir(csfDirectories.get("APPS").getDirectoryPath());
		if (csfDirectories.get("SPOLOG") != null)
			setSpologDir(csfDirectories.get("SPOLOG").getDirectoryPath());
		if (csfDirectories.get("PREV") != null)
			setPrevDir(csfDirectories.get("PREV").getDirectoryPath());
		if (csfDirectories.get("ARCHIVE") != null)
			setArchiveDir(csfDirectories.get("ARCHIVE").getDirectoryPath());
		if (csfDirectories.get("INPUT") != null)
			setInputDir(csfDirectories.get("INPUT").getDirectoryPath());//setInputDir
		if(csfDirectories.get("EXPORT_FOLDER") != null)
			setExportDir(csfDirectories.get("EXPORT_FOLDER").getDirectoryPath());
	}
	
	public void loadCsfErrorCodes() throws DAOException{
		
		CsfErrorCodesDAO dao = new CsfErrorCodesDAO();
		List<CsfErrorCodesDTO> dtoList = dao.retrieveRelated(null);
		for(CsfErrorCodesDTO dto : dtoList){
			csfErrorCodes.put(String.valueOf(dto.getErrorCode()), dto);
		}
		
	}
	
	public void loadCsfMemberService() throws DAOException{
		CSFMembersServiceDAO dao = new CSFMembersServiceDAO();
		List<CSFMemberServiceDTO> dtoList = dao.retrieveRelated(null);
		for(CSFMemberServiceDTO dto : dtoList){
			csfMemberService.add(dto);
		}
	}
	
	public void loadCsfBinTotals(String dialectId) throws DAOException{
		CSFBinDAO dao = new CSFBinDAO();
		CSFBINTotalsDTO dto = dao.retrieveBinTotals(dialectId);
		setCsfBinTotals(dto); 
	}
	
	public void loadMasterCardTransactionTypes() throws DAOException{
		// this should possibly be moved to a table
		
		//1240
		MasterCardTransactionTypesDTO dto = new MasterCardTransactionTypesDTO();
		dto.setMessageTypeIdentifier(1240);
		dto.setFunctionCode("000");
		dto.setTransactionCode(5);
		masterCardTransactionTypes.add(dto);
		
		dto = new MasterCardTransactionTypesDTO();
		dto.setMessageTypeIdentifier(1240);
		dto.setFunctionCode("001");
		dto.setTransactionCode(7);
		masterCardTransactionTypes.add(dto);
		
		dto = new MasterCardTransactionTypesDTO();
		dto.setMessageTypeIdentifier(1240);
		dto.setFunctionCode("009");
		dto.setTransactionCode(5);
		masterCardTransactionTypes.add(dto);
		
		dto = new MasterCardTransactionTypesDTO();
		dto.setMessageTypeIdentifier(1240);
		dto.setFunctionCode("012");
		dto.setTransactionCode(7);
		masterCardTransactionTypes.add(dto);
		
		dto = new MasterCardTransactionTypesDTO();
		dto.setMessageTypeIdentifier(1240);
		dto.setFunctionCode("018");
		dto.setTransactionCode(5);
		masterCardTransactionTypes.add(dto);
		
		dto = new MasterCardTransactionTypesDTO();
		dto.setMessageTypeIdentifier(1240);
		dto.setFunctionCode("020");
		dto.setTransactionCode(6);
		masterCardTransactionTypes.add(dto);
		
		dto = new MasterCardTransactionTypesDTO();
		dto.setMessageTypeIdentifier(1240);
		dto.setFunctionCode("028");
		dto.setTransactionCode(6);
		masterCardTransactionTypes.add(dto);
		
		//1442
		
		dto = new MasterCardTransactionTypesDTO();
		dto.setMessageTypeIdentifier(1442);
		dto.setFunctionCode("000");
		dto.setTransactionCode(5);
		masterCardTransactionTypes.add(dto);
		
		dto = new MasterCardTransactionTypesDTO();
		dto.setMessageTypeIdentifier(1442);
		dto.setFunctionCode("001");
		dto.setTransactionCode(7);
		masterCardTransactionTypes.add(dto);
		
		dto = new MasterCardTransactionTypesDTO();
		dto.setMessageTypeIdentifier(1442);
		dto.setFunctionCode("009");
		dto.setTransactionCode(5);
		masterCardTransactionTypes.add(dto);
		
		dto = new MasterCardTransactionTypesDTO();
		dto.setMessageTypeIdentifier(1442);
		dto.setFunctionCode("012");
		dto.setTransactionCode(7);
		
		dto = new MasterCardTransactionTypesDTO();
		dto.setMessageTypeIdentifier(1442);
		dto.setFunctionCode("018");
		dto.setTransactionCode(5);
		masterCardTransactionTypes.add(dto);
		
		dto = new MasterCardTransactionTypesDTO();
		dto.setMessageTypeIdentifier(1442);
		dto.setFunctionCode("020");
		dto.setTransactionCode(6);
		masterCardTransactionTypes.add(dto);
		
		dto = new MasterCardTransactionTypesDTO();
		dto.setMessageTypeIdentifier(1442);
		dto.setFunctionCode("028");
		dto.setTransactionCode(6);
		masterCardTransactionTypes.add(dto);	
	}
	public void loadDeliveryService() throws DAOException{
		CsfDeliveryServicesDAO dao = new CsfDeliveryServicesDAO();
		List<CsfDeliveryServicesDTO> dtoList = dao.retrieveRelated(null);
		
		for(CsfDeliveryServicesDTO dto : dtoList){
			csfDeliveryServices.put(dto.getFilenamePrefix(), dto);
		} 
	}
	
	public void loadMtiFunctionCombination(){
		
		
		
		List<Integer> functions = new ArrayList<>();
		functions.add(205);
		functions.add(282);
		mtiFunctionCombinations.put(1240, functions);
				
		functions = new ArrayList<>();
		functions.add(450);
		functions.add(451);
		functions.add(453);
		functions.add(454);
		mtiFunctionCombinations.put(1442, functions);
		
		functions = new ArrayList<>();
		functions.add(603);
		functions.add(640);
		functions.add(680);
		functions.add(685);
		functions.add(691);
		functions.add(693);
		functions.add(695);
		functions.add(696);
		functions.add(697);
		functions.add(699);
		mtiFunctionCombinations.put(1644, functions);
		
		functions = new ArrayList<>();
		functions.add(700);
		functions.add(780);
		functions.add(781);
		functions.add(782);
		functions.add(783);
		functions.add(790);
		mtiFunctionCombinations.put(1740, functions);
	
	 }
	 public CSFBinsDTO getBINDetailForBin(int inBinNo) {
		
		 CSFBinsDTO tempBINdtl = null;
	     int tmpBinNo = inBinNo;
	    
	     for (int yy =6; yy > 0; yy--) {
	    	 
	         tempBINdtl = getCsfBins().get(String.valueOf(tmpBinNo));
	         
	         if (tempBINdtl != null) {
	             return tempBINdtl;
	         }
	         tmpBinNo = tmpBinNo / 10;
	     }
	     return tempBINdtl;
	}
	
	
	public int getCurrencyCodeNumber() {
		return currencyCodeNumber;
	}

	private void setCurrencyCodeNumber(int currencyCodeNumber) {
		this.currencyCodeNumber = currencyCodeNumber;
	}

	public String getFullReportName() {
		return fullReportName;
	}

	private void setFullReportName(String fullReportName) {
		this.fullReportName = fullReportName;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	private void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getValidationCode() {
		return validationCode;
	}

	private void setValidationCode(String validationCode) {
		this.validationCode = validationCode;
	}

	public HashMap<String, CSFBinsDTO> getCsfBins() {
		return csfBins;
	}

	public HashMap<String, CSFTransactionTypesDTO> getCsfTransactionTypes() {
		return csfTransactionTypes;
	}

	public HashMap<String, CSFCardTypesDTO> getCsfCardTypes() {
		return csfCardTypes;
	}

	public HashMap<String, CSFServicesDTO> getCsfServices() {
		return csfServices;
	}

	public HashMap<String, CSFSubServicesDTO> getCsfSubServices() {
		return csfSubServices;
	}

	public HashMap<String, CSFMembersDTO> getCsfMembers() {
		return csfMembers;
	}

	public HashMap<String, CsfCompanyParametersDTO> getCsfCompanyParameters() {
		return csfCompanyParameters;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	private void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	private void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public void setSystemService(String systemService) {
		this.systemService = systemService;
	}

	private void setSystemStatus(String systemStatus) {
		this.systemStatus = systemStatus;
	}

	public HashMap<String, CsfSystemServiceDTO> getCsfSystemService() {
		return csfSystemService;
	}

	public HashMap<String, SiteControlsDTO> getSiteControls() {
		return siteControls;
	}

	public void setProcessDate(String processDate) {
		this.processDate = processDate;
	}

	public HashMap<String, CsfMastercardOptionsDTO> getCsfMasterCardOptions() {
		return csfMasterCardOptions;
	}

	public HashMap<String, CsfFilenameLookupDTO> getCsfFilenameLookup() {
		return csfFilenameLookup;
	}

	public HashMap<String, CsfCashbackMccDTO> getCsfCashBackMcc() {
		return csfCashBackMcc;
	}

	public HashMap<String, CsfSystemSettingsDTO> getCsfSystemSettings() {
		return csfSystemSettings;
	}

	public String getSystemService() {
		return systemService;
	}

	public String getSystemStatus() {
		return systemStatus;
	}

	public String getProcessDate() {
		return processDate;
	}

	public String getReceiveDir() {
		return receiveDir;
		//return "c:\\tana54\\ccc\\receive";
	}

	private void setReceiveDir(String receiveDir) {
		this.receiveDir = receiveDir;
	}

	public String getSendDir() {
		return sendDir;
		//return "c:\\tana54\\ccc\\send";
	}

	private void setSendDir(String sendDir) {
		this.sendDir = sendDir;
	}

	public String getReportsDir() {
		return reportsDir;
		//return "c:\\tana54\\ccc\\reports";
	}
	private void setReportsDir(String reportsDir) {
		this.reportsDir = reportsDir;
	}

	public String getAppsDir() {
		return appsDir;
	    //return "c:\\tana54\\ccc\\apps";
	}

	private void setAppsDir(String appsDir) {
		this.appsDir = appsDir;
	}

	public String getSpologDir() {
		return spologDir;
		//return "c:\\tana54\\ccc\\spolog";
	}

	private void setSpologDir(String spologDir) {
		this.spologDir = spologDir;
	}

	public String getPrevDir() {
		return prevDir;
		//return "c:\\tana54\\ccc\\prev";
	}

	private void setPrevDir(String prevDir) {
		this.prevDir = prevDir;
	}

	public String getArchiveDir() {
		return archiveDir;
		//return "c:\\tana54\\ccc\\archive";
	}

	private void setArchiveDir(String archiveDir) {
		this.archiveDir = archiveDir;
	}

	public String getInputDir() {
		return inputDir;
		//return "C:\\tana54\\ccc\\receive\\input";
	}

	public void setInputDir(String inputDir) {
		this.inputDir = inputDir;
	}

	public String getExportDir() {
		return exportDir;
	}

	public void setExportDir(String exportDir) {
		this.exportDir = exportDir;
	}

	public HashMap<String, CsfDirectoriesDTO> getCsfDirectories() {
		return csfDirectories;
	}

	public HashMap<String, CsfErrorCodesDTO> getCsfErrorCodes() {
		return csfErrorCodes;
	}

	public List<CSFMemberServiceDTO> getCsfMemberService() {
		return csfMemberService;
	}

	public List<MasterCardTransactionTypesDTO> getMasterCardTransactionTypes() {
		return masterCardTransactionTypes;
	}

	public HashMap<String, CsfDeliveryServicesDTO> getCsfDeliveryServices() {
		return csfDeliveryServices;
	}

	public CSFBINTotalsDTO getCsfBinTotals() {
		return csfBinTotals;
	}

	public void setCsfBinTotals(CSFBINTotalsDTO csfBinTotals) {
		this.csfBinTotals = csfBinTotals;
	}

	public String getNextOutputProcessDate() {
		return nextOutputProcessDate;
	}

	public void setNextOutputProcessDate(String nextOutputProcessDate) {
		this.nextOutputProcessDate = nextOutputProcessDate;
	}

	public HashMap<String, CSFMembersDTO> getCsfMembersByTapeId() {
		return csfMembersByTapeId;
	}

	public Map<Integer, List<Integer>> getMtiFunctionCombinations() {
		return mtiFunctionCombinations;
	}
	public HashMap<String, CsfCardFeeBilateralDTO> getCsfCardFeeBilateral() {
		return csfCardFeeBilateral;
	}
	public HashMap<String, CsfCardRateLookupDTO> getCardRate() {
		return cardRate;
	}
}
