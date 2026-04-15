package com.whistlestop.menu.controller;

import com.whistlestop.common.api.ApiResponse;
import com.whistlestop.menu.service.MenuService;
import io.javalin.Javalin;

public final class MenuController {
    private MenuController() {
    }

    public static void register(Javalin app, MenuService menuService) {
        app.get("/api/menu", ctx -> ctx.json(ApiResponse.success("Menu fetched successfully", menuService.getAllMenuItems())));
        app.get("/api/menu/quick-picks", ctx -> ctx.json(ApiResponse.success("Quick picks fetched successfully", menuService.getQuickPicks())));
    }
}
