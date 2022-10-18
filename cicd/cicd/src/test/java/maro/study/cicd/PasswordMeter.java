package maro.study.cicd;

public class PasswordMeter {
    public PasswordStrength meter(String pw) {
        if(pw == null || pw.isEmpty())
            throw new IllegalArgumentException();
        return PasswordStrength.STRONG;
    }
}
