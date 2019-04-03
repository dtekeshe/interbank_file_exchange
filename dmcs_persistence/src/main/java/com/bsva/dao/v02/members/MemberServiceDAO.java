package com.bsva.dao.v02.members;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.members.MemberEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO Document
 */
public class MemberServiceDAO extends AbstractDao<MemberEntity, Void> {

    public List<MemberEntity> issuingMemberService(String subServiceID) {
        return memberService(subServiceID, Boolean.TRUE);
    }

    public List<MemberEntity> acquiringMemberService(String subServiceID) {
        return memberService(subServiceID, Boolean.TRUE);
    }

    private List<MemberEntity> memberService(String subServiceID, Boolean issuersOnly) {

        String sql = getSQL(issuersOnly);

        // prepare params
        Map<String, Object> params = new HashMap<>();
        params.put("subServiceID", subServiceID);

        // execute
        List<MemberEntity> members
                = list(sql, params, MemberEntity.class);

        return members;
    }

    private String getSQL(Boolean issuersOnly) {

        String memberSQL =
                " SELECT S.BANK_CODE, S.MEMBER_TAPE_ID, S.MEMBER_NO AS FULL_BANK_CODE, " +
                "        S.MAX_SIZE_TRANS_FILE AS MAX_FILE_SIZE, M.MEMBER_NAME " +
                "   FROM CSF_MEMBER_SERVICE S " +
                "   JOIN CSF_MEMBERS M " +
                "     ON S.BANK_CODE = M.BANK_CODE " +
                "  WHERE " + ( issuersOnly ? " S.ISSUER_IND = 'Y'" : " S.ACQUIRER_IND = 'Y" ) +
                "    AND S.SUB_SERVICE = :subServiceID " +
                "    AND S.OUTPUT_IND = 'Y' " +
                "  ORDER BY S.MEMBER_NO ";

        return memberSQL;
    }
}
