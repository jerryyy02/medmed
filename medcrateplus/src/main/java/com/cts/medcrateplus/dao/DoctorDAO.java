package com.cts.medcrateplus.dao;

import java.util.List;

import com.cts.medcrateplus.bean.Login;
import com.cts.medcrateplus.bean.Medicine;

public interface DoctorDAO {
	public List<Login> searchDoctorByValues(String search_by, String search_value);
	public List<Login> getAllDoctor();
	public Login viewDoctor(String userId);
}
