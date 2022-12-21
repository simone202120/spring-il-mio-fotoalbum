package org.generation.italy.demo.Security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.generation.italy.demo.pojo.Role;
import org.generation.italy.demo.pojo.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class DatabaseUserDetails implements UserDetails {

	private static final long serialVersionUID = -5507256022415469811L;
	
	private final User user;
	
	public DatabaseUserDetails(User user) {
		this.user = user;
	}
	
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
		Set<GrantedAuthority> grantRole = new HashSet<>();
		Set<Role> roles = user.getRoles();
		
		for (Role role : roles) 
			grantRole.add(new SimpleGrantedAuthority(role.getName()));
		
		return grantRole;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
}
