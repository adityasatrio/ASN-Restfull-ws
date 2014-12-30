package com.asn.ws.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asn.ws.model.Sample;

@Repository
public class SampleDaoImpl implements SampleDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Sample> getDao() {
		System.out.println(" called dao from service ");

		Session session = sessionFactory.getCurrentSession();
		
		//not work only sample
		Query query = session.getNamedQuery("getListData");
		
		return query.list();
	}

}
