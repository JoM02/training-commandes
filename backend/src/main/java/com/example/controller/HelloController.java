package com.example.controller;

import com.example.service.HelloService;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Controller for handling HTTP requests to /api/hello.
 */
public class HelloController implements HttpHandler {
    // Constantes pour les codes de statut HTTP
    private static final int HTTP_OK = 200;
    private static final int HTTP_METHOD_NOT_ALLOWED = 405;

    private final HelloService helloService;

    public HelloController() {
        this.helloService = new HelloService();
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if ("GET".equals(exchange.getRequestMethod())) {
            String response = helloService.getHelloMessage();
            exchange.sendResponseHeaders(HTTP_OK, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        } else {
            exchange.sendResponseHeaders(HTTP_METHOD_NOT_ALLOWED, -1); // Méthode non autorisée
        }
    }
}
