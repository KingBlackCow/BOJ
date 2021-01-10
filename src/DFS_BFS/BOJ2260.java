package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2260 {
    static int n, k, m;
    static boolean[][][] visit;
    static int res;
    static int[][] ary;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int min;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ary = new int[n][m];
        visit = new boolean[2][n][m];
        res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                ary[i][j] = str.charAt(j) - '0';
            }
        }

        bfs();
        if (res != Integer.MAX_VALUE) System.out.println(res);
        else {
            System.out.println("-1");
        }
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(0, 0, 1, 0));
        visit[0][0][0] = true;

        while (!q.isEmpty()) {
            Node tmp = q.poll();
            if (tmp.i == n - 1 && tmp.j == m - 1) {
                res = Math.min(res, tmp.cnt);
            }
            for (int k = 0; k < 4; k++) {
                int r = tmp.i + dx[k];
                int c = tmp.j + dy[k];

                if (r >= 0 && c >= 0 && r < n && c < m) {
                    if(tmp.first==1){
                        if (ary[r][c] == 0 && !visit[tmp.first][r][c]) {
                            visit[tmp.first][r][c] = true;
                            q.add(new Node(r, c, tmp.cnt + 1, tmp.first));
                        }
                    } else{
                        if (ary[r][c] == 0 && !visit[tmp.first][r][c]) {
                            visit[tmp.first][r][c] = true;
                            q.add(new Node(r, c, tmp.cnt + 1, tmp.first));
                        }
                        if (tmp.first==0 && ary[r][c] == 1 && !visit[tmp.first][r][c]) {
                            visit[tmp.first][r][c] = true;
                            q.add(new Node(r, c, tmp.cnt + 1, 1));
                        }
                    }
                }
            }
        }
    }

    private static class Node {
        int i;
        int j;
        int cnt;
        int first;

        Node(int i, int j, int cnt, int first) {
            this.i = i;
            this.j = j;
            this.cnt = cnt;
            this.first = first;
        }
    }
}