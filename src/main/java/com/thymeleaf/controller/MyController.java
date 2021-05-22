package com.thymeleaf.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

	@GetMapping("/about")
//	@ResponseBody
	public String about(Model model) {
//		System.out.println("about page");
		model.addAttribute("name", "Mizan");
		model.addAttribute("date", new Date().toLocaleString());
		return "about";
	}

	// hanlde iteration
	@GetMapping("/itarate")
	public String iterateHandler(Model model) {
		List<String> names = List.of("dilruba", "Monket", "sapla", "ibrahim", "foyez");
		model.addAttribute("names", names);
		return "iterate";
	}

	// handle condition
	@GetMapping("/condition")
	public String condition(Model model) {
		model.addAttribute("isActive", true);
		model.addAttribute("gender", "F");
		List<Integer> nums = List.of(3);
		model.addAttribute("list", nums);

		return "condition";

	}

	// handler for including fragements
	@GetMapping("/service")
	public String serciceHandler(Model model) {
		model.addAttribute("title","I like to eat nuts!");
		model.addAttribute("subtitle",LocalDate.now().toString());
		return "service";
	}
	@GetMapping("/newAbout")
	public String newAbout() {
		return "newAbout";
	}
	@GetMapping("/child")
	public String child() {
		return "child";
	}
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
	@GetMapping("/example")
	public String example() {
		return "example";
	}
}
