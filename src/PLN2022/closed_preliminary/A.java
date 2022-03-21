package PLN2022.closed_preliminary;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class A {
    static Scanner sc = new Scanner(System.in);

    /**
     * Determine if it is possible that the second string can be created using the letters contained in the first string.
     *
     * Intuition
     * The condition is equivalent to:
     * (1) The first string must contain every letter in the second string.
     * (2) For each letter, its number of occurrence in the second string must be not larger than in the first string.
     */
    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();
        
        String first = sc.nextLine();
        String second = sc.nextLine();

        // If the second string contains more letters than the first string,
        // there must exist at least a letter in the second string that does not exist in the first string.
        // Thus, it violates statement (1).
        if (second.length() > first.length()) {
            System.out.println("not possible");
            return;
        }

        // Calculate the number of occurrence of all letters and store it in a map.
        for (char c : first.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        for (char c : second.toCharArray()) {
            // Occurrence in first string < occurrence in second string, is equivalent to
            // Occurrence in first string - occurrence in second string < 0
            // Therefore, if (occurrence in first string - occurrence in second string == 0) before the decrement,
            // then it will violate the statement (2).
            if (map.getOrDefault(c, 0) == 0) {
                System.out.println("not possible");
                return;
            }
            map.put(c, map.getOrDefault(c, 0) - 1);
        }

        // Otherwise, both statements (1) and (2) are satisfied.
        System.out.println("possible");
    }
}
