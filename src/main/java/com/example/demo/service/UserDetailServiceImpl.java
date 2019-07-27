package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.AuthUserDetail;
import com.example.demo.model.User;
import com.example.demo.repos.UserDetailRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService{

	@Autowired
	UserDetailRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> optUser = repo.findByuserName(username);
		optUser.orElseThrow(()->
		new UsernameNotFoundException("Username or password wrong"));
		UserDetails ud = new AuthUserDetail(optUser.get());
		
		new AccountStatusUserDetailsChecker().check(ud);
		return ud;
	}

}
