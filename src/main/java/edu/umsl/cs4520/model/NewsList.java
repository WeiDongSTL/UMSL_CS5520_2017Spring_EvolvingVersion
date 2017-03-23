package edu.umsl.cs4520.model;

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
