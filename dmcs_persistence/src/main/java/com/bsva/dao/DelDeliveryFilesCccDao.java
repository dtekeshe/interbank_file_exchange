package com.bsva.dao;

import java.util.List;
import java.util.Map;
import com.bsva.entities.DelDeliveryFilesCcc;
import com.bsva.entities.DelDeliveryFilesCccPK;

/**
 * @author AugustineA
 *
 */
public class DelDeliveryFilesCccDao extends AbstractDao<DelDeliveryFilesCcc,DelDeliveryFilesCccPK> {
    public DelDeliveryFilesCccDao() {
        super();
    }

    /**
     * Insert a new Event into the database.
     * @param delDeliveryFilesCcc
     */
    public void create(DelDeliveryFilesCcc delDeliveryFilesCcc) {
        super.saveOrUpdate(delDeliveryFilesCcc);
    }


    /**
     * Delete a detached Event from the database.
     * @param delDeliveryFilesCcc
     */
    public void delete(DelDeliveryFilesCcc delDeliveryFilesCcc) {
        super.delete(delDeliveryFilesCcc);
    }

    /**
     * Find an Event by its primary key.
     * @param delDeliveryFilesCccPK
     * @return
     */
    public DelDeliveryFilesCcc find(DelDeliveryFilesCccPK delDeliveryFilesCccPK) {
        return (DelDeliveryFilesCcc) super.find(DelDeliveryFilesCcc.class, delDeliveryFilesCccPK);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param delDeliveryFilesCcc
     */
    public void update(DelDeliveryFilesCcc delDeliveryFilesCcc) {
        super.saveOrUpdate(delDeliveryFilesCcc);
    }
    

    /**
     * Finds all Events in the database.
     * @return
     */
    public List findAll() {
        return super.findAll(DelDeliveryFilesCcc.class);
    }
    
    
    @Override
    public DelDeliveryFilesCcc executeQueryParametersSingle(String query, Map<String,Object> parameters) {
    	return super.executeQueryParametersSingle(query, parameters);
    }

}

