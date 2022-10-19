package maro.study.cicd;

public class PasswordMeter {
    public PasswordStrength meter(String pw) {
        checkIllegalArgumentException(pw);

        int metCount = 0;
        metCount = getMetCount(pw, metCount);

        if(metCount == 1){
            return PasswordStrength.WEAK;
        }
        if(metCount == 2){
            return PasswordStrength.NORMAL;
        }

        return PasswordStrength.STRONG;
    }

    private int getMetCount(String pw, int metCount) {
        boolean lengthRule = pw.length() >=8;
        boolean foundUppercase = isFoundUppercase(pw);
        boolean foundDigit = isFoundDigit(pw);

        if(lengthRule) metCount++;
        if(foundUppercase) metCount++;
        if(foundDigit) metCount++;
        return metCount;
    }

    private static void checkIllegalArgumentException(String pw) {
        if(pw == null || pw.isEmpty())
            throw new IllegalArgumentException();
    }

    private boolean isFoundDigit(String pw) {
        for(char ch : pw.toCharArray()){
            if(ch >= '0' && ch <= '9') {
                return true;
            }
        }
        return false;
    }

    private static boolean isFoundUppercase(String pw) {
        for(char ch : pw.toCharArray()){
            if(ch >= 'A' && ch <= 'Z') {
                return true;
            }
        }
        return false;
    }
}
