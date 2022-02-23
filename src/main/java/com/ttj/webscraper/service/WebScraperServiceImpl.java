package com.ttj.webscraper.service;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import com.ttj.webscraper.model.ScrapData;
import com.ttj.webscraper.util.ScappiUtil;
import com.ttj.webscraper.util.ScrapMetaData;
import com.ttj.webscraper.util.ScrapRepository;

@Service
public class WebScraperServiceImpl implements WebScraperService {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	
	

	@Autowired
	ScrapRepository sracpRepository;

	public WebScraperServiceImpl() {
	}

	@PostConstruct
	@Override
	public void loadContents() throws IOException {
		LOGGER.info("loadContents()...start");


		ScappiUtil scappiUtil = new ScappiUtil();

		ArrayList<ScrapMetaData> list = scappiUtil.ScappiUtilLink1();

		for (int i = 0; i < list.size(); i++) {
			ScrapMetaData scrapMdata = list.get(i);

			ScrapData scrapData = new ScrapData();
			scrapData.setEvent(scrapMdata.getEvent());
			scrapData.setApplicationName(scrapMdata.getApplicationName());
			//scrapData.setDescription(scrapMdata.getDescription());
			scrapData.setStartDate(scrapMdata.getStartDate());
			//scrapData.setEndDate(scrapMdata.getEndDate());
			scrapData.setLocation(scrapMdata.getLocation());

			sracpRepository.save(scrapData);

		}
		System.out.println(scappiUtil.ScappiUtilLink2());

		ArrayList<ScrapMetaData> list1 = scappiUtil.ScappiUtilLink2();

		for (int i = 0; i < list1.size(); i++) {
			ScrapMetaData scrapMdata = list1.get(i);

			ScrapData scrapData = new ScrapData();
			scrapData.setEvent(scrapMdata.getEvent());
			scrapData.setApplicationName(scrapMdata.getApplicationName());
			//scrapData.setDescription(scrapMdata.getDescription());
			scrapData.setStartDate(scrapMdata.getStartDate());
			//scrapData.setEndDate(scrapMdata.getEndDate());
			scrapData.setLocation(scrapMdata.getLocation());

			sracpRepository.save(scrapData);

		}

		LOGGER.info("loadContents()...completed");
	}

	@Override
	public List<ScrapData> findAllEvents() {
		
		return sracpRepository.findAll();
	}
	
	
	@Override
	public ScrapData findById(Long id) {
		
	Optional<ScrapData> data= sracpRepository.findById(id);
	ScrapData finalData=data.get();
	return finalData;
	
	
	
		
	
		
	}
	
	@Override
	public void deleteEvent(Long id) {
		
		 sracpRepository.deleteById(id);
	}
	
	@Override
	public void updateEvents(ScrapData data) {
		
	 sracpRepository.save(data);
		
	}

	
}
