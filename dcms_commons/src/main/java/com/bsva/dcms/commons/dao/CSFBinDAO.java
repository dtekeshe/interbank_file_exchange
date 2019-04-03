package com.bsva.dcms.commons.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;

import com.bsva.dao.CsfBinsDao;
import com.bsva.dcms.commons.dto.CSFBINTotalsDTO;
import com.bsva.dcms.commons.dto.CSFBinsDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.entities.CsfBins;
import com.bsva.entities.CsfMembers;
import com.bsva.entities.v02.startofday.CsfBinsEntity;

import java.sql.SQLException;

/**
 * @author AugustineA
 *
 */
public class CSFBinDAO {
	Map<String, Object> parameters = new HashMap<String, Object>();

	// private CsfBinsRepository csfBinDao = DaoFactory.csfBinsInstance();
	private CsfBinsDao csfBinsDao = new CsfBinsDao();

	public CSFBinDAO() {

	}

	public void create(CSFBinsDTO csfBinsDTO) throws DAOException {

		CsfBins csfbin = new CsfBins();
		CsfMembers csfMember = new CsfMembers();
		csfMember.setBankCode(String.valueOf(csfBinsDTO.getCsfMembersDTO().getBankCode()));
		csfbin.setBinNo(csfBinsDTO.getBinNo());
		csfbin.setBinDescription(csfBinsDTO.getBinDescription());
		csfbin.setBankCode(csfMember);
		csfbin.setCardType(csfBinsDTO.getCardType());
		csfbin.setLimit1(new BigDecimal(csfBinsDTO.getLimit1()));
		csfbin.setLimit2(new BigDecimal(csfBinsDTO.getLimit2()));
		csfbin.setFloorLimit(new BigDecimal(csfBinsDTO.getFloorLimit()));
		csfbin.setRouting((short) csfBinsDTO.getRouting());
		csfbin.setCreatedBy(csfBinsDTO.getCreatedBy());
		csfbin.setCreatedDate(csfBinsDTO.getCreatedDate());
		csfbin.setModifiedBy(csfBinsDTO.getModifiedBy());
		csfbin.setModifiedDate(csfBinsDTO.getModifiedDate());
		// csfbin.setSubService(csfBinsDTO.getSubService());
		csfbin.setFinalDeletionDate(csfBinsDTO.getFirstDeletionDate());
		csfbin.setDaysBeforefinalDeletionDate((short) csfBinsDTO.getDaysBeforeFirstDeletionDate());
		csfbin.setFinalDeletionDate(csfBinsDTO.getFinalDeletionDate());
		csfbin.setDaysBeforefinalDeletionDate((short) csfBinsDTO.getDaysBeforeFinalDeletionDate());
		csfbin.setActiveInd(csfBinsDTO.getActiveInd());
		csfbin.setAcqIssBoth(csfBinsDTO.getAcqIssBoth());

		csfBinsDao.create(csfbin);

	}

