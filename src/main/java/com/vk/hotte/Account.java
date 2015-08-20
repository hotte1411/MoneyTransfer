package com.vk.hotte;


public class Account {

    private String name;
    private int money;

    public Account(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public void addMoney(int amount) throws InvalidAmountException {
        if (amount >= 0) {
            money += amount;
        } else {
            throw new InvalidAmountException("Amount must be not negative");
        }
    }

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
