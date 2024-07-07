package com.learnspringboot.rest.webservices.restful_web_services.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnspringboot.rest.webservices.restful_web_services.bean.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{

}
