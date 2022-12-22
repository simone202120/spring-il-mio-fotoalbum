package org.generation.italy.demo.controller;

import java.util.List;
import java.util.Set;

import org.generation.italy.demo.pojo.Comment;
import org.generation.italy.demo.pojo.Photo;
import org.generation.italy.demo.service.CommentService;
import org.generation.italy.demo.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

public class ApiCommentContr {
	
	
	@Autowired
	PhotoService photoService;
	
	@Autowired
	CommentService commentService; 
	
	
	@RequestMapping("/all") 
	public List<Comment> getComment() {
		
		return commentService.findAll();
		
	}
	
	@RequestMapping("/get/{id}") 
	public Set<Comment> getPhotoComments(@PathVariable("id") int id) {
		
		Photo photo = photoService.findPhotoById(id).get();
		
		Set<Comment> com = photo.getComments();
		
		if (com.isEmpty()) {
			return null;
		}

		return com;
	}
	
	@PostMapping("/store/{id}") 
	public Comment storeComment(@PathVariable("id") int id, 
								@Valid @RequestBody 
								Comment comment) {
		
		Photo pht = photoService.findPhotoById(id).get();
		
		Comment newCom = new Comment(pht, comment.getContent());
		
		commentService.save(newCom);
		
		return newCom;
	}
}
