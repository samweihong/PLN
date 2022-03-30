package PLN2020.open_final;

import java.util.Scanner;

public class E {
    static Scanner sc = new Scanner(System.in);

    public static String solution() {
        int[][] coords = new int[4][2];
        for (int i = 0; i < 4; i++) {
            coords[i][0] = sc.nextInt();
            coords[i][1] = sc.nextInt();
        }
        reorder(coords);

        boolean ab_cdIsParallel = isParallel(coords, 0, 1, 2, 3);
        boolean bc_adIsParallel = isParallel(coords, 1, 2, 0, 3);

        if (!ab_cdIsParallel && !bc_adIsParallel) {
            return "Ordinary Quadrilateral";
        }
        if (ab_cdIsParallel && bc_adIsParallel) {
            boolean diagonalIsPerpendicular = isPerpendicular(coords, 0, 2, 1, 3);
            if (diagonalIsPerpendicular) {
                if (isPerpendicular(coords, 0, 1, 1, 2))
                    return "Square";
                else
                    return "Rhombus";
            } else {
                if (isPerpendicular(coords, 0, 1, 1, 2))
                    return "Rectangle";
                else
                    return "Parallelogram";
            }
        }
        return "Trapezium";
    }

    public static void reorder(int[][] coords) {
        int N = coords.length;
        double x = 0;
        double y = 0;
        for (int[] coord : coords) {
            x += coord[0];
            y += coord[1];
        }
        x /= 4;
        y /= 4;

        double[] angle = new double[N];
        for (int i = 0; i < N; i++)
            angle[i] = Math.atan2(coords[i][1]-y, coords[i][0]-x);

        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i+1; j < N; j++)
                if (angle[j] < angle[min])
                    min = j;

            double temp = angle[i];
            angle[i] = angle[min];
            angle[min] = temp;

            int[] t = coords[i];
            coords[i] = coords[min];
            coords[min] = t;
        }
    }

    public static boolean isParallel(int[][] coords, int a, int b, int c, int d) {
        return (coords[b][1]-coords[a][1])*(coords[d][0]-coords[c][0]) == (coords[d][1]-coords[c][1])*(coords[b][0]-coords[a][0]);
    }

    public static boolean isPerpendicular(int[][] coords, int a, int b, int c, int d) {
        return (coords[b][1]-coords[a][1])*(coords[d][1]-coords[c][1]) == -(coords[d][0]-coords[c][0])*(coords[b][0]-coords[a][0]);
    }

    public static void main(String[] args) {
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            System.out.println(solution());
        }
    }
}
