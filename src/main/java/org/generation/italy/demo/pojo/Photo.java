package org.generation.italy.demo.pojo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Table
@Entity
public class Photo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique = true, nullable = false )
	@NotNull(message = "Il campo non può essee vuoto")
	@NotEmpty(message = "Il campo non può essee vuoto")
	private String title;
	
	@Column(nullable = true)
	private String description;
	
	
	@Column(unique = true, nullable = false )
	@NotNull(message = "Il campo non può essee vuoto")
	@NotEmpty(message = "Il campo non può essee vuoto")
	private String url;
	
		
	@Column(nullable = false )
	@NotNull(message = "Il campo non può essee vuoto")
	private boolean visible;
	
	
	private String tag;
	
	private List<Category> categories; 
	
	public Photo() { }
	
	public Photo(String title, String description, String url, boolean visible) {
		setTitle(title);
		setDescription(description);
		setUrl(url);
		setVisible(visible);
	}
	
	public Photo(String title, String description, String url,boolean visible, List<Category> categories) {
		setTitle(title);
		setDescription(description);
		setUrl(url);
		setVisible(visible);
		setCategories(categories);
	}
	
	
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	

	@Override
	public String toString() {
		return "Nome foto: " + getTitle() + "Id: " + getId() + "Url: " + getUrl();

	}
}
