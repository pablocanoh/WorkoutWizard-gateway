package com.example.workoutwizardgateway.configuration;

import com.example.routineclient.RoutineClient;
import com.example.workoutclient.dto.InsightsClient;
import com.example.workoutclient.dto.WorkoutClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public RoutineClient routineClient(@Value("${routine-service.url}") String routineServiceUrl) {
        return new RoutineClient(routineServiceUrl);
    }

    @Bean
    public WorkoutClient workoutClient(@Value("${workout-service.url}") String workoutServiceUrl) {
        return new WorkoutClient(workoutServiceUrl);
    }

    @Bean
    public InsightsClient insightsClient(@Value("${insights-service.url}") String insightsServiceUrl) {
        return new InsightsClient(insightsServiceUrl);
    }
}
