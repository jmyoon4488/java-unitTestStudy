public class BaseballGame {
    /**
     * Baseball Game
     * 1. 서로 다른 1~9까지의 숫자로 이루어진 3자리 숫자를 맞추는 게임
     * 2. 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 전혀 없으면 포볼 또는 낫싱 힌트 제공
     *
     * ex)
     * 맞춰야 하는 컴퓨터의 랜덤 숫자가 843 일때
     * 사용자가 148 을 입력하면 -> 1스트라이크 1볼
     * 사용자가 279 을 입력하면 -> 포볼 or 낫싱
     * 사용자가 543 을 입력하면 -> 2스트라이크
     * 사용자가 843 을 입력하면 -> 3스트라이크
     * 이렇게 3개 숫자를 모두 맞추면 게임 종료 후 게임 다시 시작하거나 완전히 종료
     */

    private boolean isRegame = true;
    public static int BALL_SIZE_OPTION = 3;

    Computer computer;
    Player player;

    public void playGame() {
        computer = new Computer();
        computer.getRandomBallNumber();
        player = new Player();

        requestPlayerInput();
        player.requestPlayerNumber();

        comparePlayerWithComputer(computer, player);
    }

    private void comparePlayerWithComputer(Computer computer, Player player) {
        Ball cBall = computer.ball;
        Ball pBall = player.ball;

    }

    private void requestPlayerInput() {
        // TODO
    }


}