import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    Computer computer;

    @BeforeEach
    void setUp() {
        computer = new Computer();
    }

    @Test
    @DisplayName("Get Random number")
    void getRandomNumber() {
        String randomNumberStr = computer.getRandomBallNumber();
        assertThat(randomNumberStr)
                .isNotEmpty();
    }

}