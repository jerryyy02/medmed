package com.cts.medcrateplus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cts.medcrateplus.bean.Login;
import com.cts.medcrateplus.dao.LoginDAO;

@Service("loginService")
@Transactional(propagation=Propagation.SUPPORTS)
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	LoginDAO loginDAO ;

	public Login authenticate(String userName, String password) {
		// TODO Auto-generated method stub
		return loginDAO.authenticate(userName, password);
	}

	@Override
	public String getUserType(String userId) {
		// TODO Auto-generated method stub
		return loginDAO.getUserType(userId);
	}

	@Override
	public List<Login> getAllDoctors() {
		// TODO Auto-generated method stub
		return loginDAO.getAllDoctors();
	}

	@Override
	public List<Login> getAllByBloodGroup() {
		// TODO Auto-generated method stub
		return loginDAO.getAllByBloodGroup();
	}

	@Override
	public List<Login> searchGroupByValues(String search_value) {
		// TODO Auto-generated method stub
		return loginDAO.searchGroupByValues(search_value);
	}

	@Override
	public String unavailableDoctor(String userId) {
		// TODO Auto-generated method stub
		return loginDAO.unavailableDoctor(userId);
	}
	
}
