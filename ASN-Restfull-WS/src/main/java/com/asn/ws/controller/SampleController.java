package com.asn.ws.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.asn.ws.model.Sample;
import com.asn.ws.service.SampleService;
import com.asn.ws.util.Constants;

@RestController
public class SampleController {

	@Autowired
	private SampleService sampleService;

	private static final Logger logger = LoggerFactory
			.getLogger(SampleController.class);

	Map<Integer, Sample> sampleData = new HashMap<Integer, Sample>();

	@RequestMapping(value = "/rest/testService", method = RequestMethod.GET)
	public List<Sample> testService() {
		List<Sample> samples = sampleService.testingServiceToDao();
		return samples;
	}

	@RequestMapping(value = Constants.DUMMY_SAMPLE, method = RequestMethod.GET)
	public Sample getDummySamples() {
		logger.info("Start getDummySamplee");
		Sample sample = new Sample();
		sample.setId(9999);
		sample.setName("Dummy");
		sample.setCreatedDate(new Date());
		sampleData.put(9999, sample);
		return sample;
	}

	@RequestMapping(value = Constants.GET_SAMPLE, method = RequestMethod.GET)
	public Sample getSample(@PathVariable("id") int id) {
		logger.info("Start getEmployee. ID=" + id);

		return sampleData.get(id);
	}

	@RequestMapping(value = Constants.GET_ALL_SAMPLE, method = RequestMethod.GET)
	public List<Sample> getAllSample() {
		logger.info("Start getAllSamples .");
		List<Sample> samples = new ArrayList<Sample>();
		Set<Integer> sampleIdKeys = sampleData.keySet();
		for (Integer i : sampleIdKeys) {
			samples.add(sampleData.get(i));
		}
		return samples;
	}

	@RequestMapping(value = Constants.CREATE_SAMPLE, method = RequestMethod.POST)
	public Sample createSample(@RequestBody Sample sample) {
		logger.info("Start create sample.");
		sample.setCreatedDate(new Date());
		sampleData.put(sample.getId(), sample);
		return sample;
	}

	@RequestMapping(value = Constants.DELETE_SAMPLE, method = RequestMethod.PUT)
	public Sample deleteSample(@PathVariable("id") int id) {
		logger.info("Start deleteEmployee.");
		Sample sample = sampleData.get(id);
		sampleData.remove(id);
		return sample;
	}

}
