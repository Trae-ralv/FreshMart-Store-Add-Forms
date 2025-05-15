package lithan.training.javawebapp.config;

import lithan.training.javawebapp.payment.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public PaymentProcessorFactory paymentProcessorFactory() {
    	// Returns a singleton instance of the factory
        return new PaymentProcessorFactory();
    }

    @Bean
    public BillingService billingService(PaymentProcessorFactory factory) {
        BillingService billingService = new BillingService();
        // Injects a PaymentProcessor (defaulting to "gpay" mode) into BillingService
        // This ensures the dependency is properly set up during bean creation
        billingService.setPaymentProcessor(factory.getPaymentProcessor("gpay")); // Default to gpay
        return billingService;
    }
}

