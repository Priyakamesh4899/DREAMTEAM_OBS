package com.revature.bookproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.bookproject.model.User;

public interface UserJpaRepository extends JpaRepository<User,Integer>{

}
