package com.mjc813.login_cookie.common;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ComResponseDto<T> {
    private Integer code;
    private String message;
    private T data;

    public static <T> ComResponseDto<T> make(ResponseCode resCode, T data) {
        return new ComResponseDto<>(resCode.getCode(), resCode.name(), data);
    }
}
