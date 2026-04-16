package com.whistlestop.schedule.controller;

import com.whistlestop.common.api.ApiResponse;
import com.whistlestop.common.exception.BusinessException;
import com.whistlestop.schedule.service.ScheduleService;
import io.javalin.Javalin;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/*
 Controller for customer schedule endpoints.

 Handles requests for available pickup times based on the
 kiosk opening rules.
*/
public final class ScheduleController {
    private ScheduleController() {
    }

    /*
     Registers schedule-related routes.
    */
    public static void register(Javalin app, ScheduleService scheduleService) {
        app.get("/api/schedule/available-times", ctx -> {

            // Read the requested date from the query string
            String dateParam = ctx.queryParam("date");

            // Stop the request if the frontend does not provide a date
            if (dateParam == null || dateParam.isBlank()) {
                throw new BusinessException(400, "Query parameter 'date' is required, format: yyyy-MM-dd.");
            }

            try {
                // Convert the supplied date text into a LocalDate
                LocalDate date = LocalDate.parse(dateParam);

                // Return the list of available pickup times for that date
                ctx.json(ApiResponse.success("Available times fetched successfully", scheduleService.getAvailableTimes(date)));
            } catch (DateTimeParseException e) {
                // Reject invalid date formats to avoid bad schedule checks
                throw new BusinessException(400, "Invalid date format. Use yyyy-MM-dd.");
            }
        });
    }
}
