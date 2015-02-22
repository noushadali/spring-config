package org.lenzi.spring.sample.service;

import java.io.Serializable;

import org.lenzi.spring.sample.repository.PersonRepository;
import org.lenzi.spring.sample.repository.model.Person;
import org.lenzi.spring.sample.stereotype.InjectLogger;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service for interacting with people resources.
 * 
 * @author slenzi
 */
@Service
public class PersonServiceImpl implements PersonService, Serializable {
	
	@InjectLogger
	private Logger logger;
	
	@Autowired
	private PersonRepository personRepository;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1544545899210198256L;

	public PersonServiceImpl() {
		
	}

	@Override
	public Person getPersonById(int id) {
		
		logger.info("Fetching person by id = " + id);
		
		//if(personRepository.haveEntityManager()){
		//	logger.debug("Have entity manager = " + personRepository.haveEntityManager());
		//	personRepository.debugEntityManager();
		//}
		
		return personRepository.getPersonById(id);
	}

}
