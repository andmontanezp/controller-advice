package cl.anderson.errorhandling.controlleradvice;

import cl.anderson.errorhandling.controlleradvice.city.model.City;
import cl.anderson.errorhandling.controlleradvice.city.repository.CityRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class ControllerAdviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControllerAdviceApplication.class, args);
	}

	@Bean
	public ApplicationRunner runner(CityRepository cityRepository) {
		return new ApplicationRunner() {
			@Override
			public void run(ApplicationArguments args) throws Exception {
				City caracas = new City("Caracas", 2_000_000);
				City santiago = new City("Santiago", 3_000_000);
				City lima = new City("Lima", 1_000_000);

				cityRepository.saveAll(Arrays.asList(caracas, santiago, lima));
			}
		};
	}
}
