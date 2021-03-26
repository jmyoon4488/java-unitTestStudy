import java.util.*;

public class Computer {
    private Ball ball;

    public Computer() {
        this.ball = new Ball();
    }

    public String getRandomBallNumber() {
        ArrayList<Integer> baseNumberList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        for (int i = 0; i < BaseballGame.BALL_SIZE_OPTION; i++) {
            int randomIndex = getRandomIndex(baseNumberList.size());
            ball.ballNumberArr[i] = baseNumberList.get(randomIndex);
            baseNumberList.remove(randomIndex);
        }
        ball.setBallNumberStr(getNumStrFromIntArr(ball.ballNumberArr));
        return ball.getBallNumberStr();
    }

    private String getNumStrFromIntArr(int[] baseNumberList) {
        StringBuilder numberStrBuilder = new StringBuilder();
        for (int num : baseNumberList) {
            numberStrBuilder.append(num);
        }
        return numberStrBuilder.toString();
    }

    private int getRandomIndex(int range) {
        return (int) (Math.random() * (range - 1));
    }
}
