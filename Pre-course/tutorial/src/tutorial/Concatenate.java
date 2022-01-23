package tutorial;

public class Concatenate {

    public static void main(String[] args){
        for(int i = 0; i < args.length; i++){
            System.out.println(args[i]+" "+args[i].length());
        }
    }
}
