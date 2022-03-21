package PLN2022.closed_preliminary;

import java.util.Scanner;

public class B {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int maxW = 0;
        int maxH = 0;
        for (int i = 0; i < n; i++) {
            if (sc.next().equals("+")) {
                int w = sc.nextInt();
                int h = sc.nextInt();
                maxW = Math.max(maxW, Math.max(w, h));
                maxH = Math.max(maxH, Math.min(w, h));
            } else {
                int queryW = sc.nextInt();
                int queryH = sc.nextInt();
                if (maxW <= Math.max(queryW, queryH) && maxH <= Math.min(queryW, queryH))
                    System.out.println("1");
                else
                    System.out.println("0");
            }
        }
    }
}
