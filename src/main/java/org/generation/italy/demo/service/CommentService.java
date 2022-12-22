package org.generation.italy.demo.service;

import java.util.List;

import org.generation.italy.demo.pojo.Comment;
import org.generation.italy.demo.repo.CommentRepo;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class CommentService {

	@Autowired
	private CommentRepo commentRepo;
	
	public void save(Comment comment) {
		commentRepo.save(comment);
	}
		
	public List<Comment> findAll() {
		return commentRepo.findAll();
	}
	
	public Comment findCommentById(int id) {
		return commentRepo.findById(id).get();
	}
	
	public void deleteCommentById(int id) {
		commentRepo.deleteById(id);
	}
	
	@Transactional
	public List<Comment> findAllPhotos() {
		
		List<Comment> comments = commentRepo.findAll();
		
		for (Comment com : comments) {
			Hibernate.initialize(com.getPhoto());
		}
		
		return comments;
	}
}
