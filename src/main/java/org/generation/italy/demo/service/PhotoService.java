package org.generation.italy.demo.service;

import java.util.List;
import java.util.Optional;

import org.generation.italy.demo.pojo.Photo;
import org.generation.italy.demo.repo.PhotoRepo;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class PhotoService {
	
	@Autowired
	private PhotoRepo photoRepo;
	
	public Photo save(Photo photo) {
		return photoRepo.save(photo);
	}
		
	public List<Photo> findAll() {
		return photoRepo.findAll();
	}
	
	public Optional<Photo> findPhotoById(int id) {
		return photoRepo.findById(id);
	}
	
	public void deletePhoto(Photo photo) {
		photoRepo.delete(photo);
	}
	public void deletePhotoById(int id) {
		photoRepo.deleteById(id);
	}
	
	public List<Photo> findByName(String name) {
		return photoRepo.findByNameContainingIgnoreCase(name);
	}
	
	@Transactional
	public List<Photo> findAllPhotoCategory() {
		
		List<Photo> photos = photoRepo.findAll();
		
		for (Photo photo : photos) {
			Hibernate.initialize(photo.getCategories());
		}
		
		return photos;
	}
}
