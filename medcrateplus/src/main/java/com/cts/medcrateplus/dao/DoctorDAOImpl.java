package com.cts.medcrateplus.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.medcrateplus.bean.Login;
import com.cts.medcrateplus.bean.Medicine;

@Repository("doctorDAO")
@Transactional
public class DoctorDAOImpl implements DoctorDAO {
	
	@Autowired
	private SessionFactory sessionFacotry;

	@Transactional
	public List<Login> searchDoctorByValues(String search_by, String search_value) {
		// TODO Auto-generated method stub
		Session session =null;
		String query;
		if("By Name".equals(search_by)){
		query="from Login where userType='D' and firstName=?";
		org.hibernate.query.Query<Login> query2 = null;
		session=sessionFacotry.getCurrentSession();
		query2=session.createQuery(query);
		query2.setParameter(0, search_value);
		List<Login> list=query2.getResultList();
		System.out.println(list);
		return list;
		}
		else if("By Id".equals(search_by)){
	    query="from Login where userType='D' and userId=?";
	    org.hibernate.query.Query<Login> query2 = null;
		session=sessionFacotry.getCurrentSession();
		query2=session.createQuery(query);
		query2.setParameter(0, search_value);
		List<Login> list=query2.getResultList();
		return list;
		}
		else{
		query="from Login where userType='D' and specialisation=?";
		org.hibernate.query.Query<Login> query2 = null;
		session=sessionFacotry.openSession();
		query2=session.createQuery(query);
		query2.setParameter(0, search_value);
		List<Login> list=query2.getResultList();
		return list;
		}
	}

	@Transactional
	public List<Login> getAllDoctor() {
		// TODO Auto-generated method stub
		Session session =null;
		String query;
		query="from Login where userType='D'";
		org.hibernate.query.Query<Login> query2 = null;
		session=sessionFacotry.getCurrentSession();
		query2=session.createQuery(query);
		List<Login> list=query2.getResultList();
		System.out.println(list);
		return list;
	}

	@Transactional
	public Login viewDoctor(String userId) {
		// TODO Auto-generated method stub
		Session session = null;
		String query="from Login where userId=?";
		org.hibernate.query.Query<Login> query2 = null;
		session=sessionFacotry.openSession();
		query2=session.createQuery(query);
		query2.setParameter(0, userId);
		Login login = query2.getSingleResult();
		return login;
	}

}
