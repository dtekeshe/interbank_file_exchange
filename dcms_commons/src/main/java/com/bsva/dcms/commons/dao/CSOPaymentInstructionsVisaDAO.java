package com.bsva.dcms.commons.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;

import com.bsva.dao.CsoPaymentInstructionsVisaDao;
import com.bsva.dcms.commons.dto.CSOPaymentInstructionsVisaDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.entities.CsoPaymentInstructionsVisa;
import com.bsva.entities.CsoPaymentInstructionsVisaPK;

public class CSOPaymentInstructionsVisaDAO {

    //private CsoPaymentInstructionsVisaRepository csoPaymentInstructionsVisaRepoDao = DaoFactory.csoPaymentInstructionsVisaInstance();
    private CsoPaymentInstructionsVisaDao csoPaymentInstructionsVisaDao = new CsoPaymentInstructionsVisaDao();
    private Map<String, Object> map = new HashMap<String, Object>();

    public CSOPaymentInstructionsVisaDAO() {

    }

    public void create(CSOPaymentInstructionsVisaDTO csoPaymentInstructionsVisaDTO) throws DAOException {
        try {
            CsoPaymentInstructionsVisa csoPaymentInstructionsVisa = new CsoPaymentInstructionsVisa();

            csoPaymentInstructionsVisa.setFileRefNumber(csoPaymentInstructionsVisaDTO.getFileRefNumber());
            csoPaymentInstructionsVisa.setService(csoPaymentInstructionsVisaDTO.getService());
            csoPaymentInstructionsVisa.setSubService(csoPaymentInstructionsVisaDTO.getSubService());
            csoPaymentInstructionsVisa.setAcquirerMember(String.valueOf(csoPaymentInstructionsVisaDTO.getAcquierMember()));
            csoPaymentInstructionsVisa.setIssuerMember(String.valueOf(csoPaymentInstructionsVisaDTO.getIssuerMember()));
            csoPaymentInstructionsVisa.setAccountNumber(csoPaymentInstructionsVisaDTO.getAccountNumber());
            csoPaymentInstructionsVisa.setVisaAmount(BigDecimal.valueOf(csoPaymentInstructionsVisaDTO.getVisaAmount()));
            csoPaymentInstructionsVisa.setFinancialIndicator(csoPaymentInstructionsVisaDTO.getFinancialIndicator());
            csoPaymentInstructionsVisa.setTransactionCode(csoPaymentInstructionsVisaDTO.getTransactionCode());         
            
            csoPaymentInstructionsVisa.setTransactionCodeQualifier((short) csoPaymentInstructionsVisaDTO.getTransactionCodeQualifier());
            csoPaymentInstructionsVisa.setInputFileIdentifier(csoPaymentInstructionsVisaDTO.getInputFileIdentifier());
            csoPaymentInstructionsVisa.setInputSeqNumber(csoPaymentInstructionsVisaDTO.getInputSeqNumber());
            
            CsoPaymentInstructionsVisaPK csoPaymentInstructionsVisaPK = new CsoPaymentInstructionsVisaPK();
            csoPaymentInstructionsVisaPK.setSystemGenSeqNumber(csoPaymentInstructionsVisaDTO.getSystemGenSeqNumber());
            csoPaymentInstructionsVisaPK.setTransactionCodeNumber((short) csoPaymentInstructionsVisaDTO.getTransactionCodeNumber());
            csoPaymentInstructionsVisa.setCsoPaymentInstructionsVisaPK(csoPaymentInstructionsVisaPK);
            
            csoPaymentInstructionsVisa.setCardTransaction(csoPaymentInstructionsVisaDTO.getCardTransaction());
            csoPaymentInstructionsVisa.setProcessStatus(csoPaymentInstructionsVisaDTO.getProcessStatus());
            csoPaymentInstructionsVisa.setSettlementDate(new Date(csoPaymentInstructionsVisaDTO.getSettlementDate().getTime()));
            csoPaymentInstructionsVisa.setOutputDate(new Date(csoPaymentInstructionsVisaDTO.getOutputDate().getTime()));
            csoPaymentInstructionsVisa.setExchangeRate((long) csoPaymentInstructionsVisaDTO.getExchangeRate());
            csoPaymentInstructionsVisa.setAcquirerCountryCode(csoPaymentInstructionsVisaDTO.getAcquierCountryCode());
            csoPaymentInstructionsVisa.setIssuerCountryCode(csoPaymentInstructionsVisaDTO.getIssuerCountryCode());
            csoPaymentInstructionsVisa.setXborderIssuerCountryCode(csoPaymentInstructionsVisaDTO.getXborderCountryCode());
            csoPaymentInstructionsVisa.setXborderIssuerMember((short) csoPaymentInstructionsVisaDTO.getXborderIssuerMember());
            csoPaymentInstructionsVisa.setCardType(csoPaymentInstructionsVisaDTO.getCardType());
            csoPaymentInstructionsVisa.setFilenameDescription(csoPaymentInstructionsVisaDTO.getFilenameDescription());
            csoPaymentInstructionsVisa.setCashbackPurchase(csoPaymentInstructionsVisaDTO.getCashbackPurchase());
            csoPaymentInstructionsVisa.setCashbackPurchaseAmnt(BigDecimal.valueOf(csoPaymentInstructionsVisaDTO.getCashbackPurchaseAmnt()));
            // SARB Billing values
            //csoPaymentInstructionsVisa.setPosEntryModeIn(csoPaymentInstructionsVisaDTO.getPosEntryMode());
            csoPaymentInstructionsVisa.setTerminalCapability(csoPaymentInstructionsVisaDTO.getTerminalCapabilityIn());
            csoPaymentInstructionsVisa.setCardPresent(csoPaymentInstructionsVisaDTO.getCardholderIndIn());
            csoPaymentInstructionsVisa.setChipCard(csoPaymentInstructionsVisaDTO.getChipCard());
            csoPaymentInstructionsVisa.setEcommInd(csoPaymentInstructionsVisaDTO.getEcommInd());

            csoPaymentInstructionsVisaDao.create(csoPaymentInstructionsVisa);
        } catch (Exception ex) {
            ex.getMessage();
        }

    }

