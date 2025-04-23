package com.pluralsight;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.math.BigDecimal;

public class APP {
    public static void main(String[] args) {
        // Get current date and time (local system clock)
        LocalDateTime now = LocalDateTime.now();

        // Call each formatting method
        dateFormat1(now);  // Format: MM-dd-yyyy
        dateFormat2(now);  // Format: yyyy/MM/dd
        System.out.println(getFormat3(now));  // Format: MMMM dd, yyyy (returned as String)
        dateFormat4(now);  // Format: full day name, MMM d, yyyy
        dateFormat5(now);  // Format: hh:mm with GMT label (not converted to GMT)
        dateFormat6(now);  // Format: H:mm on dd MMM yyyy
        dateFormat7(now);  // Format: includes time zone and BigDecimal
    }

    // Format 1: MM-dd-yyyy (e.g. 04-23-2025)
    static void dateFormat1(LocalDateTime now) {
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        System.out.println(now.format(format1));
    }

    // Format 2: yyyy/MM/dd (e.g. 2025/04/23)
    static void dateFormat2(LocalDateTime now) {
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        System.out.println(now.format(format2));
    }

    // Format 3: Returns a formatted string (e.g. April 23, 2025)
    static String getFormat3(LocalDateTime now) {
        DateTimeFormatter format3 = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        return format3.format(now);
    }

    // Format 4: EEEE (day of the week), MMM (month), d (day), yyyy
    static void dateFormat4(LocalDateTime time) {
        DateTimeFormatter format4 = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy");
        System.out.println(time.format(format4));
    }

    // Format 5: hh:mm (12-hour time) + note (still local time, not true GMT)
    static void dateFormat5(LocalDateTime now) {
        DateTimeFormatter format5 = DateTimeFormatter.ofPattern("hh:mm");
        System.out.println(format5.format(now) + " \u00DF display in GMT time");
    }

    // Format 6: H:mm on dd MMM yyyy (24-hour clock + readable format)
    static void dateFormat6(LocalDateTime now) {
        DateTimeFormatter format6 = DateTimeFormatter.ofPattern("H:mm 'on' dd MMM yyyy");
        System.out.println(format6.format(now) + " \u00DF display in your local time zone");
    }

    // Uses ZoneId to get ZonedDateTime and BigDecimal for numeric time representation
    static void dateFormat7(LocalDateTime now) {
        ZonedDateTime zonedDateTime = now.atZone(ZoneId.systemDefault());
        DateTimeFormatter format7 = DateTimeFormatter.ofPattern("H:mm 'on' dd-MMM-yyyy");
        String formatted = zonedDateTime.format(format7);
        System.out.println("Formatted local time with ZoneId: " + formatted);

    }
}
