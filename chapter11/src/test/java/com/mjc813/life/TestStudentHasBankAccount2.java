package com.mjc813.life;

import com.mjc813.banking.BankAccount;
import com.mjc813.student.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestStudentHasBankAccount2 {
	private StudentHasBankAccount stuBank;

	@BeforeEach
	public void init() {
		stuBank = new StudentHasBankAccount(
				new Student("홍길동", "hhh1111")
				, new BankAccount("77-777-77-77", "홍길동")
		);
	}

	@Test
	public void TestIncome() {
		assertThat(this.stuBank.getCurrentMoney()).isEqualTo(0);
		this.stuBank.income(1000);
		this.stuBank.income(5000);
		this.stuBank.income(82000);
		assertThat(this.stuBank.getCurrentMoney()).isEqualTo(88000);
	}

	@Test
	public void TestOutcome() {
		assertThat(this.stuBank.getCurrentMoney()).isEqualTo(0);
		this.stuBank.income(100000);
		this.stuBank.outcome(20000);
		this.stuBank.outcome(3000);
		assertThat(this.stuBank.getCurrentMoney()).isEqualTo(77000);
	}

	@Test
	public void TestGetCurrentMoney() {
		assertThat(this.stuBank.getCurrentMoney()).isEqualTo(0);
		this.stuBank.income(100000);
		this.stuBank.outcome(10000);
		assertThat(this.stuBank.getCurrentMoney()).isEqualTo(90000);
	}
}
