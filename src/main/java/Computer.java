public class Computer {
    private Ball ball = new Ball();

    public void getRandomBallNumber() {
        ball.generateRandomBallNumber();
    }

    public Ball getBall() {
        return ball;
    }
}
