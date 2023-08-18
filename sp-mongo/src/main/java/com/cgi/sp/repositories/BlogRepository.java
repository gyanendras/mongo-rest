package com.cgi.sp.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.cgi.sp.domain.Blog;
import com.cgi.sp.domain.Employee;

public interface BlogRepository extends MongoRepository<Blog, Integer>{
	 Iterable<Blog> findByAuthorName(String authorName);
	 void deleteByBlogTitle(String blogTitle);	

}
