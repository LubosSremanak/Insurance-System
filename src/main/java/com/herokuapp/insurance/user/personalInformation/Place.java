package com.herokuapp.insurance.user.personalInformation;

import javax.validation.constraints.NotBlank;

public class Place {
    @NotBlank
    private String country, city, street;

    public Place() {
    }

    public Place(Place copyPlace) {
        this.country = copyPlace.getCountry();
        this.city = copyPlace.getCity();
        this.street = copyPlace.getStreet();
    }

    public Place(String country, String city, String street) {
        isNull(country, "Not null");
        isNull(city, "Not null");
        isNull(street, "Not null");
        this.country = country;
        this.city = city;
        this.street = street;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        isNull(street, "Not null");
        this.street = street;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        isNull(country, "Not null");
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        isNull(city, "Not null");
        this.city = city;
    }

    @Override
    public String toString() {
        return
                "country='" + country + '\'' +
                        ", city='" + city + '\'' +
                        ", street='" + street + '\'';
    }

    private void isNull(Object object, String exception) throws NullPointerException {
        if (object == null) {
            throw new NullPointerException(exception);
        }

    }
}
