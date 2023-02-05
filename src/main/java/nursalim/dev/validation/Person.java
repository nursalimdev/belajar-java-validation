package nursalim.dev.validation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Person {

    @Size(max = 20, message = "First name length must 20 characters")
    @NotBlank(message = "First name cannot blank")
    private String firstName;
    @Size(max = 20, message = "First name length must 20 characters")
    @NotBlank(message = "Last name cannot blank")
    private String lastName;

    public Person(){

    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
