package com.digiprisma;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.digiprisma.client.infra.repositories.ClientDpoRepository;
import com.digiprisma.client.persistence.model.ClientDpo;

@EnableAutoConfiguration
@SpringBootApplication
public class GestioCommandeApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestioCommandeApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ClientDpoRepository clientDpoRepository) {
		clientDpoRepository
				.save(new ClientDpo("skander", "skander", "bachouche", 706089771, new Date(), "Paris France"));
		clientDpoRepository.save(new ClientDpo("skander", "rabii", "belkhiri", 22372665, new Date(), "Nabeul Tunisie"));
		return args -> {
			clientDpoRepository.findAll().forEach(System.out::println);
		};
	}
}
