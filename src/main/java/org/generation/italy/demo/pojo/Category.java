package org.generation.italy.demo.pojo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


	
	@Table
	@Entity
	public class Category {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
		@Column(nullable = false, unique = true)
		@NotNull(message = "Il campo non può essee vuoto")
		@NotEmpty(message = "Il campo non può essee vuoto")
		private String name;
		
		@ManyToMany(mappedBy = "categories")
		private List<Photo> photos;

		
		public Category() { }
		public Category(String name) {
			setName(name);
		}

		public Category(String name, List<Photo> photos) {
			setName(name);
			setPhotos(photos);
		}

		public int getId() {
			return id;
		}

		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}

		public List<Photo> getPhotos() {
			return photos;
		}
		public void setPhotos(List<Photo> photos) {
			this.photos = photos;
		}
		
		@Override
		public String toString() {
			return "Category: " + getName();
		}
	
}
