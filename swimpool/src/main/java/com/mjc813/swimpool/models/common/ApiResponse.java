package com.mjc813.swimpool.models.common;

import lombok.*;

import java.beans.Transient;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ApiResponse<T> {
    private ResponseCode responseCode;
    private String message;
    private T responseData;

    public static <T> ApiResponse<T> make(ResponseCode responseCode, String message, T responseData) {
        return new ApiResponse<>(responseCode, message, responseData);
    }
}
