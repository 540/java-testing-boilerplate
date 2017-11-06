package com.deg540.tdd;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PurchaseShould {
    @Test
    public void calculate_subprice_for_purchase_without_items() throws Exception {
        List<PurchaseItem> items = Collections.emptyList();

        Purchase purchase = new Purchase(items, 0, 0);

        assertThat(purchase.subtotal(), is(0.0));
    }

    @Test
    public void calculate_subprice_for_purchase_with_single_item() throws Exception {
        List<PurchaseItem> items = Collections.singletonList(new PurchaseItem("name1", "Name 1", 20.5, 10, 1));

        Purchase purchase = new Purchase(items, 0, 0);

        assertThat(purchase.subtotal(), is(20.5));
    }

    @Test
    public void calculate_subprice_for_purchase_with_multiple_item() throws Exception {
        List<PurchaseItem> items = Arrays.asList(
                new PurchaseItem("name1", "Name 1", 20.5, 10, 1),
                new PurchaseItem("name2", "Name 2", 10.5, 10, 1));

        Purchase purchase = new Purchase(items, 0, 0);

        assertThat(purchase.subtotal(), is(31.0));
    }

    @Test
    public void calculate_subprice_for_purchase_with_single_item_and_multiple_quantity() throws Exception {
        List<PurchaseItem> items = Collections.singletonList(new PurchaseItem("name1", "Name 1", 20.5, 10, 2));

        Purchase purchase = new Purchase(items, 0, 0);

        assertThat(purchase.subtotal(), is(41.0));
    }

    @Test
    public void calculate_discout_for_purchase_without_discount_and_single_item() throws Exception {
        List<PurchaseItem> items = Collections.singletonList(new PurchaseItem("name1", "Name 1", 20.5, 10, 1));

        Purchase purchase = new Purchase(items, 0, 0);

        assertThat(purchase.discount(), is(0.0));
    }

    @Test
    public void calculate_discout_for_purchase_without_discount_and_multiple_item() throws Exception {
        List<PurchaseItem> items = Arrays.asList(
                new PurchaseItem("name1", "Name 1", 20.5, 10, 1),
                new PurchaseItem("name2", "Name 2", 10.5, 10, 1));

        Purchase purchase = new Purchase(items, 0, 0);

        assertThat(purchase.discount(), is(0.0));
    }

    @Test
    public void calculate_discout_for_purchase_with_discount_and_single_item() throws Exception {
        List<PurchaseItem> items = Collections.singletonList(new PurchaseItem("name1", "Name 1", 20.5, 10, 1));

        Purchase purchase = new Purchase(items, 10, 0);

        assertThat(purchase.discount(), is(2.05));
    }

    @Test
    public void calculate_discout_for_purchase_with_discount_and_multiple_item() throws Exception {
        List<PurchaseItem> items = Arrays.asList(
                new PurchaseItem("name1", "Name 1", 20.5, 10, 1),
                new PurchaseItem("name2", "Name 2", 10.5, 10, 1));

        Purchase purchase = new Purchase(items, 10, 0);

        assertThat(purchase.discount(), is(3.1));
    }

    @Test
    public void calculate_taxes_for_purchase_without_items() throws Exception {
        List<PurchaseItem> items = Collections.emptyList();

        Purchase purchase = new Purchase(items, 0, 0);

        assertThat(purchase.taxes(), is(0.0));
    }

    @Test
    public void calculate_taxes_for_purchase_without_items_and_discount() throws Exception {
        List<PurchaseItem> items = Collections.emptyList();

        Purchase purchase = new Purchase(items, 10, 0);

        assertThat(purchase.taxes(), is(0.0));
    }

    @Test
    public void calculate_total_for_purchase_without_items() throws Exception {
        List<PurchaseItem> items = Collections.emptyList();

        Purchase purchase = new Purchase(items, 0, 0);

        assertThat(purchase.total(), is(0.0));
    }

    @Test
    public void calculate_total_for_purchase_with_single_item() throws Exception {
        List<PurchaseItem> items = Collections.singletonList(new PurchaseItem("name1", "Name 1", 20.5, 10, 1));

        Purchase purchase = new Purchase(items, 0, 0);

        assertThat(purchase.total(), is(20.5));
    }

    @Test
    public void calculate_total_for_purchase_with_multiple_item() throws Exception {
        List<PurchaseItem> items = Arrays.asList(
                new PurchaseItem("name1", "Name 1", 20.5, 10, 1),
                new PurchaseItem("name2", "Name 2", 10.5, 10, 1));

        Purchase purchase = new Purchase(items, 0, 0);

        assertThat(purchase.total(), is(31.0));
    }

    @Test
    public void calculate_total_for_purchase_with_single_item_and_multiple_quantity() throws Exception {
        List<PurchaseItem> items = Collections.singletonList(new PurchaseItem("name1", "Name 1", 20.5, 10, 2));

        Purchase purchase = new Purchase(items, 0, 0);

        assertThat(purchase.total(), is(41.0));
    }


    @Test
    public void calculate_total_for_purchase_with_discount() throws Exception {
        List<PurchaseItem> items = Collections.singletonList(new PurchaseItem("name1", "Name 1", 20.5, 10, 1));

        Purchase purchase = new Purchase(items, 25, 0);

        assertThat(purchase.total(), is(15.375));
    }

    @Test
    public void calculate_total_for_purchase_with_discount_and_shipping() throws Exception {
        List<PurchaseItem> items = Collections.singletonList(new PurchaseItem("name1", "Name 1", 20.5, 10, 1));

        Purchase purchase = new Purchase(items, 25, 5);

        assertThat(purchase.total(), is(20.375));
    }

    @Test
    public void calculate_total_for_purchase_with_multiple_item_and_discount_and_shipping() throws Exception {
        List<PurchaseItem> items = Arrays.asList(
                new PurchaseItem("name1", "Name 1", 20.5, 10, 1),
                new PurchaseItem("name2", "Name 2", 10.5, 10, 1));

        Purchase purchase = new Purchase(items, 15, 10);

        assertThat(purchase.total(), is(36.35));
    }
}
