package com.omar.primerapp;

import com.omar.primerapp.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class PrimeraAppSpringBootApplication {


	@Autowired
	private PersonaService PerSer;

	public static void main(String[] args) {
		SpringApplication.run(PrimeraAppSpringBootApplication.class, args);

	}
}
