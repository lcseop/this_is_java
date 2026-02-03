package com.mjc813.machine;

import java.util.Arrays;

public class Calculator {
    /**
     * int 데이터형 들의 합을 구해서 리턴한다.
     * @param items int 형 데이터들을 콤마로 구분한 매개변수
     * @return 매개변수들의 총 합계
     */
    public long add(int ... items) {
        return Arrays.stream(items)
                .mapToLong(i->i)
                .sum();
    }
}
