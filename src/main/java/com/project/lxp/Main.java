package com.project.lxp;

import com.project.lxp.repository.InMemoryCourseRepository;

public class Main {

    public static void main(String[] args) {
        Course javaCourse;

        javaCourse = new Course();

        javaCourse.id=1L;
        javaCourse.title = "자바 입문";
        javaCourse.description = "프로그래밍 초심자를 위한 강좌";
        javaCourse.status = Status.DRAFT;

        System.out.println(javaCourse.title);
        System.out.println(javaCourse.status);


        // 1. 창고 관리자(Repository)를 한 명 생성합니다.
        InMemoryCourseRepository repository = new InMemoryCourseRepository();

        // 2. 첫 번째 강좌 객체를 만듭니다. (아직 id는 없음)
        Course course1 = new Course();
        course1.title = "자바 기초";

        // 3. 창고 관리자에게 저장을 요청합니다.
        //    save 메서드는 id가 부여된 최종 객체를 반환하죠.
        Course savedCourse1 = repository.save(course1);

        // 4. 두 번째 강좌 객체를 만듭니다.
        Course course2 = new Course();
        course2.title = "스프링 입문";

        // 5. 또 저장을 요청합니다.
        Course savedCourse2 = repository.save(course2);


        // --- 결과 확인 ---
        System.out.println("첫 번째 저장된 강좌의 ID: " + savedCourse1.id); // 예상: ?
        System.out.println("첫 번째 저장된 강좌의 제목: " + savedCourse1.title);

        System.out.println("두 번째 저장된 강좌의 ID: " + savedCourse2.id); // 예상: ?
        System.out.println("두 번째 저장된 강좌의 제목: " + savedCourse2.title);


        // --- findById 테스트 ---
        // ID가 2인 강좌를 다시 찾아봅시다.
        Course foundCourse = repository.findById(2L); // Long 타입이라 L을 붙여줍니다.
        System.out.println("ID로 찾은 강좌 제목: " + foundCourse.title); // 예상: ?
    }

}
