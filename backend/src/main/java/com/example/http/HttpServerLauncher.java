package com.example.http;

import com.example.controller.HelloController;
import com.example.http.handler.ClientHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Create server.
 * Define port.
 * Start server.
 */
public final class HttpServerLauncher {

    // Définir une constante pour le port du serveur HTTP
    private static final int SERVER_PORT = 8080;

    // Constructeur privé pour empêcher l'instanciation de la classe
    private HttpServerLauncher() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    /**
     * Start the HTTP server.
     */
    public static void start() {

        try {

            // Créer un serveur HTTP qui écoute sur le port 8080
            HttpServer server = HttpServer.create(new InetSocketAddress(SERVER_PORT), 0);

            // Ajouter un contexte pour gérer les requêtes sur "/api/hello"
            server.createContext("/api/hello", new HelloController());

            server.createContext("/clients", new ClientHandler());

            server.setExecutor(null);
            server.start();

            System.out.println("HTTP Server started on port " + SERVER_PORT);

        } catch (IOException e) {
            throw new RuntimeException("Failed to start HTTP server", e);
        }

    }
}
