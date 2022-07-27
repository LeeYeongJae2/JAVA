package com.varxyz.banking.dao;



import com.varxyz.banking.domain.Account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class CheckingAccount extends Account{
	private double overdraftAmount;
}
