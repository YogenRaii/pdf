package com.bitMiners.pdf.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bitMiners.pdf.domain.Profile;
import com.bitMiners.pdf.service.ProfileService;


@Controller
public class ProfileController {
	static final String rPath = "/resource/images/portrait";
	@Autowired
	private ProfileService profileService;
	
	/*@RequestMapping(value="/profile", method=RequestMethod.GET)
	public String getDefaultProfile(Model model){
		System.out.println("-----------/defaultprofile/"+1);
		model.addAttribute("profile", profileService.getProfile(1));
		return "profile";
	}*/
	
	@RequestMapping(value="/profile/{id}", method=RequestMethod.GET)
	public String getProfile(@PathVariable int id, Model model){
		System.out.println("-----------/profile/"+id);
		System.out.println(profileService.getProfile(id).toString());
		model.addAttribute("profile", profileService.getProfile(id));
		return "profile";
	}
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value="/profile/portrait/{id}", method=RequestMethod.POST)
	public String setportrait(@ModelAttribute("profile") Profile profile,BindingResult bindingResult,
			@RequestParam(value = "image", required = false) MultipartFile image,
			HttpSession session, ServletRequest request) throws FileNotFoundException{
		
		byte[] bytes;
		try {
			bytes = image.getBytes();
			

			String rootPath = session.getServletContext().getRealPath("/") + rPath;
			System.out.println("rootPath = " + rootPath);
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
			profile.setPortrait("/pdf"+ rPath + File.separator + fileName);
			Profile newProfile = profileService.getProfile(profile.getId());
			newProfile.setPortrait(profile.getPortrait());
			profileService.updateProfile(newProfile);
			System.out.println("Go to the location:  " + serverFile);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//		System.out.println("-----------/setProfile/  method=POST");
//		String filename = "../"+ profile.getId() + image.getOriginalFilename(); 
//		File file = new File(filename);
//		System.out.println("-----------/setProfile/  fileName" + filename);		 
//		try {
//			FileUtils.writeByteArrayToFile(file, image.getBytes());
//			System.out.println("Go to the location:  " + file.toString()
//			+ " on your computer and verify that the image has been stored.");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("-----------/setProfile/  method=POST");
//		System.out.println(profile.toString());
//		profileService.updateProfile(profile);
		return "redirect:/profile/{id}";
	}
	
	@RequestMapping(value="/profile/{id}",method=RequestMethod.POST)
	public String setProfile(@Valid @ModelAttribute("profile") Profile profile,BindingResult result, Model model){
		System.out.println("-----------/profile/  method=POST");
		System.out.println(profile.toString());
		
		if(result.hasErrors()){
			return "profile";
		}
		profileService.updateProfile(profile);
		return "redirect:/profile/{id}";
	}
	
	@RequestMapping(value="/profile/edit/{currentUserId}",method=RequestMethod.GET)
	public String editProfile(@PathVariable("currentUserId") int id,@ModelAttribute("profile") Profile profile,Model model){
		model.addAttribute("operation", "edit");
		System.out.println(profileService.getProfile(id).toString());
		model.addAttribute("profile", profileService.getProfile(id));
		return "profile";
	}
	
	@RequestMapping(value="/profile/edit/{currentUserId}",method=RequestMethod.POST)
	public String editProfile(@Valid @ModelAttribute("profile") Profile profile,BindingResult result, @PathVariable("currentUserId") int id){
		//add code here to edit the profile
		if(result.hasErrors()){
			return "profile";
		}
		
		Profile oldProfile = profileService.getProfile(id); 
		profile.setId(id);
		profile.setPortrait(oldProfile.getPortrait());
		profileService.updateProfile(profile);
		return "redirect:/profile/"+id;
	}
	
}
