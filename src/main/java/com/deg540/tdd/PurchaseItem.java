package com.deg540.tdd;

public class PurchaseItem {

    private String slug;
    private String name;
    private double price;
    private int vat;
    private int quantity;

    public PurchaseItem(String slug, String name, double price, int vat, int quantity) {
        this.slug = slug;
        this.name = name;
        this.price = price;
        this.vat = vat;
        this.quantity = quantity;
    }

    public double price() {
        return price;
    }

    public int quantity() {
        return quantity;
    }

    public double taxes() {
        double tax = price - price / (1 + (double) vat / 100);

        return Math.round(tax * 100d) / 100d;
    }
}
