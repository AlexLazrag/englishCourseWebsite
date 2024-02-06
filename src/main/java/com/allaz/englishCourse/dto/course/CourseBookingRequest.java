package com.allaz.englishCourse.dto.course;

import com.allaz.englishCourse.entity.course.Course;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CourseBookingRequest {
    @Future(message = "Date must be in the future.")
    private LocalDate startDate;

    @NotNull
    private Course course;
}