    public CSOPaymentInstructionsVisaDTO retrieve(CSOPaymentInstructionsVisaDTO bean) throws DAOException {
        CSOPaymentInstructionsVisaDTO csoPaymentInstructionsVisaDTO = new CSOPaymentInstructionsVisaDTO();
        try {

            String sql = "SELECT c FROM CsoPaymentInstructionsVisa c " + buildWhereClause(bean, true);
            CsoPaymentInstructionsVisa csoPaymentInstructionsVisa = csoPaymentInstructionsVisaDao.executeQueryParametersSingleDate(sql, map);

            if (csoPaymentInstructionsVisa.getFileRefNumber() != null) {
                csoPaymentInstructionsVisaDTO.setFileRefNumber(csoPaymentInstructionsVisa.getFileRefNumber());
            }
            if (csoPaymentInstructionsVisa.getService() != null) {
                csoPaymentInstructionsVisaDTO.setService(csoPaymentInstructionsVisa.getService());
            }
            if (csoPaymentInstructionsVisa.getSubService() != null) {
                csoPaymentInstructionsVisaDTO.setSubService(csoPaymentInstructionsVisa.getSubService());
            }
            if (csoPaymentInstructionsVisa.getAcquirerMember() != null) {
                csoPaymentInstructionsVisaDTO.setAcquierMember(Integer.valueOf(csoPaymentInstructionsVisa.getAcquirerMember()));
            }
            //if(csoPaymentInstructionsVisa.getIssuerMember()null){
            csoPaymentInstructionsVisaDTO.setIssuerMember(Integer.valueOf(csoPaymentInstructionsVisa.getIssuerMember()));
            //}
            if (csoPaymentInstructionsVisa.getAccountNumber() != null) {
                csoPaymentInstructionsVisaDTO.setAccountNumber(csoPaymentInstructionsVisa.getAccountNumber());
            }
            if (csoPaymentInstructionsVisa.getVisaAmount() != null) {
                csoPaymentInstructionsVisaDTO.setVisaAmount(csoPaymentInstructionsVisa.getVisaAmount().intValue());
            }
            if (csoPaymentInstructionsVisa.getFinancialIndicator() != null) {
                csoPaymentInstructionsVisaDTO.setFinancialIndicator(csoPaymentInstructionsVisa.getFinancialIndicator());
            }
            if (csoPaymentInstructionsVisa.getTransactionCode() != null) {
                csoPaymentInstructionsVisaDTO.setTransactionCode(csoPaymentInstructionsVisa.getTransactionCode());
            }
            if (csoPaymentInstructionsVisa.getTransactionCodeQualifier() != null) {
                csoPaymentInstructionsVisaDTO.setTransactionCodeQualifier(csoPaymentInstructionsVisa.getTransactionCodeQualifier().intValue());
            }
            /*if (csoPaymentInstructionsVisa.getTransactionCodeNumber() != null) {
                csoPaymentInstructionsVisaDTO.setTransactionCodeNumber(csoPaymentInstructionsVisa.getTransactionCodeNumber().intValue());
            }
            if (csoPaymentInstructionsVisa.getCsoPaymentInstructionsVisaPK() != null) {
                csoPaymentInstructionsVisaDTO.setInputSeqNumber((int) csoPaymentInstructionsVisa.getCsoPaymentInstructionsVisaPK().getInputSeqNumber());
            }*/
            csoPaymentInstructionsVisaDTO.setTransactionCodeNumber(csoPaymentInstructionsVisa.getCsoPaymentInstructionsVisaPK().getTransactionCodeNumber());
            csoPaymentInstructionsVisaDTO.setSystemGenSeqNumber((int)csoPaymentInstructionsVisa.getCsoPaymentInstructionsVisaPK().getSystemGenSeqNumber());
            
            if (csoPaymentInstructionsVisa.getCardTransaction() != null) {
                csoPaymentInstructionsVisaDTO.setCardTransaction(csoPaymentInstructionsVisa.getCardTransaction());
            }
            if (csoPaymentInstructionsVisa.getProcessStatus() != null) {
                csoPaymentInstructionsVisaDTO.setProcessStatus(csoPaymentInstructionsVisa.getProcessStatus());
            }
            if (csoPaymentInstructionsVisa.getInputFileIdentifier() != null) {
                csoPaymentInstructionsVisaDTO.setInputFileIdentifier(csoPaymentInstructionsVisa.getInputFileIdentifier());
            }
            if(csoPaymentInstructionsVisa.getInputSeqNumber() != 0){
            	csoPaymentInstructionsVisaDTO.setInputSeqNumber((int) csoPaymentInstructionsVisa.getInputSeqNumber());
            }
            if (csoPaymentInstructionsVisa.getSettlementDate() != null) {
                csoPaymentInstructionsVisaDTO.setSettlementDate(new Date(csoPaymentInstructionsVisa.getSettlementDate().getTime()));
            }
            if (csoPaymentInstructionsVisa.getOutputDate() != null) {
                csoPaymentInstructionsVisaDTO.setOutputDate(new Date(csoPaymentInstructionsVisa.getOutputDate().getTime()));
            }
            if (csoPaymentInstructionsVisa.getExchangeRate() != null) {
                csoPaymentInstructionsVisaDTO.setExchangeRate(csoPaymentInstructionsVisa.getExchangeRate().intValue());
            }
            if (csoPaymentInstructionsVisa.getAcquirerCountryCode() != null) {
                csoPaymentInstructionsVisaDTO.setAcquierCountryCode(csoPaymentInstructionsVisa.getAcquirerCountryCode());
            }
            if (csoPaymentInstructionsVisa.getIssuerCountryCode() != null) {
                csoPaymentInstructionsVisaDTO.setIssuerCountryCode(csoPaymentInstructionsVisa.getIssuerCountryCode());
            }
            if (csoPaymentInstructionsVisa.getXborderIssuerCountryCode() != null) {
                csoPaymentInstructionsVisaDTO.setXborderCountryCode(csoPaymentInstructionsVisa.getXborderIssuerCountryCode());
            }
            if (csoPaymentInstructionsVisa.getXborderIssuerMember() != null) {
                csoPaymentInstructionsVisaDTO.setXborderIssuerMember(csoPaymentInstructionsVisa.getXborderIssuerMember().intValue());
            }
            if (csoPaymentInstructionsVisa.getCardType() != null) {
                csoPaymentInstructionsVisaDTO.setCardType(csoPaymentInstructionsVisa.getCardType());
            }
            if (csoPaymentInstructionsVisa.getFilenameDescription() != null) {
                csoPaymentInstructionsVisaDTO.setFilenameDescription(csoPaymentInstructionsVisa.getFilenameDescription());
            }
            if (csoPaymentInstructionsVisa.getCashbackPurchase() != null) {
                csoPaymentInstructionsVisaDTO.setCashbackPurchase(csoPaymentInstructionsVisa.getCashbackPurchase());
            }
            if (csoPaymentInstructionsVisa.getCashbackPurchaseAmnt() != null) {
                csoPaymentInstructionsVisaDTO.setCashbackPurchaseAmnt(csoPaymentInstructionsVisa.getCashbackPurchaseAmnt().intValue());
            }
            
            if (csoPaymentInstructionsVisa.getChipCard() != null) {
                csoPaymentInstructionsVisaDTO.setChipCard(csoPaymentInstructionsVisa.getChipCard());
            }
            if (csoPaymentInstructionsVisa.getEcommInd() != null) {
                csoPaymentInstructionsVisaDTO.setEcommInd(csoPaymentInstructionsVisa.getEcommInd());
            }
            if (csoPaymentInstructionsVisa.getTerminalCapability() != null) {
                csoPaymentInstructionsVisaDTO.setTerminalCapability(csoPaymentInstructionsVisa.getTerminalCapability());
            }
            if (csoPaymentInstructionsVisa.getPosEntryMode() != null) {
                csoPaymentInstructionsVisaDTO.setPosEntryMode(csoPaymentInstructionsVisa.getPosEntryMode());
            }
            if (csoPaymentInstructionsVisa.getCardPresent() != null) {
                csoPaymentInstructionsVisaDTO.setCardPresent(csoPaymentInstructionsVisa.getCardPresent());
            }

        } catch (Exception ex) {
            ex.getMessage();
        }
        map.clear();
        return csoPaymentInstructionsVisaDTO;

    }

