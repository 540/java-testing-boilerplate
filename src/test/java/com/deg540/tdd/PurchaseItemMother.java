package com.deg540.tdd;

public class PurchaseItemMother {
    public static PurchaseItem aPurchaseItem() {
        return new PurchaseItem("name1", "Name 1", 20.5, 10, 1);
    }

    public static PurchaseItem anotherPurchaseItem() {
        return new PurchaseItem("name2", "Name 2", 10.5, 10, 1);
    }

    public static PurchaseItem aPurchaseItemWithMultipleQuantity() {
        return new PurchaseItem("name1", "Name 1", 20.5, 10, 2);
    }

    public static PurchaseItem[] aPurchaseItemList() {
        return new PurchaseItem[]{
                new PurchaseItem("name1", "Name 1", 20.5, 10, 1),
                new PurchaseItem("name2", "Name 2", 10.5, 10, 1)
        };
    }

    private static PurchaseItem buildPurchaseItem(String slug, String name, int price, int vat, int quantity) {
        return new PurchaseItem(slug, name, price, vat, quantity);
    }
}
