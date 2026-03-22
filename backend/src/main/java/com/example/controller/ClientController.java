package com.example.controller;

import com.example.service.ClientService;
import com.example.model.Client;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ClientController {

    private final ClientService service = new ClientService();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public void getAllClients(HttpExchange exchange) throws IOException {
        try {
            List<Client> clients = service.getAllClients();

            // Utilisation d'object mapper pour map les données
            String json = objectMapper.writeValueAsString(clients);
            exchange.getResponseHeaders().add("Content-Type", "application/json");

            exchange.sendResponseHeaders(200, json.getBytes().length);
            exchange.getResponseBody().write(json.getBytes());
        } catch (Exception e) {
            exchange.sendResponseHeaders(500, -1);
            e.printStackTrace();
        } finally {
            exchange.close();
        }
    }

    public void createClient(HttpExchange exchange) throws IOException {

        if (!"POST".equals(exchange.getRequestMethod())) {
            exchange.sendResponseHeaders(405, -1);
            return;
        }

        // Lire le body
        StringBuilder bodyBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(exchange.getRequestBody()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                bodyBuilder.append(line);
            }
        }
        String body = bodyBuilder.toString();

        // Convertir JSON → objet
        Client client = objectMapper.readValue(body, Client.class);

        // Appel service
        Client created = service.createClient(client);

        String json = objectMapper.writeValueAsString(created);

        exchange.getResponseHeaders().add("Content-Type", "application/json");
        exchange.sendResponseHeaders(201, json.getBytes().length);
        exchange.getResponseBody().write(json.getBytes());
        exchange.close();
    }
}
