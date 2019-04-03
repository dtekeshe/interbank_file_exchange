package com.bsva.dcms.commons.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bsva.dcms.commons.dto.CsfStatusCodesDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
/**
* Data access object interface that defines the methods that must be supported
* by all data access objects.
*
* Created By BSVATools
*/

public class CsfStatusCodesDAO{
	private String SQL_INSERT = 			"";
	private String SQL_SELECT = 			"";
	private String SQL_UPDATE = 			"";
	private String SQL_DELETE = 			"";
	private Connection conn;

	public CsfStatusCodesDAO(Connection conn) {
		this.conn = conn;
}

	/**
	 * Create a new record in Database.
	 *
	 * @param bean The Object to be inserted.
	 * @exception SQLException if something is wrong.
	 */
	
	public CsfStatusCodesDTO create(CsfStatusCodesDTO bean) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int pos = 1;

		try {
			SQL_INSERT = 
			"INSERT INTO CCCOWNER.CSF_STATUS_CODES (STATUS_CODE, STATUS_DESCRIPTION, CREATED_BY, CREATED_DATE, MODIFIED_BY, MODIFIED_DATE) VALUES (?, ?, ?, ?, ?, ?) ";
			ps = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);

			ps.setString(pos++, bean.getStatusCode());
			ps.setString(pos++, bean.getStatusDescription());
			ps.setString(pos++, bean.getCreatedBy());
			ps.setDate(pos++, new Date(bean.getCreatedDate().getTime()));
			ps.setString(pos++, bean.getModifiedBy());
			ps.setDate(pos++, new Date(bean.getModifiedDate().getTime()));
			ps.executeUpdate();

			rs = ps.getGeneratedKeys();

			if (rs.next()) {
			}

