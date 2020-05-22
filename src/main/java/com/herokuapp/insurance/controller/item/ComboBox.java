package com.herokuapp.insurance.controller.item;

import com.herokuapp.insurance.contract.insurance.Insurances;
import org.springframework.stereotype.Service;

@Service
public class ComboBox {
    private Insurances insurance;

    public Insurances getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurances insurance) {
        this.insurance = insurance;
    }
}
