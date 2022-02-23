package com.ttj.webscraper.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Optional;


import com.ttj.webscraper.model.ScrapData;

public interface WebScraperService {
	
	public void loadContents() throws MalformedURLException, IOException;

	public List<ScrapData> findAllEvents();
	void deleteEvent(Long id);
	void updateEvents(ScrapData data);
	ScrapData findById(Long id);
}
