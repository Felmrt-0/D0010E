package tutorial;

public class robberLanguage {
    static String RobberLanguage(String s) {
        if (s.length() == 0) {
            return "";
        } else {
            if (isConstant(s.charAt(0))) {
                return s.charAt(0) + "o" + s.charAt(0) + RobberLanguage(s.substring(1, s.length()));
            } else {
                return s.charAt(0) + RobberLanguage(s.substring(1, s.length()));
            }

        }
    }

    static boolean isConstant(char c) {
        String s = "bcdfghjklmnpqrstvwxzBCDFGHJKLMNPQRSTVWXZ";
        if (s.indexOf(c) == -1) {
            return false;
        } else return true;

    }
    public static void main(String[] args){
        System.out.print(RobberLanguage("pannkakor"));
    }
}
