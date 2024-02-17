package vw.mohak.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import vw.mohak.limitsservice.model.Limits;

@RestController
public class LimitsController {
	
	@Autowired
	private Limits limits;
	
	@GetMapping("/limits")
	public Limits getLimits()
	{
		return limits;
	}

}
