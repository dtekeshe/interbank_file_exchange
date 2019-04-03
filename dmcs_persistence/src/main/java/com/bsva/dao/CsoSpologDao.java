package com.bsva.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;
import com.bsva.entities.CsoSpolog;



public class CsoSpologDao extends AbstractDao<CsoSpolog,Date> {

	public CsoSpologDao() {
		super();
	}
	
	 /**
     * Insert a new Event into the database.
     *
     * @param csfServices
     */
    public void create(CsoSpolog csoSpolog) {
        super.saveOrUpdate(csoSpolog);
    }

    /**
     * Delete a detached Event from the database.
     *
     * @param csfServices
     */
    public void delete(CsoSpolog csoSpolog) {
        super.delete(csoSpolog);
    }

    /**
     * Find an Event by its primary key.
     *
     * @param csfServicespk
     * @return
     */
    public CsoSpolog find(Date processNameSeq) {
        return (CsoSpolog) super.find(CsoSpolog.class, processNameSeq);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param csfServices
     */
    public void update(CsoSpolog csoSpolog) {
        super.saveOrUpdate(csoSpolog);
    }

    /**
     * Finds all Events in the database.
     *
     * @return
     */
    public List findAll() {
        return super.findAll(CsoSpolog.class);
    }

    @Override
    public CsoSpolog executeQueryParametersSingle(String query, Map<String, Object> parameters) {
        return super.executeQueryParametersSingle(query, parameters);
    }

}
