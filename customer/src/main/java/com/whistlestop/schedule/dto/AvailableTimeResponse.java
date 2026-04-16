package com.whistlestop.schedule.dto;

import java.time.LocalDate;
import java.util.List;

/*
 Response object returned for pickup-time requests.

 Stores the requested date together with all valid collection
 times that can be shown to the customer.
*/
public class AvailableTimeResponse {
    private LocalDate date;
    private List<String> availableTimes;

    /*
     Empty constructor used by JSON mapping.
    */
    public AvailableTimeResponse() {
    }

    /*
     Creates the schedule response with a date and time list.
    */
    public AvailableTimeResponse(LocalDate date, List<String> availableTimes) {
        this.date = date;
        this.availableTimes = availableTimes;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<String> getAvailableTimes() {
        return availableTimes;
    }

    public void setAvailableTimes(List<String> availableTimes) {
        this.availableTimes = availableTimes;
    }
}
