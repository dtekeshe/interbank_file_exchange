package com.bsva.dao;

import com.bsva.utils.DataAccessLayerException;

import org.hibernate.*;

import com.bsva.utils.HibernateFactory;

import org.hibernate.dialect.Dialect;
import org.hibernate.engine.spi.SessionFactoryImplementor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author AugustineA
 * @param <T>Object Type
 * @param <PK>primary Key
 *
 */
public abstract class AbstractDao<T, PK> {


    public AbstractDao() {
        // HibernateFactory.buildIfNeeded();
    }

    protected void saveOrUpdate(Object obj) {

        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateFactory.openSession();
            tx = session.beginTransaction();
            session.saveOrUpdate(obj);
            tx.commit();
        } catch (Exception e1) {
            try {tx.rollback();}catch (Exception e){}
            throw new DataAccessLayerException(e1);
        } finally {
            try { session.close(); } catch ( Exception e ){}
        }
    }

    protected void save(Object obj) {

        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateFactory.openSession();
            tx = session.beginTransaction();
            session.save(obj);
            tx.commit();
        } catch (Exception e1) {
            try {tx.rollback();}catch (Exception e){}
            throw new DataAccessLayerException(e1);
        } finally {
            try { session.close(); } catch ( Exception e ){}
        }
    }

    protected void delete(Object obj) {

        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateFactory.openSession();
            tx = session.beginTransaction();
            session.delete(obj);
            tx.commit();
        } catch (Exception e1) {
            try {tx.rollback();}catch (Exception e){}
            throw new DataAccessLayerException(e1);
        } finally {
            try { session.close(); } catch ( Exception e ){}
        }
    }

    protected Object find(Class clazz, Object id) {

        Session session = null;
        Transaction tx = null;
        Object obj = null;
        try {
            session = HibernateFactory.openSession();
            tx = session.beginTransaction();
            obj = session.load(clazz, (Serializable) id);
            tx.commit();
        } catch (Exception e1) {
            try {tx.rollback();}catch (Exception e){}
            throw new DataAccessLayerException(e1);
        } finally {
            try { session.close(); } catch ( Exception e ){}
        }
        return obj;
    }

    protected List<T> findAll(Class clazz) {
        Session session = null;
        Transaction tx = null;
        List objects = null;
        try {
            session = HibernateFactory.openSession();
            tx = session.beginTransaction();
            Query query = session.createQuery("from " + clazz.getName());
            objects = query.list();
            tx.commit();
        } catch (Exception e1) {
            try {tx.rollback();}catch (Exception e){}
            throw new DataAccessLayerException(e1);
        } finally {
            try { session.close(); } catch ( Exception e ){}
        }
        return objects;
    }

    public Object executeQuery(String query, Object... params) {
        Session session = null;
        Transaction tx = null;
        List objects = null;
        try {
            session = HibernateFactory.openSession();
            tx = session.beginTransaction();
            Query createdQuery = session.createQuery(query);           
                for (int i = 0; i < params.length; i++) {
                    createdQuery.setParameter(i, params[i]);
                }
            objects = createdQuery.list();
            tx.commit();
        } catch (Exception e1) {
            try {tx.rollback();}catch (Exception e){}
            throw new DataAccessLayerException(e1);
        } finally {
            try { session.close(); } catch ( Exception e ){}
        }
        return objects;
    }
    
    public List<Object> executeQueryList(String query, Object... params) {
        Session session = null;
        Transaction tx = null;
        List objects = null;
        try {
            session = HibernateFactory.openSession();
            tx = session.beginTransaction();
            Query createdQuery = session.createQuery(query);           
                for (int i = 0; i < params.length; i++) {
                    createdQuery.setParameter(i, params[i]);
                }
            objects = createdQuery.list();
            tx.commit();
        } catch (Exception e1) {
            try {tx.rollback();}catch (Exception e){}
            throw new DataAccessLayerException(e1);
        } finally {
            try { session.close(); } catch ( Exception e ){}
        }
        return objects;
    }

    public Object executeCountQuery(String string) {
        Session session = null;
        Transaction tx = null;
        Object obj = null;
        try {
            session = HibernateFactory.openSession();
            tx = session.beginTransaction();
            Query query = session.createQuery(string);
            obj = query.uniqueResult();
            tx.commit();
        } catch (Exception e1) {
            try {tx.rollback();}catch (Exception e){}
            throw new DataAccessLayerException(e1);
        } finally {
            try { session.close(); } catch ( Exception e ){}
        }
        return obj;
    }

    public Object executeMaxQuary(String string) {
        Session session = null;
        Transaction tx = null;
        Object obj = null;
        try {
            session = HibernateFactory.openSession();
            tx = session.beginTransaction();
            obj = session.createQuery(string).uniqueResult();
            tx.commit();
        } catch (Exception e1) {
            try {tx.rollback();}catch (Exception e){}
            throw new DataAccessLayerException(e1);
        } finally {
            try { session.close(); } catch ( Exception e ){}
        }
        return obj;
    }

    @SuppressWarnings("unchecked")
    public List<Object[]> executeNamedQueryList(String query, Class<T> class1) {
        Session session = null;
        Transaction tx = null;
        List<Object[]> query1 = null;
        try {
            session = HibernateFactory.openSession();
            tx = session.beginTransaction();
            query1 = (List<Object[]>) session.createQuery(query).list();
            tx.commit();
        } catch (Exception e1) {
            try {tx.rollback();}catch (Exception e){}
            throw new DataAccessLayerException(e1);
        } finally {
            try { session.close(); } catch ( Exception e ){}
        }
        return query1;
    }

    @SuppressWarnings("unchecked")
    public List<Object[]> executeNamedQueryObject(String query) {
        Session session = null;
        Transaction tx = null;
        List<Object[]> query1 = null;
        try {
            session = HibernateFactory.openSession();
            tx = session.beginTransaction();
            query1 = (List<Object[]>) session.getNamedQuery(query).list();
            tx.commit();
        } catch (Exception e1) {
            try {tx.rollback();}catch (Exception e){}
            throw new DataAccessLayerException(e1);
        } finally {
            try { session.close(); } catch ( Exception e ){}
        }
        return query1;
    }

    @SuppressWarnings("unchecked")
    public List<T> executeTypeQuery(String string) {
        Session session = null;
        Transaction tx = null;
        List<T> list1 = null;
        try {
            session = HibernateFactory.openSession();
            tx = session.beginTransaction();
            Query query = session.createQuery(string);
            list1 = query.list();
            tx.commit();
        } catch (Exception e1) {
            try {tx.rollback();}catch (Exception e){}
            throw new DataAccessLayerException(e1);
        } finally {
            try { session.close(); } catch ( Exception e ){}
        }
        return list1;
    }

    public Object executeNativeQuery(String query, Object... params) {
        Session session = null;
        Transaction tx = null;
        Object obj = null;
        try {
            session = HibernateFactory.openSession();
            tx = session.beginTransaction();
            Query createNamedQuery = session.createQuery(query);

            for (int i = 0; i < params.length; i++) {
                createNamedQuery.setParameter(i, params[i]);
            }
            obj = createNamedQuery.list();
            tx.commit();
        } catch (Exception e1) {
            try {tx.rollback();}catch (Exception e){}
            throw new DataAccessLayerException(e1);
        } finally {
            try { session.close(); } catch ( Exception e ){}
        }

        return obj;
    }
    
    @SuppressWarnings("unchecked")
    public List<T> executeQueryParametersNative(String query) {
        Session session = null;
        Transaction tx = null;
        Query queryparameters = null;
        List<T> list2 = null;
        try {
            session = HibernateFactory.openSession();
            tx = session.beginTransaction();
            queryparameters = session.createQuery(query);             
            list2 = queryparameters.list();
            tx.commit();
        } catch (Exception e1) {
            try {tx.rollback();}catch (Exception e){}
            throw new DataAccessLayerException(e1);
        } finally {
            try { session.close(); } catch ( Exception e ){}
        }
        return list2;
    }
    
    //This is a special method to return CsoInputFileControl query using in Operator
  /*  @SuppressWarnings("unchecked")
    public List<T> executeQueryParametersNativeSQL(Set<String> attributes,String qury) {
        Query query = null;
        List<T> list2 = null;
        try {
            startOperation();
            query = session.createQuery(qury);
            query.setParameterList("processStatus", attributes);
            list2 = query.list();
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            HibernateFactory.close(session);
        }
        return list2;
    }
*/
    public void deleteBulk(String deletequery) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateFactory.openSession();
            tx = session.beginTransaction();
            Query query = session.createQuery(deletequery);
            query.executeUpdate();
            tx.commit();
        } catch (Exception e1) {
            try {tx.rollback();}catch (Exception e){}
            throw new DataAccessLayerException(e1);
        } finally {
            try { session.close(); } catch ( Exception e ){}
        }
    }
    public void deleteTruncate(String deletequery) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateFactory.openSession();
            tx = session.beginTransaction();
            Query query = session.createSQLQuery(deletequery);
            query.executeUpdate();
            tx.commit();
        } catch (Exception e1) {
            try {tx.rollback();}catch (Exception e){}
            throw new DataAccessLayerException(e1);
        } finally {
            try { session.close(); } catch ( Exception e ){}
        }
    }

    @SuppressWarnings("unchecked")
    public List<T> executeQueryParameters(String query, Map<String, Object> parameters) {
        Session session = null;
        Transaction tx = null;
        Query queryparameters = null;
        List<T> list2 = null;
        try {
            session = HibernateFactory.openSession();
            tx = session.beginTransaction();
            queryparameters = session.createQuery(query);
            if (parameters != null && !parameters.isEmpty()) {
                for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                    queryparameters.setParameter(entry.getKey(), entry.getValue().toString());
                }
            }
            list2 = queryparameters.list();
            tx.commit();
        } catch (Exception e1) {
            try {tx.rollback();}catch (Exception e){}
            throw new DataAccessLayerException(e1);
        } finally {
            try { session.close(); } catch ( Exception e ){}
        }
        return list2;
    }

    @SuppressWarnings("unchecked")
    public List<T> executeQueryParametersDate(String query, Map<String, Object> parameters) {
        Session session = null;
        Transaction tx = null;
        Query queryparameters = null;
        List<T> list2 = null;
        try {
            session = HibernateFactory.openSession();
            tx = session.beginTransaction();
            queryparameters = session.createQuery(query);
            if (parameters != null && !parameters.isEmpty()) {
                for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                    queryparameters.setParameter(entry.getKey(), entry.getValue());
                }
            }
            list2 = queryparameters.list();
            tx.commit();
        } catch (Exception e1) {
            try {tx.rollback();}catch (Exception e){}
            throw new DataAccessLayerException(e1);
        } finally {
            try { session.close(); } catch ( Exception e ){}
        }
        return list2;
    }

    @SuppressWarnings("unchecked")
    public T executeQueryParametersSingle(String query, Map<String, Object> parameters) {
        Session session = null;
        Transaction tx = null;
        Query queryparameters = null;
        T list3 = null;
        try {
            session = HibernateFactory.openSession();
            tx = session.beginTransaction();
            queryparameters = session.createQuery(query);
            if (parameters != null && !parameters.isEmpty()) {
                for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                    queryparameters.setParameter(entry.getKey(), entry.getValue().toString());
                }
            }
            if (queryparameters.list().size() > 0) {
                list3 = (T) queryparameters.list().get(0);
            } else {
                list3 = (T) queryparameters.uniqueResult();
            }
            tx.commit();
        } catch (Exception e1) {
            try {tx.rollback();}catch (Exception e){}
            throw new DataAccessLayerException(e1);
        } finally {
            try { session.close(); } catch ( Exception e ){}
        }
        return list3;
    }

    @SuppressWarnings("unchecked")
    public T executeQueryParametersSingleDate(String query, Map<String, Object> parameters) {
        Session session = null;
        Transaction tx = null;
        Query queryparameters = null;
        T list3 = null;
        try {
            session = HibernateFactory.openSession();
            tx = session.beginTransaction();
            queryparameters = session.createQuery(query);
            if (parameters != null && !parameters.isEmpty()) {
                for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                    queryparameters.setParameter(entry.getKey(), entry.getValue());
                }
            }
            if (!queryparameters.list().isEmpty()) {
                list3 = (T) queryparameters.list().get(0);
            } else {
                list3 = (T) queryparameters.uniqueResult();
            }
            tx.commit();
        } catch (Exception e1) {
            try {tx.rollback();}catch (Exception e){}
            throw new DataAccessLayerException(e1);
        } finally {
            try { session.close(); } catch ( Exception e ){}
        }
        return list3;
    }

