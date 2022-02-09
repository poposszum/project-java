package com.example.firstproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Scanner;


@SpringBootApplication
public class FirstprojectApplication {

    public static void printMenu(String[] options) {
        for (String option : options) {
            System.out.println(option);
        }
        System.out.println("Choose your option: ");
    }


    public static void main(String[] args) throws IOException {
        SpringApplication.run(FirstprojectApplication.class, args);

        String[] options = {
                "|          Menu          |",
                "|                        |",
                "|     1 - Cart list      |",
                "| 2 - Search cart by ID  |",
                "|3 - List number of Carts|",
                "|   4 - Aggregated cost  |",
                "|   5 - Average cost     |",
                "|  6 - List top owner    |",
                "|  7 - Delete Cart by ID |",
                "|       0 - Exit         |",
        };

        Scanner input = new Scanner(System.in);

        CartService cartService = new CartService();
        cartService.parseCarts();

        int option = 1;
        while (option != 0) {
            printMenu(options);
            try {
                option = input.nextInt();
                switch (option) {
                    case 1: {
                        cartService.listCarts();
                    } break;
                    case 2: {
                        System.out.println(cartService.getCartById(input.next()));
                    } break;
                    case 3: {
                        System.out.println(cartService.getNumberOfCarts());
                    } break;
                    case 4: {
                        System.out.println(cartService.getAggregatedCost());
                    } break;
                    case 5: {
                        System.out.println(cartService.getAverageCost());
                    } break;
                    case 6: {
                        System.out.println(cartService.topOwners(input.nextInt()));
                    } break;
                    case 7: {
                        cartService.deleteUser(input.next());
                    } break;
                }
            } catch (Exception ex) {
                System.out.println("Menu does not contain the given number");
                input.next();
            }
        }
    }
}
