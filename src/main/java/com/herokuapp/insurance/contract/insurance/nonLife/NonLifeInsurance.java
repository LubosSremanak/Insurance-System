package com.herokuapp.insurance.contract.insurance.nonLife;


import com.herokuapp.insurance.contract.Contract;
import com.herokuapp.insurance.user.personalInformation.Address;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public abstract class NonLifeInsurance extends Contract {
    @Min(0)
    protected float realEstateValue; //€
    @NotNull
    protected Address address;
    @NotNull
    protected TypeOfRealEstate typeOfRealEstate;


    public NonLifeInsurance() {
    }

    public NonLifeInsurance(long contractNumber) {
        super(contractNumber);
    }

    public float getRealEstateValue() {
        return realEstateValue;
    }

    public void setRealEstateValue(float realEstateValue) {
        isNull(realEstateValue, "Not null");
        this.realEstateValue = realEstateValue;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public TypeOfRealEstate getTypeOfRealEstate() {
        return typeOfRealEstate;
    }

    public void setTypeOfRealEstate(TypeOfRealEstate typeOfRealEstate) {
        this.typeOfRealEstate = typeOfRealEstate;
    }

    public String getName() {

        return super.getName();
    }

    @Override
    public void copy(Contract contract) {
        super.copy(contract);
        realEstateValue = ((NonLifeInsurance) contract).getRealEstateValue();
        address = ((NonLifeInsurance) contract).getAddress();
        typeOfRealEstate = ((NonLifeInsurance) contract).getTypeOfRealEstate();

    }

    @Override
    public String toString() {
        return super.toString() + "NonLifeInsurance{" +
                "realEstateValue=" + realEstateValue +
                ", address=" + address +
                ", typeOfRealEstate=" + typeOfRealEstate +
                '}';
    }
}
