package 리스트내원소갯추세기;

import java.io.*;
import java.util.*;

class Main {
    static int sum;
    static boolean[] visit;
    public static ArrayList<Integer> list;

    static void dfs(int x, int cnt, int count_past) {
        if (Math.abs(x) <= sum) {
            Iterator it = list.iterator();
            int count = 0;
            while (it.hasNext()) {
                int iter = (int) it.next();
                count++;
                if (cnt < iter || (cnt == iter && count > count_past)) {
                    visit[Math.abs(x + iter)] = true;
                    visit[Math.abs(x - iter)] = true;
                    dfs(x + iter, iter, count);
                    dfs(x - iter, iter, count);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer.parseInt(br.readLine());
        int tmp;
        sum = 0;
        visit = new boolean[10000001];
        list = new ArrayList<Integer>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        while (st.hasMoreTokens()) {
            tmp = Integer.parseInt(st.nextToken());
            sum += tmp;
            list.add(tmp);
            visit[tmp] = true;
        }

        int count_past = 1;
        for (Integer i : list) {
            dfs(i, i, count_past++);
        }

        int res = 0;
        for (int j = 1; j <= sum; j++) {
            if (visit[j] == false) {
                res++;
            }
        }
        System.out.println(res);
    }
}