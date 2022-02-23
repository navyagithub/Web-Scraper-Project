package com.ttj.webscraper.model;
import javax.persistence.*;
@Entity
@Table(name = "scrapdata")
public class ScrapData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "event", columnDefinition="TEXT")
	String event;
	
	
	
	@Column(name = "startDate")
	String startDate;
	
	@Column(name = "applicationName")
	String applicationName;
	
	
	@Column(name = "location")
	String location;

	public ScrapData(long id, String event, String applicationName, String startDate, String location) {
		super();
		this.id = id;
		this.event = event;
		//this.description = description;
		this.startDate = startDate;
	//	this.endDate = endDate;
		this.location = location;
		this.applicationName=applicationName;
	}
	
	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public ScrapData()
	{
		
	}

	
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	

	@Override
	public String toString() {
		return "ScrapData [id=" + id + ", event=" + event + ", startDate=" + startDate + ", applicationName="
				+ applicationName + ", location=" + location + "]";
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
