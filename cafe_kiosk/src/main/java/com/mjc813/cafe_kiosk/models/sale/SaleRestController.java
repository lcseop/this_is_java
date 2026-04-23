package com.mjc813.cafe_kiosk.models.sale;

import com.mjc813.cafe_kiosk.common.ApiResponse;
import com.mjc813.cafe_kiosk.common.CafeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sle")
public class SaleRestController {
    @Autowired
    private SaleService service;

    @PostMapping
    public ResponseEntity<ApiResponse<SaleDto>> insert(@RequestBody SaleDto newDto) {
        SaleDto result = this.service.insert(newDto);
        return ResponseEntity.status(201).body(ApiResponse.make(CafeResponse.insert_success, "SUCCESS", result));
    }
}
