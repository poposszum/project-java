package com.example.firstproject;

import com.example.firstproject.cart.MenuService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class FirstprojectApplication {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(FirstprojectApplication.class, args);

        MenuService menuService = new MenuService();

        menuService.startMenu();
    }
}
