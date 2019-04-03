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

import com.bsva.dcms.commons.dto.CsoCoreProcessesDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
/**
* Data access object interface that defines the methods that must be supported
* by all data access objects.
*
* Created By BSVATools
*/

public class CsoCoreProcessesDAO {
	private String SQL_INSERT = 			"";
	private String SQL_SELECT = 			"";
	private String SQL_UPDATE = 			"";
	private String SQL_DELETE = 			"";
	private String SQL_SELECT_COUNT = 			"";
	private DataSource conn;

	public CsoCoreProcessesDAO(DataSource conn) {
		this.conn = conn;
}

	/**
	 * Create a new record in Database.
	 *
	 * @param bean The Object to be inserted.
	 * @exception SQLException if something is wrong.
	 */
	public void create(CsoCoreProcessesDTO bean) throws DAOException {
		PreparedStatement ps = null;
		int pos = 1;

		try {
			SQL_INSERT = 
			"INSERT INTO CCCOWNER.CSO_CORE_PROCESSES (PROGRAM_NAME, TIME_INTERVAL, NO_OF_INSTANCE_SET, NO_OF_INSTANCE_ACTIVE, ACTIVE_IND, SEQUENCE_NUMBER, PROGRAM_ALIAS) VALUES (?, ?, ?, ?, ?, ?, ?) ";
			//ps = conn.prepareStatement(SQL_INSERT);

			ps.setString(pos++, bean.getProgramName());
			ps.setInt(pos++, bean.getTimeInterval());
			ps.setInt(pos++, bean.getNoOfInstanceSet());
			ps.setInt(pos++, bean.getNoOfInstanceActive());
			ps.setString(pos++, bean.getActiveInd());
			ps.setInt(pos++, bean.getSequenceNumber());
			ps.setString(pos++, bean.getProgramAlias());
			
			ps.execute();

		} catch (Exception ex) {
			throw new DAOException("Error creating CCCOWNER.CSO_CORE_PROCESSES, cause: "
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
	public CsoCoreProcessesDTO retrieve(CsoCoreProcessesDTO bean) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int pos = 1;

		try {
			SQL_SELECT = 
			"SELECT PROGRAM_NAME, TIME_INTERVAL, NO_OF_INSTANCE_SET, NO_OF_INSTANCE_ACTIVE, ACTIVE_IND, SEQUENCE_NUMBER, PROGRAM_ALIAS FROM CCCOWNER.CSO_CORE_PROCESSES ";
			SQL_SELECT += this.buildWhereClause(bean, true);

			//ps = conn.prepareStatement(SQL_SELECT);
			this.setParameters(bean, ps, pos, true);

			rs = ps.executeQuery();

			List results = this.getResults(rs);
			if (results.size() > 0) {
				return (CsoCoreProcessesDTO) results.get(0);
			} else {
				return null;
			}
		} catch (Exception ex) {
			throw new DAOException("Error retrieving CCCOWNER.CSO_CORE_PROCESSES, cause: "
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
	public List<CsoCoreProcessesDTO> retrieveRelated(CsoCoreProcessesDTO bean) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int pos = 1;

		try {
			SQL_SELECT = 
			"SELECT PROGRAM_NAME, TIME_INTERVAL, NO_OF_INSTANCE_SET, NO_OF_INSTANCE_ACTIVE, ACTIVE_IND, SEQUENCE_NUMBER, PROGRAM_ALIAS FROM CCCOWNER.CSO_CORE_PROCESSES ";
			SQL_SELECT += this.buildWhereClause(bean, true);

			//ps = conn.prepareStatement(SQL_SELECT);
			this.setParameters(bean, ps, pos, true);

			rs = ps.executeQuery();

			List results = this.getResults(rs);
			if (results.size() > 0) {
				return (List<CsoCoreProcessesDTO>) results;
			} else {
				return null;
			}
		} catch (Exception ex) {
			throw new DAOException("Error retrieving related CCCOWNER.CSO_CORE_PROCESSES, cause: "
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
	public List<CsoCoreProcessesDTO> retrieveRelated(CsoCoreProcessesDTO bean, int startRow, int endRow) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int pos = 1;

		try {
	// Oracle specific 
			SQL_SELECT = 
			"SELECT * from (SELECT ROWNUM rn, PROGRAM_NAME, TIME_INTERVAL, NO_OF_INSTANCE_SET, NO_OF_INSTANCE_ACTIVE, ACTIVE_IND, SEQUENCE_NUMBER, PROGRAM_ALIAS FROM CCCOWNER.CSO_CORE_PROCESSES ";
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
				return (List<CsoCoreProcessesDTO>) results;
			} else {
				return null;
			}
		} catch (Exception ex) {
			throw new DAOException("Error retrieving related CCCOWNER.CSO_CORE_PROCESSES, cause: "
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
	public void update(CsoCoreProcessesDTO bean) throws DAOException {
		PreparedStatement ps = null;
	//		throw new DAOException("Update not supported - No unique or primary keys defined");
			//TODO - *** update table to include unique keys and then remove commented code below and throw command above ***

		int pos = 1;
		boolean first = true;

		try {
			SQL_UPDATE = 
			"UPDATE CCCOWNER.CSO_CORE_PROCESSES SET "; 

	/* dynamic SQL for update */
		if (bean.getProgramName() != null && !bean.getProgramName().isEmpty()) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "PROGRAM_NAME=?";
		}
		if (bean.getTimeInterval() > 0) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "TIME_INTERVAL=?";
		}
		if (bean.getNoOfInstanceSet() > 0) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "NO_OF_INSTANCE_SET=?";
		}
		if (bean.getNoOfInstanceActive() > 0) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "NO_OF_INSTANCE_ACTIVE=?";
		}
		if (bean.getActiveInd() != null && !bean.getActiveInd().isEmpty()) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "ACTIVE_IND=?";
		}
		if (bean.getSequenceNumber() > 0) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "SEQUENCE_NUMBER=?";
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
		//	SQL_UPDATE += this.buildWhereClause(bean, false);
			//ps = conn.prepareStatement(SQL_UPDATE);


	/* dynamic update parameter */
			if (bean.getProgramName() != null && !bean.getProgramName().isEmpty()) {
				ps.setString(pos++, bean.getProgramName());
			}
			if (bean.getTimeInterval() > 0) {
				ps.setInt(pos++, bean.getTimeInterval());
			}
			if (bean.getNoOfInstanceSet() > 0) {
				ps.setInt(pos++, bean.getNoOfInstanceSet());
			}
			if (bean.getNoOfInstanceActive() > 0) {
				ps.setInt(pos++, bean.getNoOfInstanceActive());
			}
			if (bean.getActiveInd() != null && !bean.getActiveInd().isEmpty()) {
				ps.setString(pos++, bean.getActiveInd());
			}
			if (bean.getSequenceNumber() > 0) {
				ps.setInt(pos++, bean.getSequenceNumber());
			}
			if (bean.getProgramAlias() != null && !bean.getProgramAlias().isEmpty()) {
				ps.setString(pos++, bean.getProgramAlias());
			}
	//		pos = this.setParameters(bean, ps, pos, false);

			ps.executeUpdate();

		} catch (Exception ex) {
			throw new DAOException("Error updating CCCOWNER.CSO_CORE_PROCESSES, cause: "
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
	public void delete(CsoCoreProcessesDTO bean) throws DAOException {
		PreparedStatement ps = null;
			//throw new DAOException("0999", "Delete not supported - If you need this functionality uncomment code below and remove throw above");
			//TODO - *** update table to include unique keys and then remove commented code below and throw command above ***

		int pos = 1;

		try {
			SQL_DELETE = 
			"DELETE FROM CCCOWNER.CSO_CORE_PROCESSES";
			SQL_DELETE += this.buildWhereClause(bean, true);

			//ps = conn.prepareStatement(SQL_DELETE);

			pos = this.setParameters(bean, ps, pos, true);

			ps.executeUpdate();

		} catch (Exception ex) {
			throw new DAOException("Error deleting CCCOWNER.CSO_CORE_PROCESSES, cause: "
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
	public int retrieveRowCount(CsoCoreProcessesDTO bean) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count=0;

		int pos = 1;

		try {
			SQL_SELECT_COUNT = 
			"SELECT COUNT(*) AS count FROM CCCOWNER.CSO_CORE_PROCESSES ";
			SQL_SELECT_COUNT += this.buildWhereClause(bean, true);

			//ps = conn.prepareStatement(SQL_SELECT_COUNT);
			this.setParameters(bean, ps, pos, true);

			rs = ps.executeQuery();

			while (rs.next()) {
				count=rs.getInt("count");
			}
		} catch (Exception ex) {
			throw new DAOException("Error retrieving CCCOWNER.CSO_CORE_PROCESSES, cause: "
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
				CsoCoreProcessesDTO bean = new CsoCoreProcessesDTO();
				bean.setProgramName(rs.getString("PROGRAM_NAME"));
				bean.setTimeInterval(rs.getInt("TIME_INTERVAL"));
				bean.setNoOfInstanceSet(rs.getInt("NO_OF_INSTANCE_SET"));
				bean.setNoOfInstanceActive(rs.getInt("NO_OF_INSTANCE_ACTIVE"));
				bean.setActiveInd(rs.getString("ACTIVE_IND"));
				bean.setSequenceNumber(rs.getInt("SEQUENCE_NUMBER"));
				bean.setProgramAlias(rs.getString("PROGRAM_ALIAS"));
				results.add(bean);
			}
			return results;
		} catch (Exception ex) {
			throw new DAOException("Error getting results CCCOWNER.CSO_CORE_PROCESSES, cause: "
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
	private String buildWhereClause(CsoCoreProcessesDTO bean, boolean select) throws DAOException {
		if(bean == null) {
			return "";
		}

		StringBuilder buff = new StringBuilder();
		boolean whereClause = false;

		if (select == true) {
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
			if (bean.getTimeInterval() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("c.TIME_INTERVAL=?");
			}
			if (bean.getNoOfInstanceSet() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("c.NO_OF_INSTANCE_SET=?");
			}
			if (bean.getNoOfInstanceActive() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("c.NO_OF_INSTANCE_ACTIVE=?");
			}
			if (bean.getActiveInd() != null && !bean.getActiveInd().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("c.ACTIVE_IND=?");
			}
			if (bean.getSequenceNumber() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("c.SEQUENCE_NUMBER=?");
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
		}
		if(!whereClause && select == false) {
			throw new DAOException("Cannot update delete all rows in CCCOWNER.CSO_CORE_PROCESSES");
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
	private int setParameters(CsoCoreProcessesDTO bean, PreparedStatement ps, int pos, boolean select) throws DAOException {
		if(bean == null) {
			return 1;
		}
		try {
			if (select == true) {
				if (bean.getProgramName() != null && !bean.getProgramName().isEmpty()) {
					ps.setString(pos++, bean.getProgramName());
				}
				if (bean.getTimeInterval() > 0) {
					ps.setInt(pos++, bean.getTimeInterval());
				}
				if (bean.getNoOfInstanceSet() > 0) {
					ps.setInt(pos++, bean.getNoOfInstanceSet());
				}
				if (bean.getNoOfInstanceActive() > 0) {
					ps.setInt(pos++, bean.getNoOfInstanceActive());
				}
				if (bean.getActiveInd() != null && !bean.getActiveInd().isEmpty()) {
					ps.setString(pos++, bean.getActiveInd());
				}
				if (bean.getSequenceNumber() > 0) {
					ps.setInt(pos++, bean.getSequenceNumber());
				}
				if (bean.getProgramAlias() != null && !bean.getProgramAlias().isEmpty()) {
					ps.setString(pos++, bean.getProgramAlias());
				}
			}
			return pos;
		} catch (Exception ex) {
			throw new DAOException("Error getting results CCCOWNER.CSO_CORE_PROCESSES, cause: "
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
