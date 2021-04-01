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

    public boolean validBallNumberArr() {
        for (int i = 0; i < ballNumberArr.length - 1; i++) {
            for (int j = i + 1; j < ballNumberArr.length; j++) {
                if (this.ballNumberArr[i] == this.ballNumberArr[j]) return false;
            }
        }
        return true;
    }

    private int getRandomIndex(ArrayList<Integer> baseNumbers) {
        return (int) (Math.random() * (baseNumbers.size() - 1));
    }

    public boolean setBallNumber(String input) {
        char[] chars = input.toCharArray();
        if (chars.length != BaseballGame.BALL_SIZE_OPTION) return false;
        for (int i = 0; i < BaseballGame.BALL_SIZE_OPTION; i++) {
            int convertedNum = convertCharToInt(chars[i]);
            if (convertedNum == -1) return false;
            ballNumberArr[i] = Integer.parseInt(String.valueOf(chars[i]));
        }
        return true;
    }

    private int convertCharToInt(char ch) {
        if ('0' <= ch && ch <= '9') return Integer.parseInt(String.valueOf(ch));
        return -1;
    }
}
