package edu.unm.cs564.movierental.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.unm.cs564.movierental.model.VknsSpriden;
import edu.unm.cs564.movierental.service.exception.ServiceException;
import edu.unm.cs564.movierental.service.impl.UserService;
import edu.unm.cs564.movierental.service.impl.VknsSpridenService;
import edu.unm.cs564.movierental.service.support.dto.User;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Resource(name="userService")
	private UserService userService;
	
	@Autowired
	VknsSpridenService service1;

	/*
	 * This method will list all existing employees.
	 */
/*//	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	@ResponseBody
	@RequestMapping(value = { "/", "/list" }, headers="Accept=application/json", produces= MediaType.APPLICATION_JSON_VALUE)
	public List<VknsSpriden> listEmployees(ModelMap model) {

//		List<Employee> employees = service.findAllEmployees();
////		model.addAttribute("employees", employees);
////		return "allemployees";
//		return employees;
		
		List<VknsSpriden> spridens = service1.findAllSpridens();
//		model.addAttribute("employees", employees);
//		return "allemployees";
		return spridens;	
	}*/
	

	@RequestMapping("/list")
	public @ResponseBody List<VknsSpriden> listEmployees(ModelMap model) {
		List<VknsSpriden> spridens = service1.findAllSpridens();
		return spridens;	
	}
	
	@RequestMapping("/listallusers")
	public @ResponseBody List<User> listAllUsers(){
		List<User> usersList = new ArrayList<User>();
		usersList = userService.queryForAll();
		return usersList;
	}
	
	@RequestMapping(value="/adduser", method = RequestMethod.POST)
	public @ResponseBody String addUser(@RequestBody User users){
		boolean saved = userService.save(users);
		if(saved){
			return "{\"status\" : \"success\"}";
		} else {
			return "{\"status\" : \"failure\"}";
		}
	}
	
	@RequestMapping(value="/updateuser", method = RequestMethod.POST)
	public @ResponseBody String updateUser(@RequestBody User users){
		boolean updated = userService.update(users);
		if(updated){
			return "{\"status\" : \"success\"}";
		} else {
			return "{\"status\" : \"failure\"}";
		}
	}
	
	@RequestMapping(value="/checkemail", method = RequestMethod.GET)
	public @ResponseBody String updateUser(@RequestParam String emailId){
		boolean exists = false;
		try {
			exists = userService.checkEmail(emailId);
		} catch (ServiceException e) {
			//Do Nothing
		}
		if(exists){
			return "{\"status\" : \"exists\"}";
		} else {
			return "{\"status\" : \"notexists\"}";
		}
	}
}
