package com.maxtrain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/Users")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping(path="/Add")
	public @ResponseBody String addUser(@RequestBody User user) {
		userRepository.save(user);
		return "Added";	
	}
	
	@GetMapping(path="/Create")
	public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email) {
		User n = new User();
		n.setName(name);
		n.setEmail(email);
		userRepository.save(n);
		return "Saved";
	}
	
	@GetMapping(path="/List")
	public @ResponseBody Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}
}
