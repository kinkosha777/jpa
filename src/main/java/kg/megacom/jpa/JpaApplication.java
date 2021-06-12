package kg.megacom.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaApplication {

	private static final Logger log = LoggerFactory.getLogger(JpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(new Customer("Jack", "Bauer",43,50000));
			repository.save(new Customer("Chloe", "O'Brian",23,30000));
			repository.save(new Customer("Kim", "Bauer",31,35000));
			repository.save(new Customer("David", "Palmer",37,40000));
			repository.save(new Customer("Michelle", "Dessler",25,32000));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Customer customer = repository.findById(1L);
			log.info("Customer found with findById(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});

			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});

			log.info("Customer found with findByLastNameAndFirstName(Michelle Dessler):");
			log.info("--------------------------------------------");
			repository.findByLastNameAndFirstName("Dessler","Michelle").forEach(dessler -> {
				log.info(dessler.toString());
			});

			log.info("Customer found with findByLastNameOrFirstName(Michelle or Palmer):");
			log.info("--------------------------------------------");
			repository.findByLastNameOrFirstName("Palmer","Michelle")
					.forEach(customer1 -> log.info(customer1.toString()));
			log.info("--------------------------------------------");

			log.info("Customer found with findByLastNameEquals (O'Brian):");
			log.info("--------------------------------------------");
			repository.findByLastNameEquals("O'Brian")
					.forEach(customer1 -> log.info(customer1.toString()));
			log.info("--------------------------------------------");

			log.info("Customer found with findByLastNameEquals (O'Brian):");
			log.info("--------------------------------------------");
			repository.findByLastNameEquals("O'Brian")
					.forEach(customer1 -> log.info(customer1.toString()));
			log.info("--------------------------------------------");

			log.info("Customer found by with findBySalaryBetween(50000,30000)");
			log.info("");
			repository.findBySalaryBetween(50000, 30000)
					.forEach(customer1 -> log.info(customer1.toString()));
			log.info("--------------------------------------------");

			log.info("Customer found by with findBySalaryGreaterThan(32000)");
			log.info("");
			repository.findBySalaryGreaterThan(32000)
					.forEach(customer1 -> log.info(customer1.toString()));
			log.info("--------------------------------------------");

			log.info("Customer found by with findBySalaryOrderByFirstNameDesc(50000)");
			log.info("");
			repository.findBySalaryOrderByFirstNameDesc(50000)
					.forEach(customer1 -> log.info(customer1.toString()));
			log.info("--------------------------------------------");

			log.info("Customer found by with findBySalaryGreaterThanOrAgeBefore(30000,23)");
			log.info("");
			repository.findBySalaryGreaterThanOrAgeBefore(30000,23)
					.forEach(customer1 -> log.info(customer1.toString()));
			log.info("--------------------------------------------");



			log.info("Customer found by with findByFirstNameLikeAndFirstNameNotLike(the first name ends with an 'e' but not 'oe')");
			log.info("");
			repository.findByFirstNameLikeAndFirstNameNotLike("%e", "%oe")
					.forEach(customer1 -> log.info(customer1.toString()));
			log.info("--------------------------------------------");

			log.info("Customer found by with findByLastNameStartingWith(the last name start with an 'B' and first name ends 'd')");
			log.info("");
			repository.findByLastNameStartingWithOrFirstNameEndingWith("B", "d")
					.forEach(customer1 -> log.info(customer1.toString()));
			log.info("--------------------------------------------");

			log.info("Customer found by with findByFirstNameIgnoreCase(BEKMYRZA)");
			log.info("");
			repository.findByFirstNameIgnoreCase("BEKMYRZA")
					.forEach(customer1 -> log.info(customer1.toString()));
			log.info("--------------------------------------------");



		};
	}
}
