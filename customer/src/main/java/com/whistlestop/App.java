package com.whistlestop;

import com.whistlestop.common.exception.GlobalExceptionHandler;
import com.whistlestop.menu.controller.MenuController;
import com.whistlestop.menu.repository.MenuRepository;
import com.whistlestop.menu.service.MenuService;
import com.whistlestop.schedule.controller.ScheduleController;
import com.whistlestop.schedule.service.ScheduleService;
import io.javalin.Javalin;
import io.javalin.json.JavalinJackson;

/*
 Main entry point for the customer backend.

 Creates the Javalin application, registers the required
 customer-side routes, and starts the server.
*/
public class App {

    /*
     Starts the customer backend server.

     Sets up Javalin configuration, registers global exception handling,
     creates service classes, and connects the menu and schedule routes.
    */
    public static void main(String[] args) {

        // Port used for local development
        int port = 7000;

        // Create the Javalin app and enable settings needed for frontend testing
        Javalin app = Javalin.create(config -> {
            config.showJavalinBanner = false;
            config.bundledPlugins.enableCors(cors -> cors.addRule(it -> it.anyHost()));
            config.jsonMapper(new JavalinJackson());
        });

        // Register a shared exception handler for all routes
        GlobalExceptionHandler.register(app);

        // Create repository and service classes used by the customer routes
        MenuRepository menuRepository = new MenuRepository();
        MenuService menuService = new MenuService(menuRepository);
        ScheduleService scheduleService = new ScheduleService();

        // Simple route used to confirm that the backend is running
        app.get("/api/health", ctx -> ctx.json(java.util.Map.of("status", "ok")));

        // Register customer-facing routes
        MenuController.register(app, menuService);
        ScheduleController.register(app, scheduleService);

        // Start the Javalin server
        app.start(port);
    }
}
