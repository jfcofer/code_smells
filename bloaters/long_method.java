
public class OrderProcessor {

    public void processOrder(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }
        if (order.getItems() == null || order.getItems().isEmpty()) {
            throw new IllegalArgumentException("Order must contain items");
        }
        if (order.getCustomer() == null) {
            throw new IllegalArgumentException("Order must have a customer");
        }

        for (OrderItem item : order.getItems()) {
            if (item.getQuantity() > item.getProduct().getStock()) {
                throw new IllegalArgumentException("Not enough stock for item: " + item.getProduct().getName());
            }
        }

        double totalPrice = 0;
        for (OrderItem item : order.getItems()) {
            double itemPrice = item.getQuantity() * item.getProduct().getPrice();
            totalPrice += itemPrice;
        }

        if (order.getCustomer().isPremiumMember()) {
            double discount = totalPrice * 0.1;
            totalPrice -= discount;
        }

        double taxes = totalPrice * 0.2;
        totalPrice += taxes;

        Invoice invoice = new Invoice();
        invoice.setOrder(order);
        invoice.setTotalPrice(totalPrice);
        invoice.setTaxes(taxes);
        invoice.generate();

        NotificationService notificationService = new NotificationService();
        notificationService.sendInvoiceEmail(order.getCustomer().getEmail(), invoice);

        for (OrderItem item : order.getItems()) {
            Product product = item.getProduct();
            product.setStock(product.getStock() - item.getQuantity());
        }

        OrderRepository orderRepository = new OrderRepository();
        orderRepository.save(order);
    }
}