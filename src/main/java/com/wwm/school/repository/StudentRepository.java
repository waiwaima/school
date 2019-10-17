package com.wwm.school.repository;

import com.wwm.school.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>, CustomStudentRepository {

  @Query(value = "SELECT * FROM student WHERE student.id NOT IN " +
          "(SELECT s.id " +
          "FROM student s " +
          "JOIN student_course sc ON s.id = sc.student_id " +
          "JOIN course c ON sc.course_id = c.id " +
          "WHERE c.name = :name)",
      nativeQuery = true)
  Set<Student> getStudentsNotRegisteringCourse(@Param("name") String name);

}
