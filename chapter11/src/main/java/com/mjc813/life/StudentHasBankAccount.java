package com.mjc813.life;

import com.mjc813.banking.BankAccount;
import com.mjc813.student.Student;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class StudentHasBankAccount {
    private final Student student;
    private final BankAccount bankAccount;

    /**
     * 계좌에 돈을 입금한다.
     * @param money 입금액
     */
    public void income(int money) {
        try {
            if (money < 1 || money > 100000000) {
                throw new MoneyRangeMaxMinException("출금은 1원에서 1억원까지만 가능합니다.");
            }
            bankAccount.setMoney(bankAccount.getMoney() + money);
            System.out.println(student.getName() + "의 계좌에 " + money + "원이 입금되었습니다.");
            System.out.println("현재액: " + bankAccount.getMoney() + "원");
        } catch (MoneyRangeMaxMinException e) {
            System.out.println("오류: " + e.getMessage());
        }
    }

    /**
     * 계좌에서 돈을 출금한다.
     * @param money 출금액
     * @return 출금액 반환
     */
    public int outcome(int money) {
        try {
            if (money < 1 || money > 100000000) {
                throw new MoneyRangeMaxMinException("출금은 1원에서 1억원까지만 가능합니다.");
            }
            if (money > bankAccount.getMoney()) {
                throw new MoneyNotEnoughException("계좌에 돈이 부족합니다.");
            }
            bankAccount.setMoney(bankAccount.getMoney() - money);
            System.out.println(student.getName() + "의 계좌에서 " + money + "원이 출금되었습니다.");
            System.out.println("현재액: " + bankAccount.getMoney() + "원");
            return money;

        } catch (MoneyRangeMaxMinException e) {
            System.out.println("오류: " + e.getMessage());
            return 0;
        } catch (MoneyNotEnoughException e) {
            System.out.println("오류: " + e.getMessage());
            return 0;
        }
    }

    /**
     * 현재 잔액을 반환한다.
     * @return 잔액 반환
     */
    public int getCurrentMoney() {
        return bankAccount.getMoney();
    }
}
