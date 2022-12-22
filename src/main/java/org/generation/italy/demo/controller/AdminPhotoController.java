package org.generation.italy.demo.controller;

import java.util.List;
import java.util.Optional;

import org.generation.italy.demo.pojo.Category;
import org.generation.italy.demo.pojo.Photo;
import org.generation.italy.demo.pojo.Tag;
import org.generation.italy.demo.service.CategoryService;
import org.generation.italy.demo.service.PhotoService;
import org.generation.italy.demo.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

public class AdminPhotoController {
	
	
	@Autowired
	PhotoService photoService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	TagService tagService;
	
	
	@GetMapping("/index")
	public String indexPhotos(Model model,  
		@RequestParam(name = "query", required = false) 
		String query) {
		
		List<Photo> photos = query == null ? photoService.findAll() : photoService.findPhotoById(query);
 
		model.addAttribute("photos", photos);
		model.addAttribute("routeName", "foto");
		 
		return "admin-index";
	}
	
	
	@GetMapping("/show/{id}")
	public String showPhotos(@PathVariable("id") int id, Model model) {
		
		Optional<Photo> optPhoto = photoService.findPhotoById(id);
		Photo photo = optPhoto.get();
		
		model.addAttribute("photo", photo);
		
		model.addAttribute("routeName", "dettaglio foto");
		 
		return "admin-show";
	}
	
	
	@GetMapping("/create")
	public String createPizza(Model model) {
		Photo ph1 = new Photo();
		model.addAttribute("obj", ph1);
				
		List<Category> categories = categoryService.findAll(); 
		model.addAttribute("categories", categories);
		
		List<Tag> tags = tagService.findAll();
		model.addAttribute("tgs", tags);

		model.addAttribute("routeName", "create");
		model.addAttribute("element", "photo");
		model.addAttribute("type", "Crea");
		model.addAttribute("action", "store");
		
		return "admin-edit_create";
	}
	
	
	@PostMapping("/store")
	public String storePhoto(@Valid @ModelAttribute("photo")
								Photo photo,
								BindingResult bindingResult, 
								RedirectAttributes redirectAttributes) {

		
		if(bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
			return "redirect:/admin/photo/create";
		}
		redirectAttributes.addFlashAttribute("successMsg", "Creazione avvenuta con successo");
	

		photoService.save(photo);
		
		return "redirect:/admin/photo/index";
	}
	
	
	@GetMapping("/edit/{id}")
	public String editPizza(@PathVariable("id") int id, Model model) {
		
		List<Category> categories = categoryService.findAll(); 
		model.addAttribute("categories", categories);
		
		List<Tag> tags = tagService.findAll();
		model.addAttribute("tgs", tags);
		
		Photo optPhoto = photoService.findPhotoById(id).get();
		model.addAttribute("obj", optPhoto);

		model.addAttribute("routeName", "edit");
		model.addAttribute("element", "photo");
		model.addAttribute("type", "Modifica");
		model.addAttribute("action", "update");
		
		return "admin-edit_create";
	}
	@PostMapping("/update")
	public String updatePhoto(@Valid @ModelAttribute("photo") 
								Photo photo, 
								BindingResult bindingResult, 
								RedirectAttributes redirectAttributes) {
	

		if(bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
			return "redirect:/admin/photo/edit/" + photo.getId();
		}
		
		redirectAttributes.addFlashAttribute("successMsg", "Modifica avvenuta con successo");
		

		photoService.save(photo);
		
		return "redirect:/admin/photo/index";
	}
	
	
	@GetMapping("/delete/{id}")
	public String deletePizza(@PathVariable("id") int id) {
		
		photoService.deletePhotoById(id);

		return "redirect:/admin/photo/index";
	}
}

