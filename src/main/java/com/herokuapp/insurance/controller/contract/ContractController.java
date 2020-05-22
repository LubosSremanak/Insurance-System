package com.herokuapp.insurance.controller.contract;

import com.herokuapp.insurance.api.UserManager;
import com.herokuapp.insurance.contract.Contract;
import com.herokuapp.insurance.contract.insurance.life.travel.PurposeOfTrip;
import com.herokuapp.insurance.contract.insurance.life.travel.TravelInsurance;
import com.herokuapp.insurance.contract.insurance.nonLife.TypeOfRealEstate;
import com.herokuapp.insurance.controller.item.ComboBox;
import com.herokuapp.insurance.user.AutoIncrement;
import com.herokuapp.insurance.contract.insurance.Insurances;
import com.herokuapp.insurance.contract.insurance.life.accident.AccidentInsurance;
import com.herokuapp.insurance.contract.insurance.life.accident.TerritorialValidity;
import com.herokuapp.insurance.contract.insurance.nonLife.apartment.ApartmentInsurance;
import com.herokuapp.insurance.contract.insurance.nonLife.home.HomeInsurance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
public abstract class ContractController {

    protected final AutoIncrement contractId;
    protected final UserManager userManager;

    @Autowired
    public ContractController(UserManager userManager, AutoIncrement contractId) {
        this.userManager = userManager;
        this.contractId = contractId;
    }

    @GetMapping("/contract")
    public ModelAndView drawContracts(Model model) {
        model.addAttribute("contract", userManager.getContracts());
        return new ModelAndView("html/contracts");
    }

    @GetMapping("/detail/contract/{contractId}")
    public ModelAndView drawContractDetail(@PathVariable long contractId, Model model) {
        Contract contract = userManager.getContract(contractId);
        model.addAttribute("contract", contract);
        ModelAndView modelAndView = pathFromClass(contract);
        modelAndView.setViewName(modelAndView.getViewName() + "Detail");
        return modelAndView;
    }


    public String editContract(Contract contract, long userId, long contractId) {
        contract.setContractNumber(contractId);
        contract.setInsurer(userManager.editUser(userId));
        userManager.editContract(userId, contractId).copy(contract);
        return "redirect:/detail/{userId}";
    }


    @GetMapping("/edit/contract/{contractId}/{userId}")
    public ModelAndView drawEditContract(@PathVariable long contractId, @PathVariable long userId, Model model) {
        Contract contract = userManager.editContract(userId, contractId);
        model.addAttribute("contract", contract);
        model.addAttribute("edit", true);
        model.addAttribute("contractId", contractId);
        model.addAttribute("userId", userId);
        model.addAttribute("users", userManager.getUsers());
        model.addAttribute("allRealEstates", TypeOfRealEstate.values());
        model.addAttribute("allTerritorialValidity", TerritorialValidity.values());
        model.addAttribute("allPurposeOfTrip", PurposeOfTrip.values());
        return pathFromClass(contract);
    }


    protected String addContract(Contract contract, long userId) {
        contract.setFormation(LocalDate.now());
        contract.setContractNumber(this.contractId.getId());
        this.contractId.autoIncrement();
        contract.setInsurer(userManager.editUser(userId));
        userManager.createContract(userId, contract);
        return "redirect:/detail/{userId}";
    }

    @PostMapping("/create/contract/{userId}")
    public ModelAndView createContract(@Valid @ModelAttribute ComboBox comboBox, Model model, @PathVariable long userId) {
        Insurances insurance = comboBox.getInsurance();
        model.addAttribute("userId", userId);
        model.addAttribute("edit", false);
        model.addAttribute("users", userManager.getUsers());
        Contract contract = contractFromType(insurance, contractId.getId());
        model.addAttribute("contract", contract);
        model.addAttribute("allRealEstates", TypeOfRealEstate.values());
        model.addAttribute("allTerritorialValidity", TerritorialValidity.values());
        model.addAttribute("allPurposeOfTrip", PurposeOfTrip.values());
        return pathFromClass(contract);
    }


    protected Contract contractFromType(Insurances insurance, long contractId) {


        if (insurance.equals(Insurances.TRAVEL)) {
            return new TravelInsurance(contractId);
        }
        if (insurance.equals(Insurances.HOME)) {
            return new HomeInsurance(contractId);
        }
        if (insurance.equals(Insurances.APARTMENT)) {
            return new ApartmentInsurance(contractId);
        }
        return new AccidentInsurance(contractId);

    }

    protected ModelAndView pathFromClass(Contract insurance) {


        if (insurance instanceof TravelInsurance) {
            return new ModelAndView("html/insurances/life/travel");
        }
        if (insurance instanceof HomeInsurance) {
            return new ModelAndView("html/insurances/nonLife/home");
        }
        if (insurance instanceof ApartmentInsurance) {
            return new ModelAndView("html/insurances/nonLife/apartment");
        }

        return new ModelAndView("html/insurances/life/accident");

    }

}
