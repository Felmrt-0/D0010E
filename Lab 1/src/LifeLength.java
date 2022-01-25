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
        return ("The life length (iteration) of " + x + " is " + y + ".");
    }

    public static int recLifeLength(int a0) {
        if (a0 == 1) {
            return 0;
        } else {
            return recLifeLength(f1(a0)) + 1;
        }
    }

    public static String recIntsToString(int x) {
        int y = recLifeLength(x);
        return ("The life length (recursive) of " + x + " is " + y + ".");
    }

    public static void task1(int a0) {
        System.out.print(f1(a0));
    }

    public static void task2(int a0) {
        System.out.print("f1=" + f1(a0) + " ");
        System.out.print("f2=" + f2(a0) + " ");
        System.out.print("f4=" + f4(a0) + " ");
        System.out.print("f8=" + f8(a0) + " ");
        System.out.print("f16=" + f16(a0) + " ");
        System.out.print("f32=" + f32(a0) + " ");
    }

    public static void task3() {
        System.out.println(iterateF(3,5));
        System.out.println(iterateF(42,3));
        System.out.println(iterateF(1,3));
    }

    public static void task4() {
        for(int i = 1; i<=16; i++){
            System.out.println(intsToString(i));
        }
    }

    public static void task6() {
        for(int i = 1; i<=16; i++){
            System.out.println(recIntsToString(i));
            System.out.println(intsToString(i));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int a0 = Integer.parseInt(args[0]);
        int n = 6;
        switch (n) {
            case 1:
                task1(a0);
                break;
            case 2:
                task2(a0);
                break;
            case 3:
                task3();
                break;
            case 4:
                task4();
                break;
            case 6:
                task6();
                break;
            default:
                System.out.print("Error, invalid argument.");
        }
    }
}
    