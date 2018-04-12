package local;

import config.property.APProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
// Para trabalhar com perfis diferentes
@EnableConfigurationProperties(APProperty.class)
public class ApiiinStartApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiiinStartApplication.class, args);
	}
}
