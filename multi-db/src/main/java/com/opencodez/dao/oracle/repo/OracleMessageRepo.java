package com.opencodez.dao.oracle.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.opencodez.dao.oracle.domain.TblOracle;

public interface OracleMessageRepo extends JpaRepository<TblOracle, Long> {
}
