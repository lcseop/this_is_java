package com.mjc813.cafe_kios.models;

import com.mjc813.cafe_kios.ResponseCode;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ApiResponse<T> {
    private ResponseCode code;
    private String message;
    private T responseData;
}
