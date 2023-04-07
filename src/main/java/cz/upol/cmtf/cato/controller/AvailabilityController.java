package cz.upol.cmtf.cato.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/api/")
public class AvailabilityController {
	
	
	@CrossOrigin(origins = "*")
	@GetMapping("test")
	public String test() {
		return "Hello, we are available!";
	}
}
