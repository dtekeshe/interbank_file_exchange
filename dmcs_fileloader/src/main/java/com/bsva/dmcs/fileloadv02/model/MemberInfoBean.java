package com.bsva.dmcs.fileloadv02.model;

import com.bsva.dao.v02.members.MemberBinInfoDAO;
import com.bsva.dcms.commons.dto.CSFBinsDTO;
import com.bsva.dcms.commons.util.BsvTableLookup;
import com.bsva.dmcs.fileloadv02.dto.MemberInfoDTO;
import com.bsva.entities.v02.members.MemberBinInfo;

import java.util.Map;

/**
 * TODO Document
 */
public class MemberInfoBean {

    private final Map<Integer, MemberBinInfo> members;

    public MemberInfoBean() {

        members = new MemberBinInfoDAO().membersBinInfo();
    }

   // public MemberInfoDTO getMemberByBin(Integer bin) {

    public MemberInfoDTO getMemberByBin(Integer bin) {

        MemberBinInfo memberBinInfo = members.get( bin );

        if (memberBinInfo != null) {
            return MemberInfoDTO.instance(memberBinInfo);
        }

        // consider partial bins
        String b = "" + bin;
        int len = b.length() - 1;
        for (int idx = len; idx > 0; --idx) {
       	 String lookupBin = b.substring(0, idx);
       	 memberBinInfo = members.get(Integer.valueOf(lookupBin));
       	 if (memberBinInfo != null) {
       		return MemberInfoDTO.instance(memberBinInfo);
       	 }
        }

        // not found
        return null;
    }
}
