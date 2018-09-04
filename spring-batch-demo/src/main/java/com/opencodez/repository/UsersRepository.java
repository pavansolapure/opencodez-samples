package com.opencodez.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.opencodez.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
