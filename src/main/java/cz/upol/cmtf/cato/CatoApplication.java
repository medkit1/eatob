package cz.upol.cmtf.cato;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CatoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatoApplication.class, args);
	}
	
	@GetMapping("/hello")
	public String hello() {
		return String.format("Hello World!");
	}

}
