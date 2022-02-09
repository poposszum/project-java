package com.example.firstproject;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class Cart {

    @CsvBindByName(column = "id")
    private String id;

    @CsvBindByName(column = "cost")
    private int cost;

    @CsvBindByName(column = "ownerName")
    private String ownerName;

    @CsvBindByName(column = "numberOfItems")
    private int numberOfItems;

    @CsvBindByName(column = "createdAt")
    private String createdAt;

    @Override
    public String toString() {
        return "id :" + this.getId()
                + ", owner name: " + this.getOwnerName()
                + ", cost: " + this.getCost()
                + ", number of items: " + this.getNumberOfItems()
                + ", created at:" + this.getCreatedAt();
    }
}
