package com.bsva.dcms.commons.dao;

import com.bsva.dao.CsoBillingSummaryDao;
import com.bsva.dcms.commons.dto.CsoBillingSummaryDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.entities.CsoBillingSummary;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author SimphiweT
 */
public class CsoBillingSummaryDAO {

    private CsoBillingSummaryDao billingSummaryDao = new CsoBillingSummaryDao();
    private Map<String, Object> map = new HashMap<>();

    public void create(CsoBillingSummaryDTO bean) throws DAOException {
        
        CsoBillingSummary csoBillingSummary = new CsoBillingSummary();
        
        try {            
            csoBillingSummary.setProcessDate(bean.getProcessDate());
            csoBillingSummary.setIssuingMember(bean.getIssuingMember());
            csoBillingSummary.setService(bean.getService());
            csoBillingSummary.setValue(bean.getValue());
            csoBillingSummary.setValueAbove(bean.getValueAbove());
            csoBillingSummary.setValueBelow(bean.getValueBelow());
            csoBillingSummary.setVolume(bean.getVolume());
            csoBillingSummary.setVolumeAbove(bean.getVolumeAbove());
            csoBillingSummary.setVolumeBelow(bean.getVolumeBelow());
            
            billingSummaryDao.create(csoBillingSummary);
        } catch (Exception ex) {
            throw new DAOException("Error creating CCCOWNER.COS_BILLING_SUMMARY, cause: " + ex.getMessage(), ex);
        }
    }

    public CsoBillingSummary retrieve(CsoBillingSummaryDTO bean) throws DAOException {

        CsoBillingSummaryDTO csoBillingSummaryDTO = new CsoBillingSummaryDTO();
        try {
            String sql = "SELECT c  FROM CsoBillingSummary c " + buildWhereClause(bean, true);
            CsoBillingSummary billingSummaryDTO = billingSummaryDao.executeQueryParametersSingle(sql, map);

            if (csoBillingSummaryDTO.getService() != null) {
                csoBillingSummaryDTO.setService(bean.getService());
            }
            if (csoBillingSummaryDTO.getProcessDate() != null) {
                csoBillingSummaryDTO.setProcessDate(bean.getProcessDate());
            }
            if (csoBillingSummaryDTO.getValue() != null) {
                csoBillingSummaryDTO.setVolume(bean.getVolume());
            }
            if (csoBillingSummaryDTO.getIssuingMember() < 0) {
                csoBillingSummaryDTO.setIssuingMember(bean.getIssuingMember());
            }
            if (csoBillingSummaryDTO.getValue() != null) {
                csoBillingSummaryDTO.setValue(bean.getValue());
            }

            map.clear();
            return billingSummaryDTO;

        } catch (Exception ex) {
            throw new DAOException("Error retrieving CCCOWNER.CSO_BILLING_SUMMARY, cause: " + ex.getMessage(), ex);
        }
    }

    public List<CsoBillingSummaryDTO> retrieveRelated(CsoBillingSummaryDTO obj) throws DAOException {

        List<CsoBillingSummaryDTO> dtoList = new LinkedList<CsoBillingSummaryDTO>();

        CsoBillingSummaryDTO dto = null;

        try {
            String sql = "SELECT c FROM CsoBillingSummary c " + buildWhereClause(obj, true);
            List<CsoBillingSummary> billingSummaryDTOList = billingSummaryDao.executeQueryParameters(sql, map);

            for (CsoBillingSummary billingSummaryDTO : billingSummaryDTOList) {
                dto = new CsoBillingSummaryDTO();

                if (billingSummaryDTO.getService() != null) {
                    dto.setService(billingSummaryDTO.getService());
                }
                if (billingSummaryDTO.getIssuingMember() > 0) {
                    dto.setIssuingMember(billingSummaryDTO.getIssuingMember());
                }

                dtoList.add(dto);
            }
        } catch (Exception ex) {
            throw new DAOException("Error retrieving CSF_DIRECTORIES entries, cause: " + ex.getMessage(), ex);
        }
        map.clear();
        return dtoList;
    }

    private String buildWhereClause(CsoBillingSummaryDTO bean, boolean select) throws DAOException {
        if (bean == null) {
            return "";
        }

        StringBuilder buff = new StringBuilder();
        boolean whereClause = false;

        if (bean.getIssuingMember() > 0) {
            if (!whereClause) {
                whereClause = true;
                buff.append(" WHERE ");
            } else {
                buff.append(" AND ");
            }

            buff.append("c.issuingMember= :issuingMember");
            map.put("issuingMember", bean.getIssuingMember());
        }

        if (select == true) {
            if (bean.getService() != null && !bean.getService().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.subService= :subService");
                map.put("subService", bean.getService());
            }
        }
        if (!whereClause && select == false) {
            throw new DAOException("Cannot update delete all rows in CCCOWNER.CSO_BILLING_SUMMARY");
        }
        return buff.toString();
    }

}
