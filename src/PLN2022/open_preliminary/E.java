package PLN2022.open_preliminary;

import java.util.Scanner;

public class E {
    static Scanner sc = new Scanner(System.in);

    public static void solution() {
        int n = sc.nextInt();
        int k = sc.nextInt();
        int c = sc.nextInt();
        int l = sc.nextInt();
        int[] types = new int[n];
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            types[i] = sc.nextInt();
            values[i] = sc.nextInt();
        }
        double[] res = new double[n+1];
        for (int i = n-1; i >= 0; i--) {
            if (types[i] == 1)
                res[i] = Math.max(res[i+1], res[i+1] * (1-0.01*k) + values[i]);
            else
                res[i] = Math.max(res[i+1], res[i+1] * (1+0.01*c) - values[i]);
        }
        System.out.printf("%.2f", res[0]*l);
    }

    public static void main(String[] args) {
        solution();
    }
}
