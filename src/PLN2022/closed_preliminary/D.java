package PLN2022.closed_preliminary;

import java.util.Scanner;

public class D {
    static Scanner sc = new Scanner(System.in);
    static int[][] dp;
    static int[] arr;

    public static void solution() {
        int V = sc.nextInt();
        int n = sc.nextInt();
        arr = new int[n];
        dp = new int[V+1][n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(V-max(V, n));
    }

    public static int max(int maximum, int i) {
        if (maximum == 0 || i == 0)
            return 0;
        if (dp[maximum][i-1] > 0) return dp[maximum][i-1];

        int res;
        if (arr[i-1] > maximum) {
            res = max(maximum, i-1);
        } else {
            res = Math.max(arr[i-1] + max(maximum - arr[i-1], i-1),
                  max(maximum, i-1));
        }
        dp[maximum][i-1] = res;
        return res;
    }

    public static void main(String[] args) {
        solution();
    }
}
