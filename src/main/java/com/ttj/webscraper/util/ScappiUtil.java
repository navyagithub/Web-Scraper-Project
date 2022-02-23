package com.ttj.webscraper.util;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

public class ScappiUtil{

	//public static void main(String[] args) throws IOException {

	public ArrayList<ScrapMetaData> ScappiUtilLink1() throws IOException
	{
		Document page = Jsoup.connect("https://www.techmeme.com/events").get();
		
		String applicationName= getapplicationName(page);
		
		
		Elements repositories = page.getElementsByClass("rhov");
		ArrayList<String> hyperLinks = new ArrayList<String>();
		// Node.attr(String key)
		// iterating and extracting
		for (Element e : repositories) {
			hyperLinks.add(e.html());
		}

		
		List<String> hyperLinks4 = new ArrayList<String>();

		String row;

		

		for (int i = 0; i < hyperLinks.size(); i++) {
			row = hyperLinks.get(i);
			hyperLinks4.addAll(lineTagSplitor(row));

		}

		System.out.println("hyperLinks4 >>" + hyperLinks4.size());
		ArrayList<ScrapMetaData> scrapMetaDatalist = new ArrayList<>();
		int counter = hyperLinks4.size();

		ScrapMetaData scrapMetaData = null;
		for (int i = 0; i < hyperLinks4.size(); i++) {

			if (counter == 3) {
				List<String> scapmetalList = hyperLinks4.stream().limit(counter).collect(Collectors.toList());
				System.out.println("scapmetalList"+scapmetalList+"  -----hyperLinks4  "+hyperLinks4);

				scrapMetaData = new ScrapMetaData();
				scrapMetaData.setApplicationName(applicationName);

				if(scapmetalList.get(0)!="#")
				{
					String str = scapmetalList.get(0);
					String[] cc = str.split("-");
					if(cc.length>1)
					{ //YYYY-MM-DD
						scrapMetaData.setStartDate(scapmetalList.get(0) );
						//scrapMetaData.setEndDate(scapmetalList.get(1) );
					}
					else
					{
						scrapMetaData.setStartDate(scapmetalList.get(0) );
					}
				
				}
				//doubt	
			if (scapmetalList.get(1).contains("<em style=")) {
					String str = htmlTagRepace(scapmetalList.get(1));
					scrapMetaData.setEvent(str);
				} else {
					scrapMetaData.setEvent(scapmetalList.get(1));
				}
				scrapMetaData.setLocation(scapmetalList.get(2));

				scrapMetaDatalist.add(scrapMetaData);

			}
			if (counter > 3) {
				List<String> scapmetalList = hyperLinks4.stream().limit(counter).collect(Collectors.toList());
				System.out.println("scapmetalList--"+scapmetalList);

				scrapMetaData = new ScrapMetaData();
				scrapMetaData.setApplicationName(applicationName);
				scrapMetaData.setLocation(scapmetalList.get(counter - 1));

				if (scapmetalList.get(counter - 2).contains("<em style=")) {
					String str = htmlTagRepace(scapmetalList.get(counter - 2));
					scrapMetaData.setEvent(str);
				} else {
					scrapMetaData.setEvent(scapmetalList.get(counter - 2));
				}
				
				
				scrapMetaData.setStartDate(scapmetalList.get(counter - 3));

				scrapMetaDatalist.add(scrapMetaData);
			}

			counter = counter - 3;
		}
	
		return scrapMetaDatalist;
	}
	
	
	private String getapplicationName(Document page) {
		String applicationName=null;
		Elements metaTags = page.getElementsByTag("meta");
		for (Element metaTag : metaTags) {
		    String name = metaTag.attr("name");
		    String content = metaTag.attr("content");
		    if(name.equalsIgnoreCase("application-name")) {
		    	applicationName=content;
		    	break;
		    }
		}
		return applicationName;
	}


	public ScappiUtil() {
	
	}

