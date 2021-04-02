import java.util.*;

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

    public static int BALL_SIZE_OPTION = 3;
    private HashMap<Integer, Integer> computerBallChecker = new HashMap<>();

    Computer computer;
    Player player;

    public boolean playGame() {
        computer = new Computer();
        player = new Player();
        initGame();

        while (true) {
            player.resetBallCount();
            inputPlayerNumberInBallState(player.getBall());
            comparePlayerBallWithChecker(player);
            System.out.println(player.getResultStateStr());;
            if (player.isAllStrike()) break;
        }
        return inputReplayGame();
    }

    private void initGame() {
        computer.getRandomBallNumber();
        System.out.println("com num : " + computer.getBall().getBallNumberStr());
        setComputerBallChecker(computer.getBall());
    }

    private boolean inputReplayGame() {
        System.out.println("다시 게임을 시작하려면 1을 입력해주세요. 게임을 종료하시려면 아무거나 입력해주세요.");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        if (input.isEmpty()) {
            System.out.println("게임을 종료합니다.");
            return false;
        }
        if ("1".equals(input)) {
            System.out.println("게임을 다시 시작합니다.");
            return true;
        }
        return false;
    }

    private void inputPlayerNumberInBallState(Ball pBall) {
        pBall.initBall();
        boolean isValidNumber = false;
        System.out.println("플레이어 숫자를 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        while (!isValidNumber) {
            boolean isSuccessBallSetting = pBall.isSuccessBallNumberSetting(sc.next());
            if (isPrintWrongInput(isSuccessBallSetting)) continue;
            isValidNumber = pBall.checkBallValidation();
            if (!isValidNumber) System.out.println("Input number duplicate / re input number");
        }
    }

    private void comparePlayerBallWithChecker(Player player) {
        for (int i = 0; i < BALL_SIZE_OPTION; i++) {
            Ball.BALL_TYPE type = checkBallStateFromChecker(i, player.getBall().ballNumberArr[i]);
            if (type == Ball.BALL_TYPE.STRIKE) player.setStrikeCount(player.getStrikeCount() + 1);
            if (type == Ball.BALL_TYPE.BALL) player.setBallCount(player.getBallCount() + 1);
        }
    }

    private Ball.BALL_TYPE checkBallStateFromChecker(int pBallNumberIndex, int pBallNumber) {
        if (computerBallChecker.containsKey(pBallNumber)) {
            if (computerBallChecker.get(pBallNumber) == pBallNumberIndex) return Ball.BALL_TYPE.STRIKE;
            return Ball.BALL_TYPE.BALL;
        }
        return Ball.BALL_TYPE.FOUR_BALL;
    }

    private void setComputerBallChecker(Ball cBall) {
        for (int i = 0; i < BALL_SIZE_OPTION; i++) {
            computerBallChecker.put(cBall.ballNumberArr[i], i);
        }
    }

    private boolean isPrintWrongInput(boolean inputSuccess) {
        if (!inputSuccess) System.out.println("Input number is rong / re input number");
        return !inputSuccess;
    }


}