package com.storynest.sn_customer_service.repository;

import com.storynest.sn_customer_service.userEntity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    public Optional<User> findByUserName(String userName);
    public Optional<User> findByEmail(String email);
}
