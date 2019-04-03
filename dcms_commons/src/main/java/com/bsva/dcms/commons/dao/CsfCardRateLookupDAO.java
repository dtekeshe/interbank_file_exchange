package com.bsva.dcms.commons.dao;

import com.bsva.dao.CsfCardRateLookupDao;
import com.bsva.dcms.commons.dto.CsfCardRateLookupDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.entities.CsfCardRateLookup;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author SimphiweT
 */
public class CsfCardRateLookupDAO {

    private Map<String, Object> map = new HashMap<>();
    private CsfCardRateLookupDao csfCardRateLookupDao = new CsfCardRateLookupDao();

    public CsfCardRateLookupDAO() {
    }

    public void create(CsfCardRateLookupDTO csfCardRateLookupDTO) throws DAOException {

        CsfCardRateLookup csfCardRateLookup = new CsfCardRateLookup();
        try {
            csfCardRateLookup.getCsfCardRateLookupPK().setCardPresent(csfCardRateLookupDTO.getCardPresent());
            csfCardRateLookup.getCsfCardRateLookupPK().setChipCard(csfCardRateLookupDTO.getChipCard());
            csfCardRateLookup.getCsfCardRateLookupPK().setECommInd(csfCardRateLookupDTO.geteCommInd());
            csfCardRateLookup.getCsfCardRateLookupPK().setPosEntryMode(csfCardRateLookupDTO.getPosEntryMode());
            csfCardRateLookup.setRateDescriptor(csfCardRateLookupDTO.getRateDescriptor());
            csfCardRateLookup.getCsfCardRateLookupPK().setSubService(csfCardRateLookupDTO.getSubService());
            csfCardRateLookup.getCsfCardRateLookupPK().setTerminalCapability(csfCardRateLookupDTO.getTerminalCapability());
            csfCardRateLookupDao.create(csfCardRateLookup);

        } catch (Exception ex) {
            throw new DAOException("Error creating CSF_CARD_RATE_LOOKUP entry, cause: " + ex.getMessage(), ex);
        }

    }

    public CsfCardRateLookupDTO retrieve(CsfCardRateLookupDTO csfCardRateLookupDTO) throws DAOException {

        CsfCardRateLookupDTO lookupDTO = new CsfCardRateLookupDTO();

        String sql = "SELECT c FROM CsfCardRateLookup c " + buildWhereClause(csfCardRateLookupDTO);

        CsfCardRateLookup rateLookup = csfCardRateLookupDao.executeQueryParametersSingle(sql, map);

        if (rateLookup == null) {
            return null;
        } else {

            try {
                if (rateLookup.getCsfCardRateLookupPK().getCardPresent() != null) {
                    lookupDTO.setCardPresent(rateLookup.getCsfCardRateLookupPK().getCardPresent());
                }
                if (rateLookup.getCsfCardRateLookupPK().getChipCard() != null) {
                    lookupDTO.setChipCard(rateLookup.getCsfCardRateLookupPK().getChipCard());
                }
                if (rateLookup.getCsfCardRateLookupPK().getECommInd() != null) {
                    lookupDTO.seteCommInd(rateLookup.getCsfCardRateLookupPK().getECommInd());
                }
                if (rateLookup.getCsfCardRateLookupPK().getPosEntryMode() != null) {
                    lookupDTO.setPosEntryMode(rateLookup.getCsfCardRateLookupPK().getPosEntryMode());
                }
                if (rateLookup.getRateDescriptor() != null) {
                    lookupDTO.setRateDescriptor(rateLookup.getRateDescriptor());
                }

                if (rateLookup.getCsfCardRateLookupPK().getSubService() != null) {
                    lookupDTO.setSubService(rateLookup.getCsfCardRateLookupPK().getSubService());
                }
                if (rateLookup.getCsfCardRateLookupPK().getTerminalCapability() != null) {
                    lookupDTO.setTerminalCapability(rateLookup.getCsfCardRateLookupPK().getTerminalCapability());
                }

            } catch (Exception ex) {
                // throw new DAOException("Error creating CSF_CARD_RATE_LOOKUP entry, cause: " + ex.getMessage(), ex);
            }
            map.clear();
            return lookupDTO;
        }        
    }

