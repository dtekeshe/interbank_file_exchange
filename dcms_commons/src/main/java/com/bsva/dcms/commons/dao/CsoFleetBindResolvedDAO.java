package com.bsva.dcms.commons.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import com.bsva.dao.CsoFleetBindResolvedDao;
import com.bsva.dcms.commons.dto.CsoFleetBindResolvedDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.entities.CsoFleetBindResolved;
import com.bsva.entities.CsoFleetBindResolvedPK;    

/**
 * Data access object interface that defines the methods that must be supported
 * by all data access objects.
 * 
* Created By BSVATools
 */

public class CsoFleetBindResolvedDAO {

    private Map<String, Object> map = new HashMap<>();
    private CsoFleetBindResolvedDao csofleetBindResolvedDao = new CsoFleetBindResolvedDao();

    public CsoFleetBindResolvedDAO() {
    }

    /**
     * Create a new record in Database.
     *
     * @param bean The Object to be inserted.
     * @throws com.bsva.dcms.commons.exceptions.DAOException
     */
    public void create(CsoFleetBindResolvedDTO bean) throws DAOException {
        try {

            CsoFleetBindResolved csoFleetBindResolved = new CsoFleetBindResolved();
            CsoFleetBindResolvedPK csoFleetBindResolvedPk = new CsoFleetBindResolvedPK();
            csoFleetBindResolvedPk.setAcq(bean.getAcq());
            csoFleetBindResolvedPk.setIss(bean.getIss());
            csoFleetBindResolvedPk.setService(bean.getService());
            csoFleetBindResolvedPk.setSubService(bean.getSubService());
            csoFleetBindResolvedPk.setTxCde(bean.getTxCde());
            csoFleetBindResolvedPk.setTxDateTime(bean.getTxDateTime());                        
            csoFleetBindResolved.setCsoFleetBindResolvedPK(csoFleetBindResolvedPk);            
            csoFleetBindResolved.setAccNo(bean.getAccNo());
            csoFleetBindResolved.setAcquirerBin(bean.getAcquirerBin());
            csoFleetBindResolved.setIssuerBin(bean.getIssuerBin());
            csoFleetBindResolved.setAmount(bean.getAmount());
            csoFleetBindResolved.setCardType(bean.getCardType());
            csoFleetBindResolved.setFileSystemSeqNumber(bean.getFileSystemSeqNumber());
            //csoFleetBindResolved.setProcessDate(bean.getProcessDate());
            csoFleetBindResolved.setProduct(bean.getProduct());
            csoFleetBindResolved.setSubProduct(bean.getSubProduct());
            csoFleetBindResolved.setTranSystemSeqNumber(bean.getTranSystemSeqNumber());
            csoFleetBindResolved.setTxCnt(bean.getTxCnt());

            csofleetBindResolvedDao.create(csoFleetBindResolved);

        } catch (Exception ex) {
            throw new DAOException("Error creating CCCOWNER.CSO_FLEET_BIND_RESOLVED, cause: " + ex.getMessage(), ex);
        }
    }

