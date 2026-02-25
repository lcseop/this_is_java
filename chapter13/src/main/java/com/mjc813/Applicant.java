package com.mjc813;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Applicant<T> {
    private T kind;
}
