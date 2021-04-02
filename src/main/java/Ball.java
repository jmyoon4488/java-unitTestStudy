import java.util.*;

public class Ball {
    public static final String STRIKE_STR = "스트라이크";
    public static final String BALL_STR = "볼";
    public static final String FOUR_BALL_STR = "포볼";
    public static final String NOTHING_STR = "낫싱";

    public Integer[] ballNumberArr = new Integer[BaseballGame.BALL_SIZE_OPTION];

    public void initBall() {
        ballNumberArr = new Integer[BaseballGame.BALL_SIZE_OPTION];
    }

    public void generateRandomBallNumber() {
        ArrayList<Integer> baseNumber = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        for (int i = 0; i < BaseballGame.BALL_SIZE_OPTION; i++) {
            int randomIndex = getRandomIndex(baseNumber);
            ballNumberArr[i] = baseNumber.get(randomIndex);
            baseNumber.remove(randomIndex);
        }
    }

    public boolean isSuccessBallNumberSetting(String input) {
        char[] chars = input.toCharArray();
        if (chars.length != BaseballGame.BALL_SIZE_OPTION) return false;
        for (int i = 0; i < BaseballGame.BALL_SIZE_OPTION; i++) {
            int convertedNum = convertCharToInt(chars[i]);
            if (convertedNum == -1) return false;
            ballNumberArr[i] = convertedNum;
        }
        return true;
    }

    public boolean checkBallValidation() {
        HashSet<Integer> checkSet = new HashSet<>();
        for (int num : ballNumberArr) {
            if (checkSet.contains(num)) return false;
            checkSet.add(num);
        }
        return true;
    }

    private int getRandomIndex(ArrayList<Integer> baseNumbers) {
        return (int) (Math.random() * (baseNumbers.size() - 1));
    }

    private int convertCharToInt(char ch) {
        if ('0' <= ch && ch <= '9') return Integer.parseInt(String.valueOf(ch));
        return -1;
    }

    public String getBallNumberStr() {
        StringBuilder sb = new StringBuilder();
        for (int num : ballNumberArr) sb.append(num);
        return sb.toString();
    }

    enum BALL_TYPE {
        STRIKE(0, STRIKE_STR),
        BALL(1, BALL_STR),
        FOUR_BALL(2, FOUR_BALL_STR),
        NOTHING(3, NOTHING_STR);

        private int typeNum;
        private String typeStr;

        BALL_TYPE(int type, String str) {
            this.typeNum = type;
            this.typeStr = str;
        }

        public String getTypeStr() {
            return typeStr;
        }
    }
}


