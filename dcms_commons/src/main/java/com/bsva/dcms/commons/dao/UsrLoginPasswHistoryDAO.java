package com.bsva.dcms.commons.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bsva.dcms.commons.dto.UsrLoginPasswHistoryDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
/**
* Data access object interface that defines the methods that must be supported
* by all data access objects.
*
* Created By BSVATools
*/

public class UsrLoginPasswHistoryDAO {
	private String SQL_INSERT = 			"";
	private String SQL_SELECT = 			"";
	private String SQL_UPDATE = 			"";
	private String SQL_DELETE = 			"";
	private String SQL_SELECT_COUNT = 			"";
	private Connection conn;

	public UsrLoginPasswHistoryDAO(Connection conn) {
		this.conn = conn;
}

	/**
	 * Create a new record in Database.
	 *
	 * @param bean The Object to be inserted.
	 * @exception SQLException if something is wrong.
	 */
	public UsrLoginPasswHistoryDTO create(UsrLoginPasswHistoryDTO bean) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int pos = 1;

		try {
			SQL_INSERT = 
			"INSERT INTO CCCOWNER.USR_LOGIN_PASSW_HISTORY (LOGIN_NAME, OLD_PASSWORD_1, OLD_PASSWORD_2, OLD_PASSWORD_3, SYSTEM_NAME) VALUES (?, ?, ?, ?, ?) ";
			ps = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);

			ps.setString(pos++, bean.getLoginName());
			ps.setString(pos++, bean.getOldPassword1());
			ps.setString(pos++, bean.getOldPassword2());
			ps.setString(pos++, bean.getOldPassword3());
			ps.setString(pos++, bean.getSystemName());
			ps.executeUpdate();

			rs = ps.getGeneratedKeys();

			if (rs.next()) {
			}

