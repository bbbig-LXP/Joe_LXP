package com.project.lxp.repository;

import com.project.lxp.Course;
import com.project.lxp.CourseService;

public interface CourseRepository {

    //완성된 Course 객체를 받아 저장소에 저장합니다.
    Course save(Course course);

    // findById id로 Course를 찾습니다
    Course findById(Long id);

}
