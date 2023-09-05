package com.learning.system.service;

import com.learning.system.dao.AdminRepository;
import com.learning.system.dao.UserRepo;
import com.learning.system.dto.ManagementEvent;
import com.learning.system.entity.CourseEntity;
import com.learning.system.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LearningManagmentService implements LmsService {

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public Optional<CourseEntity> getCourseById(long id) {
        return userRepo.findById(id);
    }

    @Override
    public List<CourseEntity> getCourseDetails(String technology) {
        return userRepo.findAllByTechnology(technology);
    }

    @Override
    public List<CourseEntity> getAllCourse() {
        return userRepo.findAll();
    }


    @Override
    public List<CourseEntity> getCourseDetailByDuraion(int fromTime, int toTime) {
        return userRepo.findAllByCourseDuration(fromTime,toTime);
    }
    @KafkaListener(topics = "coursedet",groupId = "myCourse")
    public void processProductEvents(ManagementEvent managementEvent) {
        CourseEntity product = managementEvent.getCourseEntity();
        if (managementEvent.getType().equals("CreateCourse")) {
            userRepo.save(product);
        }
    }
    @KafkaListener(topics = "adminev",groupId = "myAdmin")
    public void processAdminEvents(UserEntity userEntity) {
            String encryptedPwd = passwordEncoder.encode(userEntity.getPassword());
            userEntity.setPassword(encryptedPwd);
            adminRepository.save(userEntity);
    }



}
