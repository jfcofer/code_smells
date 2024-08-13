public class switch_statements{

    public class PaymentProcessor {
        public void processPayment(PaymentType type, double amount) {
            switch (type) {
                case CREDIT_CARD:
                    processCreditCardPayment(amount);
                    break;
                case DEBIT_CARD:
                    processDebitCardPayment(amount);
                    break;
                case PAYPAL:
                    processPaypalPayment(amount);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown payment type");
            }
        }
    
        private void processCreditCardPayment(double amount) {
            System.out.println("Processing credit card payment of $" + amount);
        }
    
        private void processDebitCardPayment(double amount) {
            System.out.println("Processing debit card payment of $" + amount);
        }
    
        private void processPaypalPayment(double amount) {
            System.out.println("Processing PayPal payment of $" + amount);
        }
    }
    
    enum PaymentType {
        CREDIT_CARD,
        DEBIT_CARD,
        PAYPAL
    }
    

}
