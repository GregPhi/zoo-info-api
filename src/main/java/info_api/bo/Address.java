package info_api.bo;

import java.util.Objects;

public class Address {
    private String address;
    private int zip_code;
    private String street;

    public Address() {
    }

    public Address(String address, int zip_code, String street) {
        this.address = address;
        this.zip_code = zip_code;
        this.street = street;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getZip_code() {
        return zip_code;
    }

    public void setZip_code(int zip_code) {
        this.zip_code = zip_code;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address1 = (Address) o;
        return zip_code == address1.zip_code &&
                Objects.equals(address, address1.address) &&
                Objects.equals(street, address1.street);
    }
}
