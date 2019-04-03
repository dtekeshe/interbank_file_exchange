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

import com.bsva.dcms.commons.dto.CsoEndOfServiceControlsDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
/**
* Data access object interface that defines the methods that must be supported
* by all data access objects.
*
* Created By BSVATools
*/

public class CsoEndOfServiceControlsDAO {

	private DataSource conn;

	public CsoEndOfServiceControlsDAO(DataSource conn) {
		this.conn = conn;
}

	/**
	 * Create a new record in Database.
	 *
	 * @param bean The Object to be inserted.
	 * @exception SQLException if something is wrong.
	 */
	public void create(CsoEndOfServiceControlsDTO bean) throws DAOException {
		PreparedStatement ps = null;
		int pos = 1;
		try {
			String sql = 
			"INSERT INTO CCCOWNER.CSO_END_OF_SERVICE_CONTROLS (FILE_REF_NUMBER, RECORD_ID, OUTPUT_DATE, SERVICE, SUB_SERVICE, NUMBER_OF_FILES, NUMBER_CREDITS, NUMBER_DEBITS, CREDIT_VALUE, DEBIT_VALUE, HASH_TOTAL, BANK_CODE, EOS_BALANCE, FORCE_CLOSE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
			//ps = conn.prepareStatement(sql);
			ps.setString(pos++, bean.getFileRefNumber());
			ps.setString(pos++, bean.getRecordId());
			ps.setDate(pos++, new Date(bean.getOutputDate().getTime()));
			ps.setString(pos++, bean.getService());
			ps.setString(pos++, bean.getSubService());
			ps.setInt(pos++, bean.getNumberOfFiles());
			ps.setInt(pos++, bean.getNumberCredits());
			ps.setInt(pos++, bean.getNumberDebits());
			ps.setDouble(pos++, bean.getCreditValue());
			ps.setDouble(pos++, bean.getDebitValue());
			ps.setLong(pos++, bean.getHashTotal());
			ps.setInt(pos++, bean.getBankCode());
			ps.setString(pos++, bean.getEosBalance());
			ps.setString(pos++, bean.getForceClose());
			
			ps.execute();

		} catch (Exception ex) {
			throw new DAOException("Error creating CCCOWNER.CSO_END_OF_SERVICE_CONTROLS, cause: "
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
	public CsoEndOfServiceControlsDTO retrieve(CsoEndOfServiceControlsDTO bean) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int pos = 1;

		try {
			String sql = 
			"SELECT FILE_REF_NUMBER, RECORD_ID, OUTPUT_DATE, SERVICE, SUB_SERVICE, NUMBER_OF_FILES, NUMBER_CREDITS, NUMBER_DEBITS, CREDIT_VALUE, DEBIT_VALUE, HASH_TOTAL, BANK_CODE, EOS_BALANCE, FORCE_CLOSE FROM CCCOWNER.CSO_END_OF_SERVICE_CONTROLS ";
			sql += this.buildWhereClause(bean, true);

			//ps = conn.prepareStatement(sql);
			this.setParameters(bean, ps, pos, true);

			rs = ps.executeQuery();

			List results = this.getResults(rs);
			if (results.size() > 0) {
				return (CsoEndOfServiceControlsDTO) results.get(0);
			} else {
				return null;
			}
		} catch (Exception ex) {
			throw new DAOException("Error retrieving CCCOWNER.CSO_END_OF_SERVICE_CONTROLS, cause: "
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
	public List<CsoEndOfServiceControlsDTO> retrieveRelated(CsoEndOfServiceControlsDTO bean) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int pos = 1;

		try {
			String sql = 
			"SELECT FILE_REF_NUMBER, RECORD_ID, OUTPUT_DATE, SERVICE, SUB_SERVICE, NUMBER_OF_FILES, NUMBER_CREDITS, NUMBER_DEBITS, CREDIT_VALUE, DEBIT_VALUE, HASH_TOTAL, BANK_CODE, EOS_BALANCE, FORCE_CLOSE FROM CCCOWNER.CSO_END_OF_SERVICE_CONTROLS ";
			sql += this.buildWhereClause(bean, true);

			//ps = conn.prepareStatement(sql);
			this.setParameters(bean, ps, pos, true);

			rs = ps.executeQuery();

			List results = this.getResults(rs);
			if (results.size() > 0) {
				return (List<CsoEndOfServiceControlsDTO>) results;
			} else {
				return null;
			}
		} catch (Exception ex) {
			throw new DAOException("Error retrieving related CCCOWNER.CSO_END_OF_SERVICE_CONTROLS, cause: "
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
	public List<CsoEndOfServiceControlsDTO> retrieveRelated(CsoEndOfServiceControlsDTO bean, int startRow, int endRow) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int pos = 1;

		try {
	// Oracle specific 
			String sql = 
			"SELECT * from (SELECT ROWNUM rn, FILE_REF_NUMBER, RECORD_ID, OUTPUT_DATE, SERVICE, SUB_SERVICE, NUMBER_OF_FILES, NUMBER_CREDITS, NUMBER_DEBITS, CREDIT_VALUE, DEBIT_VALUE, HASH_TOTAL, BANK_CODE, EOS_BALANCE, FORCE_CLOSE FROM CCCOWNER.CSO_END_OF_SERVICE_CONTROLS ";
			sql += this.buildWhereClause(bean, true);

			sql += ") WHERE rn > " + startRow;
			if( endRow > 0 ) {
				sql += " AND rn <= " + endRow;
			}
			//ps = conn.prepareStatement(sql);
			this.setParameters(bean, ps, pos, true);

			rs = ps.executeQuery();

			List results = this.getResults(rs);
			if (results.size() > 0) {
				return (List<CsoEndOfServiceControlsDTO>) results;
			} else {
				return null;
			}
		} catch (Exception ex) {
			throw new DAOException("Error retrieving related CCCOWNER.CSO_END_OF_SERVICE_CONTROLS, cause: "
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
	public void update(CsoEndOfServiceControlsDTO bean) throws DAOException {
		PreparedStatement ps = null;
		int pos = 1;
		boolean first = true;

		try {
			String sql = 
			"UPDATE CCCOWNER.CSO_END_OF_SERVICE_CONTROLS SET ";

	/* dynamic SQL for update */
		if (bean.getFileRefNumber() != null && !bean.getFileRefNumber().isEmpty()) {
				if(!first) {
					sql += ", ";
				}
				else {
					first = false;
				}
			sql += "FILE_REF_NUMBER=?";
		}
		if (bean.getRecordId() != null && !bean.getRecordId().isEmpty()) {
				if(!first) {
					sql += ", ";
				}
				else {
					first = false;
				}
			sql += "RECORD_ID=?";
		}
		if (bean.getOutputDate() != null) {
				if(!first) {
					sql += ", ";
				}
				else {
					first = false;
				}
			sql += "OUTPUT_DATE=?";
		}
		if (bean.getService() != null && !bean.getService().isEmpty()) {
				if(!first) {
					sql += ", ";
				}
				else {
					first = false;
				}
			sql += "SERVICE=?";
		}
		if (bean.getSubService() != null && !bean.getSubService().isEmpty()) {
				if(!first) {
					sql += ", ";
				}
				else {
					first = false;
				}
			sql += "SUB_SERVICE=?";
		}
		if (bean.getNumberOfFiles() > 0) {
				if(!first) {
					sql += ", ";
				}
				else {
					first = false;
				}
			sql += "NUMBER_OF_FILES=?";
		}
		if (bean.getNumberCredits() > 0) {
				if(!first) {
					sql += ", ";
				}
				else {
					first = false;
				}
			sql += "NUMBER_CREDITS=?";
		}
		if (bean.getNumberDebits() > 0) {
				if(!first) {
					sql += ", ";
				}
				else {
					first = false;
				}
			sql += "NUMBER_DEBITS=?";
		}
		if (bean.getCreditValue() > 0.0) {
				if(!first) {
					sql += ", ";
				}
				else {
					first = false;
				}
			sql += "CREDIT_VALUE=?";
		}
		if (bean.getDebitValue() > 0.0) {
				if(!first) {
					sql += ", ";
				}
				else {
					first = false;
				}
			sql += "DEBIT_VALUE=?";
		}
		if (bean.getHashTotal() > 0L) {
				if(!first) {
					sql += ", ";
				}
				else {
					first = false;
				}
			sql += "HASH_TOTAL=?";
		}
		if (bean.getBankCode() > 0) {
				if(!first) {
					sql += ", ";
				}
				else {
					first = false;
				}
			sql += "BANK_CODE=?";
		}
		if (bean.getEosBalance() != null && !bean.getEosBalance().isEmpty()) {
				if(!first) {
					sql += ", ";
				}
				else {
					first = false;
				}
			sql += "EOS_BALANCE=?";
		}
		if (bean.getForceClose() != null && !bean.getForceClose().isEmpty()) {
				if(!first) {
					sql += ", ";
				}
				else {
					first = false;
				}
			sql += "FORCE_CLOSE=?";
		}
		//	sql += this.buildWhereClause(bean, false);
		//ps = conn.prepareStatement(sql);


	/* dynamic update parameter */
			if (bean.getFileRefNumber() != null && !bean.getFileRefNumber().isEmpty()) {
				ps.setString(pos++, bean.getFileRefNumber());
			}
			if (bean.getRecordId() != null && !bean.getRecordId().isEmpty()) {
				ps.setString(pos++, bean.getRecordId());
			}
			if (bean.getOutputDate() != null) {
				ps.setDate(pos++, new Date(bean.getOutputDate().getTime()));
			}
			if (bean.getService() != null && !bean.getService().isEmpty()) {
				ps.setString(pos++, bean.getService());
			}
			if (bean.getSubService() != null && !bean.getSubService().isEmpty()) {
				ps.setString(pos++, bean.getSubService());
			}
			if (bean.getNumberOfFiles() > 0) {
				ps.setInt(pos++, bean.getNumberOfFiles());
			}
			if (bean.getNumberCredits() > 0) {
				ps.setInt(pos++, bean.getNumberCredits());
			}
			if (bean.getNumberDebits() > 0) {
				ps.setInt(pos++, bean.getNumberDebits());
			}
			if (bean.getCreditValue() > 0.0) {
				ps.setDouble(pos++, bean.getCreditValue());
			}
			if (bean.getDebitValue() > 0.0) {
				ps.setDouble(pos++, bean.getDebitValue());
			}
			if (bean.getHashTotal() > 0L) {
				ps.setLong(pos++, bean.getHashTotal());
			}
			if (bean.getBankCode() > 0) {
				ps.setInt(pos++, bean.getBankCode());
			}
			if (bean.getEosBalance() != null && !bean.getEosBalance().isEmpty()) {
				ps.setString(pos++, bean.getEosBalance());
			}
			if (bean.getForceClose() != null && !bean.getForceClose().isEmpty()) {
				ps.setString(pos++, bean.getForceClose());
			}
		//	pos = this.setParameters(bean, ps, pos, false);

			ps.executeUpdate();

		} catch (Exception ex) {
			throw new DAOException("Error updating CCCOWNER.CSO_END_OF_SERVICE_CONTROLS, cause: "
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
	public void delete(CsoEndOfServiceControlsDTO bean) throws DAOException {
		PreparedStatement ps = null;

		int pos = 1;

		try {
			String sql = 
			"DELETE FROM CCCOWNER.CSO_END_OF_SERVICE_CONTROLS";
			sql += this.buildWhereClause(bean, true);

			//ps = conn.prepareStatement(sql);

			pos = this.setParameters(bean, ps, pos, true);

			ps.executeUpdate();

		} catch (Exception ex) {
			throw new DAOException("Error deleting CCCOWNER.CSO_END_OF_SERVICE_CONTROLS, cause: "
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
	public int retrieveRowCount(CsoEndOfServiceControlsDTO bean) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count=0;

		int pos = 1;

		try {
			String sql = 
			"SELECT COUNT(*) AS count FROM CCCOWNER.CSO_END_OF_SERVICE_CONTROLS ";
			sql += this.buildWhereClause(bean, true);

			//ps = conn.prepareStatement(sql);
			this.setParameters(bean, ps, pos, true);

			rs = ps.executeQuery();

			while (rs.next()) {
				count=rs.getInt("count");
			}
		} catch (Exception ex) {
			throw new DAOException("Error retrieving CCCOWNER.CSO_END_OF_SERVICE_CONTROLS, cause: "
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
				CsoEndOfServiceControlsDTO bean = new CsoEndOfServiceControlsDTO();
				bean.setFileRefNumber(rs.getString("FILE_REF_NUMBER"));
				bean.setRecordId(rs.getString("RECORD_ID"));
				bean.setOutputDate(rs.getDate("OUTPUT_DATE"));
				bean.setService(rs.getString("SERVICE"));
				bean.setSubService(rs.getString("SUB_SERVICE"));
				bean.setNumberOfFiles(rs.getInt("NUMBER_OF_FILES"));
				bean.setNumberCredits(rs.getInt("NUMBER_CREDITS"));
				bean.setNumberDebits(rs.getInt("NUMBER_DEBITS"));
				bean.setCreditValue(rs.getDouble("CREDIT_VALUE"));
				bean.setDebitValue(rs.getDouble("DEBIT_VALUE"));
				bean.setHashTotal(rs.getLong("HASH_TOTAL"));
				bean.setBankCode(rs.getInt("BANK_CODE"));
				bean.setEosBalance(rs.getString("EOS_BALANCE"));
				bean.setForceClose(rs.getString("FORCE_CLOSE"));
				results.add(bean);
			}
			return results;
		} catch (Exception ex) {
			throw new DAOException("Error getting results CCCOWNER.CSO_END_OF_SERVICE_CONTROLS, cause: "
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
	private String buildWhereClause(CsoEndOfServiceControlsDTO bean, boolean select) throws DAOException {
		if(bean == null) {
			return "";
		}

		StringBuilder buff = new StringBuilder();
		boolean whereClause = false;

		if (bean.getFileRefNumber() != null && !bean.getFileRefNumber().isEmpty()) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			 buff.append("c.FILE_REF_NUMBER=?");
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
		if (bean.getBankCode() > 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			 buff.append("c.BANK_CODE=?");
		}
		if (select == true) {
			if (bean.getRecordId() != null && !bean.getRecordId().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("c.RECORD_ID=?");
			}
			if (bean.getOutputDate() != null) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("c.OUTPUT_DATE=?");
			}
			if (bean.getNumberOfFiles() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("c.NUMBER_OF_FILES=?");
			}
			if (bean.getNumberCredits() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("c.NUMBER_CREDITS=?");
			}
			if (bean.getNumberDebits() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("c.NUMBER_DEBITS=?");
			}
			if (bean.getCreditValue() > 0.0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("c.CREDIT_VALUE=?");
			}
			if (bean.getDebitValue() > 0.0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("c.DEBIT_VALUE=?");
			}
			if (bean.getHashTotal() > 0L) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("c.HASH_TOTAL=?");
			}
			if (bean.getEosBalance() != null && !bean.getEosBalance().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("c.EOS_BALANCE=?");
			}
			if (bean.getForceClose() != null && !bean.getForceClose().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("c.FORCE_CLOSE=?");
			}
		}
		if(!whereClause && select == false) {
			throw new DAOException("Cannot update delete all rows in CCCOWNER.CSO_END_OF_SERVICE_CONTROLS");
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
	private int setParameters(CsoEndOfServiceControlsDTO bean, PreparedStatement ps, int pos, boolean select) throws DAOException {
		if(bean == null) {
			return 1;
		}
		try {
			if (bean.getFileRefNumber() != null && !bean.getFileRefNumber().isEmpty()) {
				ps.setString(pos++, bean.getFileRefNumber());
			}
			if (bean.getService() != null && !bean.getService().isEmpty()) {
				ps.setString(pos++, bean.getService());
			}
			if (bean.getSubService() != null && !bean.getSubService().isEmpty()) {
				ps.setString(pos++, bean.getSubService());
			}
			if (bean.getBankCode() > 0) {
				ps.setInt(pos++, bean.getBankCode());
			}
			if (select == true) {
				if (bean.getRecordId() != null && !bean.getRecordId().isEmpty()) {
					ps.setString(pos++, bean.getRecordId());
				}
				if (bean.getOutputDate() != null) {
					ps.setDate(pos++, new Date(bean.getOutputDate().getTime()));
				}
				if (bean.getNumberOfFiles() > 0) {
					ps.setInt(pos++, bean.getNumberOfFiles());
				}
				if (bean.getNumberCredits() > 0) {
					ps.setInt(pos++, bean.getNumberCredits());
				}
				if (bean.getNumberDebits() > 0) {
					ps.setInt(pos++, bean.getNumberDebits());
				}
				if (bean.getCreditValue() > 0.0) {
					ps.setDouble(pos++, bean.getCreditValue());
				}
				if (bean.getDebitValue() > 0.0) {
					ps.setDouble(pos++, bean.getDebitValue());
				}
				if (bean.getHashTotal() > 0L) {
					ps.setLong(pos++, bean.getHashTotal());
				}
				if (bean.getEosBalance() != null && !bean.getEosBalance().isEmpty()) {
					ps.setString(pos++, bean.getEosBalance());
				}
				if (bean.getForceClose() != null && !bean.getForceClose().isEmpty()) {
					ps.setString(pos++, bean.getForceClose());
				}
			}
			return pos;
		} catch (Exception ex) {
			throw new DAOException("Error getting results CCCOWNER.CSO_END_OF_SERVICE_CONTROLS, cause: "
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
