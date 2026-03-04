package com.mjc813;

import com.mjc813.lamda.*;

public class Example {
    public void procStringExam() {
        Check check1 = new CheckLength();
        Check check2 = new RepeatString();

        check1.procString("구현 클래스", 6);
        check2.procString("구현 클래스", 6);

        LamdaUseInterface lu = new LamdaUseInterface();

        lu.doSome((str, num) -> System.out.println((str.length() == num) ? "같다" : "다르다"), "테스트", 3);
        lu.doSome((str, num) -> System.out.println(str.repeat(num)), "테스트", 3);
    }
}
