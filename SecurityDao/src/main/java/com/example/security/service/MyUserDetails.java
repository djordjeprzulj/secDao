package com.example.security.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.security.model.TUser;

public class MyUserDetails implements UserDetails {

	private TUser tUser;
	
	public MyUserDetails(TUser tUser) {
		this.tUser = tUser;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		ArrayList<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
		list.add(new GrantedAuthority() {			
			@Override
			public String getAuthority() {
				return tUser.getRole();
			}
		});
		return list;	
	}

	@Override
	public String getPassword() {
		return tUser.getPassword();
	}

	@Override
	public String getUsername() {
		return tUser.getUsername();
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