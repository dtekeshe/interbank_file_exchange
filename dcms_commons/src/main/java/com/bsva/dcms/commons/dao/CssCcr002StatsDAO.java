package com.bsva.dcms.commons.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bsva.dcms.commons.dto.CssCcr002StatsDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
/**
* Data access object interface that defines the methods that must be supported
* by all data access objects.
*
* Created By BSVATools
*/

public class CssCcr002StatsDAO {
	private String SQL_INSERT = 			"";
	private String SQL_SELECT = 			"";
	private String SQL_UPDATE = 			"";
	private String SQL_DELETE = 			"";
	private String SQL_SELECT_COUNT = 			"";
	private Connection conn;

	public CssCcr002StatsDAO(Connection conn) {
		this.conn = conn;
}

	/**
	 * Create a new record in Database.
	 *
	 * @param bean The Object to be inserted.
	 * @exception SQLException if something is wrong.
	 */
	
	public void create(CssCcr002StatsDTO bean) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int pos = 1;

		try {
			SQL_INSERT = 
			"INSERT INTO CCCOWNER.CSS_CCR002_STATS (PROCESS_DATE, SERVICE, SUB_SERVICE, TARGET_BANK, OTHER_BANK, FEES_AS_ACQ, FEES_AS_ISS, NETT_FEES) VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";
			ps = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);

			ps.setDate(pos++, new Date(bean.getProcessDate().getTime()));
			ps.setString(pos++, bean.getService());
			ps.setString(pos++, bean.getSubService());
			ps.setInt(pos++, bean.getTargetBank());
			ps.setInt(pos++, bean.getOtherBank());
			ps.setDouble(pos++, bean.getFeesAsAcq());
			ps.setDouble(pos++, bean.getFeesAsIss());
			ps.setDouble(pos++, bean.getNettFees());
			ps.executeUpdate();

