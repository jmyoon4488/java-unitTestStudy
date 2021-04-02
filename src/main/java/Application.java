public class Application {
    public static void main(String[] args) {
        BaseballGame game = new BaseballGame();
        while (game.playGame())
            continue;
        System.out.println("프로그램을 종료합니다!");
    }
}
