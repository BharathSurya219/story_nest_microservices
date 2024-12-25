package com.storynest.sn_customer_service.userDTO;


import com.storynest.sn_customer_service.enums.AccountStatus;
import com.storynest.sn_customer_service.enums.Roles;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;

    @NotBlank(message = "{user.fullName.notBlank}")
    private String fullName;

    @NotBlank(message = "{user.password.notBlank}")
    @Size(min = 8, max = 20, message = "{user.password.size}")
    private String password;

    @NotBlank(message = "{user.userName.notBlank}")
    @Pattern(regexp = "^[a-zA-Z0-9_.-]*$", message = "{user.userName.invalid}")
    private String userName;

    @NotBlank(message = "{user.email.notBlank}")
    @Email(message = "{user.email.invalid}")
    private String email;

    private LocalDateTime accountCreationDate;

    private LocalDateTime lastModified;

    private LocalDateTime lastPasswordUpdate;

    @NotNull
    @AssertTrue(message = "{user.terms.invalid}")
    private boolean termsandConditionAccepted;

    private AccountStatus accountStatus;

    private Roles roles;
}
