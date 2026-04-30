package com.project.lxp.controller;

import com.project.lxp.service.CourseService;
import com.project.lxp.domain.Course;

public class CourseController {
    //CourseService의 courseService 메서드 호출
    private CourseService courseService;

    //생성자 Controller는 courseService를 받아 courseService에 저장한다.
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    //Service의 createService를 시켜 title과 description을 받는다.
    public Course createCourse(String title, String descrioption) {

        return courseService.createCourse(title, descrioption);
    }

}
