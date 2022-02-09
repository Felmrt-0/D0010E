public class Main{
    public static int max (int[] a){
        int largest = a[0];
        for (int i = 1; i < a.length; i++){
            if(largest<a[i]){
                largest = a[i];
            }
        }
        return largest;
    }

    public static void sägMjau(int n){

        if(n!=0){
            System.out.print("Mjau");
            sägMjau(n-1);
        }
    }

    private static int max(int[] a, int idx){
        if(idx == -1){
            return a[a.length];
        }
    }

    public static void main(String[] args){
        
    }
}