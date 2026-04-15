package com.whistlestop.schedule.controller;

import com.whistlestop.common.api.ApiResponse;
import com.whistlestop.common.exception.BusinessException;
import com.whistlestop.schedule.service.ScheduleService;
import io.javalin.Javalin;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public final class ScheduleController {
    private ScheduleController() {
    }

    public static void register(Javalin app, ScheduleService scheduleService) {
        app.get("/api/schedule/available-times", ctx -> {
            String dateParam = ctx.queryParam("date");
            if (dateParam == null || dateParam.isBlank()) {
                throw new BusinessException(400, "Query parameter 'date' is required, format: yyyy-MM-dd.");
            }

            try {
                LocalDate date = LocalDate.parse(dateParam);
                ctx.json(ApiResponse.success("Available times fetched successfully", scheduleService.getAvailableTimes(date)));
            } catch (DateTimeParseException e) {
                throw new BusinessException(400, "Invalid date format. Use yyyy-MM-dd.");
            }
        });
    }
}
