package com.example.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.security.model.TUser;
import com.example.security.repository.TUserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired 
	private TUserRepository tUserRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		TUser user = tUserRepository.findByUsername(username);
        if (user == null) 
            throw new UsernameNotFoundException(username);        
        return new MyUserDetails(user);
	}

}
