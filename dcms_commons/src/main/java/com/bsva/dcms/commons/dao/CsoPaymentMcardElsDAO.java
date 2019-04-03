package com.bsva.dcms.commons.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bsva.dcms.commons.dto.CsoPaymentMcardElsDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
/**
* Data access object interface that defines the methods that must be supported
* by all data access objects.
*
* Created By BSVATools
*/

public class CsoPaymentMcardElsDAO{
	private String SQL_INSERT = 			"";
	private String SQL_SELECT = 			"";
	private String SQL_UPDATE = 			"";
	private String SQL_DELETE = 			"";
	private String SQL_SELECT_COUNT = 			"";

	public CsoPaymentMcardElsDAO(Connection conn) {
		//this.conn = conn;
}

	/**
	 * Create a new record in Database.
	 *
	 * @param bean The Object to be inserted.
	 * @exception SQLException if something is wrong.
	 */
	public CsoPaymentMcardElsDTO create(CsoPaymentMcardElsDTO bean) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int pos = 1;

		try {
			SQL_INSERT = 
			"INSERT INTO CCCOWNER.CSO_PAYMENT_MCARD_ELS (SYSTEM_SEQ_NUMBER, DATA_EL_NO, DATA_EL_TYPE, DATA_EL_LENGTH, DATA_EL_DATA) VALUES (?, ?, ?, ?, ?) ";
			//ps = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);

			ps.setLong(pos++, bean.getSystemSeqNumber());
			ps.setString(pos++, bean.getDataElNo());
			ps.setInt(pos++, bean.getDataElType());
			ps.setInt(pos++, bean.getDataElLength());
			ps.setBytes(pos++, bean.getDataElData());
			ps.executeUpdate();

			rs = ps.getGeneratedKeys();

			if (rs.next()) {
			}

			return bean;
		} catch (Exception ex) {
			throw new DAOException("Error creating CCCOWNER.CSO_PAYMENT_MCARD_ELS, cause: "
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
	
	public CsoPaymentMcardElsDTO retrieve(CsoPaymentMcardElsDTO bean) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int pos = 1;

		try {
			SQL_SELECT = 
			"SELECT SYSTEM_SEQ_NUMBER, DATA_EL_NO, DATA_EL_TYPE, DATA_EL_LENGTH, DATA_EL_DATA FROM CCCOWNER.CSO_PAYMENT_MCARD_ELS ";
			SQL_SELECT += this.buildWhereClause(bean, true);

			//ps = conn.prepareStatement(SQL_SELECT);
			this.setParameters(bean, ps, pos, true);

			rs = ps.executeQuery();

			List results = this.getResults(rs);
			if (results.size() > 0) {
				return (CsoPaymentMcardElsDTO) results.get(0);
			} else {
				return null;
			}
		} catch (Exception ex) {
			throw new DAOException("Error retrieving CCCOWNER.CSO_PAYMENT_MCARD_ELS, cause: "
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
	
	public List<CsoPaymentMcardElsDTO> retrieveRelated(CsoPaymentMcardElsDTO bean) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int pos = 1;

		try {
			SQL_SELECT = 
			"SELECT SYSTEM_SEQ_NUMBER, DATA_EL_NO, DATA_EL_TYPE, DATA_EL_LENGTH, DATA_EL_DATA FROM CCCOWNER.CSO_PAYMENT_MCARD_ELS ";
			SQL_SELECT += this.buildWhereClause(bean, true);

			//ps = conn.prepareStatement(SQL_SELECT);
			this.setParameters(bean, ps, pos, true);

			rs = ps.executeQuery();

			List results = this.getResults(rs);
			if (results.size() > 0) {
				return (List<CsoPaymentMcardElsDTO>) results;
			} else {
				return null;
			}
		} catch (Exception ex) {
			throw new DAOException("Error retrieving related CCCOWNER.CSO_PAYMENT_MCARD_ELS, cause: "
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
	
	public void update(CsoPaymentMcardElsDTO bean) throws DAOException {
		PreparedStatement ps = null;
		int pos = 1;
		boolean first = true;

		try {
			SQL_UPDATE = 
			"UPDATE CCCOWNER.CSO_PAYMENT_MCARD_ELS SET ";

	/* dynamic SQL for update */
		if (bean.getSystemSeqNumber() > 0L) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "SYSTEM_SEQ_NUMBER=?";
		}
		if (bean.getDataElNo() != null && !bean.getDataElNo().isEmpty()) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "DATA_EL_NO=?";
		}
		if (bean.getDataElType() > 0) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "DATA_EL_TYPE=?";
		}
		if (bean.getDataElLength() > 0) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "DATA_EL_LENGTH=?";
		}
		if (bean.getDataElData() != null) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "DATA_EL_DATA=?";
		}
			SQL_UPDATE += this.buildWhereClause(bean, false);
			//ps = conn.prepareStatement(SQL_UPDATE);


	/* dynamic update parameter */
			if (bean.getSystemSeqNumber() > 0L) {
				ps.setLong(pos++, bean.getSystemSeqNumber());
			}
			if (bean.getDataElNo() != null && !bean.getDataElNo().isEmpty()) {
				ps.setString(pos++, bean.getDataElNo());
			}
			if (bean.getDataElType() > 0) {
				ps.setInt(pos++, bean.getDataElType());
			}
			if (bean.getDataElLength() > 0) {
				ps.setInt(pos++, bean.getDataElLength());
			}
			if (bean.getDataElData() != null) {
				ps.setBytes(pos++, bean.getDataElData());
			}
			pos = this.setParameters(bean, ps, pos, false);

			ps.executeUpdate();

		} catch (Exception ex) {
			throw new DAOException("Error updating CCCOWNER.CSO_PAYMENT_MCARD_ELS, cause: "
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
	
	public void delete(CsoPaymentMcardElsDTO bean) throws DAOException {
		PreparedStatement ps = null;
			throw new DAOException("Delete not supported - If you need this functionality uncomment code below and remove throw above");
			//TODO - *** update table to include unique keys and then remove commented code below and throw command above ***
/*
		int pos = 1;

		try {
			SQL_DELETE = 
			"DELETE FROM CCCOWNER.CSO_PAYMENT_MCARD_ELS";
			SQL_DELETE += this.buildWhereClause(bean, false);

			ps = conn.prepareStatement(SQL_DELETE);

			pos = this.setParameters(bean, ps, pos, false);

			ps.executeUpdate();

		} catch (Exception ex) {
			throw new DAOException("0901", "Error deleting CCCOWNER.CSO_PAYMENT_MCARD_ELS, cause: "
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
	public int retrieveRowCount(CsoPaymentMcardElsDTO bean) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count=0;

		int pos = 1;

		try {
			SQL_SELECT_COUNT = 
			"SELECT COUNT(*) AS count FROM CCCOWNER.CSO_PAYMENT_MCARD_ELS ";
			SQL_SELECT_COUNT += this.buildWhereClause(bean, true);

			//ps = conn.prepareStatement(SQL_SELECT_COUNT);
			this.setParameters(bean, ps, pos, true);

			rs = ps.executeQuery();

			while (rs.next()) {
				count=rs.getInt("count");
			}
		} catch (Exception ex) {
			throw new DAOException("Error retrieving CCCOWNER.CSO_PAYMENT_MCARD_ELS, cause: "
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
				CsoPaymentMcardElsDTO bean = new CsoPaymentMcardElsDTO();
				bean.setSystemSeqNumber(rs.getLong("SYSTEM_SEQ_NUMBER"));
				bean.setDataElNo(rs.getString("DATA_EL_NO"));
				bean.setDataElType(rs.getInt("DATA_EL_TYPE"));
				bean.setDataElLength(rs.getInt("DATA_EL_LENGTH"));
				bean.setDataElData(rs.getBytes("DATA_EL_DATA"));
				results.add(bean);
			}
			return results;
		} catch (Exception ex) {
			throw new DAOException("Error getting results CCCOWNER.CSO_PAYMENT_MCARD_ELS, cause: "
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
	private String buildWhereClause(CsoPaymentMcardElsDTO bean, boolean select) throws DAOException {
		if(bean == null) {
			return "";
		}

		StringBuilder buff = new StringBuilder();
		boolean whereClause = false;

		if (bean.getSystemSeqNumber() > 0L) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			 buff.append("c.SYSTEM_SEQ_NUMBER=?");
		}
		if (bean.getDataElNo() != null && !bean.getDataElNo().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			 buff.append("c.DATA_EL_NO=?");
		}
		if (select == true) {
			if (bean.getDataElType() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("c.DATA_EL_TYPE=?");
			}
			if (bean.getDataElLength() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("c.DATA_EL_LENGTH=?");
			}
			if (bean.getDataElData() != null) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("c.DATA_EL_DATA=?");
			}
		}
		if(!whereClause && select == false) {
			throw new DAOException("Cannot update delete all rows in CCCOWNER.CSO_PAYMENT_MCARD_ELS");
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
	private int setParameters(CsoPaymentMcardElsDTO bean, PreparedStatement ps, int pos, boolean select) throws DAOException {
		if(bean == null) {
			return 1;
		}
		try {
			if (bean.getSystemSeqNumber() > 0L) {
				ps.setLong(pos++, bean.getSystemSeqNumber());
			}
			if (bean.getDataElNo() != null && !bean.getDataElNo().isEmpty()) {
				ps.setString(pos++, bean.getDataElNo());
			}
			if (select == true) {
				if (bean.getDataElType() > 0) {
					ps.setInt(pos++, bean.getDataElType());
				}
				if (bean.getDataElLength() > 0) {
					ps.setInt(pos++, bean.getDataElLength());
				}
				if (bean.getDataElData() != null) {
					ps.setBytes(pos++, bean.getDataElData());
				}
			}
			return pos;
		} catch (Exception ex) {
			throw new DAOException("Error getting results CCCOWNER.CSO_PAYMENT_MCARD_ELS, cause: "
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