    @SuppressWarnings("unchecked")
    public List<CSOPaymentInstructionsVisaDTO> retrieveRelated(CSOPaymentInstructionsVisaDTO obj) throws DAOException {
        List<CSOPaymentInstructionsVisaDTO> dtoList = new LinkedList<CSOPaymentInstructionsVisaDTO>();
        CSOPaymentInstructionsVisaDTO csoPaymentInstructionsVisaDTO = null;
        String sql = "SELECT c  FROM CsoPaymentInstructionsVisa c " + buildWhereClause(obj, true);

        List<CsoPaymentInstructionsVisa> csoPaymentInstructionsVisaretrieveRelated = csoPaymentInstructionsVisaDao.executeQueryParametersDate(sql, map);

        for (CsoPaymentInstructionsVisa csoPaymentInstructionsVisa : csoPaymentInstructionsVisaretrieveRelated) {

            csoPaymentInstructionsVisaDTO = new CSOPaymentInstructionsVisaDTO();
            if (csoPaymentInstructionsVisa.getFileRefNumber() != null) {
                csoPaymentInstructionsVisaDTO.setFileRefNumber(csoPaymentInstructionsVisa.getFileRefNumber());
            }
            csoPaymentInstructionsVisaDTO.setSystemGenSeqNumber((int)csoPaymentInstructionsVisa.getCsoPaymentInstructionsVisaPK().getSystemGenSeqNumber());
            if (csoPaymentInstructionsVisa.getService() != null) {
                csoPaymentInstructionsVisaDTO.setService(csoPaymentInstructionsVisa.getService());
            }
            if (csoPaymentInstructionsVisa.getSubService() != null) {
                csoPaymentInstructionsVisaDTO.setSubService(csoPaymentInstructionsVisa.getSubService());
            }
            if (csoPaymentInstructionsVisa.getAcquirerMember() != null) {
                csoPaymentInstructionsVisaDTO.setAcquierMember(Integer.valueOf(csoPaymentInstructionsVisa.getAcquirerMember()));
            }
            if(csoPaymentInstructionsVisa.getIssuerMember() != null){
            csoPaymentInstructionsVisaDTO.setIssuerMember(Integer.valueOf(csoPaymentInstructionsVisa.getIssuerMember()));
            }
            if (csoPaymentInstructionsVisa.getAccountNumber() != null) {
                csoPaymentInstructionsVisaDTO.setAccountNumber(csoPaymentInstructionsVisa.getAccountNumber());
            }
            if (csoPaymentInstructionsVisa.getVisaAmount() != null) {
                csoPaymentInstructionsVisaDTO.setVisaAmount(csoPaymentInstructionsVisa.getVisaAmount().intValue());
            }
            if (csoPaymentInstructionsVisa.getFinancialIndicator() != null) {
                csoPaymentInstructionsVisaDTO.setFinancialIndicator(csoPaymentInstructionsVisa.getFinancialIndicator());
            }
            if (csoPaymentInstructionsVisa.getTransactionCode() != null) {
                csoPaymentInstructionsVisaDTO.setTransactionCode(csoPaymentInstructionsVisa.getTransactionCode());
            }
            if (csoPaymentInstructionsVisa.getTransactionCodeQualifier() != null) {
                csoPaymentInstructionsVisaDTO.setTransactionCodeQualifier(csoPaymentInstructionsVisa.getTransactionCodeQualifier().intValue());
            }
            if (csoPaymentInstructionsVisa.getCsoPaymentInstructionsVisaPK().getTransactionCodeNumber() != 0) {
                csoPaymentInstructionsVisaDTO.setTransactionCodeNumber(csoPaymentInstructionsVisa.getCsoPaymentInstructionsVisaPK().getTransactionCodeNumber());
            }
            if (csoPaymentInstructionsVisa.getCsoPaymentInstructionsVisaPK() != null) {
                csoPaymentInstructionsVisaDTO.setInputSeqNumber((int) csoPaymentInstructionsVisa.getInputSeqNumber());
            }
            if (csoPaymentInstructionsVisa.getCardTransaction() != null) {
                csoPaymentInstructionsVisaDTO.setCardTransaction(csoPaymentInstructionsVisa.getCardTransaction());
            }
            if (csoPaymentInstructionsVisa.getProcessStatus() != null) {
                csoPaymentInstructionsVisaDTO.setProcessStatus(csoPaymentInstructionsVisa.getProcessStatus());
            }
            if (csoPaymentInstructionsVisa.getInputFileIdentifier() != null) {
                csoPaymentInstructionsVisaDTO.setInputFileIdentifier(csoPaymentInstructionsVisa.getInputFileIdentifier());
            }
            if (csoPaymentInstructionsVisa.getSettlementDate() != null) {
                csoPaymentInstructionsVisaDTO.setSettlementDate(new Date(csoPaymentInstructionsVisa.getSettlementDate().getTime()));
            }
            if (csoPaymentInstructionsVisa.getOutputDate() != null) {
                csoPaymentInstructionsVisaDTO.setOutputDate(new Date(csoPaymentInstructionsVisa.getOutputDate().getTime()));
            }
            if (csoPaymentInstructionsVisa.getExchangeRate() != null) {
                csoPaymentInstructionsVisaDTO.setExchangeRate(csoPaymentInstructionsVisa.getExchangeRate().intValue());
            }
            if (csoPaymentInstructionsVisa.getAcquirerCountryCode() != null) {
                csoPaymentInstructionsVisaDTO.setAcquierCountryCode(csoPaymentInstructionsVisa.getAcquirerCountryCode());
            }
            if (csoPaymentInstructionsVisa.getIssuerCountryCode() != null) {
                csoPaymentInstructionsVisaDTO.setIssuerCountryCode(csoPaymentInstructionsVisa.getIssuerCountryCode());
            }
            if (csoPaymentInstructionsVisa.getXborderIssuerCountryCode() != null) {
                csoPaymentInstructionsVisaDTO.setXborderCountryCode(csoPaymentInstructionsVisa.getXborderIssuerCountryCode());
            }
            if (csoPaymentInstructionsVisa.getXborderIssuerMember() != null) {
                csoPaymentInstructionsVisaDTO.setXborderIssuerMember(csoPaymentInstructionsVisa.getXborderIssuerMember().intValue());
            }
            if (csoPaymentInstructionsVisa.getCardType() != null) {
                csoPaymentInstructionsVisaDTO.setCardType(csoPaymentInstructionsVisa.getCardType());
            }
            if (csoPaymentInstructionsVisa.getFilenameDescription() != null) {
                csoPaymentInstructionsVisaDTO.setFilenameDescription(csoPaymentInstructionsVisa.getFilenameDescription());
            }
            if (csoPaymentInstructionsVisa.getCashbackPurchase() != null) {
                csoPaymentInstructionsVisaDTO.setCashbackPurchase(csoPaymentInstructionsVisa.getCashbackPurchase());
            }
            if (csoPaymentInstructionsVisa.getCashbackPurchaseAmnt() != null) {
                csoPaymentInstructionsVisaDTO.setCashbackPurchaseAmnt(csoPaymentInstructionsVisa.getCashbackPurchaseAmnt().intValue());
            }
            
            if (csoPaymentInstructionsVisa.getChipCard() != null) {
                csoPaymentInstructionsVisaDTO.setChipCard(csoPaymentInstructionsVisa.getChipCard());
            }
            if (csoPaymentInstructionsVisa.getEcommInd() != null) {
                csoPaymentInstructionsVisaDTO.setEcommInd(csoPaymentInstructionsVisa.getEcommInd());
            }
            if (csoPaymentInstructionsVisa.getTerminalCapability() != null) {
                csoPaymentInstructionsVisaDTO.setTerminalCapability(csoPaymentInstructionsVisa.getTerminalCapability());
            }
            if (csoPaymentInstructionsVisa.getPosEntryMode() != null) {
                csoPaymentInstructionsVisaDTO.setPosEntryMode(csoPaymentInstructionsVisa.getPosEntryMode());
            }
            if (csoPaymentInstructionsVisa.getCardPresent() != null) {
                csoPaymentInstructionsVisaDTO.setCardPresent(csoPaymentInstructionsVisa.getCardPresent());
            }
            dtoList.add(csoPaymentInstructionsVisaDTO);
        }
        map.clear();
        return dtoList;
    }

