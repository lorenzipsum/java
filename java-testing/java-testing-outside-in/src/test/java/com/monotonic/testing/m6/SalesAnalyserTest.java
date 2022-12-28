package com.monotonic.testing.m6;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SalesAnalyserTest {

    private final SalesRepository repoMock = Mockito.mock(SalesRepository.class);

    private final SalesAnalyser analyser = new SalesAnalyser(repoMock);

    private static final List<Sale> exampleSales = Arrays.asList(
            new Sale("Cardiff", 10, 2),
            new Sale("Cardiff", 3, 5),
            new Sale("Cardiff", 6, 20),
            new Sale("London", 5, 7)
    );

    private static final Map<String, Integer> expectedStoreSales = new HashMap<>();

    static {
        expectedStoreSales.put("Cardiff", 155);
        expectedStoreSales.put("London", 35);
    }

    @Test
    public void shouldAggregateStoreSales() {
        //given
        when(repoMock.loadSales()).thenReturn(exampleSales);

        //when
        Map<String, Integer> citySales = analyser.tallyCitySales();

        //then
        assertEquals("Calculated wrong store sales", expectedStoreSales, citySales);
        verify(repoMock, times(1)).loadSales();
    }

}
