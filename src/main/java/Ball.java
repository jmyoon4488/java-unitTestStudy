
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

}
