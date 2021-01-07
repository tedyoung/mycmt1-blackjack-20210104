package com.jitterted.ebp.blackjack;

public class Wallet {

  private int balance = 0;

  public Wallet() {
  }

  public boolean isEmpty() {
    return balance == 0;
  }

  public void addMoney(int amount) {
    ensureAmountNotLessThanZero(amount);
    balance += amount;
  }

  public int balance() {
    return balance;
  }

  public void bet(int amount) {
    ensureAmountNotLessThanZero(amount);
    ensureSufficientBalance(amount);
    balance -= amount;
  }

  private void ensureAmountNotLessThanZero(int amount) {
    if (amount < 0) {
      throw new IllegalArgumentException();
    }
  }

  private void ensureSufficientBalance(int amount) {
    if (amount > balance) {
      throw new IllegalArgumentException();
    }
  }
}
