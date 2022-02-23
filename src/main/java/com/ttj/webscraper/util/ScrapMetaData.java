package com.ttj.webscraper.util;

public class ScrapMetaData {

	String event;
	String applicationName;
	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	String startDate;

	//String endDate;
	String location;
	String otherInfo;

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}

	@Override
	public String toString() {
		return "ScrapMetaData [event=" + event + ", applicationName=" + applicationName + ", startDate=" + startDate
				+ ", location=" + location + ", otherInfo=" + otherInfo + "]";
	}

	

	
}
