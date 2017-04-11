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
 * 
 * ---------------------------------------
 * 				Controller
 * '@Controller' here indicates that the class 
 * is going to be used as a controller for the 
 * application. '@RequestMapping' tells that 
 * the method will behave certain action for the 
 * 'url pattern'. Whenever a request pattern matches  
 * the pattern specified in '@RequestMapping' 
 * the code written in related method will be 
 * executed. Here you can see that each action 
 * is returning an object of 'ModelAndView' class. 
 * 'ModelAndView' class offers a number of things 
 * to the application, the very first parameter 
 * passed to it represents the name of view 
 * (required jsp file) that is going to be rendered 
 * after completion of action's code. The second 
 * parameter serves as a String value key for 
 * the object at third parameter. With these 
 * capabilities we can send an object to a view 
 * associated with a key. 
 */

package edu.umsl.cs5520.controller;


import java.util.ArrayList;


//import java.util.Date;
//import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.umsl.cs5520.model.News;
import edu.umsl.cs5520.model.NewsList;
import edu.umsl.cs5520.service.NewsService;

@Controller
public class NewsController {

	@Autowired
	private NewsService newsService;
	
	@Value("${application.message:Hello World}")
	private String message = "Hello World";

	@GetMapping("/")
	public String welcome() {
		return "welcome";
	}
    @RequestMapping(value = "/inputNews", method = RequestMethod.GET)
    public ModelAndView inputNews(
            @ModelAttribute News news,
            BindingResult result) {
        return new ModelAndView("inputNews");
    }

    @RequestMapping(value = "/saveNews", method = RequestMethod.POST)
    @Transactional(readOnly = false)
    public ModelAndView saveNews(
            @ModelAttribute News news,
            BindingResult result) {
    	this.newsService.saveNews(news);
    	System.out.println(news);
        return new ModelAndView("inputNews");
    }
    @RequestMapping(value = "/showSavedNews", method = RequestMethod.GET)
    public ModelAndView showSavedNews(
            @ModelAttribute("newsList") ArrayList<News> newsList,
            BindingResult result) {
    	newsList = new ArrayList<>();
		System.out.println("newsList = " + newsList);
		for (News n : this.newsService.findAllNews(new PageRequest(0, 100)).getContent()) {
			newsList.add(n);
			
		}
        return new ModelAndView("showSavedNews", "newsList", newsList);
    }

    @RequestMapping(value = "/searchNews", method = RequestMethod.GET)
    public ModelAndView searchNews(
            @ModelAttribute NewsList newsList,
            BindingResult result) {

        return new ModelAndView("searchNews", "newsList", newsList);
    }
    
    @RequestMapping(value = "/searchResult", method = RequestMethod.GET)
    public ModelAndView searchResult(
            @ModelAttribute NewsList newsList,
            BindingResult result) {

        return new ModelAndView("searchResult", "newsList", newsList);
    }
    
    @RequestMapping(value = "/toDelNews", method = RequestMethod.GET)
    public ModelAndView toDelNews(
            @ModelAttribute News news,
    		BindingResult result) {
    	return new ModelAndView("delNews");
    }

    @RequestMapping(value = "/delNews", method = RequestMethod.POST)
    public ModelAndView delNews(
            @ModelAttribute News news,
            BindingResult result) {
    	news = this.newsService.getNewsById(news.getId());
    	this.newsService.delete(news);
        return new ModelAndView("delNews", "news", news);
    }


}
