package com.company;

import Exceptions.NegativeValueDepositException;
import Exceptions.NegativeValueException;
import Exceptions.NotEnoughMoneyException;
import Exceptions.OutLimitException;

public class Account {
    String owner;
    int balance, accountNumber, limit, deposit;

    public Account(String owner, int balance, int accountNumber, int limit, int deposit) {
        this.owner = owner;
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.limit = limit;
        this.deposit = deposit;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public void sendMoneyTo (Account to, int value) throws NotEnoughMoneyException, OutLimitException, NegativeValueException {
        if (this.balance < value) {
            throw new NotEnoughMoneyException("Brakuje środków na koncie.");
        } if (this.limit < value) {
            throw new OutLimitException("Kwota przelewu jest większa niż limit!");
        } if (value < 0){
            throw new NegativeValueException("Kwota przelewu nie może być ujemną!");
        } else {
            this.balance -= value;
            to.balance += value;
        }
    }
    public void balanceDeposit (int value) throws NegativeValueDepositException {
        if (value < 0) {
            throw new NegativeValueDepositException("Error. Nie mozesz wpłacić ujemnej kwoty.");
        } else {
            this.balance += value;
        }
    }
}
