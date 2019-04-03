package com.bsva.dcms.commons.dao;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bsva.dao.CsfMembersDao;
import com.bsva.dcms.commons.dto.CSFMembersDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.entities.CsfMembers;
/**
 * Data access object interface that defines the methods that must be supported
 * by all data access objects.
 *
 * Created By BSVATools
 */

public class CSFMembersDAO{

	private Map<String,Object> map = new HashMap<>();
	//private CsfMembersRepository csfmembersDao = DaoFactory.csfMembersInstance();
	
	private CsfMembersDao csfmembersDao = new CsfMembersDao();
	
	//private CsfMembersRepository csfmembersDao = DaoFactory.csfMembersInstance();
	

	public CSFMembersDAO() {

	}

	/**
	 * Create a new record in Database.
	 *
	 * @param bean The Object to be inserted.
	 * @exception SQLException if something is wrong.
	 */

	public CSFMembersDTO create(CSFMembersDTO bean) throws DAOException {

		try {

			CsfMembers member = new CsfMembers();
			member.setMemberNo(bean.getMemberNo());			
			member.setBankCode(String.valueOf(bean.getBankCode()));
			member.setMemberName(bean.getMemberName());
			member.setAbbrevMemberName(bean.getAbbrevMemberName());
			member.setMnemonicMemberName(bean.getMnemonicMemberName());
			member.setMemberAddress1(bean.getMemberAddress1());
			member.setMemberAddress2(bean.getMemberAddress2());
			member.setMemberAddress3(bean.getMemberAddress3());
			member.setMemberAddress4(bean.getMemberAddress4());
			member.setMemberStatus(bean.getMemberStatus());
			member.setMemberTapeId(bean.getMemberTapeId());
			member.setContactName(bean.getContactName());
			member.setVatRegNo(bean.getVatRegNo());
			member.setOriginatingBankId(bean.getOriginatingBankId());
			member.setProcessorId(bean.getProcessorId());
			member.setTieredItemCharge(new BigDecimal(bean.getTieredItemCharge()));
			member.setIncfOutputRequired(bean.getIncfOutputRequired());
			member.setMonthsUntilCisBinDeletion((short) bean.getMonthsUntilCisBinDeletion());
			member.setTieredItemChargeBelow(new BigDecimal(bean.getTieredItemChargeBelow()));
			member.setTieredItemChargeAbove(new BigDecimal(bean.getTieredItemChargeAbove()));
			member.setNegCardDataRequired(bean.getNegCardDataRequired());
			csfmembersDao.create(member);

			return bean;
		} catch (Exception ex) {
			throw new DAOException("Error creating CCCOWNER.CSF_MEMBERS, cause: "
					+ ex.getMessage(), ex);
		} 
	}
	/**
	 * Retrieve a record from Database.
	 *
	 * @param bean The Object to be retrieved.
	 * @exception SQLException if something is wrong.
	 */

