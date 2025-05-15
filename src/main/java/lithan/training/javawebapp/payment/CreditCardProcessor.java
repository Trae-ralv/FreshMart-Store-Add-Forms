package lithan.training.javawebapp.payment;

public class CreditCardProcessor implements PaymentProcessor {
    @Override
    public boolean process() {
        // Simulate payment processing
    	System.out.println("Processing payment via Credit Card");
        return true;
    }
}