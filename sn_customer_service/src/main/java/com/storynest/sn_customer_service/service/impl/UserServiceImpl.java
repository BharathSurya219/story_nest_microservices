package com.storynest.sn_customer_service.service.impl;

import com.storynest.sn_customer_service.enums.AccountStatus;
import com.storynest.sn_customer_service.enums.Roles;
import com.storynest.sn_customer_service.exception.UserAlreadyExistsException;
import com.storynest.sn_customer_service.exception.UserNotFoundException;
import com.storynest.sn_customer_service.repository.UserRepository;
import com.storynest.sn_customer_service.service.UserService;
import com.storynest.sn_customer_service.userDTO.UserDTO;
import com.storynest.sn_customer_service.userEntity.User;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

	@Override
	public synchronized void deleteCustomer(String userId) {
		this.repository.deleteById(Integer.valueOf(userId));
	}

	@Override
	public UserDTO update(UserDTO userDTO) {
		var user = this.repository.findById(Math.toIntExact(userDTO.getId()))
						.orElseThrow(() -> new UserNotFoundException(
				String.format("Cannot update user:: No user found with the provided ID: %s", userDTO.getId())
		));
		this.repository.save(user);
		ModelMapper mapper = new ModelMapper();
		mapper.map(user, userDTO);
		return userDTO;
	}

	@Override
	public List<UserDTO> findAllCustomers() {
		ModelMapper mapper = new ModelMapper();
		return this.repository.findAll().stream()
				.map(userEntity -> mapper.map(userEntity,UserDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public Boolean existsById(Long userId) {
		return this.repository.findById(Math.toIntExact(userId))
				.isPresent();
	}

	@Override
	public UserDTO findById(Long userId) {
		ModelMapper mapper = new ModelMapper();
		return this.repository.findById(Math.toIntExact(userId))
				.map(userEntity -> mapper.map(userEntity,UserDTO.class))
				.orElseThrow(() -> new UserNotFoundException(String.format("No user found with the provided ID: %s", userId)));
	}

	private void mergeCustomer(User user, UserDTO request) {
		if (StringUtils.isNotBlank(request.getFullName())) {
			user.setFullName(request.getFullName());
		}
		if (StringUtils.isNotBlank(request.getEmail())) {
			user.setEmail(request.getEmail());
		}
		if (StringUtils.isNotBlank(request.getUserName())) {
			user.setUserName(request.getUserName());
		}
	}
}