	public CSFMembersDTO retrieve(CSFMembersDTO bean) throws DAOException {
		CSFMembersDTO cSFMembersDTO = new CSFMembersDTO();
		try {
			String sql = "SELECT s FROM CsfMembers s "+ buildWhereClause(bean, true);
			CsfMembers members = csfmembersDao.executeQueryParametersSingle(sql, map);
			if(members.getAbbrevMemberName() != null){
			cSFMembersDTO.setAbbrevMemberName(members.getAbbrevMemberName());
			}
			if(members.getBankCode() != null){
			cSFMembersDTO.setBankCode(Integer.valueOf(members.getBankCode()));
			}
			if(members.getContactName() != null){
			cSFMembersDTO.setContactName(members.getContactName());
			}
			if(members.getIncfOutputRequired() != null){
			cSFMembersDTO.setIncfOutputRequired(members.getIncfOutputRequired());
			}
			if(members.getMemberAddress1() != null){
			cSFMembersDTO.setMemberAddress1(members.getMemberAddress1());
			}
			if(members.getMemberAddress2() != null){
			cSFMembersDTO.setMemberAddress2(members.getMemberAddress2());
			}
			if(members.getMemberAddress3() != null){
			cSFMembersDTO.setMemberAddress3(members.getMemberAddress3());
			}
			if(members.getMemberAddress4() != null){
			cSFMembersDTO.setMemberAddress4(members.getMemberAddress4());
			}
			if(members.getMemberName() != null){
			cSFMembersDTO.setMemberName(members.getMemberName());
			}
			if(members.getMemberNo() != null){
			cSFMembersDTO.setMemberNo(members.getMemberNo());
			}
			if(members.getMemberStatus() != null){
			cSFMembersDTO.setMemberStatus(members.getMemberStatus());
			}
			if(members.getMemberTapeId() != null){
			cSFMembersDTO.setMemberTapeId(members.getMemberTapeId());
			}
			if(members.getMnemonicMemberName() != null){
			cSFMembersDTO.setMnemonicMemberName(members.getMnemonicMemberName());
			}
			if(members.getMonthsUntilCisBinDeletion() != null){
			cSFMembersDTO.setMonthsUntilCisBinDeletion(members.getMonthsUntilCisBinDeletion().intValue());
			}
			if(members.getNegCardDataRequired() != null){
			cSFMembersDTO.setNegCardDataRequired(members.getNegCardDataRequired());
			}
			if(members.getOriginatingBankId() != null){
			cSFMembersDTO.setOriginatingBankId(members.getOriginatingBankId());
			}
			if(members.getProcessorId() != null){
			cSFMembersDTO.setProcessorId(members.getProcessorId().intValue());
			}
			if(members.getTieredItemCharge() != null){
			cSFMembersDTO.setTieredItemCharge(members.getTieredItemCharge().intValue());
			}
			if(members.getTieredItemChargeAbove() != null){
			cSFMembersDTO.setTieredItemChargeAbove(members.getTieredItemChargeAbove().intValue());
			}
			if(members.getTieredItemChargeBelow() != null){
			cSFMembersDTO.setTieredItemChargeBelow(members.getTieredItemChargeBelow().intValue());
			}
			if(members.getVatRegNo() != null){
			cSFMembersDTO.setVatRegNo(members.getVatRegNo());
			}
			map.clear();
			return cSFMembersDTO;

		} catch (Exception ex) {
			throw new DAOException("Error retrieving CCCOWNER.CSF_MEMBERS, cause: "
					+ ex.getMessage(), ex);
		}
	}

	/**
	 * Retrieve a list of records from Database.
	 *
	 * @param bean The List of Objects to be retrieved.
	 * @exception SQLException if something is wrong.
	 */

