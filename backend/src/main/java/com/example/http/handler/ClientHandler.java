package com.example.http.handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.example.controller.ClientController;

import java.io.IOException;

public class ClientHandler implements HttpHandler {

    private final ClientController controller;

    public ClientHandler() {
        this.controller = new ClientController();
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        try {
            String method = exchange.getRequestMethod();
            if ("GET".equals(method)) {
                controller.getAllClients(exchange);
            } else if ("POST".equals(method)) {
                controller.createClient(exchange);
            } else {
                exchange.sendResponseHeaders(405, -1);
            }
        } catch (Exception e) {
            exchange.sendResponseHeaders(500, -1); // Internal Server Error
            e.printStackTrace();
        } finally {
            exchange.close();
        }
    }
}
