package org;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloAppController
{
	@RequestMapping("/Welcome")
	public ModelAndView welcome()
	{
		return new ModelAndView("welcome","message","Welcome to the first web App");
	}
	
}
