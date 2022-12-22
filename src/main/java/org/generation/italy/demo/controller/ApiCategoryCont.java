package org.generation.italy.demo.controller;

import java.util.List;

import org.generation.italy.demo.pojo.Category;
import org.generation.italy.demo.pojo.Photo;
import org.generation.italy.demo.service.CategoryService;
import org.generation.italy.demo.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/1/categories")
@CrossOrigin("*")
public class ApiCategoryCont {
	
	
	@Autowired
	PhotoService photoService;
	
	@Autowired
	CategoryService categoryService;
	
	
	@RequestMapping("/all") 
	public List<Category> getCategories() {
		
		return categoryService.findAll();
		
	}
	
	@RequestMapping("/get/{id}") 
	public List<Category> getPhotoCategories(@PathVariable("id") int id) {
		
		Photo photo = photoService.findPhotoById(id).get();
		
		List<Category> cat = photo.getCategories();
		
		if (cat.isEmpty()) {
			return null;
		}

		return cat;
	}
}