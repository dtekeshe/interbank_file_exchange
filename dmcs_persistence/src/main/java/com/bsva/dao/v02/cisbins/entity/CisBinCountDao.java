package com.bsva.dao.v02.cisbins.entity;

import java.util.ArrayList;
import java.util.List;

import com.bsva.dao.AbstractDao;

public class CisBinCountDao  extends AbstractDao<CisBinsCountEntity, Void> {
	
	private final static String BIN_COUNT_SQL = 
			"   SELECT COUNT(*)AS TOT_COUNT                                      	"+
            "          ,SUM(CASE                                                	"+
            "               WHEN TO_DATE(DELETION_DATE,'YYYYMMDD') <				"+
            "                 ADD_MONTHS(B.PROCESS_DATE,							"+
            "                     NVL(C.MONTHS_UNTIL_CIS_BIN_DELETION				"+
            "                             * -1,-9))									"+
            "                     THEN 1											"+
            "                ELSE 0													"+
            "                END) AS FINALLY_DEL									"+
            "          ,SUM(CASE													"+
            "                WHEN TO_DATE(DELETION_DATE,'YYYYMMDD') >				"+
            "                      ADD_MONTHS(B.PROCESS_DATE,						"+
            "                       NVL(C.MONTHS_UNTIL_CIS_BIN_DELETION				"+
            "                             * -1,-9))									"+
            "                                 AND									"+
            "                      TO_DATE(DELETION_DATE,'YYYYMMDD') <=				"+
            "                               B.PROCESS_DATE							"+
            "                      THEN 1											"+
            "                ELSE 0													"+
            "                END) AS DEL_CYCLE										"+
            "          ,SUM(CASE													"+
            "                WHEN TO_DATE(DELETION_DATE,'YYYYMMDD') >				"+
            "                               B.PROCESS_DATE							"+
            "                      THEN 1											"+
            "                ELSE 0													"+
            "                END) AS TO_BE_DELTED									"+
            "          ,SUM(CASE													"+
            "                WHEN TRIM(DELETION_DATE) IS NULL						"+
            "                      THEN 1											"+
            "                ELSE 0													"+
            "                END) AS ACT_BINS										"+
            "    FROM CIS_BINS A													"+
            "        ,CSO_SYSTEM_PARAMETERS B										"+		
            "        ,CSF_MEMBERS C													"+
            "    WHERE B.PROCESS_ACTIVE_IND = 'Y'									"+
            "      AND C.BANK_CODE = A.BANK_CODE";									

	public List<CisBinsCountEntity> returnBinCount() {

		List<CisBinsCountEntity> listData = new ArrayList<CisBinsCountEntity>();
		
		// execute
		List<CisBinsCountEntity> entities = list(BIN_COUNT_SQL, CisBinsCountEntity.class);

		// prepare result
		for (CisBinsCountEntity entity : entities) {
			CisBinsCountEntity bankCode1 = new CisBinsCountEntity();
			bankCode1.setActiveBins(entity.getActiveBins());
			bankCode1.setBinDeleted(entity.getBinDeleted());
			bankCode1.setBinTotalNumber(entity.getBinTotalNumber());
			bankCode1.setDeletionCycle(entity.getDeletionCycle());
			bankCode1.setSetForDeletion(entity.getSetForDeletion());
			listData.add(bankCode1);
		}

		return listData;
	}

}
