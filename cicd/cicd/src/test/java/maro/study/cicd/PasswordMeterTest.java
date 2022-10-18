package maro.study.cicd;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PasswordMeterTest {

    @DisplayName("널 입력이면 익셉션 발생")
    @Test
    void nullInput() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(()-> new PasswordMeter().meter(null));
    }

    @DisplayName("빈값 입력이면 익셉션 발생")
    @Test
    void emptyInput() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(()-> new PasswordMeter().meter(""));
    }
}
