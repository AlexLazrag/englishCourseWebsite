package com.allaz.englishCourse.converter.course;

import com.allaz.englishCourse.dto.course.CourseRequest;
import com.allaz.englishCourse.dto.course.CourseResponse;
import com.allaz.englishCourse.entity.course.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseConverter {
    public Course toCourse(CourseRequest request){
        return Course.builder()
                .courseName(request.getCourseName())
                .price(request.getPrice())
                .courseType(request.getCourseType())
                .build();
    }

    public CourseResponse toResponse(Course course){
        return new CourseResponse(course.getId(),
                course.getCourseName(),
                course.getPrice(),
                course.getCourseType());
    }
}
