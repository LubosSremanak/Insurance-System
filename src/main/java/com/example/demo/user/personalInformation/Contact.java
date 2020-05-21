package com.example.demo.user.personalInformation;

import com.sun.istack.internal.Nullable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Contact {
    @NotBlank
    @Size(min = 10, max = 10, message = "Phone number must be 09xx xxx xxx")
    private String phoneNumber;
    @NotBlank
    @Email
    private String email;

    public Contact() {
    }

    public Contact(@Nullable String phoneNumber, @Nullable String email) {
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'';
    }

}
