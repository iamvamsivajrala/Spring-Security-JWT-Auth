package com.jwt.auth.securityConfig;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.jwt.auth.entity.UsersData;
import com.jwt.auth.repo.UsersRepo;

@Component
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UsersRepo usersRepo;
	
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		
		Optional<UsersData>  user=usersRepo.findByName(name);
		
		return user.map(UsersDataToUsersDetails::new)
		.orElseThrow(()->new UsernameNotFoundException("user not found"+name));
		
	}

}
