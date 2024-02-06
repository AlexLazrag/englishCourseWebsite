package com.allaz.englishCourse.repository.course;

import com.allaz.englishCourse.entity.course.CourseBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseBookingRepository extends JpaRepository<CourseBooking, Long> {
}
