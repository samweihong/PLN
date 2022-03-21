package PLN2022.closed_preliminary;

import java.util.Scanner;

public class B {
    static Scanner sc = new Scanner(System.in);

    public static void solution() {
        int n = sc.nextInt();
        int maxW = 0;
        int maxH = 0;
        for (int i = 0; i < n; i++) {
            String c = sc.next();
            if (c.equals("+")) {
                int w = sc.nextInt();
                int h = sc.nextInt();
                if (w > h) {
                    maxW = Math.max(maxW, w);
                    maxH = Math.max(maxH, h);
                } else {
                    maxW = Math.max(maxW, h);
                    maxH = Math.max(maxH, w);
                }
                continue;
            }
            if (c.equals("?")) {
                int queryW = sc.nextInt();
                int queryH = sc.nextInt();
                if (maxW <= queryW && maxH <= queryH ||
                    maxH <= queryW && maxW <= queryH)
                    System.out.println("1");
                else
                    System.out.println("0");
            }
        }
    }

    public static void main(String[] args) {
        solution();
    }
}
