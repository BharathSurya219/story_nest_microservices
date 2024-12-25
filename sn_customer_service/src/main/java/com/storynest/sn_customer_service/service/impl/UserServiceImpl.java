package com.storynest.sn_customer_service.service.impl;

import com.storynest.sn_customer_service.enums.AccountStatus;
import com.storynest.sn_customer_service.enums.Roles;
import com.storynest.sn_customer_service.exception.UserAlreadyExistsException;
import com.storynest.sn_customer_service.repository.UserRepository;
import com.storynest.sn_customer_service.service.UserService;
import com.storynest.sn_customer_service.userDTO.UserDTO;
import com.storynest.sn_customer_service.userEntity.User;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserRepository repository;
	
	@Autowired
    private PasswordEncoder passwordEncoder;


	
	@Override
	public UserDTO createUser(UserDTO userDTO) {
        log.info("user dto which is registering with email:{}", userDTO.getEmail());
        User user = new User();
		Optional<User> optional = repository.findByUserName(userDTO.getUserName());
		if (optional.isPresent()) {
			throw new UserAlreadyExistsException("User is already present");
		}
		LocalDateTime date = LocalDateTime.now();
		userDTO.setAccountCreationDate(date);
		userDTO.setLastModified(date);
		userDTO.setLastPasswordUpdate(date);
		userDTO.setAccountStatus(AccountStatus.CREATED);
		userDTO.setRoles(Roles.USER);
		ModelMapper mapper = new ModelMapper();
		mapper.map(userDTO, user);
		user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		repository.save(user);
		userDTO.setId(user.getId());
		return userDTO;
	}

}
