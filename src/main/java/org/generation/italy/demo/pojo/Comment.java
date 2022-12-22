package org.generation.italy.demo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class Comment {
	 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	

	@NotNull(message = "Il campo non può essere vuoto")
	@NotEmpty(message = "Il campo non può essere vuoto")
	@Lob
	private String content;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="photo_id", nullable=true)
	private Photo photo;
	
	
	
	public Comment() { }
	public Comment(Photo photo, String content) {
		setPhoto(photo);
		setContent(content);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public Photo getPhoto() {
		return photo;
	}
	public void setPhoto(Photo photo) {
		this.photo = photo;
	}
	
	@Override
	public String toString() {
		return "Commento: " + getContent()
				+ "Foto associata: " + getPhoto();
	}
}