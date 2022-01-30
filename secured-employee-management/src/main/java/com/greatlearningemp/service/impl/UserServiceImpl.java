package com.greatlearningemp.service.impl;

import com.greatlearningemp.entity.User;
import com.greatlearningemp.repository.UserRepository;
import com.greatlearningemp.securityconfig.CustomUserDetails;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class UserServiceImpl implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User userFromDB = userRepository.getUserByUsername(username);
		if(Objects.isNull(userFromDB)) {
			throw new UsernameNotFoundException("Could not find user");
		}
		return new CustomUserDetails(userFromDB);
	}

}
