package com.example.demo.controller.contract.insurance.home;

import com.example.demo.api.UserManager;
import com.example.demo.contract.insurance.nonLife.home.HomeInsurance;
import com.example.demo.controller.contract.ContractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class HomeController extends ContractController {

    @Autowired
    public HomeController(UserManager userManager) {
        super(userManager);
    }


    @PostMapping("/edit/Home/{contractId}/{userId}")
    public String editHomeToUser(@ModelAttribute @Valid HomeInsurance contract, @PathVariable long contractId, @PathVariable long userId) {
        return editContract(contract, userId, contractId);
    }


    @PostMapping("/add/Home/{userId}")
    public String addHomeToUser( @ModelAttribute @Valid HomeInsurance contract, @PathVariable long userId) {
        return addContract(contract, userId);
    }
}
