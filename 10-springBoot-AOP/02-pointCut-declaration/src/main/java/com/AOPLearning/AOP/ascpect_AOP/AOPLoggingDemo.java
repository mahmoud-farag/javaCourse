package com.AOPLearning.AOP.ascpect_AOP;


import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOPLoggingDemo {
//    // here is an example on how to use it
//    @Before("pointCutReference()") // so this pointCut can be reused multiple times
//    public void doStuff(){
//        System.out.println("Will do stuff here....");
//    }
//
//    @Before("pointCutReference()")
//    public void doStuff2(){
//        System.out.println("Will do stuff2 here....");
//    }


//    // match any method in any class with this exact sgnature
//    @Before("execution(public void addToAccount())")
//    public void doSomeBeforeStuff() {
//        System.out.println("=====>>>>>> HER WE WILL DO SOME BRE WORK STUFF<<<<<<<<========");
//    }

    /* ******************************
        // match any method in any class starting with add
        @Before("execution(public void add*())")
        public void doSomeBeforeStuffv2() {
            System.out.println("=====>>>>>> HER WE WILL DO SOME BRE WORK STUFF<<<<<<<<========");
        }

        // match any method in any class starting with add and return any type
        @Before("execution( * add*())")
        public void doSomeBeforeStuffv3() {
            System.out.println("=====>>>>>> HER WE WILL DO SOME BRE WORK STUFF<<<<<<<<========");
        }

        // match any method in any class starting with add and return any type and have only one parameter with any type
        @Before("execution( * add*(*))")
        public void doSomeBeforeStuffv4() {
            System.out.println("=====>>>>>> HER WE WILL DO SOME BRE WORK STUFF<<<<<<<<========");
        }

        // match any method in any class starting with add and return any type and may take 0 or more parameter with any type
        @Before("execution( * add*(..))")
        public void doSomeBeforeStuffv5() {
            System.out.println("=====>>>>>> HER WE WILL DO SOME BRE WORK STUFF<<<<<<<<========");
        }

    ******************************** */
}
