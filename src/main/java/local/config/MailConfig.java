package local.config;

import local.config.property.APIProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfig {

    @Autowired
    private APIProperty property;

    @Bean
    public JavaMailSender mailSender() {

        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.connectiontimeout", 1000 * 10);

        JavaMailSenderImpl mail = new JavaMailSenderImpl();
        mail.setJavaMailProperties(properties);
        mail.setHost(property.getMail().getHost());
        mail.setPort(property.getMail().getPort());
        mail.setUsername(property.getMail().getUsername());
        mail.setPassword(property.getMail().getPassword());
        return mail;
    }

}
