package com.time.formatter;

import com.time.formatter.service.BritishTimeFormatter;
import com.time.formatter.service.TimeFormatter;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BritishTimeFormatterTest {
    private final TimeFormatter fmt = new BritishTimeFormatter();

    @Test
    void sampleCases() {
        assertEquals("one o'clock", fmt.format(LocalTime.of(1,0)));
        assertEquals("five past two", fmt.format(LocalTime.of(2,5)));
        assertEquals("ten past three", fmt.format(LocalTime.of(3,10)));
        assertEquals("quarter past four", fmt.format(LocalTime.of(4,15)));
        assertEquals("twenty past five", fmt.format(LocalTime.of(5,20)));
        assertEquals("twenty-five past six", fmt.format(LocalTime.of(6,25)));
        assertEquals("six thirty-two", fmt.format(LocalTime.of(6,32)));
        assertEquals("half past seven", fmt.format(LocalTime.of(7,30)));
        assertEquals("twenty-five to eight", fmt.format(LocalTime.of(7,35)));
        assertEquals("twenty to nine", fmt.format(LocalTime.of(8,40)));
        assertEquals("quarter to ten", fmt.format(LocalTime.of(9,45)));
        assertEquals("ten to eleven", fmt.format(LocalTime.of(10,50)));
        assertEquals("five to twelve", fmt.format(LocalTime.of(11,55)));
        assertEquals("midnight", fmt.format(LocalTime.of(0,0)));
        assertEquals("noon", fmt.format(LocalTime.of(12,0)));
    }

    @Test
    void edgeCases() {
        assertEquals("eleven fifty-nine", fmt.format(LocalTime.of(11,59)));
        assertEquals("eleven oh one", fmt.format(LocalTime.of(11,1)));
        assertEquals("twelve oh two", fmt.format(LocalTime.of(12,2)));
        assertEquals("twenty-nine past twelve", fmt.format(LocalTime.of(12,29)));
        assertEquals("one to one", fmt.format(LocalTime.of(0,59)));
    }
}
