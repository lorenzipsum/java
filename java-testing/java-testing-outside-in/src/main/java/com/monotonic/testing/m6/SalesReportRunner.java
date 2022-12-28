package com.monotonic.testing.m6;


import java.io.PrintStream;

public class SalesReportRunner {

    private final PrintStream out;

    public SalesReportRunner(final PrintStream out) {
        this.out = out;
    }

    public static void main(String[] args) {
        String fileLocation = args[0];
        new SalesReportRunner(System.out).run(fileLocation);
    }

    public void run(final String fileLocation) {
        final SalesRepository repository = new SalesRepository(fileLocation);
        final SalesAnalyser analyser = new SalesAnalyser(repository);
        final SalesReport report = new SalesReport(analyser, this.out);

        report.run();
    }
}
