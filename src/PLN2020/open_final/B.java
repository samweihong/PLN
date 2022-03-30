package PLN2020.open_final;

import java.util.*;

public class B {
    static Scanner sc = new Scanner(System.in);
    static Node root = new Node(0, 0);
    static Node LCA = null;
    static Map<Integer, Node> map = new HashMap<>();
    static Map<Node, Integer> totalMemory = new HashMap<>();

    public static void solution() {
        int r = sc.nextInt();
        int s = sc.nextInt();
        findLCA(root, r, s);
        System.out.println(getTotalMemory(LCA));
    }

    public static boolean findLCA(Node root, int r, int s) {
        int sum = 0;

        for (Node child : root.children)
            sum += (findLCA(child, r, s) ? 1 : 0);
        if (root.pid == r || root.pid == s)
            sum++;

        if (sum >= 2)
            LCA = root;

        return sum > 0;
    }

    public static int getTotalMemory(Node node) {
        if (totalMemory.containsKey(node))
            return totalMemory.get(node);

        int sum = node.memory;
        for (Node child : node.children)
            sum += getTotalMemory(child);
        totalMemory.put(node, sum);
        return sum;
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        int q = sc.nextInt();
        map.put(0, root);
        for (int i = 0; i < n; i++) {
            int pid = sc.nextInt();
            int ppid = sc.nextInt();
            int memory = sc.nextInt();
            Node node = new Node(pid, memory);
            map.put(pid, node);
            map.get(ppid).children.add(node);
        }

        for (int i = 0; i < q; i++) {
            solution();
        }
    }
}

class Node {
    int pid;
    int memory;
    ArrayList<Node> children;

    public Node(int pid, int memory) {
        this.pid = pid;
        this.memory = memory;
        this.children = new ArrayList<>();
    }
}