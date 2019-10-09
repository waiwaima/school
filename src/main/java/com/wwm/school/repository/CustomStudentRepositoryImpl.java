package com.wwm.school.repository;

import com.wwm.school.model.Course;
import com.wwm.school.model.Student;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.Set;

public class CustomStudentRepositoryImpl implements CustomStudentRepository {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  @Transactional
  public Student addStudent(String studentName, Course... courses) {
    Set<Course> studentCourses = new HashSet<>();
    Student student = new Student(studentName, studentCourses);
    for (Course c : courses) {
      Course course = (c.getId() == null) ? c : entityManager.find(Course.class, c.getId());
      course.getStudents().add(student);
      studentCourses.add(course);
    }
    entityManager.persist(student);
    return student;
  }

  @Override
  @Transactional
  public void deleteStudent(Student student) {
    Student s = entityManager.find(Student.class, student.getId());
    for (Course course : s.getCourses()) {
      course.getStudents().remove(s);
    }
    entityManager.remove(s);
  }

}
