package com.project.lxp.repository;

import com.project.lxp.Course;
import java.util.HashMap;
import java.util.Map;

public class InMemoryCourseRepository implements CourseRepository {

    //   이 변수는 Repository 객체가 살아있는 동안 계속 데이터를 '기억'합니다.
    private static Map<Long, Course> store = new HashMap<>();

    //  임시 사용할 Auto Increment : squence = ++sequence
    private static long sequence = 0L; // Long 타입이라 뒤에 L을 붙여줍니다.

    //새로운 Course 객체를 받아 저장소에 저장합니다.
    @Override
    public Course save(Course course) {

        //sequence에 1씩 추가하여 Id 생성
        course.setId(++sequence);

        //map에 ID와 course 입력
        store.put(sequence, course);

        return course;
    }

    // id를 이용해 저장된 Course 객체를 찾습니다.
    @Override
    public Course findById(Long id) {
        return store.get(id);
    }
}