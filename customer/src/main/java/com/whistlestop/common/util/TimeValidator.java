package com.whistlestop.common.util;

import com.whistlestop.common.exception.BusinessException;
import com.whistlestop.schedule.util.OpeningHoursPolicy;

import java.time.LocalDateTime;

public final class TimeValidator {
    private TimeValidator() {
    }

    public static void validatePickupDateTime(LocalDateTime pickupDateTime) {
        if (pickupDateTime == null) {
            throw new BusinessException(400, "Pickup time is required.");
        }

        if (!OpeningHoursPolicy.isWithinOpeningHours(pickupDateTime)) {
            throw new BusinessException(400, "Selected pickup time is outside opening hours.");
        }
    }
}
