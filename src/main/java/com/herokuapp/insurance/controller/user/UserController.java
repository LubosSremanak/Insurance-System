package com.herokuapp.insurance.controller.user;

import com.herokuapp.insurance.api.UserManager;
import com.herokuapp.insurance.contract.insurance.Insurances;
import com.herokuapp.insurance.controller.item.ComboBox;
import com.herokuapp.insurance.user.AutoIncrement;
import com.herokuapp.insurance.user.User;
import com.herokuapp.insurance.user.personalInformation.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {

    protected final UserManager userManager;
    private final AutoIncrement userId;

    @Autowired
    public UserController(UserManager userManager, AutoIncrement id) {
        this.userManager = userManager;
        this.userId = id;
    }


    @GetMapping("/edit/{id}")
    public ModelAndView drawEdit(@PathVariable long id, Model model, boolean detail) {

        model.addAttribute("user", userManager.editUser(id));

        if (detail) {
            model.addAttribute("detail", true);
        } else {
            model.addAttribute("edit", true);
        }
        return new ModelAndView("html/addUser");
    }


    @PostMapping("/edit/{id}/{check}")
    public String editUser(@ModelAttribute @Valid User user, @PathVariable boolean check) {
        System.out.println(check);

        if (check)
            user.setCorrespondenceAddress(user.getCorrespondenceAddress());
        else
            user.setCorrespondenceAddress(new Address(user.getAddress()));
        userManager.editUser(user.getId()).copy(user);
        return "redirect:/user";
    }

    @GetMapping("/user")
    public ModelAndView drawUser(Model model) {
        model.addAttribute("userList", userManager.getUsers());
        return new ModelAndView("html/user");
    }

    @GetMapping("/addUser")
    public ModelAndView drawAddUser(Model model) {

        model.addAttribute("user", new User(this.userId.getId()));
        model.addAttribute("edit", false);

        return new ModelAndView("html/addUser");
    }

    @PostMapping("/user")
    public Object addUser(@ModelAttribute @Valid User user, Model model) {

        user.setCorrespondenceAddress(user.getCorrespondenceAddress());
        user.setId(userId.getId());
        userManager.addUser(user);
        userId.autoIncrement();

        return drawUserDetail(user.getId(), model);
    }

    @GetMapping("/edit/detail/{id}")
    public ModelAndView drawDetailEdit(@PathVariable long id, Model model) {
        model.addAttribute("edit", 2);
        return drawEdit(id, model, true);
    }

    @PostMapping("/edit/detail/{id}/{check}")
    public String detailEditUser(@ModelAttribute @Valid User user, @PathVariable boolean check) {


        if (check)
            user.setCorrespondenceAddress(user.getCorrespondenceAddress());
        else
            user.setCorrespondenceAddress(new Address(user.getAddress()));
        userManager.editUser(user.getId()).copy(user);
        return "redirect:/detail/{id}";
    }


    @GetMapping("/detail/{id}")
    public ModelAndView drawUserDetail(@PathVariable long id, Model model) {
        model.addAttribute("user", userManager.editUser(id));
        model.addAttribute("allInsurances", Insurances.values());
        model.addAttribute("comboBox", new ComboBox());
        return new ModelAndView("html/detail");
    }

}
