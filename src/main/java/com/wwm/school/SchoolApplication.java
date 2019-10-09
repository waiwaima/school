package com.wwm.school;

import com.wwm.school.model.Course;
import com.wwm.school.model.Student;
import com.wwm.school.repository.CourseRepository;
import com.wwm.school.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SchoolApplication implements CommandLineRunner {

  @Autowired
  private StudentRepository studentRepository;

  @Autowired
  private CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(SchoolApplication.class, args);
	}

	@Override
  public void run(String... args) throws Exception {

	  Course english = new Course("English");
    Course math = new Course("Math");
    Set<Course> courses = new HashSet<>();
    courses.add(english);
    courses.add(math);

    Student joe = studentRepository.addStudent("Joe", english, math);
    Student michael = studentRepository.addStudent("Michael", english);

    Set<Student> mathStudents = courseRepository.getStudentsByCourseName("Math");
    Set<Student> nonMathStudents = studentRepository.getStudentsNotRegisteringCourse("Math");

    studentRepository.deleteStudent(joe);
    studentRepository.deleteStudent(michael);
  }

}
