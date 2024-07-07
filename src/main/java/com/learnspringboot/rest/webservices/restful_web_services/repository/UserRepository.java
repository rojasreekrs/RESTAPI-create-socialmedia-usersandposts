package com.learnspringboot.rest.webservices.restful_web_services.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnspringboot.rest.webservices.restful_web_services.bean.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
