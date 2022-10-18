package maro.study.cicd;

public class PasswordMeter {
    public PasswordStrength meter(String pw) {
        if(pw == null || pw.isEmpty())
            throw new IllegalArgumentException();

        boolean lengthRule = pw.length() >=8;
        if(!lengthRule){
            return PasswordStrength.NORMAL;
        }

        boolean foundUppercase = false;
        for(char ch : pw.toCharArray()){
            if(ch >= 'A' && ch <= 'Z') {
                foundUppercase = true;
                break;
            }
        }
        if(!foundUppercase){
            return PasswordStrength.NORMAL;
        }

        return PasswordStrength.STRONG;
    }
}
