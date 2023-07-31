package com.javaBean.testJavaBean.rest;

import com.javaBean.testJavaBean.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

   private  Coach theCoach;

   @Autowired
   public void setCoach (Coach theCoach) {
       this.theCoach = theCoach;
   }
    @GetMapping("/")
    public String helloJava() {
        int number = 8;
        return "hello java Spring boot!!";
    }

    @GetMapping("/workout")
    public String getWorkout () {
       return theCoach.getDailyWorkout();
    }
}
