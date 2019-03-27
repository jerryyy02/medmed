package com.cts.medcrateplus.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.medcrateplus.bean.Medicine;

@Repository("medicineDAO")
@Transactional
public class MedicineDAOImpl implements MedicineDAO {

	@Autowired
	private SessionFactory sessionFacotry;
	
	@Transactional
	public List<Medicine> getAllMedicine() {
		// TODO Auto-generated method stub
				Session session =null;
				String query="from Medicine";
				org.hibernate.query.Query<Medicine> query2 = null;
				session=sessionFacotry.getCurrentSession();
				query2=session.createQuery(query);
				List<Medicine> list=query2.getResultList();
				System.out.println(list);
				return list;
	}

	@Transactional
	public List<Medicine> getAllMedicineByLowToHigh(String order) {
		// TODO Auto-generated method stub
		Session session =null;
		String query;
		if(order.equals("LowToHigh")){
		query="from Medicine order by medId asc";
		}
		else{
			 query="from Medicine order by medId desc";
		}
		org.hibernate.query.Query<Medicine> query2 = null;
		session=sessionFacotry.openSession();
		query2=session.createQuery(query);
		List<Medicine> list=query2.getResultList();
		System.out.println(list);
		return list;
	}

	@Transactional
	public List<Medicine> getAllMedicineByHighToLow(String order) {
		// TODO Auto-generated method stub
		Session session =null;
		String query;
		if(order.equals("LowToHigh")){
		query="from Medicine where status='0' order by medId asc";
		}
		else{
			 query="from Medicine where status='0' order by medId desc";
		}
		org.hibernate.query.Query<Medicine> query2 = null;
		session=sessionFacotry.openSession();
		query2=session.createQuery(query);
		List<Medicine> list=query2.getResultList();
		System.out.println(list);
		return list;
	}

	@Transactional
	public String blockMedicine(String medId) {
		// TODO Auto-generated method stub
		Session session = null;
		String query="select status from Medicine where medId=?";
		org.hibernate.query.Query<String> query2 = null;
		session=sessionFacotry.getCurrentSession();
		query2=session.createQuery(query);
		query2.setParameter(0, medId);
		String medicine = query2.getSingleResult();
		System.out.println(medicine);
		Medicine medicine2= session.get(Medicine.class, medId);
		if(medicine.equals("0")){
			medicine2.setStatus("1"); 
			System.out.println(medicine2);
			session.saveOrUpdate(medicine2); 
		}
		if(medicine.equals("1")){
			medicine2.setStatus("0"); 
			System.out.println(medicine2);
			session.saveOrUpdate(medicine2); 
		}
		return null;
	}

	@Transactional
	public List<Medicine> getMedicineByStatus() {
		// TODO Auto-generated method stub
		Session session =null;
		String query="from Medicine where status='0'";
		org.hibernate.query.Query<Medicine> query2 = null;
		session=sessionFacotry.getCurrentSession();
		query2=session.createQuery(query);
		List<Medicine> list=query2.getResultList();
		return list;
	}

	@Transactional
	public String insertMedicine(Medicine medicine) {
		// TODO Auto-generated method stub
		Session session = null;
		session = sessionFacotry.getCurrentSession();
		session.save(medicine);
		medicine.setStatus("0");
		return "Success";
	}

	@Transactional
	public List<Medicine> searchMedicineByValues(String search, String search_value) {
		// TODO Auto-generated method stub
		Session session =null;
		String query;
		if("Salt Name".equals(search)){
		query="from Medicine where saltName=?";
		org.hibernate.query.Query<Medicine> query2 = null;
		session=sessionFacotry.openSession();
		query2=session.createQuery(query);
		query2.setParameter(0, search_value);
		List<Medicine> list=query2.getResultList();
		return list;
		}
		else if("Medicine Name".equals(search)){
	    query="from Medicine where medName=?";
	    org.hibernate.query.Query<Medicine> query2 = null;
		session=sessionFacotry.openSession();
		query2=session.createQuery(query);
		query2.setParameter(0, search_value);
		List<Medicine> list=query2.getResultList();
		return list;
		}
		else{
		query="from Medicine where brand=?";
		org.hibernate.query.Query<Medicine> query2 = null;
		session=sessionFacotry.openSession();
		query2=session.createQuery(query);
		query2.setParameter(0, search_value);
		List<Medicine> list=query2.getResultList();
		return list;
		}
	
	}

	@Transactional
	public String deleteMedicine(String medId) {
		// TODO Auto-generated method stub
		Session session = null;
		session=sessionFacotry.getCurrentSession();
		Medicine object = new Medicine();
		object.setMedId(medId);
		session.delete(object);
		return "sucess";
	}

}
