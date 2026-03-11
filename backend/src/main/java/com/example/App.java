package com.example;

import com.example.config.HibernateUtil;
import com.example.http.HttpServerLauncher;

/**
 * Hello world!
 */
public final class App {

    private App() {
    }

    /**
     * Says hello to the world.
     *
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        // Initialiser Hibernate
        System.out.println("Initializing Hibernate...");
        HibernateUtil.init();
        System.out.println("Hibernate initialized successfully.");

        // Créer un serveur HTTP qui écoute sur le port 8080
        HttpServerLauncher.start();

        // Garder l'application active
        synchronized (App.class) {
            try {
                App.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
