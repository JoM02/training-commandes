package com.example;

import com.example.config.HibernateUtil;
import com.example.controller.HelloController;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Hello world!
 */
public final class App {

    // Définir une constante pour le port du serveur HTTP
    private static final int SERVER_PORT = 8080;

    private App() {
    }

    /**
     * Says hello to the world.
     *
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        try {
            // Initialiser Hibernate
            System.out.println("Initializing Hibernate...");
            HibernateUtil.init();
            System.out.println("Hibernate initialized successfully.");

            // Créer un serveur HTTP qui écoute sur le port 8080
            HttpServer server = HttpServer.create(new InetSocketAddress(SERVER_PORT), 0);
            System.out.println("HTTP Server started on port " + SERVER_PORT);

            // Ajouter un contexte pour gérer les requêtes sur "/api/hello"
            server.createContext("/api/hello", new HelloController());

            // Démarrer le serveur
            server.start();

            // Garder l'application active
            synchronized (App.class) {
                try {
                    App.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
