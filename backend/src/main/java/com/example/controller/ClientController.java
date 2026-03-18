package com.example.controller;

import com.example.service.ClientService;
import com.example.model.Client;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.util.List;

public class ClientController {

    private final ClientService service = new ClientService();

    public void getAllClients(HttpExchange exchange) throws IOException {
        try {
            List<Client> clients = service.getAllClients();
            String response = clients.toString(); // Remplacez par JSON si nécessaire
            exchange.sendResponseHeaders(200, response.getBytes().length);
            exchange.getResponseBody().write(response.getBytes());
        } catch (Exception e) {
            exchange.sendResponseHeaders(500, -1);
            e.printStackTrace();
        } finally {
            exchange.close();
        }
    }

    public void createClient(HttpExchange exchange) throws IOException {
        // on verra plus tard (POST + body)
        exchange.sendResponseHeaders(201, -1);
    }
}
