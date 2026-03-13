package com.mjc813;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Report5 extends Thread {
    private String role;
    private Integer[] arrays;

    public Report5(String role, Integer[] arrays) {
        this.role = role;
        this.arrays = arrays;
    }

    @Override
    public void run() {
        int sum = 0;
        float avg = 0;
        boolean first = false;
        StringBuilder msg = new StringBuilder();
        switch (role) {
            case "sum" :
                for (int num : this.arrays) {
                    sum += num;
                }
                System.out.println("숫자들의 총합 : " + sum);
                break;
            case "avg" :
                for (int num : this.arrays) {
                    sum += num;
                }
                avg = (float) sum / this.arrays.length;
                System.out.println("숫자들의 평균 : " + avg);
                break;
            case "sort" :
                msg.append("숫자들의 오름차순 정렬 : ");
                Arrays.sort(this.arrays);
                for (int i = 0; i < this.arrays.length; i++) {
                    msg.append(this.arrays[i]).append((i != this.arrays.length-1) ? ", " : "");
                }
                System.out.println(msg);
                break;
            case "odd" :
                msg.append("숫자들 중 홀수 값들 : ");
                for (int i = 0; i < this.arrays.length; i++) {

                }
                for (int i = 0; i < this.arrays.length; i++) {
                    if (this.arrays[i] % 2 == 1) {
                        msg.append((first) ? ", " : "").append(this.arrays[i]);
                        first = true;
                    }
                }
                System.out.println(msg);
                break;
            case "even" :
                msg.append("숫자들 중 짝수 값들 내림차순 : ");
                Arrays.sort(this.arrays, Collections.reverseOrder());
                for (int i = 0; i < this.arrays.length; i++) {
                    if (this.arrays[i] % 2 == 0) {
                        msg.append((first) ? ", " : "").append(this.arrays[i]);
                        first = true;
                    }
                }
                System.out.println(msg);
                break;
        }
    }
}
