package com.bsva.dcms.commons.dao;


import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.bsva.dao.CsfMastercardOptionsDao;
import com.bsva.dcms.commons.dto.CsfMastercardOptionsDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.entities.CsfMastercardOptions;
/**
 * Data access object interface that defines the methods that must be supported
 * by all data access objects.
 *
 * Created By BSVATools
 */

public class CsfMastercardOptionsDAO{
	
	private Map<String,Object> map = new HashMap<>();
	//private CsfMastercardOptionsRepository csfMastercardOptionsDao = DaoFactory.csfMastercardOptionsInstance();
	private CsfMastercardOptionsDao csfMastercardOptionsDao = new CsfMastercardOptionsDao();

	public CsfMastercardOptionsDAO() {

	}

	/**
	 * Create a new record in Database.
	 *
	 * @param bean The Object to be inserted.
	 * @exception SQLException if something is wrong.
	 */

	public CsfMastercardOptionsDTO create(CsfMastercardOptionsDTO bean) throws DAOException {
		try {

			CsfMastercardOptions csfMastercardOptions = new CsfMastercardOptions();
			csfMastercardOptions.setBankCode((short) bean.getBankCode());
			csfMastercardOptions.setRecordReadStartByte((short) bean.getRecordReadStartByte());
			csfMastercardOptions.setRecordWriteStartByte((short) bean.getRecordWriteStartByte());
			csfMastercardOptions.setRecordLeadBytes(bean.getRecordLeadBytes());
			csfMastercardOptions.setEolPresent(bean.getEolPresent());
			csfMastercardOptions.setBitmapBinaryText(bean.getBitmapBinaryText());
			csfMastercardOptionsDao.create(csfMastercardOptions);


			return bean;
		} catch (Exception ex) {
			throw new DAOException("Error creating CCCOWNER.CSF_MASTERCARD_OPTIONS, cause: "
					+ ex.getMessage(), ex);
		}
	}
	/**
	 * Retrieve a record from Database.
	 *
	 * @param bean The Object to be retrieved.
	 * @exception SQLException if something is wrong.
	 */

	public CsfMastercardOptionsDTO retrieve(CsfMastercardOptionsDTO bean) throws DAOException {
		
		CsfMastercardOptionsDTO csfMastercardOptionsDTO = new CsfMastercardOptionsDTO();
		
		try {
			
			String sql = "SELECT c  FROM CsfMastercardOptions c "+ this.buildWhereClause(bean, true);
			
			CsfMastercardOptions csfMastercardOptions = csfMastercardOptionsDao.executeQueryParametersSingle(sql, map);

			if(csfMastercardOptions.getBankCode()!=null){
				csfMastercardOptionsDTO.setBankCode(csfMastercardOptions.getBankCode().shortValue());
			}
			if(csfMastercardOptions.getBitmapBinaryText()!=null){
				csfMastercardOptionsDTO.setBitmapBinaryText(csfMastercardOptions.getBitmapBinaryText());
			}
			if(csfMastercardOptions.getEolPresent()!=null){
				csfMastercardOptionsDTO.setEolPresent(csfMastercardOptions.getEolPresent());
			}
			//if(csfMastercardOptions.getRecordLeadBytes()!=null){
				//csfMastercardOptionsDTO.setRecordLeadBytes(csfMastercardOptions.getRecordLeadBytes());
			//}
			//  if(csfMastercardOptions.getRecordReadStartByte()!=null){
			csfMastercardOptionsDTO.setRecordReadStartByte(csfMastercardOptions.getRecordReadStartByte());
			// }
			// if(csfMastercardOptions.getRecordWriteStartByte()!=null){
			csfMastercardOptionsDTO.setRecordWriteStartByte(csfMastercardOptions.getRecordWriteStartByte());
			// }
			map.clear();
			return csfMastercardOptionsDTO;

		} catch (Exception ex) {
			throw new DAOException("Error retrieving CCCOWNER.CSF_MASTERCARD_OPTIONS, cause: "
					+ ex.getMessage(), ex);
		} 
	}

