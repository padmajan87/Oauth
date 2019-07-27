package com.example.demo.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public interface UserDetailRepository extends JpaRepository<User,Integer> {
	Optional<User> findByuserName(String name);
}
