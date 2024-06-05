package com.aluracursos.literalurachallenge;

import com.aluracursos.literalurachallenge.principal.Principal;
import com.aluracursos.literalurachallenge.repository.AutoresRepository;
import com.aluracursos.literalurachallenge.repository.LibreriaRepository;
import com.aluracursos.literalurachallenge.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteralurachallengeApplication implements CommandLineRunner {

	@Autowired
	private LibreriaRepository repository;

	@Autowired
	private AutoresRepository autoresRepository;

	@Autowired
	private LibroService libroService;

	public static void main(String[] args) {
		SpringApplication.run(LiteralurachallengeApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(libroService);
		principal.muestraElMenu();
	}
}
