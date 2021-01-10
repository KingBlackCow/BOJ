package DFS_BFS;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BinaryGraph {
    static boolean res;
    static boolean[] visited;
    static List<Integer>[] list;
    static String[] color;
    static int v;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        for (int i = 0; i < test; i++) {
            res = false;
            StringTokenizer st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            visited = new boolean[v + 1];
            list = new LinkedList[v + 1];
            color = new String[v + 1];
            for (int j = 1; j < v + 1; j++) {
                list[j] = new LinkedList<>();
            }
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            list[first].add(second);
            list[second].add(first);
            for (int j = 1; j < e; j++) {
                st = new StringTokenizer(br.readLine());
                int one = Integer.parseInt(st.nextToken());
                int two = Integer.parseInt(st.nextToken());
                list[one].add(two);
                list[two].add(one);
            }
            for (int j = 1; j < v+1; j++) {
                dfs(list[j].get(0), 0);
                visited=new boolean[v+1];
                color=new String[v+1];
            }

            //bfs(list[second].get(0));
            if (res) System.out.println("NO");
            else System.out.println("YES");
//            boolean flag = true;
//            int[] visit = new int[v+1];
//            Queue<Integer> q = new LinkedList<>();
//
//            for (int t = 1; t < v+1; t++) {
//                if (visit[t] == 0) {
//                    q.offer(t);
//                    visit[t] = 1;
//
//                    while (!q.isEmpty() && flag) {
//                        int cur = q.poll();
//                        for (Integer next : list[cur]) {
//                            if (visit[next] == 0) {
//                                q.offer(next);
//                                visit[next] = visit[cur] * -1;
//                            } else if (visit[next] == visit[cur]) {
//                                flag = false;
//                                break;
//                            }
//                        }
//                    }
//
//                }
//            }
//            if (flag)
//                System.out.println("YES");
//            else
//                System.out.println("NO");
        }
    }

    private static void dfs(int x, int turn) {
        visited[x] = true;
        if (turn == 0) color[x] = "red";
        for (Integer i : list[x]) {
            if (!visited[i]) {
                if (turn % 2 == 0) {
                    color[i] = "black";
                } else {
                    color[i] = "red";
                }
                dfs(i, turn + 1);
            } else if (color[i] == color[x]) res = true;
        }
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        color[start] = "red";
        int turn = 0;
        while (!q.isEmpty()) {
            int tmp = q.poll();
            for (Integer i : list[tmp]) {
                if (!visited[i]) {
                    visited[i] = true;
                    if (turn % 2 == 0) color[i] = "black";
                    else color[i] = "red";
                    q.add(i);
                } else if (color[i] == color[tmp]) {
                    res = true;
                }

            }
            turn++;
        }
    }
}


