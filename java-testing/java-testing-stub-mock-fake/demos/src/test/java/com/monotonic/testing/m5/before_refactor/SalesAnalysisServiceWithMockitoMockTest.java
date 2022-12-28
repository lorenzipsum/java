package com.monotonic.testing.m5.before_refactor;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SalesAnalysisServiceWithMockitoMockTest {
    private static final List<Sale> exampleSales = Arrays.asList(
            new Sale("Apples", "Cardiff", 10, 2),
            new Sale("Oranges", "Cardiff", 3, 5),
            new Sale("Bananas", "Cardiff", 6, 20),
            new Sale("Oranges", "London", 5, 7)
    );

    private static final Map<String, Integer> expectedStoreSales = new HashMap<>();

    static {
        expectedStoreSales.put("Cardiff", 155);
        expectedStoreSales.put("London", 35);
    }

    @Test
    public void shouldAggregateStoreSales() {
        //given
        SalesRepository mockRepo = mock(SalesRepository.class);
        when(mockRepo.loadSales()).thenReturn(exampleSales);
        SalesAnalysisService analysisService = new SalesAnalysisService(mockRepo);

        //when
        Map<String, Integer> tallyStoreSales = analysisService.tallyStoreSales();

        //then
        assertEquals(tallyStoreSales, expectedStoreSales);
        verify(mockRepo).loadSales();
    }
}
