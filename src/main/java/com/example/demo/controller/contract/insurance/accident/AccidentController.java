package com.example.demo.controller.contract.insurance.accident;

import com.example.demo.api.UserManager;
import com.example.demo.contract.insurance.life.accident.AccidentInsurance;
import com.example.demo.controller.contract.ContractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AccidentController extends ContractController {

    @Autowired
    public AccidentController(UserManager userManager) {
        super(userManager);
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
}
