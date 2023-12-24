package com.example.workoutwizardgateway.configuration;

import com.example.routineclient.RoutineClient;
import com.example.workoutclient.dto.InsightsClient;
import com.example.workoutclient.dto.WorkoutClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public RoutineClient routineClient() {
        return new RoutineClient("http://localhost:8081");
    }

    @Bean
    public WorkoutClient workoutClient() {
        return new WorkoutClient("http://localhost:8080");
    }

    @Bean
    public InsightsClient insightsClient() {
        return new InsightsClient("http://localhost:8080");
    }
}
