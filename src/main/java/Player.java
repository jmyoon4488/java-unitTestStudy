import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private int strikeCount = 0;
    private int ballCount = 0;
    private Ball ball = null;

    public Player() {
        this.ball = new Ball();
    }
}
