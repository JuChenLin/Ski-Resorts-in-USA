package com.priscilla.web.entity.enumerate;

public enum PriceRange {
    LOW("$"),
    MEDIUM("$$"),
    HIGH("$$$");

    private final String symbol;

//    private final String range;
//
//    PriceRange(String range) {
//        this.range = range;
//    }

    PriceRange(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
