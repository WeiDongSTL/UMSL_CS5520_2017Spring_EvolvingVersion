/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package edu.umsl.cs4520.controller;


//import java.util.Date;
//import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.umsl.cs4520.model.News;
import edu.umsl.cs4520.model.NewsList;
import edu.umsl.cs4520.service.NewsService;

@Controller
public class NewsController {

	@Autowired
	private NewsService newsService;
	
	@Value("${application.message:Hello World}")
	private String message = "Hello World";

	@GetMapping("/")
	public String welcome() {
		//model.put("time", new Date());
		//model.put("message", this.message);
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
            @ModelAttribute NewsList newsList,
            BindingResult result) {
    	newsList.setNewsPage(this.newsService.findAllNews(new PageRequest(0, 100)));
    	Page<News> pages = newsList.getNewsPage();
		System.out.println("pages.hasNext(): " + pages.hasNext());
    	while(pages.hasNext()) {
    		newsList.addNewsList(pages.getContent());
    	}
    	for (News n : newsList.getNewsList()) {
    		System.out.println(n);
    	}
		System.out.println("In showSavedNews Method.");
		System.out.println(newsList.getNewsList());
        return new ModelAndView("showSavedNews");
    }

    @RequestMapping(value = "/searchNews", method = RequestMethod.POST)
    public ModelAndView searchNews(
            @ModelAttribute NewsList newsList,
            BindingResult result) {

        return new ModelAndView("searchNews", "newsList", newsList);
    }

}
