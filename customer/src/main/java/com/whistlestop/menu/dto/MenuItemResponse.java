package com.whistlestop.menu.dto;

/*
 Response object returned to the frontend for menu items.

 Contains the fields the customer app needs to display
 item name, category, prices, and availability.
*/
public class MenuItemResponse {
    private long id;
    private String name;
    private String category;
    private double regularPrice;
    private double largePrice;
    private boolean available;

    /*
     Empty constructor used by JSON mapping.
    */
    public MenuItemResponse() {
    }

    /*
     Creates a menu response object with the supplied item values.
    */
    public MenuItemResponse(long id, String name, String category, double regularPrice, double largePrice, boolean available) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.regularPrice = regularPrice;
        this.largePrice = largePrice;
        this.available = available;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getRegularPrice() {
        return regularPrice;
    }

    public void setRegularPrice(double regularPrice) {
        this.regularPrice = regularPrice;
    }

    public double getLargePrice() {
        return largePrice;
    }

    public void setLargePrice(double largePrice) {
        this.largePrice = largePrice;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
