package PLN2022.closed_preliminary;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class C {
    static Scanner sc = new Scanner(System.in);

    public static void solution() {
        int a = sc.nextInt();
        int b = sc.nextInt();
        Set<Integer> set = new HashSet<>();
        int count = 0;
        int sum = 0;
        for (int i = b; i <= a; i += b) {
            int r = i % 10;
            if (!set.contains(r)) {
                set.add(r);
                sum += r;
                count++;
                continue;
            }
            break;
        }
        int group = a/b/count;
        int res = sum * group;
        for (int i = (group*count*b)+b; i <= a; i += b) {
            res += i%10;
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
