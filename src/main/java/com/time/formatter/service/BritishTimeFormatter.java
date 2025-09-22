package com.time.formatter.service;

import com.time.formatter.util.NumberToWords;

import java.time.LocalTime;

/**
 * British spoken time formatter.
 */
public class BritishTimeFormatter implements TimeFormatter {

    @Override
    public String format(LocalTime time) {
        if (time == null)
        {
            throw new IllegalArgumentException("time must not be null");
        }

        if (time.equals(LocalTime.MIDNIGHT))
        {
            return "midnight";
        }
        if (time.equals(LocalTime.NOON))
        {
            return "noon";
        }

        int h = time.getHour();
        int m = time.getMinute();


        String hourWord = NumberToWords.of(h);

        if (m == 0) {
            return hourWord + " o'clock";
        }

        if (m == 15) return "quarter past " + hourWord;
        if (m == 30) return "half past " + hourWord;
        if (m == 45) {
            int nextHour = h + 1;
            return "quarter to " + NumberToWords.of(nextHour);
        }

        if (m % 5 == 0) {
            if (m < 30) {
                return NumberToWords.of(m) + " past " + hourWord;
            } else {
                int remaining = 60 - m;
                int nextHour = h + 1;
                return NumberToWords.of(remaining) + " to " + NumberToWords.of(nextHour);
            }
        }

        if (m < 10) {
            return hourWord + " oh " + NumberToWords.of(m);
        }

        if (m < 30) {
            return NumberToWords.of(m) + " past " + hourWord;
        }

        if (h == 0) {
            int remaining = 60 - m;
            return NumberToWords.of(remaining) + " to " + NumberToWords.of(1);
        } else {
            String minutePart = NumberToWords.of(m);
            return hourWord + " " + minutePart;
        }
    }
}
