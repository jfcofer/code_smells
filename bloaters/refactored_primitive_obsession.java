public class Customer {

    private String name;
    private PhoneNumber phoneNumber; // Refactored to use a PhoneNumber class
    private Address address; // Refactored to use an Address class

    public Customer(String name, PhoneNumber phoneNumber, Address address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getName() { return name; }
    public PhoneNumber getPhoneNumber() { return phoneNumber; }
    public Address getAddress() { return address; }

    public void updatePhoneNumber(PhoneNumber newPhoneNumber) {
        this.phoneNumber = newPhoneNumber;
    }

    public void updateAddress(Address newAddress) {
        this.address = newAddress;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address=" + address +
                '}';
    }
}

class PhoneNumber {

    private String value;

    public PhoneNumber(String value) {
        if (value == null || value.length() != 10) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}

class Address {

    private String streetAddress;
    private String city;
    private String postalCode;
    private String country;

    public Address(String streetAddress, String city, String postalCode, String country) {
        if (streetAddress == null || city == null || postalCode == null || country == null) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.streetAddress = streetAddress;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return streetAddress + ", " + city + ", " + postalCode + ", " + country;
    }
}