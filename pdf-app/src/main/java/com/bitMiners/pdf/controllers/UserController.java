package com.bitMiners.pdf.controllers;

import com.bitMiners.pdf.domain.Authority;
import com.bitMiners.pdf.domain.Profile;
import com.bitMiners.pdf.domain.User;
import com.bitMiners.pdf.domain.types.AuthorityType;
import com.bitMiners.pdf.repositories.AuthorityRepository;
import com.bitMiners.pdf.services.ProfileService;
import com.bitMiners.pdf.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

@Controller
@RequestMapping("/users")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private AuthorityRepository authorityRepository;

    @RequestMapping(value = {"/list", ""})
    public String users(Model model) {
        model.addAttribute("userList", userService.getAllUsers());
        return "allUsers";
    }

    @RequestMapping(value = "/signupForm", method = RequestMethod.GET)
    public String addUser(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("url", "signup");
        return "addUser";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String addUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
            return "addUser";
        }

        User dbUser = this.userService.getUserByUsername(user.getUsername());

        if (dbUser != null) return "redirect:/signupForm";

        user.setProfile(new Profile());
        user.setDateCreated(new Date());

        // set user authorities
        Set<Authority> authorities = Collections.singleton(this.authorityRepository.findByName(AuthorityType.ROLE_USER));
        user.setAuthorities(authorities);

        userService.addUser(user);
        return "redirect:/login";
    }

    @RequestMapping(value = "/addAdminForm", method = RequestMethod.GET)
    public String addAdmin(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("admin", "admin");
        model.addAttribute("url", "addAdmin");
        return "addUser";
    }

    @RequestMapping(value = "/addAdmin", method = RequestMethod.POST)
    public String addAdmin(@ModelAttribute("user") User user) {
        user.setProfile(new Profile());
        user.setDateCreated(new Date());

        // set admin authorities
        Set<Authority> authorities = Collections.singleton(this.authorityRepository.findByName(AuthorityType.ROLE_ADMIN));
        user.setAuthorities(authorities);

        userService.addUser(user);
        return "redirect:/users/adminList";
    }

    @RequestMapping(value = "/adminList", method = RequestMethod.GET)
    public String getAllAdmins(Model model) {
        model.addAttribute("userList", userService.getAllAdmins());
        return "allUsers";
    }


    @RequestMapping(value = "/{userId}/profile", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Profile getUserProfile(@PathVariable("userId") int userId) {
        LOGGER.info("getUserProfile(): userId -> {}", userId);
        return userService.getProfileByUserId(userId);
    }
}
