package com.project.lxp.repository;

import com.project.lxp.domain.Course;
import com.project.lxp.domain.CourseStatus;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcCourseRepository implements CourseRepository {

    private final DataSource dataSource;

    public JdbcCourseRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Course save(Course course) {
        String sql = "INSERT INTO courses (title, description, status) VALUES (?, ?, ?)";
        // try-with-resources 구문을 사용하여 자원을 자동으로 해제합니다.
        try (Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, course.getTitle());
            pstmt.setString(2, course.getDescription());
            pstmt.setString(3, course.getStatus().name()); // Enum을 문자열로 변환하여 저장
            pstmt.executeUpdate();

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    Long generatedId = generatedKeys.getLong(1);
                    course.setId(generatedId);
                    return course;
                } else {
                    throw new SQLException("ID 생성에 실패했습니다.");
                }
            }
        } catch (SQLException e) {
            // 실제 애플리케이션에서는 로깅 라이브러리를 사용하는 것이 좋습니다.
            throw new RuntimeException("데이터베이스에 강좌를 저장하는 중 오류가 발생했습니다.", e);
        }
    }

    @Override
    public Course findById(Long id) {
        String sql = "SELECT id, title, description, status FROM courses WHERE id = ?";
        try (Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Course course = new Course("title", "description");
                    course.setId(rs.getLong("id"));
                    course.setTitle(rs.getString("title"));
                    course.setDescription(rs.getString("description"));
                    // DB의 문자열을 Enum으로 변환
                    course.setStatus(CourseStatus.valueOf(rs.getString("status")));
                    return course;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("ID로 강좌를 찾는 중 오류가 발생했습니다.", e);
        }
        return null; // 찾는 강좌가 없을 경우 null 반환
    }
}