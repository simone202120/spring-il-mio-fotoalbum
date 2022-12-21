package org.generation.italy.demo.service;

import java.util.List;
import java.util.Optional;

import org.generation.italy.demo.Security.DatabaseUserDetails;
import org.generation.italy.demo.pojo.User;
import org.generation.italy.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	private UserRepo userRepo;

	
	public void save(User user) {
		userRepo.save(user);
	}

	public void delete(User user) {
		userRepo.delete(user);
	}

	public void deleteById(int id) {
		userRepo.deleteById(id);
	}
	
	public List<User> findAll() {
		return userRepo.findAll();
	}
	
	public Optional<User> findById(int id) {
		return userRepo.findById(id);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> userOpt = userRepo.findByUsername(username);
	
		if (userOpt.isEmpty()) throw new UsernameNotFoundException("Utente non trovato");
		
		return new DatabaseUserDetails(userOpt.get());	
	}
}
