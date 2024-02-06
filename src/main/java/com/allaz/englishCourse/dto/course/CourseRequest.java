package com.allaz.englishCourse.dto.course;

import com.allaz.englishCourse.entity.course.CourseBooking;
import com.allaz.englishCourse.entity.course.CourseType;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CourseRequest {
    @NotNull
    private String courseName;

    @NotNull
    private Double price;

    @NotNull
    private String level;

    @NotNull
    private CourseType courseType;

    private Set<CourseBooking> bookings;
}
