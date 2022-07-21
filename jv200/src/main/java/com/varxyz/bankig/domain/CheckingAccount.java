package com.varxyz.bankig.domain;

public class CheckingAccount extends Account {
	private double overdraftAmount;

	public CheckingAccount (String accountNum, double balance, double overdraftAmount) {
			super(accountNum, balance);
		    this.overdraftAmount = overdraftAmount;
		   }

	public void withdraw(double amount) {
		if (balance < amount) { // 잔고보다 출금금액이 많을시
			double remainMoney = amount - balance;
			if (overdraftAmount < remainMoney) {
				System.out.println("대출한도초과");
				System.out.println("대출최대한도 " + overdraftAmount);
			} else {
				overdraftAmount -= remainMoney;
				System.out.println(remainMoney + "만큼 대출받으셨습니다");
				balance -= balance + remainMoney;
				System.out.println("통장잔액" + balance);
			}
		} else {
			balance -= amount;
			System.out.println("출금하셨습니다");
			System.out.println("통장잔액" + balance);
		}
	}

}
