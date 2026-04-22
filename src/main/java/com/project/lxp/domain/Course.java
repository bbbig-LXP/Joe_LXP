package com.project.lxp.domain;

import com.project.lxp.Level;
import com.project.lxp.Status;
import java.time.LocalDateTime;

public class Course {
    public Long id;
    public String title;
    public String description;
    public Long instructorId;
    public CourseStatus status;
    public Level level;
    public LocalDateTime createAt;
    public LocalDateTime updateAt;
    public LocalDateTime published_at;


    //생성자
    //강좌 등록 비즈니스 규칙 검증(Validation) 및 강제(Enforcement)
    public Course(String title, String description) {
        if (title == null || title.length() < 2|| title.length() >50) {
            throw new IllegalArgumentException("강좌명은 2자 이상 50자 이하여야 합니다.");
        }
        if (description == null || description.length() < 2 || description.length() > 50) {
            throw new IllegalArgumentException("강의 설명은 2자 이상 50자 이하여야 합니다.");
        }
        //최초 생성시 강좌의 상태는 DRAFT(Enforcemnet)
        this.status = CourseStatus.DRAFT;
    }

}
