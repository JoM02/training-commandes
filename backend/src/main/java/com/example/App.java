package com.example;

import com.example.config.HibernateUtil;

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
        System.out.println("Starting application...");

        HibernateUtil.init();

        System.out.println("Application started.");
    }
}
