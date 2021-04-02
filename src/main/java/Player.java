import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private int strikeCount = 0;
    private int ballCount = 0;
    private Ball ball = new Ball();

    public Ball getBall() {
        return ball;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public void setStrikeCount(int strikeCount) {
        this.strikeCount = strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void setBallCount(int ballCount) {
        this.ballCount = ballCount;
    }

    public void resetBallCount() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    public boolean isAllStrike() {
        if (strikeCount == BaseballGame.BALL_SIZE_OPTION) return true;
        return false;
    }

    public String getResultStateStr() {
        StringBuilder sb = new StringBuilder();
        if (strikeCount == 0 && ballCount == 0) sb.append(String.format("%s", Ball.BALL_TYPE.NOTHING.getTypeStr()));
        if (strikeCount != 0) sb.append(String.format("%d %s", strikeCount, Ball.BALL_TYPE.STRIKE.getTypeStr()));
        if (ballCount != 0) sb.append(String.format(" %d %s", ballCount, Ball.BALL_TYPE.BALL.getTypeStr()));
        return sb.toString().trim();
    }
}
