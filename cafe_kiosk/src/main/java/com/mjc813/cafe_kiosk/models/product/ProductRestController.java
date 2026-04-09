package com.mjc813.cafe_kiosk.models.product;

import com.mjc813.cafe_kiosk.common.ApiResponse;
import com.mjc813.cafe_kiosk.common.CafeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/prd")
public class ProductRestController {

    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity<ApiResponse<ProductDto>> insert(@RequestBody ProductDto productDto) {
        ProductDto result = this.productService.insert(productDto);
        return ResponseEntity.status(201).body(ApiResponse.make(CafeResponse.insert_success, "ok", result));
    }

    @PatchMapping
    public ResponseEntity<ApiResponse<ProductDto>> update(@RequestBody ProductDto productDto) {
        ProductDto result = this.productService.update(productDto);
        return ResponseEntity.status(200).body(ApiResponse.make(CafeResponse.update_success, "ok", result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductDto>> delete(@PathVariable Integer id) {
        ProductDto result = this.productService.delete(id);
        return ResponseEntity.status(200).body(ApiResponse.make(CafeResponse.delete_success, "ok", result));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductDto>> findById(@PathVariable Integer id) {
        ProductDto result = this.productService.findById(id);
        return ResponseEntity.status(200).body(ApiResponse.make(CafeResponse.select_success, "ok", result));
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<Slice<ProductDto>>> findAll(@RequestParam(name="searchName", defaultValue="") String name
            , @PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Slice<ProductDto> result = this.productService.findByNameContains(name, pageable);
        return ResponseEntity.status(200).body(ApiResponse.make(CafeResponse.select_success, "ok", result));
    }
}
