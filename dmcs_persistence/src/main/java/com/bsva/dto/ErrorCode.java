package com.bsva.dto;

/**
 *
 */
public enum ErrorCode {

    SUCCESS                             (0),
    HEADER_RECORD_NOT_FIRST_REC         (3),
    TRAILER_RECORD_NOT_LAST_REC         (5),

    FILE_PREFIX_SUBSERV_INVALID         (10),
    OUTPUT_DATE_NOT_EQ_PROCESS_DATE     (11),

    ENVIRONMENT_INDICATOR_INCORRECT     (15),
    FILE_ORIGINATOR_INVALID             (16),
    HDR_FILENAME_NOT_EQUAL_FILENAME     (18),

    DATA_TYPE_NOT_EQUAL_DATA            (23),
    DATA_DIRECTION_NOT_EQUAL_IN         (24),
    HDR_REC_SIZE_INCORRECT              (25),

    INVALID_ISSUER_BIN                  (27),
    INVALID_ACQUIRER_BIN                (28),

    TRAN_CODE_DOES_NOT_EXIST            (31),
    AMOUNT_NOT_NUMERIC                  (33),
    TX_EXCEEDS_PASA_PAYMENT_LIMIT       (43),

    TRC1_TRAN_CODE_NOT_EQUAL_TRC0(41),
    TCR_SEQ_NO_OUT_OF_SEQ(42),

    INVALID_CARD_NUMBER_LENGTH(55),
    SRC_CURRENCY_CODE_INVALID(59),
    ISS_BIN_DELETED(61),
    ACQ_BIN_DELETED(62),
    BIN_IS_ONLY_ACQUIRING_BIN(63),

    SERVICE_ON_HEADER_INVALID(65),
    HDR_FILE_NUMBER_NOT_EQUAL_FILENAME(67),

    SUB_SERVICE_INVALID(76),
    CARD_NUMBER_NOT_NUMERIC(77),
    INVALID_CARD_TYPE(79),
    TRAN_NOT_ALLOWED_FOR_SUBSERV(80),
    INVALID_PDS_0025_REVERSAL(84),
    FILE_FORMAT_ERROR_ON_FILE(85),
    SERVICE_ON_FOOTER_INVALID(87),
    TRAILER_DATE_NOT_PROCESS_DATE(88),
    FOOTER_COUNT_NOT_RECORD_COUNT(89),
    RECORD_99_NOT_FOUND_IN_FILE(90),
    INVALID_BITMAP(91),
	REASON_CODE_DOES_NOT_EXIST(92),
	NULL_DATETIME_ON_FLEET_TRXN(93),
	INVALID_AMEX_MERCHANT_SE(94);

    private final Integer code;

    ErrorCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

}
