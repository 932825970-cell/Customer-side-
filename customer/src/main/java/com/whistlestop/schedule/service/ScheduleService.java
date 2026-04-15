package com.whistlestop.schedule.service;

import com.whistlestop.common.constant.BusinessConstants;
import com.whistlestop.common.exception.BusinessException;
import com.whistlestop.schedule.dto.AvailableTimeResponse;
import com.whistlestop.schedule.util.OpeningHoursPolicy;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ScheduleService {
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    public AvailableTimeResponse getAvailableTimes(LocalDate date) {
        if (date == null) {
            throw new BusinessException(400, "Query parameter 'date' is required, format: yyyy-MM-dd.");
        }

        if (!OpeningHoursPolicy.isOpenOn(date)) {
            return new AvailableTimeResponse(date, List.of());
        }

        LocalTime start = OpeningHoursPolicy.openingTime(date);
        LocalTime end = OpeningHoursPolicy.closingTime(date);
        List<String> slots = new ArrayList<>();

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime earliestAllowed = now.plusMinutes(BusinessConstants.MIN_PREP_BUFFER_MINUTES);

        for (LocalTime current = start; !current.isAfter(end); current = current.plusMinutes(BusinessConstants.SLOT_INTERVAL_MINUTES)) {
            LocalDateTime candidate = LocalDateTime.of(date, current);
            if (candidate.isAfter(earliestAllowed)) {
                slots.add(current.format(TIME_FORMATTER));
            }
        }

        return new AvailableTimeResponse(date, slots);
    }
}
