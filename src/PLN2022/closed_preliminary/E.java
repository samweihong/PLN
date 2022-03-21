package PLN2022.closed_preliminary;

import java.math.BigInteger;
import java.util.Scanner;

public class E {
    static Scanner sc = new Scanner(System.in);

    public static void solution() {
        int n = sc.nextInt();
        int r = sc.nextInt();
        BigInteger res = BigInteger.ONE;
        for (int i = 1; i <= r; i++) {
            res = res.multiply(BigInteger.valueOf(n-1+i))
                     .divide(BigInteger.valueOf(i));
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            solution();
        }
    }
}
