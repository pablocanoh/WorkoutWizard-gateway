package com.example.workoutwizardgateway.controller;

import com.example.workoutclient.dto.InsightsClient;
import com.example.workoutclient.dto.InsightsDataPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/insights")
public class InsightsController {

    @Autowired
    private InsightsClient insightsClient;

    @GetMapping
    public List<InsightsDataPoint> getInsights(@RequestHeader("Authorization") String jwtToken) {
        return insightsClient.getInsights(jwtToken);
    }
}
