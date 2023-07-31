package com.AOPLearning.AOP.ascpect_AOP;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class demoAspect1 {

    @Before("com.AOPLearning.AOP.ascpect_AOP.pointCuts.beforeAddMethods()")
    public void beforeAddMethodsHandler(JoinPoint theJoinPoint) {
        //JoinPoint used to access the method args and other important stuff.
        System.out.println("=====>>>>>> beforeAddMethodsHandler works now <<<<<<<<========");

        // show method signature
        MethodSignature signature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println(signature);

        // print out the args

        Object[] args = theJoinPoint.getArgs();

        for (Object arg : args) {
            System.out.println("the argument: " + arg);
        }
    }
}
