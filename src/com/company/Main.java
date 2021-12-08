package com.company;

import Exceptions.NegativeValueDepositException;
import Exceptions.NegativeValueException;
import Exceptions.NotEnoughMoneyException;
import Exceptions.OutLimitException;

public class Main {

    public static void main(String[] args) {
        Account PersonOne = new Account("Arthur", 500, 15, 200, 1000);
        Account PersonTwo = new Account("Thomas", 10, 17, 500, 100);

        for (int i = -200; i < 600; i += 200) {
            try {
                PersonOne.sendMoneyTo(PersonTwo, i);
                PersonTwo.balanceDeposit(i);
            } catch (NegativeValueDepositException | NotEnoughMoneyException | OutLimitException | NegativeValueException exception) {
                System.out.println(exception.getMessage());
            } finally {
                System.out.println("Stan konta PersonOne: " + PersonOne.balance + ". Stan konta PersonTwo: " + PersonTwo.balance);
                System.out.println(i);
                System.out.println();
            }
        }
    }
}
