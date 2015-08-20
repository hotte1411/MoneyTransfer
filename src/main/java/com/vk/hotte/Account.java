package com.vk.hotte;

/**
 *  This class describes usual bank account with name and amount of money.
 *
 */
public class Account {

    private String name;
    private int money;

    public Account(String name, int money) {
        this.name = name;
        this.money = money;
    }

    /**
     * Method adds money to account
     * @param amount shows how much money need to add to account
     * @throws InvalidAmountException if amount is negative
     */
    public void addMoney(int amount) throws InvalidAmountException {
        if (amount >= 0) {
            money += amount;
        } else {
            throw new InvalidAmountException("Amount must be not negative");
        }
    }

    /**
     * Method subtracts money from account
     * @param amount shows how much money need to subtract from account
     * @throws InvalidAmountException if amount is negative or if money doesn't enough to subtract
     */
     public void subtractMoney(int amount) throws InvalidAmountException {

        if(amount > money) {
            throw new InvalidAmountException("Not enough money on account");
        }


        if (amount >= 0) {
            money -= amount;
        } else {
            throw new InvalidAmountException("Amount must be not negative");
        }
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
