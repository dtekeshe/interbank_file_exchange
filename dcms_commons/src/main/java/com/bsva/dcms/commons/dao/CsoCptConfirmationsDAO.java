package com.bsva.dcms.commons.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.bsva.dcms.commons.dto.CsoCptConfirmationsDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
/**
* Data access object interface that defines the methods that must be supported
* by all data access objects.
*
* Created By BSVATools
*/

public class CsoCptConfirmationsDAO {
	private String SQL_INSERT = 			"";
	private String SQL_SELECT = 			"";
	private String SQL_UPDATE = 			"";
	private String SQL_DELETE = 			"";
	private String SQL_SELECT_COUNT = 			"";
	private DataSource conn;

	public CsoCptConfirmationsDAO(DataSource conn) {
		this.conn = conn;
}

	/**
	 * Create a new record in Database.
	 *
	 * @param bean The Object to be inserted.
	 * @exception SQLException if something is wrong.
	 */
	public CsoCptConfirmationsDTO create(CsoCptConfirmationsDTO bean) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int pos = 1;

		try {
			SQL_INSERT = 
			"INSERT INTO CCCOWNER.CSO_CPT_CONFIRMATIONS (CHECK_POINT, SERVICE, SUB_SERVICE, CPT_PROCESS_DATE, CPT_CONFIRMED, CPT_CONFIRMED_USER, CPT_CONFIRMATION_RAISED, CPT_CONFIRMED_TIME) VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";
			//ps = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);

			ps.setString(pos++, bean.getCheckPoint());
			ps.setString(pos++, bean.getService());
			ps.setString(pos++, bean.getSubService());
			ps.setDate(pos++, new Date(bean.getCptProcessDate().getTime()));
			ps.setString(pos++, bean.getCptConfirmed());
			ps.setString(pos++, bean.getCptConfirmedUser());
			ps.setTimestamp(pos++, bean.getCptConfirmationRaised());
			ps.setTimestamp(pos++, bean.getCptConfirmedTime());
			ps.executeUpdate();

			rs = ps.getGeneratedKeys();

			if (rs.next()) {
			}

			return bean;
		} catch (Exception ex) {
			throw new DAOException("Error creating CCCOWNER.CSO_CPT_CONFIRMATIONS, cause: "
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
	public CsoCptConfirmationsDTO retrieve(CsoCptConfirmationsDTO bean) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int pos = 1;

		try {
			SQL_SELECT = 
			"SELECT CHECK_POINT, SERVICE, SUB_SERVICE, CPT_PROCESS_DATE, CPT_CONFIRMED, CPT_CONFIRMED_USER, CPT_CONFIRMATION_RAISED, CPT_CONFIRMED_TIME FROM CCCOWNER.CSO_CPT_CONFIRMATIONS ";
			SQL_SELECT += this.buildWhereClause(bean, true);

			//ps = conn.prepareStatement(SQL_SELECT);
			this.setParameters(bean, ps, pos, true);

			rs = ps.executeQuery();

			List results = this.getResults(rs);
			if (results.size() > 0) {
				return (CsoCptConfirmationsDTO) results.get(0);
			} else {
				return null;
			}
		} catch (Exception ex) {
			throw new DAOException("Error retrieving CCCOWNER.CSO_CPT_CONFIRMATIONS, cause: "
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
	public List<CsoCptConfirmationsDTO> retrieveRelated(CsoCptConfirmationsDTO bean) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int pos = 1;

		try {
			SQL_SELECT = 
			"SELECT CHECK_POINT, SERVICE, SUB_SERVICE, CPT_PROCESS_DATE, CPT_CONFIRMED, CPT_CONFIRMED_USER, CPT_CONFIRMATION_RAISED, CPT_CONFIRMED_TIME FROM CCCOWNER.CSO_CPT_CONFIRMATIONS ";
			SQL_SELECT += this.buildWhereClause(bean, true);

			//ps = conn.prepareStatement(SQL_SELECT);
			this.setParameters(bean, ps, pos, true);

			rs = ps.executeQuery();

			List results = this.getResults(rs);
			if (results.size() > 0) {
				return (List<CsoCptConfirmationsDTO>) results;
			} else {
				return null;
			}
		} catch (Exception ex) {
			throw new DAOException("Error retrieving related CCCOWNER.CSO_CPT_CONFIRMATIONS, cause: "
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
	public List<CsoCptConfirmationsDTO> retrieveRelated(CsoCptConfirmationsDTO bean, int startRow, int endRow) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int pos = 1;

		try {
	// Oracle specific 
			SQL_SELECT = 
			"SELECT * from (SELECT ROWNUM rn, CHECK_POINT, SERVICE, SUB_SERVICE, CPT_PROCESS_DATE, CPT_CONFIRMED, CPT_CONFIRMED_USER, CPT_CONFIRMATION_RAISED, CPT_CONFIRMED_TIME FROM CCCOWNER.CSO_CPT_CONFIRMATIONS ";
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
				return (List<CsoCptConfirmationsDTO>) results;
			} else {
				return null;
			}
		} catch (Exception ex) {
			throw new DAOException("Error retrieving related CCCOWNER.CSO_CPT_CONFIRMATIONS, cause: "
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
	public void update(CsoCptConfirmationsDTO bean) throws DAOException {
		PreparedStatement ps = null;
		int pos = 1;
		boolean first = true;

		try {
			SQL_UPDATE = 
			"UPDATE CCCOWNER.CSO_CPT_CONFIRMATIONS SET ";

	/* dynamic SQL for update */
		if (bean.getCheckPoint() != null && !bean.getCheckPoint().isEmpty()) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "CHECK_POINT=?";
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
		if (bean.getCptProcessDate() != null) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "CPT_PROCESS_DATE=?";
		}
		if (bean.getCptConfirmed() != null && !bean.getCptConfirmed().isEmpty()) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "CPT_CONFIRMED=?";
		}
		if (bean.getCptConfirmedUser() != null && !bean.getCptConfirmedUser().isEmpty()) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "CPT_CONFIRMED_USER=?";
		}
		if (bean.getCptConfirmationRaised() != null) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "CPT_CONFIRMATION_RAISED=?";
		}
		if (bean.getCptConfirmedTime() != null) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "CPT_CONFIRMED_TIME=?";
		}
			SQL_UPDATE += this.buildWhereClause(bean, false);
			//ps = conn.prepareStatement(SQL_UPDATE);


	/* dynamic update parameter */
			if (bean.getCheckPoint() != null && !bean.getCheckPoint().isEmpty()) {
				ps.setString(pos++, bean.getCheckPoint());
			}
			if (bean.getService() != null && !bean.getService().isEmpty()) {
				ps.setString(pos++, bean.getService());
			}
			if (bean.getSubService() != null && !bean.getSubService().isEmpty()) {
				ps.setString(pos++, bean.getSubService());
			}
			if (bean.getCptProcessDate() != null) {
				ps.setDate(pos++, new Date(bean.getCptProcessDate().getTime()));
			}
			if (bean.getCptConfirmed() != null && !bean.getCptConfirmed().isEmpty()) {
				ps.setString(pos++, bean.getCptConfirmed());
			}
			if (bean.getCptConfirmedUser() != null && !bean.getCptConfirmedUser().isEmpty()) {
				ps.setString(pos++, bean.getCptConfirmedUser());
			}
			if (bean.getCptConfirmationRaised() != null) {
				ps.setTimestamp(pos++, bean.getCptConfirmationRaised());
			}
			if (bean.getCptConfirmedTime() != null) {
				ps.setTimestamp(pos++, bean.getCptConfirmedTime());
			}
			pos = this.setParameters(bean, ps, pos, false);

			ps.executeUpdate();

		} catch (Exception ex) {
			throw new DAOException("Error updating CCCOWNER.CSO_CPT_CONFIRMATIONS, cause: "
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
	public void delete(CsoCptConfirmationsDTO bean) throws DAOException {
		PreparedStatement ps = null;
		//	throw new DAOException("Delete not supported - If you need this functionality uncomment code below and remove throw above");
			//TODO - *** update table to include unique keys and then remove commented code below and throw command above ***

		int pos = 1;

		try {
			SQL_DELETE = 
			"DELETE FROM CCCOWNER.CSO_CPT_CONFIRMATIONS";
			SQL_DELETE += this.buildWhereClause(bean, true);

			//ps = conn.prepareStatement(SQL_DELETE);

			pos = this.setParameters(bean, ps, pos, true);

			ps.executeUpdate();

		} catch (Exception ex) {
			throw new DAOException("Error deleting CCCOWNER.CSO_CPT_CONFIRMATIONS, cause: "
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
	public int retrieveRowCount(CsoCptConfirmationsDTO bean) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count=0;

		int pos = 1;

		try {
			SQL_SELECT_COUNT = 
			"SELECT COUNT(*) AS count FROM CCCOWNER.CSO_CPT_CONFIRMATIONS ";
			SQL_SELECT_COUNT += this.buildWhereClause(bean, true);

			//ps = conn.prepareStatement(SQL_SELECT_COUNT);
			this.setParameters(bean, ps, pos, true);

			rs = ps.executeQuery();

			while (rs.next()) {
				count=rs.getInt("count");
			}
		} catch (Exception ex) {
			throw new DAOException("Error retrieving CCCOWNER.CSO_CPT_CONFIRMATIONS, cause: "
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
				CsoCptConfirmationsDTO bean = new CsoCptConfirmationsDTO();
				bean.setCheckPoint(rs.getString("CHECK_POINT"));
				bean.setService(rs.getString("SERVICE"));
				bean.setSubService(rs.getString("SUB_SERVICE"));
				bean.setCptProcessDate(rs.getDate("CPT_PROCESS_DATE"));
				bean.setCptConfirmed(rs.getString("CPT_CONFIRMED"));
				bean.setCptConfirmedUser(rs.getString("CPT_CONFIRMED_USER"));
				bean.setCptConfirmationRaised(rs.getTimestamp("CPT_CONFIRMATION_RAISED"));
				bean.setCptConfirmedTime(rs.getTimestamp("CPT_CONFIRMED_TIME"));
				results.add(bean);
			}
			return results;
		} catch (Exception ex) {
			throw new DAOException("Error getting results CCCOWNER.CSO_CPT_CONFIRMATIONS, cause: "
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
	private String buildWhereClause(CsoCptConfirmationsDTO bean, boolean select) throws DAOException {
		if(bean == null) {
			return "";
		}

		StringBuilder buff = new StringBuilder();
		boolean whereClause = false;

		if (bean.getCheckPoint() != null && !bean.getCheckPoint().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			 buff.append("c.CHECK_POINT=?");
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
			if (bean.getCptProcessDate() != null) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("c.CPT_PROCESS_DATE=?");
			}
			if (bean.getCptConfirmed() != null && !bean.getCptConfirmed().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("c.CPT_CONFIRMED=?");
			}
			if (bean.getCptConfirmedUser() != null && !bean.getCptConfirmedUser().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("c.CPT_CONFIRMED_USER=?");
			}
			if (bean.getCptConfirmationRaised() != null) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("c.CPT_CONFIRMATION_RAISED=?");
			}
			if (bean.getCptConfirmedTime() != null) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("c.CPT_CONFIRMED_TIME=?");
			}
		}
		if(!whereClause && select == false) {
			throw new DAOException("Cannot update delete all rows in CCCOWNER.CSO_CPT_CONFIRMATIONS");
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
	private int setParameters(CsoCptConfirmationsDTO bean, PreparedStatement ps, int pos, boolean select) throws DAOException {
		if(bean == null) {
			return 1;
		}
		try {
			if (bean.getCheckPoint() != null && !bean.getCheckPoint().isEmpty()) {
				ps.setString(pos++, bean.getCheckPoint());
			}
			if (bean.getService() != null && !bean.getService().isEmpty()) {
				ps.setString(pos++, bean.getService());
			}
			if (bean.getSubService() != null && !bean.getSubService().isEmpty()) {
				ps.setString(pos++, bean.getSubService());
			}
			if (select == true) {
				if (bean.getCptProcessDate() != null) {
					ps.setDate(pos++, new Date(bean.getCptProcessDate().getTime()));
				}
				if (bean.getCptConfirmed() != null && !bean.getCptConfirmed().isEmpty()) {
					ps.setString(pos++, bean.getCptConfirmed());
				}
				if (bean.getCptConfirmedUser() != null && !bean.getCptConfirmedUser().isEmpty()) {
					ps.setString(pos++, bean.getCptConfirmedUser());
				}
				if (bean.getCptConfirmationRaised() != null) {
					ps.setTimestamp(pos++, bean.getCptConfirmationRaised());
				}
				if (bean.getCptConfirmedTime() != null) {
					ps.setTimestamp(pos++, bean.getCptConfirmedTime());
				}
			}
			return pos;
		} catch (Exception ex) {
			throw new DAOException("Error getting results CCCOWNER.CSO_CPT_CONFIRMATIONS, cause: "
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
