package UnionFind;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static HashMap<String, String> parent;
    static HashMap<String, Integer> number;

    public static String find(String x) {
        if (parent.get(x).equals(x)) return x;
        else {
            String p = find(parent.get(x));
            parent.put(x, p);
            return parent.get(x);
        }
    }

    public static void union(String x, String y) {
        x = find(x);
        y = find(y);

        if (!x.equals(y)) {
            parent.put(y, x);
            number.put(x, number.get(x) + number.get(y));
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < t; i++) {
            parent = new HashMap<>();
            number = new HashMap<>();
            int f = Integer.parseInt(br.readLine());
            for (int j = 0; j < f; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String x = st.nextToken();
                String y = st.nextToken();

                if (!parent.containsKey(x)) {
                    parent.put(x, x);
                    number.put(x, 1);
                }
                if (!parent.containsKey(y)) {
                    parent.put(y, y);
                    number.put(y, 1);
                }
                union(x, y);
                System.out.println(number.get(find(x)));
            }
        }
    }
}
