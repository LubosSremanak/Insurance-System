package com.herokuapp.insurance.contract.insurance.life.travel;


import com.herokuapp.insurance.contract.Contract;
import com.herokuapp.insurance.contract.insurance.life.LifeInsurance;

import javax.validation.constraints.NotNull;

public class TravelInsurance extends LifeInsurance {
    @NotNull
    private PurposeOfTrip purposeOfTrip;
    private boolean europe;


    public TravelInsurance() {
    }

    public TravelInsurance(long contractNumber) {
        super(contractNumber);
        isNull(contractNumber, "Not null");
        this.europe = false;
    }

    public PurposeOfTrip getPurposeOfTrip() {
        return purposeOfTrip;
    }

    public void setPurposeOfTrip(PurposeOfTrip purposeOfTrip) {
        this.purposeOfTrip = purposeOfTrip;
    }

    public boolean isEurope() {
        return europe;
    }

    public void setEurope(boolean europe) {
        this.europe = europe;
    }

    @Override
    public void copy(Contract contract) {
        super.copy(contract);
        purposeOfTrip = ((TravelInsurance) contract).purposeOfTrip;
        europe = ((TravelInsurance) contract).europe;
    }

    @Override
    public String getName() {
        return super.getName() + "Travel";
    }

    @Override
    public String toString() {
        return super.toString() + "TravelInsurance{" +
                "purposeOfTrip=" + purposeOfTrip +
                ", europe=" + europe +
                '}';
    }


}
