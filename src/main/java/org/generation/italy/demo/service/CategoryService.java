package org.generation.italy.demo.service;

import java.util.List;

import org.generation.italy.demo.pojo.Category;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class CategoryService {

	@Autowired
	private CategoryService categoryRepo;
	
	public void save(Category categories) {
		categoryRepo.save(categories);
	}
		
	public List<Category> findAll() {
		return categoryRepo.findAll();
	}
	
	public Category findCategoryById(int id) {
		return categoryRepo.findById(id).get();
	}
	
	public void deleteCategoryById(int id) {
		categoryRepo.deleteById(id);
	}
	
	@Transactional
	public List<Category> findAllCategories() {
		
		List<Category> categories = categoryRepo.findAll();
		
		for (Category cat : categories) {
			Hibernate.initialize(cat.getPhotos());
		}
		
		return categories;
	}
}

