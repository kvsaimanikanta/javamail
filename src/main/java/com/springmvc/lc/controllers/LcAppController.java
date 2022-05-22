package com.springmvc.lc.controllers;

import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springmvc.lc.dto.UserInfoDto;
import com.springmvc.lc.dto.UserSignupDto;
import com.springmvc.lc.propertyeditor.NamePropertyEditor;
import com.springmvc.lc.propertyeditor.UserNamePopertyEditor;
import com.springmvc.lc.service.LcAppCalulate;
import com.springmvc.lc.validater.EmailValidator;
import com.springmvc.lc.validater.UserNameValidator;

@Controller
@SessionAttributes({"userInfo"})
public class LcAppController {
	
	Logger logger = Logger.getLogger(LcAppController.class.getName());
	
	@Autowired
	private EmailValidator emailValidator;
	
	@Autowired
	private UserNameValidator nameValidator;
	
	@Autowired
	private LcAppCalulate appCalulate;

	/* By using model Interface
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage(Model model) {
		UserInfoDto userInfo = new UserInfoDto();
		model.addAttribute("userInfo", userInfo);
		return "home-page";
	}
	
	@RequestMapping(value = "/process-page")
	public String resultPage(Model model, UserInfoDto userInfoDto) {
		model.addAttribute("userInfo", userInfoDto);
		return "result-page";
	}
	*/
	
	// By using @ModelAttribute annotation
	@RequestMapping(value = "/")
	public String shoeHomePage(Model model) {
		
		model.addAttribute("userInfo", new UserInfoDto());
		
		return "home-page";
	}
	
	@RequestMapping(value = "/process-page")
	public String showResultPage(Model model, @Valid UserInfoDto userInfo, BindingResult result) {
		
		model.addAttribute("userInfo", userInfo);
		model.addAttribute(BindingResult.MODEL_KEY_PREFIX+"userInfo", result);
		
		//session.setAttribute("userName", userInfo.getYourName());
		
		//model.addAttribute("appResult", appResult);
		
		if(result.hasErrors()) {
			
			List<ObjectError> allErrors = result.getAllErrors();
			
			for(ObjectError error : allErrors) {
				System.out.println(error);
			}
			
			return "home-page";
		}
		
		userInfo.setResult(appCalulate.calulate(userInfo.getYourName(), userInfo.getCrushName()));
		
		return "result-page"; 
	}
	
	@RequestMapping(value = "/signup")
	public String showSignUpPage(@ModelAttribute("userSignup") UserSignupDto dto) {
		
//		Phone phone = new Phone();
//		phone.setCountryCode("91");
//		phone.setNumber("7674893321");
//		
//		CommunicationDto com = new CommunicationDto();
//		com.setPhone(phone);
//		
//		dto.setCommunicationDto(com);
		
		return "signup-page";
	}
	
	@RequestMapping(value = "/afterSignup")
	public String showAfterSignup(@Valid @ModelAttribute("userSignup") UserSignupDto dto, BindingResult result) {
		
		//UserNameValidator nameValidator = new UserNameValidator();
		nameValidator.validate(dto, result);
		
		//EmailValidator emailValidator= new EmailValidator();
		emailValidator.validate(dto, result);
		
		if(result.hasErrors()) {
			List<ObjectError> allErrors = result.getAllErrors();
			for(ObjectError error : allErrors) {
				System.out.println(error);
			}
			return "signup-page";
		}
		
		return "afterSignup";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		
		//binder.setDisallowedFields("userName");
		
		StringTrimmerEditor editor = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, "name", editor);
		
		NamePropertyEditor nameProprtEditor = new NamePropertyEditor();
		binder.registerCustomEditor(String.class, "name", nameProprtEditor);
		
//		UserNamePopertyEditor userNameProprtEditor = new UserNamePopertyEditor();
//		binder.registerCustomEditor(String.class, "yourName", userNameProprtEditor);
//		
//		CrushNamePopertyEditor crushNamePropertyEditor = new CrushNamePopertyEditor();
//		binder.registerCustomEditor(String.class, "crushName", crushNamePropertyEditor);
		
		
		
//		binder.addValidators(new UserNameValidator());
//		
//		binder.addValidators(new EmailValidator());
		
	}
	
}
