package com.bitMiners.pdf.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.bitMiners.pdf.domain.Profile;
import com.bitMiners.pdf.service.ProfileService;


@Controller
public class ProfileController {
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
		model.addAttribute("profile", profileService.getProfile(id));
		return "profile";
	}
	
//	@RequestMapping(value="/profile/{id}", method=RequestMethod.POST)
//	public String setProfile(@ModelAttribute("profile") Profile profile,BindingResult bindingResult,
//			@RequestParam(value = "image", required = false) MultipartFile image){
//		String filename = "c:\\pdf_data\\" + profile.getFirstName() + profile.getId() + image.getOriginalFilename(); 
//		File file = new File(filename);
//				 
//		try {
//			FileUtils.writeByteArrayToFile(file, image.getBytes());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("-----------/profile/  method=POST");
//		System.out.println(profile.toString());
//		profileService.updateProfile(profile);
//		return "redirect:/profile/{id}";
//	}
	
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
		model.addAttribute("profile", profileService.getProfile(id));
		return "profile";
	}
	
	@RequestMapping(value="/profile/edit/{currentUserId}",method=RequestMethod.POST)
	public String editProfile(@Valid @ModelAttribute("profile") Profile profile,BindingResult result, @PathVariable("currentUserId") int id){
		//add code here to edit the profile
		if(result.hasErrors()){
			return "profile";
		}
		
		return "redirect:/profile/"+id;
	}
	
}
