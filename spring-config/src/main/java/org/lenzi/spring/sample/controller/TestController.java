/**
 * 
 */
package org.lenzi.spring.sample.controller;

import org.lenzi.spring.sample.properties.ManagedProperties;
import org.lenzi.spring.sample.repository.model.Person;
import org.lenzi.spring.sample.service.PersonService;
import org.lenzi.spring.sample.stereotype.InjectLogger;
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
    
    @Autowired
    PersonService personService;
    
    //@InjectLogger
    //Logger logger;

	@RequestMapping(method = RequestMethod.GET)
	public String printHello(ModelMap model) {
		
		logger.info("printHello called");
		
		StringBuffer buff = new StringBuffer();
		buff.append("Hello! This is the \"" + appProps.getAppTitle() + "\" application.");
		
		Person per = personService.getPersonById(1);
		if(per != null){
			buff.append(" Fetched " + per.getFirstName() + " " + per.getLastName() + " from the database.");
		}else{
			buff.append(" Failed to fetch person from database.");
		}
		
		model.addAttribute("message", buff.toString());
		
		return "/test/test.jsp";
	}

}
