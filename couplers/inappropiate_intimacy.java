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

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
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

    public void setAddress(Address address) {
        this.address = address;
    }
}

public class Order {
    private Customer customer;
    private double amount;

    public Order(Customer customer, double amount) {
        this.customer = customer;
        this.amount = amount;
    }

    public void updateShippingAddress(String street, String city, String postalCode) {
        // Inappropriate Intimacy: La clase Order está accediendo y modificando directamente los atributos de la clase Address.
        // Esto genera una fuerte dependencia entre las clases Order y Address, lo que indica que Order sabe demasiado sobre la estructura interna de Address.
        customer.getAddress().setStreet(street);
        customer.getAddress().setCity(city);
        customer.getAddress().setPostalCode(postalCode);
    }

    public double getAmount() {
        return amount;
    }

    public Customer getCustomer() {
        return customer;
    }
}
