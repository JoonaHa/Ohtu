package ohtu;

import java.util.HashMap;

public class TennisGame {

    private Player player1;
    private Player player2;
    private HashMap<String, String> possibleScores;

    public TennisGame(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
        possibleScores = new HashMap<>();
    }

    public void wonPoint(String player) {
        if (player == player1.getName()) {
            player1.addPoint();
        } else {
            player2.addPoint();
        }
    }

    public String getScore() {
        if (isEven()) {
            return evenScores();
        } else if (hasAdvantage()) {
            return advatageOrWin();
        } else {
            return normalScore();
        }

    }

    private String normalScore() {
        int tempScore;
        String score = "";
        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                tempScore = player1.getScore();
            } else {
                score += "-";
                tempScore = player2.getScore();
            }
            switch (tempScore) {
                case 0:
                    score += "Love";
                    break;
                case 1:
                    score += "Fifteen";
                    break;
                case 2:
                    score += "Thirty";
                    break;
                case 3:
                    score += "Forty";
                    break;
            }
        }
        return score;
    }

    private boolean isEven() {
        return player1.getScore() == player2.getScore();
    }

    private boolean hasAdvantage() {
        return player1.getScore() >= 4 || player2.getScore() >= 4;
    }

    private String advatageOrWin() {
        int scoreDifference = player1.getScore() - player2.getScore();

        if (scoreDifference == 1) {
            return "Advantage " + player1.getName();
        }
        if (scoreDifference == -1) {
            return "Advantage " + player2.getName();
        }
        if (scoreDifference >= 2) {
            return "Win for " + player1.getName();
        } else {
            return "Win for " + player2.getName();
        }

    }

    private String evenScores() {

        switch (player1.getScore()) {
            case 0:
                return "Love-All";

            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";

            case 3:
                return "Forty-All";
            default:
                return "Deuce";

        }

    }

}
