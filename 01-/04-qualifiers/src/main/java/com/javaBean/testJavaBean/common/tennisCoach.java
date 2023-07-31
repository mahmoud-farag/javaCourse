package com.javaBean.testJavaBean.common;

import org.springframework.stereotype.Component;

@Component
public class tennisCoach implements  Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice daily workout for tennisCoach!!:)";
    }
}
