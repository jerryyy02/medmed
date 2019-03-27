package com.cts.medcrateplus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cts.medcrateplus.bean.Medicine;
import com.cts.medcrateplus.dao.MedicineDAO;

@Service("MedicineService")
@Transactional(propagation=Propagation.SUPPORTS)
public class MedicineServiceImpl implements MedicineService {

	@Autowired
	MedicineDAO medicineDAO;
	@Override
	public List<Medicine> getAllMedicine() {
		// TODO Auto-generated method stub
		return medicineDAO.getAllMedicine();
	}
	@Override
	public List<Medicine> getAllMedicineByLowToHigh(String order) {
		// TODO Auto-generated method stub
		return medicineDAO.getAllMedicineByLowToHigh(order);
	}
	@Override
	public List<Medicine> getAllMedicineByHighToLow(String order) {
		// TODO Auto-generated method stub
		return medicineDAO.getAllMedicineByHighToLow(order);
	}
	@Override
	public String blockMedicine(String medId) {
		// TODO Auto-generated method stub
		return medicineDAO.blockMedicine(medId);
	}
	@Override
	public List<Medicine> getMedicineByStatus() {
		// TODO Auto-generated method stub
		return medicineDAO.getMedicineByStatus();
	}
	@Override
	public String insertMedicine(Medicine medicine) {
		// TODO Auto-generated method stub
		return medicineDAO.insertMedicine(medicine);
	}
	@Override
	public List<Medicine> searchMedicineByValues(String search_by, String search_value) {
		// TODO Auto-generated method stub
		return medicineDAO.searchMedicineByValues(search_by, search_value);
	}
	@Override
	public String deleteMedicine(String medId) {
		// TODO Auto-generated method stub
		return medicineDAO.deleteMedicine(medId);
	}

}
