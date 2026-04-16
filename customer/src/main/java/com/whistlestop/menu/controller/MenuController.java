package com.whistlestop.menu.controller;

import com.whistlestop.common.api.ApiResponse;
import com.whistlestop.menu.service.MenuService;
import io.javalin.Javalin;

/*
 Controller for menu-related customer endpoints.

 Handles requests for the full menu and the quick-pick section.
*/
public final class MenuController {
    private MenuController() {
    }

    /*
     Registers all menu routes used by the customer frontend.
    */
    public static void register(Javalin app, MenuService menuService) {

        // Return the full list of menu items
        app.get("/api/menu", ctx -> ctx.json(ApiResponse.success(
                "Menu fetched successfully", menuService.getAllMenuItems())));

        // Return the smaller list of highlighted quick-pick items
        app.get("/api/menu/quick-picks", ctx -> ctx.json(ApiResponse.success(
                "Quick picks fetched successfully", menuService.getQuickPicks())));
    }
}
