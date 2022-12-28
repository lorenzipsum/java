package com.monotonic.testing.m5.before_refactor;

public class ReportRunner {

    public static void main(String[] args) {

        if (args.length < 1) {
            System.err.println("You must provide a commandline argument specifying the file to analyse");
            System.exit(-1);
        }
        final SalesRepository csvSalesRepository = new CsvSalesRepository(args[0]);
        final SalesAnalysisService salesAnalysisService = new SalesAnalysisService(csvSalesRepository);
        final SalesReport report = new SalesReport(System.out, salesAnalysisService);
        report.report();
    }

}
