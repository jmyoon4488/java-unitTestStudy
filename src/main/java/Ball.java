import java.util.ArrayList;
import java.util.Arrays;

public class Ball {
    public static final String STR_STRIKE = "스트라이크";
    public static final String STR_BALL = "볼";

    private String ballNumberStr = "";
    public int[] ballNumberArr = null;

    public Ball () {
        ballNumberStr = "";
        ballNumberArr = new int[BaseballGame.BALL_SIZE_OPTION];
    }

    public String getBallNumberStr() {
        return ballNumberStr;
    }

    public void setBallNumberStr(String ballNumberStr) {
        this.ballNumberStr = ballNumberStr;
    }

    public void generateRandomBallState() {
        ArrayList<Integer> baseNumber = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        for (int i = 0; i < BaseballGame.BALL_SIZE_OPTION; i++) {
            int randomIndex = getRandomIndex(baseNumber);
            ballNumberArr[i] = baseNumber.get(randomIndex);
            baseNumber.remove(randomIndex);
        }
    }
    
    private int getRandomIndex(ArrayList<Integer> baseNumbers) {
        return (int) (Math.random() * (baseNumbers.size() - 1));
    }
}
