package outsidepack;

import org.springframework.web.bind.annotation.*;


@RestController
public class GreetOutsideController {
	
	@GetMapping ("outside") //url => "/"
	String greetOutside()
	{
		return "Hello From Outside App Package";
	}

}
