package com.monotonic.testing.m6;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class SalesReportSystemTest {

    @Test
    public void shouldPrintStoreReportForSampleData() {
        ApplicationRunner runner = new ApplicationRunner();
        String report = runner.run("src/main/resources/example-sales.csv");

        assertThat(report, containsString("- London          -    235 -"));
    }
}
