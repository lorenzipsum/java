package com.monotonic.testing.m6;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;

public class SalesRepositoryTest {

    @Test
    public void shouldLoadSampleData() {
        //given
        SalesRepository repository = new SalesRepository("src/main/resources/example-sales.csv");

        //when
        List<Sale> sales = repository.loadSales();

        //then
        assertThat(sales, hasItem(allOf(
                hasProperty("store", equalTo("London")),
                hasProperty("number", equalTo(2)),
                hasProperty("pricePerItem", equalTo(30)))));
    }
}
