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
}

public class Order {
    private Customer customer;

    public Order(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }
}

public class Main {
    public static void main(String[] args) {
        Address address = new Address("123 Main St", "Springfield", "12345");
        Customer customer = new Customer("John Doe", address);
        Order order = new Order(customer);

        // Message Chains: Acceso encadenado a métodos para obtener la información deseada
        String city = order.getCustomer().getAddress().getCity();
        System.out.println("City: " + city);
    }
}
