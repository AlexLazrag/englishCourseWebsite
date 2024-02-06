package com.allaz.englishCourse.entity.course;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "course_name", nullable = false)
    @NotEmpty(message = "Enter the title of the course.")
    private String courseName;

    @Column(name = "price", nullable = false)
    @NotNull(message = "Course should have a price.")
    private Double price;

    @Column(name = "course_level", nullable = false)
    @NotNull(message = "Course should have difficulty level.")
    private String level;

    @Column(name = "course_type")
    @Enumerated(EnumType.STRING)
    @NotNull
    private CourseType courseType;
}