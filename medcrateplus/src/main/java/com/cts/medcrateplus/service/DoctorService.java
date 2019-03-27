package com.cts.medcrateplus.service;

import java.util.List;

import com.cts.medcrateplus.bean.Login;

public interface DoctorService {

	public List<Login> searchDoctorByValues(String search_by, String search_value);
	public List<Login> getAllDoctor();
	public Login viewDoctor(String userId);
}
