import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private int strikeCount = 0;
    private int ballCount = 0;
    public Ball ball = null;

    public Player() {
        this.ball = new Ball();
    }

    public void requestPlayerNumber() {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        setPlayerNumberToBall(input);
    }

    private void setPlayerNumberToBall(String input) {
        boolean isValidInput = this.ball.setBallNumber(input);

    }

    public boolean validInput(String input) {
        return false;
    }
}
