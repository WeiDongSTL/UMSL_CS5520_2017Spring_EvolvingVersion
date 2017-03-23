package edu.umsl.cs4520.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import edu.umsl.cs4520.model.News;

@Component("newsService")
@Transactional
public class NewsServiceImpl implements NewsService {

	private final NewsRepository newsRepository;


	public NewsServiceImpl(NewsRepository newsRepository) {
		this.newsRepository = newsRepository;
	}


	@Override
	public Page<News> findAllNews(Pageable pageable) {
/*
		Assert.notNull(criteria, "Criteria must not be null");
		String name = criteria.getName();

		if (!StringUtils.hasLength(name)) {
			return this.newsRepository.findAll(null);
		}

		String country = "";
		int splitPos = name.lastIndexOf(",");

		if (splitPos >= 0) {
			country = name.substring(splitPos + 1);
			name = name.substring(0, splitPos);
		}*/

		return this.newsRepository.findAll(new PageRequest(0, 100));
	}

	@Override
	public News getNews(String source, String title) {
		return this.newsRepository.findBySourceAndTitleAllIgnoringCase(source, title);
	}

	@Override
	public News saveNews(News news) {
		return this.newsRepository.save(news);
	}

	@Override
	public void delete(News news) {
		this.newsRepository.delete(news);
	}

}

