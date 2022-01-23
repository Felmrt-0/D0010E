public class LifeLength {
    public static int f1(int a0) {
        if (a0 == 1) {
            return a0;
        } else if (a0 % 2 == 0) {
            return a0 / 2;
        } else {
            return 3 * a0 + 1;
        }
    }

    public static int f2(int a0) {
        return f1(f1(a0));
    }

    public static int f4(int a0) {
        return f2(f2(a0));
    }

    public static int f8(int a0) {
        return f4(f4(a0));
    }

    public static int f16(int a0) {
        return f8(f8(a0));
    }

    public static int f32(int a0) {
        return f16(f16(a0));
    }

    public static int iterateF(int a0, int n) {
        for (int i = 1; i <= n; i++) {
            if (a0 == 1) {
                return 1;
            } else if (a0 % 2 == 0) {
                a0 = a0 / 2;
            } else {
                a0 = 3 * a0 + 1;
            }
        }
        return a0;
    }

    public static int iterLifeLength(int a0) {
        int count = 0;
        while (a0 != 1) {
            if (a0 % 2 == 0) {
                a0 = a0 / 2;
            } else {
                a0 = 3 * a0 + 1;
            }
            count++;
        }
        return count;
    }

    public static String intsToString(int x) {
        int y = iterLifeLength(x);
        return ("The life length of " + x + " is " + y + ".");
    }

    public static void main(String[] args) {
        System.out.print(intsToString(5));
        
    }
}
    