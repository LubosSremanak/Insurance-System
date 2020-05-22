package com.example.demo.controller;

import com.example.demo.api.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public abstract class SpringController {

    protected final UserManager userManager;

    @Autowired
    public SpringController(UserManager userManager) {
        this.userManager = userManager;
    }


}
