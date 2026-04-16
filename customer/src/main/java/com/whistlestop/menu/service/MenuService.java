package com.whistlestop.menu.service;

import com.whistlestop.menu.dto.MenuItemResponse;
import com.whistlestop.menu.dto.QuickPickResponse;
import com.whistlestop.menu.entity.MenuItem;
import com.whistlestop.menu.repository.MenuRepository;

import java.util.List;

/*
 Service class for menu-related business logic.

 Converts internal menu data into response objects used
 by the customer frontend.
*/
public class MenuService {
    private final MenuRepository menuRepository;

    /*
     Repository is passed in so menu data can be retrieved separately
     from the service logic.
    */
    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    /*
     Returns the full menu in response format.
    */
    public List<MenuItemResponse> getAllMenuItems() {
        return menuRepository.findAll().stream()
                .map(this::toMenuItemResponse)
                .toList();
    }

    /*
     Returns quick-pick menu items in response format.
    */
    public List<QuickPickResponse> getQuickPicks() {
        return menuRepository.findQuickPicks().stream()
                .map(item -> new QuickPickResponse(
                        item.getId(),
                        item.getName(),
                        item.getCategory(),
                        item.getRegularPrice(),
                        item.getLargePrice(),
                        item.isAvailable()))
                .toList();
    }

    /*
     Converts an internal menu item into the response object
     expected by the customer frontend.
    */
    private MenuItemResponse toMenuItemResponse(MenuItem item) {
        return new MenuItemResponse(
                item.getId(),
                item.getName(),
                item.getCategory(),
                item.getRegularPrice(),
                item.getLargePrice(),
                item.isAvailable());
    }
}
