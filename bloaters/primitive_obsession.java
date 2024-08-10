public class Customer {

    private String name;
    private String phoneNumber;
    private String streetAddress; 
    private String city;
    private String postalCode;
    private String country;

    public Customer(String name, String phoneNumber, String streetAddress, String city, String postalCode, String country) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.streetAddress = streetAddress;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    public String getName() { return name; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getStreetAddress() { return streetAddress; }
    public String getCity() { return city; }
    public String getPostalCode() { return postalCode; }
    public String getCountry() { return country; }

    public void updatePhoneNumber(String newPhoneNumber) {
        if (newPhoneNumber == null || newPhoneNumber.length() != 10) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        this.phoneNumber = newPhoneNumber;
    }

    public void updateAddress(String streetAddress, String city, String postalCode, String country) {
        if (streetAddress == null || city == null || postalCode == null || country == null) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.streetAddress = streetAddress;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + streetAddress + ", " + city + ", " + postalCode + ", " + country + '\'' +
                '}';
    }
}