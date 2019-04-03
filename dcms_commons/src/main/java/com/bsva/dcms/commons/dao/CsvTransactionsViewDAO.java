package com.bsva.dcms.commons.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bsva.dcms.commons.dto.views.CsvTransactionsViewDto;
import com.bsva.dcms.commons.exceptions.DAOException;

public class CsvTransactionsViewDAO {
	
	private String SQL_SELECT = 			"";
	private Connection conn;
	
	public CsvTransactionsViewDAO(Connection conn){
		this.conn = conn;
	}
	
	public List<CsvTransactionsViewDto> retrieveRelated(CsvTransactionsViewDto bean) throws DAOException{
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		int pos = 1;
		
		try{
			
			SQL_SELECT = 
					"SELECT * FROM CCCOWNER.CSV_TRANSACTIONS_VIEW ";
					SQL_SELECT += this.buildWhereClause(bean, true);

			ps = conn.prepareStatement(SQL_SELECT);
			this.setParameters(bean, ps, pos, true);
			
			rs = ps.executeQuery();
					
			List results = this.getResults(rs);
			if (results.size() > 0) {
				return (List<CsvTransactionsViewDto>) results;
			} else {
				return null;
			}
			
		}catch (Exception ex) {
			throw new DAOException("Error retrieving related CCCOWNER.CSV_TRANSACTIONS_VIEW, cause: "
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
	private String buildWhereClause(CsvTransactionsViewDto bean, boolean select) throws DAOException {
		if(bean == null) {
			return "";
		}

		StringBuilder buff = new StringBuilder();
		boolean whereClause = false;

		if (bean.getCashbackAmountDirection() > 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			 buff.append("CASHBACK_AMOUNT_DIRECTION =?");
		}
		if (select == true) {
			
			if (bean.getFleetCountTran() != null && !bean.getFleetCountTran().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("FLEET_COUNT_TRAN=?");
			}
		
			if (bean.getAcquirerMember() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("ACQUIRER_MEMBER=?");
			}
			
			if (bean.getAcquirerName() != null && !bean.getAcquirerName().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("ACQUIRER_NAME=?");
			}
			
			if (bean.getAcquirerBin() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("ACQUIRER_BIN=?");
			}
			
			if (bean.getIssuerMember() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("ISSUER_MEMBER=?");
			}
			
			if (bean.getIssuerName() != null && !bean.getIssuerName().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("ISSUER_NAME=?");
			}
			
			if (bean.getIssuerBin() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("ISSUER_BIN=?");
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
			if (bean.getCardType() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("CARD_TYPE=?");
			}
			
			if (bean.getCardDescription() != null && !bean.getCardDescription().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("CARD_DESCRIPTION=?");
			}
			
			if (bean.getTransactionCode() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("TRANSACTION_CODE=?");
			}
			if (bean.getTransactionDescription() != null && !bean.getTransactionDescription().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("TRANSACTION_DESCRIPTION=?");
			}
			
			if (bean.getTransactionAmount() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("TRAN_AMOUNT=?");
			}
			
			if (bean.getTransactionSystemSeqNumber() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("TRAN_SYSTEM_SEQ_NUMBER=?");
			}
			
			if (bean.getCashbackPresent() != null && !bean.getCashbackPresent().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("CASHBACK_PRESENT=?");
			}
			
			if (bean.getCashbackAmount() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("CASHBACK_AMOUNT=?");
			}
			
			if (bean.getTransactionStatus() != null && !bean.getTransactionStatus().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("TRAN_STATUS=?");
			}
			
			if (bean.getFileStatus() != null && !bean.getFileStatus().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("FILE_STATUS=?");
			}
			
			if (bean.getMessageTypeInd() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("MESSAGE_TYPE_IND=?");
			}
			if (bean.getMerchantCatCode() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("MERCHANT_CAT_CODE=?");
			}
			if (bean.getInterchangeRateDsgn() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("INTCHG_RATE_DSGN=?");
			}
			if (bean.getMessageReasonCode() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("MESSAGE_REASON_CODE=?");
			}
			if (bean.getBillingFee() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("BILLING_FEE=?");
			}
			if (bean.getBillingFeeAmount() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("BILLING_FEE_AMOUNT=?");
			}
			if (bean.getBillingVat() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("BILLING_VAT=?");
			}
			if (bean.getCashbackBillFee() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("CB_BILL_FEE=?");
			}
			if (bean.getCashbackBillFeeAmnt() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("CB_BILL_FEE_AMNT=?");
			}
			if (bean.getCashbackBillVat() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("CB_BILL_VAT=?");
			}
			if (bean.getInterchangeFee() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("INTERCHANGE_FEE=?");
			}
			if (bean.getInterchangeFeeAmount() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("INTERCHANGE_FEE_AMOUNT=?");
			}
			if (bean.getInputVat() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("INPUT_VAT=?");
			}
			
			if (bean.getDestReport() != null && !bean.getDestReport().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("DEST_REPORT=?");
			}
			if (bean.getAmountDirection() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("AMOUNT_DIRECTION=?");
			}
			if (bean.getReportSortSequence() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("REPORT_SORT_SEQUENCE=?");
			}
			if (bean.getCashbackInterchangeFee() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("CB_INTERCHANGE_FEE=?");
			}
			if (bean.getCashbackInterchangeFeeAmount() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("CB_INTERHCANGE_FEE_AMOUNT=?");
			}
			if (bean.getCashbackInputVat() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("CASHBACK_INPUT_VAT=?");
			}

		}
		if(!whereClause && select == false) {
			throw new DAOException("Cannot update delete all rows in CCCOWNER.CSV_TRANSACTIONS_VIEW");
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
				CsvTransactionsViewDto bean = new CsvTransactionsViewDto();
				bean.setCashbackAmountDirection(rs.getInt("CASHBACK_AMOUNT_DIRECTION"));
				bean.setFleetCountTran(rs.getString("FLEET_COUNT_TRAN"));
				bean.setAcquirerMember(rs.getInt("ACQUIRER_MEMBER"));
				bean.setAcquirerName(rs.getString("ACQUIRER_NAME"));
				bean.setAcquirerBin(rs.getInt("ACQUIRER_BIN"));
				bean.setIssuerMember(rs.getInt("ISSUER_MEMBER"));
				bean.setIssuerName(rs.getString("ISSUER_NAME"));
				bean.setIssuerBin(rs.getInt("ISSUER_BIN"));
				bean.setService(rs.getString("SERVICE"));
				bean.setSubService(rs.getString("SUB_SERVICE"));
				bean.setCardType(rs.getInt("CARD_TYPE"));
				bean.setCardDescription(rs.getString("CARD_DESCRIPTION"));
				bean.setTransactionCode(rs.getShort("TRANSACTION_CODE"));
				bean.setTransactionDescription(rs.getString("TRANSACTION_DESCRIPTION"));
				bean.setTransactionAmount(rs.getDouble("TRAN_AMOUNT"));
				bean.setTransactionSystemSeqNumber(rs.getLong("TRAN_SYSTEM_SEQ_NUMBER"));
				bean.setCashbackPresent(rs.getString("CASHBACK_PRESENT"));
				bean.setCashbackAmount(rs.getDouble("CASHBACK_AMOUNT"));
				bean.setTransactionStatus(rs.getString("TRAN_STATUS"));
				bean.setFileStatus(rs.getString("FILE_STATUS"));
				bean.setMessageTypeInd(rs.getInt("MESSAGE_TYPE_IND"));
				bean.setMerchantCatCode(rs.getInt("MERCHANT_CAT_CODE"));
				bean.setInterchangeRateDsgn(rs.getInt("INTCHG_RATE_DSGN"));
				bean.setMessageReasonCode(rs.getInt("MESSAGE_REASON_CODE"));
				bean.setBillingFee(rs.getDouble("BILLING_FEE"));
				bean.setBillingFeeAmount(rs.getDouble("BILLING_FEE_AMOUNT"));
				bean.setBillingVat(rs.getDouble("BILLING_VAT"));
				bean.setCashbackBillFee(rs.getDouble("CB_BILL_FEE"));
				bean.setCashbackBillFeeAmnt(rs.getDouble("CB_BILL_FEE_AMNT"));
				bean.setCashbackBillVat(rs.getDouble("CB_BILL_VAT"));
				bean.setInterchangeFee(rs.getDouble("INTERCHANGE_FEE"));
				bean.setInterchangeFeeAmount(rs.getDouble("INTERCHANGE_FEE_AMOUNT"));
				bean.setInputVat(rs.getDouble("INPUT_VAT"));
				bean.setDestReport(rs.getString("DEST_REPORT"));
				bean.setAmountDirection(rs.getInt("AMOUNT_DIRECTION"));
				bean.setReportSortSequence(rs.getInt("REPORT_SORT_SEQUENCE"));
				bean.setCashbackInterchangeFee(rs.getDouble("CB_INTERCHANGE_FEE"));
				bean.setCashbackInterchangeFeeAmount(rs.getDouble("CB_INTERHCANGE_FEE_AMOUNT"));
				bean.setCashbackInputVat(rs.getDouble("CASHBACK_INPUT_VAT"));
			
				results.add(bean);
			}
			return results;
		} catch (Exception ex) {
			throw new DAOException("Error getting results CCCOWNER.CSV_TRANSACTIONS_VIEW, cause: "
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
	private int setParameters(CsvTransactionsViewDto bean, PreparedStatement ps, int pos, boolean select) throws DAOException {
		if(bean == null) {
			return 1;
		}
		try {
			if (bean.getCashbackAmountDirection() > 0) {
				ps.setInt(pos++, bean.getCashbackAmountDirection());
			}
			if (select == true) {
				if (bean.getFleetCountTran() != null && !bean.getFleetCountTran().isEmpty()) {
					ps.setString(pos++, bean.getFleetCountTran());
				}
			
				if (bean.getAcquirerMember() > 0) {
					ps.setInt(pos++, bean.getAcquirerMember());
				}
				
				if (bean.getAcquirerName() != null && !bean.getAcquirerName().isEmpty()) {
					ps.setString(pos++, bean.getAcquirerName());
				}
				
				if (bean.getAcquirerBin() > 0) {
					ps.setInt(pos++, bean.getAcquirerBin());
				}
				
				if (bean.getIssuerMember() > 0) {
					ps.setInt(pos++, bean.getIssuerMember());
				}
				
				if (bean.getIssuerName() != null && !bean.getIssuerName().isEmpty()) {
					ps.setString(pos++, bean.getIssuerName());
				}
				
				if (bean.getIssuerBin() > 0) {
					ps.setInt(pos++, bean.getIssuerBin());
				}
				if (bean.getService() != null && !bean.getService().isEmpty()) {
					ps.setString(pos++, bean.getService());
				}
				
				if (bean.getSubService() != null && !bean.getSubService().isEmpty()) {
					ps.setString(pos++, bean.getSubService());
				}
				if (bean.getCardType() > 0) {
					ps.setInt(pos++, bean.getCardType());
				}
				
				if (bean.getCardDescription() != null && !bean.getCardDescription().isEmpty()) {
					ps.setString(pos++, bean.getCardDescription());
				}
				
				if (bean.getTransactionCode() > 0) {
					ps.setInt(pos++, bean.getTransactionCode());
				}
				if (bean.getTransactionDescription() != null && !bean.getTransactionDescription().isEmpty()) {
					ps.setString(pos++, bean.getTransactionDescription());
				}
				
				if (bean.getTransactionAmount() > 0) {
					ps.setDouble(pos++, bean.getTransactionAmount());
				}
				
				if (bean.getTransactionSystemSeqNumber() > 0) {
					ps.setLong(pos++, bean.getTransactionSystemSeqNumber());
				}
				
				if (bean.getCashbackPresent() != null && !bean.getCashbackPresent().isEmpty()) {
					ps.setString(pos++, bean.getCashbackPresent());
				}
				
				if (bean.getCashbackAmount() > 0) {
					ps.setDouble(pos++, bean.getCashbackAmount());
				}
				
				if (bean.getTransactionStatus() != null && !bean.getTransactionStatus().isEmpty()) {
					ps.setString(pos++, bean.getTransactionStatus());
				}
				
				if (bean.getFileStatus() != null && !bean.getFileStatus().isEmpty()) {
					ps.setString(pos++, bean.getFileStatus());
				}
				
				if (bean.getMessageTypeInd() > 0) {
					ps.setInt(pos++, bean.getMessageTypeInd());
				}
				if (bean.getMerchantCatCode() > 0) {
					ps.setInt(pos++, bean.getMerchantCatCode());
				}
				if (bean.getInterchangeRateDsgn() > 0) {
					ps.setInt(pos++, bean.getInterchangeRateDsgn());
				}
				if (bean.getMessageReasonCode() > 0) {
					ps.setInt(pos++, bean.getMessageReasonCode());
				}
				if (bean.getBillingFee() > 0) {
					ps.setDouble(pos++, bean.getBillingFee());
				}
				if (bean.getBillingFeeAmount() > 0) {
					ps.setDouble(pos++, bean.getBillingFeeAmount());
				}
				if (bean.getBillingVat() > 0) {
					ps.setDouble(pos++, bean.getBillingVat());
				}
				if (bean.getCashbackBillFee() > 0) {
					ps.setDouble(pos++, bean.getCashbackBillFee());
				}
				if (bean.getCashbackBillFeeAmnt() > 0) {
					ps.setDouble(pos++, bean.getCashbackBillFeeAmnt());
				}
				if (bean.getCashbackBillVat() > 0) {
					ps.setDouble(pos++, bean.getCashbackBillVat());
				}
				if (bean.getInterchangeFee() > 0) {
					ps.setDouble(pos++, bean.getInterchangeFee());
				}
				if (bean.getInterchangeFeeAmount() > 0) {
					ps.setDouble(pos++, bean.getInterchangeFeeAmount());
				}
				if (bean.getInputVat() > 0) {
					ps.setDouble(pos++, bean.getInputVat());
				}
				
				if (bean.getDestReport() != null && !bean.getDestReport().isEmpty()) {
					ps.setString(pos++, bean.getDestReport());
				}
				if (bean.getAmountDirection() > 0) {
					ps.setInt(pos++, bean.getAmountDirection());
				}
				if (bean.getReportSortSequence() > 0) {
					ps.setInt(pos++, bean.getReportSortSequence());
				}
				if (bean.getCashbackInterchangeFee() > 0) {
					ps.setDouble(pos++, bean.getCashbackInterchangeFee());
				}
				if (bean.getCashbackInterchangeFeeAmount() > 0) {
					ps.setDouble(pos++, bean.getCashbackInterchangeFeeAmount());
				}
				if (bean.getCashbackInputVat() > 0) {
					ps.setDouble(pos++, bean.getCashbackInputVat());
				}
			}
			return pos;
		} catch (Exception ex) {
			throw new DAOException("Error getting results CCCOWNER.CSV_TRANSACTIONS_VIEW, cause: "
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
