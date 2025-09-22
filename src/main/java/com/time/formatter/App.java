package com.time.formatter;

import com.time.formatter.service.BritishTimeFormatter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;

/**
 * Accepts time strings in pattern H:mm or HH:mm.
 */
public final class App {
    private static final DateTimeFormatter PARSER = DateTimeFormatter.ofPattern("H:mm", Locale.ENGLISH);

    public static void main(String[] args) {
        BritishTimeFormatter formatter = new BritishTimeFormatter();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter time in this format (H:mm) Or Space to exit");
            String line = sc.nextLine();
            if (line == null || line.trim().isEmpty())
                break;
            try
            {
                LocalTime t = LocalTime.parse(line.trim(), PARSER);
                System.out.println(formatter.format(t));
            }
            catch (DateTimeParseException e)
            {
                System.out.println("Invalid time format. Use H:mm (e.g. 7:30 or 19:05)");
            }
        }
    }
}
