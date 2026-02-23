package com.example.service;

import com.example.repository.HelloRepository;

/**
 * Service for handling LOGIQUE METIER to /api/hello.
 */
public class HelloService {
    private final HelloRepository helloRepository;

    public HelloService() {
        this.helloRepository = new HelloRepository();
    }

    public String getHelloMessage() {
        // Logique métier (par exemple, récupérer un message depuis la base de données)
        return helloRepository.fetchHelloMessage();
    }
}
