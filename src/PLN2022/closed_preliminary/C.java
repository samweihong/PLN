package PLN2022.closed_preliminary;

import java.util.Scanner;

public class C {
    static Scanner sc = new Scanner(System.in);

    public static void solution() {
        int a = sc.nextInt();
        int b = sc.nextInt();
        int firstR = b % 10;
        int count = 1;
        int sum = firstR;
        for (int i = b+b; i <= a; i += b) {
            int r = i % 10;
            if (r == firstR)
                break;
            sum += r;
            count++;
        }
        int group = a/b/count;
        int res = sum * group;
        for (int i = (group*count*b)+b; i <= a; i += b) {
            res += i % 10;
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
