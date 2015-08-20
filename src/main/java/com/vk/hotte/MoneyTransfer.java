package com.vk.hotte;


public class MoneyTransfer {

    int sum;
    int senderMoney;
    int recipientMoney;

    /**
     * Method transfers money from one account to second
     * @param sender is a Account from who need to transfer money
     * @param recipient  is a Account which need to get money
     * @param amount is a amount of money
     */
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
