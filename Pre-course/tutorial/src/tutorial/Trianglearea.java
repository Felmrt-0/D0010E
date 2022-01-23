package tutorial;

public class Trianglearea {
    static double triangleArea(double a, double b, double c) {
        double s = (a + b + c) / 2;
        double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));

        return area;
    }

    public static void main(String[] args) {
        System.out.print(triangleArea(1, 1, 1));
    }
}
