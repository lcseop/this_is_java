package com.mjc813;

import lombok.Getter;
import java.util.Scanner;

@Getter
public class BankApplication {
    private Account[] accounts = new Account[100];
    private Account myAccount;

    public BankApplication(Account account) {
        this.myAccount = account;
    }

    public void start() {
        Scanner s = new Scanner(System.in);
        start: while(true) {
            System.out.println("-------------------------------------------------");
            System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
            System.out.println("-------------------------------------------------");
            System.out.print("선택> ");
            select: switch(Integer.parseInt(s.nextLine())) {
                case 1:
                    String newNumber = "", newName = "";
                    int newAccount = 0, index = 0;
                    for (int i = 0; i < this.accounts.length; i++) {
                        if (accounts[i] == null) {
                            index = i;
                            break;
                        }
                    }
                    try {
                        System.out.println("---------");
                        System.out.println("계좌생성");
                        System.out.println("---------");
                        System.out.print("계좌번호: ");
                        newNumber = s.nextLine();
                        System.out.print("계좌주: ");
                        newName = s.nextLine();
                        System.out.print("초기입금액: ");
                        newAccount = Integer.parseInt(s.nextLine());
                        while (newAccount < Account.MIN_BALANCE || newAccount > Account.MAX_BALANCE) {
                            System.out.println("오류: 입금액은 0원에서 100만원까지 설정 가능합니다.");
                            System.out.print("초기입금액: ");
                            newAccount = Integer.parseInt(s.nextLine());
                        }
                        accounts[index] = new Account(newAccount, newNumber, newName);
                        System.out.println("결과: 계좌가 생성되었습니다.");
                    } catch (Exception e) {
                        System.out.println("[" + e.getMessage() + "] 오류 발생");
                        break;
                    }
                    break;
                case 2:
                    System.out.println("---------");
                    System.out.println("계좌목록");
                    System.out.println("---------");
                    for (int i = 0; i < this.accounts.length; i++) {
                        if (accounts[i] == null) {
                            break;
                        }
                        System.out.println(accounts[i].getNumber() + "\t" + accounts[i].getName() + "\t" + accounts[i].getBalance());
                    }
                    break;
                case 3:
                    String targetNumber = "";
                    int targetBalance = 0;
                    Account targetAccount;
                    System.out.println("---------");
                    System.out.println("예금");
                    System.out.println("---------");
                    try {
                        System.out.print("계좌번호: ");
                        targetNumber = s.nextLine();
                        targetFind:
                        while (true) {
                            if (targetNumber.equals("0")) {
                                System.out.println("예금을 중단합니다.");
                                break select;
                            }
                            for (int i = 0; i < accounts.length; i++) {
                                if (accounts[i].getNumber().equals(targetNumber)) {
                                    targetAccount = accounts[i];
                                    break targetFind;
                                }
                            }
                            System.out.println("오류: 대상 계좌번호를 찾을 수 없습니다. 돌아가고 싶다면 0을 입력하세요.");
                            System.out.print("계좌번호: ");
                            targetNumber = s.nextLine();
                        }
                        System.out.print("예금액: ");
                        targetBalance = Integer.parseInt(s.nextLine());
                        while (targetAccount.getBalance() + targetBalance < Account.MIN_BALANCE || targetAccount.getBalance() + targetBalance > Account.MAX_BALANCE ||
                                targetBalance < Account.MIN_BALANCE || targetBalance > Account.MAX_BALANCE) {
                            System.out.println("오류: 예금 후 소지 금액이 0원에서 100만원 사이가 아니거나 예금액을 0원에서 100만원 사이로 설정해주십시오.");
                            System.out.print("예금액: ");
                            targetBalance = Integer.parseInt(s.nextLine());
                        }
                        targetAccount.setBalance(targetAccount.getBalance() + targetBalance);
                        System.out.println("결과: 예금이 성공되었습니다.");
                    } catch (Exception e) {
                        System.out.println("[" + e.getMessage() + "] 오류 발생");
                        break;
                    }
                    break;
                case 4:
                    String targetNum = "";
                    int targetBal = 0;
                    Account targetAcc;
                    System.out.println("---------");
                    System.out.println("출금");
                    System.out.println("---------");
                    try {
                        System.out.print("계좌번호: ");
                        targetNum = s.nextLine();
                        targetFind:
                        while (true) {
                            if (targetNum.equals("0")) {
                                System.out.println("출금을 중단합니다.");
                                break select;
                            }
                            for (int i = 0; i < accounts.length; i++) {
                                if (accounts[i].getNumber().equals(targetNum)) {
                                    targetAcc = accounts[i];
                                    break targetFind;
                                }
                            }
                            System.out.println("오류: 대상 계좌번호를 찾을 수 없습니다. 돌아가고 싶다면 0을 입력하세요.");
                            System.out.print("계좌번호: ");
                            targetNum = s.nextLine();
                        }
                        System.out.print("출금액: ");
                        targetBal = Integer.parseInt(s.nextLine());
                        while (targetAcc.getBalance() - targetBal < Account.MIN_BALANCE || targetAcc.getBalance() - targetBal > Account.MAX_BALANCE ||
                                targetBal < Account.MIN_BALANCE || targetBal > Account.MAX_BALANCE) {
                            System.out.println("오류: 출금 후 소지 금액이 0원에서 100만원 사이가 아니거나 출금액을 0원에서 100만원 사이로 설정해주십시오.");
                            System.out.print("출금액: ");
                            targetBal = Integer.parseInt(s.nextLine());
                        }
                        targetAcc.setBalance(targetAcc.getBalance() - targetBal);
                        System.out.println("결과: 출금이 성공되었습니다.");
                    } catch (Exception e) {
                        System.out.println("[" + e.getMessage() + "] 오류 발생");
                        break;
                    }
                    break;
                case 5:
                    System.out.println("프로그램 종료");
                    break start;
            }
        }
    }

}
