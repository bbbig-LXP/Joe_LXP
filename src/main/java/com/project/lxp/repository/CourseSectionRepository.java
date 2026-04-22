package com.project.lxp.repository;

public interface CourseSectionRepository {

    //CourseSection타입 section 값을 찾아 CourseSection 형태로 저장한다.
    CourseSection save(CourseSection section);

    //Long 타입의 sectionId로 Id를 찾아 CourseSection 타입으로 반환한다.
    CourseSection findById(Long sectionId);

    //Long 타입의 courseId로 Id를 찾아 List<CourseSection> 타입으로 반환한다.
    List<CourseSection> findByCourseId(Long courseId);


}
