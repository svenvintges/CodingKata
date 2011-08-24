package nl.svenvintges.codekata.tennisgame;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: sven
 * Date: 8/24/11
 * Time: 9:52 PM
 * To change this template use File | Settings | File Templates.
 */

public class TennisGameTest {

    TennisGame game;

    @Before
    public void setUp() throws Exception {
        game = new TennisGame("Boris Becker", "Bjorg");
    }

    @Test
    public void testNewGameShouldReturnLoveAll() {
        String score = game.getScore();

        assertEquals("Love all", score);
    }

    @Test
    public void testPlayerOneWinsFirstBall() {
        game.playerOneScores();

        String score = game.getScore();
        assertEquals("Fifteen,Love", score);
    }

    @Test
    public void testFifteenAll() {
        game.playerOneScores();
        game.playerTwoScores();

        String score = game.getScore();
        assertEquals("Fifteen all", score);
    }

    @Test
    public void testPlayerTwoWinsFirstTwoBalls() {
        createScore(0, 2);

        String score = game.getScore();
        assertEquals("Love,Thirty", score);
    }


    @Test
    public void testPlayerOneWinsFirstThreeBalls() {
        createScore(3, 0);
        String score = game.getScore();
        assertEquals("Forty,Love", score);
    }

    @Test
    public void testPlayersAreDeuce() {
        createScore(3, 3);

        String score = game.getScore();
        assertEquals("Deuce", score);
    }

    @Test
    public void testPlayerOneWinsGame() {
        createScore(4, 0);

        String score = game.getScore();
        assertEquals("Boris Becker wins", score);
    }

    @Test
    public void testPlayerTwoWinsGame() {
        createScore(1, 4);

        String score = game.getScore();
        assertEquals("Bjorg wins", score);
    }

    @Test
    public void testPlayersAreDuce4() {
        createScore(4, 4);
        String score = game.getScore();
        assertEquals("Deuce", score);
    }

    @Test
    public void testPlayerTwoAdvantage() {
        createScore(4, 5);

        String score = game.getScore();
        assertEquals("Advantage Bjorg", score);
    }

    @Test
    public void testPlayerOneAdvantage() {
        createScore(5, 4);

        String score = game.getScore();
        assertEquals("Advantage Boris Becker", score);
    }

    @Test
    public void testPlayerTwoWins() {
        createScore(2, 4);
        String score = game.getScore();
        assertEquals("Bjorg wins", score);
    }


    @Test
    public void testPlayerTwoWinsAfterAdvantage() {
        createScore(6, 8);
        String score = game.getScore();
        assertEquals("Bjorg wins", score);
    }


    @Test
    public void testPlayerOneWinsAfterAdvantage() {
        createScore(8, 6);
        String score = game.getScore();
        assertEquals("Boris Becker wins", score);
    }

    private void createScore(int playerOneBalls, int playerTwoBalls) {
        for (int i = 0; i < playerOneBalls; i++) {
            game.playerOneScores();
        }
        for (int i = 0; i < playerTwoBalls; i++) {
            game.playerTwoScores();
        }
    }

}
