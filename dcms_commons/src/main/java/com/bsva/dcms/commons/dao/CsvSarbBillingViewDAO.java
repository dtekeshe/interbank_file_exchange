package com.bsva.dcms.commons.dao;

import com.bsva.dao.CsvSarbBillingViewDao;
import com.bsva.dcms.commons.dto.CsvSarbBillingViewDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.entities.CsvSarbBillingView;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author SimphiweT
 */
public class CsvSarbBillingViewDAO {
    
    private Map<String, Object> map = new HashMap<>();
    private CsvSarbBillingViewDao csvSarbBillingViewDao = new CsvSarbBillingViewDao();

    public CsvSarbBillingViewDAO() {
    }

    public CsvSarbBillingViewDTO retrieve(CsvSarbBillingViewDTO csvSarbBillingViewDTO) throws DAOException {

        CsvSarbBillingViewDTO sarbBillingViewDTO = null;

        String sql = "SELECT c FROM CsvSarbBillingView c " + buildWhereClause(csvSarbBillingViewDTO);

        CsvSarbBillingView billing = csvSarbBillingViewDao.executeQueryParametersSingleDate(sql, map);

        sarbBillingViewDTO = new CsvSarbBillingViewDTO();

        try {

            if (billing.getBillingPercent() != null) {
                sarbBillingViewDTO.setBillingPercent(billing.getBillingPercent());
            }
            if (billing.getBillingRate() != null) {
                sarbBillingViewDTO.setBillingRate(billing.getBillingRate());
            }
            if (billing.getCardType() >= 0) {
                sarbBillingViewDTO.setCardType(billing.getCardType());
            }
            if (billing.getCsvSarbBillingViewPK().getRateDescriptor() != null) {
                sarbBillingViewDTO.setRateDescriptor(billing.getCsvSarbBillingViewPK().getRateDescriptor());
            }            

        } catch (Exception ex) {
            throw new DAOException("Error retrieving CSV_SARB_BILLING_VIEW entry, cause: " + ex.getMessage(), ex);
        }
        map.clear();

        return sarbBillingViewDTO;
    }

    private String buildWhereClause(CsvSarbBillingViewDTO csvSarbBillingViewDTO) {

        if (csvSarbBillingViewDTO == null) {
            return "";
        }
        StringBuilder buff = new StringBuilder();
        boolean whereClause = false;

        if (csvSarbBillingViewDTO.getBillingPercent() != null) {
            if (!whereClause) {
                whereClause = true;
                buff.append(" WHERE ");
            } else {
                buff.append(" AND ");
            }

            buff.append("c.billingPercent =:billingPercent");
            map.put("c.billingPercent", csvSarbBillingViewDTO.getBillingPercent());
        }

        if (csvSarbBillingViewDTO.getBillingRate() != null) {
            if (!whereClause) {
                whereClause = true;
                buff.append(" WHERE ");
            } else {
                buff.append(" AND ");
            }

            buff.append("c.billingRate =:billingRate");
            map.put("billingRate", csvSarbBillingViewDTO.getBillingRate());
        }

        if (csvSarbBillingViewDTO.getCardType()  >= 0) {
            if (!whereClause) {
                whereClause = true;
                buff.append(" WHERE ");
            } else {
                buff.append(" AND ");
            }

            buff.append("c.cardType =:cardType");
            map.put("cardType", csvSarbBillingViewDTO.getCardType());
        }

        if (csvSarbBillingViewDTO.getRateDescriptor() != null) {
            if (!whereClause) {
                whereClause = true;
                buff.append(" WHERE ");
            } else {
                buff.append(" AND ");
            }

            buff.append("c.csvSarbBillingViewPK.rateDescriptor =:rateDescriptor");
            map.put("rateDescriptor", csvSarbBillingViewDTO.getRateDescriptor());
        }        

        return buff.toString();
    }

    public void update(CsvSarbBillingViewDTO csvSarbBillingViewDTO) throws DAOException {

    }

    public void delete(CsvSarbBillingViewDTO csvSarbBillingViewDTO) throws DAOException {

    }
    
}
