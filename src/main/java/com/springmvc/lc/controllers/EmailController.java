package com.springmvc.lc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.springmvc.lc.dto.EmailDto;
import com.springmvc.lc.dto.UserInfoDto;
import com.springmvc.lc.service.EmailServiceImpl;
import com.springmvc.lc.service.LcAppCalulate;

@Controller
public class EmailController {
	
	@Autowired 
	private EmailServiceImpl emailServiceImpl;

	@RequestMapping(value = "/sendEmail")
	public String sendEmail(@ModelAttribute("emailDto") EmailDto emailDto) {
		return "email-page";
	}
	
	@RequestMapping(value = "/emailProcess-page")
	public String processEmail(@SessionAttribute("userInfo") UserInfoDto userInfoDto,@ModelAttribute("emailDto") EmailDto emailDto) {
		
		emailServiceImpl.sendEmail(userInfoDto.getYourName(), userInfoDto.getCrushName(), emailDto.getUserEmail(),new LcAppCalulate().calulate(userInfoDto.getYourName(), userInfoDto.getCrushName()));
		return "email-process-page";
		
	}
	
}
