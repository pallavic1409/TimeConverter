package com.time.formatter.util;

/**
 * Convert numbers to English words used for time.00
 */
public final class NumberToWords {
    private static final String[] BELOW_20 = {
        "zero","one","two","three","four","five","six","seven","eight","nine","ten",
        "eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"
    };

    private NumberToWords() { }

    public static String of(int n) {
        if (n < 0 || n >= 60) throw new IllegalArgumentException("number out of range: " + n);
        if (n < 20) return BELOW_20[n];
        int tens = (n / 10) * 10;
        int ones = n % 10;
        String tensWord;
        switch (tens) {
            case 20: tensWord = "twenty"; break;
            case 30: tensWord = "thirty"; break;
            case 40: tensWord = "forty"; break;
            case 50: tensWord = "fifty"; break;
            default: throw new IllegalArgumentException("unsupported tens: " + tens);
        }
        return ones == 0 ? tensWord : tensWord + "-" + BELOW_20[ones];
    }
}
