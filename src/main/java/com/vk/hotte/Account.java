package com.vk.hotte;


public class Account {

    private String name;
    private int money;

    public Account(String name) {
        this.name = name;
        this.money = 0;
    }

    public void addMoney(int amount) throws InvalidAmountException {
        if (amount >= 0) {
            money += amount;
        } else {
            throw new InvalidAmountException("Amount must be not negative");
        }
    }

    public void substractMoney(int amount) throws InvalidAmountException {

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
}
