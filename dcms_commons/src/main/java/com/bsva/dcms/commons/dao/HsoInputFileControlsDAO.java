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

import com.bsva.dcms.commons.dto.HsoInputFileControlsDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
/**
* Data access object interface that defines the methods that must be supported
* by all data access objects.
*
* Created By BSVATools
*/

public class HsoInputFileControlsDAO {
	private String SQL_INSERT = 			"";
	private String SQL_SELECT = 			"";
	private String SQL_UPDATE = 			"";
	private String SQL_DELETE = 			"";
	private String SQL_SELECT_COUNT = 			"";
	private DataSource conn;

	public HsoInputFileControlsDAO(DataSource conn) {
		this.conn = conn;
}

	/**
	 * Create a new record in Database.
	 *
	 * @param bean The Object to be inserted.
	 * @exception SQLException if something is wrong.
	 */
	public void create(HsoInputFileControlsDTO bean) throws DAOException {
		PreparedStatement ps = null;
		int pos = 1;

		try {
			SQL_INSERT = 
			"INSERT INTO CCCOWNER.HSO_INPUT_FILE_CONTROLS (FILE_REF_NUMBER, OUTPUT_DATE, SERVICE, SUB_SERVICE, NUMBER_OF_RECS, NUMBER_CREDITS, NUMBER_DEBITS, CREDIT_VALUE, DEBIT_VALUE, HASH_TOTAL, LAST_FILE_INDICATOR, PROCESS_STATUS, EXTRACTED_COUNT, EXT_CREDITS, EXT_DEBITS, EXT_CREDIT_VALUE, EXT_DEBIT_VALUE, LAST_PROCESS_DATE, NEXT_OUTPUT_DATE, SETTLEMENT_COUNT, LOAD_DATE, ORIGINATING_MEMBER, NEGATIVE_CARD_COUNT, NEGATIVE_DUPLICATE_COUNT, LAST_COMMITED_RECORD_POINTER, EXCEP_REP_PRODUCED_IND, ERROR_FILENAME, SYSTEM_SEQ_NUMBER) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
			//ps = conn.prepareStatement(SQL_INSERT);

			ps.setString(pos++, bean.getFileRefNumber());
			ps.setDate(pos++, new Date(bean.getOutputDate().getTime()));
			ps.setString(pos++, bean.getService());
			ps.setString(pos++, bean.getSubService());
			ps.setInt(pos++, bean.getNumberOfRecs());
			ps.setInt(pos++, bean.getNumberCredits());
			ps.setInt(pos++, bean.getNumberDebits());
			ps.setDouble(pos++, bean.getCreditValue());
			ps.setDouble(pos++, bean.getDebitValue());
			ps.setLong(pos++, bean.getHashTotal());
			ps.setString(pos++, bean.getLastFileIndicator());
			ps.setString(pos++, bean.getProcessStatus());
			ps.setInt(pos++, bean.getExtractedCount());
			ps.setInt(pos++, bean.getExtCredits());
			ps.setInt(pos++, bean.getExtDebits());
			ps.setDouble(pos++, bean.getExtCreditValue());
			ps.setDouble(pos++, bean.getExtDebitValue());
			ps.setDate(pos++, new Date(bean.getLastProcessDate().getTime()));
			ps.setDate(pos++, new Date(bean.getNextOutputDate().getTime()));
			ps.setInt(pos++, bean.getSettlementCount());
			ps.setDate(pos++, new Date(bean.getLoadDate().getTime()));
			ps.setInt(pos++, bean.getOriginatingMember());
			ps.setInt(pos++, bean.getNegativeCardCount());
			ps.setInt(pos++, bean.getNegativeDuplicateCount());
			ps.setInt(pos++, bean.getLastCommitedRecordPointer());
			ps.setString(pos++, bean.getExcepRepProducedInd());
			ps.setString(pos++, bean.getErrorFilename());
			ps.setLong(pos++, bean.getSystemSeqNumber());
			
			ps.execute();

		} catch (Exception ex) {
			throw new DAOException("Error creating CCCOWNER.HSO_INPUT_FILE_CONTROLS, cause: "
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
	public HsoInputFileControlsDTO retrieve(HsoInputFileControlsDTO bean) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int pos = 1;

		try {
			SQL_SELECT = 
			"SELECT FILE_REF_NUMBER, OUTPUT_DATE, SERVICE, SUB_SERVICE, NUMBER_OF_RECS, NUMBER_CREDITS, NUMBER_DEBITS, CREDIT_VALUE, DEBIT_VALUE, HASH_TOTAL, LAST_FILE_INDICATOR, PROCESS_STATUS, EXTRACTED_COUNT, EXT_CREDITS, EXT_DEBITS, EXT_CREDIT_VALUE, EXT_DEBIT_VALUE, LAST_PROCESS_DATE, NEXT_OUTPUT_DATE, SETTLEMENT_COUNT, LOAD_DATE, ORIGINATING_MEMBER, NEGATIVE_CARD_COUNT, NEGATIVE_DUPLICATE_COUNT, LAST_COMMITED_RECORD_POINTER, EXCEP_REP_PRODUCED_IND, ERROR_FILENAME, SYSTEM_SEQ_NUMBER FROM CCCOWNER.HSO_INPUT_FILE_CONTROLS ";
			SQL_SELECT += this.buildWhereClause(bean, true);

			//ps = conn.prepareStatement(SQL_SELECT);
			this.setParameters(bean, ps, pos, true);

			rs = ps.executeQuery();

			List results = this.getResults(rs);
			if (results.size() > 0) {
				return (HsoInputFileControlsDTO) results.get(0);
			} else {
				return null;
			}
		} catch (Exception ex) {
			throw new DAOException("Error retrieving CCCOWNER.HSO_INPUT_FILE_CONTROLS, cause: "
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
	public List<HsoInputFileControlsDTO> retrieveRelated(HsoInputFileControlsDTO bean) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int pos = 1;

		try {
			SQL_SELECT = 
			"SELECT FILE_REF_NUMBER, OUTPUT_DATE, SERVICE, SUB_SERVICE, NUMBER_OF_RECS, NUMBER_CREDITS, NUMBER_DEBITS, CREDIT_VALUE, DEBIT_VALUE, HASH_TOTAL, LAST_FILE_INDICATOR, PROCESS_STATUS, EXTRACTED_COUNT, EXT_CREDITS, EXT_DEBITS, EXT_CREDIT_VALUE, EXT_DEBIT_VALUE, LAST_PROCESS_DATE, NEXT_OUTPUT_DATE, SETTLEMENT_COUNT, LOAD_DATE, ORIGINATING_MEMBER, NEGATIVE_CARD_COUNT, NEGATIVE_DUPLICATE_COUNT, LAST_COMMITED_RECORD_POINTER, EXCEP_REP_PRODUCED_IND, ERROR_FILENAME, SYSTEM_SEQ_NUMBER FROM CCCOWNER.HSO_INPUT_FILE_CONTROLS ";
			SQL_SELECT += this.buildWhereClause(bean, true);

			//ps = conn.prepareStatement(SQL_SELECT);
			this.setParameters(bean, ps, pos, true);

			rs = ps.executeQuery();

			List results = this.getResults(rs);
			if (results.size() > 0) {
				return (List<HsoInputFileControlsDTO>) results;
			} else {
				return null;
			}
		} catch (Exception ex) {
			throw new DAOException("Error retrieving related CCCOWNER.HSO_INPUT_FILE_CONTROLS, cause: "
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
	public List<HsoInputFileControlsDTO> retrieveRelated(HsoInputFileControlsDTO bean, int startRow, int endRow) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int pos = 1;

		try {
	// Oracle specific 
			SQL_SELECT = 
			"SELECT * from (SELECT ROWNUM rn, FILE_REF_NUMBER, OUTPUT_DATE, SERVICE, SUB_SERVICE, NUMBER_OF_RECS, NUMBER_CREDITS, NUMBER_DEBITS, CREDIT_VALUE, DEBIT_VALUE, HASH_TOTAL, LAST_FILE_INDICATOR, PROCESS_STATUS, EXTRACTED_COUNT, EXT_CREDITS, EXT_DEBITS, EXT_CREDIT_VALUE, EXT_DEBIT_VALUE, LAST_PROCESS_DATE, NEXT_OUTPUT_DATE, SETTLEMENT_COUNT, LOAD_DATE, ORIGINATING_MEMBER, NEGATIVE_CARD_COUNT, NEGATIVE_DUPLICATE_COUNT, LAST_COMMITED_RECORD_POINTER, EXCEP_REP_PRODUCED_IND, ERROR_FILENAME, SYSTEM_SEQ_NUMBER FROM CCCOWNER.HSO_INPUT_FILE_CONTROLS ";
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
				return (List<HsoInputFileControlsDTO>) results;
			} else {
				return null;
			}
		} catch (Exception ex) {
			throw new DAOException("Error retrieving related CCCOWNER.HSO_INPUT_FILE_CONTROLS, cause: "
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
	public void update(HsoInputFileControlsDTO bean) throws DAOException {
		PreparedStatement ps = null;
		int pos = 1;
		boolean first = true;

		try {
			SQL_UPDATE = 
			"UPDATE CCCOWNER.HSO_INPUT_FILE_CONTROLS SET ";

	/* dynamic SQL for update */
		if (bean.getFileRefNumber() != null && !bean.getFileRefNumber().isEmpty()) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "FILE_REF_NUMBER=?";
		}
		if (bean.getOutputDate() != null) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "OUTPUT_DATE=?";
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
		if (bean.getNumberOfRecs() > 0) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "NUMBER_OF_RECS=?";
		}
		if (bean.getNumberCredits() > 0) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "NUMBER_CREDITS=?";
		}
		if (bean.getNumberDebits() > 0) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "NUMBER_DEBITS=?";
		}
		if (bean.getCreditValue() > 0.0) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "CREDIT_VALUE=?";
		}
		if (bean.getDebitValue() > 0.0) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "DEBIT_VALUE=?";
		}
		if (bean.getHashTotal() > 0L) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "HASH_TOTAL=?";
		}
		if (bean.getLastFileIndicator() != null && !bean.getLastFileIndicator().isEmpty()) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "LAST_FILE_INDICATOR=?";
		}
		if (bean.getProcessStatus() != null && !bean.getProcessStatus().isEmpty()) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "PROCESS_STATUS=?";
		}
		if (bean.getExtractedCount() > 0) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "EXTRACTED_COUNT=?";
		}
		if (bean.getExtCredits() > 0) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "EXT_CREDITS=?";
		}
		if (bean.getExtDebits() > 0) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "EXT_DEBITS=?";
		}
		if (bean.getExtCreditValue() > 0.0) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "EXT_CREDIT_VALUE=?";
		}
		if (bean.getExtDebitValue() > 0.0) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "EXT_DEBIT_VALUE=?";
		}
		if (bean.getLastProcessDate() != null) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "LAST_PROCESS_DATE=?";
		}
		if (bean.getNextOutputDate() != null) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "NEXT_OUTPUT_DATE=?";
		}
		if (bean.getSettlementCount() > 0) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "SETTLEMENT_COUNT=?";
		}
		if (bean.getLoadDate() != null) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "LOAD_DATE=?";
		}
		if (bean.getOriginatingMember() > 0) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "ORIGINATING_MEMBER=?";
		}
		if (bean.getNegativeCardCount() > 0) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "NEGATIVE_CARD_COUNT=?";
		}
		if (bean.getNegativeDuplicateCount() > 0) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "NEGATIVE_DUPLICATE_COUNT=?";
		}
		if (bean.getLastCommitedRecordPointer() > 0) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "LAST_COMMITED_RECORD_POINTER=?";
		}
		if (bean.getExcepRepProducedInd() != null && !bean.getExcepRepProducedInd().isEmpty()) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "EXCEP_REP_PRODUCED_IND=?";
		}
		if (bean.getErrorFilename() != null && !bean.getErrorFilename().isEmpty()) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "ERROR_FILENAME=?";
		}
		if (bean.getSystemSeqNumber() > 0L) {
				if(!first) {
					SQL_UPDATE += ", ";
				}
				else {
					first = false;
				}
			SQL_UPDATE += "SYSTEM_SEQ_NUMBER=?";
		}
			//SQL_UPDATE += this.buildWhereClause(bean, false);
			//ps = conn.prepareStatement(SQL_UPDATE);


	/* dynamic update parameter */
			if (bean.getFileRefNumber() != null && !bean.getFileRefNumber().isEmpty()) {
				ps.setString(pos++, bean.getFileRefNumber());
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
			if (bean.getNumberOfRecs() > 0) {
				ps.setInt(pos++, bean.getNumberOfRecs());
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
			if (bean.getLastFileIndicator() != null && !bean.getLastFileIndicator().isEmpty()) {
				ps.setString(pos++, bean.getLastFileIndicator());
			}
			if (bean.getProcessStatus() != null && !bean.getProcessStatus().isEmpty()) {
				ps.setString(pos++, bean.getProcessStatus());
			}
			if (bean.getExtractedCount() > 0) {
				ps.setInt(pos++, bean.getExtractedCount());
			}
			if (bean.getExtCredits() > 0) {
				ps.setInt(pos++, bean.getExtCredits());
			}
			if (bean.getExtDebits() > 0) {
				ps.setInt(pos++, bean.getExtDebits());
			}
			if (bean.getExtCreditValue() > 0.0) {
				ps.setDouble(pos++, bean.getExtCreditValue());
			}
			if (bean.getExtDebitValue() > 0.0) {
				ps.setDouble(pos++, bean.getExtDebitValue());
			}
			if (bean.getLastProcessDate() != null) {
				ps.setDate(pos++, new Date(bean.getLastProcessDate().getTime()));
			}
			if (bean.getNextOutputDate() != null) {
				ps.setDate(pos++, new Date(bean.getNextOutputDate().getTime()));
			}
			if (bean.getSettlementCount() > 0) {
				ps.setInt(pos++, bean.getSettlementCount());
			}
			if (bean.getLoadDate() != null) {
				ps.setDate(pos++, new Date(bean.getLoadDate().getTime()));
			}
			if (bean.getOriginatingMember() > 0) {
				ps.setInt(pos++, bean.getOriginatingMember());
			}
			if (bean.getNegativeCardCount() > 0) {
				ps.setInt(pos++, bean.getNegativeCardCount());
			}
			if (bean.getNegativeDuplicateCount() > 0) {
				ps.setInt(pos++, bean.getNegativeDuplicateCount());
			}
			if (bean.getLastCommitedRecordPointer() > 0) {
				ps.setInt(pos++, bean.getLastCommitedRecordPointer());
			}
			if (bean.getExcepRepProducedInd() != null && !bean.getExcepRepProducedInd().isEmpty()) {
				ps.setString(pos++, bean.getExcepRepProducedInd());
			}
			if (bean.getErrorFilename() != null && !bean.getErrorFilename().isEmpty()) {
				ps.setString(pos++, bean.getErrorFilename());
			}
			if (bean.getSystemSeqNumber() > 0L) {
				ps.setLong(pos++, bean.getSystemSeqNumber());
			}
			//pos = this.setParameters(bean, ps, pos, false);

			ps.executeUpdate();

		} catch (Exception ex) {
			throw new DAOException("Error updating CCCOWNER.HSO_INPUT_FILE_CONTROLS, cause: "
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
	public void delete(HsoInputFileControlsDTO bean) throws DAOException {
		PreparedStatement ps = null;
	//		throw new DAOException("Delete not supported - If you need this functionality uncomment code below and remove throw above");
			//TODO - *** update table to include unique keys and then remove commented code below and throw command above ***

		int pos = 1;

		try {
			SQL_DELETE = 
			"DELETE FROM CCCOWNER.HSO_INPUT_FILE_CONTROLS";
			SQL_DELETE += this.buildWhereClause(bean, true);

			//ps = conn.prepareStatement(SQL_DELETE);

			pos = this.setParameters(bean, ps, pos, true);

			ps.executeUpdate();

		} catch (Exception ex) {
			throw new DAOException("Error deleting CCCOWNER.HSO_INPUT_FILE_CONTROLS, cause: "
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
	public void deleteAgeing(java.util.Date date) throws DAOException { 
		PreparedStatement ps = null;

		int pos = 1;

		try {
			SQL_DELETE = 
			"DELETE FROM CCCOWNER.HSO_INPUT_FILE_CONTROLS WHERE TO_DATE(SUBSTR(FILE_REF_NUMBER,9,8),'YYYYMMDD') < ?";
			

			//ps = conn.prepareStatement(SQL_DELETE);
            ps.setDate(pos++, new Date(date.getTime()));
			

			ps.executeUpdate();

		} catch (Exception ex) {
			throw new DAOException("Error deleting CCCOWNER.HSO_INPUT_FILE_CONTROLS, cause: "
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
	public int retrieveRowCount(HsoInputFileControlsDTO bean) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count=0;

		int pos = 1;

		try {
			SQL_SELECT_COUNT = 
			"SELECT COUNT(*) AS count FROM CCCOWNER.HSO_INPUT_FILE_CONTROLS ";
			SQL_SELECT_COUNT += this.buildWhereClause(bean, true);

			//ps = conn.prepareStatement(SQL_SELECT_COUNT);
			this.setParameters(bean, ps, pos, true);

			rs = ps.executeQuery();

			while (rs.next()) {
				count=rs.getInt("count");
			}
		} catch (Exception ex) {
			throw new DAOException("Error retrieving CCCOWNER.HSO_INPUT_FILE_CONTROLS, cause: "
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
				HsoInputFileControlsDTO bean = new HsoInputFileControlsDTO();
				bean.setFileRefNumber(rs.getString("FILE_REF_NUMBER"));
				bean.setOutputDate(rs.getDate("OUTPUT_DATE"));
				bean.setService(rs.getString("SERVICE"));
				bean.setSubService(rs.getString("SUB_SERVICE"));
				bean.setNumberOfRecs(rs.getInt("NUMBER_OF_RECS"));
				bean.setNumberCredits(rs.getInt("NUMBER_CREDITS"));
				bean.setNumberDebits(rs.getInt("NUMBER_DEBITS"));
				bean.setCreditValue(rs.getDouble("CREDIT_VALUE"));
				bean.setDebitValue(rs.getDouble("DEBIT_VALUE"));
				bean.setHashTotal(rs.getLong("HASH_TOTAL"));
				bean.setLastFileIndicator(rs.getString("LAST_FILE_INDICATOR"));
				bean.setProcessStatus(rs.getString("PROCESS_STATUS"));
				bean.setExtractedCount(rs.getInt("EXTRACTED_COUNT"));
				bean.setExtCredits(rs.getInt("EXT_CREDITS"));
				bean.setExtDebits(rs.getInt("EXT_DEBITS"));
				bean.setExtCreditValue(rs.getDouble("EXT_CREDIT_VALUE"));
				bean.setExtDebitValue(rs.getDouble("EXT_DEBIT_VALUE"));
				bean.setLastProcessDate(rs.getDate("LAST_PROCESS_DATE"));
				bean.setNextOutputDate(rs.getDate("NEXT_OUTPUT_DATE"));
				bean.setSettlementCount(rs.getInt("SETTLEMENT_COUNT"));
				bean.setLoadDate(rs.getDate("LOAD_DATE"));
				bean.setOriginatingMember(rs.getInt("ORIGINATING_MEMBER"));
				bean.setNegativeCardCount(rs.getInt("NEGATIVE_CARD_COUNT"));
				bean.setNegativeDuplicateCount(rs.getInt("NEGATIVE_DUPLICATE_COUNT"));
				bean.setLastCommitedRecordPointer(rs.getInt("LAST_COMMITED_RECORD_POINTER"));
				bean.setExcepRepProducedInd(rs.getString("EXCEP_REP_PRODUCED_IND"));
				bean.setErrorFilename(rs.getString("ERROR_FILENAME"));
				bean.setSystemSeqNumber(rs.getLong("SYSTEM_SEQ_NUMBER"));
				results.add(bean);
			}
			return results;
		} catch (Exception ex) {
			throw new DAOException("Error getting results CCCOWNER.HSO_INPUT_FILE_CONTROLS, cause: "
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
	private String buildWhereClause(HsoInputFileControlsDTO bean, boolean select) throws DAOException {
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
			 buff.append("FILE_REF_NUMBER=?");
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
		if (bean.getSystemSeqNumber() > 0L) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			 buff.append("SYSTEM_SEQ_NUMBER=?");
		}
		if (select == true) {
			if (bean.getOutputDate() != null) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("OUTPUT_DATE=?");
			}
			if (bean.getNumberOfRecs() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("NUMBER_OF_RECS=?");
			}
			if (bean.getNumberCredits() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("NUMBER_CREDITS=?");
			}
			if (bean.getNumberDebits() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("NUMBER_DEBITS=?");
			}
			if (bean.getCreditValue() > 0.0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("CREDIT_VALUE=?");
			}
			if (bean.getDebitValue() > 0.0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("DEBIT_VALUE=?");
			}
			if (bean.getHashTotal() > 0L) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("HASH_TOTAL=?");
			}
			if (bean.getLastFileIndicator() != null && !bean.getLastFileIndicator().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("LAST_FILE_INDICATOR=?");
			}
			if (bean.getProcessStatus() != null && !bean.getProcessStatus().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("PROCESS_STATUS=?");
			}
			if (bean.getExtractedCount() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("EXTRACTED_COUNT=?");
			}
			if (bean.getExtCredits() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("EXT_CREDITS=?");
			}
			if (bean.getExtDebits() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("EXT_DEBITS=?");
			}
			if (bean.getExtCreditValue() > 0.0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("EXT_CREDIT_VALUE=?");
			}
			if (bean.getExtDebitValue() > 0.0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("EXT_DEBIT_VALUE=?");
			}
			if (bean.getLastProcessDate() != null) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("LAST_PROCESS_DATE=?");
			}
			if (bean.getNextOutputDate() != null) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("NEXT_OUTPUT_DATE=?");
			}
			if (bean.getSettlementCount() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("SETTLEMENT_COUNT=?");
			}
			if (bean.getLoadDate() != null) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("LOAD_DATE=?");
			}
			if (bean.getOriginatingMember() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("ORIGINATING_MEMBER=?");
			}
			if (bean.getNegativeCardCount() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("NEGATIVE_CARD_COUNT=?");
			}
			if (bean.getNegativeDuplicateCount() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("NEGATIVE_DUPLICATE_COUNT=?");
			}
			if (bean.getLastCommitedRecordPointer() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("LAST_COMMITED_RECORD_POINTER=?");
			}
			if (bean.getExcepRepProducedInd() != null && !bean.getExcepRepProducedInd().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("EXCEP_REP_PRODUCED_IND=?");
			}
			if (bean.getErrorFilename() != null && !bean.getErrorFilename().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				 buff.append("ERROR_FILENAME=?");
			}
		}
		if(!whereClause && select == false) {
			throw new DAOException("Cannot update delete all rows in CCCOWNER.HSO_INPUT_FILE_CONTROLS");
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
	private int setParameters(HsoInputFileControlsDTO bean, PreparedStatement ps, int pos, boolean select) throws DAOException {
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
			if (bean.getSystemSeqNumber() > 0L) {
				ps.setLong(pos++, bean.getSystemSeqNumber());
			}
			if (select == true) {
				if (bean.getOutputDate() != null) {
					ps.setDate(pos++, new Date(bean.getOutputDate().getTime()));
				}
				if (bean.getNumberOfRecs() > 0) {
					ps.setInt(pos++, bean.getNumberOfRecs());
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
				if (bean.getLastFileIndicator() != null && !bean.getLastFileIndicator().isEmpty()) {
					ps.setString(pos++, bean.getLastFileIndicator());
				}
				if (bean.getProcessStatus() != null && !bean.getProcessStatus().isEmpty()) {
					ps.setString(pos++, bean.getProcessStatus());
				}
				if (bean.getExtractedCount() > 0) {
					ps.setInt(pos++, bean.getExtractedCount());
				}
				if (bean.getExtCredits() > 0) {
					ps.setInt(pos++, bean.getExtCredits());
				}
				if (bean.getExtDebits() > 0) {
					ps.setInt(pos++, bean.getExtDebits());
				}
				if (bean.getExtCreditValue() > 0.0) {
					ps.setDouble(pos++, bean.getExtCreditValue());
				}
				if (bean.getExtDebitValue() > 0.0) {
					ps.setDouble(pos++, bean.getExtDebitValue());
				}
				if (bean.getLastProcessDate() != null) {
					ps.setDate(pos++, new Date(bean.getLastProcessDate().getTime()));
				}
				if (bean.getNextOutputDate() != null) {
					ps.setDate(pos++, new Date(bean.getNextOutputDate().getTime()));
				}
				if (bean.getSettlementCount() > 0) {
					ps.setInt(pos++, bean.getSettlementCount());
				}
				if (bean.getLoadDate() != null) {
					ps.setDate(pos++, new Date(bean.getLoadDate().getTime()));
				}
				if (bean.getOriginatingMember() > 0) {
					ps.setInt(pos++, bean.getOriginatingMember());
				}
				if (bean.getNegativeCardCount() > 0) {
					ps.setInt(pos++, bean.getNegativeCardCount());
				}
				if (bean.getNegativeDuplicateCount() > 0) {
					ps.setInt(pos++, bean.getNegativeDuplicateCount());
				}
				if (bean.getLastCommitedRecordPointer() > 0) {
					ps.setInt(pos++, bean.getLastCommitedRecordPointer());
				}
				if (bean.getExcepRepProducedInd() != null && !bean.getExcepRepProducedInd().isEmpty()) {
					ps.setString(pos++, bean.getExcepRepProducedInd());
				}
				if (bean.getErrorFilename() != null && !bean.getErrorFilename().isEmpty()) {
					ps.setString(pos++, bean.getErrorFilename());
				}
			}
			return pos;
		} catch (Exception ex) {
			throw new DAOException("Error getting results CCCOWNER.HSO_INPUT_FILE_CONTROLS, cause: "
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
