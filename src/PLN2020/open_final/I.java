package PLN2020.open_final;

import java.util.Scanner;

public class I {
    static Scanner sc = new Scanner(System.in);

    public static void solution() {
        String B = sc.nextLine();
        int left = 0;
        int right = 0;
        for (char c : B.toCharArray()) {
            if (c == '{')
                left++;
            else {
                if (left > 0)
                    left--;
                else
                    right++;
            }
        }
        int count = (left + right)/2;
        if (left % 2 == 1) count++;

        System.out.println(count);
    }

    public static void main(String[] args) {
        int T = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < T; i++) {
            solution();
        }
    }
}
