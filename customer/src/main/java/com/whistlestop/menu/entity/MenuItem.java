package com.whistlestop.menu.entity;

public class MenuItem {
    private long id;
    private String name;
    private String category;
    private double regularPrice;
    private double largePrice;
    private boolean quickPick;
    private boolean available;

    public MenuItem() {
    }

    public MenuItem(long id, String name, String category, double regularPrice, double largePrice, boolean quickPick, boolean available) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.regularPrice = regularPrice;
        this.largePrice = largePrice;
        this.quickPick = quickPick;
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

    public boolean isQuickPick() {
        return quickPick;
    }

    public void setQuickPick(boolean quickPick) {
        this.quickPick = quickPick;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
