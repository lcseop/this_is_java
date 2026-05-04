package com.mjc813.swimpool.models.teacher;

import com.mjc813.swimpool.models.common.ApiResponse;
import com.mjc813.swimpool.models.common.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PatchMapping
    private ResponseEntity<ApiResponse<TeacherDto>> update(@RequestBody TeacherDto teacherDto) {
        TeacherDto result = this.teacherService.update(teacherDto);
        return ResponseEntity.status(201).body(ApiResponse.make(
                ResponseCode.update_ok, "ok", result
        ));
    }

    @GetMapping("/{id}")
    private ResponseEntity<ApiResponse<TeacherDto>> findById(@PathVariable Integer id) {
        TeacherDto result = this.teacherService.findById(id);
        return ResponseEntity.status(200).body(ApiResponse.make(
                ResponseCode.select_ok, "ok", result
        ));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<ApiResponse<TeacherDto>> deleteById(@PathVariable Integer id) {
        TeacherDto result = this.teacherService.deleteById(id);
        return ResponseEntity.status(200).body(ApiResponse.make(
                ResponseCode.delete_ok, "ok", result
        ));
    }

    @GetMapping("/searchname")
    private ResponseEntity<ApiResponse<List<TeacherDto>>> findByName(@RequestParam String name,
                                                                     @PageableDefault(size=10, page=0, direction= Sort.Direction.ASC) Pageable pageable) {
        List<TeacherDto> result = this.teacherService.findByName(name, pageable);
        return ResponseEntity.status(200).body(ApiResponse.make(
                ResponseCode.select_ok, "ok", result
        ));
    }

    @GetMapping("/swimpool/{id}")
    private ResponseEntity<ApiResponse<Slice<TeacherDto>>> findBySwimPool(@PathVariable(name="id") Integer swimpoolId,
                                                                          @PageableDefault(size=10, page=0, direction= Sort.Direction.DESC) Pageable pageable) {
        Slice<TeacherDto> result = this.teacherService.findBySwimpool(swimpoolId, pageable);
        return ResponseEntity.status(200).body(ApiResponse.make(
                ResponseCode.select_ok, "ok", result
        ));
    }
}
