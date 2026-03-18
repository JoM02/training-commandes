package com.example.config;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Utility class for managing Hibernate SessionFactory.
 */
public final class HibernateUtil {
    private static SessionFactory sessionFactory;

    // Private constructor to prevent instantiation
    private HibernateUtil() {
        throw new UnsupportedOperationException("Utility class");
    }

    /**
     * Initializes the Hibernate SessionFactory.
     */
    public static void init() {
        try {

            // Crée une configuration Hibernate
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml"); // Charge hibernate.cfg.xml

            // Ajoute automatiquement toutes les entités dans le package com.example.model
            // (ne fonctionne pas)
            // configuration.addPackage("com.example.model");

            sessionFactory = configuration.buildSessionFactory();

            System.out.println("Hibernate initialized successfully");

        } catch (HibernateException e) { // Capture d'une exception spécifique
            throw new RuntimeException("Failed to initialize Hibernate", e);
        }
    }

    /**
     * Gets the Hibernate SessionFactory.
     *
     * @return the SessionFactory
     * @throws IllegalStateException if the SessionFactory is not initialized
     */
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            throw new IllegalStateException("SessionFactory not initialized");
        }
        return sessionFactory;
    }

    /**
     * Shuts down the Hibernate SessionFactory.
     */
    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
