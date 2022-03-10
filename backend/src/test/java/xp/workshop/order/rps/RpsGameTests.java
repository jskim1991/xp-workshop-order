package xp.workshop.order.rps;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static xp.workshop.order.rps.Hand.*;

public class RpsGameTests {

    // P1 VS P2
    // R VS S = P1
    // R VS P = P2
    // R VS R = DRAW
    // R, S, P * 3 = 9
    //

    @Test
    public void rockVsScisorse_play_winnerIsPlayer1() {
        String result = RpsGame.play(ROCK, SCISORSE);
        assertThat(result, equalTo("PLAYER1"));
    }

    @Test
    public void rockVsPaper_play_winnerIsPlayer2() {
        String result = RpsGame.play(ROCK, PAPER);
        assertThat(result, equalTo("PLAYER2"));
    }

    @Test
    public void rockVsRock_play_draw() {
        String result = RpsGame.play(ROCK, ROCK);
        assertThat(result, equalTo("DRAW"));
    }

    @Test
    public void scisorseVsScisorse_play_draw() {
        String result = RpsGame.play(SCISORSE, SCISORSE);
        assertThat(result, equalTo("DRAW"));
    }

    @Test
    public void scisorseVsPaper_play_winnerIsPlayer1() {
        String result = RpsGame.play(SCISORSE, PAPER);
        assertThat(result, equalTo("PLAYER1"));
    }

    @Test
    public void scisorseVsRock_play_winnerPlayer2() {
        String result = RpsGame.play(SCISORSE, ROCK);
        assertThat(result, equalTo("PLAYER2"));
    }
}
