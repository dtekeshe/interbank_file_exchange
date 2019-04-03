package com.bsva.dao;

import java.util.List;
import java.util.Map;

import com.bsva.entities.CsvDefaultFilesView;
import com.bsva.entities.CsvDefaultFilesViewPK;
import com.bsva.utils.DataAccessLayerException;

public class CsvDefaultFilesViewDao extends AbstractDao<CsvDefaultFilesView,CsvDefaultFilesViewPK>{

	/**
	 * @author AugustineA
	 *
	 */
		public CsvDefaultFilesViewDao() {
	        super();
	    }

	    /**
	     * Insert a new Event into the database.
	     * @param event
	     */
	    public void create(CsvDefaultFilesView obj) throws DataAccessLayerException {
	        super.saveOrUpdate(obj);
	    }


	    /**
	     * Delete a detached Event from the database.
	     * @param event
	     */
	    public void delete(CsvDefaultFilesView obj) throws DataAccessLayerException {
	        super.delete(obj);
	    }

	    /**
	     * Find an Event by its primary key.
	     * @param id
	     * @return
	     */
	    public CsvDefaultFilesView find(CsvDefaultFilesViewPK csvDefaultFilesViewPK) throws DataAccessLayerException {
	        return (CsvDefaultFilesView) super.find(CsvDefaultFilesView.class, csvDefaultFilesViewPK);
	    }

	    /**
	     * Updates the state of a detached Event.
	     *
	     * @param event
	     */
	    public void update(CsvDefaultFilesView obj) throws DataAccessLayerException {
	        super.saveOrUpdate(obj);
	    }

	    /**
	     * Finds all Events in the database.
	     * @return
	     */
	    public List findAll() throws DataAccessLayerException{
	        return super.findAll(CsvDefaultFilesView.class);
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
	    public CsvDefaultFilesView executeQueryParametersSingle(String query, Map<String,Object> parameters) {
	    	return super.executeQueryParametersSingle(query, parameters);
			
			
	    }
}
