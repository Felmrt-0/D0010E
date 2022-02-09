public class Main {

    private static String beautify(String s, char bad){
        int stringLength = s.length();
        String sFix = "";
        if(stringLength == 0){
            return "String was empty.";
        }
        for (int i = 0; i < stringLength; i++){
            if(s.charAt(i) !='t'){
                sFix += s.charAt(i);
            }
        }
        return sFix;
    }

    public static void main(String[] args) {
        String x = beautify("trots", 't');
        System.out.print(x);
    }
}