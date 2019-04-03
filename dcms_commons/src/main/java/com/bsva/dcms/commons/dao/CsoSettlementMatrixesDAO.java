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

import com.bsva.dcms.commons.dto.CsoSettlementMatrixesDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
/**
* Data access object interface that defines the methods that must be supported
* by all data access objects.
*
* Created By BSVATools
*/

public class CsoSettlementMatrixesDAO {

	private DataSource conn;

	public CsoSettlementMatrixesDAO(DataSource conn) {
		this.conn = conn;
}

	/**
	 * Create a new record in Database.
	 *
	 * @param bean The Object to be inserted.
	 * @exception SQLException if something is wrong.
	 */
	public void create(CsoSettlementMatrixesDTO bean) throws DAOException {
		PreparedStatement ps = null;
		int pos = 1;

		try {
			String sql = 
			"INSERT INTO CCCOWNER.CSO_SETTLEMENT_MATRIXES (ORIGINATING_BANK, ACTION_DATE, HOMING_BANK, SERVICE, SUB_SERVICE, CURRENCY_CODE, STATUS_CODE, SETTLEMENT_IND, BANK_OUTPUT_CREATED_IND, CR_VOLUME, DR_VOLUME, CR_VALUE, DR_VALUE, PAYMENT_STREAM) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
			//ps = conn.prepareStatement(sql);

			ps.setInt(pos++, bean.getOriginatingBank());
			ps.setDate(pos++, new Date(bean.getActionDate().getTime()));
			ps.setInt(pos++, bean.getHomingBank());
			ps.setString(pos++, bean.getService());
			ps.setString(pos++, bean.getSubService());
			ps.setString(pos++, bean.getCurrencyCode());
			ps.setString(pos++, bean.getStatusCode());
			ps.setString(pos++, bean.getSettlementInd());
			ps.setString(pos++, bean.getBankOutputCreatedInd());
			ps.setInt(pos++, bean.getCrVolume());
			ps.setInt(pos++, bean.getDrVolume());
			ps.setDouble(pos++, bean.getCrValue());
			ps.setDouble(pos++, bean.getDrValue());
			ps.setString(pos++, bean.getPaymentStream());
			ps.executeUpdate();

		} catch (Exception ex) {
			throw new DAOException("Error creating CCCOWNER.CSO_SETTLEMENT_MATRIXES, cause: "
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
	public CsoSettlementMatrixesDTO retrieve(CsoSettlementMatrixesDTO bean) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int pos = 1;

		try {
			String sql = 
			"SELECT ORIGINATING_BANK, ACTION_DATE, HOMING_BANK, SERVICE, SUB_SERVICE, CURRENCY_CODE, STATUS_CODE, SETTLEMENT_IND, BANK_OUTPUT_CREATED_IND, CR_VOLUME, DR_VOLUME, CR_VALUE, DR_VALUE, PAYMENT_STREAM FROM CCCOWNER.CSO_SETTLEMENT_MATRIXES ";
			sql += this.buildWhereClause(bean, true);

			//ps = conn.prepareStatement(sql);
			this.setParameters(bean, ps, pos, true);

			rs = ps.executeQuery();

			List results = this.getResults(rs);
			if (results.size() > 0) {
				return (CsoSettlementMatrixesDTO) results.get(0);
			} else {
				return null;
			}
		} catch (Exception ex) {
			throw new DAOException("Error retrieving CCCOWNER.CSO_SETTLEMENT_MATRIXES, cause: "
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
	public List<CsoSettlementMatrixesDTO> retrieveRelated(CsoSettlementMatrixesDTO bean) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int pos = 1;

		try {
			String sql = 
			"SELECT ORIGINATING_BANK, ACTION_DATE, HOMING_BANK, SERVICE, SUB_SERVICE, CURRENCY_CODE, STATUS_CODE, SETTLEMENT_IND, BANK_OUTPUT_CREATED_IND, CR_VOLUME, DR_VOLUME, CR_VALUE, DR_VALUE, PAYMENT_STREAM FROM CCCOWNER.CSO_SETTLEMENT_MATRIXES ";
			sql += this.buildWhereClause(bean, true);

			//ps = conn.prepareStatement(sql);
			this.setParameters(bean, ps, pos, true);

			rs = ps.executeQuery();

			List results = this.getResults(rs);
			if (results.size() > 0) {
				return (List<CsoSettlementMatrixesDTO>) results;
			} else {
				return null;
			}
		} catch (Exception ex) {
			throw new DAOException("Error retrieving related CCCOWNER.CSO_SETTLEMENT_MATRIXES, cause: "
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
	public List<CsoSettlementMatrixesDTO> retrieveRelated(CsoSettlementMatrixesDTO bean, int startRow, int endRow) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int pos = 1;

		try {
	// Oracle specific 
			String sql = 
			"SELECT * from (SELECT ROWNUM rn, ORIGINATING_BANK, ACTION_DATE, HOMING_BANK, SERVICE, SUB_SERVICE, CURRENCY_CODE, STATUS_CODE, SETTLEMENT_IND, BANK_OUTPUT_CREATED_IND, CR_VOLUME, DR_VOLUME, CR_VALUE, DR_VALUE, PAYMENT_STREAM FROM CCCOWNER.CSO_SETTLEMENT_MATRIXES ";
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
				return (List<CsoSettlementMatrixesDTO>) results;
			} else {
				return null;
			}
		} catch (Exception ex) {
			throw new DAOException("Error retrieving related CCCOWNER.CSO_SETTLEMENT_MATRIXES, cause: "
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
	public void update(CsoSettlementMatrixesDTO bean) throws DAOException {
		PreparedStatement ps = null;
		int pos = 1;
		boolean first = true;

		try {
			String sql = 
			"UPDATE CCCOWNER.CSO_SETTLEMENT_MATRIXES SET ";

	/* dynamic SQL for update */
		if (bean.getOriginatingBank() > 0) {
				if(!first) {
					sql += ", ";
				}
				else {
					first = false;
				}
			sql += "ORIGINATING_BANK=?";
		}
		if (bean.getActionDate() != null) {
				if(!first) {
					sql += ", ";
				}
				else {
					first = false;
				}
			sql += "ACTION_DATE=?";
		}
		if (bean.getHomingBank() > 0) {
				if(!first) {
					sql += ", ";
				}
				else {
					first = false;
				}
			sql += "HOMING_BANK=?";
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
		if (bean.getCurrencyCode() != null && !bean.getCurrencyCode().isEmpty()) {
				if(!first) {
					sql += ", ";
				}
				else {
					first = false;
				}
			sql += "CURRENCY_CODE=?";
		}
		if (bean.getStatusCode() != null && !bean.getStatusCode().isEmpty()) {
				if(!first) {
					sql += ", ";
				}
				else {
					first = false;
				}
			sql += "STATUS_CODE=?";
		}
		if (bean.getSettlementInd() != null && !bean.getSettlementInd().isEmpty()) {
				if(!first) {
					sql += ", ";
				}
				else {
					first = false;
				}
			sql += "SETTLEMENT_IND=?";
		}
		if (bean.getBankOutputCreatedInd() != null && !bean.getBankOutputCreatedInd().isEmpty()) {
				if(!first) {
					sql += ", ";
				}
				else {
					first = false;
				}
			sql += "BANK_OUTPUT_CREATED_IND=?";
		}
		if (bean.getCrVolume() > 0) {
				if(!first) {
					sql += ", ";
				}
				else {
					first = false;
				}
			sql += "CR_VOLUME=?";
		}
		if (bean.getDrVolume() > 0) {
				if(!first) {
					sql += ", ";
				}
				else {
					first = false;
				}
			sql += "DR_VOLUME=?";
		}
		if (bean.getCrValue() > 0.0) {
				if(!first) {
					sql += ", ";
				}
				else {
					first = false;
				}
			sql += "CR_VALUE=?";
		}
		if (bean.getDrValue() > 0.0) {
				if(!first) {
					sql += ", ";
				}
				else {
					first = false;
				}
			sql += "DR_VALUE=?";
		}
		if (bean.getPaymentStream() != null && !bean.getPaymentStream().isEmpty()) {
				if(!first) {
					sql += ", ";
				}
				else {
					first = false;
				}
			sql += "PAYMENT_STREAM=?";
		}
	//		sql += this.buildWhereClause(bean, false);
			//ps = conn.prepareStatement(sql);


	/* dynamic update parameter */
			if (bean.getOriginatingBank() > 0) {
				ps.setInt(pos++, bean.getOriginatingBank());
			}
			if (bean.getActionDate() != null) {
				ps.setDate(pos++, new Date(bean.getActionDate().getTime()));
			}
			if (bean.getHomingBank() > 0) {
				ps.setInt(pos++, bean.getHomingBank());
			}
			if (bean.getService() != null && !bean.getService().isEmpty()) {
				ps.setString(pos++, bean.getService());
			}
			if (bean.getSubService() != null && !bean.getSubService().isEmpty()) {
				ps.setString(pos++, bean.getSubService());
			}
			if (bean.getCurrencyCode() != null && !bean.getCurrencyCode().isEmpty()) {
				ps.setString(pos++, bean.getCurrencyCode());
			}
			if (bean.getStatusCode() != null && !bean.getStatusCode().isEmpty()) {
				ps.setString(pos++, bean.getStatusCode());
			}
			if (bean.getSettlementInd() != null && !bean.getSettlementInd().isEmpty()) {
				ps.setString(pos++, bean.getSettlementInd());
			}
			if (bean.getBankOutputCreatedInd() != null && !bean.getBankOutputCreatedInd().isEmpty()) {
				ps.setString(pos++, bean.getBankOutputCreatedInd());
			}
			if (bean.getCrVolume() > 0) {
				ps.setInt(pos++, bean.getCrVolume());
			}
			if (bean.getDrVolume() > 0) {
				ps.setInt(pos++, bean.getDrVolume());
			}
			if (bean.getCrValue() > 0.0) {
				ps.setDouble(pos++, bean.getCrValue());
			}
			if (bean.getDrValue() > 0.0) {
				ps.setDouble(pos++, bean.getDrValue());
			}
			if (bean.getPaymentStream() != null && !bean.getPaymentStream().isEmpty()) {
				ps.setString(pos++, bean.getPaymentStream());
			}
	//		pos = this.setParameters(bean, ps, pos, false);

			ps.executeUpdate();

		} catch (Exception ex) {
			throw new DAOException("Error updating CCCOWNER.CSO_SETTLEMENT_MATRIXES, cause: "
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
	public void delete(CsoSettlementMatrixesDTO bean) throws DAOException {
		PreparedStatement ps = null;


		int pos = 1;

		try {
			String sql = 
			"DELETE FROM CCCOWNER.CSO_SETTLEMENT_MATRIXES";
			sql += this.buildWhereClause(bean, true);

			//ps = conn.prepareStatement(sql);

			pos = this.setParameters(bean, ps, pos, true);

			ps.executeUpdate();

		} catch (Exception ex) {
			throw new DAOException("Error deleting CCCOWNER.CSO_SETTLEMENT_MATRIXES, cause: "
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
	public int retrieveRowCount(CsoSettlementMatrixesDTO bean) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count=0;

		int pos = 1;

		try {
			String sql = 
			"SELECT COUNT(*) AS count FROM CCCOWNER.CSO_SETTLEMENT_MATRIXES ";
			sql += this.buildWhereClause(bean, true);

			//ps = conn.prepareStatement(sql);
			this.setParameters(bean, ps, pos, true);

			rs = ps.executeQuery();

			while (rs.next()) {
				count=rs.getInt("count");
			}
		} catch (Exception ex) {
			throw new DAOException("Error retrieving CCCOWNER.CSO_SETTLEMENT_MATRIXES, cause: "
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
				CsoSettlementMatrixesDTO bean = new CsoSettlementMatrixesDTO();
				bean.setOriginatingBank(rs.getInt("ORIGINATING_BANK"));
				bean.setActionDate(rs.getDate("ACTION_DATE"));
				bean.setHomingBank(rs.getInt("HOMING_BANK"));
				bean.setService(rs.getString("SERVICE"));
				bean.setSubService(rs.getString("SUB_SERVICE"));
				bean.setCurrencyCode(rs.getString("CURRENCY_CODE"));
				bean.setStatusCode(rs.getString("STATUS_CODE"));
				bean.setSettlementInd(rs.getString("SETTLEMENT_IND"));
				bean.setBankOutputCreatedInd(rs.getString("BANK_OUTPUT_CREATED_IND"));
				bean.setCrVolume(rs.getInt("CR_VOLUME"));
				bean.setDrVolume(rs.getInt("DR_VOLUME"));
				bean.setCrValue(rs.getDouble("CR_VALUE"));
				bean.setDrValue(rs.getDouble("DR_VALUE"));
				bean.setPaymentStream(rs.getString("PAYMENT_STREAM"));
				results.add(bean);
			}
			return results;
		} catch (Exception ex) {
			throw new DAOException("Error getting results CCCOWNER.CSO_SETTLEMENT_MATRIXES, cause: "
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
	private String buildWhereClause(CsoSettlementMatrixesDTO bean, boolean select) throws DAOException {
		if(bean == null) {
			return "";
		}

		StringBuilder buff = new StringBuilder();
		boolean whereClause = false;

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
			if (bean.getOriginatingBank() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("ORIGINATING_BANK=?");
			}
			if (bean.getActionDate() != null) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("ACTION_DATE=?");
			}
			if (bean.getHomingBank() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("HOMING_BANK=?");
			}
			if (bean.getCurrencyCode() != null && !bean.getCurrencyCode().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("CURRENCY_CODE=?");
			}
			if (bean.getStatusCode() != null && !bean.getStatusCode().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("STATUS_CODE=?");
			}
			if (bean.getSettlementInd() != null && !bean.getSettlementInd().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("SETTLEMENT_IND=?");
			}
			if (bean.getBankOutputCreatedInd() != null && !bean.getBankOutputCreatedInd().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("BANK_OUTPUT_CREATED_IND=?");
			}
			if (bean.getCrVolume() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("CR_VOLUME=?");
			}
			if (bean.getDrVolume() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("DR_VOLUME=?");
			}
			if (bean.getCrValue() > 0.0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("CR_VALUE=?");
			}
			if (bean.getDrValue() > 0.0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("DR_VALUE=?");
			}
			if (bean.getPaymentStream() != null && !bean.getPaymentStream().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("PAYMENT_STREAM=?");
			}
		}
		if(!whereClause && select == false) {
			throw new DAOException("Cannot update delete all rows in CCCOWNER.CSO_SETTLEMENT_MATRIXES");
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
	private int setParameters(CsoSettlementMatrixesDTO bean, PreparedStatement ps, int pos, boolean select) throws DAOException {
		if(bean == null) {
			return 1;
		}
		try {
			if (bean.getService() != null && !bean.getService().isEmpty()) {
				ps.setString(pos++, bean.getService());
			}
			if (bean.getSubService() != null && !bean.getSubService().isEmpty()) {
				ps.setString(pos++, bean.getSubService());
			}
			if (select == true) {
				if (bean.getOriginatingBank() > 0) {
					ps.setInt(pos++, bean.getOriginatingBank());
				}
				if (bean.getActionDate() != null) {
					ps.setDate(pos++, new Date(bean.getActionDate().getTime()));
				}
				if (bean.getHomingBank() > 0) {
					ps.setInt(pos++, bean.getHomingBank());
				}
				if (bean.getCurrencyCode() != null && !bean.getCurrencyCode().isEmpty()) {
					ps.setString(pos++, bean.getCurrencyCode());
				}
				if (bean.getStatusCode() != null && !bean.getStatusCode().isEmpty()) {
					ps.setString(pos++, bean.getStatusCode());
				}
				if (bean.getSettlementInd() != null && !bean.getSettlementInd().isEmpty()) {
					ps.setString(pos++, bean.getSettlementInd());
				}
				if (bean.getBankOutputCreatedInd() != null && !bean.getBankOutputCreatedInd().isEmpty()) {
					ps.setString(pos++, bean.getBankOutputCreatedInd());
				}
				if (bean.getCrVolume() > 0) {
					ps.setInt(pos++, bean.getCrVolume());
				}
				if (bean.getDrVolume() > 0) {
					ps.setInt(pos++, bean.getDrVolume());
				}
				if (bean.getCrValue() > 0.0) {
					ps.setDouble(pos++, bean.getCrValue());
				}
				if (bean.getDrValue() > 0.0) {
					ps.setDouble(pos++, bean.getDrValue());
				}
				if (bean.getPaymentStream() != null && !bean.getPaymentStream().isEmpty()) {
					ps.setString(pos++, bean.getPaymentStream());
				}
			}
			return pos;
		} catch (Exception ex) {
			throw new DAOException("Error getting results CCCOWNER.CSO_SETTLEMENT_MATRIXES, cause: "
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
