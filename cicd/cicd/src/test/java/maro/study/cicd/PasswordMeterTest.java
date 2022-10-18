package maro.study.cicd;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PasswordMeterTest {

    private PasswordMeter passwordMeter = new PasswordMeter();

    @DisplayName("널 입력이면 익셉션 발생")
    @Test
    void nullInput() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(()-> passwordMeter.meter(null));
    }

    @DisplayName("빈값 입력이면 익셉션 발생")
    @Test
    void emptyInput() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(()-> passwordMeter.meter(""));
    }

    @DisplayName("모든 조건을 충족하면 강함")
    @Test
    void meetAllRules() {
        PasswordStrength result = passwordMeter.meter("abcABC123");
        assertThat(result).isEqualTo(PasswordStrength.STRONG);
        PasswordStrength result2 = passwordMeter.meter("123abcABC");
        assertThat(result2).isEqualTo(PasswordStrength.STRONG);
    }
    @DisplayName("길이가 8미만, 다른 조건은 충족하는 경우")
    @Test
    void digitAndUppercase() {
        PasswordStrength result = passwordMeter.meter("abcC123");
        assertThat(result).isEqualTo(PasswordStrength.NORMAL);
    }
}
