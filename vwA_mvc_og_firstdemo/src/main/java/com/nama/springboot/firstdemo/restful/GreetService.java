package com.nama.springboot.firstdemo.restful;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nama.springboot.firstdemo.model.HelloWorldBean;

//@RestController = @Controller + @ResponseBody
//@Controller

@RestController
public class GreetService {
	
	
	@Value("${name}")
	String myname;
	
	@GetMapping("greet")
	public String greetAll()
	{
		return "Hello Everyone!";
	}
	
	
	@GetMapping("greet1/{msg}")
	public String greetMsg(@PathVariable String msg)
	{
		System.out.println("msg="+msg+","+myname);
		return msg+","+myname;
	}
	
	@GetMapping("greet2")
	public String greetByName(@RequestParam String name)
	{
		System.out.println("name="+name);
		return "Hi "+name;
	}
	
	@GetMapping("greet3")
	public String greetByName(@RequestParam String name,@RequestParam String surname)
	{
		System.out.println(name+","+surname);
		return "Hi "+name+" "+surname;
	}
	
	@GetMapping("greet4/{surname}")
	public String greetByName1(@RequestParam String name,@PathVariable String surname)
	{
		System.out.println(name+","+surname);
		return "Hi "+name+" "+surname;
	}
	
	//object bean --> json format
	/*
	 * {
			message:"Hi Folks!",
			nousers:5
		}
	
}
	 */
	@GetMapping("sayhi")
	public HelloWorldBean getMessage()
	{
		return new HelloWorldBean("Hi Folks!",5);
	}
	
	@PostMapping("sethellobean")
	public String setHelloBean(@RequestBody HelloWorldBean b)
	{
		System.out.println(b.getMessage());
		System.out.println(b.getNousers());
		
		return "you have sent message as:"+b.getMessage()+" with no of users:"+b.getNousers();
	}

    
}
