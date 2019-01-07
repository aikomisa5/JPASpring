package hello;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
public class JpaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaSpringApplication.class, args);
	}

	@Bean
	public CommandLineRunner jpaSample(PersonaRepository personaRepo) {
		return (args) -> {

			// save 2 todos in the H2 database
			personaRepo.save(new Persona("Test"));

			Persona p1 = new Persona("Detailed test");
			p1.setDescription("Detailed description");
			personaRepo.save(p1);

			// query for all todos in the H2 database and print them
			personaRepo.findAll().forEach(System.out::println);
		};
	}

}

