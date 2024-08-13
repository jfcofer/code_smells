public class Order {
    private String customerName;
    private String customerAddress;
    private String customerPhone;
    private String productName;
    private double productPrice;
    private int quantity;

    public Order(String customerName, String customerAddress, String customerPhone, String productName, double productPrice, int quantity) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
    }

    public double calculateTotalAmount() {
        return productPrice * quantity;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public int getQuantity() {
        return quantity;
    }
}

public class OrderPrinter {

    public void printOrderDetails(Order order) {
        // Feature Envy: accediendo a múltiples atributos de la clase Order
        System.out.println("Order details:");
        System.out.println("Customer: " + order.getCustomerName());
        System.out.println("Address: " + order.getCustomerAddress());
        System.out.println("Phone: " + order.getCustomerPhone());
        System.out.println("Product: " + order.getProductName());
        System.out.println("Price: $" + order.getProductPrice());
        System.out.println("Quantity: " + order.getQuantity());
        System.out.println("Total: $" + order.calculateTotalAmount());
    }
}

public class OrderProcessor {

    public void processOrder(Order order) {
        // Feature Envy: accediendo a múltiples atributos de la clase Order
        System.out.println("Processing order for " + order.getCustomerName());
        System.out.println("Shipping to " + order.getCustomerAddress());
        System.out.println("Contact phone: " + order.getCustomerPhone());
        System.out.println("Order total: $" + order.calculateTotalAmount());
    }
}
