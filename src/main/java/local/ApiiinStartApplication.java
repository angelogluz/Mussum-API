package local;

import local.config.property.APIProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableConfigurationProperties(APIProperty.class)
public class ApiiinStartApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiiinStartApplication.class, args);
	}
}
