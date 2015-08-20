package com.vk.hotte;


public class MoneyTransfer {

    public void transfer(Account sender, Account recipient, int amount) {

        try {

            sender.substractMoney(amount);
            recipient.addMoney(amount);

        } catch (InvalidAmountException exception) {


        }
    }

}
