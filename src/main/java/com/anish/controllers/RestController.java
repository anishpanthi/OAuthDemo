package com.anish.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anish.models.User;
import com.anish.services.DataService;

@Controller
@RequestMapping("/check/users")
public class RestController {

	@Autowired
	DataService dataService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public List<User> list() {
		return dataService.getUserList();

	}
}
