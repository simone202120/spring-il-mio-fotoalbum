package org.generation.italy.demo.service;

import java.util.List;

import org.generation.italy.demo.pojo.Tag;
import org.generation.italy.demo.repo.TagRepo;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class TagService {

	@Autowired
	private TagRepo tagRepo;
	
	public void save(Tag tags) {
		tagRepo.save(tags);
	}
		
	public List<Tag> findAll() {
		return tagRepo.findAll();
	}
	
	public Tag findTagById(int id) {
		return tagRepo.findById(id).get();
	}
	
	public void deleteTagById(int id) {
		tagRepo.deleteById(id);
	}
	
	@Transactional
	public List<Tag> findAllPhotos() {
		
		List<Tag> tags = tagRepo.findAll();
		
		for (Tag tag : tags) {
			Hibernate.initialize(tag.getPhotos());
		}
		
		return tags;
	}
}
