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

import com.bsva.dcms.commons.dto.CsoBatchProcessesDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
/**
* Data access object interface that defines the methods that must be supported
* by all data access objects.
*
* Created By BSVATools
*/

public class CsoBatchProcessesDAO{
	private String SQL_INSERT = 			"";
	private String SQL_SELECT = 			"";
	private String SQL_UPDATE = 			"";
	private String SQL_DELETE = 			"";
	private String SQL_SELECT_COUNT = 			"";
	private DataSource conn;

	public CsoBatchProcessesDAO(DataSource conn) {
		this.conn = conn;
}

	/**
	 * Create a new record in Database.
	 *
	 * @param bean The Object to be inserted.
	 * @exception SQLException if something is wrong.
	 */
	
	public void create(CsoBatchProcessesDTO bean) throws DAOException {
		PreparedStatement ps = null;
		int pos = 1;

		try {
			SQL_INSERT = 
			"INSERT INTO CCCOWNER.CSO_BATCH_PROCESSES (RUN_ORDER, PROGRAM_NAME, COMPLETED, MONTH_END_ONLY, PROGRAM_ALIAS, INTERFACE, ACTIVE) VALUES (?, ?, ?, ?, ?, ?, ?) ";
			//ps = conn.prepareStatement(SQL_INSERT);

			ps.setInt(pos++, bean.getRunOrder());
			ps.setString(pos++, bean.getProgramName());
			ps.setString(pos++, bean.getCompleted());
			ps.setString(pos++, bean.getMonthEndOnly());
			ps.setString(pos++, bean.getProgramAlias());
			ps.setString(pos++, bean.getAInterface());
			ps.setString(pos++, bean.getActive());
			
			ps.execute();

		} catch (Exception ex) {
			throw new DAOException("Error creating CCCOWNER.CSO_BATCH_PROCESSES, cause: "
					+ ex.getMessage(), ex);
		} finally {
			close(ps);
		}
	}
	/**
	 * Retrieve a record from Database.
	 *
	 * @param bean The Object to be retrieved.
	 * @exception SQLException if something is wrong.
	 */
	
	public CsoBatchProcessesDTO retrieve(CsoBatchProcessesDTO bean) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int pos = 1;

		try {
			SQL_SELECT = 
			"SELECT RUN_ORDER, PROGRAM_NAME, COMPLETED, MONTH_END_ONLY, PROGRAM_ALIAS, INTERFACE, ACTIVE FROM CCCOWNER.CSO_BATCH_PROCESSES ";
			SQL_SELECT += this.buildWhereClause(bean, true);

			//ps = conn.prepareStatement(SQL_SELECT);
			this.setParameters(bean, ps, pos, true);

			rs = ps.executeQuery();

			List results = this.getResults(rs);
			if (results.size() > 0) {
				return (CsoBatchProcessesDTO) results.get(0);
			} else {
				return null;
			}
		} catch (Exception ex) {
			throw new DAOException("Error retrieving CCCOWNER.CSO_BATCH_PROCESSES, cause: "
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
	
	public List<CsoBatchProcessesDTO> retrieveRelated(CsoBatchProcessesDTO bean) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int pos = 1;

		try {
			SQL_SELECT = 
			"SELECT RUN_ORDER, PROGRAM_NAME, COMPLETED, MONTH_END_ONLY, PROGRAM_ALIAS, INTERFACE, ACTIVE FROM CCCOWNER.CSO_BATCH_PROCESSES ";
			SQL_SELECT += this.buildWhereClause(bean, true);

			//ps = conn.prepareStatement(SQL_SELECT);
			this.setParameters(bean, ps, pos, true);

			rs = ps.executeQuery();

			List results = this.getResults(rs);
			if (results.size() > 0) {
				return (List<CsoBatchProcessesDTO>) results;
			} else {
				return null;
			}
		} catch (Exception ex) {
			throw new DAOException("Error retrieving related CCCOWNER.CSO_BATCH_PROCESSES, cause: "
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
	public List<CsoBatchProcessesDTO> retrieveRelated(CsoBatchProcessesDTO bean, int startRow, int endRow) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int pos = 1;

		try {
	// Oracle specific 
			SQL_SELECT = 
			"SELECT * from (SELECT ROWNUM rn, RUN_ORDER, PROGRAM_NAME, COMPLETED, MONTH_END_ONLY, PROGRAM_ALIAS, INTERFACE, ACTIVE FROM CCCOWNER.CSO_BATCH_PROCESSES ";
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
				return (List<CsoBatchProcessesDTO>) results;
			} else {
				return null;
			}
		} catch (Exception ex) {
			throw new DAOException("Error retrieving related CCCOWNER.CSO_BATCH_PROCESSES, cause: "
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
	
	public void update(CsoBatchProcessesDTO bean) throws DAOException {
		PreparedStatement ps = null;


		int pos = 1;
		boolean first = true;

		try {
			SQL_UPDATE = 
			"UPDATE CCCOWNER.CSO_BATCH_PROCESSES SET ";

	/* dynamic SQL for update */
		if (bean.getRunOrder() > 0) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "RUN_ORDER=?";
		}
		if (bean.getProgramName() != null && !bean.getProgramName().isEmpty()) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "PROGRAM_NAME=?";
		}
		if (bean.getCompleted() != null && !bean.getCompleted().isEmpty()) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "COMPLETED=?";
		}
		if (bean.getMonthEndOnly() != null && !bean.getMonthEndOnly().isEmpty()) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "MONTH_END_ONLY=?";
		}
		if (bean.getProgramAlias() != null && !bean.getProgramAlias().isEmpty()) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "PROGRAM_ALIAS=?";
		}
		if (bean.getAInterface() != null && !bean.getAInterface().isEmpty()) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "INTERFACE=?";
		}
		if (bean.getActive() != null && !bean.getActive().isEmpty()) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "ACTIVE=?";
		}
		//	SQL_UPDATE += this.buildWhereClause(bean, false);
			//ps = conn.prepareStatement(SQL_UPDATE);


