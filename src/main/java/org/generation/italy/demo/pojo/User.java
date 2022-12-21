package org.generation.italy.demo.pojo;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table
public class User {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	@NotNull
	@NotEmpty
	private String username;
	
	@Column(nullable = false)
	@NotNull
	@NotEmpty
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Role> roles;
	
	
	public User() {	}
	public User(String name, String password, Role role) {
		setUsername(name);
		setPassword(password);
		addRole(role);
	}
	public User(String name, String password, Set<Role> role) {
		setUsername(name);
		setPassword(password);
		setRoles(role);
	}
	

	public int getId() {
		return id;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public void addRole(Role role) {
		
		if (getRoles() == null) {
			roles = new HashSet<>();
		}
		getRoles().add(role);
	}
	
	
	@Override
	public String toString() {
		return "\nUsername: " + getUsername() 
				+ " | Id: " + getId() 
				+ "\nPassword: " + getPassword();
	}
}