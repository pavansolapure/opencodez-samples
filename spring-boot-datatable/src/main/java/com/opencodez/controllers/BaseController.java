/**
 * 
 */
package com.opencodez.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.opencodez.domain.User;
import com.opencodez.domain.UserModel;
import com.opencodez.domain.pagination.DataTableRequest;
import com.opencodez.domain.pagination.DataTableResults;
import com.opencodez.domain.pagination.PaginationCriteria;
import com.opencodez.repo.GenericRepo;
import com.opencodez.repo.UserRepository;
import com.opencodez.util.AppUtil;

/**
 * @author pavan.solapure
 *
 */
@Controller
public class BaseController {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private GenericRepo genericRepo;
	
	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;
	
		
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView home(@RequestParam(value = "name", defaultValue = "World") String name) {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("userModel", new UserModel());
		List<UserModel> userList  = genericRepo.getUserModel();
		mv.addObject("userlist", userList);
		return mv;
	}
	
	@RequestMapping(value="/users/mysql", method=RequestMethod.GET)
	public String listUsers(Model model) {
		return "users_mysql";
	}
	
	@RequestMapping(value="/users/paginated/mysql", method=RequestMethod.GET)
	@ResponseBody
	public String listUsersPaginated(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		DataTableRequest<User> dataTableInRQ = new DataTableRequest<User>(request);
		PaginationCriteria pagination = dataTableInRQ.getPaginationRequest();
		
		String baseQuery = "SELECT USER_ID as id, USER_NAME as name, SALARY as salary, (SELECT COUNT(1) FROM MYUSERS) AS total_records  FROM MYUSERS";
		String paginatedQuery = AppUtil.buildPaginatedQuery(baseQuery, pagination);
		
		System.out.println(paginatedQuery);
		
		Query query = entityManager.createNativeQuery(paginatedQuery, UserModel.class);
		
		@SuppressWarnings("unchecked")
		List<UserModel> userList = query.getResultList();
		
		DataTableResults<UserModel> dataTableResult = new DataTableResults<UserModel>();
		dataTableResult.setDraw(dataTableInRQ.getDraw());
		dataTableResult.setListOfDataObjects(userList);
		if (!AppUtil.isObjectEmpty(userList)) {
			dataTableResult.setRecordsTotal(userList.get(0).getTotalRecords()
					.toString());
			if (dataTableInRQ.getPaginationRequest().isFilterByEmpty()) {
				dataTableResult.setRecordsFiltered(userList.get(0).getTotalRecords()
						.toString());
			} else {
				dataTableResult.setRecordsFiltered(Integer.toString(userList.size()));
			}
		}
		return new Gson().toJson(dataTableResult);
	}
	
	@RequestMapping(value="/users/oracle", method=RequestMethod.GET)
	public String listUsersOracle(Model model) {
		return "users";
	}
	
	@RequestMapping(value="/users/paginated/orcl", method=RequestMethod.GET)
	@ResponseBody
	public String listUsersPaginatedForOracle(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		DataTableRequest<User> dataTableInRQ = new DataTableRequest<User>(request);
		PaginationCriteria pagination = dataTableInRQ.getPaginationRequest();
		String baseQuery = "SELECT USER_ID as id, USER_NAME as name, SALARY as salary  FROM MYUSERS";
		String paginatedQuery = AppUtil.buildPaginatedQueryForOracle(baseQuery, pagination);
		
		System.out.println(paginatedQuery);
		
		Query query = entityManager.createNativeQuery(paginatedQuery, UserModel.class);
		
		@SuppressWarnings("unchecked")
		List<UserModel> userList = query.getResultList();
		
		DataTableResults<UserModel> dataTableResult = new DataTableResults<UserModel>();
		dataTableResult.setDraw(dataTableInRQ.getDraw());
		dataTableResult.setListOfDataObjects(userList);
		if (!AppUtil.isObjectEmpty(userList)) {
			dataTableResult.setRecordsTotal(userList.get(0).getTotalRecords()
					.toString());
			if (dataTableInRQ.getPaginationRequest().isFilterByEmpty()) {
				dataTableResult.setRecordsFiltered(userList.get(0).getTotalRecords()
						.toString());
			} else {
				dataTableResult.setRecordsFiltered(Integer.toString(userList.size()));
			}
		}
		return new Gson().toJson(dataTableResult);
	}
	
	@RequestMapping(value="/adduser", method=RequestMethod.POST)
	public String addUser(@ModelAttribute UserModel userModel, Model model) {
		if(null != userModel) {
			
			if(!AppUtil.isObjectEmpty(userModel.getId()) && 
					!AppUtil.isObjectEmpty(userModel.getName()) && 
					!AppUtil.isObjectEmpty(userModel.getSalary())) {
				
				User u = new User();
				u.setId(userModel.getId());
				u.setName(userModel.getName());
				u.setSalary(userModel.getSalary());
				userRepo.save(u);
			}
		}
		return "redirect:/";
	}

}
