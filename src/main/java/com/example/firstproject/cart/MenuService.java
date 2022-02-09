package com.example.firstproject.cart;


import java.util.Scanner;

public class MenuService {

    public static void printMenu(String[] options) {
        for (String option : options) {
            System.out.println(option);
        }
        System.out.println("Choose your option: ");
    }

    public void startMenu() {
        String[] options = {
                " _________________________ ",
                "/           Menu          \\",
                "|                          |",
                "|      1 - Cart list       |",
                "|  2 - Search cart by ID   |",
                "| 3 - List number of Carts |",
                "|    4 - Aggregated cost   |",
                "|    5 - Average cost      |",
                "|   6 - List top owner     |",
                "|   7 - Delete Cart by ID  |",
                "\\        0 - Exit         /",
                " ````````````````````````` ",
        };

        CartService cartService = new CartService();
        cartService.parseCarts();
        Scanner input = new Scanner(System.in);
        int option = 1;
        while (option != 0) {
            printMenu(options);
            option = input.nextInt();
            switch (option) {
                case 1: {
                    cartService.listCarts();
                }
                break;
                case 2: {
                    System.out.println("Enter the ID: ");
                    System.out.println(cartService.getCartById(input.next()));
                }
                break;
                case 3: {
                    System.out.println("The number of Carts: " + cartService.getNumberOfCarts());
                }
                break;
                case 4: {
                    System.out.println("Aggregated cost of the Carts: " + cartService.getAggregatedCost());
                }
                break;
                case 5: {
                    System.out.println("Average cost of the Carts: " + cartService.getAverageCost());
                }
                break;
                case 6: {
                    System.out.println("How many owners do you want to list ?");
                    System.out.println(cartService.topOwners(input.nextInt()));
                }
                break;
                case 7: {
                    System.out.println("Enter the user ID: ");
                    cartService.deleteUser(input.next());
                }
                break;

                default: {
                    System.out.println("Menu does not contain the given number");
                }
            }
        }
    }
}
