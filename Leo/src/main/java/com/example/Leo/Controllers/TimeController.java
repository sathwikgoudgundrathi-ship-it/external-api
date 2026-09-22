package com.example.Leo.Controllers;

import java.time.DateTimeException;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Provides the current server time in a requested time zone.
 */
@RestController
@RequestMapping("/api/time")
@CrossOrigin(origins = "http://localhost:3000")
public class TimeController {

    /**
     * Example: GET /api/time?zone=Asia/Kolkata
     *
     * @param zone IANA time-zone identifier; defaults to UTC.
     * @return the current time and related details as JSON.
     */
    @GetMapping
    public ResponseEntity<Map<String, String>> getCurrentTime(
            @RequestParam(defaultValue = "UTC") String zone) {
        try {
            String sanitizedZone = (zone != null) ? zone.trim() : "UTC";
            ZonedDateTime now = ZonedDateTime.now(ZoneId.of(sanitizedZone));

            Map<String, String> response = new LinkedHashMap<>();
            response.put("dateTime", now.toString());
            response.put("date", now.toLocalDate().toString());
            response.put("time", now.toLocalTime().toString());
            response.put("zone", now.getZone().getId());
            response.put("offset", now.getOffset().toString());

            return ResponseEntity.ok(response);
        } catch (DateTimeException exception) {
            Map<String, String> response = Map.of(
                    "error", "Invalid time zone: " + zone,
                    "hint", "Use an IANA zone such as Asia/Kolkata or Europe/London.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}
