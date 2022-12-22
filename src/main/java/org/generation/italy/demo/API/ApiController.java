package org.generation.italy.demo.API;

import java.util.List;

import org.generation.italy.demo.pojo.Category;
import org.generation.italy.demo.pojo.Photo;
import org.generation.italy.demo.service.CategoryService;
import org.generation.italy.demo.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public class ApiController {
	
	
	@Autowired
	private PhotoService photoService;
	
	@Autowired
	private CategoryService categoryService;
	
	
	@GetMapping("/index")
	public List<Photo> getPhotos() {

		return photoService.findAll();
		
	}
	
	
	@RequestMapping("/get/{id}") 
	public List<Photo> getCategoriesPhoto(@PathVariable("id") int id) {
		
		Category c = categoryService.findCategoryById(id);
		
		List<Photo> photo = c.getPhotos();
		
		if (photo.isEmpty()) {
			return null;
		}

		return photo;
	}

	
	@GetMapping("/search/{query}")
	public List<Photo> searchPhotoByTitleOrTag(@PathVariable("query") String q) {
		
		List<Photo> photos = (q == null) ? 
								photoService.findAll() : 
								photoService.findByTitleOrTag(q);
		
		return photos;
 	}
}
