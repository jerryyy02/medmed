package com.cts.medcrateplus.service;

import java.util.List;

import com.cts.medcrateplus.bean.Login;

public interface LoginService {

	public String getUserType(String userId);
	public Login authenticate(String userName, String password);
	public List<Login> getAllDoctors();
	public List<Login> getAllByBloodGroup();
	public List<Login> searchGroupByValues(String search_value);
	public String unavailableDoctor(String userId);
}
