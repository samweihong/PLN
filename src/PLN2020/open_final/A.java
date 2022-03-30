package PLN2020.open_final;

import java.util.Scanner;

public class A {
    static Scanner sc = new Scanner(System.in);

    public static void solution() {
        String S = sc.next();
        int I = sc.nextInt();
        int O = sc.nextInt();
        try {
            int res = Integer.parseInt(S, I);
            System.out.println(Integer.toString(res, O));
        } catch (NumberFormatException e) {
            System.out.println("INVALID");
        }
    }

    public static void main(String[] args) {
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            solution();
        }
    }
}
