package com.cgi.sp.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// @Entity(name="blogs")
public class Blog {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="blog_id")
	int blogId;
	
	@Column(name="blog_title")
	String blogTitle;
	
	@Column(name="author_name")
	String authorName;
	
	@Column(name="blog_content")
	String blogContent;
	
	
	public Blog(int blogId, String blogTitle, String authorName, String blogContent) {
		super();
		this.blogId = blogId;
		this.blogTitle = blogTitle;
		this.authorName = authorName;
		this.blogContent = blogContent;
	}
	
	
	public Blog() {
		super();
	}


	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	public String getBlogTitle() {
		return blogTitle;
	}
	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getBlogContent() {
		return blogContent;
	}
	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}
	
	
	
}