    /**
     * Retrieve a record from Database.
     *
     * @param bean The Object to be retrieved.
     * @return
     * @throws com.bsva.dcms.commons.exceptions.DAOException
     */
    public CsoFleetBindResolvedDTO retrieve(CsoFleetBindResolvedDTO bean) throws DAOException {
        try {
            CsoFleetBindResolvedDTO csoFleetBindResolvedDTO = new CsoFleetBindResolvedDTO();

            String sql = "SELECT c FROM CsoFleetBindResolved c " + buildWhereClause(bean, true);
            CsoFleetBindResolved csoFleetBindResolved = csofleetBindResolvedDao.executeQueryParametersSingleDate(sql, map);

            csoFleetBindResolvedDTO.setAccNo(csoFleetBindResolved.getAccNo());
            csoFleetBindResolvedDTO.setAcq(csoFleetBindResolved.getCsoFleetBindResolvedPK().getAcq());
            csoFleetBindResolvedDTO.setAcquirerBin(csoFleetBindResolved.getAcquirerBin());
            csoFleetBindResolvedDTO.setAmount(csoFleetBindResolved.getAmount());
            csoFleetBindResolvedDTO.setCardType(csoFleetBindResolved.getCardType());
            csoFleetBindResolvedDTO.setFileSystemSeqNumber(csoFleetBindResolved.getFileSystemSeqNumber());
            csoFleetBindResolvedDTO.setIss(csoFleetBindResolved.getCsoFleetBindResolvedPK().getIss());
            csoFleetBindResolvedDTO.setProcessDate(csoFleetBindResolved.getProcessDate());
            csoFleetBindResolvedDTO.setProduct(csoFleetBindResolved.getProduct());
            csoFleetBindResolvedDTO.setService(csoFleetBindResolved.getCsoFleetBindResolvedPK().getService());
            csoFleetBindResolvedDTO.setSubProduct(csoFleetBindResolved.getSubProduct());
            csoFleetBindResolvedDTO.setTranSystemSeqNumber(csoFleetBindResolved.getTranSystemSeqNumber());
            csoFleetBindResolvedDTO.setTxCde(csoFleetBindResolved.getCsoFleetBindResolvedPK().getTxCde());
            csoFleetBindResolvedDTO.setTxCnt(csoFleetBindResolved.getTxCnt());
            csoFleetBindResolvedDTO.setTxDateTime(csoFleetBindResolved.getCsoFleetBindResolvedPK().getTxDateTime());

            return csoFleetBindResolvedDTO;
        } catch (Exception ex) {
            return null;
            //throw new DAOException("Error retrieving CCCOWNER.CSO_FLEET_BIND_RESOLVED, cause: " + ex.getMessage(), ex);            
        }
    }

    /**
     * Retrieve a list of records from Database.
     *
     * @param csoFleetBindResolvedDTOs
     * @return
     * @throws com.bsva.dcms.commons.exceptions.DAOException
     */
    public List<CsoFleetBindResolvedDTO> retrieveRelated(CsoFleetBindResolvedDTO csoFleetBindResolvedDTOs) throws DAOException {
        try {

            List<CsoFleetBindResolvedDTO> csoFleetBindResolvedDTOList = new LinkedList<>();

            String sql = "SELECT c FROM CsoFleetBindResolved c " + buildWhereClause(csoFleetBindResolvedDTOs, true);
            List<CsoFleetBindResolved> csoFleetBindResolvedList = csofleetBindResolvedDao.executeQueryParametersDate(sql, map);
            for (CsoFleetBindResolved csoFleetBindResolved : csoFleetBindResolvedList) {

                CsoFleetBindResolvedDTO csoFleetBindResolvedDTO = new CsoFleetBindResolvedDTO();
                csoFleetBindResolvedDTO.setAccNo(csoFleetBindResolved.getAccNo());
                csoFleetBindResolvedDTO.setAcq(csoFleetBindResolved.getCsoFleetBindResolvedPK().getAcq());
                csoFleetBindResolvedDTO.setAcquirerBin(csoFleetBindResolved.getAcquirerBin());
                csoFleetBindResolvedDTO.setAmount(csoFleetBindResolved.getAmount());
                csoFleetBindResolvedDTO.setCardType(csoFleetBindResolved.getCardType());
                csoFleetBindResolvedDTO.setFileSystemSeqNumber(csoFleetBindResolved.getFileSystemSeqNumber());
                csoFleetBindResolvedDTO.setIss(csoFleetBindResolved.getCsoFleetBindResolvedPK().getIss());
                csoFleetBindResolvedDTO.setProcessDate(csoFleetBindResolved.getProcessDate());
                csoFleetBindResolvedDTO.setProduct(csoFleetBindResolved.getProduct());
                csoFleetBindResolvedDTO.setService(csoFleetBindResolved.getCsoFleetBindResolvedPK().getService());
                csoFleetBindResolvedDTO.setSubProduct(csoFleetBindResolved.getSubProduct());
                csoFleetBindResolvedDTO.setTranSystemSeqNumber(csoFleetBindResolved.getTranSystemSeqNumber());
                csoFleetBindResolvedDTO.setTxCde(csoFleetBindResolved.getCsoFleetBindResolvedPK().getTxCde());
                csoFleetBindResolvedDTO.setTxCnt(csoFleetBindResolved.getTxCnt());
                csoFleetBindResolvedDTO.setTxDateTime(csoFleetBindResolved.getCsoFleetBindResolvedPK().getTxDateTime());
                csoFleetBindResolvedDTOList.add(csoFleetBindResolvedDTO);

            }
            map.clear();
            return csoFleetBindResolvedDTOList;
        } catch (Exception ex) {
            throw new DAOException("Error retrieving related CCCOWNER.CSO_FLEET_BIND_RESOLVED, cause: " + ex.getMessage(), ex);
        }
    }

