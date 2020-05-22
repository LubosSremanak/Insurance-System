package com.example.demo.controller.contract.insurance.travel;

import com.example.demo.api.UserManager;
import com.example.demo.contract.insurance.life.travel.TravelInsurance;
import com.example.demo.controller.contract.ContractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class TravelController extends ContractController {

    @Autowired
    public TravelController(UserManager userManager) {
        super(userManager);
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

}