//    protected void handleException(HibernateException e) {
//        HibernateFactory.rollback(tx);
//        throw new DataAccessLayerException(e1);
//    }

//    protected void startOperation() {
//        session = HibernateFactory.openSession();
//        tx = session.beginTransaction();
//    }

    /**
     * Get Dialect of JNDI datasource is pointing to.
     * @return
     */
    public Dialect getDialect() {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateFactory.openSession();
            tx = session.beginTransaction();
            SessionFactory sessionFactory = session.getSessionFactory();
            Dialect dialect = ((SessionFactoryImplementor) sessionFactory).getDialect();
            tx.commit();
            return dialect;
        } catch (Exception e1) {
            try {tx.rollback();}catch (Exception e){}
            throw new DataAccessLayerException(e1);
        } finally {
            try { session.close(); } catch ( Exception e ){}
        }
    }

    /**
     * Parameterized Hibernate Update Query
     *
     * @param hql
     * @param params
     * @return
     */
    public int update(String hql, Map<String, Object> params) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateFactory.openSession();
            tx = session.beginTransaction();
            Query query = session.createQuery(hql);
            for (String paramName : params.keySet()) {
                query.setParameter(paramName, params.get(paramName));
            }

            int result = query.executeUpdate();
            tx.commit();
            return result;
        } catch (Exception e1) {
            try {tx.rollback();}catch (Exception e){}
            throw new DataAccessLayerException(e1);
        } finally {
            try { session.close(); } catch ( Exception e ){}
        }
    }

    /**
     * Will permit Native Oracle and MySQL to be passed to it
     * as opposed to a named query that can only be bound to one native sql.
     *
     * @param sql
     * @return
     */
    public Object executeSQLQuery(String sql) {
        Session session = null;
        Transaction tx = null;
        try{
            session = HibernateFactory.openSession();
            tx = session.beginTransaction();
            SQLQuery query = session.createSQLQuery(sql);

            List result = query.list();
            tx.commit();
            return result;
        } catch (Exception e1) {
            try {tx.rollback();}catch (Exception e){}
            throw new DataAccessLayerException(e1);
        } finally {
            try { session.close(); } catch ( Exception e ){}
        }
    }
    /**
     * Get Unique Result
     * @param hql
     * @param params
     * @param clazz
     * @return
     */
    public T executeSQLQuery(String hql,  Map<String, Object> params, Class<T> clazz) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateFactory.openSession();
            tx = session.beginTransaction();
            Query query = session.createQuery(hql);
            for (String paramName : params.keySet()) {
                query.setParameter(paramName, params.get(paramName));
            }
            List result = query.list();
            T rs = null;
            if (result.size() > 0) {
                rs = (T) result.get(0);
            }
            tx.commit();
            return rs;
        } catch (Exception e1) {
            try {tx.rollback();}catch (Exception e){}
            throw new DataAccessLayerException(e1);
        } finally {
            try { session.close(); } catch ( Exception e ){}
        }
    }

    public Session getSession() {
        return null; //session is null;
    }

    public void setSession(Session session) {
        // this.session = session;
    }

    public Transaction getTx() {
        return null; //tx;
    }

    public void setTx(Transaction tx) {
        //this.tx = tx;
    }


    protected List<T> list(String sql,  Class<T> clazz) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateFactory.openSession();
            tx = session.beginTransaction();
            SQLQuery query = session.createSQLQuery(sql);

            // tell hibernate list type to return
            query.addEntity(clazz);

            List result = query.list();
            tx.commit();
            return result;
        } catch (Exception e1) {
            try {tx.rollback();}catch (Exception e){}
            throw new DataAccessLayerException(e1);
        } finally {
            try { session.close(); } catch ( Exception e ){}
        }
    }

    protected List<T> list(String sql, Map<String, Object> params, Class<T> clazz) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateFactory.openSession();
            tx = session.beginTransaction();
            SQLQuery query = session.createSQLQuery(sql);
            for (String key : params.keySet()) {
                query.setParameter(key, params.get(key));
            }

            // tell hibernate list type to return
            query.addEntity(clazz);
            tx.commit();
            return query.list();
        } catch (Exception e1) {
            try {tx.rollback();}catch (Exception e){}
            throw new DataAccessLayerException(e1);
        } finally {
            try { session.close(); } catch ( Exception e ){}
        }
    }

    /**
     * Get unique result
     *
     * @param sql
     * @param clazz
     * @return
     */
    protected T uniqueResult(String sql, Map<String, Object> params, Class<T> clazz) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateFactory.openSession();
            tx = session.beginTransaction();
            SQLQuery query = session.createSQLQuery(sql);

            // set parameters
            for (String paramName : params.keySet()) {
                Object value = params.get(paramName);
                query.setParameter(paramName, value);
            }

            // tell hibernate object type to return
            query.addEntity(clazz);
            T result = (T) query.uniqueResult();
            tx.commit();
            return result;
        } catch (Exception e1) {
            try {tx.rollback();}catch (Exception e){}
            throw new DataAccessLayerException(e1);
        } finally {
            try { session.close(); } catch ( Exception e ){}
        }
    }

    /**
     * Get unique result
     *
     * @param sql
     * @param clazz
     * @return
     */
    protected T uniqueResult(String sql,  Class<T> clazz) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateFactory.openSession();
            tx = session.beginTransaction();
            SQLQuery query = session.createSQLQuery(sql);

            // tell hibernate object type to return
            query.addEntity(clazz);
            T result = (T) query.uniqueResult();
            tx.commit();
            return result;
        } catch (Exception e1) {
            try {tx.rollback();}catch (Exception e){}
            throw new DataAccessLayerException(e1);
        } finally {
            try { session.close(); } catch ( Exception e ){}
        }
    }

    /**
     * TODO Document
     *
     * @param sql
     * @param payload
     * @return database update result list
     */
    public List<Integer> executeUpdate(String sql, List<Map<String, Object>> payload) {

        List<Integer> results = new ArrayList<>();
        Session session = null;
        Transaction tx = null;
        try {

            session = HibernateFactory.openSession();
            tx = session.beginTransaction();

            for (Map<String, Object> params : payload) {
                int result = executeUpdate(sql, params);
                results.add(result);
            }
            tx.commit();
            return results;
        } catch (Exception e1) {
            try {tx.rollback();}catch (Exception e){}
            throw new DataAccessLayerException(e1);
        } finally {
            try { session.close(); } catch ( Exception e ){}
        }
    }
    /**
     * TODO Document
     *
     * @param sql
     * @param payload
     * @return database update result list
     */
    public Integer executeUpdate(String sql) {

        Session session = null;
        Transaction tx = null;
        try {

            session = HibernateFactory.openSession();
            tx = session.beginTransaction();
            Object query = executeSQLQuery(sql);
            tx.commit();
            return 1;
            
        } catch (Exception e1) {
            try {tx.rollback();}catch (Exception e){}
            throw new DataAccessLayerException(e1);
        } finally {
            try { session.close(); } catch ( Exception e ){}
        }
    }
    
    /**
     * TODO Document
     *
     * @param sql
     * @param payload
     * @return database update result list
     */
    /**
     * //This method inserts data to the table using an insert and it also 
     * This method updates the data in the table at the same time.
     * So it does the insert and also the update on the same data same time.
     * */
    public Integer executeSelectQuery(String sql) {

        Session session = null;
        Transaction tx = null;
        try {

            session = HibernateFactory.openSession();
            tx = session.beginTransaction();
            int queryCount = session.createSQLQuery(sql).executeUpdate();
            tx.commit();
            return queryCount;
            
        } catch (Exception e1) {
            try {tx.rollback();}catch (Exception e){}
            throw new DataAccessLayerException(e1);
        } finally {
            try { session.close(); } catch ( Exception e ){}
        }
    }

    protected Integer executeUpdate(String sql, Map<String, Object> params) {
        Session session = null;
        Transaction tx = null;
        try {

            session = HibernateFactory.openSession();
            tx = session.beginTransaction();

            SQLQuery query = session.createSQLQuery(sql);

            for (String paramName : params.keySet()) {
                Object value = params.get(paramName);
                query.setParameter(paramName, value);
            }

            // execute
            int result = query.executeUpdate();

            // commit transaction
            tx.commit();

            return result;
        } catch (Exception e1) {
            try {tx.rollback();}catch (Exception e){}
            throw new DataAccessLayerException(e1);
        } finally {
            try { session.close(); } catch ( Exception e ){}
        }
    }
}
