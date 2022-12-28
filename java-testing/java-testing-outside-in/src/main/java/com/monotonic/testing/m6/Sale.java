package com.monotonic.testing.m6;

public class Sale {
    private final String store;
    private final int number;
    private final int pricePerItem;

    public Sale(String store, int number, int pricePerItem) {
        this.store = store;
        this.number = number;
        this.pricePerItem = pricePerItem;
    }

    public String getStore() {
        return store;
    }

    public int getNumber() {
        return number;
    }

    public int getPricePerItem() {
        return pricePerItem;
    }

    public int getValue() {
        return getNumber() * getPricePerItem();
    }

    @Override
    public String toString() {
        return "Sale{" +
                "store='" + store + '\'' +
                ", number=" + number +
                ", pricePerItem=" + pricePerItem +
                '}';
    }
}