    public List<CsfCardRateLookupDTO> retrieveRelated(CsfCardRateLookupDTO csfCardRateLookupDTO) throws DAOException {

        List<CsfCardRateLookupDTO> dtoList = new LinkedList<>();

        CsfCardRateLookupDTO lookupDTO = null;

        try {

            String sql = "SELECT c FROM CsfCardRateLookup c " + buildWhereClause(csfCardRateLookupDTO);

            List<CsfCardRateLookup> rateLookupList = csfCardRateLookupDao.executeQueryParameters(sql, map);

            lookupDTO = new CsfCardRateLookupDTO();

            for (CsfCardRateLookup rateLookup : rateLookupList) {

                if (rateLookup.getCsfCardRateLookupPK().getCardPresent() != null) {
                    lookupDTO.setCardPresent(rateLookup.getCsfCardRateLookupPK().getCardPresent());
                }
                if (rateLookup.getCsfCardRateLookupPK().getChipCard() != null) {
                    lookupDTO.setChipCard(rateLookup.getCsfCardRateLookupPK().getChipCard());
                }
                if (rateLookup.getCsfCardRateLookupPK().getECommInd() != null) {
                    lookupDTO.seteCommInd(rateLookup.getCsfCardRateLookupPK().getECommInd());
                }
                if (rateLookup.getCsfCardRateLookupPK().getPosEntryMode() != null) {
                    lookupDTO.setPosEntryMode(rateLookup.getCsfCardRateLookupPK().getPosEntryMode());
                }
                if (rateLookup.getRateDescriptor() != null) {
                    lookupDTO.setRateDescriptor(rateLookup.getRateDescriptor());
                }
                if (rateLookup.getCsfCardRateLookupPK().getSubService() != null) {
                    lookupDTO.setSubService(rateLookup.getCsfCardRateLookupPK().getSubService());
                }
                if (rateLookup.getCsfCardRateLookupPK().getTerminalCapability() != null) {
                    lookupDTO.setTerminalCapability(rateLookup.getCsfCardRateLookupPK().getTerminalCapability());
                }

                dtoList.add(lookupDTO);
            }

        } catch (Exception ex) {
            throw new DAOException("Error retrieving CSF_CARD_RATE_LOOKUP entry, cause: " + ex.getMessage(), ex);
        }
        map.clear();

        return dtoList;

    }

    private String buildWhereClause(CsfCardRateLookupDTO csfCardRateLookupDTO) {

        if (csfCardRateLookupDTO == null) {
            return "";
        }
        StringBuilder buff = new StringBuilder();
        boolean whereClause = false;

        if (csfCardRateLookupDTO.getCardPresent() != null) {
            if (!whereClause) {
                whereClause = true;
                buff.append(" WHERE ");
            } else {
                buff.append(" AND ");
            }

            buff.append("c.csfCardRateLookupPK.cardPresent =:cardPresent");
            map.put("cardPresent", csfCardRateLookupDTO.getCardPresent());
        }

        if (csfCardRateLookupDTO.getChipCard() != null) {
            if (!whereClause) {
                whereClause = true;
                buff.append(" WHERE ");
            } else {
                buff.append(" AND ");
            }

            buff.append("c.csfCardRateLookupPK.chipCard =:chipCard");
            map.put("chipCard", csfCardRateLookupDTO.getChipCard());
        }

        if (csfCardRateLookupDTO.getPosEntryMode() != null) {
            if (!whereClause) {
                whereClause = true;
                buff.append(" WHERE ");
            } else {
                buff.append(" AND ");
            }

            buff.append("c.csfCardRateLookupPK.posEntryMode =:posEntryMode");
            map.put("posEntryMode", csfCardRateLookupDTO.getPosEntryMode());
        }
      
        if (csfCardRateLookupDTO.getService() != null) {
            if (!whereClause) {
                whereClause = true;
                buff.append(" WHERE ");
            } else {
                buff.append(" AND ");
            }

            buff.append("c.csfCardRateLookupPK.service =:service");
            map.put("service", csfCardRateLookupDTO.getService());
        }

        if (csfCardRateLookupDTO.getTerminalCapability() != null) {
            if (!whereClause) {
                whereClause = true;
                buff.append(" WHERE ");
            } else {
                buff.append(" AND ");
            }

            buff.append("c.csfCardRateLookupPK.terminalCapability =:terminalCapability");
            map.put("terminalCapability", csfCardRateLookupDTO.getTerminalCapability());
        }

        if (csfCardRateLookupDTO.geteCommInd() != null) {
            if (!whereClause) {
                whereClause = true;
                buff.append(" WHERE ");
            } else {
                buff.append(" AND ");
            }

            buff.append("c.csfCardRateLookupPK.eCommInd =:eCommInd");
            map.put("eCommInd", csfCardRateLookupDTO.geteCommInd());
        }

        return buff.toString();
    }

    public void update(CsfCardRateLookupDTO csfCardRateLookupDTO) throws DAOException {

    }

    public void delete(CsfCardRateLookupDTO csfCardRateLookupDTO) throws DAOException {

    }

}
