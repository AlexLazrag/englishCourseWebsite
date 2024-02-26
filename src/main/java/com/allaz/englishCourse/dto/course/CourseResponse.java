package com.allaz.englishCourse.dto.course;

import com.allaz.englishCourse.entity.course.CourseType;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CourseResponse {
    private Long id;
    private String courseName;
    private Double price;
    private CourseType courseType;
}
