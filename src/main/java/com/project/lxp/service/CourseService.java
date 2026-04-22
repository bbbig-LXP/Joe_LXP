package com.project.lxp.Service;

import com.project.lxp.domain.Course;
import com.project.lxp.repository.CourseRepository;

public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    //강좌 생성
    public Course createCourse(String title, String description){
        //강좌 생성
        Course course = new Course(title, description);
        //강좌 저장
        return courseRepository.save(course);
    }


}
