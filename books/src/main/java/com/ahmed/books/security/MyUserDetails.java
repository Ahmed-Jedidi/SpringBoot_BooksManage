package com.ahmed.books.security;

import java.util.Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.ahmed.books.entities.User;

public class MyUserDetails implements UserDetails {
	private String username;
	private String password;
	private Boolean enabled;
	private List<GrantedAuthority> authorities;
	private User user;

	public MyUserDetails() {
	}

	public MyUserDetails(String username) {
		this.username = username;
	}

	public MyUserDetails(User user) {
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.enabled = user.getEnabled();
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> auths = new ArrayList<>();
		this.user.getRoles().forEach(role -> {
			GrantedAuthority auhority = new SimpleGrantedAuthority("ROLE_" + role.getRole());

			auths.add(auhority);
		});
		return auths;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
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
		return this.enabled;
	}
}