    private String buildWhereClause(CSOPaymentInstructionsVisaDTO obj, boolean select) throws DAOException {

        if (obj == null) {
            return "";
        }

        StringBuilder buff = new StringBuilder();
        boolean whereClause = false;

        if (select == true) {
            if (obj.getFileRefNumber() != null) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.fileRefNumber =:fileRefNumber");
                map.put("fileRefNumber", obj.getFileRefNumber());

            }

            if (obj.getSystemGenSeqNumber() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.csoPaymentInstructionsVisaPK.systemGenSeqNumber =:systemGenSeqNumber");
                map.put("systemGenSeqNumber", Long.parseLong("" + obj.getSystemGenSeqNumber()));
            }

            if (obj.getService() != null) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.service =:service");
                map.put("service", obj.getService());
            }

            if (obj.getSubService() != null) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.subService =:subService");
                map.put("subService", obj.getSubService());
            }

            if (obj.getAcquierMember() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.acquirerMember =:acquirerMember");
                map.put("acquirerMember", String.valueOf(obj.getAcquierMember()));
            }
            if (obj.getIssuerMember() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.issuerMember =:issuerMember");
                map.put("issuerMember", String.valueOf(obj.getIssuerMember()));
            }
            if (obj.getAccountNumber() != null) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.accountNumber =:accountNumber");
                map.put("accountNumber", obj.getAccountNumber());
            }
            if (obj.getVisaAmount() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.visaAmount =:visaAmount");
                map.put("visaAmount", String.valueOf(obj.getVisaAmount()));
            }
            if (obj.getFinancialIndicator() != null) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.financialIndicator =:financialIndicator");
                map.put("financialIndicator", obj.getFinancialIndicator());
            }
            if (obj.getTransactionCode() != null) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.transactionCode =:transactionCode");
                map.put("transactionCode", obj.getTransactionCode());
            }
            if (obj.getTransactionCodeQualifier() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.transactionCodeQualifier =:transactionCodeQualifier");
                map.put("transactionCodeQualifier", String.valueOf(obj.getTransactionCodeQualifier()));
            }
            if (obj.getTransactionCodeNumber() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.transactionCodeNumber =:transactionCodeNumber");
                map.put("transactionCodeNumber", String.valueOf(obj.getTransactionCodeNumber()));
            }
            if (obj.getInputSeqNumber() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.inputSeqNumber =:inputSeqNumber");
                map.put("inputSeqNumber", String.valueOf(obj.getInputSeqNumber()));
            }
            if (obj.getCardTransaction() != null) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.cardTransaction =:cardTransaction");
                map.put("cardTransaction", obj.getCardTransaction());
            }
            if (obj.getProcessStatus() != null) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.processStatus =:processStatus");
                map.put("processStatus", obj.getProcessStatus());
            }
            if (obj.getInputSeqNumber() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.inputFileIdentifier =:inputFileIdentifier");
                map.put("inputFileIdentifier", obj.getInputFileIdentifier());
            }
            if (obj.getSettlementDate() != null) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.settlementDate =:settlementDate");
                map.put("settlementDate", String.valueOf(obj.getSettlementDate()));
            }
            if (obj.getOutputDate() != null) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.outputDate =:outputDate");
                map.put("outputDate", String.valueOf(obj.getOutputDate()));
            }
            if (obj.getExchangeRate() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.exchangeRate =:exchangeRate");
                map.put("exchangeRate", String.valueOf(obj.getExchangeRate()));
            }
            if (obj.getAcquierCountryCode() != null) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.acquirerCountryCode =:acquirerCountryCode");
                map.put("acquirerCountryCode", obj.getAcquierCountryCode());
            }
            if (obj.getIssuerCountryCode() != null) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.issuerCountryCode =:issuerCountryCode");
                map.put("issuerCountryCode", obj.getIssuerCountryCode());
            }
            if (obj.getXborderCountryCode() != null) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.xborderIssuerCountryCode =:xborderIssuerCountryCode");
                map.put("xborderIssuerCountryCode", obj.getXborderCountryCode());
            }
            if (obj.getXborderIssuerMember() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.xborderIssuerMember =:xborderIssuerMember");
                map.put("xborderIssuerMember", String.valueOf(obj.getXborderIssuerMember()));
            }
            if (obj.getCardType() != null) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.cardType =:cardType");
                map.put("cardType", obj.getCardType());
            }
            if (obj.getFilenameDescription() != null) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.filenameDescription =:filenameDescription");
                map.put("filenameDescription", obj.getFilenameDescription());
            }
            if (obj.getCashbackPurchase() != null) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.cashbackPurchase =:cashbackPurchase");
                map.put("cashbackPurchase", obj.getCashbackPurchase());
            }
            if (obj.getCashbackPurchaseAmnt() > 0) {
                if (!whereClause) {
                    whereClause = true;
                    buff.append(" WHERE ");
                } else {
                    buff.append(" AND ");
                }

                buff.append("c.cashbackPurchaseAmnt =:cashbackPurchaseAmnt");
                map.put("cashbackPurchaseAmnt", String.valueOf(obj.getCashbackPurchaseAmnt()));
            }
        }
        if (!whereClause && select == false) {
            throw new DAOException("Cannot Build where clause in CsoPaymentInstructionsVisa");
        }

        return buff.toString();
    }

    public void update(CSOPaymentInstructionsVisaDTO csoPaymentInstructionsVisaDTO) throws DAOException {
        try {

            CsoPaymentInstructionsVisa csoPaymentInstructionsVisa = new CsoPaymentInstructionsVisa();

            csoPaymentInstructionsVisa.setFileRefNumber(csoPaymentInstructionsVisaDTO.getFileRefNumber());
            csoPaymentInstructionsVisa.setService(csoPaymentInstructionsVisaDTO.getService());
            csoPaymentInstructionsVisa.setSubService(csoPaymentInstructionsVisaDTO.getSubService());
            csoPaymentInstructionsVisa.setAcquirerMember(String.valueOf(csoPaymentInstructionsVisaDTO.getAcquierMember()));
            csoPaymentInstructionsVisa.setIssuerMember(String.valueOf(csoPaymentInstructionsVisaDTO.getIssuerMember()));
            csoPaymentInstructionsVisa.setAccountNumber(csoPaymentInstructionsVisaDTO.getAccountNumber());
            csoPaymentInstructionsVisa.setVisaAmount(BigDecimal.valueOf(csoPaymentInstructionsVisaDTO.getVisaAmount()));
            csoPaymentInstructionsVisa.setFinancialIndicator(csoPaymentInstructionsVisaDTO.getFinancialIndicator());
            csoPaymentInstructionsVisa.setTransactionCode(csoPaymentInstructionsVisaDTO.getTransactionCode());
            csoPaymentInstructionsVisa.setTransactionCodeQualifier((short) csoPaymentInstructionsVisaDTO.getTransactionCodeQualifier());
            
            csoPaymentInstructionsVisa.setInputFileIdentifier(csoPaymentInstructionsVisaDTO.getInputFileIdentifier());
            csoPaymentInstructionsVisa.setInputSeqNumber(csoPaymentInstructionsVisaDTO.getInputSeqNumber());

            CsoPaymentInstructionsVisaPK csoPaymentInstructionsVisaPK = new CsoPaymentInstructionsVisaPK();
            csoPaymentInstructionsVisaPK.setSystemGenSeqNumber(csoPaymentInstructionsVisaDTO.getSystemGenSeqNumber());
            csoPaymentInstructionsVisaPK.setTransactionCodeNumber((short) csoPaymentInstructionsVisaDTO.getTransactionCodeNumber());
            csoPaymentInstructionsVisa.setCsoPaymentInstructionsVisaPK(csoPaymentInstructionsVisaPK);
            
            
            csoPaymentInstructionsVisa.setCardTransaction(csoPaymentInstructionsVisaDTO.getCardTransaction());
            csoPaymentInstructionsVisa.setProcessStatus(csoPaymentInstructionsVisaDTO.getProcessStatus());
            csoPaymentInstructionsVisa.setSettlementDate(new Date(csoPaymentInstructionsVisaDTO.getSettlementDate().getTime()));
            csoPaymentInstructionsVisa.setOutputDate(new Date(csoPaymentInstructionsVisaDTO.getOutputDate().getTime()));
            csoPaymentInstructionsVisa.setExchangeRate((long) csoPaymentInstructionsVisaDTO.getExchangeRate());
            csoPaymentInstructionsVisa.setAcquirerCountryCode(csoPaymentInstructionsVisaDTO.getAcquierCountryCode());
            csoPaymentInstructionsVisa.setIssuerCountryCode(csoPaymentInstructionsVisaDTO.getIssuerCountryCode());
            csoPaymentInstructionsVisa.setXborderIssuerCountryCode(csoPaymentInstructionsVisaDTO.getXborderCountryCode());
            csoPaymentInstructionsVisa.setXborderIssuerMember((short) csoPaymentInstructionsVisaDTO.getXborderIssuerMember());
            csoPaymentInstructionsVisa.setCardType(csoPaymentInstructionsVisaDTO.getCardType());
            csoPaymentInstructionsVisa.setFilenameDescription(csoPaymentInstructionsVisaDTO.getFilenameDescription());
            csoPaymentInstructionsVisa.setCashbackPurchase(csoPaymentInstructionsVisaDTO.getCashbackPurchase());
            csoPaymentInstructionsVisa.setCashbackPurchaseAmnt(BigDecimal.valueOf(csoPaymentInstructionsVisaDTO.getCashbackPurchaseAmnt()));
            // SARB Billing values
            //csoPaymentInstructionsVisa.setPosEntryModeIn(csoPaymentInstructionsVisaDTO.getPosEntryMode());
            csoPaymentInstructionsVisa.setTerminalCapability(csoPaymentInstructionsVisaDTO.getTerminalCapabilityIn());
            csoPaymentInstructionsVisa.setCardPresent(csoPaymentInstructionsVisaDTO.getCardholderIndIn());
            csoPaymentInstructionsVisa.setChipCard(csoPaymentInstructionsVisaDTO.getChipCard());
            csoPaymentInstructionsVisa.setEcommInd(csoPaymentInstructionsVisaDTO.getEcommInd());
            csoPaymentInstructionsVisa.setRateDesc(csoPaymentInstructionsVisaDTO.getRateDesc());
            csoPaymentInstructionsVisa.setInterchangeFee(csoPaymentInstructionsVisaDTO.getInterchangeFee());
            csoPaymentInstructionsVisa.setInterchangePerc(csoPaymentInstructionsVisaDTO.getCashbackIcPerc());
            csoPaymentInstructionsVisa.setInterchangeVat(csoPaymentInstructionsVisaDTO.getInterchasngeVat());

            csoPaymentInstructionsVisaDao.update(csoPaymentInstructionsVisa);

        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    public void delete() throws DAOException {
        //csoPaymentInstructionsVisaDao.deleteBulk("Delete from CsoPaymentInstructionsVisa");
        csoPaymentInstructionsVisaDao.deleteTruncate("TRUNCATE TABLE CSO_PAYMENT_INSTRUCTIONS_VISA");
        csoPaymentInstructionsVisaDao.deleteTruncate("TRUNCATE TABLE CSO_CCR030_VISA");
    }

}
