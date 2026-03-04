package com.mjc813;

import com.mjc813.lamda.*;
import com.mjc813.lamda2.*;
import com.mjc813.lamda3.*;
import com.mjc813.lamda4.*;
import com.mjc813.lamda5.*;

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

    public void lamdaExmaple() {
        action((x, y) -> {
            int result = x + y;
            System.out.println("result: " + result);
        });

        action((x, y) -> {
            int result = x - y;
            System.out.println("result: " + result);
        });
    }

    public void action(Calculable calculable) {
        int x = 10;
        int y = 4;
        calculable.calculate(x, y);
    }

    public void lamdaExample2() {
        Person person = new Person();

        person.action(() -> {
            System.out.println("출근을 합니다.");
            System.out.println("프로그래밍을 합니다.");
        });

        person.action(() -> System.out.println("퇴근합니다."));
    }

    public void buttonExample() {
        Button btnOk = new Button();
        btnOk.setClickListener(() -> System.out.println("OK 버튼을 클릭했습니다."));
        btnOk.click();

        Button btnCancel = new Button();
        btnCancel.setClickListener(() -> System.out.println("Cancel 버튼을 클릭했습니다."));
        btnCancel.click();
    }

    public void lamdaExample3() {
        Person2 person = new Person2();

        person.action1((name, job) -> {
            System.out.print(name + "이 ");
            System.out.println(job + "을 합니다.");
        });
        person.action1((name, job) -> System.out.println(name + "이 " + job + "을 하지 않습니다."));

        person.action2(word -> {
            System.out.print("\"" + word + "\"");
            System.out.println("라고 말합니다.");
        });
        person.action2(word -> System.out.println("\"" + word + "\"라고 외칩니다."));
    }

    public void lamdaExample4() {
        Person3 person = new Person3();

        person.action((x, y) -> {
            double result = x + y;
            return result;
        });

        person.action(Double::sum);
    }

    public void methodReferenceExample() {
        Person3 person = new Person3();
        person.action(Computer::staticMethod);

        Computer computer = new Computer();
        person.action(computer::instanceMethod);

        Person4 person2 = new Person4();
        person2.ordering(String::compareToIgnoreCase);
    }

    public void constructorReferenceExample() {
        Person5 person = new Person5();

        Member m1 = person.getMember1(Member::new);
        System.out.println(m1);
        System.out.println();

        Member m2 = person.getMember2(Member::new);
        System.out.println(m2);
    }

}
