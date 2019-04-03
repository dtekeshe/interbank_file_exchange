package com.bsva.dao.v02.billing;

/**
 * TODO Document
 */
public class CCR015DataEntity {

    private final static String CCR015_DATA_SQL =
            " SELECT PROCESS_MONTH, ISSUER_BIN, ISSUER_MEMBER, ISSUER_MEMBER_NAME, ACQUIRING_MEMBER_NAME,           " +
            "        CARD_DESCRIPTION, CARD_TYPE, ACQUIRING_MEMBER, MERCHANT_CAT_CODE, INTERCHANGE_RATE_DESIGNATOR  " +
            "        TRANSACTION_DESCRIPTION, ITEM_CHARGE, ITEM_CHARGE_AMOUNT, VOLUME, VALUE, TOTAL_COST            " +
            "   FROM CSV_CCR015_VIEW " +
            "  WHERE ISSUER_MEMBER = :issuerMember ";

    public void ccr015Data(Integer issuerMember) {

    }
}
