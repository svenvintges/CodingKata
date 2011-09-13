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

    private static final int SCORE_NEEDED_TO_WIN_THE_GAME = 3;
    private static final int SCORE_LOVE = 0;
    private static final int SCORE_FIFTEEN = 1;
    private static final int SCORE_THIRTY = 2;
    private static final int SCORE_FORTY = 3;
    private int scorePlayer1 = 0, scorePlayer2 = 0;
    private String namePlayer1 = "";
    private String namePlayer2 = "";


    public TennisGame(String nameOfPlayer1, String nameOfPlayer2) {
        this.namePlayer1 = nameOfPlayer1;
        this.namePlayer2 = nameOfPlayer2;
    }


    //TODO Refactoring is needed to lower the cyclomatic complexity.
    public final String getScoreAsTextualRepresentation() {
        String scorePlayer1Text, scorePlayer2Text;
        scorePlayer1Text = translateScoreToTextualRepresentation(scorePlayer1);
        scorePlayer2Text = translateScoreToTextualRepresentation(scorePlayer2);

        if (gameIsTie()) {
            if (scoreIsFourtyOrHigher()) {
                return "Deuce";
            }
            return scorePlayer1Text + " all";
        }

        if (playerOneHasEnoughPointsToWin()) {
            if (scoreDifferenceIsMoreThenOne() && player1HasMorePointsThanPlayer2()) {
                return namePlayer1 + " wins";
            } else if (playerOneHasAdvantage()) {
                return "Advantage " + namePlayer1;
            }
        }

        if (playerTwoHasEnoughPointsToWin()) {
            if (scoreDifferenceIsMoreThenOne() && player2HasMorePointsThanPlayer1()) {
                return namePlayer2 + " wins";
            } else if (playerTwoHasAdvantage()) {
                return "Advantage " + namePlayer2;
            }
        }


        return scorePlayer1Text + "," + scorePlayer2Text;
    }


    private boolean player2HasMorePointsThanPlayer1() {
        return scorePlayer2 > scorePlayer1;
    }

    private boolean player1HasMorePointsThanPlayer2() {
        return scorePlayer1 > scorePlayer2;
    }

    private boolean playerOneHasAdvantage() {
        return scorePlayer1 - scorePlayer2 == 1;
    }

    private boolean playerTwoHasAdvantage() {
        return scorePlayer2 - scorePlayer1 == 1;
    }

    private boolean scoreDifferenceIsMoreThenOne() {
        return Math.abs(scorePlayer1 - scorePlayer2) > 1;
    }

    private boolean playerOneHasEnoughPointsToWin() {
        return scorePlayer1 > SCORE_NEEDED_TO_WIN_THE_GAME;
    }

    private boolean playerTwoHasEnoughPointsToWin() {
        return scorePlayer2 > SCORE_NEEDED_TO_WIN_THE_GAME;
    }

    private boolean scoreIsFourtyOrHigher() {
        return scorePlayer1 > SCORE_THIRTY;
    }

    private boolean gameIsTie() {
        return scorePlayer1 == scorePlayer2;
    }


    private String translateScoreToTextualRepresentation(int score) {
        switch (score) {
            case SCORE_LOVE:
                return "Love";
            case SCORE_FIFTEEN:
                return "Fifteen";
            case SCORE_THIRTY:
                return "Thirty";
            case SCORE_FORTY:
                return "Forty";
            default:
                return "";
        }
    }


    public final void playerOneScores() {
        scorePlayer1++;
    }

    public final void playerTwoScores() {
        scorePlayer2++;
    }
}
