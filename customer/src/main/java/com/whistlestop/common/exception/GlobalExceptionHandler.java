package com.whistlestop.common.exception;

import com.whistlestop.common.api.ApiResponse;
import io.javalin.Javalin;

public final class GlobalExceptionHandler {
    private GlobalExceptionHandler() {
    }

    public static void register(Javalin app) {
        app.exception(BusinessException.class, (e, ctx) -> {
            ctx.status(e.getStatusCode());
            ctx.json(ApiResponse.fail(e.getMessage(), null));
        });

        app.exception(Exception.class, (e, ctx) -> {
            ctx.status(500);
            ctx.json(ApiResponse.fail("Internal server error", null));
        });
    }
}
