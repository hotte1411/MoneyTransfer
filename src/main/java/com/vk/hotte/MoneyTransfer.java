package com.vk.hotte;


public class MoneyTransfer {

    private int sum;
    private int senderMoney;
    private int recipientMoney;

    public void transfer(Account sender, Account recipient, int amount) {

        sum = getSum(sender, recipient);
        senderMoney = sender.getMoney();
        recipientMoney = recipient.getMoney();

        try {

            sender.subtractMoney(amount);
            recipient.addMoney(amount);

        } catch (InvalidAmountException exception) {

            if(sum != getSum(sender, recipient)) {
                sender.setMoney(senderMoney);
                recipient.setMoney(recipientMoney);
            }
        }
    }

    private int getSum(Account sender, Account recipient) {
        return sender.getMoney() + recipient.getMoney();
    }
}
