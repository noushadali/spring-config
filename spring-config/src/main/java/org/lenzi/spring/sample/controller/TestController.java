/**
 * 
 */
package org.lenzi.spring.sample.controller;

import org.lenzi.spring.sample.properties.ManagedProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author slenzi
 *
 * Test controller to make sure Spring MVC is working.
 */
@Controller
@RequestMapping("/test")
public class TestController {

	private Logger logger = LoggerFactory.getLogger(TestController.class);
	
    @Autowired
    private ManagedProperties appProps;	

	@RequestMapping(method = RequestMethod.GET)
	public String printHello(ModelMap model) {
		
		logger.info("printHello called");
		
		model.addAttribute("message", "Hello! This is the \"" + appProps.getAppTitle() + "\" application.");
		
		return "/test/test.jsp";
	}

}
