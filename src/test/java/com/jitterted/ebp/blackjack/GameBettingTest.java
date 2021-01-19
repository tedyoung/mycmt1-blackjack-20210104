package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GameBettingTest {

  @Test
  public void newGamePlayerBalanceIsZero() throws Exception {
    Game game = new Game();

    assertThat(game.playerBalance())
        .isZero();
  }

  @Test
  public void playerDeposit25ThenBalanceIs25() throws Exception {
    Game game = new Game();

    game.playerDeposits(25);

    assertThat(game.playerBalance())
        .isEqualTo(25);
  }

  @Test
  public void playerWith100BalanceBets75ThenBalanceIs25() throws Exception {
    Game game = new Game();
    game.playerDeposits(100);

    game.playerBets(75);

    assertThat(game.playerBalance())
        .isEqualTo(100 - 75);
  }

  @Test
  public void playerWith100Bets50AndWinsThenBalanceIs150() throws Exception {
    Game game = new Game();
    game.playerDeposits(100);
    game.playerBets(50);

    game.playerWins();

    assertThat(game.playerBalance())
        .isEqualTo(100 - 50 + (50 * 2));
  }

  @Test
  public void playerWith50Bets25AndLosesThenBalanceIs25() throws Exception {
    Game game = new Game();
    game.playerDeposits(50);
    game.playerBets(25);

    game.playerLoses();

    assertThat(game.playerBalance())
        .isEqualTo(50 - 25);
  }

  @Test
  public void playerWith75Bets50AndPushesThenBalanceIs75() throws Exception {
    Game game = new Game();
    game.playerDeposits(75);
    game.playerBets(50);

    game.playerPushes();

    assertThat(game.playerBalance())
        .isEqualTo(75 - 50 + 50);
  }

  @Test
  public void playerWith200Bets100AndWinsBlackjackThenBalance350() throws Exception {
    Game game = new Game();
    game.playerDeposits(200);
    game.playerBets(100);

    game.playerWinsBlackjack();

    assertThat(game.playerBalance())
        .isEqualTo(200 - 100 + ((int) (100 * 2.5)));
  }

}