package com.hms.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.entity.UserInfo;

public interface UserInfoRepo extends JpaRepository<UserInfo, Integer> {
	Optional<UserInfo>findByName(String name);

}
