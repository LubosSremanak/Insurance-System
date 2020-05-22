package com.herokuapp.insurance.contract.insurance.nonLife.home;


import com.herokuapp.insurance.contract.Contract;
import com.herokuapp.insurance.contract.insurance.nonLife.NonLifeInsurance;

import javax.validation.constraints.Min;

public class HomeInsurance extends NonLifeInsurance {
    @Min(0)
    private double valueOfHousehold;


    public HomeInsurance() {
    }

    public HomeInsurance(long contractNumber) {
        super(contractNumber);
        isNull(contractNumber, "Not null");
        this.valueOfHousehold = 0;
    }

    @Override
    public void copy(Contract contract) {
        super.copy(contract);
        valueOfHousehold = ((HomeInsurance) contract).getValueOfHousehold();
    }

    @Override
    public String getName() {
        return super.getName() + "Home";
    }

    public double getValueOfHousehold() {
        return valueOfHousehold;
    }

    public void setValueOfHousehold(double valueOfHousehold) {
        this.valueOfHousehold = valueOfHousehold;
    }

    @Override
    public String toString() {
        return super.toString() + "HomeInsurance{" +
                "valueOfHousehold=" + valueOfHousehold +
                '}';
    }


}
