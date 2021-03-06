package DFS_BFS;

import java.io.*;
import java.util.*;

public class DFS_BFS_ARR {
    static int V;
    static int E;
    static boolean[] visit;
    static int[][] mat;


    public static void dfs(int k) {
        visit[k] = true;
        System.out.print(k + " ");
        for (int i = 1; i < V + 1; i++) {
            if (mat[k][i] == 1 && !visit[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int i) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(i);
        while (!q.isEmpty()) {
            int tmp = q.poll();
            visit[tmp]=true;
            System.out.print(tmp + " ");
            for (int j = 1; j < V + 1; j++) {
                if (visit[j] == false && mat[tmp][j] == 1) {
                    visit[j] = true;
                    q.offer(j);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner scan = new Scanner(System.in);
        V = scan.nextInt();
        E = scan.nextInt();
        int start = scan.nextInt();
        mat = new int[V + 1][V + 1];
        visit = new boolean[V + 1];
        for (int j = 0; j < V + 1; j++) {
            Arrays.fill(mat[j], 0);
        }
        Arrays.fill(visit, false);
        for (int i = 0; i < E; i++) {
            int t1 = scan.nextInt();
            int t2 = scan.nextInt();
            mat[t1][t2] = 1;
            mat[t2][t1] = 1;
        }
        dfs(start);
        System.out.println();
        visit = new boolean[V + 1];
        bfs(start);
    }
}


