package tutorial;

public class HighestNumber {
    public static void main(String[] args){
        if(args.length == 0){
            System.out.println("Error, no arguments.");
        }
        else{
            int highest = Integer.MIN_VALUE;
            int temp;
            for (int i = 0; i < args.length; i++){
                temp = Integer.parseInt(args[i]);
                if(temp > highest){
                    highest = temp;
                }
            }
            System.out.println("The highest number was: "+highest);
        }
    }
}