	/* dynamic update parameter */
			if (bean.getRunOrder() > 0) {
				ps.setInt(pos++, bean.getRunOrder());
			}
			if (bean.getProgramName() != null && !bean.getProgramName().isEmpty()) {
				ps.setString(pos++, bean.getProgramName());
			}
			if (bean.getCompleted() != null && !bean.getCompleted().isEmpty()) {
				ps.setString(pos++, bean.getCompleted());
			}
			if (bean.getMonthEndOnly() != null && !bean.getMonthEndOnly().isEmpty()) {
				ps.setString(pos++, bean.getMonthEndOnly());
			}
			if (bean.getProgramAlias() != null && !bean.getProgramAlias().isEmpty()) {
				ps.setString(pos++, bean.getProgramAlias());
			}
			if (bean.getAInterface() != null && !bean.getAInterface().isEmpty()) {
				ps.setString(pos++, bean.getAInterface());
			}
			if (bean.getActive() != null && !bean.getActive().isEmpty()) {
				ps.setString(pos++, bean.getActive());
			}
	//		pos = this.setParameters(bean, ps, pos, false);

			ps.executeUpdate();

		} catch (Exception ex) {
			throw new DAOException("Error updating CCCOWNER.CSO_BATCH_PROCESSES, cause: "
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
	
	public void delete(CsoBatchProcessesDTO bean) throws DAOException {
		PreparedStatement ps = null;
			throw new DAOException("Delete not supported - If you need this functionality uncomment code below and remove throw above");
			//TODO - *** update table to include unique keys and then remove commented code below and throw command above ***
/*
		int pos = 1;

		try {
			SQL_DELETE = 
			"DELETE FROM CCCOWNER.CSO_BATCH_PROCESSES";
			SQL_DELETE += this.buildWhereClause(bean, false);

			ps = conn.prepareStatement(SQL_DELETE);

			pos = this.setParameters(bean, ps, pos, false);

			ps.executeUpdate();

		} catch (Exception ex) {
			throw new DAOException( "Error deleting CCCOWNER.CSO_BATCH_PROCESSES, cause: "
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
				CsoBatchProcessesDTO bean = new CsoBatchProcessesDTO();
				bean.setRunOrder(rs.getInt("RUN_ORDER"));
				bean.setProgramName(rs.getString("PROGRAM_NAME"));
				bean.setCompleted(rs.getString("COMPLETED"));
				bean.setMonthEndOnly(rs.getString("MONTH_END_ONLY"));
				bean.setProgramAlias(rs.getString("PROGRAM_ALIAS"));
//				bean.setInterface(rs.getString("INTERFACE"));
				bean.setActive(rs.getString("ACTIVE"));
				results.add(bean);
			}
			return results;
		} catch (Exception ex) {
			throw new DAOException("Error getting results CCCOWNER.CSO_BATCH_PROCESSES, cause: "
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
	private String buildWhereClause(CsoBatchProcessesDTO bean, boolean select) throws DAOException {
		if(bean == null) {
			return "";
		}

		StringBuilder buff = new StringBuilder();
		boolean whereClause = false;

		if (select == true) {
			if (bean.getRunOrder() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("c.RUN_ORDER=?");
			}
			if (bean.getProgramName() != null && !bean.getProgramName().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("c.PROGRAM_NAME=?");
			}
			if (bean.getCompleted() != null && !bean.getCompleted().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("c.COMPLETED=?");
			}
			if (bean.getMonthEndOnly() != null && !bean.getMonthEndOnly().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("c.MONTH_END_ONLY=?");
			}
			if (bean.getProgramAlias() != null && !bean.getProgramAlias().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("c.PROGRAM_ALIAS=?");
			}
			if (bean.getAInterface() != null && !bean.getAInterface().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("c.INTERFACE=?");
			}
			if (bean.getActive() != null && !bean.getActive().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("c.ACTIVE=?");
			}
		}
		if(!whereClause && select == false) {
			throw new DAOException("Cannot update delete all rows in CCCOWNER.CSO_BATCH_PROCESSES");
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
	private int setParameters(CsoBatchProcessesDTO bean, PreparedStatement ps, int pos, boolean select) throws DAOException {
		if(bean == null) {
			return 1;
		}
		try {
			if (select == true) {
				if (bean.getRunOrder() > 0) {
					ps.setInt(pos++, bean.getRunOrder());
				}
				if (bean.getProgramName() != null && !bean.getProgramName().isEmpty()) {
					ps.setString(pos++, bean.getProgramName());
				}
				if (bean.getCompleted() != null && !bean.getCompleted().isEmpty()) {
					ps.setString(pos++, bean.getCompleted());
				}
				if (bean.getMonthEndOnly() != null && !bean.getMonthEndOnly().isEmpty()) {
					ps.setString(pos++, bean.getMonthEndOnly());
				}
				if (bean.getProgramAlias() != null && !bean.getProgramAlias().isEmpty()) {
					ps.setString(pos++, bean.getProgramAlias());
				}
				if (bean.getAInterface() != null && !bean.getAInterface().isEmpty()) {
					ps.setString(pos++, bean.getAInterface());
				}
				if (bean.getActive() != null && !bean.getActive().isEmpty()) {
					ps.setString(pos++, bean.getActive());
				}
			}
			return pos;
		} catch (Exception ex) {
			throw new DAOException("Error getting results CCCOWNER.CSO_BATCH_PROCESSES, cause: "
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
