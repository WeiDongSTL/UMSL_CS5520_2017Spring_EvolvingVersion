/*Name: Wei Dong
 *Course: UMSL CS5520-2017Spring
 *Project: Power News Management System
 */

/* The purpose of the program is to develop 
 * a Java web application using Srping Boot,
 * Spring MVC, Spring Data JPA, PostgreSQL, 
 * and Maven to extract news from various 
 * sources.
 * 
 * Development of web-applications with the 
 * help of Spring MVC implies creation of 
 * several logical layers of architecture. 
 * Among the layers, service layer (via JPA)
 * is responsible for communication with a 
 * PostgreSQL database, which is used to store 
 * the news and related information. The program 
 * is mainly a Spring MVC application using 
 * annotations. A simple form with spring's 
 * tags is used to initiate the extraction 
 * request to the webpage, and after the data 
 * are received and parsed by Google API through
 * Javascript, they will be saved and persisted 
 * in a PostgreSQL database. 
 *  
 * For each news, these are properties need to 
 * store:
 * 
 * 1. the unique ID associated with the news,
 * 2. the name of source providing the news, 
 * 3. the title associated with the news,
 * and
 * 4. the content of the news.
 * 
 * Same news will be saved into the table 
 * only once, by checking its ID extracted 
 * from the page. After news has been 
 * put into the database, the news will 
 * be displayed on the current page at the 
 * lower part of the user interface.
 * 
 * Main technologies used are:
 * 1) Spring Boot 1.5
 * 2) Spring MVC 4
 * 3) Spring Data JPA
 * 4) PostgreSQL 7.4
 * 5) Maven 4
 * 6) JDK 1.8
 * 
 * Development IDE: Eclipse Mars (4.5.0)
 * Operation System: Ubuntu 12.04
 *----------------------------------
 * NewsList class represents a list of news on
 * a webpage saved into database.
 */

package edu.umsl.cs5520.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

/**
 * Created by dav on 3/19/17.
 */
public class NewsList {
    private Page<News> newsPage;
    private List<News> newsList = new ArrayList<>();
	private String url = "";

	public Page<News> getNewsPage() {
		return newsPage;
	}
	public void setNewsPage(Page<News> newsPage) {
		this.newsPage = newsPage;
	}
	public List<News> getNewsList() {
		return newsList;
	}
	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}
	public void addNewsList(List<News> newsList) {
		this.newsList.addAll(newsList);
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
    @Override
	public String toString() {
		return "NewsList [newsPage=" + newsPage + ", url=" + url + ", getNewsPage()=" + getNewsPage() + ", getUrl()="
				+ getUrl() + "]";
	}

}
