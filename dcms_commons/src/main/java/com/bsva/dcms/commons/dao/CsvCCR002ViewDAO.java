package com.bsva.dcms.commons.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bsva.dcms.commons.dto.views.temp.CsvCcr002ViewDto;
import com.bsva.dcms.commons.exceptions.DAOException;

public class CsvCCR002ViewDAO {
	
	private String SQL_SELECT = 			"";
	private Connection conn;
	
	public CsvCCR002ViewDAO(Connection conn){
		this.conn = conn;
	}
	
	public List<CsvCcr002ViewDto> retrieveRelated(CsvCcr002ViewDto bean) throws DAOException{
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		int pos = 1;
		
		try{
			
			SQL_SELECT = 
					"SELECT * FROM CCCOWNER.CSV_CCR002_VIEW ";
					SQL_SELECT += this.buildWhereClause(bean, true);

			ps = conn.prepareStatement(SQL_SELECT);
			this.setParameters(bean, ps, pos, true);
			
			rs = ps.executeQuery();
					
			List results = this.getResults(rs);
			if (results.size() > 0) {
				return (List<CsvCcr002ViewDto>) results;
			} else {
				return null;
			}
			
		}catch (Exception ex) {
			throw new DAOException("Error retrieving related CCCOWNER.CSV_CCR002_VIEW, cause: "
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
	private String buildWhereClause(CsvCcr002ViewDto bean, boolean select) throws DAOException {
		if(bean == null) {
			return "";
		}

		StringBuilder buff = new StringBuilder();
		boolean whereClause = false;

		if (bean.getIssuerMember() != null && !bean.getIssuerMember().isEmpty()) {
	
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			 buff.append("ISSUER_MEMBER =?");
		}
		
		if (select == true) {
			if (bean.getIssuerBankCode() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("ISSUER_CODE=?");
			}
			if (bean.getAcquirerMember() != null && !bean.getAcquirerMember().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("ACQUIRER_MEMBER=?");
			}
			
			if (bean.getAcquirerBankCode() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("ACQUIRER_CODE=?");
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
			
			if (bean.getAcquirerFees() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("ACQ_FEES=?");
			}
			
			if (bean.getIssuerFees() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("ISS_FEES=?");
			}
			
			if (bean.getNettFees() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("NETT_FEES=?");
			}
			
			if (bean.getInvoiceNumber() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("INVOICE_NO_CCR001=?");
			}
			
		}
		if(!whereClause && select == false) {
			throw new DAOException("Cannot update delete all rows in CCCOWNER.CSV_CCR002_VIEW");
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
				CsvCcr002ViewDto bean = new CsvCcr002ViewDto();
				bean.setIssuerMember(rs.getString("ISSUER_MEMBER"));
				bean.setIssuerBankCode(rs.getInt("ISSUER_CODE"));
				bean.setAcquirerMember(rs.getString("ACQUIRER_MEMBER"));
				bean.setAcquirerBankCode(rs.getInt("ACQUIRER_CODE"));
				bean.setService(rs.getString("SERVICE"));
				bean.setSubService(rs.getString("SUB_SERVICE"));
				bean.setAcquirerFees(rs.getDouble("ACQ_FEES"));
				bean.setIssuerFees(rs.getDouble("ISS_FEES"));
				bean.setNettFees(rs.getDouble("NETT_FEES"));
				bean.setInvoiceNumber(rs.getInt("INVOICE_NO_CCR001"));
				
				results.add(bean);
			}
			return results;
		} catch (Exception ex) {
			throw new DAOException("Error getting results CCCOWNER.CSV_CCR002_VIEW, cause: "
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
	private int setParameters(CsvCcr002ViewDto bean, PreparedStatement ps, int pos, boolean select) throws DAOException {
		if(bean == null) {
			return 1;
		}
		try {
			if (bean.getIssuerMember() != null && !bean.getIssuerMember().isEmpty()) {
				ps.setString(pos++, bean.getIssuerMember());
			}
			if (select == true) {
				if (bean.getIssuerBankCode() > 0) {
					ps.setInt(pos++, bean.getIssuerBankCode());
				}
				if (bean.getAcquirerMember() != null && !bean.getAcquirerMember().isEmpty()) {
					ps.setString(pos++, bean.getAcquirerMember());
				}
				
				if (bean.getAcquirerBankCode() > 0) {
					ps.setInt(pos++, bean.getAcquirerBankCode());
				}
				if (bean.getService() != null && !bean.getService().isEmpty()) {
					ps.setString(pos++, bean.getService());
				}
				
				if (bean.getSubService() != null && !bean.getSubService().isEmpty()) {
					ps.setString(pos++, bean.getSubService());
				}
				if (bean.getAcquirerFees() > 0) {
					ps.setDouble(pos++, bean.getAcquirerFees());
				}
				
				if (bean.getIssuerFees() > 0) {
					ps.setDouble(pos++, bean.getIssuerFees());
				}
				
				if (bean.getNettFees() > 0) {
					ps.setDouble(pos++, bean.getNettFees());
				}
				
				if (bean.getInvoiceNumber() > 0) {
					ps.setInt(pos++, bean.getInvoiceNumber());
				}
			}
			return pos;
		} catch (Exception ex) {
			throw new DAOException("Error getting results CCCOWNER.CSV_CCR002_VIEW, cause: "
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
