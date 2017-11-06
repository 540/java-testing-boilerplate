package com.deg540.tdd;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PurchaseShouldMother {
    @Test
    public void calculate_subprice_for_purchase_without_items() throws Exception {
        Purchase purchase = PurchaseMother.anEmptyPurchase();

        assertThat(purchase.subtotal(), is(0.0));
    }

    @Test
    public void calculate_subprice_for_purchase_with_single_item() throws Exception {
        Purchase purchase = PurchaseMother.aPurchaseWithSingleItem();

        assertThat(purchase.subtotal(), is(20.5));
    }

    @Test
    public void calculate_subprice_for_purchase_with_multiple_item() throws Exception {
        Purchase purchase = PurchaseMother.aPurchaseWithMultipleItems();

        assertThat(purchase.subtotal(), is(31.0));
    }

    @Test
    public void calculate_subprice_for_purchase_with_single_item_and_multiple_quantity() throws Exception {
        Purchase purchase = PurchaseMother.aPurchaseWithSingleItemAndMultipleQuantity();

        assertThat(purchase.subtotal(), is(41.0));
    }

    @Test
    public void calculate_discount_for_purchase_without_discount_and_single_item() throws Exception {
        Purchase purchase = PurchaseMother.aPurchaseWithSingleItem();

        assertThat(purchase.discount(), is(0.0));
    }

    @Test
    public void calculate_discount_for_purchase_without_discount_and_multiple_item() throws Exception {
        Purchase purchase = PurchaseMother.aPurchaseWithMultipleItems();

        assertThat(purchase.discount(), is(0.0));
    }

    @Test
    public void calculate_discount_for_purchase_with_discount_and_single_item() throws Exception {
        Purchase purchase = PurchaseMother.aPurchaseWithSingleItemAndDiscount();

        assertThat(purchase.discount(), is(2.05));
    }

    @Test
    public void calculate_discount_for_purchase_with_discount_and_multiple_item() throws Exception {
        Purchase purchase = PurchaseMother.aPurchaseWithMultipleItemsAndDiscount();

        assertThat(purchase.discount(), is(3.1));
    }

    @Test
    public void calculate_taxes_for_purchase_without_items() throws Exception {
        Purchase purchase = PurchaseMother.anEmptyPurchase();

        assertThat(purchase.taxes(), is(0.0));
    }

    @Test
    public void calculate_taxes_for_purchase_without_items_and_discount() throws Exception {
        Purchase purchase = PurchaseMother.anEmptyPurchaseWithDiscount();

        assertThat(purchase.taxes(), is(0.0));
    }

    @Test
    public void calculate_total_for_purchase_without_items() throws Exception {
        Purchase purchase = PurchaseMother.anEmptyPurchase();

        assertThat(purchase.total(), is(0.0));
    }

    @Test
    public void calculate_total_for_purchase_with_single_item() throws Exception {
        Purchase purchase = PurchaseMother.aPurchaseWithSingleItem();

        assertThat(purchase.total(), is(20.5));
    }

    @Test
    public void calculate_total_for_purchase_with_multiple_item() throws Exception {
        Purchase purchase = PurchaseMother.aPurchaseWithMultipleItems();

        assertThat(purchase.total(), is(31.0));
    }

    @Test
    public void calculate_total_for_purchase_with_single_item_and_multiple_quantity() throws Exception {
        Purchase purchase = PurchaseMother.aPurchaseWithSingleItemAndMultipleQuantity();

        assertThat(purchase.total(), is(41.0));
    }


    @Test
    public void calculate_total_for_purchase_with_discount() throws Exception {
        Purchase purchase = PurchaseMother.aPurchaseWithSingleItemAndAnotherDiscount();

        assertThat(purchase.total(), is(15.375));
    }

    @Test
    public void calculate_total_for_purchase_with_discount_and_shipping() throws Exception {
        Purchase purchase = PurchaseMother.aPurchaseWithSingleItemAndAnotherDiscountAndShipping();

        assertThat(purchase.total(), is(20.375));
    }

    @Test
    public void calculate_total_for_purchase_with_multiple_item_and_discount_and_shipping() throws Exception {
        Purchase purchase = PurchaseMother.aPurchaseWithMultipleItemsAndDiscountAndShipping();

        assertThat(purchase.total(), is(36.35));
    }
}
