package com.herokuapp.insuranceSystem.contract.insurance.life.accident;


import com.herokuapp.insuranceSystem.contract.Contract;
import com.herokuapp.insuranceSystem.contract.insurance.life.LifeInsurance;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AccidentInsurance extends LifeInsurance {
    @NotNull
    private TerritorialValidity territorialValidity;
    @Min(0)
    private double death, permanentInsultConsequences, dailyHospitalCompensation;


    public AccidentInsurance() {
    }

    public AccidentInsurance(long contractNumber) {
        super(contractNumber);
    }

    public TerritorialValidity getTerritorialValidity() {
        return territorialValidity;
    }

    public void setTerritorialValidity(TerritorialValidity territorialValidity) {
        isNull(territorialValidity, "Not null");
        this.territorialValidity = territorialValidity;
    }

    public double getDeath() {
        return death;
    }

    public void setDeath(double death) {
        this.death = death;
    }

    public double getPermanentInsultConsequences() {
        return permanentInsultConsequences;
    }

    public void setPermanentInsultConsequences(double permanentInsultConsequences) {
        this.permanentInsultConsequences = permanentInsultConsequences;
    }

    public double getDailyHospitalCompensation() {
        return dailyHospitalCompensation;
    }

    public void setDailyHospitalCompensation(double dailyHospitalCompensation) {
        this.dailyHospitalCompensation = dailyHospitalCompensation;

    }

    @Override
    public void copy(Contract contract) {
        super.copy(contract);
        death = ((AccidentInsurance) contract).getDeath();
        permanentInsultConsequences = ((AccidentInsurance) contract).getPermanentInsultConsequences();
        dailyHospitalCompensation = ((AccidentInsurance) contract).getDailyHospitalCompensation();
        territorialValidity = ((AccidentInsurance) contract).getTerritorialValidity();

    }

    @Override
    public String getName() {
        return super.getName() + "Accident";
    }

    @Override
    public String toString() {
        return super.toString() + "AccidentInsurance{" +
                "territorialValidity=" + territorialValidity +
                ", death=" + death +
                ", permanentInsultConsequences=" + permanentInsultConsequences +
                ", dailyHospitalCompensation=" + dailyHospitalCompensation +
                '}';
    }


}
