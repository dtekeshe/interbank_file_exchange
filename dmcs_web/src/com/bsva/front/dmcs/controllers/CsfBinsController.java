package com.bsva.front.dmcs.controllers;

import com.bsva.dcms.commons.dao.CSFBinDAO;
import com.bsva.dcms.commons.dao.CSFCardTypesDAO;
import com.bsva.dcms.commons.dao.CSFMembersDAO;
import com.bsva.dcms.commons.dto.CSFBinsDTO;
import com.bsva.dcms.commons.dto.CSFCardTypesDTO;
import com.bsva.dcms.commons.dto.CSFMembersDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.dcms.commons.util.BsvTableLookup;
import com.bsva.front.dmcs.dto.CsfBinsDTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ViewScoped;

import javax.faces.event.ValueChangeEvent;


/**
 * @author AugustineA
 *
 */
@ViewScoped
public class CsfBinsController extends CSFBinDAO implements Serializable {

    private CSFBinsDTO csfBinsDTO = new CsfBinsDTO();
    private CSFMembersDAO csfMembersDAO = new CSFMembersDAO();
    private CSFCardTypesDAO csfCardTypesDAO = new CSFCardTypesDAO();
    
    private List<CSFMembersDTO> csfMembersRetrievedList = new ArrayList<CSFMembersDTO>();    
    private List<CSFBinsDTO> csfBinsRetrievedList = new ArrayList<CSFBinsDTO>();
    private List<CSFCardTypesDTO> csfRetrievedCardTypesList = new ArrayList<CSFCardTypesDTO>();

    private Map<String, String> memberSelectItems;
    private Map<String, String> binSelectItems;
    private Map<Integer, String> cardTypesSelectItems;
    private String selectedItem;
    
    private CSFBinsDTO csfBinsDTOResult;

    public CsfBinsController() throws DAOException {

        csfMembersRetrievedList = getMembersList();
        csfBinsRetrievedList = getBinsList();        
        csfRetrievedCardTypesList = getCardTypesList();

        binSelectItems = new LinkedHashMap<String, String>();
        memberSelectItems = new LinkedHashMap<String, String>();
        cardTypesSelectItems = new LinkedHashMap<Integer, String>();

        for (Object member : getCsfMembersRetrievedList()) {
            CSFMembersDTO cSFMembersDTO = (CSFMembersDTO) member;
            memberSelectItems.put(String.valueOf(cSFMembersDTO.getBankCode()), cSFMembersDTO.getMemberName());
        }

        for (Object cardType : getCsfRetrievedCardTypes()) {
            CSFCardTypesDTO cardTypesDTO = (CSFCardTypesDTO) cardType;
            cardTypesSelectItems.put(cardTypesDTO.getCardType(), cardTypesDTO.getCardDescription());
        }

        for (CSFBinsDTO binsDTO : getCsfBinsRetrievedList()) {
            binSelectItems.put(binsDTO.getBinNo(), binsDTO.getBinDescription());
        }
    }

    public CsfBinsController(CsfBinsDTO csfBinsDTO) {
        this.csfBinsDTO = csfBinsDTO;
    }

    public void update() throws DAOException {
        
        csfBinsDTO.setBinNo(this.getCsfBinsDTO().getBinNo());
        csfBinsDTO.setBankCode(this.getCsfBinsDTO().getBankCode());
        csfBinsDTO.setBinDescription(this.getCsfBinsDTO().getBinDescription());
        csfBinsDTO.setCardType(this.getCsfBinsDTO().getCardType());
        csfBinsDTO.setLimit1(this.getCsfBinsDTO().getLimit1());
        csfBinsDTO.setLimit2(this.getCsfBinsDTO().getLimit2());
        csfBinsDTO.setFloorLimit(this.getCsfBinsDTO().getFloorLimit());
        csfBinsDTO.setRouting(this.getCsfBinsDTO().getRouting());
        csfBinsDTO.setFirstDeletionDate(this.getCsfBinsDTO().getFirstDeletionDate());
        csfBinsDTO.setDaysBeforeFirstDeletionDate(this.getCsfBinsDTO().getDaysBeforeFirstDeletionDate());
        csfBinsDTO.setFinalDeletionDate(this.getCsfBinsDTO().getFinalDeletionDate());
        csfBinsDTO.setDaysBeforeFinalDeletionDate(this.getCsfBinsDTO().getDaysBeforeFinalDeletionDate());
        csfBinsDTO.setActiveInd(this.getCsfBinsDTO().getActiveInd());
        csfBinsDTO.setAcqIssBoth(this.getCsfBinsDTO().getAcqIssBoth());      
        
        super.create(csfBinsDTO);
    }

    public void create() throws DAOException {

        CSFBinsDTO csfBins = new CsfBinsDTO();
        csfBins = csfBinsDTO;

        CSFMembersDTO cSFMembersDTO = new CSFMembersDTO();
        cSFMembersDTO.setBankCode(csfBins.getBankCode());
        CSFMembersDTO cSFMembersResult = csfMembersDAO.retrieve(cSFMembersDTO);
        csfBins.setCsfMembersDTO(cSFMembersResult);

        super.create(csfBins);
    }

