package org.lenzi.spring.sample.repository;

import java.io.Serializable;

import javax.persistence.Transient;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.lenzi.spring.sample.repository.model.Person;
import org.lenzi.spring.sample.repository.model.Person_;
import org.lenzi.spring.sample.stereotype.InjectLogger;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Repository for person data.
 * 
 * @author slenzi
 */
@Repository
@Transactional
public class PersonRepository extends AbstractRepository implements Serializable {

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = -5619951818085361996L;
	
	@InjectLogger
	private Logger logger;

	public PersonRepository() {
		
	}
	
	/**
	 * Fetch person by person ID.
	 * 
	 * @param id - The person ID.
	 * @return
	 */
	public Person getPersonById(int id){
		
		logger.info("Fetching person by person id = " + id);
		
		logger.info("Getting entity manager.");
		//EntityManager pgEm = getEntityManager();
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Person> query	= cb.createQuery(Person.class);
		Root<Person> root = query.from(Person.class);
		
		//Metamodel meta = getEntityManager().getMetamodel();
		//EntityType<Person> Per_ = meta.entity(Person.class);
	
		query.select(root).where(cb.equal(root.get(Person_.personId), id));
	
		Person p = null;
		try{
			
			logger.info("Running query.");
			p = entityManager.createQuery(query).getSingleResult();
			logger.info("Query execution complete.");
			
		} catch (NoResultException e){
			logger.error("Error querying person for person id " + id + ". " + e.getMessage());
			return null;
		}
		if(p == null){
			logger.warn("No person returned from database for person id " + id);
		}
		return p;
	}

}
