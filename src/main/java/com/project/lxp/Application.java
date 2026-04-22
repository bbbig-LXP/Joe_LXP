package com.project.lxp;

import com.project.lxp.controller.CourseController;
import com.project.lxp.repository.CourseRepository;
import com.project.lxp.repository.InMemoryCourseRepository;
import com.project.lxp.service.CourseService; // package 이름이 Service일 경우를 가정
import com.project.lxp.domain.Course;
import java.util.Scanner;

public class Application {

    //CourseRepository의 구현체 InMemoryCourseRepository를 만든다.
    //repository 객체를 생성자에 넣어주면서 CourseService를 만든다.
    //그렇게 만든 service 객체를 생성자에 넣어 CourseController를 만든다.

    public static void main(String[] args) {
        // 1. 조립영역 (Dependency Injection)
        // 여기서 repository, service, controller를 순서대로 생성하고 연결해주세요.

        InMemoryCourseRepository inMemoryCourseRepository;
        CourseService courseService;
        CourseController courseController;


        CourseRepository courseRepository = new InMemoryCourseRepository();
        CourseService courseService1 = new CourseService(courseRepository);
        courseController = new CourseController (courseService1);


        // === 2. 실행 영역 (User Interaction) ===
        Scanner scanner = new Scanner(System.in);

        System.out.print("강좌 제목을 입력하세요: ");
        String title = scanner.nextLine();

        System.out.print("강좌 설명을 입력하세요: ");
        String description = scanner.nextLine();

        // 여기서 controller의 메소드를 호출하고, 결과를 받아 출력해주세요.

        Course createdCourse = courseController.createCourse(title, description);

        System.out.println("새로운 강좌가 성공적으로 등록되었습니다!");
        System.out.println("강좌 ID: " + createdCourse.getId());
        System.out.println("강좌 제목: " + createdCourse.getTitle());
        System.out.println("강좌 상태: " + createdCourse.getStatus());

    }



}
