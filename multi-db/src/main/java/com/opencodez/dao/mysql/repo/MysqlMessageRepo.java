package com.opencodez.dao.mysql.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.opencodez.dao.mysql.domain.TblMysql;

public interface MysqlMessageRepo extends JpaRepository<TblMysql, Long> {
}
