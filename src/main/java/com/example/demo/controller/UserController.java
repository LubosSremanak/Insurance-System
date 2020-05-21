package com.example.demo.controller;

import com.example.demo.api.UserManager;
import com.example.demo.contract.insurance.Insurances;
import com.example.demo.controller.item.ComboBox;
import com.example.demo.user.AutoIncrement;
import com.example.demo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController extends SpringController {

    private final AutoIncrement userId;


    @Autowired
    public UserController(UserManager userManager, AutoIncrement id) {
        super(userManager);
        this.userId = id;
    }

    @GetMapping("/edit/{id}")
    public String drawEdit(@PathVariable long id, Model model, boolean detail) {

        model.addAttribute("user", userManager.editUser(id));

        if (detail) {
            model.addAttribute("detail", true);
        } else {
            model.addAttribute("edit", true);
        }
        return "/html/addUser";
    }


    @PostMapping("/edit/{id}")
    public String editUser(@ModelAttribute @Valid User user) {
        userManager.editUser(user.getId()).copy(user);
        user.setCorrespondenceAddress(user.getCorrespondenceAddress());
        return "redirect:/user";
    }

    @GetMapping("/user")
    public String drawUser(Model model) {
        model.addAttribute("userList", userManager.getUsers());
        return "/html/user";
    }

    @GetMapping("/addUser")
    public String drawAddUser(Model model) {

        model.addAttribute("user", new User(this.userId.getId()));
        model.addAttribute("edit", false);

        return "/html/addUser";
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
    public String drawDetailEdit(@PathVariable long id, Model model) {
        model.addAttribute("edit", 2);
        return drawEdit(id, model, true);
    }

    @PostMapping("/edit/detail/{id}")
    public String detailEditUser(@ModelAttribute @Valid User user) {
        userManager.editUser(user.getId()).copy(user);
        user.setCorrespondenceAddress(user.getCorrespondenceAddress());
        return "redirect:/detail/{id}";
    }


    @GetMapping("/detail/{id}")
    public String drawUserDetail(@PathVariable long id, Model model) {
        model.addAttribute("user", userManager.editUser(id));
        model.addAttribute("allInsurances", Insurances.values());
        model.addAttribute("comboBox", new ComboBox());
        return "/html/detail";
    }

}
