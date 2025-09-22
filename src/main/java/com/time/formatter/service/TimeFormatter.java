package com.time.formatter.service;

import java.time.LocalTime;

/**
 * Interface for formatting LocalTime into spoken form.
 */
public interface TimeFormatter {
    /**
     * Convert a LocalTime to a spoken form string.
     * @param time non-null LocalTime
     * @return spoken form
     */
    String format(LocalTime time);
}
