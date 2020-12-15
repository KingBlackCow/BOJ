package practice;

import java.io.*;
import java.util.*;

public class DFS_BFS_ADJ {
    static int V;
    static int E;
    static boolean[] visit;
    static ArrayList<ArrayList<Integer>> ad;

    public static void dfs(int i){
        visit[i] = true;
        System.out.print(i+" ");
        Collections.sort(ad.get(i));
        for(int j : ad.get(i)){  // 배열 null check
            if(visit[j] == false){
                dfs(j);
            }
        }
    }

    public static void bfs(int i){
        Queue <Integer>q = new <Integer> LinkedList();
        HashMap<Integer, Boolean> hash = new HashMap<Integer, Boolean>();
        q.offer(i);
        while(!q.isEmpty()){
            int temp = q.poll();
            visit[temp] = true;
            System.out.print(temp+" ");

            for(int j : ad.get(temp)){
                if(visit[j] == false && !hash.containsKey(j)){
                    q.offer(j);
                    hash.put(j, true);
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
        int start=scan.nextInt();
        ad = new ArrayList(V +1); // 인접 리스트 초기화
        visit = new boolean[V +1]; // visit 배열 초기화

        for(int i = 0; i < V +1; i++){ // 인접 리스트 속의 리스트 초기화
            ad.add(new ArrayList());
        }

        for(int i = 0; i < E; i++){
            int t1 = scan.nextInt();
            int t2 = scan.nextInt();
            ad.get(t1).add(t2);
            ad.get(t2).add(t1);
        }
        dfs(start);
        System.out.println();
        visit = new boolean[V +1];
        bfs(start);
    }
}