    /**
     * Update a record in Database.
     *
     * @param bean The Object to be updated.
     * @throws com.bsva.dcms.commons.exceptions.DAOException
     */
    public void update(CsoFleetBindResolvedDTO bean) throws DAOException {
        try {

            CsoFleetBindResolved csoFleetBindResolved = new CsoFleetBindResolved();
            CsoFleetBindResolvedPK csoFleetBindResolvedPk = new CsoFleetBindResolvedPK();
            csoFleetBindResolvedPk.setAcq((short) bean.getAcq());
            csoFleetBindResolvedPk.setIss((short) bean.getIss());
            csoFleetBindResolvedPk.setService(bean.getService());
            csoFleetBindResolvedPk.setSubService(bean.getSubService());
            csoFleetBindResolvedPk.setTxCde((short) bean.getTxCde());
            csoFleetBindResolvedPk.setTxDateTime(bean.getTxDateTime());
            csoFleetBindResolved.setAccNo(bean.getAccNo());
            csoFleetBindResolved.setIssuerBin(bean.getIssuerBin());
            csoFleetBindResolved.setAcquirerBin(bean.getAcquirerBin());
            csoFleetBindResolved.setAmount(bean.getAmount());
            csoFleetBindResolved.setCardType((short) bean.getCardType());
            csoFleetBindResolved.setCsoFleetBindResolvedPK(csoFleetBindResolvedPk);
            csoFleetBindResolved.setFileSystemSeqNumber(bean.getFileSystemSeqNumber());
            csoFleetBindResolved.setProcessDate(bean.getProcessDate());
            csoFleetBindResolved.setProduct(bean.getProduct());
            csoFleetBindResolved.setSubProduct(bean.getSubProduct());
            csoFleetBindResolved.setTranSystemSeqNumber(bean.getFileSystemSeqNumber());
            csoFleetBindResolved.setTxCnt((short) bean.getTxCnt());

            csofleetBindResolvedDao.update(csoFleetBindResolved);

        } catch (Exception ex) {
            throw new DAOException("Error updating CCCOWNER.CSO_FLEET_BIND_RESOLVED, cause: " + ex.getMessage(), ex);
        }
    }

    /**
     * Delete a record in Database.
     *
     * @param bean The Object to be deleted.
     * @throws com.bsva.dcms.commons.exceptions.DAOException
     */
    public void delete(CsoFleetBindResolvedDTO bean) throws DAOException {
        try {

        } catch (Exception ex) {
            throw new DAOException("Error deleting CCCOWNER.CSO_FLEET_BIND_RESOLVED, cause: " + ex.getMessage(), ex);
        }
    }