			return bean;
		} catch (Exception ex) {
			throw new DAOException("Error creating CCCOWNER.CSF_STATUS_CODES, cause: "
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
	
	public CsfStatusCodesDTO retrieve(CsfStatusCodesDTO bean) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int pos = 1;

		try {
			SQL_SELECT = 
			"SELECT STATUS_CODE, STATUS_DESCRIPTION, CREATED_BY, CREATED_DATE, MODIFIED_BY, MODIFIED_DATE FROM CCCOWNER.CSF_STATUS_CODES ";
			SQL_SELECT += this.buildWhereClause(bean, true);

			ps = conn.prepareStatement(SQL_SELECT);
			this.setParameters(bean, ps, pos, true);

			rs = ps.executeQuery();

			List results = this.getResults(rs);
			if (results.size() > 0) {
				return (CsfStatusCodesDTO) results.get(0);
			} else {
				return null;
			}
		} catch (Exception ex) {
			throw new DAOException("Error retrieving CCCOWNER.CSF_STATUS_CODES, cause: "
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
	
	public List<CsfStatusCodesDTO> retrieveRelated(CsfStatusCodesDTO bean) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int pos = 1;

		try {
			SQL_SELECT = 
			"SELECT STATUS_CODE, STATUS_DESCRIPTION, CREATED_BY, CREATED_DATE, MODIFIED_BY, MODIFIED_DATE FROM CCCOWNER.CSF_STATUS_CODES ";
			SQL_SELECT += this.buildWhereClause(bean, true);

			ps = conn.prepareStatement(SQL_SELECT);
			this.setParameters(bean, ps, pos, true);

			rs = ps.executeQuery();

			List results = this.getResults(rs);
			if (results.size() > 0) {
				return (List<CsfStatusCodesDTO>) results;
			} else {
				return null;
			}
		} catch (Exception ex) {
			throw new DAOException("Error retrieving related CCCOWNER.CSF_STATUS_CODES, cause: "
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
	
	public void update(CsfStatusCodesDTO bean) throws DAOException {
		PreparedStatement ps = null;
//			throw new DAOException("Update not supported - No unique or primary keys defined");
			//TODO - *** update table to include unique keys and then remove commented code below and throw command above ***

		int pos = 1;
		boolean first = true;

		try {
			SQL_UPDATE = 
			"UPDATE CCCOWNER.CSF_STATUS_CODES SET ";

	/* dynamic SQL for update */
		if (bean.getStatusCode() != null && !bean.getStatusCode().isEmpty()) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "STATUS_CODE=?";
		}
		if (bean.getStatusDescription() != null && !bean.getStatusDescription().isEmpty()) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "STATUS_DESCRIPTION=?";
		}
		if (bean.getCreatedBy() != null && !bean.getCreatedBy().isEmpty()) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "CREATED_BY=?";
		}
		if (bean.getCreatedDate() != null) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "CREATED_DATE=?";
		}
		if (bean.getModifiedBy() != null && !bean.getModifiedBy().isEmpty()) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "MODIFIED_BY=?";
		}
		if (bean.getModifiedDate() != null) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "MODIFIED_DATE=?";
		}
			SQL_UPDATE += this.buildWhereClause(bean, false);
			ps = conn.prepareStatement(SQL_UPDATE);


	/* dynamic update parameter */
			if (bean.getStatusCode() != null && !bean.getStatusCode().isEmpty()) {
				ps.setString(pos++, bean.getStatusCode());
			}
			if (bean.getStatusDescription() != null && !bean.getStatusDescription().isEmpty()) {
				ps.setString(pos++, bean.getStatusDescription());
			}
			if (bean.getCreatedBy() != null && !bean.getCreatedBy().isEmpty()) {
				ps.setString(pos++, bean.getCreatedBy());
			}
			if (bean.getCreatedDate() != null) {
				ps.setDate(pos++, new Date(bean.getCreatedDate().getTime()));
			}
			if (bean.getModifiedBy() != null && !bean.getModifiedBy().isEmpty()) {
				ps.setString(pos++, bean.getModifiedBy());
			}
			if (bean.getModifiedDate() != null) {
				ps.setDate(pos++, new Date(bean.getModifiedDate().getTime()));
			}
			pos = this.setParameters(bean, ps, pos, false);

			ps.executeUpdate();

		} catch (Exception ex) {
			throw new DAOException("Error updating CCCOWNER.CSF_STATUS_CODES, cause: "
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
	
	public void delete(CsfStatusCodesDTO bean) throws DAOException {
		PreparedStatement ps = null;
			throw new DAOException("Delete not supported - If you need this functionality uncomment code below and remove throw above");
			//TODO - *** update table to include unique keys and then remove commented code below and throw command above ***
/*
		int pos = 1;

		try {
			SQL_DELETE = 
			"DELETE FROM CCCOWNER.CSF_STATUS_CODES";
			SQL_DELETE += this.buildWhereClause(bean, false);

			ps = conn.prepareStatement(SQL_DELETE);

			pos = this.setParameters(bean, ps, pos, false);

			ps.executeUpdate();

		} catch (Exception ex) {
			throw new DAOException("Error deleting CCCOWNER.CSF_STATUS_CODES, cause: "
				+ ex.getMessage(), ex);
		} finally {
			close(ps);
		}
*/
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
				CsfStatusCodesDTO bean = new CsfStatusCodesDTO();
				bean.setStatusCode(rs.getString("STATUS_CODE"));
				bean.setStatusDescription(rs.getString("STATUS_DESCRIPTION"));
				bean.setCreatedBy(rs.getString("CREATED_BY"));
				bean.setCreatedDate(rs.getDate("CREATED_DATE"));
				bean.setModifiedBy(rs.getString("MODIFIED_BY"));
				bean.setModifiedDate(rs.getDate("MODIFIED_DATE"));
				results.add(bean);
			}
			return results;
		} catch (Exception ex) {
			throw new DAOException("Error getting results CCCOWNER.CSF_STATUS_CODES, cause: "
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
	private String buildWhereClause(CsfStatusCodesDTO bean, boolean select) throws DAOException {
		if(bean == null) {
			return "";
		}

		StringBuilder buff = new StringBuilder();
		boolean whereClause = false;

		if (select == true) {
			if (bean.getStatusCode() != null && !bean.getStatusCode().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("c.STATUS_CODE=?");
			}
			if (bean.getStatusDescription() != null && !bean.getStatusDescription().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("c.STATUS_DESCRIPTION=?");
			}
			if (bean.getCreatedBy() != null && !bean.getCreatedBy().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("c.CREATED_BY=?");
			}
			if (bean.getCreatedDate() != null) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("c.CREATED_DATE=?");
			}
			if (bean.getModifiedBy() != null && !bean.getModifiedBy().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("c.MODIFIED_BY=?");
			}
			if (bean.getModifiedDate() != null) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("c.MODIFIED_DATE=?");
			}
		}
		if(!whereClause && select == false) {
			throw new DAOException("Cannot update delete all rows in CCCOWNER.CSF_STATUS_CODES");
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
	private int setParameters(CsfStatusCodesDTO bean, PreparedStatement ps, int pos, boolean select) throws DAOException {
		if(bean == null) {
			return 1;
		}
		try {
			if (select == true) {
				if (bean.getStatusCode() != null && !bean.getStatusCode().isEmpty()) {
					ps.setString(pos++, bean.getStatusCode());
				}
				if (bean.getStatusDescription() != null && !bean.getStatusDescription().isEmpty()) {
					ps.setString(pos++, bean.getStatusDescription());
				}
				if (bean.getCreatedBy() != null && !bean.getCreatedBy().isEmpty()) {
					ps.setString(pos++, bean.getCreatedBy());
				}
				if (bean.getCreatedDate() != null) {
					ps.setDate(pos++, new Date(bean.getCreatedDate().getTime()));
				}
				if (bean.getModifiedBy() != null && !bean.getModifiedBy().isEmpty()) {
					ps.setString(pos++, bean.getModifiedBy());
				}
				if (bean.getModifiedDate() != null) {
					ps.setDate(pos++, new Date(bean.getModifiedDate().getTime()));
				}
			}
			return pos;
		} catch (Exception ex) {
			throw new DAOException("Error getting results CCCOWNER.CSF_STATUS_CODES, cause: "
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
