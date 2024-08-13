public class Address {
    private String street;
    private String city;
    private String postalCode;

    public Address(String street, String city, String postalCode) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }
}

public class Customer {
    private String name;
    private Address address;

    public Customer(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public String getStreet() {
        return address.getStreet();
    }

    public String getCity() {
        return address.getCity();
    }

    public String getPostalCode() {
        return address.getPostalCode();
    }
}

public class Order {
    private Customer customer;

    public Order(Customer customer) {
        this.customer = customer;
    }

    public String getCustomerName() {
        return customer.getName();
    }

    public String getCustomerStreet() {
        return customer.getStreet();
    }

    public String getCustomerCity() {
        return customer.getCity();
    }

    public String getCustomerPostalCode() {
        return customer.getPostalCode();
    }
}

public class Main {
    public static void main(String[] args) {
        Address address = new Address("123 Main St", "Springfield", "12345");
        Customer customer = new Customer("John Doe", address);
        Order order = new Order(customer);

        // Middle Man: Acceso indirecto a datos a través de múltiples métodos intermediarios
        //La clase Order no añade ningún comportamiento útil, simplemente delega llamadas de un método a otro.
        System.out.println("Customer Name: " + order.getCustomerName());
        System.out.println("Street: " + order.getCustomerStreet());
        System.out.println("City: " + order.getCustomerCity());
        System.out.println("Postal Code: " + order.getCustomerPostalCode());
    }
}
