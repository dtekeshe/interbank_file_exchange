package com.bsva.dcms.commons.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.bsva.dao.CsoSpologDao;
import com.bsva.dcms.commons.dto.CsoSpologDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.entities.CsoSpolog;

public class CsoSpologDAO {


		private CsoSpologDao  csoSpologDao = new CsoSpologDao();
		
		private Map<String,Object> map = new HashMap<String, Object>();

		public CsoSpologDAO() {

		}

		/**
		 * Create a new record in Database.
		 *
		 * @param bean The Object to be inserted.
		 * @exception SQLException if something is wrong.
		 */

		public void create(CsoSpologDTO bean) throws DAOException {
			try {
				CsoSpolog csoSpolog = new CsoSpolog();
				csoSpolog.setMessage(bean.getMessage());
				csoSpolog.setMessageSeq(bean.getMessageSeq());
				csoSpolog.setProcessName(bean.getProcessName());
				csoSpolog.setProcessNameSeq(bean.getProcessNameSeq());
				csoSpolog.setVersion(bean.getVersion());
				
				csoSpologDao.create(csoSpolog);
				
				
			} catch (Exception ex) {
				throw new DAOException("Error creating CCCOWNER.CsoSpolog, cause: "+ ex.getMessage(), ex);
			} 
		}
		/**
		 * Retrieve a record from Database.
		 *
		 * @param bean The Object to be retrieved.
		 * @exception SQLException if something is wrong.
		 */

		public CsoSpologDTO retrieve(CsoSpologDTO bean) throws DAOException {

			CsoSpologDTO csoSpologDTO = new CsoSpologDTO();

			try {

				String sql ="SELECT c FROM CsoSpolog c"+ this.buildWhereClause(bean, true);
				CsoSpolog csoSpolog = csoSpologDao.executeQueryParametersSingleDate(sql, map);
	            if(csoSpolog != null){
				if(csoSpolog.getProcessName()!=null){
					csoSpologDTO.setProcessName(csoSpolog.getProcessName());
				}
				if(csoSpolog.getMessage()!=null){
					csoSpologDTO.setMessage(csoSpolog.getMessage());
				}
				if(csoSpolog.getMessageSeq()!= 0){
					csoSpologDTO.setMessageSeq(csoSpolog.getMessageSeq());
				}
				if(csoSpolog.getProcessNameSeq()!=0){
					csoSpologDTO.setProcessNameSeq(csoSpolog.getProcessNameSeq());
				}
				if(csoSpolog.getVersion()!=null){
					csoSpologDTO.setVersion(csoSpolog.getVersion());
				}
				map.clear();
				return csoSpologDTO;
	            }else{
				  return null;
	            }
			} catch (Exception ex) {
				throw new DAOException("Error retrieving CCCOWNER.CsoSpolog, cause: "+ ex.getMessage(), ex);
			}
		}

		

		/**
		 * Retrieve a list of records from Database.
		 *
		 * @param bean The List of Objects to be retrieved.
		 * @exception SQLException if something is wrong.
		 */


		public List<CsoSpologDTO> retrieveRelated(CsoSpologDTO bean) throws DAOException {

			List<CsoSpologDTO> dtoList = new LinkedList<>();
			try {
				String sql = "SELECT c FROM CsoSpolog c ";
				sql += this.buildWhereClause(bean, true);
				List<CsoSpolog> csoSpologs =  csoSpologDao.executeQueryParameters(sql, map);

				for (CsoSpolog csoSpolog : csoSpologs) {
					CsoSpologDTO csoSpologDTO = new CsoSpologDTO();
					if(csoSpolog.getProcessName()!=null){
						csoSpologDTO.setProcessName(csoSpolog.getProcessName());
					}
					if(csoSpolog.getMessage()!=null){
						csoSpologDTO.setMessage(csoSpolog.getMessage());
					}
					if(csoSpolog.getMessageSeq()!=0){
						csoSpologDTO.setMessageSeq(csoSpolog.getMessageSeq());
					}
					if(csoSpolog.getProcessNameSeq()!=0){
						csoSpologDTO.setProcessNameSeq(csoSpolog.getProcessNameSeq());
					}
					if(csoSpolog.getVersion()!=null){
						csoSpologDTO.setVersion(csoSpolog.getVersion());
					}
					dtoList.add(csoSpologDTO);
				}
				return dtoList;

			} catch (Exception ex) {
				throw new DAOException("Error retrieving related CCCOWNER.CsoSpolog, cause: "+ ex.getMessage(), ex);
			}
		}
		/**
		 * Update a record in Database.
		 *
		 * @param bean The Object to be updated.
		 * @exception SQLException if something is wrong.
		 */

