package com.jwt.auth.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwt.auth.entity.UsersData;

public interface UsersRepo extends JpaRepository<UsersData, Integer> {
	Optional<UsersData> findByName(String name);
}
