package com.example.Leo.Controllers;

import com.example.Leo.service.WheatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class WheatherController {

    @Autowired
    private WheatherService ws;

    @GetMapping("/getweather/{city}")
    public String getWeather(@PathVariable String city) {
        return this.ws.getWeather(city);
    }
}

