package com.whistlestop;

import com.whistlestop.common.exception.GlobalExceptionHandler;
import com.whistlestop.menu.controller.MenuController;
import com.whistlestop.menu.repository.MenuRepository;
import com.whistlestop.menu.service.MenuService;
import com.whistlestop.schedule.controller.ScheduleController;
import com.whistlestop.schedule.service.ScheduleService;
import io.javalin.Javalin;
import io.javalin.json.JavalinJackson;

public class App {
    public static void main(String[] args) {
        int port = 7000;

        Javalin app = Javalin.create(config -> {
            config.showJavalinBanner = false;
            config.bundledPlugins.enableCors(cors -> cors.addRule(it -> it.anyHost()));
            config.jsonMapper(new JavalinJackson());
        });

        GlobalExceptionHandler.register(app);

        MenuRepository menuRepository = new MenuRepository();
        MenuService menuService = new MenuService(menuRepository);
        ScheduleService scheduleService = new ScheduleService();

        app.get("/api/health", ctx -> ctx.json(java.util.Map.of("status", "ok")));
        MenuController.register(app, menuService);
        ScheduleController.register(app, scheduleService);

        app.start(port);
    }
}
