package PLN2022.open_preliminary;

import java.util.Scanner;

public class D {
    static Scanner sc = new Scanner(System.in);
    static double[][][] coords;

    public static void solution() {
        int N = sc.nextInt();
        coords = new double[N][2][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++)
                for (int k = 0; k < 2; k++)
                    coords[i][j][k] = sc.nextDouble();
            if (i == 0) continue;

            for (int j = 0; j < i; j++) {
                if (!intersect(i, j)) {
                    System.out.println("False");
                    return;
                }
            }
        }
        System.out.println("True");
    }

    public static boolean intersect(int i, int j) {
        if (orientation(coords[i][0], coords[i][1], coords[j][0]) == orientation(coords[i][0], coords[i][1], coords[j][1]))
            return false;
        if (orientation(coords[j][0], coords[j][1], coords[i][0]) == orientation(coords[j][0], coords[j][1], coords[i][1]))
            return false;
        return true;
    }

    public static int orientation(double[] a, double[] b, double[] c) {
        double res = (b[1]-a[1])*(c[0]-b[0]) - (b[0]-a[0])*(c[1]-b[1]);
        if (res == 0) return 0;
        if (res > 0) return 1;
        return 2;
    }

    public static void main(String[] args) {
        solution();
    }
}
