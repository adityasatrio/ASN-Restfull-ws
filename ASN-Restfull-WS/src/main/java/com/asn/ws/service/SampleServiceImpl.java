package com.asn.ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asn.ws.dao.SampleDao;
import com.asn.ws.model.Sample;

@Service
public class SampleServiceImpl implements SampleService {

	@Autowired
	private SampleDao sampleDao;

	@Override
	@Transactional(readOnly = true)
	public List<Sample> testingServiceToDao() {
		System.out.println("called service from controller ");

		return sampleDao.getDao();
	}

}
