package com.whistlestop.menu.dto;

/*
 Response object used for quick-pick menu items.

 Reuses the normal menu item fields because the frontend
 still needs the same details for display.
*/
public class QuickPickResponse extends MenuItemResponse {

    /*
     Empty constructor used by JSON mapping.
    */
    public QuickPickResponse() {
    }

    /*
     Creates a quick-pick response using the same values as a menu item.
    */
    public QuickPickResponse(long id, String name, String category, double regularPrice, double largePrice, boolean available) {
        super(id, name, category, regularPrice, largePrice, available);
    }
}