	public List<CSFMembersDTO> retrieveRelated(CSFMembersDTO bean) throws DAOException {
		List<CSFMembersDTO> dtoList = new ArrayList<>();
		CSFMembersDTO cSFMembersDTO = null;
		try {
			String sql = "SELECT s FROM CsfMembers s "+ buildWhereClause(bean, true);
			List<CsfMembers> csfMembers2 = csfmembersDao.executeQueryParameters(sql, map);
			for (CsfMembers members : csfMembers2) {
				
				cSFMembersDTO = new CSFMembersDTO();
				
				if(members.getAbbrevMemberName() != null){
					cSFMembersDTO.setAbbrevMemberName(members.getAbbrevMemberName());
					}
					if(members.getBankCode() != null){
					cSFMembersDTO.setBankCode(Integer.valueOf(members.getBankCode()));
					}
					if(members.getContactName() != null){
					cSFMembersDTO.setContactName(members.getContactName());
					}
					if(members.getIncfOutputRequired() != null){
					cSFMembersDTO.setIncfOutputRequired(members.getIncfOutputRequired());
					}
					if(members.getMemberAddress1() != null){
					cSFMembersDTO.setMemberAddress1(members.getMemberAddress1());
					}
					if(members.getMemberAddress2() != null){
					cSFMembersDTO.setMemberAddress2(members.getMemberAddress2());
					}
					if(members.getMemberAddress3() != null){
					cSFMembersDTO.setMemberAddress3(members.getMemberAddress3());
					}
					if(members.getMemberAddress4() != null){
					cSFMembersDTO.setMemberAddress4(members.getMemberAddress4());
					}
					if(members.getMemberName() != null){
					cSFMembersDTO.setMemberName(members.getMemberName());
					}
					if(members.getMemberNo() != null){
					cSFMembersDTO.setMemberNo(members.getMemberNo());
					}
					if(members.getMemberStatus() != null){
					cSFMembersDTO.setMemberStatus(members.getMemberStatus());
					}
					if(members.getMemberTapeId() != null){
					cSFMembersDTO.setMemberTapeId(members.getMemberTapeId());
					}
					if(members.getMnemonicMemberName() != null){
					cSFMembersDTO.setMnemonicMemberName(members.getMnemonicMemberName());
					}
					if(members.getMonthsUntilCisBinDeletion() != null){
					cSFMembersDTO.setMonthsUntilCisBinDeletion(members.getMonthsUntilCisBinDeletion().intValue());
					}
					if(members.getNegCardDataRequired() != null){
					cSFMembersDTO.setNegCardDataRequired(members.getNegCardDataRequired());
					}
					if(members.getOriginatingBankId() != null){
					cSFMembersDTO.setOriginatingBankId(members.getOriginatingBankId());
					}
					if(members.getProcessorId() != null){
					cSFMembersDTO.setProcessorId(members.getProcessorId().intValue());
					}
					if(members.getTieredItemCharge() != null){
					cSFMembersDTO.setTieredItemCharge(members.getTieredItemCharge().intValue());
					}
					if(members.getTieredItemChargeAbove() != null){
					cSFMembersDTO.setTieredItemChargeAbove(members.getTieredItemChargeAbove().intValue());
					}
					if(members.getTieredItemChargeBelow() != null){
					cSFMembersDTO.setTieredItemChargeBelow(members.getTieredItemChargeBelow().intValue());
					}
					if(members.getVatRegNo() != null){
					cSFMembersDTO.setVatRegNo(members.getVatRegNo());
					}				
					dtoList.add(cSFMembersDTO);

			}		
			map.clear();
			return dtoList;

		} catch (Exception ex) {
			throw new DAOException("Error retrieving related CCCOWNER.CSF_MEMBERS, cause: "
					+ ex.getMessage(), ex);
		} 

	}

	/**
	 * Update a record in Database.
	 *
	 * @param bean The Object to be updated.
	 * @exception SQLException if something is wrong.
	 */

