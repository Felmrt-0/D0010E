package tutorial;

public class LowestNumber {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.print("Error, no arguments found.");
        } else {
            int lowest = Integer.MAX_VALUE;
            int temp;
            for (int i = 0; i < args.length; i++) {
                temp = Integer.parseInt(args[i]);
                if (temp < lowest) {
                    lowest = temp;
                }
            }
            System.out.println("The lowest number was: " + lowest);
        }
    }
}
