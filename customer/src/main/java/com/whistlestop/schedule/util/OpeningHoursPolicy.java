package com.whistlestop.schedule.util;

import com.whistlestop.common.constant.BusinessConstants;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/*
 Utility class for kiosk opening-hour checks.

 Keeps the day-based opening rules in one place so other
 classes can reuse the same business logic.
*/
public final class OpeningHoursPolicy {
    private OpeningHoursPolicy() {
    }

    /*
     Returns true when the kiosk is open on the given date.
    */
    public static boolean isOpenOn(LocalDate date) {
        return date.getDayOfWeek() != DayOfWeek.SUNDAY;
    }

    /*
     Returns the opening time for the supplied day.
    */
    public static LocalTime openingTime(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.SATURDAY
                ? BusinessConstants.SATURDAY_OPEN
                : BusinessConstants.WEEKDAY_OPEN;
    }

    /*
     Returns the closing time for the supplied day.
    */
    public static LocalTime closingTime(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.SATURDAY
                ? BusinessConstants.SATURDAY_CLOSE
                : BusinessConstants.WEEKDAY_CLOSE;
    }

    /*
     Checks whether a full date and time falls inside kiosk opening hours.
    */
    public static boolean isWithinOpeningHours(LocalDateTime dateTime) {
        LocalDate date = dateTime.toLocalDate();

        // Closed days are immediately rejected
        if (!isOpenOn(date)) {
            return false;
        }

        LocalTime time = dateTime.toLocalTime();

        // Time must fall between the opening and closing boundaries
        return !time.isBefore(openingTime(date)) && !time.isAfter(closingTime(date));
    }
}