	/* Retrieve */
	public CSFBinsDTO retrieve(CSFBinsDTO dto) throws DAOException {
		try {
			CSFBinsDTO cSFBinsDTO = new CSFBinsDTO();
			String sql = "SELECT c FROM CsfBins c " + buildWhereClause(dto, true);
			CsfBins csfbin = csfBinsDao.executeQueryParametersSingle(sql, parameters);
			if (csfbin.getBinNo() != null) {
				cSFBinsDTO.setBinNo(csfbin.getBinNo());
			}
			if (csfbin.getBinDescription() != null) {
				cSFBinsDTO.setBinDescription(csfbin.getBinDescription());
			}
			if (csfbin.getBankCode() != null) {
				cSFBinsDTO.setBankCode(Integer.valueOf(csfbin.getBankCode().getBankCode()));
			}
			if (csfbin.getCardType() != null) {
				cSFBinsDTO.setCardType(csfbin.getCardType());
			}
			if (csfbin.getLimit1() != null) {
				cSFBinsDTO.setLimit1(csfbin.getLimit1().doubleValue());
			}
			if (csfbin.getLimit2() != null) {
				cSFBinsDTO.setLimit2(csfbin.getLimit2().doubleValue());
			}
			if (csfbin.getFloorLimit() != null) {
				cSFBinsDTO.setFloorLimit(csfbin.getFloorLimit().doubleValue());
			}
			if (csfbin.getRouting() != null) {
				cSFBinsDTO.setRouting(csfbin.getRouting().intValue());
			}
			if (csfbin.getCreatedBy() != null) {
				cSFBinsDTO.setCreatedBy(csfbin.getCreatedBy());
			}
			if (csfbin.getCreatedDate() != null) {
				cSFBinsDTO.setCreatedDate(csfbin.getCreatedDate());
			}
			if (csfbin.getModifiedBy() != null) {
				cSFBinsDTO.setModifiedBy(csfbin.getModifiedBy());
			}
			if (csfbin.getModifiedDate() != null) {
				cSFBinsDTO.setModifiedDate(csfbin.getModifiedDate());
			}
			if (csfbin.getSubService() != null) {
				cSFBinsDTO.setSubService(csfbin.getSubService());
			}
			if (csfbin.getFinalDeletionDate() != null) {
				cSFBinsDTO.setFirstDeletionDate(csfbin.getFinalDeletionDate());
			}
			if (csfbin.getDaysBeforefinalDeletionDate() != null) {
				cSFBinsDTO.setDaysBeforeFirstDeletionDate(csfbin.getDaysBeforefinalDeletionDate().intValue());
			}
			if (csfbin.getFinalDeletionDate() != null) {
				cSFBinsDTO.setFinalDeletionDate(csfbin.getFinalDeletionDate());
			}
			if (csfbin.getDaysBeforefinalDeletionDate() != null) {
				cSFBinsDTO.setDaysBeforeFinalDeletionDate(csfbin.getDaysBeforefinalDeletionDate().intValue());
			}
			if (csfbin.getActiveInd() != null) {
				cSFBinsDTO.setActiveInd(csfbin.getActiveInd());
			}
			if (csfbin.getAcqIssBoth() != null) {
				cSFBinsDTO.setAcqIssBoth(csfbin.getAcqIssBoth());
			}
			parameters.clear();
			return cSFBinsDTO;
		}
		catch (Exception ex) {
			throw new DAOException("Error retrieving CsfBins entries, cause: " + ex.getMessage(), ex);

		}
	}

	/* Retrieve Related */

