package com.wwm.school.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
public class Student {

  @Id
  @GeneratedValue
  private Long id;

  private String name;

  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  @JoinTable(name = "student_course",
      joinColumns = { @JoinColumn(name = "student_id") },
      inverseJoinColumns = { @JoinColumn(name = "course_id") })
  private Set<Course> courses = new HashSet<>();

  public Student() { }

  public Student(String name) {
    this.name = name;
  }

  public Student(String name, Set<Course> courses) {
    this.name = name;
    this.courses = courses;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }

    if (!(o instanceof Student)) {
      return false;
    }

    Student student = (Student) o;
    return Objects.equals(id, student.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

}
