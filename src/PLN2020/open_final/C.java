package PLN2020.open_final;

import java.util.Scanner;

public class C {
    static Scanner sc = new Scanner(System.in);

    public static void solution() {
        int k = sc.nextInt();
        System.out.print(3 * k * (k+1) * (k+1) + " ");
        System.out.println((int) Math.pow(k+1, 3));
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            solution();
        }
    }
}
