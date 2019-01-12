package com.bitMiners.pdf.controllers;

import com.bitMiners.pdf.domain.PdfUserDetails;
import com.bitMiners.pdf.domain.User;
import com.bitMiners.pdf.services.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

@SessionAttributes({"currentUser", "currentUserId"})
@Controller
public class LoginController {
    private static final Logger log = LogManager.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
    public String loginerror(Model model) {

        model.addAttribute("error", "true");
        return "login";
    }

    @RequestMapping("/error-forbidden")
    public String errorForbidden() {
        return "error-forbidden";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model model, SessionStatus session) {
        SecurityContextHolder.getContext().setAuthentication(null);
        session.setComplete();
        return "redirect:/welcome";
    }

    @RequestMapping(value = "/postLogin", method = RequestMethod.POST)
    public String postLogin(Model model, HttpSession session) {
        log.info("postLogin()");

        // read principal out of security context and set it to session
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        validatePrinciple(authentication.getPrincipal());
        User loggedInUser = ((PdfUserDetails) authentication.getPrincipal()).getUserDetails();

        model.addAttribute("currentUserId", loggedInUser.getId());
        model.addAttribute("currentUser", loggedInUser.getUsername());
        session.setAttribute("userId", loggedInUser.getId());
        return "redirect:/wallPage";
    }

    private void validatePrinciple(Object principal) {
        if (principal == null || !(principal instanceof PdfUserDetails)) {
            throw new  IllegalArgumentException("Principal can not be null!");
        }
    }
}
