package ua.goit.user.info.time;

import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TimezoneService {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Get the local UTC shift as an integer.
     * Returns the UTC shift value in hours for the system time zone.
     *
     * @return the current UTC offset in hours (e.g., 2 for UTC+2)
     */
    public static int getLocalUTCOffset() {

        // Get the current time in the system's default time zone
        ZonedDateTime now = ZonedDateTime.now(ZoneId.systemDefault());

        // Calculate the UTC offset in hours
        ZoneOffset offset = now.getOffset();
        return offset.getTotalSeconds() / 3600;
    }

    /**
     * Get the current time in the format yyyy-MM-dd HH:mm:ss by the given UTC offset.
     * If null is passed, the local UTC offset of the system is used.
     *
     * @param utcOffset UTC shift in hours (e.g. 2 for UTC+2)
     * @return current time in the format yyyy-MM-dd HH:mm:ss
     */
    public static String getTimeByUTCOffset(Integer utcOffset) {

        // If utcOffset is null, use the local UTC offset
        if (utcOffset == null) {
            utcOffset = getLocalUTCOffset();
        }

        // Return formatted time with the provided or default UTC offset
        return formatTimeWithOffset(ZoneOffset.ofHours(utcOffset));
    }

    /**
     * Get the current time in yyyy-MM-dd HH:mm:ss format by UTC string value.
     * String format: “UTC+n” or “UTC-n” (e.g., “UTC+2” or “UTC-5”).
     * If an empty string or null is passed, the system's local UTC shift is used.
     *
     * @param timezone a string describing UTC (e.g., “UTC+2” or “UTC-5”)
     * @return current time in the format yyyy-MM-dd HH:mm:ss
     */
    public static String getTimeByUTCOffset(String timezone) {
        int utcOffset;

        // If timezone is null or empty, use the system's local UTC shift
        if (timezone == null || timezone.isEmpty()) {
            utcOffset = getLocalUTCOffset();
            return formatTimeWithOffset(ZoneOffset.ofHours(utcOffset));
        }

        // Parse timezone string, expecting formats like "UTC+n" or "UTC-n"
        if (timezone.startsWith("UTC+")) {
            utcOffset = Integer.parseInt(timezone.substring(4));
        } else if (timezone.startsWith("UTC-")) {
            utcOffset = Integer.parseInt(timezone.substring(4)) * -1;
        } else if (timezone.startsWith("UTC")) {
            utcOffset = Integer.parseInt(timezone.substring(3));
        } else {

            // Default to UTC if string doesn't match expected patterns
            return formatTimeWithOffset(ZoneOffset.UTC);
        }

        // Return formatted time with the specified UTC offset
        return formatTimeWithOffset(ZoneOffset.ofHours(utcOffset));
    }

    public static String getTimeByUTCOffset() {
        int utcOffset = getLocalUTCOffset();
        return formatTimeWithOffset(ZoneOffset.ofHours(utcOffset));
    }

    /**
     * Formats the current time using the specified ZoneOffset.
     *
     * @param offset the time shift as a ZoneOffset
     * @return current time in the format yyyy-MM-dd HH:mm:ss
     */
    private static String formatTimeWithOffset(ZoneOffset offset) {
        return ZonedDateTime.now(offset).format(FORMATTER);
    }
}




