package com.bitMiners.pdf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
    @RequestMapping(value = {"/", "", "/welcome"}, method = RequestMethod.GET)
    public String getWelcomePage() {
        return "welcome";
    }
}
