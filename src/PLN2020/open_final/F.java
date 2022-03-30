package PLN2020.open_final;

import java.util.*;

public class F {
    static Scanner sc = new Scanner(System.in);
    static Map<Integer, ArrayList<String>> map;

    public static void solution() {
        int N = sc.nextInt();
        sc.nextLine();
        map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String word = sc.nextLine();
            map.computeIfAbsent(word.length(), integer -> new ArrayList<>());
            map.get(word.length()).add(word);
        }

        int M = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < M; i++) {
            String start = sc.next();
            String end = sc.next();
            sc.nextLine();
            System.out.println(start + " " + end + " " + BFS(start, end));
        }
    }

    public static int BFS(String start, String end) {
        ArrayList<String> list = map.get(start.length());
        boolean[] visited = new boolean[list.size()];

        Queue<String> q = new LinkedList<>();
        q.offer(start);
        int count = 0;
        while (true) {
            for (int size = q.size(); size > 0; size--) {
                String s = q.poll();
                if (s.equals(end))
                    return count;

                for (int index = 0; index < list.size(); index++) {
                    if (visited[index]) continue;

                    String curr = list.get(index);
                    if (diffOneChar(s, curr)) {
                        visited[index] = true;
                        q.offer(curr);
                    }
                }
            }
            count++;
        }
    }

    public static boolean diffOneChar(String s, String t) {
        int count = 0;
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) != t.charAt(i)) count++;
        return count == 1;
    }

    public static void main(String[] args) {
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            solution();
        }
    }
}
