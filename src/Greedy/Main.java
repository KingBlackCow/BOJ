package Greedy;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] str = br.readLine().split(" ");
        List<Integer> listPlus = new ArrayList<>();
        List<Integer> listMinus = new ArrayList<>();
        listMinus.add(0);
        listPlus.add(0);
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(str[i]);
            if (tmp > 0) {
                listPlus.add(tmp);
            } else {
                listMinus.add(Math.abs(tmp));
            }
        }
        Collections.sort(listMinus, Collections.reverseOrder());
        Collections.sort(listPlus, Collections.reverseOrder());
        boolean minus = false;
        int sum = 0;

        if (listMinus.get(0) > listPlus.get(0)) {
            minus = true;
        } else {
            minus = false;
        }

        for (int i = 0; i < listPlus.size(); i++) {
            if (i % m == 0) {
                sum += 2 * listPlus.get(i);
                if (!minus && i == 0) sum -= listPlus.get(i);
            }
        }

        for (int i = 0; i < listMinus.size(); i++) {
            if (i % m == 0) {
                sum += 2 * listMinus.get(i);
                if (minus && i == 0) sum -= listMinus.get(i);
            }
        }
        System.out.println(sum);
    }
}