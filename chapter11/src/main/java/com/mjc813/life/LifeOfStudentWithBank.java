package com.mjc813.life;

import com.mjc813.banking.BankAccount;
import com.mjc813.banking.MachineNotWorkingException;
import com.mjc813.banking.SendMachine;
import com.mjc813.student.Student;

public class LifeOfStudentWithBank {
    public void doToday() {
        Student lcs = new Student("이충섭", "2022261052");
        Student cwc = new Student("삼충섭", "2023261052");

        BankAccount ba1 = new BankAccount("1111-1111-11", "이충섭");
        BankAccount ba2 = new BankAccount("1111-2222-11", "삼충섭");

        StudentHasBankAccount lcsBank = new StudentHasBankAccount(lcs, ba1);
        StudentHasBankAccount cwcBank = new StudentHasBankAccount(cwc, ba2);

        this.sendMoney(lcsBank, cwcBank, 100000);
        this.sendMoney(lcsBank, cwcBank, 5000);
    }

    public void sendMoney(StudentHasBankAccount from, StudentHasBankAccount to, int money) {
        // 원하는 곳에 예외처리 하세요
        SendMachine sm = new SendMachine();
        try {
            if ( sm.isActive() ) {
                // 과제
                // from 뱅크에서 money 를 빼낸다.
                from.outcome(money);
                // 과제
                // to 뱅크로 money 를 추가한다.
                to.income(money);
            }
        } catch (MachineNotWorkingException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
