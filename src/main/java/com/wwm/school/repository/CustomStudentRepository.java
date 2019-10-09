package com.wwm.school.repository;

import com.wwm.school.model.Course;
import com.wwm.school.model.Student;

public interface CustomStudentRepository {

  Student addStudent(String studentName, Course... courses);

  void deleteStudent(Student student);

}
