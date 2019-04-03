package com.bsva.dcms.commons.dao;

import com.bsva.dao.CsfCardFeeSarbBillingDao;
import com.bsva.dcms.commons.dto.CsfCardFeeSarbBillingDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.entities.CsfCardFeeSarbBilling;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author SimphiweT
 */
public class CsfCardFeeSarbBillingDAO {

    private Map<String, Object> map = new HashMap<>();
    private CsfCardFeeSarbBillingDao cardFeeSarbBillingDao = new CsfCardFeeSarbBillingDao();

    public CsfCardFeeSarbBillingDAO() {
    }

    public void create(CsfCardFeeSarbBillingDTO cardFeeSarbBillingDTO) throws DAOException {

        CsfCardFeeSarbBilling cardFeeSarbBilling = new CsfCardFeeSarbBilling();
        try {
            cardFeeSarbBilling.setChangeOverDate(cardFeeSarbBillingDTO.getChangeOverDate());
            cardFeeSarbBilling.setCreditPercent(cardFeeSarbBillingDTO.getCreditPercent());
            cardFeeSarbBilling.setCreditRate(cardFeeSarbBillingDTO.getCreditRate());
            cardFeeSarbBilling.setDebitPercent(cardFeeSarbBillingDTO.getOldDebitPercent());
            cardFeeSarbBilling.setDebitRate(cardFeeSarbBillingDTO.getDebitRate());
            cardFeeSarbBilling.setOldCreditPercent(cardFeeSarbBillingDTO.getOldCreditPercent());
            cardFeeSarbBilling.setOldCreditRate(cardFeeSarbBillingDTO.getOldCreditRate());
            cardFeeSarbBilling.setOldDebitPercent(cardFeeSarbBillingDTO.getOldDebitPercent());
            cardFeeSarbBilling.setOldDebitRate(cardFeeSarbBillingDTO.getDebitRate());
            cardFeeSarbBilling.setRateDescriptor(cardFeeSarbBillingDTO.getRateDescriptor());
            cardFeeSarbBillingDao.create(cardFeeSarbBilling);
        } catch (Exception ex) {
            throw new DAOException("Error creating CSF_CARD_FEE_SARB_BILLING entry, cause: " + ex.getMessage(), ex);
        }

    }

    public CsfCardFeeSarbBillingDTO retrieve(CsfCardFeeSarbBillingDTO csfCardFeeSarbBillingDTO) throws DAOException {

        CsfCardFeeSarbBillingDTO sarbBillingDTO = null;

        String sql = "SELECT c FROM CsfCardFeeSarbBilling c " + buildWhereClause(csfCardFeeSarbBillingDTO);

        CsfCardFeeSarbBilling billing = cardFeeSarbBillingDao.executeQueryParametersSingle(sql, map);

        sarbBillingDTO = new CsfCardFeeSarbBillingDTO();

        try {

            if (billing.getChangeOverDate() != null) {
                sarbBillingDTO.setChangeOverDate(billing.getChangeOverDate());
            }
            if (billing.getCreditPercent() != null) {
                sarbBillingDTO.setCreditPercent(billing.getCreditPercent());
            }
            if (billing.getCreditRate() != null) {
                sarbBillingDTO.setCreditRate(billing.getCreditRate());
            }
            if (billing.getDebitPercent() != null) {
                sarbBillingDTO.setDebitPercent(billing.getDebitPercent());
            }
            if (billing.getDebitRate() != null) {
                sarbBillingDTO.setDebitRate(billing.getDebitRate());
            }
            if (billing.getOldCreditPercent() != null) {
                sarbBillingDTO.setOldCreditPercent(billing.getOldCreditPercent());
            }
            if (billing.getOldCreditRate() != null) {
                sarbBillingDTO.setOldCreditRate(billing.getOldCreditRate());
            }
            if (billing.getOldDebitPercent() != null) {
                sarbBillingDTO.setOldDebitPercent(billing.getOldDebitPercent());
            }
            if (billing.getOldDebitRate() != null) {
                sarbBillingDTO.setOldCreditRate(billing.getOldDebitRate());
            }
            if (billing.getRateDescriptor() != null) {
                sarbBillingDTO.setRateDescriptor(billing.getRateDescriptor());
            }

        } catch (Exception ex) {
            throw new DAOException("Error retrieving CSF_CARD_FEE_SARB_BILLING entry, cause: " + ex.getMessage(), ex);
        }
        map.clear();

        return sarbBillingDTO;
    }

