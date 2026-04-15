package com.whistlestop.menu.dto;

public class QuickPickResponse extends MenuItemResponse {
    public QuickPickResponse() {
    }

    public QuickPickResponse(long id, String name, String category, double regularPrice, double largePrice, boolean available) {
        super(id, name, category, regularPrice, largePrice, available);
    }
}
