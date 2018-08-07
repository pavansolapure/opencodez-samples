/**
 * 
 */
package com.opencodez.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.opencodez.domain.UserModel;

/**
 * @author pavan.solapure
 *
 */
@Repository
public class GenericRepoImpl implements GenericRepo {
	
	@PersistenceContext
	private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see com.opencodez.repo.GenericRepo#getUserModel()
	 */
	@Override
	public List<UserModel> getUserModel() {

		String qry = "SELECT USER_ID as id, USER_NAME as name, salary as salary, 1 as total_records FROM MYUSERS";
		Query query = entityManager.createNativeQuery(qry,
				UserModel.class);

		@SuppressWarnings("unchecked")
		List<UserModel> daoDtolist = query.getResultList();
		
		return daoDtolist;
	}

}
