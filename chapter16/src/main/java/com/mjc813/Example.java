package com.mjc813;

import com.mjc813.lamda.*;

public class Example {
    public void procStringExam() {
        Check check1 = new CheckLength();
        Check check2 = new RepeatString();

        check1.procString("구현 클래스", 6);
        check2.procString("구현 클래스", 6);

        check((str, num) -> System.out.println(str + "의 길이가 " + num + "와 일치 여부: " + (str.length()==num)));
        check((str, num) -> System.out.println(str.repeat(num)));
    }

    public void check(Check check) {
        check.procString("이름 없는 람다식", 9);
    }
}
