package com.example.telem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class Application {

    public static void main(String[] args) {
        System.setProperty("server.servlet.context-path", "/padrao");
        SpringApplication.run(Application.class, args);
    }

}
