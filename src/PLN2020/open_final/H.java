package PLN2020.open_final;

import java.util.Scanner;

public class H {
    static Scanner sc = new Scanner(System.in);

    public static void solution() {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] += Math.max((i > 0 ? map[i-1][j] : 0),
                                      (j > 0 ? map[i][j-1] : 0));
            }
        }
        System.out.println(map[n-1][m-1]);
    }

    public static void main(String[] args) {
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            solution();
        }
    }
}
