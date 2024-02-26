package com.allaz.englishCourse.dto.user;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class UserUpdate {
    @NotBlank
    @Length(min=3)
    private String firstName;

    @NotBlank
    @Length(min=3)
    private String lastName;
}
