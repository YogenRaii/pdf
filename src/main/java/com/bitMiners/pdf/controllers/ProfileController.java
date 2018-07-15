package com.bitMiners.pdf.controllers;

import com.bitMiners.pdf.domain.Profile;
import com.bitMiners.pdf.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.*;


@Controller
public class ProfileController {
    static final String rPath = "/resource/images/portrait";
    @Autowired
    private ProfileService profileService;

    @RequestMapping(value = "/profile/{id}", method = RequestMethod.GET)
    public String getProfile(@PathVariable int id, Model model) {
        try {
            model.addAttribute("profile", profileService.getProfile(id));
        } catch (Exception e) {
            return "error-forbidden";
        }
        return "profile";
    }

    @RequestMapping(value = "/profile/portrait/{id}", method = RequestMethod.POST)
    public String setPortrait(@ModelAttribute("profile") Profile profile, BindingResult bindingResult,
                              @RequestParam(value = "image", required = false) MultipartFile image,
                              HttpSession session, ServletRequest request) throws FileNotFoundException {

        byte[] bytes;
        try {
            bytes = image.getBytes();


            String rootPath = session.getServletContext().getRealPath("/") + rPath;
            File dir = new File(rootPath);
            if (!dir.exists())
                dir.mkdirs();
            String fileName = profile.getId() + "_" + image.getOriginalFilename();
            File serverFile = new File(dir.getAbsolutePath()
                    + File.separator + fileName);
            BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream(serverFile));
            stream.write(bytes);
            stream.close();
            profile.setPortrait("/pdf" + rPath + File.separator + fileName);
            Profile newProfile = profileService.getProfile(profile.getId());
            newProfile.setPortrait(profile.getPortrait());
            profileService.updateProfile(newProfile);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return "redirect:/profile/{id}";
    }

    @RequestMapping(value = "/profile/{id}", method = RequestMethod.POST)
    public String setProfile(@Valid @ModelAttribute("profile") Profile profile, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "profile";
        }
        profileService.updateProfile(profile);
        return "redirect:/profile/{id}";
    }

    @RequestMapping(value = "/profile/edit/{currentUserId}", method = RequestMethod.GET)
    public String editProfile(@PathVariable("currentUserId") int id,
                              @ModelAttribute("profile") Profile profile, Model model, HttpSession session) {
        int userId = (Integer) session.getAttribute("userId");
        if (userId != id) {
            return "redirect:/profile/" + id;
        }
        model.addAttribute("operation", "edit");
        model.addAttribute("profile", profileService.getProfile(id));
        return "profile";
    }

    @RequestMapping(value = "/profile/edit/{currentUserId}", method = RequestMethod.POST)
    public String editProfile(@Valid @ModelAttribute("profile") Profile profile, BindingResult result,
                              @PathVariable("currentUserId") int id, HttpSession session) {
        //add code here to edit the profile
        if (result.hasErrors()) {
            return "profile";
        }
        int userId = (Integer) session.getAttribute("userId");
        if (userId != id) {
            return "redirect:/profile/" + id;
        }
        Profile oldProfile = profileService.getProfile(id);
        profile.setId(id);
        profile.setPortrait(oldProfile.getPortrait());
        profileService.updateProfile(profile);
        return "redirect:/profile/" + id;
    }

}