	/**
	 * Retrieve a list of records from Database.
	 *
	 * @param bean The List of Objects to be retrieved.
	 * @exception SQLException if something is wrong.
	 */

	public List<CsfMastercardOptionsDTO> retrieveRelated(CsfMastercardOptionsDTO bean) throws DAOException {
		
		List<CsfMastercardOptionsDTO> dtoList = new LinkedList<CsfMastercardOptionsDTO>();
		
		CsfMastercardOptionsDTO csfMastercardOptionsDTO = null;
		
		try {
			
			String sql ="SELECT c FROM CsfMastercardOptions c "+ this.buildWhereClause(bean, true);
			
			List<CsfMastercardOptions> csMastercardOptions = csfMastercardOptionsDao.executeQueryParameters(sql, map);
			
			for (CsfMastercardOptions csfMastercardOptions : csMastercardOptions) {				
				csfMastercardOptionsDTO = new CsfMastercardOptionsDTO();
				
				if(csfMastercardOptions.getBankCode()!=null){
					csfMastercardOptionsDTO.setBankCode(csfMastercardOptions.getBankCode().shortValue());
				}
				if(csfMastercardOptions.getBitmapBinaryText()!=null){
					csfMastercardOptionsDTO.setBitmapBinaryText(csfMastercardOptions.getBitmapBinaryText());
				}
				if(csfMastercardOptions.getEolPresent()!=null){
					csfMastercardOptionsDTO.setEolPresent(csfMastercardOptions.getEolPresent());
				}
				//if(csfMastercardOptions.getRecordLeadBytes()!=null){
					//csfMastercardOptionsDTO.setRecordLeadBytes(csfMastercardOptions.getRecordLeadBytes());
				//}
				//  if(csfMastercardOptions.getRecordReadStartByte()!=null){
				csfMastercardOptionsDTO.setRecordReadStartByte(csfMastercardOptions.getRecordReadStartByte());
				// }
				// if(csfMastercardOptions.getRecordWriteStartByte()!=null){
				csfMastercardOptionsDTO.setRecordWriteStartByte(csfMastercardOptions.getRecordWriteStartByte());
				// }
				dtoList.add(csfMastercardOptionsDTO);
			}
			
			map.clear();
			return dtoList;

		} catch (Exception ex) {
			throw new DAOException("Error retrieving related CCCOWNER.CSF_MASTERCARD_OPTIONS, cause: "
					+ ex.getMessage(), ex);
		} 
	}
	
	/**
	 * Update a record in Database.
	 *
	 * @param bean The Object to be updated.
	 * @exception SQLException if something is wrong.
	 */

	public void update(CsfMastercardOptionsDTO bean) throws DAOException {
		try {
			CsfMastercardOptions csfMastercardOptions = new CsfMastercardOptions();
			csfMastercardOptions.setBankCode((short) bean.getBankCode());
			csfMastercardOptions.setBitmapBinaryText(bean.getBitmapBinaryText());
			csfMastercardOptions.setEolPresent(bean.getEolPresent());
			csfMastercardOptions.setRecordLeadBytes(bean.getRecordLeadBytes());
			csfMastercardOptions.setRecordReadStartByte((short) bean.getRecordReadStartByte());
			csfMastercardOptions.setRecordWriteStartByte((short) bean.getRecordWriteStartByte());
			csfMastercardOptionsDao.update(csfMastercardOptions);

		} catch (Exception ex) {
			throw new DAOException("Error updating CCCOWNER.CSF_MASTERCARD_OPTIONS, cause: "
					+ ex.getMessage(), ex);
		}
	}
	/**
	 * Delete a record in Database.
	 *
	 * @param bean The Object to be deleted.
	 * @exception SQLException if something is wrong.
	 */