    public List<CsfCardFeeSarbBillingDTO> retrieveRelated(CsfCardFeeSarbBillingDTO csfCardFeeSarbBillingDTO) throws DAOException {

        List<CsfCardFeeSarbBillingDTO> dtoList = new LinkedList<>();

        CsfCardFeeSarbBillingDTO sarbBillingDTO = null;

        try {

            String sql = "SELECT c FROM CsfCardFeeSarbBilling c " + buildWhereClause(csfCardFeeSarbBillingDTO);
            List<CsfCardFeeSarbBilling> feeSarbBillingList = cardFeeSarbBillingDao.executeQueryParameters(sql, map);

            for (CsfCardFeeSarbBilling feeSarbBilling : feeSarbBillingList) {
                sarbBillingDTO = new CsfCardFeeSarbBillingDTO();

                if (feeSarbBilling.getChangeOverDate() != null) {
                    sarbBillingDTO.setChangeOverDate(feeSarbBilling.getChangeOverDate());
                }
                if (feeSarbBilling.getCreditPercent() != null) {
                    sarbBillingDTO.setCreditPercent(feeSarbBilling.getCreditPercent());
                }
                if (feeSarbBilling.getCreditRate() != null) {
                    sarbBillingDTO.setCreditRate(feeSarbBilling.getCreditRate());
                }
                if (feeSarbBilling.getDebitPercent() != null) {
                    sarbBillingDTO.setDebitPercent(feeSarbBilling.getDebitPercent());
                }
                if (feeSarbBilling.getDebitRate() != null) {
                    sarbBillingDTO.setDebitRate(feeSarbBilling.getDebitRate());
                }
                if (feeSarbBilling.getOldCreditPercent() != null) {
                    sarbBillingDTO.setOldCreditPercent(feeSarbBilling.getOldCreditPercent());
                }
                if (feeSarbBilling.getOldCreditRate() != null) {
                    sarbBillingDTO.setOldCreditRate(feeSarbBilling.getOldCreditRate());
                }
                if (feeSarbBilling.getOldDebitPercent() != null) {
                    sarbBillingDTO.setOldDebitPercent(feeSarbBilling.getOldDebitPercent());
                }
                if (feeSarbBilling.getOldDebitRate() != null) {
                    sarbBillingDTO.setOldCreditRate(feeSarbBilling.getOldDebitRate());
                }
                if (feeSarbBilling.getRateDescriptor() != null) {
                    sarbBillingDTO.setRateDescriptor(feeSarbBilling.getRateDescriptor());
                }
                dtoList.add(sarbBillingDTO);
            }
        } catch (Exception ex) {
            throw new DAOException("Error retrieving CSF_CARD_FEE_SARB_BILLING entries, cause: " + ex.getMessage(), ex);
        }
        map.clear();
        return dtoList;
    }

