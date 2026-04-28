package com.mjc813.swimpool.models.teacher;

import com.mjc813.swimpool.models.common.ApiResponse;
import com.mjc813.swimpool.models.common.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tea")
public class TeacherRestController {
    @Autowired
    private TeacherService teacherService;

    @PostMapping
    private ResponseEntity<ApiResponse<TeacherDto>> insert(@RequestBody TeacherDto teacherDto) {
        TeacherDto result = this.teacherService.insert(teacherDto);
        return ResponseEntity.status(201).body(ApiResponse.make(
                ResponseCode.insert_ok, "ok", result
        ));
    }
}
