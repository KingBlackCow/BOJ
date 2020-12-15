package CodingTestPractice;

import java.io.*;
import java.util.*;


public class Main2 {
    int[] ary = new int[13];

    static ArrayList<Integer> list = new ArrayList<Integer>();
    static int sum = 0;

    public static void dp(int i, HashSet<Integer> set) {
        if (set.contains(i)) {
            return;
        } else {
            if (i > sum){ return;}
            else if (i < 1) {return;}
            set.add(i);
            System.out.println(i);
            for (Integer j : list) {
                //System.out.println(i + j);
                dp(i + j, set);
                dp(i - j, set);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String sen = br.readLine();
        StringTokenizer st = new StringTokenizer(sen, " ");
        HashSet<Integer> set = new HashSet<Integer>();

        while (st.hasMoreTokens()) {
            int tmp = Integer.parseInt(st.nextToken());
            list.add(tmp);
            sum += tmp;
        }
        for (int i = 0; i < list.size(); i++) {
            dp(list.get(i), set);
        }

        System.out.println(set.size());
    }
}

