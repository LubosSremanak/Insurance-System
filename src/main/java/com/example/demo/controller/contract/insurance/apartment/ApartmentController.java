package com.example.demo.controller.contract.insurance.apartment;

import com.example.demo.api.UserManager;
import com.example.demo.contract.insurance.nonLife.apartment.ApartmentInsurance;
import com.example.demo.controller.contract.ContractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ApartmentController extends ContractController {

    @Autowired
    public ApartmentController(UserManager userManager) {
        super(userManager);
    }

    @PostMapping("/edit/Apartment/{contractId}/{userId}")
    public String editApartmentToUser(@ModelAttribute @Valid ApartmentInsurance contract, @PathVariable long contractId, @PathVariable long userId) {
        return editContract(contract, userId, contractId);
    }

    @PostMapping("/add/Apartment/{userId}")
    public String addApartmentToUser( @ModelAttribute @Valid ApartmentInsurance contract, @PathVariable long userId) {
        return addContract(contract, userId);
    }
}
