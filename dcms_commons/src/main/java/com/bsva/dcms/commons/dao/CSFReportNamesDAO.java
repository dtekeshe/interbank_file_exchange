package com.bsva.dcms.commons.dao;


import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;

import com.bsva.dao.CsfReportNamesDao;
import com.bsva.dcms.commons.dto.CSFReportNamesDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.entities.CsfReportNames;



public class CSFReportNamesDAO {


	//private CsfReportNamesRepository reportnamesdao = DaoFactory.csfReportNamesInstance();
	private CsfReportNamesDao reportNamesDao = new CsfReportNamesDao();
	private Map<String,Object> map = new HashMap<String, Object>();

	public CSFReportNamesDAO(){
	}

	/**
	 * Creates an entry in the CSF_ASCII_EBCDIC table
	 *
	 * @param CSF_ASCII_EBCDIC the table entry to create
	 * @throws DAOException if a database exception occurs
	 */

	public void create(CSFReportNamesDTO csfReportNamesDTO) throws DAOException {


		try {

			CsfReportNames csfReportNames = new CsfReportNames();

			csfReportNames.setReportName(csfReportNamesDTO.getReportName());
			csfReportNames.setReportTitle(csfReportNamesDTO.getReportTitle());
			csfReportNames.setProgramName(csfReportNamesDTO.getProgramName());
			csfReportNames.setActiveIndicator(csfReportNamesDTO.getActiveIndicator());
			csfReportNames.setInternalFilename(csfReportNamesDTO.getInternalFilename());
			csfReportNames.setExternalFilenamePrefix(csfReportNamesDTO.getExternalFilenamePrefix());
			csfReportNames.setInternalIndicator(csfReportNamesDTO.getInternalIndicator());
			csfReportNames.setCreatedBy(csfReportNamesDTO.getCreatedBy());
			csfReportNames.setCreatedDate(csfReportNamesDTO.getCreatedDate());
			csfReportNames.setModifiedBy(csfReportNamesDTO.getModifiedBy());
			csfReportNames.setModifiedDate(csfReportNamesDTO.getModifiedDate());
			reportNamesDao.create(csfReportNames);	            

		}
		catch(Exception ex){
			throw new DAOException("Error creating CSF_REPORT_NAMES entry, cause: " + ex.getMessage(), ex);
		}
	}

	public CSFReportNamesDTO retrieve(CSFReportNamesDTO obj) throws DAOException {
		CSFReportNamesDTO dto = null;
		try {
			//String sql = "SELECT * FROM CCCOWNER.CSF_ASCII_EBCDIC" ;
			String sql = "SELECT c FROM CsfReportNames c "  +buildWhereClause(obj,true) ;

			CsfReportNames reportname = reportNamesDao.executeQueryParametersSingle(sql, map);

			dto = new CSFReportNamesDTO();

			if(reportname.getReportName()!=null){
				dto.setReportName(reportname.getReportName());
			}
			if(reportname.getReportTitle()!=null){
				dto.setReportTitle(reportname.getReportTitle());
			}
			if(reportname.getProgramName()!=null){
				dto.setProgramName(reportname.getProgramName());
			}
			if(reportname.getActiveIndicator()!=null){
				dto.setActiveIndicator(reportname.getActiveIndicator());
			}
			if(reportname.getInternalFilename()!=null){
				dto.setInternalFilename(reportname.getInternalFilename());
			}
			if(reportname.getExternalFilenamePrefix()!=null){
				dto.setExternalFilenamePrefix(reportname.getExternalFilenamePrefix());
			}
			if(reportname.getInternalIndicator()!=null){
				dto.setInternalIndicator(reportname.getInternalIndicator());
			}
			if(reportname.getCreatedBy()!=null){
				dto.setCreatedBy(reportname.getCreatedBy());
			}
			if(reportname.getCreatedDate()!=null){
				dto.setCreatedDate(reportname.getCreatedDate());
			}
			if(reportname.getModifiedBy()!=null){
				dto.setModifiedBy(reportname.getModifiedBy());
			}
			if(reportname.getModifiedDate()!=null){
				dto.setModifiedDate(reportname.getModifiedDate());
			}

			map.clear();
			return dto;

		}
		catch(Exception ex) {
			throw new DAOException("Error retrieving CSF_REPORT_NAMES entry, cause: " + ex.getMessage(), ex);
		}

	}

