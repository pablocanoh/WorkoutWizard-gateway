package com.example.workoutwizardgateway.controller;

import com.example.routineclient.RoutineClient;
import com.example.routineclient.dtos.ExerciseResponse;
import com.example.routineclient.dtos.ExerciseType;
import com.example.routineclient.dtos.ExperienceLevel;
import com.example.routineclient.dtos.Routine;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/routine")
public class RoutineController {

    @Autowired
    private RoutineClient routineClient;

    @GetMapping("/suggest")
    public Routine suggest(@RequestParam ExperienceLevel experienceLevel, @RequestParam int daysPerWeek) {
        return routineClient.suggest(experienceLevel, daysPerWeek);
    }

    @GetMapping("/latest")
    public Optional<Routine> getLatest() {
        return routineClient.getLatest();
    }

    @GetMapping("/exercise")
    public Map<ExerciseType, List<ExerciseResponse>> exercise() {
        return routineClient.getExercise();
    }

    @GetMapping("/{routineId}")
    public Routine get(@PathVariable UUID routineId) {
        return routineClient.getRoutine(routineId);
    }

    @PostMapping
    public UUID create(@RequestBody Routine routine) throws JsonProcessingException {
        return routineClient.create(routine);
    }
}
