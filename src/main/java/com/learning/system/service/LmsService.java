package com.learning.system.service;

import com.learning.system.entity.CourseEntity;

import java.util.List;
import java.util.Optional;

public interface LmsService {
    public List<CourseEntity> getCourseDetails(String technology);
    public List<CourseEntity> getAllCourse();
    public List<CourseEntity> getCourseDetailByDuraion(int fromTime, int toTime);
    public Optional<CourseEntity> getCourseById(long id);
}
