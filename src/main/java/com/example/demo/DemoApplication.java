package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.model.Alien;
import com.example.demo.repo.AlienRepo;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context =SpringApplication.run(DemoApplication.class, args);
		Alien alien1 = context.getBean(Alien.class);
		alien1.setId(100);
		alien1.setName("Grv");
		alien1.setTech("Java");

		AlienRepo repo = context.getBean(AlienRepo.class);
		repo.save(alien1);


		System.out.println(repo.findAll());


		//we can write all jdbc steps here but we will use springboot to connect with database

		

	}

}
