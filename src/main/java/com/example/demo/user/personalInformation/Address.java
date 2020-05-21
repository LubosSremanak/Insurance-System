package com.example.demo.user.personalInformation;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Address {

    @Min(1)
    private int houseNumber;
    @NotBlank
    @Size(min = 5, max = 6)
    @Pattern(regexp = "^[0-9]{3}(\\s*[0-9]{2})?$")
    private String psc;

    private Place place;

    public Address() {

    }

    public Address(Address copyAddress) {
        isNull(copyAddress, "Not null");
        this.houseNumber = copyAddress.getHouseNumber();
        this.psc = copyAddress.getPsc();
        this.place = new Place(copyAddress.getPlace());
    }

    public Address(Place place, int houseNumber, String psc) {
        isNull(place, "Not null");
        isNull(psc, "Not null");
        this.houseNumber = houseNumber;
        this.psc = psc;
        this.place = place;
    }

    public String getPsc() {
        return psc;
    }

    public void setPsc(String psc) {
        isNull(psc, "Not null");
        this.psc = psc;
    }


    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        isNull(place, "Not null");
        this.place = place;
    }

    public void isEverythingSet() throws NullPointerException {

        if (psc.equals("") || place.getCity().equals("") || place.getCountry().equals("") || place.getStreet().equals(""))
            isNull(null, "Not null");

    }

    @Override
    public String toString() {
        return "houseNumber=" + houseNumber +
                ", psc=" + psc +
                ", place=" + place;
    }

    private void isNull(Object object, String exception) throws NullPointerException {

        if (object == null) {
            throw new NullPointerException(exception);
        }

    }
}
