package com.herokuapp.insuranceSystem.controller;

import com.herokuapp.insuranceSystem.api.UserManager;
import org.springframework.beans.factory.annotation.Autowired;


public abstract class SpringController {

    protected final UserManager userManager;

    @Autowired
    public SpringController(UserManager userManager) {
        this.userManager = userManager;
    }


}
