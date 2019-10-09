package com.wwm.school.extra;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

  @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
  private Set<StudentCourse> students = new HashSet<>();

  public Course() { }

  public Course(String name) {
    this.name = name;
  }

}
