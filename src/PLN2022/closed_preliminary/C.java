package PLN2022.closed_preliminary;

import java.util.Scanner;

public class C {
    static Scanner sc = new Scanner(System.in);

    /**
     * Calculate the sum of the last digits of all multiples of b that is less than a.
     *
     * Intuition
     * Observe that the last digits of multiples of b form a cycle:
     * Example: a = 75, b = 6
     * Multiples of 6 less than 75: 6, 12, 18, 24, 30, 36, 42, 48, 54, 60, 66, 72
     * Last digits: 6 2 8 4 0 (first complete cycle), 6 2 4 8 0 (second complete cycle), 6 2 (partial cycle)
     *
     * Therefore, it is obvious that
     * Sum of all last digits = number of complete cycles * sum of each cycle + sum of partial cycle
     */
    public static void solution() {
        int a = sc.nextInt();
        int b = sc.nextInt();
        int firstR = b % 10;
        int count = 1;    // Number of digits in each cycle
        int sum = firstR; // Sum of each cycle
        for (int i = b+b; i <= a; i += b) {
            int r = i % 10;
            if (r == firstR)
                break;
            sum += r;
            count++;
        }
        int group = a/b/count; // Number of complete cycles
        int res = sum * group;
        for (int i = (group*count*b)+b; i <= a; i += b) {
            res += i % 10; // Add sum of partial cycle
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            solution();
        }
    }
}
