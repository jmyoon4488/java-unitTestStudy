import java.util.*;

public class Computer {
    public Ball ball;

    public Computer() {
        this.ball = new Ball();
    }

    public void getRandomBallNumber() {
        ball.generateRandomBallState();
    }
}
