package com.example.application.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class CafeteriaItem {

    @Id
    private String name;
    private String label;
    private int price;

    public CafeteriaItem(String name, String label, int price) {
        this.name = name;
        this.label = label;
        this.price = price;
    }

    public CafeteriaItem() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
