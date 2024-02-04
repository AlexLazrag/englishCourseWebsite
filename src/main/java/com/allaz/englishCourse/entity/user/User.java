package com.allaz.englishCourse.entity.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name", nullable = false)
    @NotEmpty(message = "Enter your first name")
    @Size(min = 2, max = 255)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @NotEmpty(message = "Enter your last name")
    @Size(min = 2, max = 255)
    private String lastName;

    @Column(name = "email", unique = true, nullable = false)
    @NotBlank(message = "Enter a valid email")
    @Email
    private String email;

    @Column(name = "phone_number", nullable = false)
    @Pattern(regexp = "^(\\+|00)[0-9\\-]{10,15}$")
    private String phoneNumber;


    private String password;
}
