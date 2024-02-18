package vw.mohak.usermicro;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@GetMapping("/greet")
	String greetUser()
	{
		return "Hi user from port 8001";
	}
	
	@GetMapping("/greetByName")
	String greetByParams (@RequestParam (name = "name") String userName)
	{
		return "Hi " + userName + " from port 8001";
	}

}
