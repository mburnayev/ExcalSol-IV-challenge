package mburnayev.ESGBBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ESGBBackendApplication {

	public static void main(String[] args) {
		System.out.println("Running...");
		SpringApplication.run(ESGBBackendApplication.class, args);
	}

}