	public void update(CSFMembersDTO bean) throws DAOException {
		
		CsfMembers member = new CsfMembers();
		member.setMemberNo(bean.getMemberNo());			
		member.setBankCode(String.valueOf(bean.getBankCode()));
		member.setMemberName(bean.getMemberName());
		member.setAbbrevMemberName(bean.getAbbrevMemberName());
		member.setMnemonicMemberName(bean.getMnemonicMemberName());
		member.setMemberAddress1(bean.getMemberAddress1());
		member.setMemberAddress2(bean.getMemberAddress2());
		member.setMemberAddress3(bean.getMemberAddress3());
		member.setMemberAddress4(bean.getMemberAddress4());
		member.setMemberStatus(bean.getMemberStatus());
		member.setMemberTapeId(bean.getMemberTapeId());
		member.setContactName(bean.getContactName());
		member.setVatRegNo(bean.getVatRegNo());
		member.setOriginatingBankId(bean.getOriginatingBankId());
		member.setProcessorId(bean.getProcessorId());
		member.setTieredItemCharge(new BigDecimal(bean.getTieredItemCharge()));
		member.setIncfOutputRequired(bean.getIncfOutputRequired());
		member.setMonthsUntilCisBinDeletion((short) bean.getMonthsUntilCisBinDeletion());
		member.setTieredItemChargeBelow(new BigDecimal(bean.getTieredItemChargeBelow()));
		member.setTieredItemChargeAbove(new BigDecimal(bean.getTieredItemChargeAbove()));
		member.setNegCardDataRequired(bean.getNegCardDataRequired());
		csfmembersDao.update(member);


	}
	/**
	 * Delete a record in Database.
	 *
	 * @param bean The Object to be deleted.
	 * @exception SQLException if something is wrong.
	 */

	
	public void delete(CSFMembersDTO bean) throws DAOException {

			try {

				CsfMembers member = new CsfMembers();
				member.setMemberNo(bean.getMemberNo());			
				member.setBankCode(String.valueOf(bean.getBankCode()));
				member.setMemberName(bean.getMemberName());
				member.setAbbrevMemberName(bean.getAbbrevMemberName());
				member.setMnemonicMemberName(bean.getMnemonicMemberName());
				member.setMemberAddress1(bean.getMemberAddress1());
				member.setMemberAddress2(bean.getMemberAddress2());
				member.setMemberAddress3(bean.getMemberAddress3());
				member.setMemberAddress4(bean.getMemberAddress4());
				member.setMemberStatus(bean.getMemberStatus());
				member.setMemberTapeId(bean.getMemberTapeId());
				member.setContactName(bean.getContactName());
				member.setVatRegNo(bean.getVatRegNo());
				member.setOriginatingBankId(bean.getOriginatingBankId());
				member.setProcessorId(bean.getProcessorId());
				member.setTieredItemCharge(new BigDecimal(bean.getTieredItemCharge()));
				member.setIncfOutputRequired(bean.getIncfOutputRequired());
				member.setMonthsUntilCisBinDeletion((short) bean.getMonthsUntilCisBinDeletion());
				member.setTieredItemChargeBelow(new BigDecimal(bean.getTieredItemChargeBelow()));
				member.setTieredItemChargeAbove(new BigDecimal(bean.getTieredItemChargeAbove()));
				member.setNegCardDataRequired(bean.getNegCardDataRequired());
				csfmembersDao.delete(member);

				
			} catch (Exception ex) {
				throw new DAOException("Error creating CCCOWNER.CSF_MEMBERS, cause: "
						+ ex.getMessage(), ex);
			} 
		}

	/**
	 * Populate the query ResultSet.
	 *
	 * @param rs The ResultSet.
	 * @exception SQLException if something is wrong.
	 */
	
