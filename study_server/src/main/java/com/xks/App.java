package com.xks;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        System.out.println("start...");
        SpringApplication.run(App.class);
        System.out.println("end...");
    }
}
