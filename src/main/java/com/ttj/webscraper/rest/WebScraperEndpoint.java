package com.ttj.webscraper.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ttj.webscraper.model.ScrapData;
import com.ttj.webscraper.service.WebScraperService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")

public class WebScraperEndpoint {
	
	@Autowired
	WebScraperService scraperService;
	
	@ApiOperation(value = "Search articles by author name")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success response"),
            @ApiResponse(code = 401, message = "Resource not authorized"),
            @ApiResponse(code = 403, message = "Access forbidden"),
            @ApiResponse(code = 404, message = "Resource not found")
    }
    )

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/events", method = RequestMethod.GET, produces = "application/json")
	public List<ScrapData> listEvents() {
		return scraperService.findAllEvents();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/events/{id}", method = RequestMethod.GET, produces = "application/json")
	public ScrapData getEvent(@PathVariable Long id) {
		return scraperService.findById(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/events/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public void deleteEvent(@PathVariable Long id) {
		 scraperService.deleteEvent(id);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/events/update-event/{id}", method = RequestMethod.PUT, produces = "application/json")
	public void updateEvent(@RequestBody ScrapData scrapData,@PathVariable Long id) {
		scrapData.setId(id);
		 scraperService.updateEvents(scrapData);
	}
}
