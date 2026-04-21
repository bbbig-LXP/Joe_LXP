package com.project.lxp.repository;

import com.project.lxp.Course;
import java.util.HashMap;
import java.util.Map;

public class InMemoryCourseRepository implements CourseRepository {

    // 1. '가짜 데이터베이스' 역할을 할 저장소를 만듭니다.
    //    - Key: 강좌의 ID (Long 타입)
    //    - Value: 강좌 객체 (Course 타입)
    //    이 변수는 Repository 객체가 살아있는 동안 계속 데이터를 '기억'합니다.
    private static Map<Long, Course> store = new HashMap<>();

    // 2. '자동 증가 ID'를 기억할 '수첩'을 만듭니다.
    //    - long 타입의 변수이고, 이름은 sequence라고 지읍시다.
    //    - 0부터 시작하도록 초기화합니다.
    private static long sequence = 0L; // Long 타입이라 뒤에 L을 붙여줍니다.

    /**
     * 새로운 Course 객체를 받아 저장소에 저장합니다.
     * @param course 저장할 강좌 객체 (아직 id가 없음)
     * @return id가 부여되고 저장된 강좌 객체
     */
    @Override
    public Course save(Course course) {

        course.setId();
        store.put(course.id, course);

        // 5. 저장이 완료된 course 객체를 반환하여,
        //    "이런 내용으로 최종 저장되었어요"라고 알려줍니다.
        return course;
    }

    /**
     * id를 이용해 저장된 Course 객체를 찾습니다.
     * @param id 찾고 싶은 강좌의 ID
     * @return 찾은 강좌 객체. 없으면 null을 반환합니다.
     */
    @Override
    public Course findById(Long id) {
        // 6. '가짜 DB'(store)에서 id를 key로 가지는 값을 찾아 반환합니다.
        //    map.get(key) 메서드를 사용합니다.
        return store.get(id);
    }
}