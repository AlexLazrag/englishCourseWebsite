package com.allaz.englishCourse.dto.user;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class UserRoleRequest {
    @NotBlank
    private String userRoleName;
}
