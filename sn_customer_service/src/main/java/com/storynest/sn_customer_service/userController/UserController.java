package com.storynest.sn_customer_service.userController;

import com.storynest.sn_customer_service.service.JwtService;
import com.storynest.sn_customer_service.service.UserService;
import com.storynest.sn_customer_service.userDTO.AuthRequest;
import com.storynest.sn_customer_service.userDTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private  UserService userService;

	@Autowired
	private  JwtService jwtService;

	@Autowired
	private  AuthenticationManager authenticationManager;

	@PostMapping("/register")
	public ResponseEntity<UserDTO> createUser(@RequestBody @Validated UserDTO userDTO) {
		UserDTO dto = userService.createUser(userDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
	}

	@PostMapping("/delete")
	public ResponseEntity<UserDTO> deleteUser(@RequestBody @Validated UserDTO userDTO) {
		UserDTO dto = userService.createUser(userDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
	}

	@PostMapping("/token")
	public ResponseEntity<String> generateToken(@RequestBody AuthRequest authRequest) {
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword()));
		if (authentication.isAuthenticated()){
			return ResponseEntity.status(HttpStatus.OK).body(jwtService.generateToken(authRequest));
		}
		return ResponseEntity.badRequest().body("wrong creds bradar");
	}

	@GetMapping("/validate")
	public ResponseEntity<UserDTO> validateToken(@RequestBody @Validated UserDTO userDTO) {
		UserDTO dto = userService.createUser(userDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
	}
}
