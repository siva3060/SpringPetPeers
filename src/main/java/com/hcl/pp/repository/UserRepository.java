package com.hcl.pp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.pp.Models.User;

public interface UserRepository extends JpaRepository<User,Integer> {

}
