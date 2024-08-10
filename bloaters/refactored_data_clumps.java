public class Customer {

    private String name;
    private String address;
    private String phone;

    public Customer(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
}

public class Product {

    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double calculateTotalPrice() {
        return price * quantity;
    }
}

public class OrderProcessor {

    public void processOrder(Customer customer, Product product) {
        double totalAmount = product.calculateTotalPrice();
        System.out.println("Processing order for " + customer.getName());
        System.out.println("Shipping to " + customer.getAddress());
        System.out.println("Contact phone: " + customer.getPhone());
        System.out.println("Order total: $" + totalAmount);
    }
}

public class InvoiceGenerator {

    public void generateInvoice(Customer customer, Product product) {
        double totalAmount = product.calculateTotalPrice();
        System.out.println("Generating invoice for " + customer.getName());
        System.out.println("Shipping to " + customer.getAddress());
        System.out.println("Contact phone: " + customer.getPhone());
        System.out.println("Invoice total: $" + totalAmount);
    }
}

public class CustomerService {

    public void sendOrderConfirmation(Customer customer, Product product) {
        double totalAmount = product.calculateTotalPrice();
        System.out.println("Sending order confirmation to " + customer.getName());
        System.out.println("Address: " + customer.getAddress());
        System.out.println("Contact phone: " + customer.getPhone());
        System.out.println("Order total: $" + totalAmount);
    }
}