			return bean;
		} catch (Exception ex) {
			throw new DAOException("Error creating CCCOWNER.USR_LOGIN_PASSW_HISTORY, cause: "
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
	public UsrLoginPasswHistoryDTO retrieve(UsrLoginPasswHistoryDTO bean) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int pos = 1;

		try {
			SQL_SELECT = 
			"SELECT LOGIN_NAME, OLD_PASSWORD_1, OLD_PASSWORD_2, OLD_PASSWORD_3, SYSTEM_NAME FROM CCCOWNER.USR_LOGIN_PASSW_HISTORY ";
			SQL_SELECT += this.buildWhereClause(bean, true);

			ps = conn.prepareStatement(SQL_SELECT);
			this.setParameters(bean, ps, pos, true);

			rs = ps.executeQuery();

			List results = this.getResults(rs);
			if (results.size() > 0) {
				return (UsrLoginPasswHistoryDTO) results.get(0);
			} else {
				return null;
			}
		} catch (Exception ex) {
			throw new DAOException("Error retrieving CCCOWNER.USR_LOGIN_PASSW_HISTORY, cause: "
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
	public List<UsrLoginPasswHistoryDTO> retrieveRelated(UsrLoginPasswHistoryDTO bean) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int pos = 1;

		try {
			SQL_SELECT = 
			"SELECT LOGIN_NAME, OLD_PASSWORD_1, OLD_PASSWORD_2, OLD_PASSWORD_3, SYSTEM_NAME FROM CCCOWNER.USR_LOGIN_PASSW_HISTORY ";
			SQL_SELECT += this.buildWhereClause(bean, true);

			ps = conn.prepareStatement(SQL_SELECT);
			this.setParameters(bean, ps, pos, true);

			rs = ps.executeQuery();

			List results = this.getResults(rs);
			if (results.size() > 0) {
				return (List<UsrLoginPasswHistoryDTO>) results;
			} else {
				return null;
			}
		} catch (Exception ex) {
			throw new DAOException("Error retrieving related CCCOWNER.USR_LOGIN_PASSW_HISTORY, cause: "
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
	public List<UsrLoginPasswHistoryDTO> retrieveRelated(UsrLoginPasswHistoryDTO bean, int startRow, int endRow) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int pos = 1;

		try {
	// Oracle specific 
			SQL_SELECT = 
			"SELECT * from (SELECT ROWNUM rn, LOGIN_NAME, OLD_PASSWORD_1, OLD_PASSWORD_2, OLD_PASSWORD_3, SYSTEM_NAME FROM CCCOWNER.USR_LOGIN_PASSW_HISTORY ";
			SQL_SELECT += this.buildWhereClause(bean, true);

			SQL_SELECT += ") WHERE rn > " + startRow;
			if( endRow > 0 ) {
				SQL_SELECT += " AND rn <= " + endRow;
			}
			ps = conn.prepareStatement(SQL_SELECT);
			this.setParameters(bean, ps, pos, true);

			rs = ps.executeQuery();

			List results = this.getResults(rs);
			if (results.size() > 0) {
				return (List<UsrLoginPasswHistoryDTO>) results;
			} else {
				return null;
			}
		} catch (Exception ex) {
			throw new DAOException("Error retrieving related CCCOWNER.USR_LOGIN_PASSW_HISTORY, cause: "
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
	public void update(UsrLoginPasswHistoryDTO bean) throws DAOException {
		PreparedStatement ps = null;
		int pos = 1;
		boolean first = true;

		try {
			SQL_UPDATE = 
			"UPDATE CCCOWNER.USR_LOGIN_PASSW_HISTORY SET ";

	/* dynamic SQL for update */
		if (bean.getLoginName() != null && !bean.getLoginName().isEmpty()) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "LOGIN_NAME=?";
		}
		if (bean.getOldPassword1() != null && !bean.getOldPassword1().isEmpty()) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "OLD_PASSWORD_1=?";
		}
		if (bean.getOldPassword2() != null && !bean.getOldPassword2().isEmpty()) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "OLD_PASSWORD_2=?";
		}
		if (bean.getOldPassword3() != null && !bean.getOldPassword3().isEmpty()) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "OLD_PASSWORD_3=?";
		}
		if (bean.getSystemName() != null && !bean.getSystemName().isEmpty()) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "SYSTEM_NAME=?";
		}
			SQL_UPDATE += this.buildWhereClause(bean, false);
			ps = conn.prepareStatement(SQL_UPDATE);


	/* dynamic update parameter */
			if (bean.getLoginName() != null && !bean.getLoginName().isEmpty()) {
				ps.setString(pos++, bean.getLoginName());
			}
			if (bean.getOldPassword1() != null && !bean.getOldPassword1().isEmpty()) {
				ps.setString(pos++, bean.getOldPassword1());
			}
			if (bean.getOldPassword2() != null && !bean.getOldPassword2().isEmpty()) {
				ps.setString(pos++, bean.getOldPassword2());
			}
			if (bean.getOldPassword3() != null && !bean.getOldPassword3().isEmpty()) {
				ps.setString(pos++, bean.getOldPassword3());
			}
			if (bean.getSystemName() != null && !bean.getSystemName().isEmpty()) {
				ps.setString(pos++, bean.getSystemName());
			}
			pos = this.setParameters(bean, ps, pos, false);

			ps.executeUpdate();

		} catch (Exception ex) {
			throw new DAOException("Error updating CCCOWNER.USR_LOGIN_PASSW_HISTORY, cause: "
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
	public void delete(UsrLoginPasswHistoryDTO bean) throws DAOException {
		PreparedStatement ps = null;
			throw new DAOException("Delete not supported - If you need this functionality uncomment code below and remove throw above");
			//TODO - *** update table to include unique keys and then remove commented code below and throw command above ***
/*
		int pos = 1;

		try {
			SQL_DELETE = 
			"DELETE FROM CCCOWNER.USR_LOGIN_PASSW_HISTORY";
			SQL_DELETE += this.buildWhereClause(bean, false);

			ps = conn.prepareStatement(SQL_DELETE);

			pos = this.setParameters(bean, ps, pos, false);

			ps.executeUpdate();

		} catch (Exception ex) {
			throw new DAOException("0901", "Error deleting CCCOWNER.USR_LOGIN_PASSW_HISTORY, cause: "
				+ ex.getMessage(), ex);
		} finally {
			close(ps);
		}
*/
	}
	/**
	 * Retrieve a record count from Database.
	 *
	 * @param bean The Object to be retrieved.
	 * @exception SQLException if something is wrong.
	 */
	public int retrieveRowCount(UsrLoginPasswHistoryDTO bean) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count=0;

		int pos = 1;

		try {
			SQL_SELECT_COUNT = 
			"SELECT COUNT(*) AS count FROM CCCOWNER.USR_LOGIN_PASSW_HISTORY ";
			SQL_SELECT_COUNT += this.buildWhereClause(bean, true);

			ps = conn.prepareStatement(SQL_SELECT_COUNT);
			this.setParameters(bean, ps, pos, true);

			rs = ps.executeQuery();

			while (rs.next()) {
				count=rs.getInt("count");
			}
		} catch (Exception ex) {
			throw new DAOException("Error retrieving CCCOWNER.USR_LOGIN_PASSW_HISTORY, cause: "
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
				UsrLoginPasswHistoryDTO bean = new UsrLoginPasswHistoryDTO();
				bean.setLoginName(rs.getString("LOGIN_NAME"));
				bean.setOldPassword1(rs.getString("OLD_PASSWORD_1"));
				bean.setOldPassword2(rs.getString("OLD_PASSWORD_2"));
				bean.setOldPassword3(rs.getString("OLD_PASSWORD_3"));
				bean.setSystemName(rs.getString("SYSTEM_NAME"));
				results.add(bean);
			}
			return results;
		} catch (Exception ex) {
			throw new DAOException("Error getting results CCCOWNER.USR_LOGIN_PASSW_HISTORY, cause: "
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
	private String buildWhereClause(UsrLoginPasswHistoryDTO bean, boolean select) throws DAOException {
		if(bean == null) {
			return "";
		}

		StringBuilder buff = new StringBuilder();
		boolean whereClause = false;

		if (bean.getLoginName() != null && !bean.getLoginName().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			 buff.append("LOGIN_NAME=?");
		}
		if (bean.getSystemName() != null && !bean.getSystemName().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			 buff.append("SYSTEM_NAME=?");
		}
		if (select == true) {
			if (bean.getOldPassword1() != null && !bean.getOldPassword1().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("OLD_PASSWORD_1=?");
			}
			if (bean.getOldPassword2() != null && !bean.getOldPassword2().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("OLD_PASSWORD_2=?");
			}
			if (bean.getOldPassword3() != null && !bean.getOldPassword3().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("OLD_PASSWORD_3=?");
			}
		}
		if(!whereClause && select == false) {
			throw new DAOException("Cannot update delete all rows in CCCOWNER.USR_LOGIN_PASSW_HISTORY");
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
	private int setParameters(UsrLoginPasswHistoryDTO bean, PreparedStatement ps, int pos, boolean select) throws DAOException {
		if(bean == null) {
			return 1;
		}
		try {
			if (bean.getLoginName() != null && !bean.getLoginName().isEmpty()) {
				ps.setString(pos++, bean.getLoginName());
			}
			if (bean.getSystemName() != null && !bean.getSystemName().isEmpty()) {
				ps.setString(pos++, bean.getSystemName());
			}
			if (select == true) {
				if (bean.getOldPassword1() != null && !bean.getOldPassword1().isEmpty()) {
					ps.setString(pos++, bean.getOldPassword1());
				}
				if (bean.getOldPassword2() != null && !bean.getOldPassword2().isEmpty()) {
					ps.setString(pos++, bean.getOldPassword2());
				}
				if (bean.getOldPassword3() != null && !bean.getOldPassword3().isEmpty()) {
					ps.setString(pos++, bean.getOldPassword3());
				}
			}
			return pos;
		} catch (Exception ex) {
			throw new DAOException("Error getting results CCCOWNER.USR_LOGIN_PASSW_HISTORY, cause: "
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
