package com.bsva.dcms.commons.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.bsva.dcms.commons.dto.CsoInternalFilesDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
/**
* Data access object interface that defines the methods that must be supported
* by all data access objects.
*
* Created By BSVATools
*/

public class CsoInternalFilesDAO {
	private String SQL_INSERT = 			"";
	private String SQL_SELECT = 			"";
	private String SQL_UPDATE = 			"";
	private String SQL_DELETE = 			"";
	private String SQL_SELECT_COUNT = 			"";
	private DataSource conn;
	
	

	public CsoInternalFilesDAO(DataSource conn) {
		this.conn = conn;
}

	/**
	 * Create a new record in Database.
	 *
	 * @param bean The Object to be inserted.
	 * @exception SQLException if something is wrong.
	 */

	public CsoInternalFilesDTO create(CsoInternalFilesDTO bean) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int pos = 1;

		try {
			SQL_INSERT = 
			"INSERT INTO CCCOWNER.CSO_INTERNAL_FILES (FILENAME, ABSOLUTE_FILENAME, SERVICE, SUB_SERVICE, RECORD_COUNT) VALUES (?, ?, ?, ?, ?) ";
			//ps = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);

			ps.setString(pos++, bean.getFilename());
			ps.setString(pos++, bean.getAbsoluteFilename());
			ps.setString(pos++, bean.getService());
			ps.setString(pos++, bean.getSubService());
			ps.setLong(pos++, bean.getRecordCount());
			ps.executeUpdate();

			rs = ps.getGeneratedKeys();

			if (rs.next()) {
			}

			return bean;
		} catch (Exception ex) {
			throw new DAOException("Error creating CCCOWNER.CSO_INTERNAL_FILES, cause: "
					+ ex.getMessage(), ex);
		} finally {
			close(rs);
			close(ps);
		}
	}
	/**
	 * Retrieve a record from Database.
	 *
	 * @param bean The Object to be retrieved.
	 * @exception SQLException if something is wrong.
	 */

	public CsoInternalFilesDTO retrieve(CsoInternalFilesDTO bean) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int pos = 1;

		try {
			SQL_SELECT = 
			"SELECT FILENAME, ABSOLUTE_FILENAME, SERVICE, SUB_SERVICE, RECORD_COUNT FROM CCCOWNER.CSO_INTERNAL_FILES ";
			SQL_SELECT += this.buildWhereClause(bean, true);

			//ps = conn.prepareStatement(SQL_SELECT);
			this.setParameters(bean, ps, pos, true);

			rs = ps.executeQuery();

			List results = this.getResults(rs);
			if (results.size() > 0) {
				return (CsoInternalFilesDTO) results.get(0);
			} else {
				return null;
			}
		} catch (Exception ex) {
			throw new DAOException("Error retrieving CCCOWNER.CSO_INTERNAL_FILES, cause: "
				+ ex.getMessage(), ex);
		} finally {
			close(rs);
			close(ps);
		}
	}

	/**
	 * Retrieve a list of records from Database.
	 *
	 * @param bean The List of Objects to be retrieved.
	 * @exception SQLException if something is wrong.
	 */

	public List<CsoInternalFilesDTO> retrieveRelated(CsoInternalFilesDTO bean) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int pos = 1;

		try {
			SQL_SELECT = 
			"SELECT FILENAME, ABSOLUTE_FILENAME, SERVICE, SUB_SERVICE, RECORD_COUNT FROM CCCOWNER.CSO_INTERNAL_FILES ";
			SQL_SELECT += this.buildWhereClause(bean, true);

			//ps = conn.prepareStatement(SQL_SELECT);
			this.setParameters(bean, ps, pos, true);

			rs = ps.executeQuery();

			List results = this.getResults(rs);
			if (results.size() > 0) {
				return (List<CsoInternalFilesDTO>) results;
			} else {
				return null;
			}
		} catch (Exception ex) {
			throw new DAOException("Error retrieving related CCCOWNER.CSO_INTERNAL_FILES, cause: "
				+ ex.getMessage(), ex);
		} finally {
			close(rs);
			close(ps);
		}
	}
	/**
	 * Retrieve a list of records based on rowcountfrom Database.
	 *
	 * @param bean The List of Objects to be retrieved.
	 * @exception SQLException if something is wrong.
	 */
	public List<CsoInternalFilesDTO> retrieveRelated(CsoInternalFilesDTO bean, int startRow, int endRow) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int pos = 1;

		try {
	// Oracle specific 
			SQL_SELECT = 
			"SELECT * from (SELECT ROWNUM rn, FILENAME, ABSOLUTE_FILENAME, SERVICE, SUB_SERVICE, RECORD_COUNT FROM CCCOWNER.CSO_INTERNAL_FILES ";
			SQL_SELECT += this.buildWhereClause(bean, true);

			SQL_SELECT += ") WHERE rn > " + startRow;
			if( endRow > 0 ) {
				SQL_SELECT += " AND rn <= " + endRow;
			}
			//ps = conn.prepareStatement(SQL_SELECT);
			this.setParameters(bean, ps, pos, true);

			rs = ps.executeQuery();

			List results = this.getResults(rs);
			if (results.size() > 0) {
				return (List<CsoInternalFilesDTO>) results;
			} else {
				return null;
			}
		} catch (Exception ex) {
			throw new DAOException("Error retrieving related CCCOWNER.CSO_INTERNAL_FILES, cause: "
				+ ex.getMessage(), ex);
		} finally {
			close(rs);
			close(ps);
		}
	}
	/**
	 * Update a record in Database.
	 *
	 * @param bean The Object to be updated.
	 * @exception SQLException if something is wrong.
	 */

	public void update(CsoInternalFilesDTO bean) throws DAOException {
		PreparedStatement ps = null;
		int pos = 1;
		boolean first = true;

		try {
			SQL_UPDATE = 
			"UPDATE CCCOWNER.CSO_INTERNAL_FILES SET ";

	/* dynamic SQL for update */
		if (bean.getFilename() != null && !bean.getFilename().isEmpty()) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "FILENAME=?";
		}
		if (bean.getAbsoluteFilename() != null && !bean.getAbsoluteFilename().isEmpty()) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "ABSOLUTE_FILENAME=?";
		}
		if (bean.getService() != null && !bean.getService().isEmpty()) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "SERVICE=?";
		}
		if (bean.getSubService() != null && !bean.getSubService().isEmpty()) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "SUB_SERVICE=?";
		}
		if (bean.getRecordCount() > 0L) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "RECORD_COUNT=?";
		}
			SQL_UPDATE += this.buildWhereClause(bean, false);
			//ps = conn.prepareStatement(SQL_UPDATE);


	/* dynamic update parameter */
			if (bean.getFilename() != null && !bean.getFilename().isEmpty()) {
				ps.setString(pos++, bean.getFilename());
			}
			if (bean.getAbsoluteFilename() != null && !bean.getAbsoluteFilename().isEmpty()) {
				ps.setString(pos++, bean.getAbsoluteFilename());
			}
			if (bean.getService() != null && !bean.getService().isEmpty()) {
				ps.setString(pos++, bean.getService());
			}
			if (bean.getSubService() != null && !bean.getSubService().isEmpty()) {
				ps.setString(pos++, bean.getSubService());
			}
			if (bean.getRecordCount() > 0L) {
				ps.setLong(pos++, bean.getRecordCount());
			}
			pos = this.setParameters(bean, ps, pos, false);

			ps.executeUpdate();

		} catch (Exception ex) {
			throw new DAOException("Error updating CCCOWNER.CSO_INTERNAL_FILES, cause: "
				+ ex.getMessage(), ex);
		} finally {
			close(ps);
		}
	}
	/**
	 * Delete a record in Database.
	 *
	 * @param bean The Object to be deleted.
	 * @exception SQLException if something is wrong.
	 */

	public void delete(CsoInternalFilesDTO bean) throws DAOException {
		PreparedStatement ps = null;
		//	throw new DAOException("Delete not supported - If you need this functionality uncomment code below and remove throw above");
			//TODO - *** update table to include unique keys and then remove commented code below and throw command above ***

		int pos = 1;

		try {
			SQL_DELETE = 
			"DELETE FROM CCCOWNER.CSO_INTERNAL_FILES";
			SQL_DELETE += this.buildWhereClause(bean, true);

			//ps = conn.prepareStatement(SQL_DELETE);

			pos = this.setParameters(bean, ps, pos, true);

			ps.executeUpdate();

		} catch (Exception ex) {
			throw new DAOException("Error deleting CCCOWNER.CSO_INTERNAL_FILES, cause: "
				+ ex.getMessage(), ex);
		} finally {
			close(ps);
		}
	}
	/**
	 * Retrieve a record count from Database.
	 *
	 * @param bean The Object to be retrieved.
	 * @exception SQLException if something is wrong.
	 */
	public int retrieveRowCount(CsoInternalFilesDTO bean) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count=0;

		int pos = 1;

		try {
			SQL_SELECT_COUNT = 
			"SELECT COUNT(*) AS count FROM CCCOWNER.CSO_INTERNAL_FILES ";
			SQL_SELECT_COUNT += this.buildWhereClause(bean, true);

			//ps = conn.prepareStatement(SQL_SELECT_COUNT);
			this.setParameters(bean, ps, pos, true);

			rs = ps.executeQuery();

			while (rs.next()) {
				count=rs.getInt("count");
			}
		} catch (Exception ex) {
			throw new DAOException("Error retrieving CCCOWNER.CSO_INTERNAL_FILES, cause: "
				+ ex.getMessage(), ex);
		} finally {
			close(rs);
			close(ps);
		}
		return count;
	}

	/**
	 * Populate the query ResultSet.
	 *
	 * @param rs The ResultSet.
	 * @exception SQLException if something is wrong.
	 */
	private List getResults(ResultSet rs) throws DAOException {
		try {
			List results = new ArrayList();
			while (rs.next()) {
				CsoInternalFilesDTO bean = new CsoInternalFilesDTO();
				bean.setFilename(rs.getString("FILENAME"));
				bean.setAbsoluteFilename(rs.getString("ABSOLUTE_FILENAME"));
				bean.setService(rs.getString("SERVICE"));
				bean.setSubService(rs.getString("SUB_SERVICE"));
				bean.setRecordCount(rs.getLong("RECORD_COUNT"));
				results.add(bean);
			}
			return results;
		} catch (Exception ex) {
			throw new DAOException("Error getting results CCCOWNER.CSO_INTERNAL_FILES, cause: "
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
	private String buildWhereClause(CsoInternalFilesDTO bean, boolean select) throws DAOException {
		if(bean == null) {
			return "";
		}

		StringBuilder buff = new StringBuilder();
		boolean whereClause = false;

		if (bean.getFilename() != null && !bean.getFilename().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			 buff.append("c.FILENAME=?");
		}
		if (bean.getService() != null && !bean.getService().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			 buff.append("c.SERVICE=?");
		}
		if (bean.getSubService() != null && !bean.getSubService().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			 buff.append("c.SUB_SERVICE=?");
		}
		if (select == true) {
			if (bean.getAbsoluteFilename() != null && !bean.getAbsoluteFilename().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("c.ABSOLUTE_FILENAME=?");
			}
			if (bean.getRecordCount() > 0L) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("c.RECORD_COUNT=?");
			}
		}
		if(!whereClause && select == false) {
			throw new DAOException("Cannot update delete all rows in CCCOWNER.CSO_INTERNAL_FILES");
		}
		return buff.toString();
	}

	/**
	 * Build a Dynamic Parameter Class.
	 *
	 * @param bean The Object to be inserted.
	 * @param ps The Prepared Statement.
	 * @param pos offset for parameters.
	 * @param select Is parameters for a Query or Update.
	 * @exception SQLException if something is wrong.
	 */
	private int setParameters(CsoInternalFilesDTO bean, PreparedStatement ps, int pos, boolean select) throws DAOException {
		if(bean == null) {
			return 1;
		}
		try {
			if (bean.getFilename() != null && !bean.getFilename().isEmpty()) {
				ps.setString(pos++, bean.getFilename());
			}
			if (bean.getService() != null && !bean.getService().isEmpty()) {
				ps.setString(pos++, bean.getService());
			}
			if (bean.getSubService() != null && !bean.getSubService().isEmpty()) {
				ps.setString(pos++, bean.getSubService());
			}
			if (select == true) {
				if (bean.getAbsoluteFilename() != null && !bean.getAbsoluteFilename().isEmpty()) {
					ps.setString(pos++, bean.getAbsoluteFilename());
				}
				if (bean.getRecordCount() > 0L) {
					ps.setLong(pos++, bean.getRecordCount());
				}
			}
			return pos;
		} catch (Exception ex) {
			throw new DAOException("Error getting results CCCOWNER.CSO_INTERNAL_FILES, cause: "
				+ ex.getMessage(), ex);
		} finally {
		}
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
