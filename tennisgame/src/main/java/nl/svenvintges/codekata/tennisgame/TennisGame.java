// From: http://codingdojo.org/cgi-bin/wiki.pl?KataCatalogue
package nl.svenvintges.codekata.tennisgame;

/**
 * Created by IntelliJ IDEA.
 * User: sven
 * Date: 8/24/11
 * Time: 9:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class TennisGame {

    int scorePlayer1 = 0, scorePlayer2 = 0;
    String player1 = "";
    String player2 = "";


    public TennisGame(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public String getScore() {
        String scorePlayer1Text = "", scorePlayer2Text = "";

        if (scorePlayer1 == 0 && scorePlayer2 == 0) {
            return "Love all";
        }

        scorePlayer1Text = translateScore(scorePlayer1);
        scorePlayer2Text = translateScore(scorePlayer2);

        if (scorePlayer1 == scorePlayer2) {
            if (scorePlayer1 > 2) {
                return "Deuce";
            }
            return scorePlayer1Text + " all";
        }

        if (scorePlayer1 > 3) {
            if (scorePlayer1 - scorePlayer2 > 1) {
                return player1 + " wins";
            } else if (scorePlayer1 - scorePlayer2 == 1) {
                return "Advantage " + player1;
            }
        }

        if (scorePlayer2 > 3) {
            if (scorePlayer2 - scorePlayer1 > 1) {
                return player2 + " wins";
            } else if (scorePlayer2 - scorePlayer1 == 1) {
                return "Advantage " + player2;
            }
        }


        return scorePlayer1Text + "," + scorePlayer2Text;
    }

    private String translateScore(int score) {
        switch (score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return "";
        }
    }


    public void playerOneScores() {
        scorePlayer1++;
    }

    public void playerTwoScores() {
        scorePlayer2++;
    }
}
