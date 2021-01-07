package com.jitterted.ebp.blackjack;

public class Wallet {

  private int balance = 0;
  private boolean isEmpty;

  public Wallet() {
    isEmpty = true;
  }

  public boolean isEmpty() {
    return isEmpty;
  }

  public void addMoney(int amount) {
    balance += amount;
    isEmpty = false;
  }

  public int balance() {
    return balance;
  }
}
