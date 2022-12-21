package org.generation.italy.demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.generation.italy.demo.pojo.Category;
import org.generation.italy.demo.pojo.Photo;
import org.generation.italy.demo.pojo.Role;
import org.generation.italy.demo.pojo.Tag;
import org.generation.italy.demo.pojo.User;
import org.generation.italy.demo.service.CategoryService;
import org.generation.italy.demo.service.PhotoService;
import org.generation.italy.demo.service.RoleService;
import org.generation.italy.demo.service.TagService;
import org.generation.italy.demo.service.UserService;
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
	
		CategoryService.save(c1);
		categoryService.save(c2);
		
		photoService.save(p1);
		photoService.save(p2);
		

		Tag t1 = new Tag("animali");
		Tag t2 = new Tag("fiori");
		
		
		TagService.save(t1);
		TagService.save(t2);
		
		Role admin = new Role("ADMIN");
		Role user = new Role("USER");

		RoleService.save(admin);
		RoleService.save(user);
		
		Set<Role> userAdmin = new HashSet<>();		
		userAdmin.add(user);
		userAdmin.add(admin);

		User userUser = new User("user", "{noop}pwd", user);
		User adminUser = new User("admin", "{noop}pwd2", admin);
		User usAd = new User("userAdmin", "{noop}pwd3", userAdmin);
	
		UserService.save(userUser);
		UserService.save(adminUser);
		UserService.save(usAd);
		
		
	}

}
	
	
