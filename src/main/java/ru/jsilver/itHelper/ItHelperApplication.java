package ru.jsilver.itHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.jsilver.itHelper.repositories.PersonRepository;


@SpringBootApplication
public class ItHelperApplication {

	@Autowired
	private PersonRepository personRepository;

//	private static Logger log = LoggerFactory.getLogger(ItHelperApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ItHelperApplication.class, args);
	}

//	@PostConstruct
//	public void setup() {
//		List<Person> names = personService.getPersonNamesByLastName("Куколев");
//		log.info("names: " + names);
//	}
}
