package org.lenzi.spring.sample.service;

import org.lenzi.spring.sample.repository.model.Person;

/**
 * Person service interface.
 * 
 * @author slenzi
 */
public interface PersonService {

	/**
	 * Fetch person by id
	 * 
	 * @param id - the person id
	 * @return Person object
	 */
	public Person getPersonById(int id);
	
}
