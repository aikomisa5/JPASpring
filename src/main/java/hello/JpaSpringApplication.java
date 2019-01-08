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
	public CommandLineRunner jpaExample(PersonaRepository personaRepository) {
		return (args) -> {

			// persisto a una persona en la base de H2
			Persona p1 = new Persona("Sherlock","Holmes","25877147","DNI",35);
			personaRepository.save(p1);

			Persona p2 = new Persona("John","Watson","25845347","DNI",37);
			personaRepository.save(p2);

			// query for all todos in the H2 database and print them
			personaRepository.findAll().forEach(System.out::println);
		};
	}

}

