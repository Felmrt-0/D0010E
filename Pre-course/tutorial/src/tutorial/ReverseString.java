package tutorial;

public class ReverseString {
    static String reverseString(String s){
        if(s.length()==0){
            return "";
        }
        else{
            return(reverseString(s.substring(1,s.length()))+s.charAt(0));
        }
    }
    public static void main(String[] args){
        String s = reverseString("agnoB");
        System.out.print(s);
    }
}

