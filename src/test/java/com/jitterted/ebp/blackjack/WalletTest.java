package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class WalletTest {

  @Test
  public void newWalletIsEmpty() throws Exception {
    Wallet wallet = new Wallet();

    assertThat(wallet.isEmpty())
        .isTrue();
  }

  @Test
  public void newWalletWhenAddMoneyThenIsNotEmpty() throws Exception {
    // given
    Wallet wallet = new Wallet();

    // when
    wallet.addMoney(10);

    // then
    assertThat(wallet.isEmpty())
        .isFalse();
  }

  @Test
  public void newWalletHasZeroBalance() throws Exception {
    Wallet wallet = new Wallet();

    assertThat(wallet.balance())
        .isZero();
  }

  @Test
  public void newWalletAdd15HasBalanceOf15() throws Exception {
    Wallet wallet = new Wallet();

    wallet.addMoney(15);

    assertThat(wallet.balance())
        .isEqualTo(15);
  }

  @Test
  public void newWalletAdd17AndAdd18HasBalanceOf35() throws Exception {
    Wallet wallet = new Wallet();

    wallet.addMoney(17);
    wallet.addMoney(18);

    assertThat(wallet.balance())
        .isEqualTo(17 + 18); // Evident Data
  }

}
