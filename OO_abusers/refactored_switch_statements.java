public class refactored_switch_statements {

    public interface PaymentStrategy {
        void processPayment(double amount);
    }
    
    public class CreditCardPayment implements PaymentStrategy {
        @Override
        public void processPayment(double amount) {
            System.out.println("Processing credit card payment of $" + amount);
        }
    }
    
    public class DebitCardPayment implements PaymentStrategy {
        @Override
        public void processPayment(double amount) {
            System.out.println("Processing debit card payment of $" + amount);
        }
    }
    
    public class PaypalPayment implements PaymentStrategy {
        @Override
        public void processPayment(double amount) {
            System.out.println("Processing PayPal payment of $" + amount);
        }
    }
    

    public class PaymentProcessor {
        private PaymentStrategy strategy;
    
        public PaymentProcessor(PaymentStrategy strategy) {
            this.strategy = strategy;
        }
    
        public void processPayment(double amount) {
            strategy.processPayment(amount);
        }
    }
    
    
    public static void main(String[] args) {
        PaymentStrategy creditCardStrategy = new CreditCardPayment();
        PaymentStrategy debitCardStrategy = new DebitCardPayment();
        PaymentStrategy paypalStrategy = new PaypalPayment();

        PaymentProcessor processor = new PaymentProcessor(creditCardStrategy);
        processor.processPayment(100.0);

        processor = new PaymentProcessor(debitCardStrategy);
        processor.processPayment(200.0);

        processor = new PaymentProcessor(paypalStrategy);
        processor.processPayment(300.0);
    }
      
}
