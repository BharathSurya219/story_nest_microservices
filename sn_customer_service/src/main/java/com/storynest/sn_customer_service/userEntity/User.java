package com.storynest.sn_customer_service.userEntity;


import com.storynest.sn_customer_service.enums.AccountStatus;
import com.storynest.sn_customer_service.enums.Roles;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "users", indexes = 
{
	    @Index(name = "idx_user_username", columnList = "userName"),
	    @Index(name = "idx_user_email", columnList = "email"),
	    @Index(name = "idx_user_account_creation_date", columnList = "accountCreationDate")
}
	)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String fullName;
	
	private String password;
	
	private String userName;
	
	private String email;
	
	private LocalDateTime accountCreationDate;
	
	private LocalDateTime lastModified;
	
	private LocalDateTime lastPasswordUpdate;
	
	private boolean termsandConditionAccepted;
	
	@Enumerated
	private AccountStatus accountStatus;
	
	@Enumerated
	private Roles roles;
}
