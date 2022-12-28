package com.monotonic.testing.m6;

import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class SalesAnalyser {
    private final SalesRepository repository;

    public SalesAnalyser(SalesRepository repository) {
        this.repository = repository;
    }

    public Map<String, Integer> tallyCitySalesOld() {
        Map<String, Integer> citySales = new HashMap<>();

        this.repository.loadSales().forEach((sale) -> {
            if (citySales.containsKey(sale.getStore())) {
                int newValue = sale.getValue() + (Integer) citySales.get(sale.getStore());
                citySales.replace(sale.getStore(), newValue);
            } else {
                citySales.put(sale.getStore(), sale.getValue());
            }
        });

        return citySales;
    }

    public Map<String, Integer> tallyCitySales() {
        return this.repository.loadSales()
                .stream()
                .collect(groupingBy(Sale::getStore, summingInt(Sale::getValue)));

    }
}

