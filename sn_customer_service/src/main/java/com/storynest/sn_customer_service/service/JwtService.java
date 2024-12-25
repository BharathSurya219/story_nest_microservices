package com.storynest.sn_customer_service.service;

import com.storynest.sn_customer_service.userDTO.AuthRequest;
import com.storynest.sn_customer_service.userDTO.UserDTO;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {

	public String generateToken(AuthRequest user);

	public void ValidateToken(String token);

	String extractUserName(String token);

	boolean isTokenValid(String token, UserDetails userDetails);

}
