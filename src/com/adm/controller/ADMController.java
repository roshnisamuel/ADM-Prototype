package com.adm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adm.service.States;
import com.adm.vo.State;

@Controller
@RequestMapping("/hello")
public class ADMController {

	@Autowired
	States states;
	
	
	@RequestMapping(method = RequestMethod.GET)
	   public String printHello(ModelMap model) {
	      model.addAttribute("message", "Hello Spring MVC Framework!");
	      List<State> stateList = states.asList();
	      model.addAttribute("size", stateList.size());
	      return "hello";
	   }
}
