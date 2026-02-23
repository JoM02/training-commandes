package com.example.repository;

import com.example.config.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Repository class for managing database operations related to "Hello"
 * messages.
 * This class provides methods to interact with the database using Hibernate.
 */
public class HelloRepository {

    /**
     * Fetches a "Hello" message from the database.
     * If no message is found, a default message is returned.
     *
     * @return A "Hello" message as a {@link String}.
     */
    public String fetchHelloMessage() {
        Transaction transaction = null;
        String message = "Hello, World!"; // Valeur par défaut

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            // Exemple : récupérer un message depuis une table "messages"
            message = (String) session.createQuery("SELECT * FROM Client;")
                    .uniqueResult();

            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return message;
    }
}
