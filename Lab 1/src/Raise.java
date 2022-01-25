public class Raise {

    public static double recRaiseOne(double x, int k) {
        if (k == 0) {
            return 1.0;
        } else {
            return x * recRaiseOne(x, k - 1);
        }
    }

    public static double recRaiseHalf(double x, int k) {
        if (k == 0) {
            return 1;
        } else if (k % 2 == 0) {
            return Math.pow(x * Math.floor(k / 2), 2);
        } else {
            return x * Math.pow(x * Math.floor(k / 2), 2);
        }
    }
}
