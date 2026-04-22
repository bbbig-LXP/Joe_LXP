package com.project.lxp.domain;

import java.time.LocalDateTime;

public class CourseSection {

    Long id;
    Long courseId;
    String title;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    public CourseSection() {
    }

    public CourseSection(Long id, Long courseId, String title, LocalDateTime createdAt,
        LocalDateTime updatedAt) {
        this.id = id;
        this.courseId = courseId;
        this.title = title;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}
