package com.vk.hotte;


import java.util.Random;

/**
 * This class provides a opportunity to transfer money from one account to another.
 *
 */
public class MoneyTransfer {

    /**
     * Method transfers money from one account to second
     *
     * @param sender    is a Account from who need to transfer money
     * @param recipient is a Account which need to get money
     * @param amount    is a amount of money
     */
    public void transfer(Account sender, Account recipient, int amount) {

        System.out.println("[BEFORE] " + Thread.currentThread().getName() + ": " +
                " sum = " + (sender.getMoney() + recipient.getMoney()));

        int sum = getSum(sender, recipient);
        sender.subtractMoney(amount);

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        recipient.addMoney(amount);

        System.out.println("[AFTER] " + Thread.currentThread().getName() + ": " +
                " sum = " + (sender.getMoney() + recipient.getMoney()));

        if (sum != getSum(sender, recipient)) {
            throw new RuntimeException(sum + " != " + getSum(sender, recipient));
        }

    }

    private int getSum(Account sender, Account recipient) {
        return sender.getMoney() + recipient.getMoney();
    }
}