    public List<CSFMembersDTO> getMembersList() throws DAOException {

        CSFMembersDTO member = new CSFMembersDTO();
        member.setIncfOutputRequired("Y");

        List<CSFMembersDTO> membersList = csfMembersDAO.retrieveRelated(member);
        
        return membersList;
    }
    
    public List<CSFCardTypesDTO> getCardTypesList() throws DAOException {                
        
        List<CSFCardTypesDTO> cardTypesDTOList = csfCardTypesDAO.retrieveRelated(null);   
        
        return cardTypesDTOList;
    }

    public List<CSFBinsDTO> getBinsList() {

        List<CSFBinsDTO> binList = new ArrayList<CSFBinsDTO>();
        HashMap<String, CSFBinsDTO> binMap = BsvTableLookup.getInstance().getCsfBins();

        for (Map.Entry binEntry : binMap.entrySet()) {
            CSFBinsDTO binDTO = new CSFBinsDTO();
            binDTO = (CSFBinsDTO) binEntry.getValue();
            binList.add(binDTO);
        }
        return binList;
    }

    public void binChanged(ValueChangeEvent e) throws DAOException {
        
        selectedItem = e.getNewValue().toString();
        CsfBinsDTO csfBins = new CsfBinsDTO();
        csfBins.setBinNo(selectedItem);
        
        csfBinsDTOResult = super.retrieve(csfBins);            
        this.getCsfBinsDTO().setBinNo(csfBinsDTOResult.getBinNo());
        this.getCsfBinsDTO().setBankCode(csfBinsDTOResult.getBankCode());
        this.getCsfBinsDTO().setBinDescription(csfBinsDTOResult.getBinDescription());
        this.getCsfBinsDTO().setCardType(csfBinsDTOResult.getCardType());
        this.getCsfBinsDTO().setLimit1(csfBinsDTOResult.getLimit1());
        this.getCsfBinsDTO().setLimit2(csfBinsDTOResult.getLimit2());
        this.getCsfBinsDTO().setFloorLimit(csfBinsDTOResult.getFloorLimit());
        this.getCsfBinsDTO().setRouting(csfBinsDTOResult.getRouting());
        this.getCsfBinsDTO().setFirstDeletionDate(csfBinsDTOResult.getFirstDeletionDate());
        this.getCsfBinsDTO().setDaysBeforeFirstDeletionDate(csfBinsDTOResult.getDaysBeforeFirstDeletionDate());
        this.getCsfBinsDTO().setFinalDeletionDate(csfBinsDTOResult.getFinalDeletionDate());
        this.getCsfBinsDTO().setDaysBeforeFinalDeletionDate(csfBinsDTOResult.getDaysBeforeFinalDeletionDate());
        this.getCsfBinsDTO().setActiveInd(csfBinsDTOResult.getActiveInd());
        this.getCsfBinsDTO().setAcqIssBoth(csfBinsDTOResult.getAcqIssBoth());                                
                
        csfBins.setBankCode(csfBinsDTOResult.getBankCode());
    }

    public Map<String, String> getMemberSelectItems() {
        return memberSelectItems;
    }

    public void setMemberSelectItems(Map<String, String> memberSelectItems) {
        this.memberSelectItems = memberSelectItems;
    }

    public String getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(String selectedItem) {
        this.selectedItem = selectedItem;
    }

    public List<CSFMembersDTO> getCsfMembersRetrievedList() {
        return csfMembersRetrievedList;
    }

    public void setCsfMembersRetrievedList(List<CSFMembersDTO> csfMembersRetrievedList) {
        this.csfMembersRetrievedList = csfMembersRetrievedList;
    }

    public CSFBinsDTO getCsfBinsDTO() {
        return csfBinsDTO;
    }

    public void setCsfBinsDTO(CsfBinsDTO csfBinsDTO) {
        this.csfBinsDTO = csfBinsDTO;
    }

    public Map<String, String> getBinSelectItems() {
        return binSelectItems;
    }

    public void setBinSelectItems(Map<String, String> binSelectItems) {
        this.binSelectItems = binSelectItems;
    }

    public List<CSFBinsDTO> getCsfBinsRetrievedList() {
        return csfBinsRetrievedList;
    }

    public void setCsfBinsRetrievedList(List<CSFBinsDTO> csfBinsRetrievedList) {
        this.csfBinsRetrievedList = csfBinsRetrievedList;
    }

    public List<CSFCardTypesDTO> getCsfRetrievedCardTypes() {
        return csfRetrievedCardTypesList;
    }

    public void setCsfRetrievedCardTypes(List<CSFCardTypesDTO> csfRetrievedCardTypes) {
        this.csfRetrievedCardTypesList = csfRetrievedCardTypes;
    }

    public Map<Integer, String> getCardTypesSelectItems() {
        return cardTypesSelectItems;
    }

    public void setCardTypesSelectItems(Map<Integer, String> cardTypesSelectItems) {
        this.cardTypesSelectItems = cardTypesSelectItems;
    }

    public CSFBinsDTO getCsfBinsDTOResult() {
        return csfBinsDTOResult;
    }

    public void setCsfBinsDTOResult(CSFBinsDTO csfBinsDTOResult) {
        this.csfBinsDTOResult = csfBinsDTOResult;
    }   
}
