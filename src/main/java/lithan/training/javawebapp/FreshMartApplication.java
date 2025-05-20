package lithan.training.javawebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// Main application class with JPA configuration
@SpringBootApplication
@EntityScan(basePackages = "lithan.training.javawebapp.model")
@EnableJpaRepositories(basePackages = "lithan.training.javawebapp.repository")
public class FreshMartApplication {
    // Entry point for the application
    public static void main(String[] args) {
        SpringApplication.run(FreshMartApplication.class, args);
    }
}