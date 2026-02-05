package com.mjc813.report.report02;

public class BatteryLessThan5Exception extends RuntimeException {
    public BatteryLessThan5Exception(String message) {
        super(message);
    }
}
