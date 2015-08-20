package com.vk.hotte;


import java.util.Random;

public class MoneyTransfer {

    public static void main(String[] args) {
        final Account sender = new Account("sender", 10000);
        final Account recipient = new Account("recipient", 0);
        final MoneyTransfer transfer = new MoneyTransfer();

        Runnable runnable1 = new Runnable(){

            public void run() {
                while (sender.getMoney() > 0) {
                    try {
                        int rand = new Random().nextInt(3) + 1;
                        transfer.transfer(sender, recipient, rand);
                        Thread.sleep(3);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                }
            }
        };

        Thread thread1 = new Thread(runnable1, "first");
        Thread thread2 = new Thread(runnable1, "second");
        thread1.start();
        thread2.start();
    }

    int sum;
    int senderMoney;
    int recipientMoney;

    /**
     * Method transfers money from one account to second
     *
     * @param sender    is a Account from who need to transfer money
     * @param recipient is a Account which need to get money
     * @param amount    is a amount of money
     */
    public synchronized void transfer(Account sender, Account recipient, int amount) {

        System.out.println("[BEFORE] " + Thread.currentThread().getName() + ": " +
                " sender money - " + sender.getMoney() +
                ", recipient money - " + recipient.getMoney() +
                " sum = " + (sender.getMoney() + recipient.getMoney()));

        int sum = getSum(sender, recipient);
        sender.subtractMoney(amount);

        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        recipient.addMoney(amount);

        System.out.println("[AFTER] " + Thread.currentThread().getName() + ": " +
                " sender money - " + sender.getMoney() +
                ", recipient money - " + recipient.getMoney() +
                " sum = " + (sender.getMoney() + recipient.getMoney()));

        if (sum != getSum(sender, recipient)) {
            throw new RuntimeException(sum + " != " + getSum(sender, recipient));
        }

    }

    private int getSum(Account sender, Account recipient) {
        return sender.getMoney() + recipient.getMoney();
    }
}