	@SuppressWarnings("unchecked")
	public List<CSFBinsDTO> retrieveRelated(CSFBinsDTO obj) throws DAOException {
		List<CSFBinsDTO> dtoList = new LinkedList<CSFBinsDTO>();
		CSFBinsDTO cSFBinsDTO;
		try {
			String sql = "SELECT  c  FROM CsfBins c " + buildWhereClause(obj, true);
			List<CsfBins> cSFBinsRetrieveRelated = csfBinsDao.executeQueryParameters(sql, parameters);
			for (CsfBins csfbin : cSFBinsRetrieveRelated) {
				cSFBinsDTO = new CSFBinsDTO();
				if (csfbin.getBinNo() != null) {
					cSFBinsDTO.setBinNo(csfbin.getBinNo());
				}
				if (csfbin.getBinDescription() != null) {
					cSFBinsDTO.setBinDescription(csfbin.getBinDescription());
				}
				cSFBinsDTO.setBankCode(Integer.valueOf(csfbin.getBankCode().getBankCode()));

				if (csfbin.getCardType() != null) {
					cSFBinsDTO.setCardType(csfbin.getCardType());
				}
				if (csfbin.getLimit1() != null) {
					cSFBinsDTO.setLimit1(csfbin.getLimit1().doubleValue());
				}
				if (csfbin.getLimit2() != null) {
					cSFBinsDTO.setLimit2(csfbin.getLimit2().doubleValue());
				}
				if (csfbin.getFloorLimit() != null) {
					cSFBinsDTO.setFloorLimit(csfbin.getFloorLimit().doubleValue());
				}
				if (csfbin.getRouting() != null) {
					cSFBinsDTO.setRouting(csfbin.getRouting().intValue());
				}
				if (csfbin.getCreatedBy() != null) {
					cSFBinsDTO.setCreatedBy(csfbin.getCreatedBy());
				}
				if (csfbin.getCreatedDate() != null) {
					cSFBinsDTO.setCreatedDate(csfbin.getCreatedDate());
				}
				if (csfbin.getModifiedBy() != null) {
					cSFBinsDTO.setModifiedBy(csfbin.getModifiedBy());
				}
				if (csfbin.getModifiedDate() != null) {
					cSFBinsDTO.setModifiedDate(csfbin.getModifiedDate());
				}
				if (csfbin.getSubService() != null) {
					cSFBinsDTO.setSubService(csfbin.getSubService());
				}
				if (csfbin.getFinalDeletionDate() != null) {
					cSFBinsDTO.setFirstDeletionDate(csfbin.getFinalDeletionDate());
				}
				if (csfbin.getDaysBeforefinalDeletionDate() != null) {
					cSFBinsDTO.setDaysBeforeFirstDeletionDate(csfbin.getDaysBeforefinalDeletionDate().intValue());
				}
				if (csfbin.getFinalDeletionDate() != null) {
					cSFBinsDTO.setFinalDeletionDate(csfbin.getFinalDeletionDate());
				}
				if (csfbin.getDaysBeforefinalDeletionDate() != null) {
					cSFBinsDTO.setDaysBeforeFinalDeletionDate(csfbin.getDaysBeforefinalDeletionDate().intValue());
				}
				if (csfbin.getActiveInd() != null) {
					cSFBinsDTO.setActiveInd(csfbin.getActiveInd());
				}
				if (csfbin.getAcqIssBoth() != null) {
					cSFBinsDTO.setAcqIssBoth(csfbin.getAcqIssBoth());
				}

				dtoList.add(cSFBinsDTO);
			}

		}
		catch (Exception ex) {
			throw new DAOException("Error retrieving CsfBins entries, cause: " + ex.getMessage(), ex);
		}
		parameters.clear();
		return dtoList;

	}

	public void createCSFBins(List<CsfBinsEntity> csfBinsdata) throws DAOException {
		try {
			delete();
			for (CsfBinsEntity csfBinsDTO : csfBinsdata) {
				CsfBins csfbin = new CsfBins();
				CsfMembers csfMember = new CsfMembers();
				csfMember.setBankCode(String.valueOf(csfBinsDTO.getCsfBinsEntityPK().getBankCode()));
				csfbin.setBinNo(csfBinsDTO.getCsfBinsEntityPK().getBinNum());
				csfbin.setBinDescription(csfBinsDTO.getBinDescription());
				csfbin.setBankCode(csfMember);
				csfbin.setCardType(csfBinsDTO.getCsfBinsEntityPK().getCardType());
				csfbin.setLimit1(new BigDecimal(csfBinsDTO.getLimit1()));
				csfbin.setLimit2(new BigDecimal(csfBinsDTO.getLimit2()));
				csfbin.setFloorLimit(new BigDecimal(csfBinsDTO.getFloorLimit()));
				csfbin.setRouting(Short.valueOf(csfBinsDTO.getRouting()));
				csfbin.setActiveInd(csfBinsDTO.getBinActiveInd());
				csfbin.setAcqIssBoth(csfBinsDTO.getIssAcqBoth());

				csfBinsDao.create(csfbin);
				
			}
		}
		catch (Exception ex) {
			throw new DAOException("Error retrieving CSF_BINS_By_Query entries, cause: " + ex.getMessage(), ex);
		}
	}

