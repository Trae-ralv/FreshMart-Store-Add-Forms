package lithan.training.javawebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"FreshMart","lithan.training.javawebapp","controller","model","config","payment","service","dao"})
public class FreshMartApplication {

	public static void main(String[] args) {
		SpringApplication.run(FreshMartApplication.class, args);
	}

}
