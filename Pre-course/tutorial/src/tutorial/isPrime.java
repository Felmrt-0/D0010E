package tutorial;

public class isPrime {
    static boolean isPrime(int a){
        int i = 2;
        while(i <= Math.sqrt(a)){
            if(a%i==0){
                return false;
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args){
        System.out.print(isPrime(17));
    }
}