	@SuppressWarnings("unchecked")
	public CSFBINTotalsDTO retrieveBinTotals(String dialectId) throws DAOException {
		CSFBINTotalsDTO dto = null;
		try {

			// ORACLE Query
			String oracleQuery = " SELECT COUNT(*) as TOT_NUMBER ,SUM(CASE  WHEN TO_DATE(a.deletion_Date,'YYYYMMDD') <   "
					+ "ADD_MONTHS(b.process_Date,NVL(c.months_Until_Cis_Bin_Deletion * -1,-9))   "
					+ "THEN 1  ELSE 0  END) AS FINALLY_DEL,SUM(CASE WHEN TO_DATE(a.deletion_Date,'YYYYMMDD') >  "
					+ "ADD_MONTHS(b.process_Date,NVL(c.months_Until_Cis_Bin_Deletion  * -1,-9)) AND "
					+ "TO_DATE(a.deletion_Date,'YYYYMMDD') <=  b.process_Date THEN 1 ELSE 0 END) AS DEL_CYCLE ,SUM(CASE  "
					+ "WHEN TO_DATE(a.deletion_Date,'YYYYMMDD') > b.process_Date THEN 1 ELSE 0 END) AS TO_BE_DELTED   "
					+ ",SUM(CASE WHEN TRIM(a.deletion_Date) IS NULL THEN 1  ELSE 0 END) AS ACT_BINS  "
					+ "FROM Cis_Bins a ,Cso_System_Parameters b ,Csf_Members c WHERE b.process_Active_Ind = 'Y'  "
					+ "AND c.bank_Code = a.bank_Code";
			/*
			 * "SELECT COUNT(*) as TOT_NUMBER ,SUM(CASE  WHEN TO_DATE(a.deletionDate,'YYYYMMDD') < "+
			 * "ADD_MONTHS(b.processDate,NVL(c.monthsUntilCisBinDeletion * -1,-9)) "+
			 * "THEN 1  ELSE 0  END) AS FINALLY_DEL,SUM(CASE WHEN TO_DATE(a.deletionDate,'YYYYMMDD') > "+
			 * "ADD_MONTHS(b.processDate,NVL(c.monthsUntilCisBinDeletion  * -1,-9)) AND "+
			 * "TO_DATE(a.deletionDate,'YYYYMMDD') <=  b.processDate THEN 1 ELSE 0 END) AS DEL_CYCLE ,SUM(CASE "+
			 * "WHEN TO_DATE(a.deletionDate,'YYYYMMDD') > b.processDate THEN 1 ELSE 0 END) AS TO_BE_DELTED "+
			 * ",SUM(CASE WHEN TRIM(a.deletionDate) IS NULL THEN 1  ELSE 0 END) AS ACT_BINS "+
			 * "FROM CisBins a ,CsoSystemParameters b ,CsfMembers c WHERE b.processActiveInd = 'Y' "+
			 * "AND c.bankCode = a.bankCode";
			 */

			// MySQL Query
			String mysqlQuery = "";
			mysqlQuery = "SELECT COUNT(*) as TOT_NUMBER ,SUM(CASE  WHEN STR_TO_DATE(a.deletion_Date,'YYYYMMDD') < "
					+ "DATE_ADD(b.process_Date, INTERVAL IFNULL(c.months_Until_Cis_Bin_Deletion * -1,-9) MONTH) "
					+ "THEN 1  ELSE 0  END) AS FINALLY_DEL,SUM(CASE WHEN STR_TO_DATE(a.deletion_Date,'YYYYMMDD') > "
					+ "DATE_ADD(b.process_Date, INTERVAL IFNULL(c.months_Until_Cis_Bin_Deletion  * -1,-9) MONTH) AND "
					+ "STR_TO_DATE(a.deletion_Date,'YYYYMMDD') <=  b.process_Date THEN 1 ELSE 0 END) AS DEL_CYCLE ,SUM(CASE "
					+ "WHEN STR_TO_DATE(a.deletion_Date,'YYYYMMDD') > b.process_Date THEN 1 ELSE 0 END) AS TO_BE_DELTED "
					+ ",SUM(CASE WHEN TRIM(a.deletion_Date) IS NULL THEN 1  ELSE 0 END) AS ACT_BINS "
					+ "FROM CIS_BINS a ,CSO_SYSTEM_PARAMETERS b ,CSF_MEMBERS c WHERE b.process_Active_Ind = 'Y' "
					+ "AND c.bank_Code = a.bank_Code";

			List<Object[]> binsTotal = (List<Object[]>) csfBinsDao
					.executeSQLQuery("ORACLE".equals(dialectId) ? oracleQuery : mysqlQuery);
			// List<Object[]> binsTotal = (List<Object[]>)csfBinsDao.executeSQLQuery(oracleQuery);
			for (Object[] t : binsTotal) {
				dto = new CSFBINTotalsDTO();
				long li = Long.parseLong("" + t[0]);
				dto.setTotalNumber((int) li);
				long l2 = Long.parseLong("" + t[1]);
				dto.setFinallyDel((int) l2);
				long l3 = Long.parseLong("" + t[2]);
				dto.setDelCycle((int) l3);
				long l4 = Long.parseLong("" + t[3]);
				dto.setToBeDeleted((int) l4);
				long l5 = Long.parseLong("" + t[4]);
				dto.setActBins((int) l5);
			}
			return dto;
		}
		catch (Exception ex) {
			throw new DAOException("Error retrieving CsfBins entry, cause: " + ex.getMessage(), ex);
		}

	}

