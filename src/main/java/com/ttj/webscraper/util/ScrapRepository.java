package com.ttj.webscraper.util;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ttj.webscraper.model.ScrapData;

public interface ScrapRepository extends JpaRepository<ScrapData, Long> {
	
	
	
 
}