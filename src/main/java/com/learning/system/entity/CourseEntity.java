package com.learning.system.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
public class CourseEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String courseName;
    private int courseDuration;
    private String description;
    private String technology;
    private String url;

}
