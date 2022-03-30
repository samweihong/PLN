package PLN2022.open_preliminary;

import java.util.Scanner;

public class B {
    static Scanner sc = new Scanner(System.in);
    static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

    public static void solution() {
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                arr[i][j] = sc.nextInt();

        int maxCovid = 0;
        int maxOmicron = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) continue;
                if (arr[i][j] == 1)
                    maxCovid = Math.max(maxCovid, DFS(arr, i, j, 1));
                else
                    maxOmicron = Math.max(maxOmicron, DFS(arr, i, j, 2));
            }
        if (maxCovid > maxOmicron)
            System.out.println("MOH should focus on Covid-19");
        else
            System.out.println("MOH should focus on Omicron");
    }

    public static int DFS(int[][] arr, int i, int j, int type) {
        if (i < 0 || i == arr.length || j < 0 || j == arr.length) return 0;
        if (arr[i][j] == type) {
            arr[i][j] = 0;
            int total = 1;
            for (int[] dir : dirs)
                total += DFS(arr, i+dir[0], j+dir[1], type);
            return total;
        }
        return 0;
    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            solution();
        }
    }
}
