package PLN2022.closed_preliminary;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class A {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();
        
        String first = sc.nextLine();
        String second = sc.nextLine();
        if (second.length() > first.length()) {
            System.out.println("not possible");
            return;
        }

        for (char c : first.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        for (char c : second.toCharArray()) {
            if (map.getOrDefault(c, 0) == 0) {
                System.out.println("not possible");
                return;
            }
            map.put(c, map.getOrDefault(c, 0) - 1);
        }
        System.out.println("possible");
    }
}
