/**
 * 
 */
package com.example.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.entity.Example;

/**
 * The Class GenericRepositoryImpl.
 *
 * @author pavan.solapure
 */
@Repository
public class GenericRepositoryImpl implements GenericRepository {

	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;
	

	@Override
	public List<Example> getExamples() {
		
		String qry = "FROM Example";
		Query query = entityManager.createQuery(qry);

		@SuppressWarnings("unchecked")
		List<Example> exampleList = query.getResultList();
		
		return exampleList;
	}


	@Transactional
	@Override
	public void saveExample(Example ex) {
		entityManager.persist(ex);		
	}


}
