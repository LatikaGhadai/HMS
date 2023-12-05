package com.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.entity.UserInfo;
import com.hms.request.AuthRequest;
import com.hms.service.JwtService;
import com.hms.service.UserInfoService;

@RestController
@RequestMapping("/auth")
public class UserInfoController {
	

	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private UserInfoService userInfoService;
	
	@PostMapping("/signup")
	public ResponseEntity<String>saveUser(@RequestBody UserInfo userInfo){
		String saveUser = userInfoService.saveUser(userInfo);
		return new ResponseEntity<>(saveUser,HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public String authentcationgetToken(@RequestBody AuthRequest authRequest) {
		return jwtService.generateToken(authRequest.getUsername());
	}

}
