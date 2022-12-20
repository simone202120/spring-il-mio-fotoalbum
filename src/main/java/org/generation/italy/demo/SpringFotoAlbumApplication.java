package org.generation.italy.demo;

import java.util.ArrayList;
import java.util.List;

import org.generation.italy.demo.pojo.Category;
import org.generation.italy.demo.pojo.Photo;
import org.generation.italy.demo.service.CategoryService;
import org.generation.italy.demo.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringFotoAlbumApplication implements CommandLineRunner {
	
	@Autowired
	private PhotoService photoService;

	@Autowired
	private CategoryService categoryService;

	public static void main(String[] args) {
		SpringApplication.run(SpringFotoAlbumApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category c1 = new Category("nome");
		Category c2 = new Category("nome");
		
		
		List<Category> categoryL1 = new ArrayList<>(); 
		categoryL1.add(c1);
		categoryL1.add(c2);
		
		
		Photo p1 = new Photo("TestNome", "description", "testUrl", true, categoryL1);
		Photo p2 = new Photo("TestNome", "description", "testUrl", true, categoryL1);
		
		
		System.out.println(p1);
		System.out.println(p2);
		
		System.out.println(c1);
		System.out.println(c2);
	
		categoryService.save(c1);
		categoryService.save(c2);
		
		photoService.save(p1);
		photoService.save(p2);
	}
	
	
}