package com.allaz.englishCourse.dto.user;

import com.allaz.englishCourse.entity.user.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class UserRequest {
    @NotBlank
    @Length(min = 3, message = "First name should contain at least 3 characters.")
    private String firstName;

    @NotBlank
    @Length(min = 3, message = "Last name should contain at least 3 characters.")
    private String lastName;

    @NotBlank
    @Email(message = "Enter a valid email.")
    private String email;

    @NotBlank
    @Length(min = 8, message = "Password should contain at least 8 characters.")
    private String password;

    private UserRole userRole;

}
