package com.example.repository;

import com.example.config.HibernateUtil;
import com.example.model.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ClientRepository {

    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public List<Client> findAll() {

        Session session = sessionFactory.openSession();

        List<Client> clients = session
                .createQuery("FROM Client", Client.class)
                .getResultList();

        session.close();

        return clients;
    }

    public Client save(Client client) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(client); // Hibernate génère l'ID ici

        transaction.commit();
        session.close();

        return client;
    }
}