package com.thymeleaf.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thymeleaf.entities.LoginData;

@Controller
public class FormValidationController {

	@GetMapping("/form")
	public String showForm(Model model) {
		model.addAttribute("loginData", new LoginData());
		return "form";
	}

	// handle form
	@PostMapping("/formSubmit")
//	@ResponseBody
	public String formSubmit(@Valid @ModelAttribute("loginData") LoginData loginData,BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			return "form";
		}
		System.out.println(loginData);
		return "success";

	}
}
