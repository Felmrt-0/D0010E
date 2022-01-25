public class Raise {

    public static int recHalfCount;
    public static int recOneCount;

    public static double recRaiseOne(double x, int k) {
        if (k == 0) {
            return 1.0;
        } else {
            recOneCount++;
            return x * recRaiseOne(x, k - 1);
        }
    }

    public static double recRaiseHalf(double x, int k) {
        if (k == 0) {
            return 1.0;
        } else if (k % 2 == 0) {
            recHalfCount++;
            double rec = recRaiseHalf(x, k / 2);
            return rec * rec;
        } else {
            recHalfCount++;
            double rec = recRaiseHalf(x, k / 2);
            return x * rec * rec;
        }
    }

    public static void main(String[] args) {
        double x = 1.5;
        for (int k = 1; k <= 15; k++) {
            recOneCount = 0;
            recHalfCount = 0;
            System.out.println("RecRaiseOne for x = " + x + " and k = " + k + " = " + recRaiseOne(x, k) + ", and took " + recOneCount + " recursive calls");
            System.out.println("RecRaiseHalf for x = " + x + " and k = " + k + " = " + recRaiseHalf(x, k) + ", and took " + recHalfCount + " recursive calls");
            System.out.println();

        }
    }
}
