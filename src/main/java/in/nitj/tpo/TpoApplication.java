package in.nitj.tpo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("in.nitj.tpo.repository")
@ComponentScan(basePackages = { "in.nitj.tpo" })
@EntityScan("in.nitj.tpo.entity")
@SpringBootApplication
public class TpoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TpoApplication.class, args);
	}

}
