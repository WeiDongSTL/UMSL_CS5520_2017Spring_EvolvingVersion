package edu.umsl.cs4520.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import edu.umsl.cs4520.model.News;

public interface NewsService {

	Page<News> findAllNews(Pageable pageable);

	News getNews(String source, String title);

	News getNewsById(int id);
	
	News saveNews(News news);
	
	void delete(News news);

	//Page<HotelSummary> getHotels(News news, Pageable pageable);

}
