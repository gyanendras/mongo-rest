package com.cgi.sp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cgi.sp.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
