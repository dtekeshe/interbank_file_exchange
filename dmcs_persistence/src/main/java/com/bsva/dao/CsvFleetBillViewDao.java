package com.bsva.dao;

import java.util.List;
import java.util.Map;
import com.bsva.entities.CsvFleetBillView;
import com.bsva.entities.CsvFleetBillViewPK;
import com.bsva.utils.DataAccessLayerException;

public class CsvFleetBillViewDao extends AbstractDao<CsvFleetBillView,CsvFleetBillViewPK>{
	
	
	/**
	 * @author AugustineA
	 *
	 */
		public CsvFleetBillViewDao() {
	        super();
	    }

	    /**
	     * Insert a new Event into the database.
	     * @param event
	     */
	    public void create(CsvFleetBillView obj) throws DataAccessLayerException {
	        super.saveOrUpdate(obj);
	    }


	    /**
	     * Delete a detached Event from the database.
	     * @param event
	     */
	    public void delete(CsvFleetBillView obj) throws DataAccessLayerException {
	        super.delete(obj);
	    }

	    /**
	     * Find an Event by its primary key.
	     * @param id
	     * @return
	     */
	    public CsvFleetBillView find(CsvFleetBillViewPK csvFleetBillViewPK) throws DataAccessLayerException {
	        return (CsvFleetBillView) super.find(CsvFleetBillView.class, csvFleetBillViewPK);
	    }

	    /**
	     * Updates the state of a detached Event.
	     *
	     * @param event
	     */
	    public void update(CsvFleetBillView obj) throws DataAccessLayerException {
	        super.saveOrUpdate(obj);
	    }

	    /**
	     * Finds all Events in the database.
	     * @return
	     */
	    public List findAll() throws DataAccessLayerException{
	        return super.findAll(CsvFleetBillView.class);
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
	    public CsvFleetBillView executeQueryParametersSingle(String query, Map<String,Object> parameters) {
	    	return super.executeQueryParametersSingle(query, parameters);
	    }
	


}
