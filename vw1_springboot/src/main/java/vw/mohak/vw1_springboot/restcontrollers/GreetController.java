package vw.mohak.vw1_springboot.restcontrollers;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController 
public class GreetController {
	Logger lg = LoggerFactory.getLogger(GreetController.class);
	
	@GetMapping  //url => "/"
	String greet()
	{
		lg.debug("Debug Msg");
		lg.info("Info Msg");
		lg.warn("Warn Msg");
		return "Hello Everyone";
	}
	
	@GetMapping ("{name}")
	String greetName(@PathVariable String name)
	{
		return "Hello " + name;
	}

}
