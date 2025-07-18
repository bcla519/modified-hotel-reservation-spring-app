package edu.wgu.d387_sample_code.model;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeZoneTranslation {

    static public LocalDateTime translateToEasternTimeZone(LocalDateTime localDateTime, ZoneId zoneId) {
        ZoneId zEasternTimeZone = ZoneId.of("America/New_York");
        ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
        ZonedDateTime zonedDateTimeEastern = zonedDateTime.withZoneSameInstant(zEasternTimeZone);

        return zonedDateTimeEastern.toLocalDateTime();
    }

    static public LocalDateTime translateToMountainTimeZone(LocalDateTime localDateTime, ZoneId zoneId) {
        ZoneId zMountainTimeZone = ZoneId.of("America/Denver");
        ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
        ZonedDateTime zonedDateTimeMountain = zonedDateTime.withZoneSameInstant(zMountainTimeZone);

        return zonedDateTimeMountain.toLocalDateTime();
    }

    static public LocalDateTime translateToUTC(LocalDateTime localDateTime, ZoneId zoneId) {
        ZoneId zUTC = ZoneId.of("UTC");
        ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
        ZonedDateTime zonedDateTimeUTC = zonedDateTime.withZoneSameInstant(zUTC);

        return zonedDateTimeUTC.toLocalDateTime();
    }
}
