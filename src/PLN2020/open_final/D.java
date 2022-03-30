package PLN2020.open_final;

import java.util.Scanner;

public class D {
    static Scanner sc = new Scanner(System.in);
    static char[][] map;

    public static void solution() {
        int N = sc.nextInt();
        int H = sc.nextInt();
        int W = sc.nextInt();
        sc.nextLine();
        map = new char[H][W];
        int x = 0;
        int y = 0;
        for (int i = 0; i < H; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = line.charAt(j);
                if (line.charAt(j) == '@') {
                    x = i;
                    y = j;
                }
            }
        }
        System.out.println(DFS(new boolean[H][W], x, y, N) ? 1 : 0);
    }

    public static boolean DFS(boolean[][] visited, int i, int j, int N) {
        if (i < 0 || i >= map.length || j < 0 || j >= map[0].length) return false;
        if (visited[i][j]) return false;
        if (map[i][j] == '#') return false;
        if (map[i][j] == '*' && --N < 0) return false;
        if (map[i][j] == '%') return true;
        visited[i][j] = true;
        return DFS(visited.clone(), i+1, j, N) ||
               DFS(visited.clone(), i-1, j, N) ||
               DFS(visited.clone(), i, j+1, N) ||
               DFS(visited.clone(), i, j-1, N);
    }

    public static void main(String[] args) {
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            solution();
        }
    }
}
