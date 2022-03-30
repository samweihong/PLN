package PLN2022.open_preliminary;

import java.util.Scanner;

public class A {
    static Scanner sc = new Scanner(System.in);

    public static void solution() {
        long S = sc.nextLong();
        long front = S / 9;
        int last = (int) (S % 9);

        if (last == 0)
            System.out.print(10*front-1 + " ");
        System.out.println(10*front+last);
    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < t; i++) {
            solution();
        }
    }
}
