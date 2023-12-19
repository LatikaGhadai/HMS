package com.hms.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.hms.entity.UserInfo;
import com.hms.repo.UserInfoRepo;

@Component
public class CostumUserDetailService implements UserDetailsService {
	@Autowired
	private UserInfoRepo userInfoRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserInfo> userName = userInfoRepo.findByName(username);
		return userName.map(CostumUserDetails::new).orElseThrow(()->new UsernameNotFoundException("User Not Found"+username));

	}

}
