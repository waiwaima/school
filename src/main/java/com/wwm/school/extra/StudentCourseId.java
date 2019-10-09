package com.wwm.school.extra;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class StudentCourseId implements Serializable {

  @Column(name = "student_id")
  private Long studentId;

  @Column(name = "course_id")
  private Long courseId;

  public StudentCourseId() { }

  public StudentCourseId(Long studentId, Long courseId) {
    this.studentId = studentId;
    this.courseId = courseId;
  }

}
