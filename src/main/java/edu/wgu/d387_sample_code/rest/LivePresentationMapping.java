package edu.wgu.d387_sample_code.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import static edu.wgu.d387_sample_code.model.TimeZoneTranslation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class LivePresentationMapping {
    @RequestMapping(path = "/livePresentation", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String livePresentation() {
        String livePresentationMessage = "Join us for our live presentation on ";

        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime livePresentationDateTime = LocalDateTime.of(2024,9,7,18,0);

        LocalDateTime livePresentationEasternTime = translateToEasternTimeZone(livePresentationDateTime, zoneId);
        LocalDateTime livePresentationMountainTime = translateToMountainTimeZone(livePresentationDateTime, zoneId);
        LocalDateTime livePresentationUTC = translateToUTC(livePresentationDateTime, zoneId);

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("EEE, MMMM d");

        livePresentationMessage += livePresentationDateTime.format(dateFormatter) + " at ";

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("h:mm a");

        livePresentationMessage += livePresentationEasternTime.format(timeFormatter) + " ET";
        livePresentationMessage += " | " + livePresentationMountainTime.format(timeFormatter) + " MT";
        livePresentationMessage += " | " + livePresentationUTC.format(timeFormatter) + " UTC";

        return livePresentationMessage;
    }
}
