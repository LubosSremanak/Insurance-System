package com.herokuapp.insuranceSystem.user.personalInformation;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Identification {

    @NotBlank
    private String firstName, lastName;
    @NotBlank
    @Size(min = 11, max = 11)
    @Pattern(regexp = "^[0-9]{6}(/[0-9]{4})?$")
    private String IdentificationNumber;


    public Identification(String firstName, String lastName, String identificationNumber) {
        isNull(firstName, "Not null");
        isNull(lastName, "Not null");
        isNull(identificationNumber, "Not null");

        this.firstName = firstName;
        this.lastName = lastName;
        this.IdentificationNumber = identificationNumber;
    }

    public Identification() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        isNull(firstName, "Not null");
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        isNull(lastName, "Not null");
        this.lastName = lastName;
    }

    public String getIdentificationNumber() {
        return IdentificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        isNull(identificationNumber, "Not null");
        this.IdentificationNumber = identificationNumber;
    }


    @Override
    public String toString() {
        return
                "firstName='" + firstName + '\'' +
                        ", lastName='" + lastName + '\'' +
                        ", identificationNumber='" + IdentificationNumber + '\'';

    }

    private void isNull(Object object, String exception) throws NullPointerException {
        if (object == null) {
            throw new NullPointerException(exception);
        }

    }

}
