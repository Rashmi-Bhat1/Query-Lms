package com.learning.system.dto;

import com.learning.system.entity.CourseEntity;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ManagementEvent {
    private String type;
    private CourseEntity courseEntity;
    //private UserEntity adminEntity;

}
