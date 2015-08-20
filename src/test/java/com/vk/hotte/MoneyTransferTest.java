package com.vk.hotte;

import org.junit.Assert;
import org.junit.Test;



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
}