		    ps.execute();
	        ps.close();

		} catch (Exception ex) {
			throw new DAOException("Error creating CCCOWNER.CSS_CCR002_STATS, cause: "
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
	
	public CssCcr002StatsDTO retrieve(CssCcr002StatsDTO bean) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int pos = 1;

		try {
			SQL_SELECT = 
			"SELECT PROCESS_DATE, SERVICE, SUB_SERVICE, TARGET_BANK, OTHER_BANK, FEES_AS_ACQ, FEES_AS_ISS, NETT_FEES FROM CCCOWNER.CSS_CCR002_STATS ";
			SQL_SELECT += this.buildWhereClause(bean, true);

			ps = conn.prepareStatement(SQL_SELECT);
			this.setParameters(bean, ps, pos, true);

			rs = ps.executeQuery();

			List results = this.getResults(rs);
			if (results.size() > 0) {
				return (CssCcr002StatsDTO) results.get(0);
			} else {
				return null;
			}
		} catch (Exception ex) {
			throw new DAOException("Error retrieving CCCOWNER.CSS_CCR002_STATS, cause: "
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
	
	public List<CssCcr002StatsDTO> retrieveRelated(CssCcr002StatsDTO bean) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int pos = 1;

		try {
			SQL_SELECT = 
			"SELECT PROCESS_DATE, SERVICE, SUB_SERVICE, TARGET_BANK, OTHER_BANK, FEES_AS_ACQ, FEES_AS_ISS, NETT_FEES FROM CCCOWNER.CSS_CCR002_STATS ";
			SQL_SELECT += this.buildWhereClause(bean, true);

			ps = conn.prepareStatement(SQL_SELECT);
			this.setParameters(bean, ps, pos, true);

			rs = ps.executeQuery();

			List results = this.getResults(rs);
			if (results.size() > 0) {
				return (List<CssCcr002StatsDTO>) results;
			} else {
				return null;
			}
		} catch (Exception ex) {
			throw new DAOException("Error retrieving related CCCOWNER.CSS_CCR002_STATS, cause: "
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
	
	public void update(CssCcr002StatsDTO bean) throws DAOException {
		PreparedStatement ps = null;
		int pos = 1;
		boolean first = true;

		try {
			SQL_UPDATE = 
			"UPDATE CCCOWNER.CSS_CCR002_STATS SET ";

	/* dynamic SQL for update */
		if (bean.getProcessDate() != null) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "PROCESS_DATE=?";
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
		if (bean.getTargetBank() > 0) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "TARGET_BANK=?";
		}
		if (bean.getOtherBank() > 0) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "OTHER_BANK=?";
		}
		if (bean.getFeesAsAcq() > 0.0) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "FEES_AS_ACQ=?";
		}
		if (bean.getFeesAsIss() > 0.0) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "FEES_AS_ISS=?";
		}
		if (bean.getNettFees() > 0.0) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "NETT_FEES=?";
		}
			SQL_UPDATE += this.buildWhereClause(bean, false);
			ps = conn.prepareStatement(SQL_UPDATE);


	/* dynamic update parameter */
			if (bean.getProcessDate() != null) {
				ps.setDate(pos++, new Date(bean.getProcessDate().getTime()));
			}
			if (bean.getService() != null && !bean.getService().isEmpty()) {
				ps.setString(pos++, bean.getService());
			}
			if (bean.getSubService() != null && !bean.getSubService().isEmpty()) {
				ps.setString(pos++, bean.getSubService());
			}
			if (bean.getTargetBank() > 0) {
				ps.setInt(pos++, bean.getTargetBank());
			}
			if (bean.getOtherBank() > 0) {
				ps.setInt(pos++, bean.getOtherBank());
			}
			if (bean.getFeesAsAcq() > 0.0) {
				ps.setDouble(pos++, bean.getFeesAsAcq());
			}
			if (bean.getFeesAsIss() > 0.0) {
				ps.setDouble(pos++, bean.getFeesAsIss());
			}
			if (bean.getNettFees() > 0.0) {
				ps.setDouble(pos++, bean.getNettFees());
			}
			pos = this.setParameters(bean, ps, pos, false);

			ps.executeUpdate();

		} catch (Exception ex) {
			throw new DAOException("Error updating CCCOWNER.CSS_CCR002_STATS, cause: "
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
	
	public void delete(CssCcr002StatsDTO bean) throws DAOException {
		PreparedStatement ps = null;


		int pos = 1;

		try {
			SQL_DELETE = 
			"DELETE FROM CCCOWNER.CSS_CCR002_STATS";
			SQL_DELETE += this.buildWhereClause(bean, false);

			ps = conn.prepareStatement(SQL_DELETE);

			pos = this.setParameters(bean, ps, pos, false);

			ps.executeUpdate();

		} catch (Exception ex) {
			throw new DAOException("Error deleting CCCOWNER.CSS_CCR002_STATS, cause: "
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
	public int retrieveRowCount(CssCcr002StatsDTO bean) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count=0;

		int pos = 1;

		try {
			SQL_SELECT_COUNT = 
			"SELECT COUNT(*) AS count FROM CCCOWNER.CSS_CCR002_STATS ";
			SQL_SELECT_COUNT += this.buildWhereClause(bean, true);

			ps = conn.prepareStatement(SQL_SELECT_COUNT);
			this.setParameters(bean, ps, pos, true);

			rs = ps.executeQuery();

			while (rs.next()) {
				count=rs.getInt("count");
			}
		} catch (Exception ex) {
			throw new DAOException("Error retrieving CCCOWNER.CSS_CCR002_STATS, cause: "
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
				CssCcr002StatsDTO bean = new CssCcr002StatsDTO();
				bean.setProcessDate(rs.getDate("PROCESS_DATE"));
				bean.setService(rs.getString("SERVICE"));
				bean.setSubService(rs.getString("SUB_SERVICE"));
				bean.setTargetBank(rs.getInt("TARGET_BANK"));
				bean.setOtherBank(rs.getInt("OTHER_BANK"));
				bean.setFeesAsAcq(rs.getDouble("FEES_AS_ACQ"));
				bean.setFeesAsIss(rs.getDouble("FEES_AS_ISS"));
				bean.setNettFees(rs.getDouble("NETT_FEES"));
				results.add(bean);
			}
			return results;
		} catch (Exception ex) {
			throw new DAOException("Error getting results CCCOWNER.CSS_CCR002_STATS, cause: "
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
	private String buildWhereClause(CssCcr002StatsDTO bean, boolean select) throws DAOException {
		if(bean == null) {
			return "";
		}

		StringBuilder buff = new StringBuilder();
		boolean whereClause = false;

		if (bean.getProcessDate() != null) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			 buff.append("PROCESS_DATE=?");
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
		if (select == true) {
			if (bean.getTargetBank() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("TARGET_BANK=?");
			}
			if (bean.getOtherBank() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("OTHER_BANK=?");
			}
			if (bean.getFeesAsAcq() > 0.0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("FEES_AS_ACQ=?");
			}
			if (bean.getFeesAsIss() > 0.0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("FEES_AS_ISS=?");
			}
			if (bean.getNettFees() > 0.0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("NETT_FEES=?");
			}
		}
		if(!whereClause && select == false) {
			throw new DAOException("Cannot update delete all rows in CCCOWNER.CSS_CCR002_STATS");
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
	private int setParameters(CssCcr002StatsDTO bean, PreparedStatement ps, int pos, boolean select) throws DAOException {
		if(bean == null) {
			return 1;
		}
		try {
			if (bean.getProcessDate() != null) {
				ps.setDate(pos++, new Date(bean.getProcessDate().getTime()));
			}
			if (bean.getService() != null && !bean.getService().isEmpty()) {
				ps.setString(pos++, bean.getService());
			}
			if (bean.getSubService() != null && !bean.getSubService().isEmpty()) {
				ps.setString(pos++, bean.getSubService());
			}
			if (select == true) {
				if (bean.getTargetBank() > 0) {
					ps.setInt(pos++, bean.getTargetBank());
				}
				if (bean.getOtherBank() > 0) {
					ps.setInt(pos++, bean.getOtherBank());
				}
				if (bean.getFeesAsAcq() > 0.0) {
					ps.setDouble(pos++, bean.getFeesAsAcq());
				}
				if (bean.getFeesAsIss() > 0.0) {
					ps.setDouble(pos++, bean.getFeesAsIss());
				}
				if (bean.getNettFees() > 0.0) {
					ps.setDouble(pos++, bean.getNettFees());
				}
			}
			return pos;
		} catch (Exception ex) {
			throw new DAOException("Error getting results CCCOWNER.CSS_CCR002_STATS, cause: "
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
