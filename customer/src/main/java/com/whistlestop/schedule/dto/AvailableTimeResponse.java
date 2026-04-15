package com.whistlestop.schedule.dto;

import java.time.LocalDate;
import java.util.List;

public class AvailableTimeResponse {
    private LocalDate date;
    private List<String> availableTimes;

    public AvailableTimeResponse() {
    }

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
