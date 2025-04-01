package com.springboot.SpringBootProject2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springboot.SpringBootProject2.beans.Student;

@SpringBootApplication
public class SpringBootProject2Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProject2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		stdBean1().displayStdDetails();

		System.out.println("-------------------");
		stdBean2().displayStdDetails();
	}

	@Bean
	public Student stdBean1(){
		return  new Student("Kaushal", 84, 77.2f);
	}
	
	@Bean
	public Student stdBean2(){
		return  new Student("Karan", 85, 67.2f);
	}
}