		public void update(CsoSpologDTO bean) throws DAOException {

			CsoSpolog csoSpolog = new CsoSpolog();
			csoSpolog.setMessage(bean.getMessage());
			csoSpolog.setMessageSeq(bean.getMessageSeq());
			csoSpolog.setProcessName(bean.getProcessName());
			csoSpolog.setProcessNameSeq(bean.getProcessNameSeq());
			csoSpolog.setVersion(bean.getVersion());
			try {

				csoSpologDao.update(csoSpolog);

			} catch (Exception ex) {
				throw new DAOException("Error updating CCCOWNER.CsoSpolog, cause: "+ ex.getMessage(), ex);
			}
		}
		/**
		 * Delete a record in Database.
		 *
		 * @param bean The Object to be deleted.
		 * @exception SQLException if something is wrong.
		 */

		
		public void delete(CsoSpologDTO bean) throws DAOException {
				try {
					CsoSpolog csoSpolog = new CsoSpolog();
					csoSpolog.setMessage(bean.getMessage());
					csoSpolog.setMessageSeq(bean.getMessageSeq());
					csoSpolog.setProcessName(bean.getProcessName());
					csoSpolog.setProcessNameSeq(bean.getProcessNameSeq());
					csoSpolog.setVersion(bean.getVersion());
					
					csoSpologDao.delete(csoSpolog);
					
					
				} catch (Exception ex) {
					throw new DAOException("Error creating CCCOWNER.CsoSpolog, cause: "+ ex.getMessage(), ex);
				} 
			}

		/**
		 * Build a Dynamic Where Clause.
		 *
		 * @param bean The Object to be used.
		 * @param select Is the where clause for a Query or Update.
		 * @exception SQLException if something is wrong.
		 */
		private String buildWhereClause(CsoSpologDTO bean, boolean select) throws DAOException {
			if(bean == null) {
				return "";
			}

			StringBuilder buff = new StringBuilder();
			boolean whereClause = false;
			
			if (select == true) {
			if (bean.getProcessNameSeq() != 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
	            //Date date = bean.getProcessNameSeq();
	            //java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
				buff.append("c.processNameSeq =:processNameSeq");
				map.put("processNameSeq",bean.getProcessNameSeq());
			}
			if (bean.getMessageSeq() != 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
	           // Date date = bean.getMessageSeq();
	            //java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
				buff.append("c.messageSeq =:messageSeq");
				map.put("messageSeq",bean.getMessageSeq());
			}
			
				if (bean.getMessage() != null && !bean.getMessage().isEmpty()) {
					if(!whereClause) {
						whereClause = true;
						buff.append(" WHERE ");
					}
					else {
						buff.append(" AND ");
					}

					buff.append("c.message =:message");
					map.put("message",bean.getMessage());
				}
				if (bean.getProcessName() != null && !bean.getProcessName().isEmpty()) {
					if(!whereClause) {
						whereClause = true;
						buff.append(" WHERE ");
					}
					else {
						buff.append(" AND ");
					}

					buff.append("c.processName =:processName");
					map.put("processName",bean.getProcessName());
				}
				if (bean.getVersion() != null && !bean.getVersion().isEmpty()) {
					if(!whereClause) {
						whereClause = true;
						buff.append(" WHERE ");
					}
					else {
						buff.append(" AND ");
					}

					buff.append("c.version =:version");
					map.put("version",bean.getVersion());
				}
			}
			if(!whereClause && select == false) {
				throw new DAOException("Cannot update delete all rows in CCCOWNER.CsoSpolog");
			}
			return buff.toString();
		}

	}

