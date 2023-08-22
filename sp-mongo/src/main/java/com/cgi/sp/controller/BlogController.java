package com.cgi.sp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.sp.domain.Blog;
import com.cgi.sp.services.BlogService;
import com.cgi.sp.services.IBlogService;

@RestController
public class BlogController {
	@Autowired
	IBlogService bs;
	
	/**
	 * Return all blogs
	 * @param blog
	 * @return
	 */
	@PostMapping("/blog")
	Blog createBlog(@RequestBody Blog blog){
		return bs.save(blog);
	}
	
	@GetMapping("/blog/{id}")
	Blog getBlog(@PathVariable int id){
		return bs.get(id);
	}
	
	@DeleteMapping("/blog/{id}")
	void delBlog(@PathVariable int id) {
		bs.delete(id);
	}
	
	@DeleteMapping("/blog/title/{title}")
	void delBlog(@PathVariable String title) {
		bs.delete(title);
	}
	
	
	// @PreAuthorize("ROLE_READ")
	@GetMapping("/blogs")
	Iterable<Blog> getAll(){
		return bs.getAll();
	}

	@GetMapping("/blogs/{name}")
	Iterable<Blog> getByAuthor(@PathVariable String name){
		return bs.getbyAuthor(name);
	}

}
