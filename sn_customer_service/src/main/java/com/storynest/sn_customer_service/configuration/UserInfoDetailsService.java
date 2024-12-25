package com.storynest.sn_customer_service.configuration;

import com.storynest.sn_customer_service.repository.UserRepository;
import com.storynest.sn_customer_service.userEntity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> optional;
		if (username.contains("@")){
			optional = userRepository.findByEmail(username);
		}
		else optional = userRepository.findByUserName(username);
		return optional.map(UserLoginService::new).orElseThrow(()-> 
		new UsernameNotFoundException(username));
	}
}
