package com.example.demo.contract.insurance.nonLife.apartment;


import com.example.demo.contract.Contract;
import com.example.demo.contract.insurance.nonLife.NonLifeInsurance;

public class ApartmentInsurance extends NonLifeInsurance {

    private boolean reinsurance;

    public ApartmentInsurance() {
    }

    public ApartmentInsurance(long contractNumber) {
        super(contractNumber);
        isNull(contractNumber, "Not null");
        this.reinsurance = false;
    }

    @Override
    public void copy(Contract contract) {
        super.copy(contract);
        reinsurance = ((ApartmentInsurance) contract).isReinsurance();
    }

    @Override
    public String getName() {
        return super.getName() + "Apartment";
    }

    public boolean isReinsurance() {
        return reinsurance;
    }

    public void setReinsurance(boolean reinsurance) {
        this.reinsurance = reinsurance;
    }

    @Override
    public String toString() {
        return super.toString() + "ApartmentInsurance{" +
                "reinsurance=" + reinsurance +
                '}';
    }


}
