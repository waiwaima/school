package com.wwm.school.extra;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "student_course")
@Getter
@Setter
public class StudentCourse {

  @EmbeddedId
  private StudentCourseId id;

  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId("studentId")
  private Student student;

  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId("courseId")
  private Course course;

  @Column(name = "score")
  private int score;

  public StudentCourse() { }

  public StudentCourse(Student student, Course course) {
    this.student = student;
    this.course = course;
    this.id = new StudentCourseId(student.getId(), course.getId());
  }

}
