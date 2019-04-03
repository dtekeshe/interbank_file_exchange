package com.bsva.dcms.commons.dao;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.bsva.dao.CsfFilenameLookupDao;
import com.bsva.dcms.commons.dto.CsfFilenameLookupDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.entities.CsfFilenameLookup;
/**
 * Data access object interface that defines the methods that must be supported
 * by all data access objects.
 *
 * Created By BSVATools
 */

public class CsfFilenameLookupDAO{

	private Map<String,Object> map = new HashMap<>();

	//private CsfFilenameLookupRepository csfFileNameDao  = DaoFactory.csfFilenameLookupInstance();
	private CsfFilenameLookupDao csfFilenameLookupDao  = new CsfFilenameLookupDao();


	public CsfFilenameLookupDAO() {

	}


	/**
	 * Create a new record in Database.
	 *
	 * @param bean The Object to be inserted.
	 * @exception SQLException if something is wrong.
	 */

	public CsfFilenameLookupDTO create(CsfFilenameLookupDTO bean) throws DAOException {		
		try {

			CsfFilenameLookup csfFilenameLookup = new CsfFilenameLookup();
			csfFilenameLookup.setAlphaSeq(bean.getAlphaSeq());
			csfFilenameLookup.setNumIndex(Long.valueOf(bean.getNumIndex()));
			csfFilenameLookupDao.create(csfFilenameLookup);

			return bean;

		} catch (Exception ex) {
			throw new DAOException("Error creating CCCOWNER.CSF_FILENAME_LOOKUP, cause: "
					+ ex.getMessage(), ex);
		}
	}
	/**
	 * Retrieve a record from Database.
	 *
	 * @param bean The Object to be retrieved.
	 * @exception SQLException if something is wrong.
	 */

	public CsfFilenameLookupDTO retrieve(CsfFilenameLookupDTO bean) throws DAOException {
		CsfFilenameLookupDTO csfFilenameLookupDTO = new CsfFilenameLookupDTO();
		try {
			String sql = "SELECT c FROM CsfFilenameLookup c "+ buildWhereClause(bean,true);

			CsfFilenameLookup csfFilenameLookup = csfFilenameLookupDao.executeQueryParametersSingleDate(sql, map);	

			if(csfFilenameLookup.getAlphaSeq()!=null){
				csfFilenameLookupDTO.setAlphaSeq(csfFilenameLookup.getAlphaSeq());
			}
			if( csfFilenameLookup.getNumIndex()  > 0){
			csfFilenameLookupDTO.setNumIndex((int)csfFilenameLookup.getNumIndex().longValue());
			}

			map.clear();
			return csfFilenameLookupDTO;

		} catch (Exception ex) {
			throw new DAOException("Error retrieving CsfFilenameLookup, cause: "
					+ ex.getMessage(), ex);
		} 
	}

	/**
	 * Retrieve a list of records from Database.
	 *
	 * @param bean The List of Objects to be retrieved.
	 * @exception SQLException if something is wrong.
	 */

	public List<CsfFilenameLookupDTO> retrieveRelated(CsfFilenameLookupDTO bean) throws DAOException {
		List<CsfFilenameLookupDTO> dtoList = new LinkedList<CsfFilenameLookupDTO>();
		CsfFilenameLookupDTO csfFilenameLookupDTO = null;
		try {
			String sql = "SELECT c FROM CsfFilenameLookup c "+buildWhereClause(bean, true);
			List<CsfFilenameLookup> csfFilenameLookupList = csfFilenameLookupDao.executeQueryParametersDate(sql, map);

			for (CsfFilenameLookup csfFilenameLookup : csfFilenameLookupList) {

				csfFilenameLookupDTO = new CsfFilenameLookupDTO();
				if(csfFilenameLookup.getAlphaSeq()!=null){
					csfFilenameLookupDTO.setAlphaSeq(csfFilenameLookup.getAlphaSeq());
				}
				csfFilenameLookupDTO.setNumIndex((int)csfFilenameLookup.getNumIndex().longValue());

				dtoList.add(csfFilenameLookupDTO);
			}
			map.clear();
			return dtoList;

		} catch (Exception ex) {
			throw new DAOException("Error retrieving related CsfFilenameLookup, cause: "
					+ ex.getMessage(), ex);
		} 
	}
	/**
	 * Update a record in Database.
	 *
	 * @param bean The Object to be updated.
	 * @throws DAOException 
	 * @exception SQLException if something is wrong.
	 */

	public void update(CsfFilenameLookupDTO bean) throws DAOException{ //throws DAOException {
		try {
			CsfFilenameLookup csfFilenameLookup = new CsfFilenameLookup();
			csfFilenameLookup.setAlphaSeq(bean.getAlphaSeq());
			csfFilenameLookup.setNumIndex(Long.valueOf(bean.getNumIndex()));
			csfFilenameLookupDao.update(csfFilenameLookup);

		} catch (Exception ex) {
			throw new DAOException("Error Updating  related CsfFilenameLookup, cause: "+ ex.getMessage(), ex);
		} 

	}
	/**
	 * Delete a record in Database.
	 *
	 * @param bean The Object to be deleted.
	 * @exception SQLException if something is wrong.
	 */

	public void delete(CsfFilenameLookupDTO bean) throws DAOException {


		try {
			//SQL_DELETE = 
					//"DELETE FROM CsfFilenameLookup";
			//SQL_DELETE += this.buildWhereClause(bean, false);
			CsfFilenameLookup csfFilenameLookup = new CsfFilenameLookup();
			csfFilenameLookup.setAlphaSeq(bean.getAlphaSeq());
			csfFilenameLookup.setNumIndex(Long.valueOf(bean.getNumIndex()));
			csfFilenameLookupDao.delete(csfFilenameLookup);

		} catch (Exception ex) {
			throw new DAOException("Error deleting CsfFilenameLookup, cause: "
					+ ex.getMessage(), ex);
		} 

	}

	/**
	 * Build a Dynamic Where Clause.
	 *
	 * @param bean The Object to be used.
	 * @param select Is the where clause for a Query or Update.
	 * @exception SQLException if something is wrong.
	 */
	private String buildWhereClause(CsfFilenameLookupDTO bean, boolean select) throws DAOException {
		if(bean == null) {
			return "";
		}

		StringBuilder buff = new StringBuilder();
		boolean whereClause = false;
		
	if (select == true) {

		if (bean.getNumIndex() > -1) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}

			buff.append("c.numIndex =:numIndex");
			map.put("numIndex",Long.valueOf(bean.getNumIndex()));
		}
			if (bean.getAlphaSeq() != null && !bean.getAlphaSeq().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.alphaSeq =:alphaSeq");
				map.put("alphaSeq",bean.getAlphaSeq());
			}
		
	 }
	if(!whereClause && select == false) {
		throw new DAOException( "Cannot update delete all rows in CsfFilenameLookup");
	}
	
		return buff.toString();
	}

}