	@SuppressWarnings("unchecked")
	public List<CSFReportNamesDTO> retrieveRelated(CSFReportNamesDTO obj) throws DAOException {
		
		List<CSFReportNamesDTO> dtoList = new LinkedList<CSFReportNamesDTO>();
		
		CSFReportNamesDTO dto = null;
		
		try {
			String sql = "SELECT c FROM CsfReportNames c "+ buildWhereClause(obj,true);

			List<CsfReportNames> reportNamesList = reportNamesDao.executeQueryParameters(sql, map);

			for (CsfReportNames reportname : reportNamesList) {	
				
				dto = new CSFReportNamesDTO();
				if(reportname.getReportName()!=null){
					dto.setReportName(reportname.getReportName());
				}
				if(reportname.getReportTitle()!=null){
					dto.setReportTitle(reportname.getReportTitle());
				}
				if(reportname.getProgramName()!=null){
					dto.setProgramName(reportname.getProgramName());
				}
				if(reportname.getActiveIndicator()!=null){
					dto.setActiveIndicator(reportname.getActiveIndicator());
				}
				if(reportname.getInternalFilename()!=null){
					dto.setInternalFilename(reportname.getInternalFilename());
				}
				if(reportname.getExternalFilenamePrefix()!=null){
					dto.setExternalFilenamePrefix(reportname.getExternalFilenamePrefix());
				}
				if(reportname.getInternalIndicator()!=null){
					dto.setInternalIndicator(reportname.getInternalIndicator());
				}
				if(reportname.getCreatedBy()!=null){
					dto.setCreatedBy(reportname.getCreatedBy());
				}
				if(reportname.getCreatedDate()!=null){
					dto.setCreatedDate(reportname.getCreatedDate());
				}
				if(reportname.getModifiedBy()!=null){
					dto.setModifiedBy(reportname.getModifiedBy());
				}
				if(reportname.getModifiedDate()!=null){
					dto.setModifiedDate(reportname.getModifiedDate());
				}

				map.clear();
				dtoList.add(dto);
			}

			return dtoList;
		}
		catch(Exception ex) {
			throw new DAOException("Error retrieving CSF_REPORT_NAMES entries, cause: " + ex.getMessage(), ex);
		}

	}

	public void update(CSFReportNamesDTO obj) throws DAOException {

		CsfReportNames csfReportNames = new CsfReportNames();
		csfReportNames.setReportName(obj.getReportName());
		csfReportNames.setReportTitle(obj.getReportTitle());
		csfReportNames.setProgramName(obj.getProgramName());
		csfReportNames.setActiveIndicator(obj.getActiveIndicator());
		csfReportNames.setInternalFilename(obj.getInternalFilename());
		csfReportNames.setExternalFilenamePrefix(obj.getExternalFilenamePrefix());
		csfReportNames.setInternalIndicator(obj.getInternalIndicator());
		csfReportNames.setCreatedBy(obj.getCreatedBy());
		csfReportNames.setCreatedDate(obj.getCreatedDate());
		csfReportNames.setModifiedBy(obj.getModifiedBy());
		csfReportNames.setModifiedDate(obj.getModifiedDate());

		try {

			reportNamesDao.update(csfReportNames);

		}

		catch(Exception ex) {
			throw new DAOException("Error updating CSF_REPORT_NAMES entry, cause: " + ex.getMessage(),  ex);
		}

	}

	private String buildWhereClause(CSFReportNamesDTO obj, boolean select)throws DAOException  {

		if(obj == null) {
			return "";
		}
		StringBuilder buff = new StringBuilder();
		boolean whereClause = false;

		if (select == true) {
		if(obj.getReportName() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.reportName =:reportName");
			map.put("reportName",obj.getReportName());
		}

		if(obj.getReportTitle() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.reportTitle =:reportTitle");
			map.put("reportTitle",obj.getReportTitle());

		}

		if(obj.getProgramName() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.programName =:programName");
			map.put("programName",obj.getProgramName());
		}

		if(obj.getActiveIndicator() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.activeIndicator =:activeIndicator");
			map.put("activeIndicator",obj.getActiveIndicator());
		}

		if(obj.getInternalFilename() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.internalFilename =:internalFilename");
			map.put("internalFilename",obj.getInternalFilename());
		}

		if(obj.getExternalFilenamePrefix() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.externalFilenamePrefix =:externalFilenamePrefix");
			map.put("externalFilenamePrefix",obj.getExternalFilenamePrefix());
		}

		if(obj.getInternalIndicator() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.internalIndicator =:internalIndicator");
			map.put("internalIndicator",obj.getInternalIndicator());
		}

		if(obj.getCreatedBy()!= null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.createdBy =:createdBy");
			map.put("createdBy",obj.getCreatedBy());
		}

		if(obj.getCreatedDate() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.createdDate =:createdDate");
			map.put("createdDate",String.valueOf(obj.getCreatedDate()));
		}

		if(obj.getModifiedBy() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.modifiedBy =:modifiedBy");
			map.put("modifiedBy",obj.getModifiedBy());
		}

		if(obj.getModifiedDate() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.modifiedDate =:modifiedDate");
			map.put("modifiedDate",String.valueOf(obj.getModifiedDate()));
		}
		}
		if(!whereClause && select == false) {
			throw new DAOException( "Cannot update delete all rows in CCCOWNER.CSF_COMPANY_PARAMETERS");
		}

		return buff.toString();
	}

}


