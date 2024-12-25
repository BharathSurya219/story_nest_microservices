package com.storynest.sn_customer_service.service;


import com.storynest.sn_customer_service.userDTO.UserDTO;

import java.util.List;

public interface UserService {

	UserDTO createUser(UserDTO userDTO);

	void deleteCustomer(String userId);

	UserDTO update(UserDTO userDTO);

	List<UserDTO> findAllCustomers();

	Boolean existsById(Long customerId);

	UserDTO findById(Long userId);
}
