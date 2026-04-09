package com.mjc813.cafe_kiosk.models.category;

import com.mjc813.cafe_kiosk.common.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.mjc813.cafe_kiosk.common.CafeResponse.*;

@RestController
@RequestMapping("/api/v1/cat")
public class CategoryRestController {

    @Autowired
    private CategoryService service;


    @PostMapping
    public ResponseEntity<ApiResponse<CategoryDto>> insert (@RequestBody CategoryDto data) {
        CategoryDto result = this.service.insert(data);
        return ResponseEntity.status(201).body(ApiResponse.make(insert_success, "SUCCESS", result));
    }

    @PatchMapping
    public ResponseEntity<ApiResponse<CategoryDto>> update (@RequestBody CategoryDto data) {
        CategoryDto result = this.service.update(data);
        return ResponseEntity.status(202).body(ApiResponse.make(update_success, "SUCCESS", result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<CategoryDto>> delete (@PathVariable Integer id) {
        CategoryDto result = this.service.delete(id);
        return ResponseEntity.status(202).body(ApiResponse.make(delete_success, "SUCCESS", result));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CategoryDto>> find (@PathVariable Integer id) {
        CategoryDto result = this.service.findById(id);
        return ResponseEntity.status(200).body(ApiResponse.make(select_success, "SUCCESS", result));
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<Slice<CategoryDto>>> findSearch(@RequestParam(name="searchName", defaultValue="") String name, @PageableDefault(size=5, sort="id", direction = Sort.Direction.DESC) Pageable pageable) {
        CategoryResultDto crd = CategoryResultDto.builder().searchName(name).build();
        Slice<CategoryDto> result = this.service.findByNameContains(crd, pageable);
        return ResponseEntity.status(200).body(ApiResponse.make(select_success, "SUCCESS", result));
    }
}
