package edu.umsl.cs4520.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import edu.umsl.cs4520.model.News;


public interface NewsRepository extends Repository<News, Integer> {
	Page<News> findAll(Pageable pageable);

	Page<News> findBySourceContainingAndTitleContainingAllIgnoringCase(String source,
			String title, Pageable pageable);

	News findBySourceAndTitleAllIgnoringCase(String source, String title);
	
	void delete(News news);
	
	News save(News news);
	
	Optional<News> findOne(Integer id);

}
