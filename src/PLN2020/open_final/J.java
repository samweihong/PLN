package PLN2020.open_final;

import java.util.Scanner;

public class J {
    static Scanner sc = new Scanner(System.in);

    public static void solution() {
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i-1])
                res[i] = res[i-1]+1;
            else
                res[i] = 1;
        }

        int sum = res[n-1];
        for (int i = n-2; i >= 0; i--) {
            if (arr[i] > arr[i+1])
                res[i] = Math.max(res[i], res[i+1]+1);
            sum += res[i];
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        solution();
    }
}
