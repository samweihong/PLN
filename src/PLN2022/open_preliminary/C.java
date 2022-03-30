package PLN2022.open_preliminary;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    static Scanner sc = new Scanner(System.in);

    public static void solution() {
        int N = sc.nextInt();
        int X = sc.nextInt();
        int Y = sc.nextInt();
        int[] x = new int[N];
        int[] refund = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            x[i] = num;
            sum += num;
        }
        for (int i = 0; i < N; i++)
            refund[i] = x[i] - sc.nextInt();

        Arrays.sort(refund);
        int n = N-X;
        for (int i = 0; i < n; i++) {
            sum -= refund[i];
        }
        for (int i = n; i < Y; i++) {
            if (refund[i] < 0) {
                sum -= refund[i];
            } else break;
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        solution();
    }
}
