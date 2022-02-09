package com.example.firstproject.cart;


import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class CartService {

    public List<Cart> cartList;

    public void parseCarts() {
        String fileName = "src/main/resources/data/example0.csv";

        try {
            cartList = new CsvToBeanBuilder(new FileReader(fileName))
                    .withType(Cart.class)
                    .build()
                    .parse();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void listCarts() {
        cartList.forEach(System.out::println);
    }

    public Cart getCartById(String id) {
        return cartList.stream().filter(cart -> id.equals(cart.getId()))
                .findAny()
                .orElse(null);
    }

    public int getNumberOfCarts() {
        return cartList.size();
    }

    public int getAggregatedCost() {
        return cartList.stream().map(Cart::getCost)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public double getAverageCost() {
        return (double) cartList.stream().map(Cart::getCost)
                .mapToInt(Integer::intValue)
                .sum() / cartList.size();

        // return getAggregatedCost() / getNumberOfCarts();
    }

    public Map<String, Integer> topOwners(int limit) {
        Map<String, Integer> ownerMap = cartList.stream().
                collect(Collectors.groupingBy(Cart::getOwnerName, Collectors.summingInt(Cart::getCost)));

        return ownerMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(limit)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    public void deleteUser(String id) {
        cartList.remove(getCartById(id));
    }

}
