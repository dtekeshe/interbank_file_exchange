package com.bsva.dao.v02.startofday;

import java.util.ArrayList;
import java.util.List;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.startofday.CsfBinsEntity;
import com.bsva.entities.v02.startofday.CsfBinsEntityPK;

public class CsfBinsDAO extends AbstractDao<CsfBinsEntity, Void> {
	
	 private static final String CSF_BINS_SQL =
    		                           "SELECT  A.BIN_NO AS BIN_NO                                                                                                                      "+
		            		           " , NVL(TRIM (A.BIN_DESCRIPTION), ' ') AS BIN_DESCRIPTION 																						"+
		            		           " , NVL(A.BANK_CODE, 99) AS BANK_CODE																											"+
		            		           ", NVL (B.MEMBER_NAME, ' ') AS BANK_NAME 																										"+
		            		           " , NVL(A.CARD_TYPE, '99') AS CARD_TYPE 																											"+
		            		           " , NVL (D.CARD_DESCRIPTION, ' ') AS CARD_DESCRIPTION 																							"+
		            		           " , NVL(A.LIMIT_1, 0) AS LIMIT_1 																												"+
		            		           " , NVL(A.LIMIT_2, 0) AS LIMIT_2																													"+
		            		           " , NVL(A.FLOOR_LIMIT, 0) AS FLOOR_LIMIT																											"+
		            		           " , NVL(A.ROUTING, 0) AS ROUTING 																												"+
		            		           " , TO_DATE(A.DELETION_DATE, 'YYYYMMDD') AS FIRST_DELETION_DATE 																					"+
		            		           " , TO_DATE(A.DELETION_DATE, 'YYYYMMDD') - C.PROCESS_DATE AS DAYS_BEFOREFIRST_DELETION_DATE 														"+
		            		           " , ADD_MONTHS (TO_DATE (A.DELETION_DATE, 'YYYYMMDD'), NVL(B.MONTHS_UNTIL_CIS_BIN_DELETION, 9)) AS FINAL_DELETION_DATE 							"+
		            		           " , ADD_MONTHS (TO_DATE (A.DELETION_DATE, 'YYYYMMDD'),NVL (B.MONTHS_UNTIL_CIS_BIN_DELETION, 9))- C.PROCESS_DATE AS DAYS_BEFOREFINAL_DELETION_DATE "+
		            		           " , CASE WHEN A.DELETION_DATE IS NULL THEN 'A' 																									"+
		            		           "       WHEN (TO_DATE (A.DELETION_DATE, 'YYYYMMDD') - C.PROCESS_DATE) >= 0 THEN 'A'															    "+
		            		           "      WHEN TO_DATE (A.DELETION_DATE, 'YYYYMMDD') - C.PROCESS_DATE < 0 																			"+
		            		           "       AND (ADD_MONTHS (TO_DATE (A.DELETION_DATE, 'YYYYMMDD'), NVL(B.MONTHS_UNTIL_CIS_BIN_DELETION, 9)) - C.PROCESS_DATE) >= 0 THEN 'D'  		"+
		            		           "       ELSE 'N' END AS BIN_ACTIVE_IND , 																										 "+
		            		           "        NVL(A.ISS_ACQ_BOTH,0) AS ISS_ACQ_BOTH,																									"+
							           "   NVL(A.FUEL_ALLOWED,0) AS FUEL_ALLOWED,																										"+
		            		           "        NVL (b.MONTHS_UNTIL_CIS_BIN_DELETION, 9) AS MONTH_UNTIL_DELETION  																		"+
		            		    "  FROM  CIS_BINS A LEFT OUTER JOIN CSF_MEMBERS B ON A.bank_code = B.bank_code  																		"+
		            		    "  LEFT OUTER JOIN CSO_SYSTEM_PARAMETERS C ON (C.PROCESS_ACTIVE_IND = 'Y' OR C.PROCESS_ACTIVE_IND = 'S') 												"+
		            		    "  LEFT OUTER JOIN CSF_CARD_TYPES D ON A.CARD_TYPE = D.CARD_TYPE 																						"+
		            		    "  WHERE ADD_MONTHS (TO_DATE (A.DELETION_DATE, 'YYYYMMDD'),NVL(B.MONTHS_UNTIL_CIS_BIN_DELETION, 9)) - C.PROCESS_DATE >= 0 								"+
		            		    "  OR A.DELETION_DATE IS NULL  ORDER BY   A.BANK_CODE , A.BIN_NO ";

    public List<CsfBinsEntity> getCsfBinsData() {

        // execute 
        List<CsfBinsEntity> entities  = list(CSF_BINS_SQL, CsfBinsEntity.class);

        // prepare result
        List<CsfBinsEntity> listData = new ArrayList<CsfBinsEntity>();
        if(entities.size() > 0){
	        for (CsfBinsEntity entity : entities) {
	        	CsfBinsEntity csfBins = new CsfBinsEntity();
	        	CsfBinsEntityPK csfBinsEntityPK = new CsfBinsEntityPK();
	        	csfBinsEntityPK.setBankCode(entity.getCsfBinsEntityPK().getBankCode());
	        	csfBinsEntityPK.setBinNum(entity.getCsfBinsEntityPK().getBinNum());
	        	csfBinsEntityPK.setCardType(entity.getCsfBinsEntityPK().getCardType());
	        	csfBins.setCsfBinsEntityPK(csfBinsEntityPK);
	        	csfBins.setBinActiveInd(entity.getBinActiveInd());
	        	csfBins.setBinDescription(entity.getBinDescription());
	        	csfBins.setDaysBeforeFinalDeletion(entity.getDaysBeforeFinalDeletion());
	        	csfBins.setDaysbeforeFirstDeletion(entity.getDaysbeforeFirstDeletion());
	        	csfBins.setFinalDeletion(entity.getFinalDeletion());
	        	csfBins.setFirstDeletionDate(entity.getFirstDeletionDate());
	        	csfBins.setFloorLimit(entity.getFloorLimit());
	        	csfBins.setFuelAllowed(entity.getFuelAllowed());
	        	csfBins.setIssAcqBoth(entity.getIssAcqBoth());
	        	csfBins.setLimit1(entity.getLimit1());
	        	csfBins.setLimit2(entity.getLimit2());
	        	csfBins.setRouting(entity.getRouting());
	        	listData.add(csfBins);
	        }
        }

        return listData;
    }

}
