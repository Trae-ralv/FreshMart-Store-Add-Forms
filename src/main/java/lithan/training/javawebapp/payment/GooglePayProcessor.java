package lithan.training.javawebapp.payment;

public class GooglePayProcessor implements PaymentProcessor {
    @Override
    public boolean process() {
        // Simulate payment processing
    	System.out.println("Processing payment via Google Pay");
        return true;
    }
}