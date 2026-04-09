package com.mjc813.cafe_kiosk.models.product;

import com.mjc813.cafe_kiosk.common.ApiResponse;
import com.mjc813.cafe_kiosk.common.CafeResponse;
import org.springframework.beans.factory.annotation.Autowired;
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
}
