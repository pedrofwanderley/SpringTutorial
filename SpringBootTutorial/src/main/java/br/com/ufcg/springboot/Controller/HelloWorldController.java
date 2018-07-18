package br.com.ufcg.springboot.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class HelloWorldController {
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String helloWorld() {
		return "Redin 10 em leda";
	}
}