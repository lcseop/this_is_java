package com.mjc813.life;

import com.mjc813.banking.BankAccount;
import com.mjc813.student.Student;

public class LifeOfStudentWithBank {
    public void doToday() {
        Student lcs = new Student("이충섭", "2022261052");
        Student cwc = new Student("삼충섭", "2023261052");

        BankAccount ba1 = new BankAccount("1111-1111-11", "이충섭");
        BankAccount ba2 = new BankAccount("1111-2222-11", "삼충섭");

        StudentHasBankAccount lcsBank = new StudentHasBankAccount(lcs, ba1);
        StudentHasBankAccount cwcBank = new StudentHasBankAccount(cwc, ba2);
    }
}
