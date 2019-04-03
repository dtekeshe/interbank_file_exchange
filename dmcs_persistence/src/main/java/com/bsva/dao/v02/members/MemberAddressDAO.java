package com.bsva.dao.v02.members;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.members.MemberAddressEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO Document
 */
public class MemberAddressDAO extends AbstractDao<MemberAddressEntity, Void> {
    
    private final static String MEMBER_ADDRESS_SQL = 
            " SELECT M.BANK_CODE, M.MEMBER_NO, S.CONTACT_NAME, M.MEMBER_NAME," +
            "        S.MEMBER_ADDRESS_1, S.MEMBER_ADDRESS_2, S.MEMBER_ADDRESS_3, S.MEMBER_ADDRESS_4," +
            "        S.VAT_REG_NUMBER" +
            "   FROM CSF_MEMBERS M " +
            "   JOIN CSF_MEMBER_SERVICE S " +
            "     ON ( M.BANK_CODE = S.BANK_CODE )" +
            "  WHERE S.SERVICE = :serviceID " +
            "    AND S.SUB_SERVICE = :subServiceID " +
            "  ORDER BY BANK_CODE";

    public Map<Integer, MemberAddressEntity> memberAddresses(String subServiceID) {

        // prepare params
        Map<String, Object> params = new HashMap<>();
        params.put("serviceID", "CARD");
        params.put("subServiceID", subServiceID);

        // execute
        List<MemberAddressEntity> entities
                = list(MEMBER_ADDRESS_SQL, params, MemberAddressEntity.class);

        // prepare result
        Map<Integer, MemberAddressEntity> addresses = new HashMap<>();

        for ( MemberAddressEntity entity : entities ) {
            addresses.put(entity.getBankCode(), entity);
        }

        return addresses;
    }
}
