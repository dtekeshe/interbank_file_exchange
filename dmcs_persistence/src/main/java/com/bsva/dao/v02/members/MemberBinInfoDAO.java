package com.bsva.dao.v02.members;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.members.MemberBinInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO Document
 */
public class MemberBinInfoDAO extends AbstractDao<MemberBinInfo, Void> {

    private final static String BIN_SQL =
            " SELECT B.BIN_NO, B.BANK_CODE, B.CARD_TYPE, B.ACQ_ISS_BOTH AS MEMBER_ROLE_ID, " +
            "         NVL(B.DAYS_BEFOREFIRST_DELETION_DATE, 0) AS DAYS_BEFOREFIRST_DELETION_DATE, " +
            "         NVL(B.DAYS_BEFOREFINAL_DELETION_DATE, 0) AS DAYS_BEFOREFINAL_DELETION_DATE, " +
            "         M.MEMBER_TAPE_ID AS DISTRIBUTION_CODE " +
            "  FROM CSF_BINS B " +
            "  JOIN CSF_MEMBERS M " +
            "    ON (B.BANK_CODE = M.BANK_CODE) ";

    public Map<Integer, MemberBinInfo> membersBinInfo() {

        // execute
        List<MemberBinInfo> entities
                = list(BIN_SQL, MemberBinInfo.class);

        // prepare result
        Map<Integer, MemberBinInfo> members = new HashMap<>();
        for (MemberBinInfo memberBinInfo : entities) {
            members.put(memberBinInfo.getBin(), memberBinInfo);
        }

        return members;
    }
}
