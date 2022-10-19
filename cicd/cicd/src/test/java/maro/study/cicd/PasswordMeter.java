package maro.study.cicd;

public class PasswordMeter {
    public PasswordStrength meter(String pw) {
        if(pw == null || pw.isEmpty())
            throw new IllegalArgumentException();

        boolean lengthRule = pw.length() >=8;
        boolean foundUppercase = isFoundUppercase(pw);
        boolean foundDigit = isFoundDigit(pw);

        if(!lengthRule){
            return PasswordStrength.NORMAL;
        }
        if(!foundUppercase){
            return PasswordStrength.NORMAL;
        }
        if(!foundDigit){
            return PasswordStrength.NORMAL;
        }

        return PasswordStrength.STRONG;
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
