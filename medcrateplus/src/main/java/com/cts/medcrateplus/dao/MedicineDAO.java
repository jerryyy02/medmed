package com.cts.medcrateplus.dao;

import java.util.List;

import com.cts.medcrateplus.bean.Medicine;

public interface MedicineDAO {

	public List<Medicine> getAllMedicine();
	public String deleteMedicine(String medId);
	public List<Medicine> getAllMedicineByLowToHigh(String order);
	public List<Medicine> getAllMedicineByHighToLow(String order);
	public String blockMedicine(String medId);
	public List<Medicine> getMedicineByStatus();
	public String insertMedicine(Medicine medicine);
	public List<Medicine> searchMedicineByValues(String search_by, String search_value);
}
