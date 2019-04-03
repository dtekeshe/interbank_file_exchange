package com.bsva.dcms.commons.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bsva.dcms.commons.dto.views.CsvSettlementViewDto;
import com.bsva.dcms.commons.exceptions.DAOException;

public class CsvSettlementViewDAO {
	
	private String SQL_SELECT = 			"";
	private Connection conn;
	
	public CsvSettlementViewDAO(Connection conn){
		this.conn = conn;
	}
	
	public List<CsvSettlementViewDto> retrieveRelated(CsvSettlementViewDto bean) throws DAOException{
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		int pos = 1;
		
		try{
			
			SQL_SELECT = 
					"SELECT * FROM CCCOWNER.CSV_SETTLEMENT_VIEW ";
					SQL_SELECT += this.buildWhereClause(bean, true);

			ps = conn.prepareStatement(SQL_SELECT);
			this.setParameters(bean, ps, pos, true);
			
			rs = ps.executeQuery();
					
			List results = this.getResults(rs);
			if (results.size() > 0) {
				return (List<CsvSettlementViewDto>) results;
			} else {
				return null;
			}
			
		}catch (Exception ex) {
			throw new DAOException("Error retrieving related CCCOWNER.CSV_SETTLEMENT_VIEW, cause: "
					+ ex.getMessage(), ex);
		} finally {
			close(rs);
			close(ps);
		}
	}
	
	/**
	 * Build a Dynamic Where Clause.
	 *
	 * @param bean The Object to be used.
	 * @param select Is the where clause for a Query or Update.
	 * @exception SQLException if something is wrong.
	 */
	private String buildWhereClause(CsvSettlementViewDto bean, boolean select) throws DAOException {
		if(bean == null) {
			return "";
		}

		StringBuilder buff = new StringBuilder();
		boolean whereClause = false;

		if (bean.getOriginatingBank() > 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			 buff.append("ORIGINATING_BANK =?");
		}
		if (select == true) {
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
			if (bean.getProcessDate() != null ) {
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
			
			if (bean.getSettlementName() != null && !bean.getSettlementName().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("SETTLEMENT_NAME=?");
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
			if (bean.getCrVolume()> 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("CR_VOLUME=?");
			}
			if (bean.getCrValue() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("CR_VALUE=?");
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
			
			if (bean.getDrValue() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("DR_VALUE=?");
			}
		}
		if(!whereClause && select == false) {
			throw new DAOException("Cannot update delete all rows in CCCOWNER.CSV_SETTLEMENT_VIEW");
		}
		return buff.toString();
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
				CsvSettlementViewDto bean = new CsvSettlementViewDto();
				bean.setOriginatingBank(rs.getInt("ORIGINATING_BANK"));
				bean.setHomingBank(rs.getInt("HOMING_BANK"));
				bean.setProcessDate(new java.util.Date(rs.getDate("PROCESS_DATE").getTime()));
				bean.setService(rs.getString("SERVICE"));
				bean.setSubService(rs.getString("SUB_SERVICE"));
				bean.setSettlementName(rs.getString("SETTLEMENT_NAME"));
				bean.setPaymentStream(rs.getString("PAYMENT_STREAM"));
				bean.setCurrencyCode(rs.getString("CURRENCY_CODE"));
				bean.setStatusCode(rs.getString("STATUS_CODE"));
				bean.setSettlementInd(rs.getString("SETTLEMENT_IND"));
				bean.setCrVolume(rs.getInt("CR_VOLUME"));
				bean.setCrValue(rs.getDouble("CR_VALUE"));
				bean.setDrVolume(rs.getInt("DR_VOLUME"));
				bean.setDrValue(rs.getDouble("DR_VALUE"));
			
				results.add(bean);
			}
			return results;
		} catch (Exception ex) {
			throw new DAOException("Error getting results CCCOWNER.CSV_SETTLEMENT_VIEW, cause: "
				+ ex.getMessage(), ex);
		} finally {
		}
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
	private int setParameters(CsvSettlementViewDto bean, PreparedStatement ps, int pos, boolean select) throws DAOException {
		if(bean == null) {
			return 1;
		}
		try {
			if (bean.getOriginatingBank() > 0) {
				ps.setInt(pos++, bean.getOriginatingBank());
			}
			if (select == true) {
				if (bean.getHomingBank() > 0) {
					ps.setInt(pos++, bean.getHomingBank());
				}
				if (bean.getProcessDate() != null) {
					ps.setDate(pos++, new java.sql.Date(bean.getProcessDate().getTime()));
				}
				
				if (bean.getService() != null && !bean.getService().isEmpty()) {
					ps.setString(pos++, bean.getService());
				}
				
				if (bean.getSubService() != null && !bean.getSubService().isEmpty()) {
					ps.setString(pos++, bean.getSubService());
				}
				
				if (bean.getSettlementName() != null && !bean.getSettlementName().isEmpty()) {
					ps.setString(pos++, bean.getSettlementName());
				}
				
				if (bean.getPaymentStream() != null && !bean.getPaymentStream().isEmpty()) {
					ps.setString(pos++, bean.getPaymentStream());
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
				
				if (bean.getCrVolume()> 0) {
					ps.setInt(pos++, bean.getCrVolume());
				}
				
				if (bean.getCrValue() > 0) {
					ps.setDouble(pos++, bean.getCrValue());
				}
				
				if (bean.getDrVolume() > 0) {
					ps.setInt(pos++, bean.getDrVolume());
				}
				
				if (bean.getDrValue() > 0) {
					ps.setDouble(pos++, bean.getDrValue());
				}
			}
			return pos;
		} catch (Exception ex) {
			throw new DAOException("Error getting results CCCOWNER.CSV_SETTLEMENT_VIEW, cause: "
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
