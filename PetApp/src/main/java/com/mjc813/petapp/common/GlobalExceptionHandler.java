package com.mjc813.petapp.common;

import com.mjc813.petapp.pet.PetResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Throwable.class)
    public ResponseEntity<PetResponseDto> ExceptionHandler404(Throwable e) {
        PetResponseDto result = new PetResponseDto(404, "throwable ERROR", null);
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(result);
    }

    @ExceptionHandler(value = NoSuchElementException.class)
    public ResponseEntity<PetResponseDto> NoSuchElementExceptionHandler404(NoSuchElementException e) {
        PetResponseDto result = new PetResponseDto(-977, "NOT FOUND ERROR", null);
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(result);
    }

    @ExceptionHandler(value = NumberFormatException.class)
    public ResponseEntity<PetResponseDto> NumberFormatExceptionHandler404(NumberFormatException e) {
        PetResponseDto result = new PetResponseDto(-912, "Number Format Error", null);
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(result);
    }

    @ExceptionHandler(value = MyExcepton.class)
    public ResponseEntity<PetResponseDto> MyExceptionHandler404(MyExcepton e) {
        PetResponseDto result = new PetResponseDto(-912, "data error", e.getData());
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(result);
    }
}
