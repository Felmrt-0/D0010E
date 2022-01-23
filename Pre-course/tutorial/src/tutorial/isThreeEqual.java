package tutorial;

public class isThreeEqual {
    static boolean threeEqual(int a, int b, int c) {
        if (a == b & b == c) {
            return true;
        } else return false;
    }

    static boolean twoEqual(int a, int b) {
        if (a == b) {
            return true;
        } else return false;
    }
    public static void main(String[] args){
        int a = 3;
        int b = 2;
        int c = 3;
        System.out.println(threeEqual(a,b,c));
        System.out.println(twoEqual(a,b));
    }
}

