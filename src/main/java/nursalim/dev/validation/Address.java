package nursalim.dev.validation;

import jakarta.validation.constraints.NotBlank;

public class Address {
    @NotBlank(message = "Street can not blank")
    private String street;
    @NotBlank(message = "City can not blank")
    private String city;
    @NotBlank(message = "Country can not blank")
    private String country;

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
