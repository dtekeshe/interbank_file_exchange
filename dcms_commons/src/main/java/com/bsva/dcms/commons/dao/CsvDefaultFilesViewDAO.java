package com.bsva.dcms.commons.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bsva.dao.CsvDefaultFilesViewDao;
import com.bsva.dcms.commons.dto.CsvDefaultFilesViewDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.entities.CsvDefaultFilesView;

public class CsvDefaultFilesViewDAO {
	
	private String SQL_SELECT = "";
	private Map<String,Object>map = new HashMap<String, Object>();
	private CsvDefaultFilesViewDao csvDefaultFilesViewDao = new CsvDefaultFilesViewDao();
	public CsvDefaultFilesViewDAO(){

	}

	/**
	 * Retrieve a record from Database.
	 *
	 * @param bean The Object to be retrieved.
	 * @exception SQLException if something is wrong.
	 */

	public CsvDefaultFilesViewDTO retrieve(CsvDefaultFilesViewDTO bean) throws DAOException {

		CsvDefaultFilesViewDTO dto = new CsvDefaultFilesViewDTO();
		try {
			SQL_SELECT = "SELECT  c  FROM CsvFleetBillView c "+ buildWhereClause(bean,true);

			CsvDefaultFilesView csvDefaultFilesView = csvDefaultFilesViewDao.executeQueryParametersSingle(SQL_SELECT,map);
			
			
			if(csvDefaultFilesView == null){
				return null;				
			}else{
			
				
			map.clear();
			return dto;
			}

		} catch (Exception ex) {
			throw new DAOException("Error retrieving CsvDefaultFilesView" + ", cause: "+ ex.getMessage(), ex);
		}
	}

	/**
	 * Retrieve a list of records from Database.
	 *
	 * @param bean The List of Objects to be retrieved.
	 * @exception SQLException if something is wrong.
	 */

	@SuppressWarnings("unchecked")
	public List<CsvDefaultFilesViewDTO> retrieveRelated() throws DAOException {
		List<CsvDefaultFilesViewDTO> dtoList = new ArrayList<CsvDefaultFilesViewDTO>();
		
		try {
			  //String  sql = "from  CsvCcr00xDataView";
				
				//List<CsvCcr00xDataView> csvCcr00xDataViewList = csvCcr00xDataViewDao.executeQueryParametersNative(sql);	
				
            String  sql = "from  CsvDefaultFilesView";
			
			List<CsvDefaultFilesView> csvDefaultFilesViewList = csvDefaultFilesViewDao.executeQueryParametersNative(sql);		
			
			for (CsvDefaultFilesView csvDefaultFilesView : csvDefaultFilesViewList) {			

				CsvDefaultFilesViewDTO dto = new CsvDefaultFilesViewDTO();
			
				dto.setDestBankId(csvDefaultFilesView.getDestBankId());
				dto.setFilePrefix(csvDefaultFilesView.getFilenamePrefix());
				dto.setOriginatingId(csvDefaultFilesView.getOriginatingId());
				dto.setService(csvDefaultFilesView.getCsvDefaultFilesViewPK().getService());
				dto.setSubService(csvDefaultFilesView.getCsvDefaultFilesViewPK().getSubService());
				dto.setOriginatingBank(csvDefaultFilesView.getCsvDefaultFilesViewPK().getOriginatingBank());
				dto.setBankCode(csvDefaultFilesView.getCsvDefaultFilesViewPK().getDestBankCode());
				
				dtoList.add(dto);			
			}
			map.clear();
			return dtoList;

		} catch (Exception ex) {
			throw new DAOException("Error retrieving related CsvDefaultFilesView, cause: "+ ex.getMessage(), ex);
		} 
	}
	
	



	/**
	 * Build a Dynamic Where Clause.
	 *
	 * @param bean The Object to be used.
	 * @param select Is the where clause for a Query or Update.
	 * @exception SQLException if something is wrong.
	 */
	private String buildWhereClause(CsvDefaultFilesViewDTO bean, boolean select) throws DAOException {
		if(bean == null) {
			return "";
		}

		StringBuilder buff = new StringBuilder();
		boolean whereClause = false;

		if (bean.getBankCode()> 0) {
	
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			 buff.append("DEST_BANK_CODE =?");
		}
		
		if (select == true) {
			
			if (bean.getDestBankId() != null && !bean.getDestBankId().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("DEST_BANK_ID=?");
			}
			
			if (bean.getOriginatingBank() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("ORIGINATING_BANK=?");
			}
			
			if (bean.getOriginatingId() != null && !bean.getOriginatingId().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("ORIGINATING_ID=?");
			}
			
			if (bean.getFilePrefix() != null && !bean.getFilePrefix().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("FILENAME_PREFIX=?");
			}
		
			if (bean.getService() != null && !bean.getService().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("SERVICE=?");
			}
			
			if (bean.getSubService() != null && !bean.getSubService().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("SUB_SERVICE=?");
			}

		}
		if(!whereClause && select == false) {
			throw new DAOException("Cannot update delete all rows in CCCOWNER.CsvDefaultFilesView");
		}
		return buff.toString();
	}

	

}
