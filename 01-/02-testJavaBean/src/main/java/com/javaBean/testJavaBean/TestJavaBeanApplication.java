package com.javaBean.testJavaBean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(
//		// custom scanning is required for all the packages that outside the default one.
//		scanBasePackages = {"com.javaBean.utils", "com.javaBean.testJavaBean"}
//)
@SpringBootApplication
public class TestJavaBeanApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestJavaBeanApplication.class, args);
	}

}
