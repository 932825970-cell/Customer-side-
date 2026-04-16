package com.whistlestop.menu.repository;

import com.whistlestop.menu.entity.MenuItem;

import java.util.List;
import java.util.stream.Collectors;

/*
 Repository used to supply menu data.

 For Part 1 this uses fixed in-memory data so frontend testing
 can start before the database layer is added.
*/
public class MenuRepository {
    private final List<MenuItem> menuItems = List.of(
            new MenuItem(1L, "Americano", "Coffee", 1.50, 2.00, true, true),
            new MenuItem(2L, "Latte", "Coffee", 2.20, 2.80, true, true),
            new MenuItem(3L, "Cappuccino", "Coffee", 2.20, 2.80, true, true),
            new MenuItem(4L, "Flat White", "Coffee", 2.30, 2.90, false, true),
            new MenuItem(5L, "Mineral Water", "Cold Drinks", 1.20, 1.20, false, true)
    );

    /*
     Returns every menu item shown to the customer.
    */
    public List<MenuItem> findAll() {
        return menuItems;
    }

    /*
     Returns only the items marked for quick-pick display.
    */
    public List<MenuItem> findQuickPicks() {
        return menuItems.stream()
                .filter(MenuItem::isQuickPick)
                .collect(Collectors.toList());
    }
}
