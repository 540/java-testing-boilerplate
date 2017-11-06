package com.deg540.tdd;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PurchaseBuilder {

    private List<PurchaseItem> items = Collections.emptyList();
    private int discount = 0;
    private int shipping = 0;

    public static PurchaseBuilder anEmptyPurchase() {
        return new PurchaseBuilder();
    }

    public static PurchaseBuilder aPurchaseWithSingleItem() {
        return new PurchaseBuilder().withItems(PurchaseItemMother.aPurchaseItem());
    }

    public static PurchaseBuilder aPurchaseWithSingleItemAndMultipleQuantity() {
        return new PurchaseBuilder().withItems(PurchaseItemMother.aPurchaseItemWithMultipleQuantity());
    }

    public static PurchaseBuilder aPurchaseWithMultipleItems() {
        return new PurchaseBuilder().withItems(PurchaseItemMother.aPurchaseItemList());
    }

    public PurchaseBuilder withItems(PurchaseItem... items) {
        this.items = Arrays.asList(items);

        return this;
    }

    public PurchaseBuilder withDiscount() {
        this.discount = 10;

        return this;
    }

    public PurchaseBuilder withDiscount(int discount) {
        this.discount = discount;

        return this;
    }

    public PurchaseBuilder withSipping(int shipping) {
        this.shipping = shipping;

        return this;
    }

    public Purchase build() {
        return new Purchase(items, discount, shipping);
    }

    public static Purchase createAPurchase() {
        return PurchaseBuilder.aPurchaseWithMultipleItems().build();
    }
}
