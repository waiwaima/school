package com.wwm.school.repository;

import com.wwm.school.model.Course;
import com.wwm.school.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface CourseRepository extends JpaRepository<Course, Long> {

  @Query("SELECT c.students FROM Course c WHERE c.name = :name")
  Set<Student> getStudentsByCourseName(@Param("name") String name);

}
