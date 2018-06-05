package com.opencodez.controller;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.opencodez.dao.mysql.domain.TblMysql;
import com.opencodez.dao.mysql.repo.MysqlMessageRepo;
import com.opencodez.dao.oracle.domain.TblOracle;
import com.opencodez.dao.oracle.repo.OracleMessageRepo;

@RestController
public class HomeController {

	@Autowired
	private OracleMessageRepo oracleMessageRepo;
	
	@Autowired
	private MysqlMessageRepo mysqlMessageRepo;	
	
	@Autowired
	@Qualifier("entityManagerFactory")
	private EntityManager oracleEM;
		
	@Autowired
	@Qualifier("mysqlEntityManager")
	private EntityManager mysqlEM;


	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/check/db/oracle", method = RequestMethod.GET)
	public ModelAndView testOracle(Map<String, Object> model) {

		List<TblOracle> messages = oracleMessageRepo.findAll();
		model.put("messages", messages);

		try {
			String sql = "select t from TblOracle t";
			Query query = oracleEM.createQuery(sql);
			List<TblOracle> list =(List<TblOracle>)query.getResultList( );
			
			model.put("messages2", list);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return new ModelAndView("index", model);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/check/db/mysql", method = RequestMethod.GET)
	public ModelAndView testMysql(Map<String, Object> model) {
		
		List<TblMysql> messages = mysqlMessageRepo.findAll();
		model.put("messages", messages);
		
		
		try {
			String sql = "select t from TblMysql t";
			Query query = mysqlEM.createQuery(sql);
			List<TblMysql> list=(List<TblMysql>)query.getResultList( );
			
			model.put("messages2", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ModelAndView("index", model);
	}

}
