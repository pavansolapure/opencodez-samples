package com.opencodez.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.opencodez.domain.User;

public interface GenericPagingRepository extends JpaRepository<User, Integer>  {

}
