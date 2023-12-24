package com.example.workoutwizardgateway.controller;

import com.example.workoutclient.dto.AddWorkoutRequest;
import com.example.workoutclient.dto.WorkoutClient;
import com.example.workoutclient.dto.WorkoutDiary;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/workout")
public class WorkoutController {

    @Autowired
    private WorkoutClient workoutClient;

    @GetMapping("diary/active")
    public WorkoutDiary getActiveDiary(@RequestHeader("Authorization") String jwtToken) {
        return workoutClient.getActiveDiary(jwtToken);
    }

    @PostMapping
    public UUID addWorkout(@RequestBody AddWorkoutRequest workout, @RequestHeader("Authorization") String jwtToken) throws JsonProcessingException {
        return workoutClient.addWorkout(workout, jwtToken);
    }
}
