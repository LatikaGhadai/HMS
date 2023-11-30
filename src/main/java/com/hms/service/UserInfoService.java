package com.hms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hms.entity.UserInfo;
import com.hms.repo.UserInfoRepo;


@Service
public class UserInfoService {
	@Autowired
	private UserInfoRepo userInfoRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public String saveUser(UserInfo userInfo) {
		userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		userInfoRepo.save(userInfo);
		return "User Saved Successfully";
	}

}
