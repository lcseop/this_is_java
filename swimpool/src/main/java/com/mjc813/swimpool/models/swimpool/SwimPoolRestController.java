package com.mjc813.swimpool.models.swimpool;

import com.mjc813.swimpool.models.common.ApiResponse;
import com.mjc813.swimpool.models.common.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pool")
public class SwimPoolRestController {
    @Autowired
    private SwimPoolService swimPoolService;

    @PostMapping
    private ResponseEntity<ApiResponse<SwimPoolDto>> insert(@RequestBody SwimPoolDto insertDto) {
        SwimPoolDto result = swimPoolService.insert(insertDto);
        return ResponseEntity.status(201).body(ApiResponse.make(
                ResponseCode.insert_ok, "ok", result
        ));
    }

    @PatchMapping
    private ResponseEntity<ApiResponse<SwimPoolDto>> update(@RequestBody SwimPoolDto updateDto) {
        SwimPoolDto result = swimPoolService.update(updateDto);
        return ResponseEntity.status(200).body(ApiResponse.make(
                ResponseCode.update_ok, "ok", result
        ));
    }

    @GetMapping("/{id}")
    private ResponseEntity<ApiResponse<SwimPoolDto>> findById(@PathVariable Integer id) {
        SwimPoolDto result = swimPoolService.findById(id);
        return ResponseEntity.status(200).body(ApiResponse.make(
                ResponseCode.select_ok, "ok", result
        ));
    }

    @GetMapping("/searchname")
    private ResponseEntity<ApiResponse<Slice<SwimPoolDto>>> findByNameContains(@RequestParam String name,
                             @PageableDefault(size=10, page=0, direction= Sort.Direction.DESC) Pageable pageable) {
        Slice<SwimPoolDto> result = swimPoolService.findByNameContains(name, pageable);
        return ResponseEntity.status(200).body(ApiResponse.make(
                ResponseCode.select_ok, "ok", result
        ));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<ApiResponse<SwimPoolDto>> deleteById(@PathVariable Integer id) {
        SwimPoolDto result = swimPoolService.delete(id);
        return ResponseEntity.status(200).body(ApiResponse.make(
                ResponseCode.delete_ok, "ok", result
        ));
    }
}
