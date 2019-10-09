package com.wwm.school.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
public class Course {

  @Id
  @GeneratedValue
  private Long id;

  private String name;

  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "courses")
  @OrderBy("name")
  private Set<Student> students = new HashSet<>();

  public Course() { }

  public Course(String name) {
    this.name = name;
  }

  public Course(String name, Set<Student> students) {
    this.name = name;
    this.students = students;
  }

}
