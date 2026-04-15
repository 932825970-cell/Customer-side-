package com.whistlestop.menu.service;

import com.whistlestop.menu.dto.MenuItemResponse;
import com.whistlestop.menu.dto.QuickPickResponse;
import com.whistlestop.menu.entity.MenuItem;
import com.whistlestop.menu.repository.MenuRepository;

import java.util.List;

public class MenuService {
    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public List<MenuItemResponse> getAllMenuItems() {
        return menuRepository.findAll().stream()
                .map(this::toMenuItemResponse)
                .toList();
    }

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
