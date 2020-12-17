package NandM_NQueen;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class nQueen {

    public static int[] ary;
    public static int n;
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ary = new int[n];
        nQueen(0);
        System.out.println(count);
    }

    public static void nQueen(int depth) {
        if (depth == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            ary[depth] = i;
            if (possibility(depth)) {
                nQueen(depth + 1);
            }
        }
    }

    public static boolean possibility(int col) {
        for (int i = 0; i < col; i++) {
            if (ary[col] == ary[i]) {
                return false;
            } else if (Math.abs(col - i) == Math.abs(ary[col] - ary[i])) {
                return false;
            }
        }
        return true;
    }
}