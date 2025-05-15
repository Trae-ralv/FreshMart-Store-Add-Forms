package lithan.training.javawebapp.payment;

import org.springframework.stereotype.Component;

@Component
public class BillingService {
    private PaymentProcessor paymentProcessor;

    // Enhancement 1: Added setter method for dependency injection
    public void setPaymentProcessor(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    // Enhancement 2: Improved completePayment method with null check
    public boolean completePayment() {
        if (paymentProcessor == null) {
            throw new IllegalStateException("PaymentProcessor not initialized");
        }
        return paymentProcessor.process();
    }
}

