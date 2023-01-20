package com.gl.TicketTrackingApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gl.TicketTrackingApplication.service.TicketService;

@SpringBootApplication
public class TicketTrackingApplication implements CommandLineRunner {
	
	@Autowired
	TicketService serviceImpl;
	
	public static void main(String[] args) {
		SpringApplication.run(TicketTrackingApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

	}

}
