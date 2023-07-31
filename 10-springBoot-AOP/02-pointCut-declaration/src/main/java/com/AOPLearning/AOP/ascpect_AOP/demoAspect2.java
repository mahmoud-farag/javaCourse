package com.AOPLearning.AOP.ascpect_AOP;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class demoAspect2 {

    @Before("com.AOPLearning.AOP.ascpect_AOP.pointCuts.DoAnalyticsStuff()")
    public void doAnalyticsStuff() {
        System.out.println("=====>>>>>> doAnalyticsStuff works now <<<<<<<<========");
    }
}
