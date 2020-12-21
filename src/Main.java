import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int check(String[][] ary) {
        int min = 0;
        String tmp = String.valueOf(ary[0][0]);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (j != 0) {
                    if (tmp.equals(ary[i][j])) {
                        min++;
                        j++;
                        if (j > 7) j--;
                    }
                }else{
                    if(!tmp.equals(ary[i][j])){
                        min++;
                    }
                }
                tmp = String.valueOf(ary[i][j]);
            }
        }

        String cop = String.valueOf(ary[0][0]);
        int min2=1;
        if(cop.charAt(0)=='W'){
            tmp=String.valueOf('B');
        }else{
            tmp=String.valueOf('W');
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (j != 0) {
                    if (tmp.equals(ary[i][j])) {
                        min2++;
                        j++;
                        if (j > 7) j--;
                    }
                }else{
                    if(!tmp.equals(ary[i][j])){
                        min2++;
                    }
                }
                tmp = String.valueOf(ary[i][j]);
            }
        }
        if(min>min2)min=min2;
        return min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[][] ary = new String[n][m];
        for (int i = 0; i < n; i++) {
            ary[i] = br.readLine().split("");
        }
        int res = Integer.MAX_VALUE;

        for (int k = 0; k < n - 7; k++) {
            for (int l = 0; l < m - 7; l++) {
                String[][] ary2 = new String[8][8];
                int min = 0;
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        ary2[i][j] = String.valueOf(ary[k + i][l + j]);
                    }
                }
                min = check(ary2);
                if (res > min) res = min;
            }
        }
        System.out.println(res);
    }
}