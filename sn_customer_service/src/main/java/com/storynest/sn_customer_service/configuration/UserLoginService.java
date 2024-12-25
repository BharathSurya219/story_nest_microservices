package com.storynest.sn_customer_service.configuration;

import com.storynest.sn_customer_service.enums.Roles;
import com.storynest.sn_customer_service.userEntity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
public class UserLoginService implements UserDetails{

	private final String name;
	private final String password;
	private final List<GrantedAuthority> roles;
	private String admin ="ROLE_USER,ROLE_ADMIN";

	public UserLoginService(User user) {
		name = user.getUserName();
		password = user.getPassword();
		if (user.getRoles().equals(Roles.ADMIN)) {
			roles = Arrays.stream(admin.split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
		} else
			roles = Arrays.stream("ROLE_USER".split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
		log.debug("Userlogged in is :"+ name +" and has roles:"+roles);
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return name;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
