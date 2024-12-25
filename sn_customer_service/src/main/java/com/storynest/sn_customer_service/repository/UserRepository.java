package com.storynest.sn_customer_service.repository;

import com.storynest.sn_customer_service.userEntity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findByUserName(String userName);
    Optional<User> findByEmail(String email);
    List<User> findAll();
}
