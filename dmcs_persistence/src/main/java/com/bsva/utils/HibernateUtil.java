
package com.bsva.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * @author Augustine
 *
 */
public class HibernateUtil {

	// sessionFactory is an expensive resource to create
	private static StandardServiceRegistry standardServiceRegistry;

	private static SessionFactory sessionFactory;

	private static SessionFactory buildSessionFactory() {
		// check if sessionFactory is null or not
		if (sessionFactory == null) {
			try {
				// First Create a StandardServiceRegistry
				standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
				// Then Create MetadataSources for Hibernate 5
				MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
				// Then Create Metadata
				Metadata metadata = metadataSources.getMetadataBuilder().build();
				// Create SessionFactory Hibernate 5
				sessionFactory = metadata.getSessionFactoryBuilder().build();
			}
			catch (Exception e) {
				e.printStackTrace();
				// Destroy standardServiceRegistry
				if (standardServiceRegistry != null) {
					StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
				}
			}
		}
		// return sessionfactory
		return sessionFactory;
	}

	// Utility method to return SessionFactory
	public static SessionFactory getSessionFactory() {
		return buildSessionFactory();
	}

	// get current Session
	public static Session getCurrentSession() {
		return getSessionFactory().getCurrentSession();
	}

	// shut down sessionFactory
	public static void shutdown() {
		getSessionFactory().close();
	}

	/*
	 * private static SessionFactory buildSessionFactory() { try { Configuration configuration = new
	 * Configuration().addResource("hibernate.cfg.xml"); configuration.configure(); StandardServiceRegistryBuilder
	 * builder = new StandardServiceRegistryBuilder() .applySettings(configuration.getProperties()); return
	 * configuration.buildSessionFactory(builder.build()); } catch (Exception ex) {
	 * System.err.println("Initial SessionFactory creation failed." + ex); throw new ExceptionInInitializerError(ex); }
	 * }
	 * 
	 * public static SessionFactory getSessionFactory() { return buildSessionFactory(); }
	 * 
	 * public static Session getCurrentSession() { return getSessionFactory().getCurrentSession(); }
	 * 
	 * public static void shutdown() { getSessionFactory().close(); }
	 */

}
