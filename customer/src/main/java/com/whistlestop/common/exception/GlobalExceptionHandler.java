package com.whistlestop.common.exception;

import com.whistlestop.common.api.ApiResponse;
import io.javalin.Javalin;

/*
 Registers application-wide exception handling.

 Converts thrown exceptions into clean JSON responses
 so the frontend receives a consistent result.
*/
public final class GlobalExceptionHandler {
    private GlobalExceptionHandler() {
    }

    /*
     Registers handlers for both business and unexpected errors.
    */
    public static void register(Javalin app) {

        // Handle known business-rule errors and return the stored status code
        app.exception(BusinessException.class, (e, ctx) -> {
            ctx.status(e.getStatusCode());
            ctx.json(ApiResponse.fail(e.getMessage(), null));
        });

        // Catch unexpected errors and avoid exposing internal details
        app.exception(Exception.class, (e, ctx) -> {
            ctx.status(500);
            ctx.json(ApiResponse.fail("Internal server error", null));
        });
    }
}
