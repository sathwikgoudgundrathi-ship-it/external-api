package com.example.Leo.service;

import java.time.LocalTime;
import org.springframework.stereotype.Service;

@Service
public class WheatherService {
    public String getWeather(String city) {
        return "Current weather in " + city + " is: " + LocalTime.now();
    }
}