	public void delete(CsfMastercardOptionsDTO bean) {
		try{

			CsfMastercardOptions csfMastercardOptions = new CsfMastercardOptions();
			csfMastercardOptions.setBankCode((short) bean.getBankCode());
			csfMastercardOptions.setBitmapBinaryText(bean.getBitmapBinaryText());
			csfMastercardOptions.setEolPresent(bean.getEolPresent());
			csfMastercardOptions.setRecordLeadBytes(bean.getRecordLeadBytes());
			csfMastercardOptions.setRecordReadStartByte((short) bean.getRecordReadStartByte());
			csfMastercardOptions.setRecordWriteStartByte((short) bean.getRecordWriteStartByte());
			csfMastercardOptionsDao.delete(csfMastercardOptions);

		}catch(Exception ex){
			ex.getMessage();    	   
		}


	}

	/**
	 * Populate the query ResultSet.
	 *
	 * @param rs The ResultSet.
	 * @exception SQLException if something is wrong.
	 */
	@SuppressWarnings("unused")
	private List<CsfMastercardOptionsDTO> getResults(ResultSet rs) throws DAOException {
		try {
			List<CsfMastercardOptionsDTO> results = new ArrayList<CsfMastercardOptionsDTO>();
			while (rs.next()) {
				CsfMastercardOptionsDTO bean = new CsfMastercardOptionsDTO();
				bean.setBankCode(rs.getInt("BANK_CODE"));
				bean.setRecordReadStartByte(rs.getInt("RECORD_READ_START_BYTE"));
				bean.setRecordWriteStartByte(rs.getInt("RECORD_WRITE_START_BYTE"));
				bean.setRecordLeadBytes(rs.getBytes("RECORD_LEAD_BYTES"));
				bean.setEolPresent(rs.getString("EOL_PRESENT"));
				bean.setBitmapBinaryText(rs.getString("BITMAP_BINARY_TEXT"));
				results.add(bean);
			}
			return results;
		} catch (Exception ex) {
			throw new DAOException("Error getting results CCCOWNER.CSF_MASTERCARD_OPTIONS, cause: "
					+ ex.getMessage(), ex);
		} finally {
		}
	}
	/**
	 * Build a Dynamic Where Clause.
	 *
	 * @param bean The Object to be used.
	 * @param select Is the where clause for a Query or Update.
	 * @exception SQLException if something is wrong.
	 */
	private String buildWhereClause(CsfMastercardOptionsDTO bean, boolean select) throws DAOException {
		if(bean == null) {
			return "";
		}

		StringBuilder buff = new StringBuilder();
		boolean whereClause = false;

		if (bean.getBankCode() > 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.bankCode =:bankCode");
			map.put("bankCode",String.valueOf(bean.getBankCode()));
		}
		if (select == true) {
			if (bean.getRecordReadStartByte() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.recordReadStartByte =:recordReadStartByte");
				map.put("recordReadStartByte",String.valueOf(bean.getRecordReadStartByte()));
				
			}
			if (bean.getRecordWriteStartByte() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.recordWriteStartByte =:recordWriteStartByte");
				map.put("recordWriteStartByte",String.valueOf(bean.getRecordWriteStartByte()));
			}
			/*if (bean.getRecordLeadBytes() != null && bean.getRecordLeadBytes().length>0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.recordLeadBytes =:recordLeadBytes");
				map.put("recordLeadBytes",String.valueOf(bean.getRecordLeadBytes()));
			}*/
			if (bean.getEolPresent() != null && !bean.getEolPresent().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.eolPresent =:eolPresent");
				map.put("eolPresent",bean.getEolPresent());
			}
			if (bean.getBitmapBinaryText() != null && !bean.getBitmapBinaryText().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.bitmapBinaryText =:bitmapBinaryText");
				map.put("bitmapBinaryText",bean.getBitmapBinaryText());
			}
		}
		if(!whereClause && select == false) {
			throw new DAOException("Cannot update delete all rows in CCCOWNER.CSF_MASTERCARD_OPTIONS");
		}
		return buff.toString();
	}

	
	/**
	 * Close JDBC Statement.
	 *
	 * @param stmt Statement to be closed.
	 */
	private void close(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
			}
		}
	}
	/**
	 * Close JDBC ResultSet.
	 *
	 * @param rs ResultSet to be closed.
	 */
	private void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}
	}
}
