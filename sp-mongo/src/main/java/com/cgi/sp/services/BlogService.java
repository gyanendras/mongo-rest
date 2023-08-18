package com.cgi.sp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.sp.domain.Blog;
import com.cgi.sp.repositories.BlogRepository;

@Service
public class BlogService implements IBlogService {
	
	@Autowired
	BlogRepository br;

	@Override
	public Blog save(Blog blog) {
		// TODO Auto-generated method stub
		return br.save(blog);
	}

	@Override
	public Blog get(int id) {
		// TODO Auto-generated method stub
		return br.findById(id).get();
	}

	@Override
	public void delete(int id) {
		br.deleteById(id);

	}

	@Override
	public Iterable<Blog> getAll() {
		// TODO Auto-generated method stub
		return br.findAll();
	}

	@Override
	public Iterable<Blog> getbyAuthor(String name) {
		// TODO Auto-generated method stub
		return br.findByAuthorName(name);
	}

}
