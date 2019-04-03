package com.bsva.dao;

import java.util.List;
import java.util.Map;

import com.bsva.entities.CsfCardFeeBilateral;
import com.bsva.entities.CsfCardFeeBilateralPK;
import com.bsva.entities.CsvCcr00xDataView;
import com.bsva.entities.CsvCcr00xDataViewPK;
import com.bsva.utils.DataAccessLayerException;

public class CsvCcr00xDataViewDao extends AbstractDao<CsvCcr00xDataView,CsvCcr00xDataViewPK>{
	
	
	/**
	 * @author AugustineA
	 *
	 */
		public CsvCcr00xDataViewDao() {
	        super();
	    }

	    /**
	     * Insert a new Event into the database.
	     * @param event
	     */
	    public void create(CsvCcr00xDataView obj) throws DataAccessLayerException {
	        super.saveOrUpdate(obj);
	    }


	    /**
	     * Delete a detached Event from the database.
	     * @param event
	     */
	    public void delete(CsvCcr00xDataView obj) throws DataAccessLayerException {
	        super.delete(obj);
	    }

	    /**
	     * Find an Event by its primary key.
	     * @param id
	     * @return
	     */
	    public CsvCcr00xDataView find(CsvCcr00xDataViewPK csvCcr00xDataViewPK) throws DataAccessLayerException {
	        return (CsvCcr00xDataView) super.find(CsvCcr00xDataView.class, csvCcr00xDataViewPK);
	    }

	    /**
	     * Updates the state of a detached Event.
	     *
	     * @param event
	     */
	    public void update(CsvCcr00xDataView obj) throws DataAccessLayerException {
	        super.saveOrUpdate(obj);
	    }

	    /**
	     * Finds all Events in the database.
	     * @return
	     */
	    public List findAll() throws DataAccessLayerException{
	        return super.findAll(CsvCcr00xDataView.class);
	    }
	    public Object executeQuery(String query, Object... params) {
	    	return super.executeQuery(query, params);
	    }
	    
	    public Object executeCountQuery(String string){	
	    	return super.executeCountQuery(string);
	    }
	    
	    public Object executeMaxQuary(String string){	
	    	return super.executeMaxQuary(string);
	    }
	    
	    public List<Object[]> executeNamedQueryList(String query,Class class1){
	    	
	    	return super.executeNamedQueryList(query, class1);
	    }
	    
	    public List<Object[]> executeNamedQueryObject(String query){
	    	
	    	return super.executeNamedQueryObject(query);
	    }
	    public List executeTypeQuery(String string) { 
	    	
	    	return super.executeTypeQuery(string);
	    }
	    
	    public List executeTypeQueryViews(String string) { 
	    	
	    	return super.executeQueryParametersNative(string);
	    }
	    
	    public Object executeNativeQuery(String query, Object... params) {
	    	return super.executeNativeQuery(query, params);
	    }
	    
	    public void  deleteBulk(String deletequery) {
	    	super.deleteBulk(deletequery);
	    }
	    
	    public List executeQueryParameters(String query, Map<String,Object> parameters) {
	    	return super.executeQueryParameters(query, parameters);
	    }
	    public CsvCcr00xDataView executeQueryParametersSingle(String query, Map<String,Object> parameters) {
	    	return super.executeQueryParametersSingle(query, parameters);
	    }
	

}
