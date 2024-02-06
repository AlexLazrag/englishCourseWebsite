package com.allaz.englishCourse.entity.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
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

    @Column(name = "password", nullable = false)
    @NotEmpty(message = "Please enter your password")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).*$")
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_role_id")
    private UserRole userRole;

    @CreatedDate
    @Column(name = "created_date", nullable = false)
    @NotNull(message = "Enter valid date")
    @Builder.Default
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private final LocalDateTime createdDate = LocalDateTime.now();
}
