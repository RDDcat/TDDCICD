package maro.study.cicd;

public class PasswordMeter {
    public PasswordStrength meter(String pw) {
        if(pw == null || pw.isEmpty())
            throw new IllegalArgumentException();

        boolean lengthRule = pw.length() >=8;
        if(!lengthRule){
            return PasswordStrength.NORMAL;
        }

        boolean foundUppercase = isFoundUppercase(pw);
        if(!foundUppercase){
            return PasswordStrength.NORMAL;
        }

        return PasswordStrength.STRONG;
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
