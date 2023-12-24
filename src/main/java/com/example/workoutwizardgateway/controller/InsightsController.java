package com.example.workoutwizardgateway.controller;

import com.example.workoutclient.dto.InsightsClient;
import com.example.workoutclient.dto.InsightsDataPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/insights")
public class InsightsController {

    @Autowired
    private InsightsClient insightsClient;

    @GetMapping
    public List<InsightsDataPoint> getInsights() {
        return insightsClient.getInsights();
    }
}
