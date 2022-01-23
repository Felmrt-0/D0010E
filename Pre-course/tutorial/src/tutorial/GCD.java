package tutorial;

public class GCD {

    static void gcd(int a, int b) {
        int c;
        do {
            c = a % b;
            a = b;
            b = c;
        } while (c != 0);
        System.out.println(a);
    }

    public static void main(String[] args){
        gcd(10,5);
    }

}
