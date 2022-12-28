package com.monotonic.testing.m6;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class ApplicationRunner {

    public String run(String inputFile) {
        ByteArrayOutputStream dummyOutput = new ByteArrayOutputStream();
        SalesReportRunner app = new SalesReportRunner(new PrintStream(dummyOutput));
        app.run(inputFile);

        try {
            return dummyOutput.toString("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}

