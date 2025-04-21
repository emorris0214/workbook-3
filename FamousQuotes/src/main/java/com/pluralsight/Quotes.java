package com.pluralsight;

public class Quotes {
    private int id;
    private String quote;

    public Quotes(int id, String quote) {
        this.id = id;
        this.quote = quote;
    }

    public String getQuote() {
        return quote;
    }

    public int getId() {
        return id;
    }
}

