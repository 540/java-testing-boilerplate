package com.deg540.tdd;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PurchaseMother {

    public static Purchase anEmptyPurchase() {
        return new Purchase(Collections.emptyList(), 0, 0);
    }

    public static Purchase aPurchaseWithSingleItem() {
        List<PurchaseItem> items = Collections.singletonList(new PurchaseItem("name1", "Name 1", 20.5, 10, 1));

        return new Purchase(items, 0, 0);
    }

    public static Purchase aPurchaseWithSingleItemAndMultipleQuantity() {
        List<PurchaseItem> items = Collections.singletonList(new PurchaseItem("name1", "Name 1", 20.5, 10, 2));

        return new Purchase(items, 0, 0);
    }

    public static Purchase aPurchaseWithMultipleItems() {
        List<PurchaseItem> items = Arrays.asList(
                new PurchaseItem("name1", "Name 1", 20.5, 10, 1),
                new PurchaseItem("name2", "Name 2", 10.5, 10, 1));

        return new Purchase(items, 0, 0);
    }

    public static Purchase aPurchaseWithSingleItemAndDiscount() {
        List<PurchaseItem> items = Collections.singletonList(new PurchaseItem("name1", "Name 1", 20.5, 10, 1));

        return new Purchase(items, 10, 0);
    }

    public static Purchase aPurchaseWithSingleItemAndAnotherDiscount() {
        List<PurchaseItem> items = Collections.singletonList(new PurchaseItem("name1", "Name 1", 20.5, 10, 1));

        return new Purchase(items, 25, 0);
    }

    public static Purchase aPurchaseWithMultipleItemsAndDiscount() {
        List<PurchaseItem> items = Arrays.asList(
                new PurchaseItem("name1", "Name 1", 20.5, 10, 1),
                new PurchaseItem("name2", "Name 2", 10.5, 10, 1));

        return new Purchase(items, 10, 0);
    }

    public static Purchase anEmptyPurchaseWithDiscount() {
        return new Purchase(Collections.emptyList(), 10, 0);
    }

    public static Purchase aPurchaseWithSingleItemAndAnotherDiscountAndShipping() {
        List<PurchaseItem> items = Collections.singletonList(new PurchaseItem("name1", "Name 1", 20.5, 10, 1));

        return new Purchase(items, 25, 5);
    }

    public static Purchase aPurchaseWithMultipleItemsAndDiscountAndShipping() {
        List<PurchaseItem> items = Arrays.asList(
                new PurchaseItem("name1", "Name 1", 20.5, 10, 1),
                new PurchaseItem("name2", "Name 2", 10.5, 10, 1));

        return new Purchase(items, 15, 10);
    }

}