	/* Build WhereClause */

	private String buildWhereClause(CSFBinsDTO obj, boolean select) throws DAOException {

		if (obj == null) {
			return "";
		}
		StringBuilder buff = new StringBuilder();
		boolean whereClause = false;

		if (select == true) {

			if (obj.getBinNo() != null) {
				if (!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.binNo = :binNo");
				parameters.put("binNo", obj.getBinNo());

			}

			if (obj.getBinDescription() != null) {
				if (!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.binDescription =:binDescription");
				parameters.put("binDescription", obj.getBinDescription());
			}

			if (obj.getBankCode() != 0) {
				if (!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.bankCode =:bankCode");
				parameters.put("bankCode", String.valueOf(obj.getBankCode()));
			}

			if (obj.getCardType() != null) {
				if (!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.cardType =:cardType");
				parameters.put("cardType", obj.getCardType());
			}

			if (obj.getLimit1() != 0) {
				if (!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.limit1 =:limit1");
				parameters.put("limit1", String.valueOf(obj.getLimit1()));
			}

			if (obj.getLimit2() != 0) {
				if (!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.limit2 =:limit2");
				parameters.put("LIMIT_2", String.valueOf(obj.getLimit2()));
			}

			if (obj.getFloorLimit() != 0) {
				if (!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.floorLimit =:floorLimit");
				parameters.put("floorLimit", String.valueOf(obj.getFloorLimit()));
			}

			if (obj.getRouting() != 0) {
				if (!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.routing =:routing");
				parameters.put("routing", String.valueOf(obj.getRouting()));
			}

			if (obj.getCreatedBy() != null) {
				if (!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.createdBy =:createdBy");
				parameters.put("createdBy", obj.getCreatedBy());
			}

			if (obj.getCreatedDate() != null) {
				if (!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.createdDate =:createdDate");
				parameters.put("createdDate", String.valueOf(obj.getCreatedDate()));
			}

			if (obj.getModifiedBy() != null) {
				if (!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.modifiedBy =:modifiedBy");
				parameters.put("modifiedBy", obj.getModifiedBy());
			}

			if (obj.getModifiedDate() != null) {
				if (!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.modifiedDate =:modifiedDate");
				parameters.put("modifiedDate", String.valueOf(obj.getModifiedDate()));
			}

			if (obj.getSubService() != null) {
				if (!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.subService =:subService");
				parameters.put("subService", obj.getSubService());
			}

			if (obj.getFirstDeletionDate() != null) {
				if (!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.firstDeletionDate =:firstDeletionDate");
				parameters.put("firstDeletionDate", String.valueOf(obj.getFirstDeletionDate()));
			}

			if (obj.getDaysBeforeFirstDeletionDate() != 0) {
				if (!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.daysBeforefirstDeletionDate =:daysBeforefirstDeletionDate");
				parameters.put("daysBeforefirstDeletionDate", String.valueOf(obj.getDaysBeforeFirstDeletionDate()));
			}

			if (obj.getFinalDeletionDate() != null) {
				if (!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.finalDeletionDate =:finalDeletionDate");
				parameters.put("finalDeletionDate", String.valueOf(obj.getFinalDeletionDate()));
			}

			if (obj.getDaysBeforeFinalDeletionDate() != 0) {
				if (!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.daysBeforefinalDeletionDate =:daysBeforefinalDeletionDate");
				parameters.put("daysBeforefinalDeletionDate", String.valueOf(obj.getDaysBeforeFinalDeletionDate()));
			}

			if (obj.getActiveInd() != null) {
				if (!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.activeInd =:activeInd");
				parameters.put("activeInd", obj.getActiveInd());
			}

			if (obj.getAcqIssBoth() != null) {
				if (!whereClause) {
					whereClause = true;
					buff.append(" WHERE ");
				}
				else {
					buff.append(" AND ");
				}

				buff.append("c.acqIssBoth =:acqIssBoth");
				parameters.put("acqIssBoth", obj.getAcqIssBoth());
			}

		}
		if (!whereClause && select == false) {
			throw new DAOException("Cannot update delete all rows in CCCOWNER.CSF_COMPANY_PARAMETERS");
		}

		return buff.toString();
	}

	/* Updating */

	public void update(CSFBinsDTO obj) throws DAOException {

		CsfBins csfbin = new CsfBins();
		csfbin.setBinNo(obj.getBinNo());
		csfbin.setBinDescription(obj.getBinDescription());
		/*
		 * CsfMembers members = new CsfMembers(); members.setBankCode(members.getBankCode());
		 * csfbin.setBankCode(members);
		 */
		csfbin.setCardType(obj.getCardType());
		csfbin.setLimit1(new BigDecimal(obj.getLimit1()));
		csfbin.setLimit2(new BigDecimal(obj.getLimit2()));
		csfbin.setFloorLimit(new BigDecimal(obj.getFloorLimit()));
		csfbin.setRouting((short) obj.getRouting());
		csfbin.setCreatedBy(obj.getCreatedBy());
		csfbin.setCreatedDate(obj.getCreatedDate());
		csfbin.setModifiedBy(obj.getModifiedBy());
		csfbin.setModifiedDate(obj.getModifiedDate());
		csfbin.setSubService(obj.getSubService());
		csfbin.setFinalDeletionDate(obj.getFirstDeletionDate());
		csfbin.setDaysBeforefinalDeletionDate((short) obj.getDaysBeforeFirstDeletionDate());
		csfbin.setFinalDeletionDate(obj.getFinalDeletionDate());
		csfbin.setDaysBeforefinalDeletionDate((short) obj.getDaysBeforeFinalDeletionDate());
		csfbin.setActiveInd(obj.getActiveInd());
		csfbin.setAcqIssBoth(obj.getAcqIssBoth());

		csfBinsDao.update(csfbin);

	}

	/**
	 * Delete a record in Database.
	 *
	 * @param bean The Object to be deleted.
	 * @exception SQLException if something is wrong.
	 */

	public void delete() throws DAOException {
		try {

			csfBinsDao.deleteBulk("Delete from CsfBins");

		}
		catch (Exception ex) {
			throw new DAOException("Error deleting CCCOWNER.CSF_BINS, cause: " + ex.getMessage(), ex);

		}

	}
}
