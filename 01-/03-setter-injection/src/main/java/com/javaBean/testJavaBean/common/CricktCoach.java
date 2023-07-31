package com.javaBean.testJavaBean.common;


import org.springframework.stereotype.Component;

//this annotation annotate the class as a java bean(means that we can use it as a dependency injection)


@Component
public class CricktCoach implements Coach {


    @Override
    public String getDailyWorkout() {
        return "Practice daily workout for CricktCoach!!:)";
    }
}