    private String buildWhereClause(CsfCardFeeSarbBillingDTO csfCardFeeSarbBillingDTO) {

        if (csfCardFeeSarbBillingDTO == null) {
            return "";
        }
        StringBuilder buff = new StringBuilder();
        boolean whereClause = false;

        if (csfCardFeeSarbBillingDTO.getChangeOverDate() != null) {
            if (!whereClause) {
                whereClause = true;
                buff.append(" WHERE ");
            } else {
                buff.append(" AND ");
            }

            buff.append("c.changeOverDate =:changeOverDate");
            map.put("c.changeOverDate", csfCardFeeSarbBillingDTO.getChangeOverDate());
        }

        if (csfCardFeeSarbBillingDTO.getCreditPercent() != null) {
            if (!whereClause) {
                whereClause = true;
                buff.append(" WHERE ");
            } else {
                buff.append(" AND ");
            }

            buff.append("c.creditPercent =:creditPercent");
            map.put("creditPercent", csfCardFeeSarbBillingDTO.getCreditPercent());
        }

        if (csfCardFeeSarbBillingDTO.getCreditRate() != null) {
            if (!whereClause) {
                whereClause = true;
                buff.append(" WHERE ");
            } else {
                buff.append(" AND ");
            }

            buff.append("c.creditRate =:creditRate");
            map.put("creditRate", csfCardFeeSarbBillingDTO.getCreditRate());
        }

        if (csfCardFeeSarbBillingDTO.getDebitPercent() != null) {
            if (!whereClause) {
                whereClause = true;
                buff.append(" WHERE ");
            } else {
                buff.append(" AND ");
            }

            buff.append("c.debitPercent =:debitPercent");
            map.put("debitPercent", csfCardFeeSarbBillingDTO.getDebitPercent());
        }

        if (csfCardFeeSarbBillingDTO.getDebitRate() != null) {
            if (!whereClause) {
                whereClause = true;
                buff.append(" WHERE ");
            } else {
                buff.append(" AND ");
            }

            buff.append("c.debitRate =:debitRate");
            map.put("debitRate", csfCardFeeSarbBillingDTO.getDebitRate());
        }

        if (csfCardFeeSarbBillingDTO.getOldCreditPercent() != null) {
            if (!whereClause) {
                whereClause = true;
                buff.append(" WHERE ");
            } else {
                buff.append(" AND ");
            }

            buff.append("c.oldCreditPercent =:oldCreditPercent");
            map.put("oldCreditPercent", csfCardFeeSarbBillingDTO.getOldCreditPercent());
        }

        if (csfCardFeeSarbBillingDTO.getOldCreditRate() != null) {
            if (!whereClause) {
                whereClause = true;
                buff.append(" WHERE ");
            } else {
                buff.append(" AND ");
            }

            buff.append("c.oldCreditRate =:oldCreditRate");
            map.put("oldCreditRate", csfCardFeeSarbBillingDTO.getOldCreditRate());
        }

        if (csfCardFeeSarbBillingDTO.getOldDebitPercent() != null) {
            if (!whereClause) {
                whereClause = true;
                buff.append(" WHERE ");
            } else {
                buff.append(" AND ");
            }

            buff.append("c.oldDebitPercent =:oldDebitPercent");
            map.put("oldCreditPercent", csfCardFeeSarbBillingDTO.getOldDebitPercent());
        }

        if (csfCardFeeSarbBillingDTO.getOldDebitRate() != null) {
            if (!whereClause) {
                whereClause = true;
                buff.append(" WHERE ");
            } else {
                buff.append(" AND ");
            }

            buff.append("c.oldDebitRate =:oldDebitRate");
            map.put("oldDebitRate", csfCardFeeSarbBillingDTO.getOldDebitRate());
        }

        if (csfCardFeeSarbBillingDTO.getRateDescriptor() != null) {
            if (!whereClause) {
                whereClause = true;
                buff.append(" WHERE ");
            } else {
                buff.append(" AND ");
            }

            buff.append("c.rateDescriptor =:rateDescriptor");
            map.put("rateDescriptor", csfCardFeeSarbBillingDTO.getRateDescriptor());
        }

        return buff.toString();
    }

    public void update(CsfCardFeeSarbBillingDTO csfCardFeeSarbBillingDTO) throws DAOException {

    }

    public void delete(CsfCardFeeSarbBillingDTO csfCardFeeSarbBillingDTO) throws DAOException {

    }

}
