import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player();
    }

    @Test
    @DisplayName("test1")
    void getResultStateStrTest() {
        String expect = "";
        String targetStr = "";

        expect = "1 스트라이크";
        player.setStrikeCount(1);
        targetStr = player.getResultStateStr();
        assertThat(targetStr).isEqualTo(expect);

        player.resetBallCount();
        expect = "3 스트라이크";
        player.setStrikeCount(3);
        targetStr = player.getResultStateStr();
        assertThat(targetStr).isEqualTo(expect);

        player.resetBallCount();
        expect = "낫싱";
        player.setStrikeCount(0);
        player.setBallCount(0);
        targetStr = player.getResultStateStr();
        assertThat(targetStr).isEqualTo(expect);

        player.resetBallCount();
        expect = "2 볼";
        player.setBallCount(2);
        targetStr = player.getResultStateStr();
        assertThat(targetStr).isEqualTo(expect);
    }
}