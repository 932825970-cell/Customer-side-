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

/*
 Service class for pickup-time business logic.

 Uses kiosk opening rules to build the list of valid
 collection slots shown to the customer.
*/
public class ScheduleService {
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    /*
     Returns valid pickup times for the supplied date.

     Closed days return an empty list, while open days return
     15-minute slots that are still available.
    */
    public AvailableTimeResponse getAvailableTimes(LocalDate date) {

        // Reject requests that do not include a date value
        if (date == null) {
            throw new BusinessException(400, "Query parameter 'date' is required, format: yyyy-MM-dd.");
        }

        // Return no slots if the kiosk is closed on that date
        if (!OpeningHoursPolicy.isOpenOn(date)) {
            return new AvailableTimeResponse(date, List.of());
        }

        LocalTime start = OpeningHoursPolicy.openingTime(date);
        LocalTime end = OpeningHoursPolicy.closingTime(date);
        List<String> slots = new ArrayList<>();

        // Prevent customers from selecting a time that is too soon
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime earliestAllowed = now.plusMinutes(BusinessConstants.MIN_PREP_BUFFER_MINUTES);

        // Build time slots in 15-minute steps across the opening window
        for (LocalTime current = start; !current.isAfter(end); current = current.plusMinutes(BusinessConstants.SLOT_INTERVAL_MINUTES)) {
            LocalDateTime candidate = LocalDateTime.of(date, current);

            // Only return slots that are still available after the prep buffer
            if (candidate.isAfter(earliestAllowed)) {
                slots.add(current.format(TIME_FORMATTER));
            }
        }

        return new AvailableTimeResponse(date, slots);
    }
}
