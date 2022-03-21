package PLN2022.closed_preliminary;

import java.util.Scanner;

public class B {
    static Scanner sc = new Scanner(System.in);

    /**
     * Determine if the card holder can fit all cards up to that point.
     *
     * Intuition
     * A card holder can fit all cards, is equivalent to
     * Its (width/height) is not smaller than the width of all cards, and
     * its (height/width) is not smaller than the height of all cards.
     *
     * This is again, equivalent to,
     * Its (width/height) is not smaller than the maximum width of all cards, and
     * its (height/width) is not smaller than the maximum height of all cards.
     *
     * Also, we consider the width of a card should always be its longer side to minimize the space required.
     * Imagine a (1 cm x 100 cm) card and another (100 cm x 1 cm) card,
     * the 100 cm should be taken as the width while the 1 cm should be taken as the height
     * so that the maximum width is 100 cm and the maximum height is 1 cm.
     * Otherwise, both the maximum width and height will be 100 cm.
     */
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
