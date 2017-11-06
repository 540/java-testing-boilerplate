package com.deg540.tdd;

import java.util.List;

public class Purchase {

    private List<PurchaseItem> items;
    private int discount;
    private int shipping;

    public Purchase(List<PurchaseItem> items, int discount, int shipping) {
        this.items = items;
        this.discount = discount;
        this.shipping = shipping;
    }

    public double subtotal() {
        return items.stream()
                .mapToDouble(item -> item.price() * item.quantity())
                .sum();
    }

    public double total() {
        return subtotal() + shipping - discount();
    }

    public double discount() {
        return subtotal() * discount / 100;
    }

    public double taxes() {
        return items.stream()
                .mapToDouble(item -> item.taxes() * item.quantity())
                .sum();
    }

    public double shipping() {
        return shipping;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "items=" + items +
                ", discount=" + discount +
                ", shipping=" + shipping +
                '}';
    }
}