	public ArrayList<ScrapMetaData> ScappiUtilLink2() throws IOException
	{
		

			
			Document page = Jsoup.connect(
					"https://www.computerworld.com/article/3313417/tech-event-calendar-2020-upcoming-shows-conferences-and-it-expos.html")
					.get();

			String applicationName=getapplicationName(page);

			Elements repositories = page.getElementsByClass("tablesorter");
			// Elements repositories = page.getElementsByClass("rhov");
			ArrayList<String> hyperLinks = new ArrayList<String>();
			// Node.attr(String key)
			// iterating and extracting
			for (Element e : repositories) {
				hyperLinks.add(e.html());

				// hyperLinks.add("TR: " + e.);
				// hyperLinks.add("Link: " + e.attr("href"));
			}

			String[] myy = null;

			ArrayList<String> hyperLinks3 = new ArrayList<String>();

			String row;

			for (int i = 0; i < hyperLinks.size(); i++) {
				row = hyperLinks.get(i);

				myy = row.split("\n");

			}

			for (int i = 0; i < myy.length; i++) {

				// System.out.println("FFF" + i + ":" + myy[i]);

				if (myy[i].contains("<th><a href=")) {

					hyperLinks3.add(htmlTagRepace(myy[i]));

				}
				if (myy[i].contains("<td>")) {

					hyperLinks3.add(htmlTagRepace(myy[i]));

				}

			}
			// System.out.println(hyperLinks3);

			ArrayList<ScrapMetaData> scrapMetaDatalist = new ArrayList<>();
			int counter = hyperLinks3.size();

			ScrapMetaData scrapMetaData = null;
			for (int i = 0; i < hyperLinks3.size(); i++) {

				if (counter == 5) {
					List<String> scapmetalList = hyperLinks3.stream().limit(counter).collect(Collectors.toList());
					System.out.println("scapmetalList--"+scapmetalList);

					if (counter == 5) {
						scrapMetaData = new ScrapMetaData();
						scrapMetaData.setApplicationName(applicationName);
						scrapMetaData.setEvent(scapmetalList.get(0));
						//scrapMetaData.setDescription(scapmetalList.get(1));
						scrapMetaData.setStartDate(scapmetalList.get(2));
						//scrapMetaData.setEndDate(scapmetalList.get(3));
						scrapMetaData.setLocation(scapmetalList.get(4));
						scrapMetaDatalist.add(scrapMetaData);
					}
				}
				if (counter > 0) {
					List<String> scapmetalList = hyperLinks3.stream().limit(counter).collect(Collectors.toList());
					System.out.println("scapmetalList--"+scapmetalList);

					scrapMetaData = new ScrapMetaData();
					scrapMetaData.setEvent(scapmetalList.get(counter - 5));
					scrapMetaData.setApplicationName(applicationName);
					//scrapMetaData.setDescription(scapmetalList.get(counter - 4));
					scrapMetaData.setStartDate(scapmetalList.get(counter - 3));
					//scrapMetaData.setEndDate(scapmetalList.get(counter - 2));
					scrapMetaData.setLocation(scapmetalList.get(counter - 1));
					scrapMetaDatalist.add(scrapMetaData);
				}

				counter = counter - 5;
			}
			
		
		return scrapMetaDatalist;
	}

	public static String htmlTagRepace(String str) {

		String regex = "<(\"[^\"]*\"|'[^']*'|[^'\">])*>";

		Pattern patt = Pattern.compile(regex);
		Matcher matcher = patt.matcher(str);
		return str = matcher.replaceAll("");

	}

	public static List<String> lineTagSplitor(String row) {

		ArrayList<String> links = new ArrayList<String>();

		String[] myy = row.split("\n");

		for (int i = 0; i < myy.length; i++) 
		{

			if ((myy[i].trim().equals("<div></div></a>"))) {
				links.add("#");

			}

			if (!myy[i].contains("<div>") && (!myy[i].contains("</div>")) && (!myy[i].contains("<a href=")))

			{
				links.add(myy[i]);

			}

		}

		return links;

	}

	public static String DateForm(String strDate) {
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");

		// System.out.println("Converted String: " + strDate);
		return strDate = dateFormat.format(date);
	}
}