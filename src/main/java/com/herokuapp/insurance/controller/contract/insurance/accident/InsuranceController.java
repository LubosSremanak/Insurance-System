package com.herokuapp.insurance.controller.contract.insurance.accident;

import com.herokuapp.insurance.contract.insurance.life.travel.TravelInsurance;
import com.herokuapp.insurance.api.UserManager;
import com.herokuapp.insurance.contract.insurance.life.accident.AccidentInsurance;
import com.herokuapp.insurance.contract.insurance.nonLife.apartment.ApartmentInsurance;
import com.herokuapp.insurance.contract.insurance.nonLife.home.HomeInsurance;
import com.herokuapp.insurance.controller.contract.ContractController;
import com.herokuapp.insurance.user.AutoIncrement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class InsuranceController extends ContractController {

    @Autowired
    public InsuranceController(UserManager userManager, AutoIncrement contractId) {
        super(userManager, contractId);
    }


    @PostMapping("/edit/Accident/{contractId}/{userId}")
    public String editAccidentToUser(@ModelAttribute @Valid AccidentInsurance contract, @PathVariable long contractId, @PathVariable long userId) {
        contract.setInsured(userManager.editUser(contract.getInsured().getId()));
        return editContract(contract, userId, contractId);
    }

    @PostMapping("/add/Accident/{userId}")
    public String addAccidentToUser(@ModelAttribute @Valid AccidentInsurance contract, @PathVariable long userId) {
        contract.setInsured(userManager.editUser(contract.getInsured().getId()));
        return addContract(contract, userId);
    }

    @PostMapping("/edit/Travel/{contractId}/{userId}")
    public String editTravelToUser(@ModelAttribute @Valid TravelInsurance contract, @PathVariable long contractId, @PathVariable long userId) {
        contract.setInsured(userManager.editUser(contract.getInsured().getId()));
        return editContract(contract, userId, contractId);
    }

    @PostMapping("/add/Travel/{userId}")
    public String addTravelToUser(@ModelAttribute @Valid TravelInsurance contract, @PathVariable long userId) {
        contract.setInsured(userManager.editUser(contract.getInsured().getId()));
        return addContract(contract, userId);
    }

    @PostMapping("/edit/Apartment/{contractId}/{userId}")
    public String editApartmentToUser(@ModelAttribute @Valid ApartmentInsurance contract, @PathVariable long contractId, @PathVariable long userId) {
        return editContract(contract, userId, contractId);
    }

    @PostMapping("/add/Apartment/{userId}")
    public String addApartmentToUser(@ModelAttribute @Valid ApartmentInsurance contract, @PathVariable long userId) {
        return addContract(contract, userId);
    }

    @PostMapping("/edit/Home/{contractId}/{userId}")
    public String editHomeToUser(@ModelAttribute @Valid HomeInsurance contract, @PathVariable long contractId, @PathVariable long userId) {
        return editContract(contract, userId, contractId);
    }

    @PostMapping("/add/Home/{userId}")
    public String addHomeToUser(@ModelAttribute @Valid HomeInsurance contract, @PathVariable long userId) {
        return addContract(contract, userId);
    }
}
