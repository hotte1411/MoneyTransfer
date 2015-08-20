package com.vk.hotte;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;


public class MoneyTransferTest {

    @Test
    public void testSimpleTransfer() {
        Account sender = new Account("sender", 500);
        Account recipient = new Account("recipient", 50);
        MoneyTransfer transfer = new MoneyTransfer();

        transfer.transfer(sender, recipient, 60);

        Assert.assertEquals(440, sender.getMoney());
        Assert.assertEquals(110, recipient.getMoney());
    }

    @Test
    public void testTransferIfNotEnoughMoney() {
        Account sender = new Account("sender", 100);
        Account recipient = new Account("recipient", 50);
        MoneyTransfer transfer = new MoneyTransfer();

        transfer.transfer(sender, recipient, 600);

        Assert.assertEquals(100, sender.getMoney());
        Assert.assertEquals(50, recipient.getMoney());
    }

    @Test
    public void testTreadSafeTransfer() {
        final Account sender = new Account("sender", 10000);
        final Account recipient = new Account("recipient", 0);
        final MoneyTransfer transfer = new MoneyTransfer();

        Runnable runnable1 = new Runnable(){

            public void run() {
                while (sender.getMoney() > 0) {
                    try {
                        int rand = new Random().nextInt(3) + 1;
                        transfer.transfer(sender, recipient, rand);
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
}
