import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static boolean[] visit;
    static int[] dx = {-1, 1, 2};
    static int m;
    static int min = Integer.MAX_VALUE;

    static class Node{
        int f;
        int s;

        Node(int f, int s) {
            this.f = f;
            this.s = s;
        }
    }

    static void bfs(int v) {
        visit[v] = true;

        Queue<Node> q = new LinkedList<>();
        int res = 0;
        q.add(new Node(v,res));

        while (!q.isEmpty()) {
            Node tmp = q.poll();
            if (tmp.f == m) {
                System.out.println(tmp.s);
                return;
            }

            for (int i = 0; i < 3; i++) {
                if (i < 2) {
                    if (tmp.f + dx[i] <= 100000 && tmp.f + dx[i] >= 0) {
                        if (!visit[tmp.f + dx[i]]) {
                            visit[tmp.f + dx[i]] = true;
                            q.add(new Node(tmp.f + dx[i],tmp.s+1));
                        }
                    }
                } else {
                    if (tmp.f * dx[i] <= 100000 && tmp.f * dx[i] >= 0) {
                        if (!visit[tmp.f * dx[i]]) {
                            visit[tmp.f * dx[i]] = true;
                            q.add(new Node(tmp.f * dx[i],tmp.s+1));
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visit = new boolean[100001];
        bfs(n);
    }
}