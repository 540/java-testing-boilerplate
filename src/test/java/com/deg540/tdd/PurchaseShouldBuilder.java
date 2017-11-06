package com.deg540.tdd;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PurchaseShouldBuilder {
    @Test
    public void calculate_subprice_for_purchase_without_items() throws Exception {
        Purchase purchase = PurchaseBuilder.anEmptyPurchase().build();

        assertThat(purchase.subtotal(), is(0.0));
    }

    @Test
    public void calculate_subprice_for_purchase_with_single_item() throws Exception {
        Purchase purchase = PurchaseBuilder.aPurchaseWithSingleItem().build();

        assertThat(purchase.subtotal(), is(20.5));
    }

    @Test
    public void calculate_subprice_for_purchase_with_multiple_item() throws Exception {
        Purchase purchase = PurchaseBuilder.aPurchaseWithMultipleItems().build();

        assertThat(purchase.subtotal(), is(31.0));
    }

    @Test
    public void calculate_subprice_for_purchase_with_single_item_and_multiple_quantity() throws Exception {
        Purchase purchase = PurchaseBuilder.aPurchaseWithSingleItemAndMultipleQuantity().build();

        assertThat(purchase.subtotal(), is(41.0));
    }

    @Test
    public void calculate_discount_for_purchase_without_discount_and_single_item() throws Exception {
        Purchase purchase = PurchaseBuilder.aPurchaseWithSingleItem().build();

        assertThat(purchase.discount(), is(0.0));
    }

    @Test
    public void calculate_discount_for_purchase_without_discount_and_multiple_item() throws Exception {
        Purchase purchase = PurchaseBuilder.aPurchaseWithMultipleItems().build();

        assertThat(purchase.discount(), is(0.0));
    }

    @Test
    public void calculate_discount_for_purchase_with_discount_and_single_item() throws Exception {
        Purchase purchase = PurchaseBuilder.aPurchaseWithSingleItem().withDiscount().build();

        assertThat(purchase.discount(), is(2.05));
    }

    @Test
    public void calculate_discount_for_purchase_with_discount_and_multiple_item() throws Exception {
        Purchase purchase = PurchaseBuilder.aPurchaseWithMultipleItems().withDiscount().build();

        assertThat(purchase.discount(), is(3.1));
    }

    @Test
    public void calculate_taxes_for_purchase_without_items() throws Exception {
        Purchase purchase = PurchaseBuilder.anEmptyPurchase().build();

        assertThat(purchase.taxes(), is(0.0));
    }

    @Test
    public void calculate_taxes_for_purchase_without_items_and_discount() throws Exception {
        Purchase purchase = PurchaseBuilder.anEmptyPurchase().withDiscount().build();

        assertThat(purchase.taxes(), is(0.0));
    }

    @Test
    public void calculate_total_for_purchase_without_items() throws Exception {
        Purchase purchase = PurchaseBuilder.anEmptyPurchase().build();

        assertThat(purchase.total(), is(0.0));
    }

    @Test
    public void calculate_total_for_purchase_with_single_item() throws Exception {
        Purchase purchase = PurchaseBuilder.aPurchaseWithSingleItem().build();

        assertThat(purchase.total(), is(20.5));
    }

    @Test
    public void calculate_total_for_purchase_with_multiple_item() throws Exception {
        Purchase purchase = PurchaseBuilder.aPurchaseWithMultipleItems().build();

        assertThat(purchase.total(), is(31.0));
    }

    @Test
    public void calculate_total_for_purchase_with_single_item_and_multiple_quantity() throws Exception {
        Purchase purchase = PurchaseBuilder.aPurchaseWithSingleItemAndMultipleQuantity().build();

        assertThat(purchase.total(), is(41.0));
    }


    @Test
    public void calculate_total_for_purchase_with_discount() throws Exception {
        Purchase purchase = PurchaseBuilder.aPurchaseWithSingleItem().withDiscount(25).build();

        assertThat(purchase.total(), is(15.375));
    }

    @Test
    public void calculate_total_for_purchase_with_discount_and_shipping() throws Exception {
        Purchase purchase = PurchaseBuilder.aPurchaseWithSingleItem().withDiscount(25).withSipping(5).build();

        assertThat(purchase.total(), is(20.375));
    }

    @Test
    public void calculate_total_for_purchase_with_multiple_item_and_discount_and_shipping() throws Exception {
        Purchase purchase = PurchaseBuilder.aPurchaseWithMultipleItems().withDiscount(15).withSipping(10).build();

        assertThat(purchase.total(), is(36.35));
    }

    @Test
    public void calculate_total_for_purchase_with_another_item_and_discount_and_shipping() throws Exception {
        assertThat(PurchaseMother.aPurchaseWithMultipleItemsAndDiscountAndShipping().total(), is(36.35));
        Purchase purchase = PurchaseBuilder.anEmptyPurchase()
                .withItems(PurchaseItemMother.anotherPurchaseItem())
                .withDiscount(15)
                .withSipping(10)
                .build();

        assertThat(purchase.total(), is(18.925));
    }

    @Test
    public void calculate_total_for_purchase() throws Exception {
        Purchase purchase = PurchaseBuilder.createAPurchase();

        assertThat(purchase.total(), is(31.0));
    }

    @Test
    public void emptyPurchaseHasAllToZero() throws Exception {
        Purchase purchase = PurchaseBuilder.anEmptyPurchase().build();

        assertThat(purchase.total(), is(0.0));
        assertThat(purchase.taxes(), is(0.0));
        assertThat(purchase.subtotal(), is(0.0));
        assertThat(purchase.discount(), is(0.0));
    }




    private Matcher<Purchase> isZero() {
        return new BaseMatcher<Purchase>() {
            @Override
            public boolean matches(final Object item) {
                final Purchase purchase = (Purchase) item;
                return purchase.total() == 0
                        && purchase.taxes() == 0
                        && purchase.subtotal() == 0
                        && purchase.discount() == 0;
            }

            @Override
            public void describeTo(final Description description) {
                description.appendText("Values should be zero");
            }
        };
    }
}