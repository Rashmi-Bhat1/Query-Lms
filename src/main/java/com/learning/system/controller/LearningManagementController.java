package com.learning.system.controller;

import com.learning.system.dao.AdminRepository;
import com.learning.system.entity.CourseEntity;
import com.learning.system.entity.UserEntity;
import com.learning.system.service.LearningManagmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@Transactional
@RequestMapping("/queryLms")
@CrossOrigin("http://localhost:3000")
public class LearningManagementController {

    @Autowired
    private LearningManagmentService learningManagmentService;

    @Autowired
    AdminRepository repo;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @GetMapping("/get")
    public List<UserEntity> getAll(){
        List<UserEntity> list = repo.findAll();
        return list;
    }

    @GetMapping("/getDetails/byId/{id}")
    public  Optional<CourseEntity> getAllDtails(@PathVariable("id") long id){
        Optional<CourseEntity> list = learningManagmentService.getCourseById(id);
        return list;
    }
    @GetMapping("/getDetails")
    public List<CourseEntity> getAllDtails(){
        List<CourseEntity> list = learningManagmentService.getAllCourse();
        return list;
    }

    @GetMapping("/getDetails/{tech}")
    public List<CourseEntity> getAllDtailsByTech(@PathVariable("tech") String technology){
        List<CourseEntity> list = learningManagmentService.getCourseDetails(technology);
        return list;
    }

    @GetMapping("/getDetails/{fromTime}/{toTime}")
    public List<CourseEntity> getAllDtailsByCourseDuration(@PathVariable("fromTime") int fromTime,
                                                           @PathVariable("toTime") int toTime){
        List<CourseEntity> list = learningManagmentService.getCourseDetailByDuraion(fromTime,toTime);
        return list;
    }

}
