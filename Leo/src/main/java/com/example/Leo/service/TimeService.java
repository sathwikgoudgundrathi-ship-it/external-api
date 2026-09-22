package com.example.Leo.service;

import java.time.LocalTime;
import org.springframework.stereotype.Service;

@Service
public class TimeService {
    public String getTime() {
        return "Current time is: " + LocalTime.now();
    }
}

