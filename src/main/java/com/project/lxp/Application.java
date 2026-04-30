package com.project.lxp;

import com.mysql.cj.jdbc.JdbcConnection;
import com.project.lxp.controller.CourseController;
import com.project.lxp.repository.CourseRepository;
import com.project.lxp.repository.InMemoryCourseRepository;
import com.project.lxp.service.CourseService;
import com.project.lxp.domain.Course;
import java.sql.Connection;
import java.util.Scanner;
import javax.sql.DataSource;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.SQLException;
import com.project.lxp.repository.JdbcCourseRepository;
import com.project.lxp.common.DBConnetion;


public class Application {


    public static void main(String[] args) {
        // 1. 조립영역 (Dependency Injection)
        // 여기서 repository, service, controller를 순서대로 생성하고 연결해주세요.

        InMemoryCourseRepository inMemoryCourseRepository;
        CourseService courseService;
        CourseController courseController;
//
//        // --- 데이터베이스 연결 설정 시작 ---
//        MysqlDataSource dataSource = new MysqlDataSource();
//        dataSource.setURL("jdbc:mysql://localhost:3306/lxp_db?serverTimezone=UTC"); // <-- URL을 본인 환경에 맞게 수정!
//        dataSource.setUser("root");    // <-- DB 사용자 이름을 입력!
//        dataSource.setPassword("dmsqlcao");    // <-- DB 비밀번호를 입력!
//        // --- 데이터베이스 연결 설정 끝 ---
//
        DataSource dataSource = DBConnetion.getDataSource();
//




        CourseRepository courseRepository = new JdbcCourseRepository(dataSource);
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
