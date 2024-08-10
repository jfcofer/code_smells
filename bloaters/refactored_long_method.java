public class OrderProcessor {

    public void processOrder(Order order) {
        validateOrder(order);
        checkInventory(order);
        double totalPrice = calculateTotalPrice(order);
        applyDiscount(order.getCustomer(), totalPrice);
        double finalPrice = applyTaxes(totalPrice);
        Invoice invoice = generateInvoice(order, finalPrice);
        notifyCustomer(order.getCustomer(), invoice);
        updateInventory(order);
        saveOrder(order);
    }

    private void validateOrder(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }
        if (order.getItems() == null || order.getItems().isEmpty()) {
            throw new IllegalArgumentException("Order must contain items");
        }
        if (order.getCustomer() == null) {
            throw new IllegalArgumentException("Order must have a customer");
        }
    }

    private void checkInventory(Order order) {
        for (OrderItem item : order.getItems()) {
            if (item.getQuantity() > item.getProduct().getStock()) {
                throw new IllegalArgumentException("Not enough stock for item: " + item.getProduct().getName());
            }
        }
    }

    private double calculateTotalPrice(Order order) {
        double totalPrice = 0;
        for (OrderItem item : order.getItems()) {
            double itemPrice = item.getQuantity() * item.getProduct().getPrice();
            totalPrice += itemPrice;
        }
        return totalPrice;
    }

    private void applyDiscount(Customer customer, double totalPrice) {
        if (customer.isPremiumMember()) {
            double discount = totalPrice * 0.1;
            totalPrice -= discount;
        }
    }

    private double applyTaxes(double totalPrice) {
        double taxes = totalPrice * 0.2;
        return totalPrice + taxes;
    }

    private Invoice generateInvoice(Order order, double totalPrice) {
        Invoice invoice = new Invoice();
        invoice.setOrder(order);
        invoice.setTotalPrice(totalPrice);
        invoice.generate();
        return invoice;
    }

    private void notifyCustomer(Customer customer, Invoice invoice) {
        NotificationService notificationService = new NotificationService();
        notificationService.sendInvoiceEmail(customer.getEmail(), invoice);
    }

    private void updateInventory(Order order) {
        for (OrderItem item : order.getItems()) {
            Product product = item.getProduct();
            product.setStock(product.getStock() - item.getQuantity());
        }
    }

    private void saveOrder(Order order) {
        OrderRepository orderRepository = new OrderRepository();
        orderRepository.save(order);
    }
}