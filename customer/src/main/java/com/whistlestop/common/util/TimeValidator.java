package com.whistlestop.common.util;

import com.whistlestop.common.exception.BusinessException;
import com.whistlestop.schedule.util.OpeningHoursPolicy;

import java.time.LocalDateTime;

/*
 Helper class used to validate requested pickup times.

 Makes sure the value exists and matches kiosk opening rules.
*/
public final class TimeValidator {
    private TimeValidator() {
    }

    /*
     Validates a pickup date and time before an order is accepted.
    */
    public static void validatePickupDateTime(LocalDateTime pickupDateTime) {

        // Stop the request if no pickup time was supplied
        if (pickupDateTime == null) {
            throw new BusinessException(400, "Pickup time is required.");
        }

        // Reject pickup times outside the kiosk opening hours
        if (!OpeningHoursPolicy.isWithinOpeningHours(pickupDateTime)) {
            throw new BusinessException(400, "Selected pickup time is outside opening hours.");
        }
    }
}
