package com.cgi.sp.services;

import com.cgi.sp.domain.Blog;

public interface IBlogService {
	
	Blog save(Blog blog);
	Blog get(int id);
	void delete(int id);
	Iterable<Blog> getAll();
	Iterable<Blog> getbyAuthor(String name);
	void delete(String str);
}