	/**
	 * Build a Dynamic Where Clause.
	 *
	 * @param bean The Object to be used.
	 * @param select Is the where clause for a Query or Update.
	 * @exception SQLException if something is wrong.
	 */
	private String buildWhereClause(CSFMembersDTO bean, boolean select) throws DAOException {
		if(bean == null) {
			return "";
		}

		StringBuilder buff = new StringBuilder();
		boolean whereClause = false;
		if (select == true) {

		if (bean.getBankCode() > 0) {
			if(!whereClause) {
				whereClause = true;
				buff.append(" WHERE ");
			}
			else {
				buff.append(" AND ");
			}
			
			buff.append("s.bankCode =:bankCode");     
			map.put("bankCode",String.valueOf(bean.getBankCode()));	

		}
				
			if (bean.getMemberNo() != null && !bean.getMemberNo().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				
				buff.append("s.memberNo =:memberNo");
				map.put("memberNo",bean.getMemberNo());
			}
			if (bean.getMemberName() != null && !bean.getMemberName().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				
				buff.append("s.memberName =:memberName");
				map.put("memberName",bean.getMemberName());
			}
			if (bean.getAbbrevMemberName() != null && !bean.getAbbrevMemberName().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				
				buff.append("s.abbrevMemberName =:abbrevMemberName");
				map.put("abbrevMemberName",bean.getAbbrevMemberName());
			}
			if (bean.getMnemonicMemberName() != null && !bean.getMnemonicMemberName().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				
				buff.append("s.mnemonicMemberName =:mnemonicMemberName");
				map.put("mnemonicMemberName",bean.getMnemonicMemberName());

			}
			if (bean.getMemberAddress1() != null && !bean.getMemberAddress1().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				
				buff.append("s.memberAddress1 =:memberAddress1");
				map.put("memberAddress1",bean.getMemberAddress1());
			}
			if (bean.getMemberAddress2() != null && !bean.getMemberAddress2().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				
				buff.append("s.memberAddress2 =:memberAddress2");
				map.put("memberAddress2",bean.getMemberAddress2());

			}
			if (bean.getMemberAddress3() != null && !bean.getMemberAddress3().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				
				buff.append("s.memberAddress3 =:memberAddress3");
				map.put("memberAddress3",bean.getMemberAddress3());
			}
			if (bean.getMemberAddress4() != null && !bean.getMemberAddress4().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				
				buff.append("s.memberAddress4 =:memberAddress4");
				map.put("memberAddress4",bean.getMemberAddress4());
			}
			if (bean.getMemberStatus() != null && !bean.getMemberStatus().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				
				buff.append("s.memberStatus =:memberStatus");
				map.put("memberStatus",bean.getMemberStatus());
			}
			if (bean.getMemberTapeId() != null && !bean.getMemberTapeId().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				
				buff.append("s.memberTapeId =:memberTapeId");
				map.put("memberTapeId",bean.getMemberTapeId());
			}
			if (bean.getContactName() != null && !bean.getContactName().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				
				buff.append("s.contactName =:contactName");
				map.put("contactName",bean.getContactName());
			}
			if (bean.getVatRegNo() != null && !bean.getVatRegNo().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				
				buff.append("s.vatRegNo =:vatRegNo");
				map.put("vatRegNo",bean.getVatRegNo());
			}
			if (bean.getOriginatingBankId() != null && !bean.getOriginatingBankId().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				
				buff.append("s.originatingBankId =:originatingBankId");
				map.put("originatingBankId",bean.getOriginatingBankId());

			}
			if (bean.getProcessorId() > 0L) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				
				buff.append("s.processorId =:processorId");
				map.put("processorId",String.valueOf(bean.getProcessorId()));
			}
			if (bean.getTieredItemCharge() > 0.0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				
				buff.append("s.tieredItemCharge =:tieredItemCharge");
				map.put("tieredItemCharge",String.valueOf(bean.getTieredItemCharge()));
			}
			if (bean.getIncfOutputRequired() != null && !bean.getIncfOutputRequired().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				
				buff.append("s.incfOutputRequired =:incfOutputRequired");
				map.put("incfOutputRequired",String.valueOf(bean.getIncfOutputRequired()));
			}
			if (bean.getMonthsUntilCisBinDeletion() > 0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				
				buff.append("s.monthsUntilCisBinDeletion =:monthsUntilCisBinDeletion");
				map.put("monthsUntilCisBinDeletion",String.valueOf(bean.getMonthsUntilCisBinDeletion()));
			}
			if (bean.getTieredItemChargeBelow() > 0.0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				
				buff.append("s.tieredItemChargeBelow =:tieredItemChargeBelow");
				map.put("tieredItemChargeBelow",String.valueOf(bean.getTieredItemChargeBelow()));
			}
			if (bean.getTieredItemChargeAbove() > 0.0) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				
				buff.append("s.tieredItemChargeAbove =:tieredItemChargeAbove");
				map.put("tieredItemChargeAbove",String.valueOf(bean.getTieredItemChargeAbove()));
			}
			if (bean.getNegCardDataRequired() != null && !bean.getNegCardDataRequired().isEmpty()) {
				if(!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}
				
				buff.append("s.negCardDataRequired =:negCardDataRequired");
				map.put("negCardDataRequired",bean.getNegCardDataRequired());
			}
			
			if (map != null && !map.isEmpty()) {
		          for (Map.Entry<String,Object> entry : map.entrySet()) {
		        	  //System.out.println("The members Key is : "+entry.getKey() +"The members Value is : "+entry.getValue().toString());
		          }
		      }
		}
		if(!whereClause && select == false) {
			throw new DAOException("Cannot update delete all rows in CCCOWNER.CSF_MEMBERS");
		}
		return buff.toString();
	}

}
