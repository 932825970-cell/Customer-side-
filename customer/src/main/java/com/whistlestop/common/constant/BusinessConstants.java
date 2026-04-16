package com.whistlestop.common.constant;

import java.time.LocalTime;

/*
 Business rules shared across the customer backend.

 Stores fixed opening hours and slot settings so schedule logic
 uses one consistent source of truth.
*/
public final class BusinessConstants {
    public static final LocalTime WEEKDAY_OPEN = LocalTime.of(6, 30);
    public static final LocalTime WEEKDAY_CLOSE = LocalTime.of(19, 0);
    public static final LocalTime SATURDAY_OPEN = LocalTime.of(7, 0);
    public static final LocalTime SATURDAY_CLOSE = LocalTime.of(18, 0);
    public static final int SLOT_INTERVAL_MINUTES = 15;
    public static final int MIN_PREP_BUFFER_MINUTES = 15;

    private BusinessConstants() {
    }
}
