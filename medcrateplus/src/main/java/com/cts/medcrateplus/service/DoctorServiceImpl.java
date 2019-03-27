package com.cts.medcrateplus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cts.medcrateplus.bean.Login;
import com.cts.medcrateplus.dao.DoctorDAO;

@Service("DoctorService")
@Transactional(propagation=Propagation.SUPPORTS)
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	DoctorDAO doctorDAO;

	@Override
	public List<Login> searchDoctorByValues(String search_by, String search_value) {
		// TODO Auto-generated method stub
		System.out.println("in service");
		return doctorDAO.searchDoctorByValues(search_by, search_value);
	}

	@Override
	public List<Login> getAllDoctor() {
		// TODO Auto-generated method stub
		return doctorDAO.getAllDoctor();
	}

	@Override
	public Login viewDoctor(String userId) {
		// TODO Auto-generated method stub
		return doctorDAO.viewDoctor(userId);
	}

}