    /**
     * Build a Dynamic Where Clause.
     *
     * @param bean The Object to be used.
     * @param select Is the where clause for a Query or Update.
     * @exception SQLException if something is wrong.
     */
    private String buildWhereClause(CsoFleetBindResolvedDTO bean, boolean select) throws DAOException {
        if (bean == null) {
            return "";
        }

        StringBuilder buff = new StringBuilder();
        boolean whereClause = false;

        if (bean.getService() != null && !bean.getService().isEmpty()) {
            if (!whereClause) {
                whereClause = true;
                buff.append(" WHERE ");
            } else {
                buff.append(" AND ");
            }
            buff.append("c.csoFleetBindResolvedPK.service =:service");
            map.put("service", bean.getService());
        }
        if (bean.getSubService() != null && !bean.getSubService().isEmpty()) {
            if (!whereClause) {
                whereClause = true;
                buff.append(" WHERE ");
            } else {
                buff.append(" AND ");
            }
            buff.append("c.csoFleetBindResolvedPK.subService =:subService");
            map.put("subService", bean.getSubService());
        }
        if (bean.getCardType() > 0) {
            if (!whereClause) {
                whereClause = true;
                buff.append(" WHERE ");
            } else {
                buff.append(" AND ");
            }
            buff.append("c.cardType =:cardType");
            map.put("cardType", bean.getCardType());
        }
        if (bean.getProcessDate() != null) {
            if (!whereClause) {
                whereClause = true;
                buff.append(" WHERE ");
            } else {
                buff.append(" AND ");
            }
            buff.append("c.processDate =:processDate");
            map.put("processDate", bean.getProcessDate());
        }
        if (select == true) {
            if (bean.getIss() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }
                buff.append("c.csoFleetBindResolvedPK.iss =:iss");
                map.put("iss", bean.getIss());
            }
            if (bean.getAcq() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }
                buff.append("c.csoFleetBindResolvedPK.acq =:acq");
                map.put("acq", bean.getAcq());
            }
            if (bean.getAccNo() != null && !bean.getAccNo().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }
                buff.append("c.accNo =:accNo");
                map.put("accNo", bean.getAccNo());
            }
            if (bean.getTxCde() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }
                buff.append("c.csoFleetBindResolvedPK.txCde =:txCde");
                map.put("txCde", bean.getTxCde());
            }
            /*if (bean.getAmount() > ) {
             if(!whereClause) {
             whereClause = true;
             buff.append(" WHERE ");
             }
             else {
             buff.append(" AND ");
             }
             buff.append("c.amount =:amount");
             map.put("amount",bean.getAmount());
             }*/
            if (bean.getTxDateTime() > 0L) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }
                buff.append("c.csoFleetBindResolvedPK.txDateTime =:txDateTime");
                map.put("txDateTime", bean.getTxDateTime());
            }
            if (bean.getProduct() != null && !bean.getProduct().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }
                buff.append("c.product =:product");
                map.put("product", bean.getProduct());
            }
            if (bean.getSubProduct() != null && !bean.getSubProduct().isEmpty()) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }
                buff.append("c.subProduct =:subProduct");
                map.put("subProduct", bean.getSubProduct());
            }
            if (bean.getTxCnt() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }
                buff.append("c.txCnt =:txCnt");
                map.put("txCnt", bean.getTxCnt());
            }
            if (bean.getAcquirerBin() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }
                buff.append("c.acquirerBin =:acquirerBin");
                map.put("acquirerBin", bean.getAcquirerBin());
            }
            if (bean.getFileSystemSeqNumber() > 0L) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }
                buff.append("c.fileSystemSeqNumber =:fileSystemSeqNumber");
                map.put("fileSystemSeqNumber", bean.getFileSystemSeqNumber());
            }
            if (bean.getTranSystemSeqNumber() > 0L) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }
                buff.append("c.tranSystemSeqNumber =:tranSystemSeqNumber");
                map.put("tranSystemSeqNumber", bean.getTranSystemSeqNumber());
            }
        }
        if (!whereClause && select == false) {
            throw new DAOException("Cannot update delete all rows in CCCOWNER.CSO_FLEET_BIND_RESOLVED");
        }
        return buff.toString();
    }

    public void delete() throws DAOException {
        csofleetBindResolvedDao.deleteBulk("Delete from CsoFleetBindResolved");
    }

}
