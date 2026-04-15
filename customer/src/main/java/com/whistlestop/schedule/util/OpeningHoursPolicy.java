package com.whistlestop.schedule.util;

import com.whistlestop.common.constant.BusinessConstants;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public final class OpeningHoursPolicy {
    private OpeningHoursPolicy() {
    }

    public static boolean isOpenOn(LocalDate date) {
        return date.getDayOfWeek() != DayOfWeek.SUNDAY;
    }

    public static LocalTime openingTime(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.SATURDAY
                ? BusinessConstants.SATURDAY_OPEN
                : BusinessConstants.WEEKDAY_OPEN;
    }

    public static LocalTime closingTime(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.SATURDAY
                ? BusinessConstants.SATURDAY_CLOSE
                : BusinessConstants.WEEKDAY_CLOSE;
    }

    public static boolean isWithinOpeningHours(LocalDateTime dateTime) {
        LocalDate date = dateTime.toLocalDate();
        if (!isOpenOn(date)) {
            return false;
        }

        LocalTime time = dateTime.toLocalTime();
        return !time.isBefore(openingTime(date)) && !time.isAfter(closingTime(date));
    }
}
