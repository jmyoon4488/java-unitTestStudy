import java.util.*;

public class Computer {
    private Ball ball;

    public Computer() {
        this.ball = new Ball();
    }

    public void getRandomBallNumber() {
        ball.generateRandomBallState();
    }

    public Ball getBall() {
        return ball;
    }
}
