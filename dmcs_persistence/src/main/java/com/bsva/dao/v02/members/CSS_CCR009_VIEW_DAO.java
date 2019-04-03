package com.bsva.dao.v02.members;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.CssCcr009View;

public class CSS_CCR009_VIEW_DAO extends AbstractDao<CssCcr009View,Void>{

	private static final String CSS_CCR009_VIEW_SQL = 	
	 " SELECT ACQUIRER ,ISSUER ,VOLUME , VALUE * 100 AS VALUE  ,TX_DESC ,PRODUCT_DESC  ,TRANSACTION_CODE ,PRODUCT_CODE ,SUB_PRODUCT  "+
	 " FROM CSS_CCR009_VIEW  ORDER BY ACQUIRER ,ISSUER ,TX_DESC ,PRODUCT_DESC ,TRANSACTION_CODE ,PRODUCT_CODE ,SUB_PRODUCT";

	private static final String CSS_CCR009_VIEW_PARAMS_SQL = 
			 " SELECT ACQUIRER ,ISSUER ,VOLUME , VALUE * 100 AS VALUE  ,TX_DESC ,PRODUCT_DESC  ,TRANSACTION_CODE ,PRODUCT_CODE ,SUB_PRODUCT  "+
					 " FROM CSS_CCR009_VIEW WHERE ISSUER =:issuer AND ACQUIRER = :acquirer  ORDER BY ACQUIRER ,ISSUER ,TX_DESC ,PRODUCT_DESC ,TRANSACTION_CODE ,PRODUCT_CODE ,SUB_PRODUCT";


    
    public List<CssCcr009View> getCSS009Reports() {

    	
        // execute
        List<CssCcr009View> entities
                = list(CSS_CCR009_VIEW_SQL, CssCcr009View.class);

        // prepare result
        List<CssCcr009View> addresses = new ArrayList<CssCcr009View>();

        for ( CssCcr009View entity : entities ) {
            addresses.add(entity);
        }

        return addresses;
    }
    
    public List<CssCcr009View> getCSS009Reports(Integer issuer, Integer acquirer) {

    	Map<String,Object> params = new HashMap<String, Object>();
    	params.put("issuer", issuer);
    	params.put("acquirer", acquirer);
        // execute
        List<CssCcr009View> entities
                = list(CSS_CCR009_VIEW_PARAMS_SQL,params ,CssCcr009View.class);

        // prepare result
        List<CssCcr009View> addresses = new ArrayList<CssCcr009View>();

        for ( CssCcr009View entity : entities ) {
            addresses.add(entity);
        }

        return addresses;
    }
}
